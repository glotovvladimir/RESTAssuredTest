package TestFramework.files;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsableMethods {

    public static XmlPath rawToXml (Response resp){
        String respStr = resp.asString();
        XmlPath xmlPath = new XmlPath(respStr);
        return xmlPath;
    }

    public static JsonPath rawToJson (Response resp){
        String respStr = resp.asString();
        JsonPath jsPath = new JsonPath(respStr);
        return jsPath;
    }

    public static String getSessionKEY() {
        RestAssured.baseURI = "http://localhost:8080";

        Response response = given().log().all().
                header("Content-Type", "application/json").
                body(payload.getJiraAuthBody()).
                when().
                post(resources.jiraAuth()).
                then().
                assertThat().statusCode(200).
                extract().response();

        String sessionId = UsableMethods.rawToJson(response).get("session.value");
        return sessionId;
    }
}
