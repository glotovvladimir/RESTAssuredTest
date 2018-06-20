package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Basics5 {

    Properties prop = new Properties();

    @BeforeTest
    public void getData() {
        try {
            FileInputStream fis = new FileInputStream("/Users/vglotov/git/RestAPICourse/RESTAssuredTest/src/test/java/TestFramework/files/env.properties");
            prop.load(fis);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void extractingNames() {

        RestAssured.baseURI = prop.getProperty("HOST");

        Response resp = given().log().body().
                param("location", "51.5220335,45.9912112").
                param("radius", "1000").
                param("keyword", "train").
                param("key", prop.getProperty("KEY")).
                when().
                get(resources.placeGetData()).
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).
                and().body("results[0].name", equalTo("Railway station \"Astrakhan crossing\"")).
                and().body("results[0].place_id", equalTo("ChIJn0yc-BHHFEER58w4PDYNWik")).
                and().header("Server", "scaffolding on HTTPServer2").
                extract().response();

        JsonPath jsonPath = UsableMethods.rawToJson(resp);
        int count = jsonPath.get("results.size()");
        for (int i = 0; i < count; i++) {
            System.out.println(i+1 + ": " + jsonPath.get("results.get(" + i + ").name"));
        }
    }
}
