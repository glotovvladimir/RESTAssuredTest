package TestFramework;

import TestFramework.files.UsableMethods;
import TestFramework.files.payload;
import TestFramework.files.resources;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static io.restassured.RestAssured.given;

public class JIRAApi {

    @Test
    public void JiraApiCreateIssue() {

        Response res = given().log().all().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + UsableMethods.getSessionKEY()).
                body(payload.getJiraAddIssiueBody()).
                when().
                post(resources.jiraAddIssue()).
                then().log().all().
                assertThat().statusCode(201).extract().response();

        String id = UsableMethods.rawToJson(res).get("id");
        System.out.println(id);
    }
}
