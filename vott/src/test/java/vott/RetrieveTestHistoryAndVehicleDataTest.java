package vott;

import io.restassured.RestAssured;
import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RetrieveTestHistoryAndVehicleDataTest {

    // Variable + Constant Test Data Setup
    private String token;
    private final String xApiKey = "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19156";
    private final String validVINNumber = "T12765432";
    private final String validTestNumber = "W01A00229";

    private final String invalidVINNumber = "T12765431";
    private final String invalidTestNumber = "W01A00222";

    @Before
    public void Setup() {

        this.token = new TokenService().getBearerToken("password");
        RestAssured.baseURI = "https://api.develop.cvs.dvsacloud.uk/cvsb-19156/v1/document-retrieval";
    }

    @Title("CVSB-19222 - Happy Path for vehicle data and test history retrieval")
    @Test
    public void RetrieveVehicleDataAndTestHistoryTest() {

        System.out.println("Valid access token: " + token);

        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", "T12765432")
                .queryParam("VehicleRegMark", "AB15XYZ").

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(200);
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryBadJwtTokenTest() {

        System.out.println("Using invalid token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token + 1)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765432")
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
    public void RetrieveVehicleDataAndTestHistoryNoVinNumberTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("VehicleRegMark", "AB15XYZ").

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(400);
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryNoVehicleRegMarkTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765432").

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(400);
    }

    @Test
    public void RetrieveVehicleDataAndTestHistoryNoAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("content-type", "application/pdf")
            .queryParam("VehicleRegMark", "AB15XYZ")
            .queryParam("vinNumber", "T12765432").

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
            .header("content-type", "application/pdf")
            .queryParam("VehicleRegMark", "AB15XYZ")
            .queryParam("vinNumber", "T12765432").

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
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765432")
            .queryParam("VehicleRegMark", "AB15XYZ").

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
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765431")
            .queryParam("VehicleRegMark", "AB15XYZ").

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
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", "T12765431")
                .queryParam("testNumber", "W01A00229").

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(404).
                body(equalTo("NoSuchKey"));
    }

}


