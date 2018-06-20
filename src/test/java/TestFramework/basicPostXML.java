package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class basicPostXML {

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
    public void postPlaceXML() {
        String postData = null;
        try {
            postData = generateStringFromResource(resources.pathXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
        RestAssured.baseURI = prop.getProperty("HOST");

        Response response = given().
                queryParam("key", prop.getProperty("KEY")).and().
                body(postData).
                when().
                post(resources.placePostDataXML()).
                then().assertThat().statusCode(200).and().contentType(ContentType.XML).
                extract().response();

        String place_id = UsableMethods.rawToXml(response).get("PlaceAddResponse.place_id");
    }

    public String generateStringFromResource (String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
