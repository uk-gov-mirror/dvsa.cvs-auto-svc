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

    @WithTag("In_Test")
    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING - AC1 - http status code: 400")
    public void testResults_CloudWatch_Logs_TRL_400() {

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

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.cleanUpTestResultsOfTestTypeId(randomTestResultId);
//        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
//        testResultsSteps.statusCodeShouldBe(201);
//        testResultsSteps.validateData("Test records created");
//
//
//        testResultsSteps.checkAwsMarshallerLogContains("systemNumber", randomSystemNumber);
//        testResultsSteps.checkAwsMarshallerLogContains("vin", randomVin);
//        testResultsSteps.checkAwsDispatcherLogContains("systemNumber", randomSystemNumber);
//        testResultsSteps.checkAwsDispatcherLogContains("vin", randomVin);
//        testResultsSteps.checkAwsDispatcherLogStatusCodeForSystemNumber(randomSystemNumber, 404);

    }

}
