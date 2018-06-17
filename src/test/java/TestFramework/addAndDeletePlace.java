package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class addAndDeletePlace {

    Properties prop = new Properties();
    private static Logger log = LogManager.getLogger(addAndDeletePlace.class.getName());

    @BeforeTest
    public void getData() {
        try {
            FileInputStream fis = new FileInputStream("src\\test\\java\\TestFramework\\files\\env.properties");
            prop.load(fis);
            log.debug("wert");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void addAndDeletePlace() {

        RestAssured.baseURI = prop.getProperty("HOST");

        Response response = given().log().all().
                queryParam("key", prop.getProperty("KEY")).and().
                body(payload.getPostBody()).
                when().
                post(resources.placePostData()).
                then().log().all().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("scope", equalTo("APP")).
                extract().response();

        String placeId = UsableMethods.rawToJson(response).get("place_id");

        given().log().all().
                queryParam("key", prop.getProperty("KEY")).
                and().body(String.format(payload.getDeleteBody(), placeId)).
                when().
                post(resources.placeDeleteData()).
                then().log().all().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("status", equalTo("OK"));
    }
}

