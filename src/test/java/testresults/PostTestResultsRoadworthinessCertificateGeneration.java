package testresults;

import data.GenericData;
import data.TestResultsData;
import model.testresults.TestResults;
import model.testresults.TestResultsGet;
import model.testresults.TestResultsStatus;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
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
public class PostTestResultsRoadworthinessCertificateGeneration {

    @Steps
    TestResultsSteps testResultsSteps;

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT1) - PASS ")
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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT2) - PASS ")
    public void testResults_Roadworthiness_TRL_QJT2_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qjt2_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT4) - PASS ")
    public void testResults_Roadworthiness_TRL_QJT4_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qjt4_7677.json","$");

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
        //testResultsSteps.validateCertificateIsGenerated(randomTestResultId,randomVin);

    }

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV2) - PASS ")
    public void testResults_Roadworthiness_HGV_QJV2_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qjv2_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV3) - PASS ")
    public void testResults_Roadworthiness_HGV_QJV3_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qjv3_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV4) - PASS ")
    public void testResults_Roadworthiness_HGV_QJV4_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qjv4_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV5) - PASS ")
    public void testResults_Roadworthiness_HGV_QJV5_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qjv5_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QKV) - PASS ")
    public void testResults_Roadworthiness_HGV_QKV_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qkv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QKT) - PASS ")
    public void testResults_Roadworthiness_TRL_QKT_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qkt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QPV) - PASS ")
    public void testResults_Roadworthiness_HGV_QPV_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qpv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QPT) - PASS ")
    public void testResults_Roadworthiness_TRL_QPT_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qpt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QQV) - PASS ")
    public void testResults_Roadworthiness_HGV_QQV_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_pass_qqv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QQT) - PASS ")
    public void testResults_Roadworthiness_TRL_QQT_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_qqt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(RUT) - PASS ")
    public void testResults_Roadworthiness_TRL_RUT_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_rut_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC1 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(RUV) - PASS ")
    public void testResults_Roadworthiness_HGV_RUV_Pass_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_pass_rut_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT1) - FAIL ")
    public void testResults_Roadworthiness_TRL_QJT1_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qjt1_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT2) - FAIL ")
    public void testResults_Roadworthiness_TRL_QJT2_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qjt2_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QJT4) - FAIL ")
    public void testResults_Roadworthiness_TRL_QJT4_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qjt4_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV2) - FAIL ")
    public void testResults_Roadworthiness_HGV_QJV2_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qjv2_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV3) - FAIL ")
    public void testResults_Roadworthiness_HGV_QJV3_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qjv3_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV4) - FAIL ")
    public void testResults_Roadworthiness_HGV_QJV4_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qjv4_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QJV5) - FAIL ")
    public void testResults_Roadworthiness_HGV_QJV5_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qjv5_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QKV) - FAIL ")
    public void testResults_Roadworthiness_HGV_QKV_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qkv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QKT) - FAIL ")
    public void testResults_Roadworthiness_TRL_QKT_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qkt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QPV) - FAIL ")
    public void testResults_Roadworthiness_HGV_QPV_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qpv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QPT) - FAIL ")
    public void testResults_Roadworthiness_TRL_QPT_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qpt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(QQV) - FAIL ")
    public void testResults_Roadworthiness_HGV_QQV_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_qqv_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(QQT) - FAIL ")
    public void testResults_Roadworthiness_TRL_QQT_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_qqt_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (TRL)(RUT) - FAIL ")
    public void testResults_Roadworthiness_TRL_RUT_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_trl_fail_rut_7677.json","$");

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

    @Ignore("Ignored until Certificate generation is no longer suppressed")
    @Title("CVSB-7677 - TC - AC2 - CERTIFICATE GENERATED ON CORRECT TEST CODES (HGV)(RUV) - FAIL ")
    public void testResults_Roadworthiness_HGV_RUV_Fail_Certificate_Generation() {

        // Read the base test result JSON.
        String testResultRecord = GenericData.readJsonValueFromFile("test-results_roadworthiness_hgv_fail_ruv_7677.json","$");

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