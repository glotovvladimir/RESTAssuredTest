package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class basic2Post {

    Properties prop = new Properties();

    @BeforeTest
    public void getData() {
        try {
            FileInputStream fis = new FileInputStream("src\\test\\java\\TestFramework\\files\\env.properties");
            prop.load(fis);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void createPlace() {
        RestAssured.baseURI = prop.getProperty("HOST");

        given().
                queryParam("key", prop.getProperty("KEY")).and().
                body(payload.getPostBody()).
                when().
                post(resources.placePostData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("status", equalTo("OK")).
                and().body("scope", equalTo("APP"));
    }
}
