package TestFramework;

import TestFramework.files.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JIRAAddComment {


    @Test
    public void JiraApiCreateComment() {

        Response res = given().log().all().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + UsableMethods.getSessionKEY()).
                body(payload.getJiraAddCommentBody()).
                when().
                post("/rest/api/2/issue/10009/comment").
                then().log().all().
                assertThat().statusCode(201).extract().response();

        String id = UsableMethods.rawToJson(res).get("id");
        System.out.println(id);
    }
}
