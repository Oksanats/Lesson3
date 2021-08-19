import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class UserDataTest extends BaseTest{
    @Test
    void getAccountIdTest(){

        given()
                .header("Authorization",token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.vk.com/method/users.get?user_id={id}&v=5.52",id)
                .prettyPeek()
                .then()
                .statusCode(200);
    }

}
