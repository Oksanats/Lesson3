import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class MyAlbumTest extends BaseTest{
    static String idAlbum;



    @Test
    void createAlbumTest() {
        idAlbum = given()
                .header("Authorization", token)
                .log()
                .method()
                .log()
                .uri()
                .when()
                .get("https://api.vk.com/method/photos.createAlbum?" +
                        "title=testAlbum&description=test&privacy_view=all&privacy_comment=" +
                        "all&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37" +
                        "&v=5.131")
                .prettyPeek()
                .then()
                //.statusCode(200)
                .extract()
                .response()
                .jsonPath()
                .getString("response.id");
        System.out.println(idAlbum);


    }

    @AfterEach
    void deleteAlbumTest() {
        given()
                .header("Authorization", token)
                .when()
                .get("https://api.vk.com/method/photos.deleteAlbum?album_id={deleteAlbumId}&access_token=1bd3f9dbef2385e35aec023addf556a5d6cb1a059cdbd64f138681ee546be44ed3e9322140581e9e11e37&v=5.131",idAlbum)
                .prettyPeek()
                .then()
                .statusCode(200);



    }

}
