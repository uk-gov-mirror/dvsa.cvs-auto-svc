package testresults;

import data.GenericData;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
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
public class PostTestResultsAnnualCertificateGeneration {

    @Steps
    TestResultsSteps testResultsSteps;

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-8798 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT1) - PASS ")
    @Test
    public void testResults_Roadworthiness_TRL_QJT1_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qjt1_7677.json","$");

        // Create alteration to add one more tech record to in the request body
        String randomVin = GenericData.generateRandomVin();
        String randomTestResultId = UUID.randomUUID().toString();
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        JsonPathAlteration alterationTestResultId = new JsonPathAlteration("$.testResultId", randomTestResultId, "", "REPLACE");

        // Collate the list of alterations.
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(
                alterationVin,
                alterationTestResultId));

        // Post the results, together with any alterations, and verify that they are accepted.
        testResultsSteps.postVehicleTestResultsWithAlterations(testResultRecord, alterations);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");

        //Verify that the certificate is generated in S3 bucket
        testResultsSteps.validateCertificateIsGenerated(randomTestResultId,randomVin);

    }
}
