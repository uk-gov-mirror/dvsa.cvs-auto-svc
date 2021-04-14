package vott;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;
////old model
//import vott.dto.TechnicalRecord;
//import vott.dto.Vehicle;

//new model
import vott.dto2.TechnicalRecord;
import vott.dto2.Vehicle;


import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

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

        this.token = new TokenService(OAuthVersion.V1, GrantType.IMPLICIT).getBearerToken();//
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

        Gson gson = new GsonBuilder().create();

        Vehicle vehicle = gson.fromJson(response, Vehicle.class);

        TechnicalRecord technicalRecord1 = vehicle.getTechnicalrecords().get(0);
        TechnicalRecord technicalRecord2 = vehicle.getTechnicalrecords().get(1);

        assertThat(vehicle.getVin()).isEqualTo("T12765432");
        assertThat(vehicle.getVrmTrm()).isEqualTo(null);
        assertThat(vehicle.getCreatedAt()).isEqualTo("2021-04-01 15:34:53.000000");
        assertThat(vehicle.getTrailerId()).isEqualTo("D000001");
        assertThat(vehicle.getSystemNumber()).isEqualTo("11000024");


        assertThat(technicalRecord1.getNotes()).isEqualTo(null);
        assertThat(technicalRecord1.getWidth()).isEqualTo(2200);
        assertThat(technicalRecord1.getHeight()).isEqualTo(null);
        assertThat(technicalRecord1.getLength()).isEqualTo(7500);
//        assertThat(technicalRecord1.getOffRoad()).isEqualTo(true);
        assertThat(technicalRecord1.getRemarks()).isEqualTo(null);
        assertThat(technicalRecord1.getCoifDate()).isEqualTo(null);
        assertThat(technicalRecord1.getRegnDate()).isEqualTo("2019-06-24");
        assertThat(technicalRecord1.getBrakeCode()).isEqualTo("178202");
        assertThat(technicalRecord1.getCreatedAt()).isEqualTo("2019-06-24 10:26:55.000000");
        assertThat(technicalRecord1.getDtpNumber()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getMake()).isEqualTo("Isuzu");
        assertThat(technicalRecord1.getMakeModel().get(0).getModel()).isEqualTo("F06");
//        assertThat(technicalRecord1.getMakeModel().get(0).getDtpCode()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getBodyMake()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getBodyModel()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getChassisMake()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getBodyTypeCode()).isEqualTo("x");
        assertThat(technicalRecord1.getMakeModel().get(0).getChassisModel()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getModelLiteral()).isEqualTo(null);
        assertThat(technicalRecord1.getMakeModel().get(0).getBodyTypeDescription()).isEqualTo("other");
        assertThat(technicalRecord1.getMakeModel().get(0).getFuelPropulsionSystem()).isEqualTo(null);
        assertThat(technicalRecord1.getNoOfAxles()).isEqualTo(3);
        assertThat(technicalRecord1.getNtaNumber()).isEqualTo("123456");
        assertThat(technicalRecord1.getStatusCode()).isEqualTo("archived");
//        assertThat(technicalRecord1.getUpdateType()).isEqualTo("techRecordUpdate");
        assertThat(technicalRecord1.getTyreUseCode()).isEqualTo("2B");
        assertThat(technicalRecord1.getApprovalType()).isEqualTo(null);
        assertThat(technicalRecord1.getCouplingType()).isEqualTo("F");
        assertThat(technicalRecord1.getEuroStandard()).isEqualTo(null);
        assertThat(technicalRecord1.getFirstUseDate()).isEqualTo("2019-06-24");
        assertThat(technicalRecord1.getFunctionCode()).isEqualTo(null);
//        assertThat(technicalRecord1.getRoadFriendly()).isEqualTo(true);
        assertThat(technicalRecord1.getVehicleClass().get(0).getCode()).isEqualTo("t");
        assertThat(technicalRecord1.getVehicleClass().get(0).getDescription()).isEqualTo("trailer");
        assertThat(technicalRecord1.getVehicleClass().get(0).getVehicleSize()).isEqualTo(null);
        assertThat(technicalRecord1.getVehicleClass().get(0).getVehicleType()).isEqualTo("trl");
        assertThat(technicalRecord1.getVehicleClass().get(0).getEuVehicleCategory()).isEqualTo(null);
        assertThat(technicalRecord1.getVehicleClass().get(0).getVehicleConfiguration()).isEqualTo("articulated");
        assertThat(technicalRecord1.getDispensations()).isEqualTo(null);
        assertThat(technicalRecord1.getGrossGbWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getLastUpdatedAt()).isEqualTo("2021-03-19 02:31:45.000000");
        assertThat(technicalRecord1.getTrainGbWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getUnladenWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getVariantNumber()).isEqualTo(null);
        assertThat(technicalRecord1.getEmissionsLimit()).isEqualTo(null);
        assertThat(technicalRecord1.getGrossEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getPurchaserNotes()).isEqualTo(null);
        assertThat(technicalRecord1.getSeatsLowerDeck()).isEqualTo(null);
        assertThat(technicalRecord1.getSeatsUpperDeck()).isEqualTo(null);
        assertThat(technicalRecord1.getSuspensionType()).isEqualTo("Y");
//        assertThat(technicalRecord1.getTachoExemptMrk()).isEqualTo(true);
        assertThat(technicalRecord1.getTrainEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getConversionRefNo()).isEqualTo("7891234");
        assertThat(technicalRecord1.getGrossKerbWeight()).isEqualTo(2500);
        assertThat(technicalRecord1.getManufactureYear()).isEqualTo("2018");
//        assertThat(technicalRecord1.getSpeedLimiterMrk()).isEqualTo(true);
//        assertThat(technicalRecord1.getAlterationMarker()).isEqualTo(true);
        assertThat(technicalRecord1.getCoifSerialNumber()).isEqualTo(null);
        assertThat(technicalRecord1.getFrameDescription()).isEqualTo(null);
        assertThat(technicalRecord1.getGrossLadenWeight()).isEqualTo(3000);
//        assertThat(technicalRecord1.getLoadSensingValve()).isEqualTo(true);
        assertThat(technicalRecord1.getMaxTrainGbWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getSpeedRestriction()).isEqualTo(null);
        assertThat(technicalRecord1.getStandingCapacity()).isEqualTo(null);
        assertThat(technicalRecord1.getCoifCertifierName()).isEqualTo(null);
        assertThat(technicalRecord1.getGrossDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getManufacturerNotes()).isEqualTo(null);
        assertThat(technicalRecord1.getMaxLoadOnCoupling()).isEqualTo(7000);
        assertThat(technicalRecord1.getMaxTrainEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getNumberOfSeatbelts()).isEqualTo(null);
        assertThat(technicalRecord1.getRearAxleToRearTrl()).isEqualTo(400);
        assertThat(technicalRecord1.getReasonForCreation()).isEqualTo("new trailer");
        assertThat(technicalRecord1.getTrainDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getApprovalTypeNumber()).isEqualTo(null);
//        assertThat(technicalRecord1.getRecordCompleteness()).isEqualTo(null);
        assertThat(technicalRecord1.getFrontAxleToRearAxle()).isEqualTo(1700);
        assertThat(technicalRecord1.getMaxTrainDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getNumberOfWheelsDriven()).isEqualTo(null);
        assertThat(technicalRecord1.getVariantVersionNumber()).isEqualTo(null);
//        assertThat(technicalRecord1.getAntiLockBrakingSystem()).isEqualTo(true);
//        assertThat(technicalRecord1.getDrawbarCouplingFitted()).isEqualTo(true);
        assertThat(technicalRecord1.getFrontAxleTo5thWheelMax()).isEqualTo(null);
        assertThat(technicalRecord1.getFrontAxleTo5thWheelMin()).isEqualTo(null);
//        assertThat(technicalRecord1.getDepartmentalVehicleMarker()).isEqualTo(true);
        assertThat(technicalRecord1.getCouplingCentreToRearTrlMax()).isEqualTo(null);
        assertThat(technicalRecord1.getCouplingCentreToRearTrlMin()).isEqualTo(null);
        assertThat(technicalRecord1.getCouplingCentreToRearAxleMax()).isEqualTo(null);
        assertThat(technicalRecord1.getCouplingCentreToRearAxleMin()).isEqualTo(null);
        assertThat(technicalRecord1.getFrontAxleTo5thWheelCouplingMax()).isEqualTo(null);
        assertThat(technicalRecord1.getFrontAxleTo5thWheelCouplingMin()).isEqualTo(null);
        assertThat(technicalRecord1.getCentreOfRearmostAxleToRearOfTrl()).isEqualTo(null);
        assertThat(technicalRecord1.getSeatbeltInstallationApprovalDate()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getBrakeCode()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getDataTrBrakeOne()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getDataTrBrakeTwo()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getDataTrBrakeThree()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getRetarderBrakeOne()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getRetarderBrakeTwo()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getBrakeCodeOriginal()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getParkingBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getParkingBrakeForceB()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getServiceBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getServiceBrakeForceB()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getSecondaryBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord1.getPsvBrakes().get(0).getSecondaryBrakeForceB()).isEqualTo(null);
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getTyreCode()).isEqualTo(1234); // todo not reaching the correct nested field
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(0).getSpeedCategorySymbol()).isEqualTo("a7"); // todo end
        assertThat(technicalRecord1.getAxles().get(0).getGbWeight()).isEqualTo("1400"); // todo not matching type returned
//        assertThat(technicalRecord1.getAxles().get(0).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(0).getAxleNumber()).isEqualTo("1");
//        assertThat(technicalRecord1.getAxles().get(0).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord1.getAxles().get(0).getLadenWeight()).isEqualTo(null);
//        assertThat(technicalRecord1.getAxles().get(0).getLeverLength()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(0).getDesignWeight()).isEqualTo("1800");
//        assertThat(technicalRecord1.getAxles().get(0).getBrakeActuator()).isEqualTo(null); // todo end
//        assertThat(technicalRecord1.getParkingBrakeMrk()).isEqualTo(true); // todo not nested in the right place
//        assertThat(technicalRecord1.getAxles().get(0).getSpringBrakeParking()).isEqualTo(1); // todo end
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getTyreCode()).isEqualTo("5678"); // todo not reaching the correct nested field
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(1).getSpeedCategorySymbol()).isEqualTo("a7"); // todo end
        assertThat(technicalRecord1.getAxles().get(1).getGbWeight()).isEqualTo("1600");
//        assertThat(technicalRecord1.getAxles().get(1).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(1).getAxleNumber()).isEqualTo("2");
//        assertThat(technicalRecord1.getAxles().get(1).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord1.getAxles().get(1).getLadenWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(1).getLeverLength()).isEqualTo("125");
        assertThat(technicalRecord1.getAxles().get(1).getDesignWeight()).isEqualTo("1900");
        assertThat(technicalRecord1.getAxles().get(1).getBrakeActuator()).isEqualTo("113");
//        assertThat(technicalRecord1.getAxles().get(1).getParkingBrakeMrk()).isEqualTo(true);
//        assertThat(technicalRecord1.getAxles().get(1).getSpringBrakeParking()).isEqualTo(1);
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getTyreCode()).isEqualTo(5678);// todo not reaching the correct nested field
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord1.getAxles().get(0).getTyres().get(2).getSpeedCategorySymbol()).isEqualTo("a7"); // todo end
//        assertThat(technicalRecord1.getAxles().get(2).getGbWeight()).isEqualTo("1600"); //todo not matching type returned
//        assertThat(technicalRecord1.getAxles().get(2).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(2).getAxleNumber()).isEqualTo("3");
//        assertThat(technicalRecord1.getAxles().get(2).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord1.getAxles().get(2).getLadenWeight()).isEqualTo(null);
        assertThat(technicalRecord1.getAxles().get(2).getLeverLength()).isEqualTo("125");
        assertThat(technicalRecord1.getAxles().get(2).getDesignWeight()).isEqualTo("1900");
        assertThat(technicalRecord1.getAxles().get(2).getBrakeActuator()).isEqualTo("113"); // todo end
//        assertThat(technicalRecord1.getAxles().get(2).getParkingBrakeMrk()).isEqualTo(true);
//        assertThat(technicalRecord1.getAxles().get(2).getSpringBrakeParking()).isEqualTo(1);
//        assertThat(technicalRecord1.getAxles().get(0).getAxlespacing().get(0).getAxles()).isEqualTo("1-2");
//        assertThat(technicalRecord1.getAxles().get(0).getAxlespacing().get(0).getValue()).isEqualTo(1200);
//        assertThat(technicalRecord1.getAxles().get(0).getPlates().get(0)).isEqualTo(null);

        assertThat(technicalRecord2.getNotes()).isEqualTo(null);
        assertThat(technicalRecord2.getWidth()).isEqualTo(2200);
        assertThat(technicalRecord2.getHeight()).isEqualTo(null);
        assertThat(technicalRecord2.getLength()).isEqualTo(7500);
//        assertThat(technicalRecord2.getOffRoad()).isEqualTo(true);
        assertThat(technicalRecord2.getRemarks()).isEqualTo(null);
        assertThat(technicalRecord2.getCoifDate()).isEqualTo(null);
        assertThat(technicalRecord2.getRegnDate()).isEqualTo("2019-06-24");
        assertThat(technicalRecord2.getBrakeCode()).isEqualTo("178202");
        assertThat(technicalRecord2.getCreatedAt()).isEqualTo("2021-03-19 02:31:45.000000");
//        assertThat(technicalRecord2.getDtpNumber()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getMake()).isEqualTo("Isuzu");
        assertThat(technicalRecord2.getMakeModel().get(1).getModel()).isEqualTo("F06");
//        assertThat(technicalRecord2.getMakeModel().get(1).getDtpCode()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getBodyMake()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getBodyModel()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getChassisMake()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getBodyTypeCode()).isEqualTo("x");
        assertThat(technicalRecord2.getMakeModel().get(1).getChassisModel()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getModelLiteral()).isEqualTo(null);
        assertThat(technicalRecord2.getMakeModel().get(1).getBodyTypeDescription()).isEqualTo("other");
        assertThat(technicalRecord2.getMakeModel().get(1).getFuelPropulsionSystem()).isEqualTo(null);
        assertThat(technicalRecord2.getNoOfAxles()).isEqualTo(3);
        assertThat(technicalRecord2.getNtaNumber()).isEqualTo("123456");
        assertThat(technicalRecord2.getStatusCode()).isEqualTo("current");
//        assertThat(technicalRecord2.getUpdateType()).isEqualTo("techRecordUpdate");
        assertThat(technicalRecord2.getTyreUseCode()).isEqualTo("2B");
        assertThat(technicalRecord2.getApprovalType()).isEqualTo(null);
        assertThat(technicalRecord2.getCouplingType()).isEqualTo("F");
        assertThat(technicalRecord2.getEuroStandard()).isEqualTo(null);
        assertThat(technicalRecord2.getFirstUseDate()).isEqualTo("2019-06-24");
        assertThat(technicalRecord2.getFunctionCode()).isEqualTo(null);
//        assertThat(technicalRecord2.getRoadFriendly()).isEqualTo(true);
        assertThat(technicalRecord2.getVehicleClass().get(1).getCode()).isEqualTo("t");
        assertThat(technicalRecord2.getVehicleClass().get(1).getDescription()).isEqualTo("trailer");
        assertThat(technicalRecord2.getVehicleClass().get(1).getVehicleSize()).isEqualTo(null);
        assertThat(technicalRecord2.getVehicleClass().get(1).getVehicleType()).isEqualTo("trl");
        assertThat(technicalRecord2.getVehicleClass().get(1).getEuVehicleCategory()).isEqualTo("o2");
        assertThat(technicalRecord2.getVehicleClass().get(1).getVehicleConfiguration()).isEqualTo("articulated");
        assertThat(technicalRecord2.getDispensations()).isEqualTo(null);
        assertThat(technicalRecord2.getGrossGbWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getLastUpdatedAt()).isEqualTo(null);
        assertThat(technicalRecord2.getTrainGbWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getUnladenWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getVariantNumber()).isEqualTo(null);
        assertThat(technicalRecord2.getEmissionsLimit()).isEqualTo(null);
        assertThat(technicalRecord2.getGrossEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getPurchaserNotes()).isEqualTo(null);
        assertThat(technicalRecord2.getSeatsLowerDeck()).isEqualTo(null);
        assertThat(technicalRecord2.getSeatsUpperDeck()).isEqualTo(null);
        assertThat(technicalRecord2.getSuspensionType()).isEqualTo("Y");
//        assertThat(technicalRecord2.getTachoExemptMrk()).isEqualTo(true);
        assertThat(technicalRecord2.getTrainEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getConversionRefNo()).isEqualTo("7891234");
        assertThat(technicalRecord2.getGrossKerbWeight()).isEqualTo(2500);
        assertThat(technicalRecord2.getManufactureYear()).isEqualTo("2018");
//        assertThat(technicalRecord2.getSpeedLimiterMrk()).isEqualTo(true);
//        assertThat(technicalRecord2.getAlterationMarker()).isEqualTo(true);
        assertThat(technicalRecord2.getCoifSerialNumber()).isEqualTo(null);
        assertThat(technicalRecord2.getFrameDescription()).isEqualTo(null);
        assertThat(technicalRecord2.getGrossLadenWeight()).isEqualTo(3000);
//        assertThat(technicalRecord2.getLoadSensingValve()).isEqualTo(true);
        assertThat(technicalRecord2.getMaxTrainGbWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getSpeedRestriction()).isEqualTo(null);
        assertThat(technicalRecord2.getStandingCapacity()).isEqualTo(null);
        assertThat(technicalRecord2.getCoifCertifierName()).isEqualTo(null);
        assertThat(technicalRecord2.getGrossDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getManufacturerNotes()).isEqualTo(null);
        assertThat(technicalRecord2.getMaxLoadOnCoupling()).isEqualTo(7000);
        assertThat(technicalRecord2.getMaxTrainEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getNumberOfSeatbelts()).isEqualTo(null);
        assertThat(technicalRecord2.getRearAxleToRearTrl()).isEqualTo(400);
        assertThat(technicalRecord2.getReasonForCreation()).isEqualTo("EU vehicle category updated");
        assertThat(technicalRecord2.getTrainDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getApprovalTypeNumber()).isEqualTo(null);
//        assertThat(technicalRecord2.getRecordCompleteness()).isEqualTo(null);
        assertThat(technicalRecord2.getFrontAxleToRearAxle()).isEqualTo(1700);
        assertThat(technicalRecord2.getMaxTrainDesignWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getNumberOfWheelsDriven()).isEqualTo(null);
        assertThat(technicalRecord2.getVariantVersionNumber()).isEqualTo(null);
//        assertThat(technicalRecord2.getAntiLockBrakingSystem()).isEqualTo(true);
//        assertThat(technicalRecord2.getDrawbarCouplingFitted()).isEqualTo(true);
        assertThat(technicalRecord2.getFrontAxleTo5thWheelMax()).isEqualTo(null);
        assertThat(technicalRecord2.getFrontAxleTo5thWheelMin()).isEqualTo(null);
//        assertThat(technicalRecord2.getDepartmentalVehicleMarker()).isEqualTo(true);
        assertThat(technicalRecord2.getCouplingCentreToRearTrlMax()).isEqualTo(null);
        assertThat(technicalRecord2.getCouplingCentreToRearTrlMin()).isEqualTo(null);
        assertThat(technicalRecord2.getCouplingCentreToRearAxleMax()).isEqualTo(null);
        assertThat(technicalRecord2.getCouplingCentreToRearAxleMin()).isEqualTo(null);
        assertThat(technicalRecord2.getFrontAxleTo5thWheelCouplingMax()).isEqualTo(null);
        assertThat(technicalRecord2.getFrontAxleTo5thWheelCouplingMin()).isEqualTo(null);
        assertThat(technicalRecord2.getCentreOfRearmostAxleToRearOfTrl()).isEqualTo(null);
        assertThat(technicalRecord2.getSeatbeltInstallationApprovalDate()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getBrakeCode()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getDataTrBrakeOne()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getDataTrBrakeTwo()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getDataTrBrakeThree()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getRetarderBrakeOne()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getRetarderBrakeTwo()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getBrakeCodeOriginal()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getParkingBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getParkingBrakeForceB()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getServiceBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getServiceBrakeForceB()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getSecondaryBrakeForceA()).isEqualTo(null);
        assertThat(technicalRecord2.getPsvBrakes().get(1).getSecondaryBrakeForceB()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getTyreCode()).isEqualTo(1234);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(0).getSpeedCategorySymbol()).isEqualTo("a7");
        assertThat(technicalRecord2.getAxles().get(0).getGbWeight()).isEqualTo("1400");
//        assertThat(technicalRecord2.getAxles().get(0).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(0).getAxleNumber()).isEqualTo("1");
//        assertThat(technicalRecord2.getAxles().get(0).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(0).getLadenWeight()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(0).getLeverLength()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(0).getDesignWeight()).isEqualTo("1800");
//        assertThat(technicalRecord2.getAxles().get(0).getBrakeActuator()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(0).getParkingBrakeMrk()).isEqualTo(true);
//        assertThat(technicalRecord2.getAxles().get(0).getSpringBrakeParking()).isEqualTo(1);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getTyreCode()).isEqualTo(5678);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(1).getSpeedCategorySymbol()).isEqualTo("a7");
        assertThat(technicalRecord2.getAxles().get(1).getGbWeight()).isEqualTo("1600");
//        assertThat(technicalRecord2.getAxles().get(1).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(1).getAxleNumber()).isEqualTo("2");
//        assertThat(technicalRecord2.getAxles().get(1).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(1).getLadenWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(1).getLeverLength()).isEqualTo("125");
        assertThat(technicalRecord2.getAxles().get(1).getDesignWeight()).isEqualTo("1900");
        assertThat(technicalRecord2.getAxles().get(1).getBrakeActuator()).isEqualTo("113");
//        assertThat(technicalRecord2.getAxles().get(1).getParkingBrakeMrk()).isEqualTo(true);
//        assertThat(technicalRecord2.getAxles().get(1).getSpringBrakeParking()).isEqualTo(1);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getTyreCode()).isEqualTo(5678);
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getTyreSize()).isEqualTo("9.23648E+11");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getPlyRating()).isEqualTo("AB");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getDataTrAxles()).isEqualTo("345");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getFitmentCode()).isEqualTo("single");
//        assertThat(technicalRecord2.getAxles().get(0).getTyres().get(2).getSpeedCategorySymbol()).isEqualTo("a7");
        assertThat(technicalRecord2.getAxles().get(2).getGbWeight()).isEqualTo("1600");
//        assertThat(technicalRecord2.getAxles().get(2).getEecWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(2).getAxleNumber()).isEqualTo("3");
//        assertThat(technicalRecord2.getAxles().get(2).getKerbWeight()).isEqualTo(null);
//        assertThat(technicalRecord2.getAxles().get(2).getLadenWeight()).isEqualTo(null);
        assertThat(technicalRecord2.getAxles().get(2).getLeverLength()).isEqualTo("125");
        assertThat(technicalRecord2.getAxles().get(2).getDesignWeight()).isEqualTo("1900");
        assertThat(technicalRecord2.getAxles().get(2).getBrakeActuator()).isEqualTo("113");
//        assertThat(technicalRecord2.getAxles().get(2).getParkingBrakeMrk()).isEqualTo(true);
//        assertThat(technicalRecord2.getAxles().get(2).getSpringBrakeParking()).isEqualTo(1);
//        assertThat(technicalRecord2.getAxles().get(0).getAxlespacing().get(0).getAxles()).isEqualTo("1-2");
//        assertThat(technicalRecord2.getAxles().get(0).getAxlespacing().get(0).getValue()).isEqualTo(1200);
//        assertThat(technicalRecord2.getAxles().get(0).getPlates().get(0)).isEqualTo(null);


        System.out.println(vehicle);

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


