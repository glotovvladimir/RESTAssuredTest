package TestFramework;

import TestFramework.files.*;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class JiraAPIUpdateComment {

    @Test
    public void JiraApiUpdateComment() {

        Response res = given().log().all().
                header("Content-Type", "application/json").
                header("Cookie", "JSESSIONID=" + UsableMethods.getSessionKEY()).
                body(payload.getJiraUpdateCommentBody()).
                when().
                put("/rest/api/2/issue/10009/comment/10004").
                then().log().all().
                assertThat().statusCode(200).extract().response();

        String id = UsableMethods.rawToJson(res).get("id");
        System.out.println(id);
    }
}
