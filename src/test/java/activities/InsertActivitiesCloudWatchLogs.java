package activities;

import data.ActivitiesData;
import data.GenericData;
import model.activities.Activities;
import model.activities.ActivitiesGet;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.apache.commons.lang3.time.DateUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.ActivitiesSteps;
import util.DataUtil;
import util.JsonPathAlteration;

import java.text.SimpleDateFormat;
import java.util.*;


@RunWith(SerenityRunner.class)
public class InsertActivitiesCloudWatchLogs {
    @Steps
    ActivitiesSteps activitiesSteps;
    ActivitiesGet.Builder activitiesData = ActivitiesData.buildActivitiesIdData();


    @WithTag("In_Test")
    @Title("CVSB- / CVSB- - AC7 ")
    @Test
    public void insertActivity() {
        // read post request body from file
        String postRequestBody = GenericData.readJsonValueFromFile("activities.json","$");
        // generate random ID
        String randomId = UUID.randomUUID().toString();
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

        activitiesSteps.insertActivityWithAlterations(postRequestBody, alterations);
        activitiesSteps.getActivities("visit", randomTesterStaffId, null, startTimeGet, endTimeGet);
        activitiesSteps.statusCodeShouldBe(200);
        activitiesSteps.deleteActivity(randomId);

    }

}
