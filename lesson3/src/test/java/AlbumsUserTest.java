
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;



import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class AlbumsUserTest extends BaseTest {


    @Test
    void getCountAlbumsTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response", is(18))
                .when()
                .get("https://api.vk.com/method/photos.getAlbumsCount?user_id=3136586&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37&v=5.131")
                .prettyPeek()
                .then()
                .statusCode(200);
    }


    @Test
    void getAlbumsTest() {

        given()
                .header("Authorization", token)
                .expect()
                .body("response.count", is(18))
                .body("response.items[0].title", is("Крым. "))
                .when()
                .get("https://api.vk.com/method/photos.getAlbums?" +
                        "access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&owner_id=3136586&album_ids=&offset=&" +
                        "count=18&v=5.131&need_system=0")
                .prettyPeek()
                .then()
                .statusCode(200);
    }


}
