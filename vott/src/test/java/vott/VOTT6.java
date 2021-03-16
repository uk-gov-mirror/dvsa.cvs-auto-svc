package vott;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import com.amazonaws.auth.BasicSessionCredentials;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

public class VOTT6 {

    //Setup
    String bearerToken;

//    public String GetBearerToken () {
//
//
//
//    }

//    @Before
//    public void BeforeEachTest () {
//
//        bearerToken = GetBearerToken();
//
//
//    }

    @Test
    public void vott6Tests() throws IOException {


        //enter jwtEndpoint to hit - replace "/jwtEndpoint" with real jwtEndpoint when ready
//        String jwtEndpoint = "https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token";

//        String grant_type = "password";
//        String userName = "cvs.automation1@dvsagov.onmicrosoft.com";
//        String password = "*7vU4EWuJPwues_nGKBMaaNYVC3434";
//        String resource = "11be8c44-22f5-43bf-b9bb-50467a26cfa7";
//        String client_id = "11be8c44-22f5-43bf-b9bb-50467a26cfa7";
//        String access_token = null;


//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get("/Hyderabad");

//        // Retrieve the body of the Response
//        ResponseBody body = response.getBody();

        // By using the ResponseBody.asString() method, we can convert the  body
        // into the string representation.
//        System.out.println("Response Body is: " + body.asString());

//        URL url = new URL("https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token");
//        HttpsURLConnection con = (HttpsURLConnection)url.openConnection();
//        InputStreamReader reader = new InputStreamReader(con.getInputStream());

        //what data to update
//        String jwtPayload = "{\n" +
//                "\"grant_type\": \"password\",\n" +
//                "\"userName\": \"cvs.automation1@dvsagov.onmicrosoft.com\",\n" +
//                "\"password\": \"*7vU4EWuJPwues_nGKBMaaNYVC3434\",\n" +
//                "\"resource\": \"11be8c44-22f5-43bf-b9bb-50467a26cfa7\"\n" +
//                "\"client_id\": \"11be8c44-22f5-43bf-b9bb-50467a26cfa7\"\n" +
//                "}";

//        RequestSpecification request = RestAssured.given().log().all().config(RestAssured.config()
//                .encoderConfig(EncoderConfig.encoderConfig()
//                        .encodeContentTypeAs("x-www-form-urlencoded",
//                                ContentType.URLENC)))
//                .contentType("x-www-form-urlencoded")
//                .formParam("grant_type", "password")
//                .formParam("userName", "cvs.automation1@dvsagov.onmicrosoft.com")
//                .formParam("password", "*7vU4EWuJPwues_nGKBMaaNYVC3434")
//                .formParam("resource", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .formParam("client_id", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .header("accept", "application/json")
//                .request();

//        Unirest.setTimeouts(0, 0);
//        HttpResponse<String> response = Unirest.post("https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Cookie", "x-ms-gateway-slice=prod; stsservicecookie=ests; fpc=Aucx3RIVu1NLoby9bZJIGKN5H5U3AQAAAAFU3dcOAAAA")
//                .field("grant_type", "password")
//                .field("userName", "cvs.automation1@dvsagov.onmicrosoft.com")
//                .field("password", "*7vU4EWuJPwues_nGKBMaaNYVC3434")
//                .field("resource", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .field("client_id", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .asString();

//        HttpResponse<String> jwtPayload = Unirest.post("https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token")
//                .header("Content-Type", "application/x-www-form-urlencoded")
//                .header("Cookie", "x-ms-gateway-slice=prod; stsservicecookie=ests; fpc=Aucx3RIVu1NLoby9bZJIGKN5H5U3AQAAAH1Q3dcOAAAA")
//                .field("grant_type", "password")
//                .field("userName", "cvs.automation1@dvsagov.onmicrosoft.com")
//                .field("password", "*7vU4EWuJPwues_nGKBMaaNYVC3434")
//                .field("resource", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .field("client_id", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
//                .asString();

        RestAssured.baseURI = "https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token";
        //setup payload
        given()
                .formParam("grant_type", "password")
                .formParam("userName", "cvs.automation1@dvsagov.onmicrosoft.com")
                .formParam("password", "*7vU4EWuJPwues_nGKBMaaNYVC3434")
                .formParam("resource", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
                .formParam("client_id", "11be8c44-22f5-43bf-b9bb-50467a26cfa7").

                //send request
                        when().
                //log().all().
                        post().

                //verification
                        then().
                log().all().

                //check status code to be 200 (OK) (get detailed list of status codes)
                        statusCode(200);

        //TODO Set an insert to test different file types, system error handling
//        BasicSessionCredentials temporaryCredentials =
//                new BasicSessionCredentials(
//                        assumeResult.getCredentials().getAccessKeyId(),
//                        assumeResult.getCredentials().getSecretAccessKey(),
//                        assumeResult.getCredentials().getSessionToken());
//        String bucketName = loader.getS3Bucket();


//        RequestSpecification httpRequest = RestAssured.given();
//        Response response = httpRequest.get("https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token");
//        JsonPath jsonPathEvaluator = response.jsonPath();
//        System.out.println(response);
//        String access_token1 = jsonPathEvaluator.get("access_token");
















//        BufferedReader in = new BufferedReader(reader);
//        String json = in.readLine();
//        Gson gson = new Gson();
//        Type mapType  = new TypeToken<Map<String,String>>(){}.getType();
//        Map<String,String> ser = gson.fromJson(json, mapType);
//        String accessToken = ser.get("access_token");
//        System.out.println("Access Token = " + accessToken);
//            path(access_token)

//            //check status message = "success"
//            body("status", equalTo("success")).
//
//            //check message = "All good! Record has been updated." - Message has to be exact, including punctuation.
//            body("message", equalTo("All good! Record has been updated."))
        ;
    }


}


