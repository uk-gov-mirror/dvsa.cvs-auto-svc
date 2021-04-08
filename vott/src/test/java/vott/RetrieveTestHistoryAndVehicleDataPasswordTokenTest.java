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
        String idReturnedInApiResponse = js.getString("id");
        String systemNumberReturnedInApiResponse = js.getString("system_number");
        String vinReturnedInApiResponse = js.getString("vin");
        String vrmTrmReturnedInApiResponse = js.getString("vrm_trm");
        String trailerIdReturnedInApiResponse = js.getString("trailer_id");
        String createdAtReturnedInApiResponse = js.getString("createdAt");

        assertThat(vinReturnedInApiResponse).isEqualTo(validVINNumber);
        System.out.println("ID returned in API response is: " + idReturnedInApiResponse);
        System.out.println("System Number in API response is: " + systemNumberReturnedInApiResponse);
        System.out.println("Vin number sent: " + validVINNumber + ". Returned vin in API response is: " + vinReturnedInApiResponse);
        System.out.println("VRM TRM in API response is: " + vrmTrmReturnedInApiResponse);
        System.out.println("Trailer ID in API response is: " + trailerIdReturnedInApiResponse);
        System.out.println("Created at: " + createdAtReturnedInApiResponse);

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


