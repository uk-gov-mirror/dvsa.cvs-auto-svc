package vott;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import net.thucydides.core.annotations.Title;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Base64;

public class DownloadMotCertificateAsPdfTest {

    // Variable + Constant Test Data Setup
    private String token;
    private final String xApiKey = "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19156";
    private final String validVINNumber = "T12765432";
    private final String validTestNumber = "W01A00229";

    private final String invalidVINNumber = "T12765431";
    private final String invalidTestNumber = "W01A00222";

    @Before
    public void Setup() {

        this.token = new TokenService().getBearerToken();
        RestAssured.baseURI = "https://api.develop.cvs.dvsacloud.uk/cvsb-19156/v1/document-retrieval";
    }

    @Title("CVSB-19156 - Happy Path for document retrieval API")
    @Test
    public void DownloadTestCertificateTest() {

        System.out.println("Valid access token: " + token);

        //Retrieve and save test certificate (pdf) as byteArray
        byte[] pdf =
            given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

            //send request
            when().//log().all().
                get().

            //verification
            then().//log().all().
                statusCode(200).
                extract().response().asByteArray();

        //Save file in resources folder
        File file = new File("src/test/resources/DownloadedMotTestCertificates/TestCert.pdf");

        //Decode downloaded pdf
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] decoder = Base64.getDecoder().decode(pdf);
            fos.write(decoder);
            //Todo Look at test logging
            System.out.println("PDF File Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Open downloaded pdf file in system default pdf viewer
        if (Desktop.isDesktopSupported()) {
            try {
                File myFile = new File("src/test/resources/DownloadedMotTestCertificates/TestCert.pdf");
                Desktop.getDesktop().open(myFile);
            } catch (FileNotFoundException ex) {
                System.out.println("File not found" + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("No application registered for PDFs" + ex.getMessage());
            }
        }
    }

    @Test
    public void DownloadTestCertificateBadJwtTokenTest() {

        System.out.println("Using invalid token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token + 1)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", validVINNumber)
            .queryParam("testNumber", validTestNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(403).
            body("message", equalTo("User is not authorized to access this resource with an explicit deny"));
    }

    @Test
    public void DownloadTestCertificateNoJwtTokenTest() {

        //prep request
        given()//.log().all()
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(401).
                body("message", equalTo("Unauthorized"));
    }

    @Test
    public void DownloadTestCertificateNoVinNumberTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("testNumber", validTestNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(400);
    }

    @Test
    public void DownloadTestCertificateNoTestNumberTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", validVINNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(400);
    }

    @Test
    public void DownloadTestCertificateNoAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("content-type", "application/pdf")
            .queryParam("testNumber", validTestNumber)
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
    public void DownloadTestCertificateInvalidAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey + "badkey")
            .header("content-type", "application/pdf")
            .queryParam("testNumber", validTestNumber)
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
    public void DownloadTestCertificateTestNumberDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", validVINNumber)
            .queryParam("testNumber", invalidTestNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(404).
            body(equalTo("NoSuchKey"));
    }

    @Test
    public void DownloadTestCertificateNumericTestNumberTest() {

        System.out.println("Using valid token: " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", "123456789").

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(400).
                body(equalTo("Certificate number is in incorrect format"));
    }

    @Test
    public void DownloadTestCertificateVinNumberDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", xApiKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", invalidVINNumber)
            .queryParam("testNumber", validTestNumber).

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(404).
            body(equalTo("NoSuchKey"));
    }

    @Test
    public void DownloadTestCertificateVinNumberSpecialCharsTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", "T12765@!'") //https://www.oreilly.com/library/view/java-cookbook/0596001703/ch03s12.html
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(400).
                body(equalTo("VIN not supplied"));
    }

    @Test
    public void DownloadTestCertificateTestNumberSpecialCharsTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber) //https://www.oreilly.com/library/view/java-cookbook/0596001703/ch03s12.html
                .queryParam("testNumber", "123Abc@!/").

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(400).
                body(equalTo("Certificate number is in incorrect format"));
    }

    @Test
    public void DownloadTestCertificatePostRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                post().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("'"+ token + "' not a valid key=value pair (missing equal-sign) in Authorization header: 'Bearer " + token + "'.")); //todo change message assert, returned by authoriser it's not getting to lambda
    }

    @Test
    public void DownloadTestCertificatePutRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                put().
                //verification
                        then().//log().all().
                statusCode(400).
                body("message", equalTo("Forbidden")); //todo check why and where this xml message comes from as it is not from cert retrieval lambda
    }

    @Test
    public void DownloadTestCertificatePatchRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                patch().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("'"+ token + "' not a valid key=value pair (missing equal-sign) in Authorization header: 'Bearer " + token + "'.")); //todo change message assert, returned by authorizer it's not getting to lambda
    }

    @Test
    public void DownloadTestCertificateDeleteRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", xApiKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", validVINNumber)
                .queryParam("testNumber", validTestNumber).

                //send request
                        when().//log().all().
                delete().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("'"+ token + "' not a valid key=value pair (missing equal-sign) in Authorization header: 'Bearer " + token + "'.")); //todo change message assert, returned by authoriser it's not getting to lambda
    }

}

