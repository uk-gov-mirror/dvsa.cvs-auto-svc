package vott;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RetrieveTestHistoryAndVehicleDataPasswordTokenTest {

    // Variable + Constant Test Data Setup
    private String token;
    private final String xApiKey = "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19222";
    private final String validVINNumber = "T12765432";
    private final String validVehicleRegMark = "AB15XYZ";

    private final String invalidVINNumber = "T12765431";
    private final String invalidVehicleRegMark = "W01A00229";

    @Before
    public void Setup() {

        this.token = new TokenService().getBearerToken("password");
        RestAssured.baseURI = "https://api.develop.cvs.dvsacloud.uk/cvsb-19222/v1/enquiry/vehicle";
        //we insert data here into db (Rob)

    }

    @Title("CVSB-19222 - Happy Path for vehicle data and test history retrieval using valid Vin Number")
    @Test
    public void RetrieveVehicleDataAndTestHistoryUsingVinTest() {

        System.out.println("Valid access token: " + token);

        String response =
                given()//.log().all()
                        .header("authorization", "Bearer " + token)
                        .header("x-api-key", xApiKey)
                        .header("content-type", "application/json")
                        .queryParam("vinNumber", validVINNumber).

                //send request
                when().//log().all().
                        get().

                //verification
                then().//log().all().
                        statusCode(200).
                        extract().response().asString();

        System.out.println(response);

        JsonPath js = new JsonPath(response);
        //String idReturnedInApiResponse = js.getString("id");
        String systemNumberReturnedInApiResponse = js.getString("system_number");
        String vinReturnedInApiResponse = js.getString("vin");
        String vrmTrmReturnedInApiResponse = js.getString("vrm_trm");
        String trailerIdReturnedInApiResponse = js.getString("trailer_id");
        String createdAtReturnedInApiResponse = js.getString("createdAt");
        String technicalrecordsNotesReturnedInApiResponse = js.getString("technicalrecords.notes");
        String technicalrecordsWidthReturnedInApiResponse = js.getString("technicalrecords.width");
        String technicalrecordsHeightReturnedInApiResponse = js.getString("technicalrecords.height");
        String technicalrecordsLengthReturnedInApiResponse = js.getString("technicalrecords.length");
        String technicalrecordsOffRoadReturnedInApiResponse = js.getString("technicalrecords.offRoad");
        String technicalrecordsRemarksReturnedInApiResponse = js.getString("technicalrecords.remarks");
        String technicalrecordsCoifDateReturnedInApiResponse = js.getString("technicalrecords.coifDate");
        String technicalrecordsRegnDateReturnedInApiResponse = js.getString("technicalrecords.regnDate");
        String technicalrecordsBrakeCodeReturnedInApiResponse = js.getString("technicalrecords.brakeCode");
        String technicalrecordsCreatedAtReturnedInApiResponse = js.getString("technicalrecords.createdAt");
        String technicalrecordsDtpNumberReturnedInApiResponse = js.getString("technicalrecords.dtpNumber");
        String technicalrecordsMakeModelMakeReturnedInApiResponse = js.getString("technicalrecords.dtpNumber.makeModel.make");
        String technicalrecordsMakeModelModelReturnedInApiResponse = js.getString("technicalrecords.dtpNumber.makeModel.model");
        String technicalrecordsMakeModelDtpCodeReturnedInApiResponse = js.getString("technicalrecords.dtpNumber.makeModel.dtpCode");
        String technicalrecordsMakeModelBodyMakeReturnedInApiResponse = js.getString("technicalrecords.makeModel.bodyMake");
        String technicalrecordsMakeModelBodyModelReturnedInApiResponse = js.getString("technicalrecords.makeModel.bodyModel");
        String technicalrecordsMakeModelChassisMakeReturnedInApiResponse = js.getString("technicalrecords.makeModel.chassisMake");
        String technicalrecordsMakeModelBodyTypeCodeReturnedInApiResponse = js.getString("technicalrecords.makeModel.bodyTypeCode");
        String technicalrecordsMakeModelChassisModelReturnedInApiResponse = js.getString("technicalrecords.makeModel.chassisModel");
        String technicalrecordsMakeModelModelLiteralReturnedInApiResponse = js.getString("technicalrecords.makeModel.modelLiteral");
        String technicalrecordsMakeModelBodyTypeDescriptionReturnedInApiResponse = js.getString("technicalrecords.makeModel.bodyTypeDescription");
        String technicalrecordsMakeModelFuelPropulsionSystemReturnedInApiResponse = js.getString("technicalrecords.makeModel.fuelPropulsionSystem");
        String technicalrecordsNoOfAxlesReturnedInApiResponse = js.getString("technicalrecords.noOfAxles");
        String technicalrecordsNtaNumberReturnedInApiResponse = js.getString("technicalrecords.ntaNumber");
        String technicalrecordsStatusCodeReturnedInApiResponse = js.getString("technicalrecords.statusCode");
        String technicalrecordsUpdateTypeReturnedInApiResponse = js.getString("technicalrecords.updateType");
        String technicalrecordsTyreUseCodeReturnedInApiResponse = js.getString("technicalrecords.tyreUseCode");
        String technicalrecordsApprovalTypeReturnedInApiResponse = js.getString("technicalrecords.approvalType");
        String technicalrecordsCouplingTypeReturnedInApiResponse = js.getString("technicalrecords.couplingType");
        String technicalrecordsEuroStandardReturnedInApiResponse = js.getString("technicalrecords.euroStandard");
        String technicalrecordsFirstUseDateReturnedInApiResponse = js.getString("technicalrecords.firstUseDate");
        String technicalrecordsFunctionCodeReturnedInApiResponse = js.getString("technicalrecords.functionCode");
        String technicalrecordsRoadFriendlyReturnedInApiResponse = js.getString("technicalrecords.roadFriendly");
        String technicalrecordsVehicleClassCodeReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.code");
        String technicalrecordsVehicleClassDescriptionReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.description");
        String technicalrecordsVehicleClassVehicleSizeReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.vehicleSize");
        String technicalrecordsVehicleClassVehicleTypeReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.vehicleType");
        String technicalrecordsVehicleClassEuVehicleCategoryReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.euVehicleCategory");
        String technicalrecordsVehicleClassVehicleConfigurationReturnedInApiResponse = js.getString("technicalrecords.vehicleClass.vehicleConfiguration");
        String technicalrecordsDispensationsReturnedInApiResponse = js.getString("technicalrecords.dispensations");
        String technicalrecordsGrossGbWeightReturnedInApiResponse = js.getString("technicalrecords.grossGbWeight");
        String technicalrecordsLastUpdatedAtReturnedInApiResponse = js.getString("technicalrecords.lastUpdatedAt");
        String technicalrecordsTrainGbWeightReturnedInApiResponse = js.getString("technicalrecords.trainGbWeight");
        String technicalrecordsUnladenWeightReturnedInApiResponse = js.getString("technicalrecords.unladenWeight");
        String technicalrecordsVariantNumberReturnedInApiResponse = js.getString("technicalrecords.variantNumber");
        String technicalrecordsEmissionsLimitReturnedInApiResponse = js.getString("technicalrecords.emissionsLimit");
        String technicalrecordsGrossEecWeightReturnedInApiResponse = js.getString("technicalrecords.grossEecWeight");
        String technicalrecordsPurchaserNotesReturnedInApiResponse = js.getString("technicalrecords.purchaserNotes");
        String technicalrecordsSeatsLowerDeckReturnedInApiResponse = js.getString("technicalrecords.seatsLowerDeck");
        String technicalrecordsSeatsUpperDeckReturnedInApiResponse = js.getString("technicalrecords.seatsUpperDeck");
        String technicalrecordsSuspensionTypeReturnedInApiResponse = js.getString("technicalrecords.suspensionType");
        String technicalrecordsTachoExemptMrkReturnedInApiResponse = js.getString("technicalrecords.tachoExemptMrk");
        String technicalrecordsTrainEecWeightReturnedInApiResponse = js.getString("technicalrecords.trainEecWeight");
        String technicalrecordsConversionRefNoReturnedInApiResponse = js.getString("technicalrecords.conversionRefNo");
        String technicalrecordsGrossKerbWeightReturnedInApiResponse = js.getString("technicalrecords.grossKerbWeight");
        String technicalrecordsManufactureYearReturnedInApiResponse = js.getString("technicalrecords.manufactureYear");
        String technicalrecordsSpeedLimiterMrkReturnedInApiResponse = js.getString("technicalrecords.speedLimiterMrk");
        String technicalrecordsAlterationMarkerReturnedInApiResponse = js.getString("technicalrecords.alterationMarker");
        String technicalrecordsCoifSerialNumberReturnedInApiResponse = js.getString("technicalrecords.coifSerialNumber");
        String technicalrecordsFrameDescriptionReturnedInApiResponse = js.getString("technicalrecords.frameDescription");
        String technicalrecordsGrossLadenWeightReturnedInApiResponse = js.getString("technicalrecords.grossLadenWeight");
        String technicalrecordsLoadSensingValveReturnedInApiResponse = js.getString("technicalrecords.loadSensingValve");
        String technicalrecordsMaxTrainGbWeightReturnedInApiResponse = js.getString("technicalrecords.maxTrainGbWeight");
        String technicalrecordsSpeedRestrictionReturnedInApiResponse = js.getString("technicalrecords.speedRestriction");
        String technicalrecordsStandingCapacityReturnedInApiResponse = js.getString("technicalrecords.standingCapacity");
        String technicalrecordsCoifCertifierNameReturnedInApiResponse = js.getString("technicalrecords.coifCertifierName");
        String technicalrecordsGrossDesignWeightReturnedInApiResponse = js.getString("technicalrecords.grossDesignWeight");
        String technicalrecordsManufacturerNotesReturnedInApiResponse = js.getString("technicalrecords.manufacturerNotes");
        String technicalrecordsMaxLoadOnCouplingReturnedInApiResponse = js.getString("technicalrecords.maxLoadOnCoupling");
        String technicalrecordsMaxTrainEecWeightReturnedInApiResponse = js.getString("technicalrecords.maxTrainEecWeight");
        String technicalrecordsNumberOfSeatbeltsReturnedInApiResponse = js.getString("technicalrecords.numberOfSeatbelts");
        String technicalrecordsRearAxleToRearTrlReturnedInApiResponse = js.getString("technicalrecords.rearAxleToRearTrl");
        String technicalrecordsReasonForCreationReturnedInApiResponse = js.getString("technicalrecords.reasonForCreation");
        String technicalrecordsTrainDesignWeightReturnedInApiResponse = js.getString("technicalrecords.trainDesignWeight");
        String technicalrecordsApprovalTypeNumberReturnedInApiResponse = js.getString("technicalrecords.approvalTypeNumber");
        String technicalrecordsRecordCompletenessReturnedInApiResponse = js.getString("technicalrecords.recordCompleteness");
        String technicalrecordsFrontAxleToRearAxleReturnedInApiResponse = js.getString("technicalrecords.frontAxleToRearAxle");
        String technicalrecordsMaxTrainDesignWeightReturnedInApiResponse = js.getString("technicalrecords.maxTrainDesignWeight");
        String technicalrecordsNumberOfWheelsDrivenReturnedInApiResponse = js.getString("technicalrecords.numberOfWheelsDriven");
        String technicalrecordsVariantVersionNumberReturnedInApiResponse = js.getString("technicalrecords.variantVersionNumber");
        String technicalrecordsAntilockBrakingSystemReturnedInApiResponse = js.getString("technicalrecords.antilockBrakingSystem");
        String technicalrecordsDrawbarCouplingFittedReturnedInApiResponse = js.getString("technicalrecords.drawbarCouplingFitted");
        String technicalrecordsFrontAxleTo5thWheelMaxReturnedInApiResponse = js.getString("technicalrecords.frontAxleTo5thWheelMax");
        String technicalrecordsFrontAxleTo5thWheelMinReturnedInApiResponse = js.getString("technicalrecords.frontAxleTo5thWheelMin");
        String technicalrecordsDepartmentalVehicleMarkerReturnedInApiResponse = js.getString("technicalrecords.departmentalVehicleMarker");
        String technicalrecordsCouplingCenterToRearTrlMaxReturnedInApiResponse = js.getString("technicalrecords.couplingCenterToRearTrlMax");
        String technicalrecordsCouplingCenterToRearTrlMinReturnedInApiResponse = js.getString("technicalrecords.couplingCenterToRearTrlMin");
        String technicalrecordsCouplingCenterToRearAxleMaxReturnedInApiResponse = js.getString("technicalrecords.couplingCenterToRearAxleMax");
        String technicalrecordsCouplingCenterToRearAxleMinReturnedInApiResponse = js.getString("technicalrecords.couplingCenterToRearAxleMin");
        String technicalrecordsFrontAxleTo5thWheelCouplingMaxReturnedInApiResponse = js.getString("technicalrecords.frontAxleTo5thWheelCouplingMax");
        String technicalrecordsFrontAxleTo5thWheelCouplingMinReturnedInApiResponse = js.getString("technicalrecords.frontAxleTo5thWheelCouplingMin");
        String technicalrecordsCentreOfRearmostAxleToRearOfTrlReturnedInApiResponse = js.getString("technicalrecords.centreOfRearmostAxleToRearOfTrl");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.seatbeltInstallationApprovalDate");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.brakeCode");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.dataTrBrakeOne");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.dataTrBrakeTwo");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.dataTrBrakeThree");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.retarderBrakeOne");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.retarderBrakeTwo");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.brakeCodeOriginal");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.parkingBrakeForceA");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.parkingBrakeForceB");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.serviceBrakeForceA");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.serviceBrakeForceB");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.secondaryBrakeForceA");
        String technicalrecordsSeatbeltInstallationApprovalDateReturnedInApiResponse = js.getString("technicalrecords.brakes.secondaryBrakeForceB");










        assertThat(vinReturnedInApiResponse).isEqualTo(validVINNumber);
        //System.out.println("ID returned in API response is: " + idReturnedInApiResponse);
        System.out.println("System Number in API response is: " + systemNumberReturnedInApiResponse);
        System.out.println("Vin number sent: " + validVINNumber + ". Returned vin in API response is: " + vinReturnedInApiResponse);
        System.out.println("VRM TRM in API response is: " + vrmTrmReturnedInApiResponse);
        System.out.println("Trailer ID in API response is: " + trailerIdReturnedInApiResponse);
        System.out.println("Created at: " + createdAtReturnedInApiResponse);
        System.out.println("technicalrecords.notes: " + technicalrecordsNotesReturnedInApiResponse);
        System.out.println("technicalrecords.width: " + technicalrecordsWidthReturnedInApiResponse);
        System.out.println("technicalrecords.height: " + technicalrecordsHeightReturnedInApiResponse);
        System.out.println("technicalrecords.length: " + technicalrecordsLengthReturnedInApiResponse);
        System.out.println("technicalrecords.offRoad: " + technicalrecordsOffRoadReturnedInApiResponse);
        System.out.println("technicalrecords.remarks: " + technicalrecordsRemarksReturnedInApiResponse);
        System.out.println("technicalrecords.coifDate: " + technicalrecordsCoifDateReturnedInApiResponse);
        System.out.println("technicalrecords.regnDate: " + technicalrecordsRegnDateReturnedInApiResponse);
        System.out.println("technicalrecords.brakeCode: " + technicalrecordsBrakeCodeReturnedInApiResponse);
        System.out.println("technicalrecords.createdAt: " + technicalrecordsCreatedAtReturnedInApiResponse);
        System.out.println("technicalrecords.dtpNumber: " + technicalrecordsDtpNumberReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.make: " + technicalrecordsMakeModelMakeReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.model: " + technicalrecordsMakeModelModelReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.dtpCode: " + technicalrecordsMakeModelDtpCodeReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.bodyMake: " + technicalrecordsMakeModelBodyMakeReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.bodyModel: " + technicalrecordsMakeModelBodyModelReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.chassisMake: " + technicalrecordsMakeModelChassisMakeReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.bodyTypeCode: " + technicalrecordsMakeModelBodyTypeCodeReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.chassisModel: " + technicalrecordsMakeModelChassisModelReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.modelLiteral: " + technicalrecordsMakeModelModelLiteralReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.bodyTypeDescription: " + technicalrecordsMakeModelBodyTypeDescriptionReturnedInApiResponse);
        System.out.println("technicalrecords.makeModel.fuelPropulsionSystem: " + technicalrecordsMakeModelFuelPropulsionSystemReturnedInApiResponse);







    }

    @Title("CVSB-19222 - Happy Path for vehicle data and test history retrieval using valid Vrm")
    @Test
    public void RetrieveVehicleDataAndTestHistoryUsingVrmTest() {

        System.out.println("Valid access token: " + token);

        String response =
                given()//.log().all()
                        .header("authorization", "Bearer " + token)
                        .header("x-api-key", xApiKey)
                        .header("content-type", "application/json")
                        .queryParam("VehicleRegMark", validVehicleRegMark).

                //send request
                when().//log().all().
                        get().

                //verification
                then().log().all().
                        statusCode(200).//time(lessThan(100L)).
                        extract().response().asString();

        System.out.println(response);

        JsonPath js2 = new JsonPath(response);
        String vrmTrmReturnedInApiResponse = js2.getString("vrm_trm");
        System.out.println(vrmTrmReturnedInApiResponse);
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryBadJwtTokenTest() {

        System.out.println("Using invalid token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token + 1)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/json")
            .queryParam("VehicleRegMark", validVehicleRegMark).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(403).
            body("message", equalTo("User is not authorized to access this resource with an explicit deny"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryNoParamsTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/json").

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(400).
            body(equalTo("No parameter defined"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryBothVinAndVrmTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/json")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("VehicleRegMark", validVehicleRegMark).

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(400).
                body(equalTo("Too many parameters defined"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryNoAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("content-type", "application/json")
            .queryParam("vinNumber", validVINNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(403).
            body("message", equalTo("Forbidden"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryInvalidAPIKey() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey + "badkey")
            .header("content-type", "application/json")
            .queryParam("VehicleRegMark", "AB15XYZ").

        //send request
        when().//log().all().
            get().

        //verification
            then().//log().all().
            statusCode(403).
            body("message", equalTo("Forbidden"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryVehicleRegMarkDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/json")
            .queryParam("VehicleRegMark", "AB15XYZ"). //todo send a vrm that doesn't exist in DB

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(404).
            body(equalTo("NoSuchKey"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryVinNumberDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/json")
            .queryParam("vinNumber", invalidVINNumber). //todo send a vin that doesn't exist in DB

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(404).
            body(equalTo("NoSuchKey"));
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryNonPrintableCharsParamsTest() {

        System.out.println("Valid access token: " + token);

        //TODO add control chars test i.e. ctrl+c etc.

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/json")
                .queryParam("testNumber", validVehicleRegMark).

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(404).
                body(equalTo("NoSuchKey"));
    }

}


