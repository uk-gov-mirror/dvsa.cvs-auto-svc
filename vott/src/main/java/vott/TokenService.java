package vott;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import java.time.Duration;
import java.time.Instant;

public class TokenService {

    private Instant lastRefreshed;
    private AccessToken cachedToken;

    public String getBearerToken(String accessType) {
        if (lastRefreshed == null || tokenHasExpired()) {
            refreshToken(accessType);
        }
        return cachedToken.getAccessToken();
    }

    private boolean tokenHasExpired() {
        return Instant.now().isAfter(lastRefreshed.plus(cachedToken.getExpiresIn()));
    }

    private void refreshToken(String accessType) {
        this.lastRefreshed = Instant.now();
        if (accessType == "password"){
            this.cachedToken = getTokenPassword();
        } else {
            this.cachedToken = getTokenClientCredentials();
        }
    }

    public AccessToken getTokenPassword() {

        RestAssured.baseURI = "https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token";

        String response =
                given()//log().all().
                        .formParam("grant_type", "password")
                        .formParam("userName", "cvs.automation1@dvsagov.onmicrosoft.com")
                        .formParam("password", "*7vU4EWuJPwues_nGKBMaaNYVC3434")
                        .formParam("resource", "11be8c44-22f5-43bf-b9bb-50467a26cfa7")
                        .formParam("client_id", "11be8c44-22f5-43bf-b9bb-50467a26cfa7").

                //send request
                when().
                        post().

                //verification
                then().//log().all().
                        statusCode(200).
                        extract().response()
                        .asString();

        JsonPath js = new JsonPath(response);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(js.get("access_token"));
        accessToken.setExpiresIn(Duration.ofSeconds(Long.parseLong(js.get("expires_in"))));
        return accessToken;
    }

    public AccessToken getTokenClientCredentials() {

        RestAssured.baseURI = "https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/v2.0/token";

        String response =
                given()//.log().all()
                        .formParam("grant_type", "client_credentials")
                        .formParam("scope", "https://dev.vta.dvsatest-cloud.uk/.default")
                        .formParam("client_secret", "eU9QK2.WixG5Io-17-~Pv_RJ3cZkCm_kke")
                        .formParam("client_id", "8b897993-7cb9-48f2-a66f-5cb6092d2d80").

                        //send request
                                when().
                        post().

                        //verification
                                then().//log().all().
                        statusCode(200).
                        extract().response().asString();

        JsonPath js = new JsonPath(response);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(js.get("access_token"));
        //accessToken.setExpiresIn(Duration.ofSeconds(Long.parseLong(js.get("expires_in"))));
        return accessToken;
    }
}

