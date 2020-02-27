package testresults;

import data.TestResultsData;
import model.testresults.TestResults;
import model.testresults.TestResultsGet;
import model.testresults.TestResultsStatus;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestResultsSteps;
import util.DataUtil;

import java.util.Random;

import static util.DataUtil.generateRandomExcludingValues;


@RunWith(SerenityRunner.class)
public class PostTestResultsPozTestTypesSubmittedLvl {

    @Steps
    TestResultsSteps testResultsSteps;

    private TestResults.Builder vehicleSubmittedData = TestResultsData.buildTestResultsSubmittedData();
    private TestResults.Builder vehicleSubmittedDataOld = TestResultsData.buildTestResultsSubmittedDataOld();

    private void validateSavedData() {

        testResultsSteps.getTestResults(vehicleSubmittedData.build().getVin(), TestResultsStatus.SUBMITTED);
        testResultsSteps.statusCodeShouldBe(200);
        testResultsSteps.validateData((TestResultsGet) vehicleSubmittedData.build());
    }

    private void validateSavedDataOld() {

        testResultsSteps.getTestResults(vehicleSubmittedDataOld.build().getSystemNumber(), TestResultsStatus.SUBMITTED);
        testResultsSteps.statusCodeShouldBe(200);
        testResultsSteps.validateData((TestResultsGet) vehicleSubmittedDataOld.build());
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testTypeName")
    @Test
    public void testResultsRandomTestTypeName() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeName(RandomStringUtils.randomAlphanumeric(50));

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - testTypeName")
    @Test
    public void testResultsEmptyTestTypeName() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeName("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setTestTypeName(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - name")
    @Test
    public void testResultsRandomName() {
        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setName(RandomStringUtils.randomAlphanumeric(50));

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Ignore ("random testTypeId should have returned an error - instead returns bad Gateway - defect CVSB-9011")
    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testTypeId")
    @Test
    public void testResultsRandomTestTypeId() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeId(RandomStringUtils.randomAlphanumeric(50));

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - testTypeId")
    @Test
    public void testResultsEmptyTestTypeId() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeId("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setTestTypeId(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - certificateNumber")
    @Test
    public void testResultsRandomCertificateNumber() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setCertificateNumber(RandomStringUtils.randomAlphanumeric(50));

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - certificateNumber")
    @Test
    public void testResultsEmptyCertificateNumber() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setCertificateNumber("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setCertificateNumber(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - certificateNumber")
    @Test
    public void testResultsNullCertificateNumber() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setCertificateNumber(null);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testTypeStartTimestamp")
    @Test
    public void testResultsValidTestTypeStartTimestamp() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeStartTimestamp(DataUtil.buildCurrentDateTime());

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testTypeEndTimestamp")
    @Test
    public void testResultsRandomTestTypeEndTimestamp() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestTypeEndTimestamp(DataUtil.buildCurrentDateTime());

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - numberOfSeatbeltsFitted")
    @Test
    public void testResultsRandomNumberOfSeatbeltsFitted() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setNumberOfSeatbeltsFitted(new Random().nextInt(999) + 10);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - numberOfSeatbeltsFitted")
    @Test
    public void testResultsMiNumberOfSeatbeltsFitted() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setNumberOfSeatbeltsFitted(0);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }



    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - numberOfSeatbeltsFitted")
    @Test
    public void testResultsNullNumberOfSeatbeltsFitted() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setNumberOfSeatbeltsFitted(null);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - lastSeatbeltInstallationCheckDate")
    @Test
    public void testResultsValidLastSeatbeltInstallationCheckDate() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setLastSeatbeltInstallationCheckDate(DataUtil.buildCurrentDateTime());

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - lastSeatbeltInstallationCheckDate")
    @Test
    public void testResultsNullLastSeatbeltInstallationCheckDate() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setLastSeatbeltInstallationCheckDate(null);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - seatbeltInstallationCheckDate true")
    @Test
    public void testResultsTrueSeatbeltInstallationCheckDate() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setSeatbeltInstallationCheckDate(true);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - seatbeltInstallationCheckDate false")
    @Test
    public void testResultsFalseSeatbeltInstallationCheckDate() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setSeatbeltInstallationCheckDate(false);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - seatbeltInstallationCheckDate")
    @Test
    public void testResultsNullSeatbeltInstallationCheckDate() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setSeatbeltInstallationCheckDate(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testResult fail")
    @Test
    public void testResultsTestResultValueOne() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("fail");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testResult pass")
    @Test
    public void testResultsTestResultValueTwo() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("pass");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testResult prs")
    @Test
    public void testResultsTestResultValueThree() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("prs");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - testResult abandoned")
    @Test
    public void testResultsTestResultValueFour() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("abandoned");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - prohibitionIssued")
    @Test
    public void testResultsNullProhibitionIssued() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setProhibitionIssued(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();

    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - prohibitionIssued false")
    @Test
    public void testResultsProhibitionIssuedFalse() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setProhibitionIssued(false);

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - prohibitionIssued true")
    @Test
    public void testResultsProhibitionIssuedTrue() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setProhibitionIssued(true);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - reasonForAbandoning with testResult abandoned")
    @Test
    public void testResultsReasonForAbandoningAbandonedEmpty() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("abandoned").setReasonForAbandoning("");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        vehicleSubmittedData.build().getTestTypes().get(0).setReasonForAbandoning(null);
        testResultsSteps.statusCodeShouldBe(400);
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - reasonForAbandoning with testResult fail")
    @Test
    public void testResultsReasonForAbandoningFailEmpty() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("fail").setReasonForAbandoning("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setReasonForAbandoning(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - reasonForAbandoning with testResult pass")
    @Test
    public void testResultsReasonForAbandoningPassEmpty() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("pass").setReasonForAbandoning("");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        vehicleSubmittedData.build().getTestTypes().get(0).setReasonForAbandoning(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - reasonForAbandoning with testResult prs")
    @Test
    public void testResultsReasonForAbandoningPrsEmpty() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("prs").setReasonForAbandoning("");

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        vehicleSubmittedData.build().getTestTypes().get(0).setReasonForAbandoning(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - reasonForAbandoning with testResult fail")
    @Test
    public void testResultsReasonForAbandoningFail() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("fail").setReasonForAbandoning(RandomStringUtils.randomAlphanumeric(1, 499));

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - reasonForAbandoning with testResult pass")
    @Test
    public void testResultsReasonForAbandoningPass() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("pass").setReasonForAbandoning(RandomStringUtils.randomAlphanumeric(1, 499));

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - reasonForAbandoning with testResult prs")
    @Test
    public void testResultsReasonForAbandoningPrs() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build().getTestTypes().get(0)
                .setTestResult("prs").setReasonForAbandoning(RandomStringUtils.randomAlphanumeric(1, 499));

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - reasonForAbandoning with testResult fail")
    @Test
    public void testResultsNullReasonForAbandoningFail() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("fail").setReasonForAbandoning(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();

    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - reasonForAbandoning with testResult pass")
    @Test
    public void testResultsNullReasonForAbandoningPass() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setTestResult("pass").setReasonForAbandoning(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();

    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - reasonForAbandoning with testResult prs")
    @Test
    public void testResultsNullReasonForAbandoningPrs() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build().getTestTypes()
                .get(0).setTestResult("prs").setReasonForAbandoning(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - additionalNotesRecorded")
    @Test
    public void testResultsRandomAdditionalNotesRecorded() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalNotesRecorded(RandomStringUtils.randomAlphanumeric(1, 499));

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - additionalNotesRecorded")
    @Test
    public void testResultsNullAdditionalNotesRecorded() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalNotesRecorded(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - additionalNotesRecorded")
    @Test
    public void testResultsEmptyAdditionalNotesRecorded() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalNotesRecorded("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setAdditionalNotesRecorded(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - additionalCommentsForAbandon")
    @Test
    public void testResultsRandomAdditionalCommentsForAbandon() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalCommentsForAbandon(RandomStringUtils.randomAlphanumeric(1, 499));

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3504 - TCD - API Consumer creates a new test result for submitted/canceled that allows null values - additionalCommentsForAbandon")
    @Test
    public void testResultsNullAdditionalCommentsForAbandon() {

        vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalCommentsForAbandon(null);

        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedData();
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3486 - API Consumer creates a new test results for submitted/canceled with no min restriction - additionalCommentsForAbandon")
    @Test
    public void testResultsEmptyAdditionalCommentsForAbandon() {

        vehicleSubmittedDataOld.setVin(generateRandomExcludingValues(21, vehicleSubmittedDataOld.build().getVin()))
                .setSystemNumber(generateRandomExcludingValues(16, vehicleSubmittedDataOld.build().getSystemNumber()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedDataOld.build().getVrm())).build()
                .getTestTypes().get(0).setAdditionalCommentsForAbandon("");

        testResultsSteps.postTestResults(vehicleSubmittedDataOld.build());
        vehicleSubmittedDataOld.build().getTestTypes().get(0).setAdditionalCommentsForAbandon(null);
        testResultsSteps.statusCodeShouldBe(201);
        testResultsSteps.validateData("Test records created");
        validateSavedDataOld();
    }

}
