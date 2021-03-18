package vott;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.given;
import java.time.Duration;
import java.time.Instant;

/*

TokenService returns a new JWT token when called.
It also checks if another token was generated recently.
Returns new token only if previous token expired.

*/

public class TokenService {

    private Instant lastRefreshed;
    private AccessToken cachedToken;

    public String getBearerToken() {
        if (lastRefreshed == null || tokenHasExpired()) {
            refreshToken();
        }
        return cachedToken.getAccessToken();
    }

    private boolean tokenHasExpired() {
        return Instant.now().isAfter(lastRefreshed.plus(cachedToken.getExpiresIn()));
    }

    private void refreshToken() {
        this.lastRefreshed = Instant.now();
        this.cachedToken = getToken();
    }

    public AccessToken getToken() {

        RestAssured.baseURI = "https://login.microsoftonline.com/6c448d90-4ca1-4caf-ab59-0a2aa67d7801/oauth2/token";

        String response =
                given()//.log().all()
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
                        extract().response().asString();

        JsonPath js = new JsonPath(response);
        AccessToken accessToken = new AccessToken();
        accessToken.setAccessToken(js.get("access_token"));
        accessToken.setExpiresIn(Duration.ofSeconds(Long.parseLong(js.get("expires_in"))));
        return accessToken;
    }
}

