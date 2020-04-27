package util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.auth.*;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cloudwatch.AmazonCloudWatchClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.QuerySpec;
import com.amazonaws.services.dynamodbv2.document.spec.UpdateItemSpec;
import com.amazonaws.services.dynamodbv2.document.utils.ValueMap;
import com.amazonaws.services.logs.AWSLogs;
import com.amazonaws.services.logs.AWSLogsClient;
import com.amazonaws.services.logs.AWSLogsClientBuilder;
import com.amazonaws.services.logs.model.*;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.securitytoken.AWSSecurityTokenService;
import com.amazonaws.services.securitytoken.AWSSecurityTokenServiceClientBuilder;
import com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.jayway.jsonpath.JsonPath;
import data.GenericData;
import exceptions.AutomationException;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.*;

public class AwsUtil {

    private static Loader loader;

    static {
        EnvironmentType envType = TypeLoader.getType();
        switch (envType) {
            case CI_DEVELOP:
                loader = new CIDevelopLoaderImpl();
                break;
            case LOCAL:
                loader = new LocalLoaderImpl();
                break;
            default:
                throw new AutomationException("Environment configuration not found");
        }
    }

    public static boolean isCertificateCreated(String uuid, String vin){

        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();

        System.out.println(System.getProperty("AWS_ROLE"));

        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        String bucketName = loader.getS3Bucket();

        String fileName = uuid + "_" + vin + "_1.pdf";
        String key =  loader.getBranchName()+ "/" + fileName;

        AmazonS3 s3Client = new AmazonS3Client(temporaryCredentials);

        System.out.println("Waiting on file " + key + " to be created... on bucket: " + bucketName);

        for(int i = 0; i < 45 ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(s3Client.doesObjectExist(bucketName, key)){
                return s3Client.doesObjectExist(bucketName, key);
            }
            System.out.println("waited for: " + i + " seconds...");
        }
        System.out.println("file " + key + " was not created in 45 or less seconds..");
        return false;
    }

    /**
     * @deprecated  replaced by #insertJsonInTable(java.lang.String, java.lang.String, java.lang.String)()
     */
    @Deprecated
    public static void insertJsonInTable(String json, String tableName) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("cvs-" + System.getProperty("BRANCH") + "-" + tableName);
        String vin = GenericData.getValueFromJsonPath(json, "$.vin");

        try {
            Item item = Item.fromJSON(json);
            System.out.println("Adding a new item...");
            PutItemOutcome outcome = table
                    .putItem(item);
            System.out.println("PutItem succeeded:\n" + item.toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Unable to add item with vin: " + vin);
            System.err.println(e);
        }
    }

    public static void insertJsonInTable(String json, String tableName, String primaryKey) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("cvs-" + System.getProperty("BRANCH") + "-" + tableName);
        String valueForPrimaryKey = GenericData.getValueFromJsonPath(json, "$." + primaryKey);



        try {
            Item item = Item.fromJSON(json);
            System.out.println("Adding a new item...");
            PutItemOutcome outcome = table
                    .putItem(item);
            System.out.println("PutItem succeeded:\n" + item.toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Unable to add item with " + primaryKey + ": " + valueForPrimaryKey);
            e.printStackTrace();
        }
    }

    public static void deleteActivitiesForUser(String testerName) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "cvs-" + System.getProperty("BRANCH") + "-activities";

        Table table = dynamoDB.getTable(tableName);

        Index index = table.getIndex("StaffIndex");
        QuerySpec spec = new QuerySpec()
                .withKeyConditionExpression("testerStaffId = :staff_id")
                .withValueMap(new ValueMap()
                        .withString(":staff_id",testerName));

        ItemCollection<QueryOutcome> items = index.query(spec);
        for (Item item : items) {
            String id = JsonPath.read(item.toJSON(), "$.id");
            System.out.println("Delete item:\n" + item.toJSONPretty());

            DeleteItemOutcome outcome = table.deleteItem("id", id);
        }
    }

    public static String getNextSystemNumberInSequence() {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "cvs-" + System.getProperty("BRANCH") + "-test-number";
        Table table = dynamoDB.getTable(tableName);
        ItemCollection<ScanOutcome> items = table.scan("attribute_exists(systemNumber)", // FilterExpression
                "systemNumber", // ProjectionExpression
                null, // ExpressionAttributeNames - not used in this example
                null // ExpressionAttributeValues - not used in this example
                );

        System.out.println("Scan of " + tableName + " for items with systemNumber not null");
        Iterator<Item> iterator = items.iterator();
        String lastSystemNumberUsed = null;
        while (iterator.hasNext()) {
            lastSystemNumberUsed = GenericData.getValueFromJsonPath(iterator.next().toJSONPretty(), "$.systemNumber");
        }
        if (lastSystemNumberUsed != null) {
            int nextSystemNumberInSequence = Integer.parseInt(lastSystemNumberUsed) + 1;
            return Integer.toString(nextSystemNumberInSequence);
        }
        else {
            throw new AutomationException("No value found for last used systemNumber");
        }
    }

    public static String getNextTrailerIdInSequence() {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String tableName = "cvs-" + System.getProperty("BRANCH") + "-test-number";
        Table table = dynamoDB.getTable(tableName);
        ItemCollection<ScanOutcome> items = table.scan("attribute_exists(trailerId)", // FilterExpression
                "trailerId, sequenceNumber, trailerLetter", // ProjectionExpression
                null, // ExpressionAttributeNames - not used in this example
                null // ExpressionAttributeValues - not used in this example
        );

        System.out.println("Scan of " + tableName + " for items with trailerId not null");
        Iterator<Item> iterator = items.iterator();
        String dynamoInfo = null;
        while (iterator.hasNext()) {
            dynamoInfo = iterator.next().toJSONPretty();
        }
        int lastTrailerSequenceNumberUsed = GenericData.extractIntegerValueFromJsonString(dynamoInfo, "$.sequenceNumber");
        String trailerLetter = GenericData.getValueFromJsonPath(dynamoInfo, "$.trailerLetter");
        if (lastTrailerSequenceNumberUsed != 0 && trailerLetter != null) {
            int nextTrailerNumberInSequence = lastTrailerSequenceNumberUsed + 1;
            return trailerLetter + nextTrailerNumberInSequence;
        }
        else {
            throw new AutomationException("No value found for last used sequence number or trailer letter");
        }
    }

    public static void updateEmailsForTestStation(String primaryKeyValue, String... updateValue) {
        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();
        String uuid = String.valueOf(UUID.randomUUID());
        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(uuid);
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());
        AmazonDynamoDBClient client = new AmazonDynamoDBClient(temporaryCredentials);
        client.setRegion(Region.getRegion(clientRegion));
        DynamoDB dynamoDB = new DynamoDB(client);
        String actualTableName = "cvs-" + System.getProperty("BRANCH") + "-test-stations";
        Table table = dynamoDB.getTable(actualTableName);


        UpdateItemSpec updateItemSpec = new UpdateItemSpec().withPrimaryKey("testStationId", primaryKeyValue)
                .withUpdateExpression("set testStationEmails = :fieldToUpdate")
                .withValueMap(new ValueMap().withList(":fieldToUpdate", Arrays.asList(updateValue)))
                .withReturnValues(ReturnValue.UPDATED_NEW);

        try {
            System.out.println("Updating the item...");
            UpdateItemOutcome outcome = table.updateItem(updateItemSpec);
            System.out.println("UpdateItem succeeded:\n" + outcome.getItem().toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("Unable to update item: primaryKeyValue");
            System.err.println(e.getMessage());
        }
    }

    public static void checkLogs(String logGroup) {

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        System.out.println("Current time (timestamp): " + currentTimestamp);
        System.out.println("Current time (getMillis): " + currentTimestamp.minusMinutes(2).getMillis());


        Regions clientRegion = Regions.EU_WEST_1;
        AWSSecurityTokenService stsClient =
                AWSSecurityTokenServiceClientBuilder.standard().withRegion(clientRegion).build();

        System.out.println(System.getProperty("AWS_ROLE"));

        AssumeRoleRequest assumeRequest = new AssumeRoleRequest()
                .withRoleArn(System.getProperty("AWS_ROLE"))
                .withDurationSeconds(3600)
                .withRoleSessionName(UUID.randomUUID().toString());
        AssumeRoleResult assumeResult =
                stsClient.assumeRole(assumeRequest);

        BasicSessionCredentials temporaryCredentials =
                new BasicSessionCredentials(
                        assumeResult.getCredentials().getAccessKeyId(),
                        assumeResult.getCredentials().getSecretAccessKey(),
                        assumeResult.getCredentials().getSessionToken());

        System.out.println("prefix: " + currentTimestamp.toDateTime().toString("YYYY/MM/DD"));

        AWSLogs logsClient = new AWSLogsClient(temporaryCredentials).withRegion(clientRegion);
        DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest()
                .withLogGroupName( logGroup  )
                .withDescending(true)
                .withLimit(1);
        DescribeLogStreamsResult describeLogStreamsResult = logsClient.describeLogStreams( describeLogStreamsRequest );
        LogStream logStream = describeLogStreamsResult.getLogStreams().get(0);

            System.out.println("$$$$$$$$$$$"+ logStream.getLogStreamName() +"$$$$$$$$$$$");

            GetLogEventsRequest request = new GetLogEventsRequest()
                    .withLimit(50)
                    .withStartTime(currentTimestamp.minusMinutes(20).getMillis())
                    .withEndTime(currentTimestamp.getMillis())
                    .withLogGroupName( logGroup )
                    .withLogStreamName( logStream.getLogStreamName() );

            GetLogEventsResult result = logsClient.getLogEvents( request );

            result.getEvents().forEach( outputLogEvent -> {
                System.out.println("*****************************");
                System.out.println( outputLogEvent.getMessage() );
            } );

//        String nextToken = null;
//        do {
//            if (nextToken != null) {
//                result = result.withNextForwardToken(nextToken);
////                        withNextToken(nextToken);
//            }
//            GetLogEventsResult response = logsClient.getLogEvents(request);
//
//            for (OutputLogEvent outputLogEvent : response.getEvents()) {
//                System.out.println(outputLogEvent.getMessage());
//                nextToken = response.getNextForwardToken();
//            }
//    // check if token is the same
//			if (result.getNextForwardToken().equals(nextToken)) {
//        break;
//    }
//    // save new token
//    nextToken = response.getNextForwardToken();
//} while (true);
}

}