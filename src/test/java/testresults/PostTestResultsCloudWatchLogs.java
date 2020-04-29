package testresults;

import data.GenericData;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestResultsSteps;
import util.JsonPathAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RunWith(SerenityRunner.class)
public class PostTestResultsCloudWatchLogs {

    @Steps
    TestResultsSteps testResultsSteps;

    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC1 - http status code: 202")
    public void testResults_CloudWatch_Logs_TRL_202() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = UUID.randomUUID().toString();
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");


        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 403);
    }


    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC2 - http status code: 400")
    public void testResults_CloudWatch_Logs_TRL_400() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404400-7e57-c0de-e400-e4404c0de400";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 400);

    }


    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC2 - http status code: 401")
    public void testResults_CloudWatch_Logs_TRL_401() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404401-7e57-c0de-e401-e4404c0de401";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 401);

    }


    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC2 - http status code: 403")
    public void testResults_CloudWatch_Logs_TRL_403() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404403-7e57-c0de-e403-e4404c0de403";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 403);

    }


    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC2 - http status code: 404")
    public void testResults_CloudWatch_Logs_TRL_404() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404404-7e57-c0de-e404-e4404c0de404";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 404);

    }


    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC3 - http status code: 429")
    public void testResults_CloudWatch_Logs_TRL_429() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404429-7e57-c0de-e429-e4404c0de429";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 429);

    }

    @WithTag("In_Test")
    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC3 - http status code: 500")
    public void testResults_CloudWatch_Logs_TRL_500() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_7675.json", "$");

        // Create alteration to add one more tech record to in the request body
        String randomSystemNumber = GenericData.generateRandomSystemNumber();
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = "e4404500-7e57-c0de-e500-e4404c0de500";
        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationSystemNumber,
                alterationTestResultId));

        // Clean up the data table
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        // Check the logs for the http code
//        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
//        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
//        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
//        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 500);

    }

}
