package activities;

import data.ActivitiesData;
import data.GenericData;
import model.activities.ActivitiesGet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ActivitiesSteps;
import util.JsonPathAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


@RunWith(SerenityRunner.class)
public class InsertActivitiesPutCloudWatchLogs {
    @Steps
    ActivitiesSteps activitiesSteps;


    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 202")
    @Test
    public void insertPutActivityVisitHttpCode202() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = UUID.randomUUID().toString();
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        String startTime = startTimestamp.toInstant().toString();
        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationTesterStaffId));


        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet , null);
        activitiesSteps.statusCodeShouldBe(200);

        activitiesSteps.putActivitiesEnd(randomId);
        activitiesSteps.statusCodeShouldBe(204);

        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber("PUT", randomId, 202);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 400")
    @Test
    public void insertPutActivityVisitHttpCode400() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404400-7e57-c0de-e400-e4404c0de400";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));

        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 400);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 401")
    @Test
    public void insertPutActivityVisitHttpCode401() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404401-7e57-c0de-e401-e4404c0de401";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));

        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 401);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 403")
    @Test
    public void insertPutActivityVisitHttpCode403() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404403-7e57-c0de-e403-e4404c0de403";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));


        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 403);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 404")
    @Test
    public void insertPutActivityVisitHttpCode404() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404404-7e57-c0de-e404-e4404c0de404";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));

        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 404);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 429")
    @Test
    public void insertPutActivityVisitHttpCode429() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404429-7e57-c0de-e429-e4404c0de429";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));

        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 429);
        activitiesSteps.deleteActivity(randomId);

    }

//    @WithTag("In_Test")
    @Title("CVSB-10767 CVS to EDH (Open Site Visits) PUT - AC1 - http status code 500")
    @Test
    public void insertPutActivityVisitHttpCode500() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities_10769.json","$");
        // generate random ID
        String randomId = "e4404500-7e57-c0de-e500-e4404c0de500";
        // generate random TesterStaffId
        String randomTesterStaffId = UUID.randomUUID().toString();

        DateTime currentTimestamp = DateTime.now().withZone(DateTimeZone.UTC);
        DateTime startTimestamp = currentTimestamp;
        DateTime endTimestamp = currentTimestamp.plusHours(1);
        String startTime = startTimestamp.toInstant().toString();
        String endTime = endTimestamp.toInstant().toString();

        String startTimeGet = startTimestamp.minusSeconds(1).toInstant().toString();
        String endTimeGet = endTimestamp.plusSeconds(1).toInstant().toString();

        // generate endTime

        // create alterations
        JsonPathAlteration alterationId = new JsonPathAlteration("$.id", randomId,"","REPLACE");
        JsonPathAlteration alterationTesterStaffId = new JsonPathAlteration("$.testerStaffId",
                randomTesterStaffId,"","REPLACE");
        JsonPathAlteration alterationStartTime = new JsonPathAlteration("$.startTime",startTime ,"","REPLACE");
        JsonPathAlteration alterationEndTime = new JsonPathAlteration("$.endTime", endTime,"","REPLACE");

        // initialize the alterations list with both declared alteration
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationId,
                alterationStartTime,
                alterationEndTime,
                alterationTesterStaffId));

        activitiesSteps.deleteActivity(randomId);
        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.checkAwsMarshallerLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogContains("id", randomId);
        activitiesSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomId, 500);
        activitiesSteps.deleteActivity(randomId);

    }

}
