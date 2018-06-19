package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics {

    Properties prop = new Properties();
    private static Logger log = LogManager.getLogger(addAndDeletePlace.class.getName());

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
    public void getPlaceTest() {

        RestAssured.baseURI = prop.getProperty("HOST");

        given().
                param("location", "51.5220335,45.9912112").
                param("radius", "1000").
                param("keyword", "train").
                param("key", prop.getProperty("KEY")).
                when().
                get(resources.placeGetData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("results[0].name", equalTo("Railway station \"Astrakhan crossing\"")).
                and().body("results[0].place_id", equalTo("ChIJn0yc-BHHFEER58w4PDYNWik")).
                and().header("Server", "scaffolding on HTTPServer2");
    }
}
