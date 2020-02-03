package vehicle;

import data.GenericData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import junit.framework.TestCase;
import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.core.annotations.WithTag;
import net.thucydides.junit.annotations.TestData;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import steps.VehicleTechnicalRecordsSteps;
import util.BasePathFilter;
import util.JsonPathAlteration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static io.restassured.RestAssured.given;
import static util.WriterReader.saveUtils;

@RunWith(SerenityParameterizedRunner.class)
public class PutVehicleUpdateHgvFields extends TestCase {

    static String randomVin;

    @BeforeClass
    public static void createRecord() {
        // TEST SETUP
        // generate random Vin
        randomVin = GenericData.generateRandomVin();
        // generate random Vrm
        String randomVrm = GenericData.generateRandomVrm();
        // read post request body from file
        String postRequestBodyHgv = GenericData.readJsonValueFromFile("technical-records_hgv_all_fields.json", "$");
        // create alteration to change Vin in the post request body with the random generated Vin
        JsonPathAlteration alterationVin = new JsonPathAlteration("$.vin", randomVin, "", "REPLACE");
        // create alteration to change primary vrm in the request body with the random generated primary vrm
        JsonPathAlteration alterationVrm = new JsonPathAlteration("$.primaryVrm", randomVrm, "", "REPLACE");

        // initialize the alterations list with both declared alterations
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(alterationVin, alterationVrm));

        String alteredBody = GenericData.applyJsonAlterations(postRequestBodyHgv, alterations);
        Response response = given().filters(new BasePathFilter())
                .contentType(ContentType.JSON)
                .body(alteredBody)
                .log().method().log().uri().log().body()
                .post("/vehicles");

        if (response.getStatusCode() == 401 || response.getStatusCode() == 403) {
            saveUtils();
            response = given().filters(new BasePathFilter())
                    .contentType(ContentType.JSON)
                    .body(alteredBody)
                    .log().method().log().uri().log().body()
                    .post("/vehicles");
        }

        Assert.assertEquals(201, response.getStatusCode());
    }

    @Steps
    VehicleTechnicalRecordsSteps vehicleTechnicalRecordsSteps;

    @TestData
    public static Collection<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {"$.techRecord[1].axles[0].parkingBrakeMrk", true},
//                {"$.techRecord[1].axles[0].tyres.dataTrAxles", 1},
//                {"$.techRecord[1].axles[0].tyres.fitmentCode", "double"},
//                {"$.techRecord[1].axles[0].tyres.plyRating", "rating"},
//                {"$.techRecord[1].axles[0].tyres.tyreCode", 463},
//                {"$.techRecord[1].axles[0].tyres.tyreSize", "11-21.5"},
//                {"$.techRecord[1].axles[0].weights.designWeight", "6500"},
//                {"$.techRecord[1].axles[0].weights.eecWeight", "6500"},
//                {"$.techRecord[1].axles[0].weights.gbWeight", "6100"},
//                {"$.techRecord[1].bodyType.description", "single decker"},
//                {"$.techRecord[1].brakes.dtpNumber", "3798B"},
//                {"$.techRecord[1].conversionRefNo", "refNo"},
//                {"$.techRecord[1].dimensions.axleSpacing[0].axles", "2-1"},
//                {"$.techRecord[1].dimensions.axleSpacing[0].value", "11000"},
//                {"$.techRecord[1].drawbarCouplingFitted", true},
//                {"$.techRecord[1].euroStandard", "3"},
//                {"$.techRecord[1].fuelPropulsionSystem", "Hybrid"},
//                {"$.techRecord[1].frontAxleToRearAxle", 2000},
//                {"$.techRecord[1].frontAxleToRearAxle", 2000},
//                {"$.techRecord[1].frontAxleToRearAxle", 2000},
//                {"$.techRecord[1].frontAxleToRearAxle", 2000},
//                {"$.techRecord[1].frontAxleToRearAxle", 2000},
//                {"$.techRecord[1].functionCode", "B"},
//                {"$.techRecord[1].grossDesignWeight", 20000},
//                {"$.techRecord[1].grossGbWeight", 20000},
//                {"$.techRecord[1].grossEecWeight", 20000},
//                {"$.techRecord[1].make", "Chevy"},
//                {"$.techRecord[1].manufactureYear", 2000},
//                {"$.techRecord[1].maxTrainDesignWeight", 10000},
//                {"$.techRecord[1].maxTrainEecWeight", 10000},
//                {"$.techRecord[1].maxTrainGbWeight", 10000},
//                {"$.techRecord[1].model", "Mustang"},
//                {"$.techRecord[1].noOfAxles", 2},
//                {"$.techRecord[1].notes", "notes"},
//                {"$.techRecord[1].ntaNumber", "0000514900"},
//                {"$.techRecord[1].reasonForCreation", "no reason"},
//                {"$.techRecord[1].regnDate", 2000},
//                {"$.techRecord[1].roadFriendly", true},
//                {"$.techRecord[1].speedLimiterMrk", true},
//                {"$.techRecord[1].tachoExemptMrk", true},
//                {"$.techRecord[1].trainDesignWeight", 50000},
//                {"$.techRecord[1].trainGbWeight", 40000},
//                {"$.techRecord[1].trainEecWeight", 20000},
//                {"$.techRecord[1].tyreUseCode", "2A"},
//                {"$.techRecord[1].offRoad", true},
//                {"$.techRecord[1].numberOfWheelsDriven", 6},
//                {"$.techRecord[1].euVehicleCategory", "m2"},
//                {"$.techRecord[1].emissionsLimit", 100},
//                {"$.techRecord[1].departmentalVehicleMarker", true},
//                {"$.techRecord[1].alterationMarker", true},
//                {"$.techRecord[1].approvalType", "ECTA"},
//                {"$.techRecord[1].approvalTypeNumber", "123456"},
//                {"$.techRecord[1].variantNumber", "123456"},
//                {"$.techRecord[1].variantVersionNumber", "123"},
//                {"$.techRecord[1].applicantDetails.address1", "**"},
//                {"$.techRecord[1].applicantDetails.address1", "**"},
//                {"$.techRecord[1].applicantDetails.address1", "**"},
//                {"$.techRecord[1].applicantDetails.name", "**"},
//                {"$.techRecord[1].applicantDetails.postCode", "**"},
//                {"$.techRecord[1].applicantDetails.postTown", "**"},
//                {"$.techRecord[1].applicantDetails.telephoneNumber", "**"},
//                {"$.techRecord[1].applicantDetails.emailAddress", "**"},
//                {"$.techRecord[1].microfilm.microfilmDocumentType", "PSV Miscellaneous"},
//                {"$.techRecord[1].microfilm.microfilmRollNumber", "1234"},
//                {"$.techRecord[1].microfilm.microfilmSerialNumber", "123456"},
//                {"$.techRecord[1].plates[0].plateSerialNumber", "12345"},
//                {"$.techRecord[1].plates[0].plateIssueDate", "2030-12-31"},
//                {"$.techRecord[1].plates[0].plateReasonForIssue", "no reason"},
//                {"$.techRecord[1].plates[0].plateIssuer", "dvsa"},
//                {"$.techRecord[1].vehicleClass.description", "skeletal"},
//                {"$.techRecord[1].vehicleConfiguration", "rigid"}
        });
    }

    private final String jsonPath;
    private final Object value;


    public PutVehicleUpdateHgvFields(String jsonPath, Object value) {
        this.jsonPath = jsonPath;
        this.value = value;
    }

    @WithTag("Vtm")
    @Title("CVSB-10209 - AC3 - HGV vehicle is updated, and the appropriate attributes are automatically set")
    @Test
    public void testVehicleTechnicalRecordsGetAllHgvAttributes() {
        String putRequestBodyHgv = GenericData.readJsonValueFromFile("technical-records_hgv_all_fields.json", "$");
        JsonPathAlteration removeAxle = new JsonPathAlteration("$.techRecord[0].axles[1]", "","","DELETE");
        JsonPathAlteration removeAxleSpacing = new JsonPathAlteration("$.techRecord[0].dimensions.axleSpacing[1]", "","","DELETE");
        JsonPathAlteration changeUserId = new JsonPathAlteration("$.msUserDetails.msOid", "123456", "", "REPLACE");
        JsonPathAlteration changeUser = new JsonPathAlteration("$.msUserDetails.msUser", "dragos", "", "REPLACE");
        JsonPathAlteration updateField = new JsonPathAlteration(jsonPath, value, "", "REPLACE");
        List<JsonPathAlteration> alterations = new ArrayList<>(Arrays.asList(removeAxle, removeAxleSpacing, changeUser, changeUserId, updateField));
        vehicleTechnicalRecordsSteps.putVehicleTechnicalRecordsForVehicleWithAlterations(randomVin, putRequestBodyHgv, alterations);
        vehicleTechnicalRecordsSteps.statusCodeShouldBe(200);
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("techRecord.size()", 2);
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("techRecord[0].statusCode", "archived");
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("techRecord[1].statusCode", "provisional");
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("$.techRecord[0].axles.size()", 1);
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("$.techRecord[0].dimensions.axleSpacing.size()", 1);
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("$.techRecord[0].lastUpdatedByID", "123456");
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("$.techRecord[0].lastUpdatedByName", "dragos");
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe("$.techRecord[0].updateType", "techRecordUpdate");
        vehicleTechnicalRecordsSteps.valueForFieldInPathShouldBe(jsonPath, value);
    }
}
