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

    private String token;
    private String APIKey = "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19156";

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
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", "T12765432")
                .queryParam("testNumber", "W01A00229").

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
            .header("x-api-key", APIKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765432")
            .queryParam("testNumber", "W01A00229").

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
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf")
                .queryParam("vinNumber", "T12765432")
                .queryParam("testNumber", "W01A00229").

                //send request
                        when().//log().all().
                get().

                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("Missing Authentication Token"));
    }

    @Test
    public void DownloadTestCertificateNoVinNumberTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", APIKey)
            .header("content-type", "application/pdf")
            .queryParam("testNumber", "W01A00229").

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
            .header("x-api-key", APIKey)
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
    public void DownloadTestCertificateNoAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("content-type", "application/pdf")
            .queryParam("testNumber", "W01A00229")
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
    public void DownloadTestCertificateInvalidAPIKeyTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", APIKey + "badkey")
            .header("content-type", "application/pdf")
            .queryParam("testNumber", "W01A00229")
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
    public void DownloadTestCertificateTestNumberDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", APIKey)
            .header("content-type", "application/pdf")
            .queryParam("vinNumber", "T12765432")
            .queryParam("testNumber", "W01A00222").

        //send request
        when().//log().all().
            get().

        //verification
        then().//log().all().
            statusCode(404).
            body(equalTo("NoSuchKey"));
    }

    @Test
    public void DownloadTestCertificateVinNumberDoesntExistTest() {

        System.out.println("Valid access token: " + token);

        //prep request
        given()//.log().all()
            .header("authorization", "Bearer " + token)
            .header("x-api-key", APIKey)
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

        //TODO add control chars test i.e. ctrl+c etc.
    }

    @Test
    public void CertificateRetrievalPostRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf").

                //send request
                        when().//log().all().
                post().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("Forbidden"));
    }

    @Test
    public void CertificateRetrievalPutRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf").

                //send request
                        when().//log().all().
                put().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("Forbidden"));
    }

    @Test
    public void CertificateRetrievalPatchRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf").

                //send request
                        when().//log().all().
                patch().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("Forbidden"));
    }

    @Test
    public void CertificateRetrievalDeleteRequestTest() {

        System.out.println("Valid access token " + token);

        //prep request
        given()//.log().all()
                .header("authorization", "Bearer " + token)
                .header("x-api-key", APIKey)
                .header("content-type", "application/pdf").

                //send request
                        when().//log().all().
                delete().
                //verification
                        then().//log().all().
                statusCode(403).
                body("message", equalTo("Forbidden"));
    }
}


