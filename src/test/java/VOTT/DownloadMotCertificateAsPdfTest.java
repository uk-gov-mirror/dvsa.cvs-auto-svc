package vott;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Base64;

public class DownloadMotCertificateAsPdfTest {

    private String token;

    @Before
    public void Setup() {
        this.token = new TokenService().getBearerToken();
    }

    @Test
    public void DownloadCertificateHappyPath() {

        RestAssured.baseURI = "https://api.develop.cvs.dvsacloud.uk/cvsb-19156/v1/document-retrieval";

        System.out.println("Valid access token" + token);

        //Retrieve and save test certificate (pdf) as byteArray
        byte[] pdf =
                given().log().all()
                        .header("authorization", "Bearer " + token)
                        .header("x-api-key", "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19156")
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

        //Downloaded pdfs are encoded in b64
        //b64 decoder
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] decoder = Base64.getDecoder().decode(pdf);
            fos.write(decoder);
            System.out.println("PDF File Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void DownloadCertificateSadPath() {

        RestAssured.baseURI = "https://api.develop.cvs.dvsacloud.uk/cvsb-19156/v1/document-retrieval";

        System.out.println("Using invalid token" + token);

        given()//.log().all()
            .header("authorization", "Bearer " + token + 1)
            .header("x-api-key", "YTRasdsadADSDEQ01asdasdasbd67845FDGGDGvww-cvsb-19156")
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
}


