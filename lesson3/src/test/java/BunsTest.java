import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class BunsTest extends BaseTest{
    static String idBunAccount;



    @Test
    void getBannedTest() {
        idBunAccount = given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.vk.com/method/account.getBanned?" +
                        "count=5&" +
                        "access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v={v}", v)
                .prettyPeek()
                .then()
                //.statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("response.profiles[1].id");
        System.out.println(idBunAccount);
    }
    @Test
    void unBunTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response", is(1))
                .when()
                .get("https://api.vk.com/method/account.unban?owner_id={idBun}" +
                        "&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v={v}",idBunAccount,v)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void bunTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response", is(1))
                .when()
                .get("https://api.vk.com/method/account.ban?owner_id={idBun}&" +
                        "access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v={v}",idBunAccount,v)
                .prettyPeek()
                .then()
                .statusCode(200);
    }












}
