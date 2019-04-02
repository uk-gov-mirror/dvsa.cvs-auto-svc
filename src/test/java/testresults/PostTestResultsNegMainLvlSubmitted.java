package testresults;

import clients.util.ToTypeConvertor;
import clients.util.testresult.TestResultsLevel;
import data.TestResultsData;
import model.testresults.TestResults;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.core.annotations.WithTags;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.TestResultsSteps;

import static util.DataUtil.generateRandomExcludingValues;


@WithTags(
        {
                @WithTag(type = "TestResults", name = "All"),
                @WithTag(type = "TestResults", name = "Negative"),
                @WithTag(type = "Service", name = "One"),

        }
)

@RunWith(SerenityRunner.class)
public class PostTestResultsNegMainLvlSubmitted {

    @Steps
    TestResultsSteps testResultsSteps;

    private TestResults.Builder vehicleSubmittedData = TestResultsData.buildTestResultsSubmittedData();
    private static final String VRM = "SL72XD";


    @Title("CVSB-416 - CVSB-949 / CVSB-3512 - Un-authorised consumer creates a new test results")
    @Test
    public void testResultsNoAuthorised() {
        testResultsSteps.postTestResultsNotAuthorised(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(403);
        testResultsSteps.validateMessage("User is not authorized to access this resource with an explicit deny");
    }

    @Title("CVSB-416 - CVSB-949 / CVSB-1575 - Un-authenticated consumer creates a new test results")
    @Test
    public void testResultsNoAuthenticated() {
        testResultsSteps.postTestResultsNotAuthenticated(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(401);
        testResultsSteps.validateMessage("Unauthorized");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3510 API Consumer tries to create a new test result for submitted/canceled with extra field defined as calculated - vehicleId")
    @Test
    public void testResultsExtraFieldVehicleId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleId", RandomStringUtils.randomAlphanumeric(10), ToTypeConvertor.STRING, TestResultsLevel.TEST_TYPES);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleId", "is not allowed");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - all body")
    @Test
    public void testResultsEmptyBody() {

        testResultsSteps.postTestResults(null);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");

    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vrm")
    @Test
    public void testResultsMissingVrm() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vrm", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vrm", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vrm")
    @Test
    public void testResultsNullVrm() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vrm", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vrm", "must be a string");
    }


    @Title("nullCVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vrm")
    @Test
    public void testResultsIntegerVrm() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vrm", RandomStringUtils.randomNumeric(8), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vrm", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - vrm")
    @Test
    public void testResultsLengthMaxVrm() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(RandomStringUtils.randomAlphanumeric(9)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vrm", "length must be less than or equal to 8 characters long");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3511 API Consumer tries to create a new test result for submitted/canceled with value/characters lower min length - vrm")
    @Test
    public void testResultsLengthMinVrm() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vrm", "is not allowed to be empty");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vin")
    @Test
    public void testResultsMissingVin() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vin", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vin", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vin")
    @Test
    public void testResultsNullVin() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vin", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vin", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vin")
    @Test
    public void testResultsIntegerVin() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vin", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vin", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - vin")
    @Test
    public void testResultsLengthMaxVin() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVin(RandomStringUtils.randomAlphanumeric(22)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vin", "length must be less than or equal to 21 characters long");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3511 API Consumer tries to create a new test result for submitted/canceled with value/characters lower min length - vin")
    @Test
    public void testResultsLengthMinVin() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVin("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vin", "is not allowed to be empty");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testStationName")
    @Test
    public void testResultsMissingTestStationName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationName", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationName", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testStationName")
    @Test
    public void testResultsNullTestStationName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationName", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationName", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testStationName")
    @Test
    public void testResultsIntegerTestStationName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationName", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationName", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - testStationName")
    @Test
    public void testResultsLengthMaxTestStationName() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStationName(RandomStringUtils.randomAlphanumeric(1000)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationName", "length must be less than or equal to 999 characters long");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testStationPNumber")
    @Test
    public void testResultsMissingTestStationPNumber() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationPNumber", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationPNumber", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testStationPNumber")
    @Test
    public void testResultsNullTestStationPNumber() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationPNumber", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationPNumber", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testStationPNumber")
    @Test
    public void testResultsIntegerTestStationPNumber() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationPNumber", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationPNumber", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - testStationPNumber")
    @Test
    public void testResultsLengthMaxTestStationPNumber() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStationPNumber(RandomStringUtils.randomAlphanumeric(21)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationPNumber", "length must be less than or equal to 20 characters long");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testStationType")
    @Test
    public void testResultsMissingTestStationType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationType", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationType", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testStationType")
    @Test
    public void testResultsNullTestStationType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationType", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationType", "must be one of [atf, gvts, hq]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testStationType")
    @Test
    public void testResultsIntegerTestStationType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStationType", RandomStringUtils.randomNumeric(1, 9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationType", "must be one of [atf, gvts, hq]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStationType random")
    @Test
    public void testResultsValueTestStationType() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStationType(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationType", "must be one of [atf, gvts, hq]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStationType empty")
    @Test
    public void testResultsValueTestStationTypeEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStationType("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStationType", "must be one of [atf, gvts, hq]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testerName")
    @Test
    public void testResultsMissingTesterName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerName", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerName", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testerName")
    @Test
    public void testResultsNullTesterName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerName", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerName", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testerName")
    @Test
    public void testResultsIntegerTesterName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerName", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerName", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - testerName")
    @Test
    public void testResultsLengthMaxTesterName() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTesterName(RandomStringUtils.randomAlphanumeric(61)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerName", "length must be less than or equal to 60 characters long");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testerStaffId")
    @Test
    public void testResultsMissingTesterStaffId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerStaffId", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerStaffId", "is required");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testerStaffId")
    @Test
    public void testResultsNullTesterStaffId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerStaffId", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerStaffId", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testerStaffId")
    @Test
    public void testResultsIntegerTesterStaffId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerStaffId", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerStaffId", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - testerStaffId")
    @Test
    public void testResultsLengthMaxTesterStaffId() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTesterStaffId(RandomStringUtils.randomAlphanumeric(37)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerStaffId", "length must be less than or equal to 36 characters long");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testerEmailAddress")
    @Test
    public void testResultsMissingTesterEmailAddress() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerEmailAddress", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerEmailAddress", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testerEmailAddress")
    @Test
    public void testResultsNullTesterEmailAddress() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerEmailAddress", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerEmailAddress", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testerEmailAddress")
    @Test
    public void testResultsIntegerTesterEmailAddress() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testerEmailAddress", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerEmailAddress", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - testerEmailAddress")
    @Test
    public void testResultsLengthMaxTesterEmailAddress() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTesterEmailAddress(RandomStringUtils.randomAlphanumeric(61)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testerEmailAddress", "length must be less than or equal to 60 characters long");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testStartTimestamp")
    @Test
    public void testResultsMissingTestStartTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStartTimestamp", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStartTimestamp", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testStartTimestamp")
    @Test
    public void testResultsNullTestStartTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStartTimestamp", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStartTimestamp", "must be a valid ISO 8601 date");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testStartTimestamp")
    @Test
    public void testResultsIntegerTestStartTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStartTimestamp", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStartTimestamp", "must be a valid ISO 8601 date");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStartTimestamp random")
    @Test
    public void testResultsRandomStringTestStartTimestamp() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStartTimestamp(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStartTimestamp", "must be a valid ISO 8601 date");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStartTimestamp empty")
    @Test
    public void testResultsEmptyTestStartTimestamp() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStartTimestamp("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStartTimestamp", "must be a valid ISO 8601 date");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testEndTimestamp")
    @Test
    public void testResultsMissingTestEndTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testEndTimestamp", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testEndTimestamp", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testEndTimestamp")
    @Test
    public void testResultsNullTestEndTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testEndTimestamp", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testEndTimestamp", "must be a valid ISO 8601 date");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testEndTimestamp")
    @Test
    public void testResultsIntegerTestEndTimestamp() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testEndTimestamp", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testEndTimestamp", "must be a valid ISO 8601 date");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testEndTimestamp random")
    @Test
    public void testResultsRandomStringTestEndTimestamp() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestEndTimestamp(RandomStringUtils.randomAlphanumeric(5)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testEndTimestamp", "must be a valid ISO 8601 date");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testEndTimestamp empty")
    @Test
    public void testResultsEmptyTestEndTimestamp() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestEndTimestamp("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testEndTimestamp", "must be a valid ISO 8601 date");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testStatus")
    @Test
    public void testResultsMissingTestStatus() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStatus", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testStatus")
    @Test
    public void testResultsNullTestStatus() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStatus", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - testStatus")
    @Test
    public void testResultsIntegerTestStatus() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testStatus", RandomStringUtils.randomNumeric(1, 9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStatus random")
    @Test
    public void testResultsValueTestStatus() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStatus(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - testStatus empty")
    @Test
    public void testResultsValueTestStatusEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestStatus("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testStatus", "should be one of [\"submitted\", \"cancelled\"]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - reasonForCancellation")
    @Test
    public void testResultsMissingReasonForCancellation() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "reasonForCancellation", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("reasonForCancellation", "is required");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - reasonForCancellation")
    @Test
    public void testResultsIntegerReasonForCancellation() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "reasonForCancellation", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("reasonForCancellation", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3507 - API Consumer tries to create a new test result for submitted/canceled with value/characters exceeding max length - reasonForCancellation")
    @Test
    public void testResultsLengthMaxReasonForCancellation() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setReasonForCancellation(RandomStringUtils.randomAlphanumeric(501)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("reasonForCancellation", "length must be less than or equal to 500 characters long");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleClass")
    @Test
    public void testResultsMissingVehicleClass() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleClass", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleClass", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleClass")
    @Test
    public void testResultsNullVehicleClass() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleClass", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleClass", "must be an object");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleClass description")
    @Test
    public void testResultsMissingVehicleClassDescription() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "description", ToTypeConvertor.MISSING, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("description", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleClass description")
    @Test
    public void testResultsNullVehicleClassDescription() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "description", ToTypeConvertor.NULL, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("description", "must be one of [motorbikes over 200cc or with a sidecar, not applicable, small psv (ie: less than or equal to 22 seats), motorbikes up to 200cc, trailer, large psv(ie: greater than 23 seats), 3 wheelers, heavy goods vehicle]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vehicleClass description")
    @Test
    public void testResultsIntegerVehicleClassDescription() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "description", RandomStringUtils.randomNumeric(1, 9), ToTypeConvertor.INTEGER, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("description", "must be one of [motorbikes over 200cc or with a sidecar, not applicable, small psv (ie: less than or equal to 22 seats), motorbikes up to 200cc, trailer, large psv(ie: greater than 23 seats), 3 wheelers, heavy goods vehicle]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicle class description random")
    @Test
    public void testResultsValueVehicleClassDescription() {

        vehicleSubmittedData.setVrm(VRM).getVehicleClass().setDescription(RandomStringUtils.randomAlphanumeric(10));
        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("description", "must be one of [motorbikes over 200cc or with a sidecar, not applicable, small psv (ie: less than or equal to 22 seats), motorbikes up to 200cc, trailer, large psv(ie: greater than 23 seats), 3 wheelers, heavy goods vehicle]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicle class description empty")
    @Test
    public void testResultsValueVehicleClassDescriptionEmpty() {

        vehicleSubmittedData.setVrm(VRM).getVehicleClass().setDescription("");
        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("description", "must be one of [motorbikes over 200cc or with a sidecar, not applicable, small psv (ie: less than or equal to 22 seats), motorbikes up to 200cc, trailer, large psv(ie: greater than 23 seats), 3 wheelers, heavy goods vehicle]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleClass code")
    @Test
    public void testResultsMissingVehicleClassCode() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "code", ToTypeConvertor.MISSING, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("code", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleClass code")
    @Test
    public void testResultsNullVehicleClassCode() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "code", ToTypeConvertor.NULL, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("code", "must be one of [1, 2, 3, n, t, l, s, v]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vehicleClass code")
    @Test
    public void testResultsIntegerVehicleClassCode() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "code", RandomStringUtils.randomNumeric(1, 9), ToTypeConvertor.INTEGER, TestResultsLevel.VEHICLE_CLASS);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("code", "must be one of [1, 2, 3, n, t, l, s, v]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicle class code random")
    @Test
    public void testResultsValueVehicleClassCode() {

        vehicleSubmittedData.setVrm(VRM).getVehicleClass().setCode(RandomStringUtils.randomAlphanumeric(10));
        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("code", "must be one of [1, 2, 3, n, t, l, s, v]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicle class code empty")
    @Test
    public void testResultsValueVehicleClassCodeEmpty() {

        vehicleSubmittedData.setVrm(VRM).getVehicleClass().setCode("");
        testResultsSteps.postTestResults(vehicleSubmittedData.build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("code", "must be one of [1, 2, 3, n, t, l, s, v]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleType")
    @Test
    public void testResultsMissingVehicleType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleType", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleType", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleType")
    @Test
    public void testResultsNullVehicleType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleType", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleType", "must be one of [psv, hgv, trl]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vehicleType")
    @Test
    public void testResultsIntegerVehicleType() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleType", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleType", "must be one of [psv, hgv, trl]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleType random")
    @Test
    public void testResultsValueVehicleType() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleType(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleType", "must be one of [psv, hgv, trl]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleType empty")
    @Test
    public void testResultsValueVehicleTypeEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleType("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleType", "must be one of [psv, hgv, trl]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - numberOfSeats")
    @Test
    public void testResultsMissingNumberOFSeats() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "numberOfSeats", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("numberOfSeats", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - numberOfSeats")
    @Test
    public void testResultsNullNumberOfSeats() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "numberOfSeats", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("numberOfSeats", "must be a number");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - numberOfSeats")
    @Test
    public void testResultsStringNumberOfSeats() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "numberOfSeats", RandomStringUtils.randomAlphanumeric(4), ToTypeConvertor.STRING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("numberOfSeats", "must be a number");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-1573 - Consumer creates a new test results for the submitted/cancelled test - noOfAxles")
    @Test
    public void testResultsRandomNumberNoOfAxles() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVin(generateRandomExcludingValues(21, vehicleSubmittedData.build().getVin()))
                .setVrm(generateRandomExcludingValues(7, vehicleSubmittedData.build().getVrm()))
                .setNoOfAxles(123).build());

        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("noOfAxles", "must be less than or equal to 99");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleConfiguration")
    @Test
    public void testResultsMissingVehicleConfiguration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleConfiguration", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleConfiguration", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleConfiguration")
    @Test
    public void testResultsNullVehicleConfiguration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleConfiguration", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleConfiguration", "must be one of [rigid, articulated]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vehicleConfiguration")
    @Test
    public void testResultsIntegerVehicleConfiguration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleConfiguration", RandomStringUtils.randomNumeric(9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleConfiguration", "must be one of [rigid, articulated]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleConfiguration random")
    @Test
    public void testResultsValueVehicleConfiguration() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleConfiguration(RandomStringUtils.randomAlphanumeric(9)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleConfiguration", "must be one of [rigid, articulated]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleConfiguration empty")
    @Test
    public void testResultsEmptyVehicleConfiguration() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleConfiguration("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleConfiguration", "must be one of [rigid, articulated]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - odometerReading")
    @Test
    public void testResultsMissingOdometerReading() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReading", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReading", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - odometerReading")
    @Test
    public void testResultsNullOdometerReading() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReading", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReading", "must be a number");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - odometerReading")
    @Test
    public void testResultsStringOdometerReading() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReading", RandomStringUtils.randomAlphanumeric(4), ToTypeConvertor.STRING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReading", "must be a number");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - odometerReadingUnits")
    @Test
    public void testResultsMissingOdometerReadingUnits() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReadingUnits", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReadingUnits", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - odometerReadingUnits")
    @Test
    public void testResultsNullOdometerReadingUnits() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReadingUnits", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReadingUnits", "must be one of [kilometres, miles]");
    }



    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - odometerReadingUnits")
    @Test
    public void testResultsIntegerOdometerReadingUnits() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "odometerReadingUnits", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReadingUnits", "must be one of [kilometres, miles]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - odometerReadingUnits random")
    @Test
    public void testResultsValueOdometerReadingUnits() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setOdometerReadingUnits(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReadingUnits", "must be one of [kilometres, miles]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - odometerReadingUnits empty")
    @Test
    public void testResultsOdometerReadingUnitsEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setOdometerReadingUnits("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("odometerReadingUnits", "must be one of [kilometres, miles]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - preparerId")
    @Test
    public void testResultsMissingPreparerId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerId", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerId", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - preparerId")
    @Test
    public void testResultsNullPreparerId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerId", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerId", "must be a string");
    }



    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - preparerId")
    @Test
    public void testResultsIntegerPreparerId() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerId", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerId", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - preparerName")
    @Test
    public void testResultsMissingPreparerName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerName", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerName", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - preparerName")
    @Test
    public void testResultsNullPreparerName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerName", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerName", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - preparerName")
    @Test
    public void testResultsIntegerPreparerName() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "preparerName", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("preparerName", "must be a string");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - euVehicleCategory")
    @Test
    public void testResultsMissingEuVehicleCategory() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "euVehicleCategory", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("euVehicleCategory", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - euVehicleCategory")
    @Test
    public void testResultsNullEuVehicleCategory() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "euVehicleCategory", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("euVehicleCategory", "must be one of [m1, m2, m3, n1, n2, n3, o1, o2, o3, o4]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - euVehicleCategory")
    @Test
    public void testResultsIntegerEuVehicleCategory() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "euVehicleCategory", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("euVehicleCategory", "must be one of [m1, m2, m3, n1, n2, n3, o1, o2, o3, o4]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - euVehicleCategory random")
    @Test
    public void testResultsValueEuVehicleCategory() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setEuVehicleCategory(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("euVehicleCategory", "must be one of [m1, m2, m3, n1, n2, n3, o1, o2, o3, o4]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - euVehicleCategory empty")
    @Test
    public void testResultsValueEuVehicleCategoryEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setEuVehicleCategory("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("euVehicleCategory", "must be one of [m1, m2, m3, n1, n2, n3, o1, o2, o3, o4]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - countryOfRegistration")
    @Test
    public void testResultsMissingCountryOfRegistration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "countryOfRegistration", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("countryOfRegistration", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - countryOfRegistration")
    @Test
    public void testResultsNullCountryOfRegistration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "countryOfRegistration", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("countryOfRegistration", "must be a string");
    }



    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - countryOfRegistration")
    @Test
    public void testResultsIntegerCountryOfRegistration() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "countryOfRegistration", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("countryOfRegistration", "must be a string");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - vehicleSize")
    @Test
    public void testResultsMissingVehicleSize() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleSize", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleSize", "is required");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - vehicleSize")
    @Test
    public void testResultsNullVehicleSize() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleSize", ToTypeConvertor.NULL, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleSize", "must be one of [small, large]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3508 API Consumer tries to create a new test result for submitted/canceled with different property type - vehicleSize")
    @Test
    public void testResultsIntegerVehicleSize() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "vehicleSize", RandomStringUtils.randomNumeric(1,9), ToTypeConvertor.INTEGER, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleSize", "must be one of [small, large]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleSize random")
    @Test
    public void testResultsValueVehicleSize() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleSize(RandomStringUtils.randomAlphanumeric(10)).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleSize", "must be one of [small, large]");
    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3509 - API Consumer tries to create a new test result for submitted/canceled with different format or allowed values - vehicleSize empty")
    @Test
    public void testResultsVehicleSizeEmpty() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setVehicleSize("").build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("vehicleSize", "must be one of [small, large]");
    }


    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3506 - API Consumer tries to create a new test result for submitted/canceled with null value for not nullable - testTypes")
    @Test
    public void testResultsTestTypesAsNull() {

        testResultsSteps.postTestResults(vehicleSubmittedData.setVrm(VRM).setTestTypes(null).build());
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testTypes", "must be an array");

    }

    @Title("CVSB-417 - CVSB-949 - CVSB-1140 / CVSB-3505 - API Consumer tries to create a new test result for submitted/canceled with missing property - testTypes")
    @Test
    public void testResultsTestTypesMissing() {

        testResultsSteps.postTestResultsFieldChange(vehicleSubmittedData.setVrm(VRM).build(), "testTypes", ToTypeConvertor.MISSING, TestResultsLevel.MAIN_LEVEL);
        testResultsSteps.statusCodeShouldBe(400);
        testResultsSteps.validatePostErrorData("testTypes", "is required");
    }

}

