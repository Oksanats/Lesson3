import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class StatusTest extends BaseTest{

    @Test
    void getStatusTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response.text", is("test"))
                .when()
                .get("https://api.vk.com/method/status.get?user_id={id}" +
                        "&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v={v}",id,v)
                .prettyPeek()
                .then()
                .statusCode(200);
    }
    @Test
    void setStatusTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response", is(1))
                .when()
                .get("https://api.vk.com/method/status.set?text=test" +
                        "&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v={v}",v)
                .prettyPeek()
                .then()
                .statusCode(200);
    }



}
