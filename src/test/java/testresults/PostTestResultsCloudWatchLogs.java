package testresults;

import data.GenericData;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.junit.Ignore;
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

    @WithTag("In_Test")
    @Test
    @Title("TESTING THE CLOUDWATCH LOGGING")
    public void testResults_CloudWatch_Logs_HGV() {

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

//        testResultsSteps.checkLogWasCreated("/aws/lambda/edh-dispatcher-cvsb-10773");
        testResultsSteps.checkLogWasCreated("/aws/lambda/edh-marshaller-cvsb-10773", currentTimestamp);
//        testResultsSteps.checkLogWasCreated("test-results-cvsb-10773");

//        // Retrieve the created record, and verify that the fields are present.
//        testResultsSteps.getTestResults(randomSystemNumber);
//        testResultsSteps.statusCodeShouldBe(200);
//
//        // Verify TestNumber/CertificateNumber field have the same value
//        testResultsSteps.valueForFieldInPathShouldBe("[0].testTypes[0].certificateNumber", testResultsSteps.getTestNumber());
    }

//    @Title("CVSB-7675 - TC2 - AC1 - ROADWORTHINESS certificate number generated (TRL) - PASS")
//    @Test
//    public void testResults_Roadworthiness_TRL_Pass_Certificate_Number() {
//
//        // Read the base test result JSON.
//        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_7675.json", "$");
//
//        // Create alteration to add one more tech record to in the request body
//        String randomSystemNumber = GenericData.generateRandomSystemNumber();
//        String randomVin = GenericData.generateRandomVin();
//        String randomTestResultId = UUID.randomUUID().toString();
//        JsonPathAlteration alterationSystemNumber = new JsonPathAlteration("$.systemNumber", randomSystemNumber, "", "REPLACE");
//        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
//        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");
//
//        // Collate the list of alterations.
//        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
//                alterationVin,
//                alterationSystemNumber,
//                alterationTestResultId));
//
//        // Post the results, together with any alterations, and verify that they are accepted.
//        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
//        testResultsSteps.statusCodeShouldBe(201);
//        testResultsSteps.validateData("Test records created");
//
//        // Retrieve the created record, and verify that the fields are present.
//        testResultsSteps.getTestResults(randomSystemNumber);
//        testResultsSteps.statusCodeShouldBe(200);
//
//        // Verify TestNumber/CertificateNumber are  test field values match the expected values.
//        testResultsSteps.valueForFieldInPathShouldBe("[0].testTypes[0].certificateNumber", testResultsSteps.getTestNumber());
//    }

}
