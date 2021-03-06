import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;

import org.junit.jupiter.api.BeforeAll;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class BaseTest {
    static Properties properties = new Properties();
    static String token;
    static String id;
    static String v;

    @BeforeAll
    static void beforeAll(){
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.filters(new AllureRestAssured());
        getProperties();
        token = properties.getProperty("token");
        id = properties.getProperty("id");
        v = properties.getProperty("v");
    }
    private static void getProperties(){
        try(InputStream output = new FileInputStream("src/test/resources/application.properties")) {
          properties.load(output);
        }
        catch (IOException e){
            e.printStackTrace();

        }
    }

}
