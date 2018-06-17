package TestFramework;

import TestFramework.files.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.util.Properties;

import static io.restassured.RestAssured.given;

public class TweetTest {

    Properties prop = new Properties();
    String consumerKey = "eT0enpSwlXDQQSMiX7gv4ePkT";
    String consSecret = "LIar3UddzVA3TFfgaPMtfWCe97pCAj8tJXol0K4A6k3Z7DIIvj";
    String accToken = "997565154710736897-r0tN69QuAlY76TO2CXLDpvVx21UUpYW";
    String tokenSecret = "sNVoj2pyojdviVLJLukJl1RC7RoBXx65svEK4g8fPsKdk";
    String tweetId;

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
    public void getLatestTweet() {
        RestAssured.baseURI = prop.getProperty("TWEETERHOST");

        Response res = given().auth().oauth(consumerKey, consSecret, accToken, tokenSecret).
                log().all().
                queryParam("count", "1").
                when().
                get(resources.tweetGetTimeline()).
                then().log().all().assertThat().statusCode(200).extract().response();

        String id = UsableMethods.rawToJson(res).get("id").toString();
        String text = UsableMethods.rawToJson(res).get("text").toString();
        System.out.println(id + " " + text);
    }

    @Test
    public void createTweet() {
        RestAssured.baseURI = prop.getProperty("TWEETERHOST");

        Response res = given().auth().oauth(consumerKey, consSecret, accToken, tokenSecret).
                log().all().
                queryParam("status", LocalDateTime.now().toString()).
                when().
                post(resources.postTweet()).
                then().log().all().assertThat().statusCode(200).extract().response();

        tweetId = UsableMethods.rawToJson(res).get("id").toString();
    }

    @Test(dependsOnMethods = "getLatestTweet")
    public void deleteTweet() {
        RestAssured.baseURI = prop.getProperty("TWEETERHOST");
        createTweet();

        Response res = given().auth().oauth(consumerKey, consSecret, accToken, tokenSecret).
                log().all().
                when().
                post(String.format(resources.deleteTweet(), tweetId)).
                then().log().all().assertThat().statusCode(200).extract().response();

        String text = UsableMethods.rawToJson(res).get("text").toString();
        String truncated = UsableMethods.rawToJson(res).get("truncated").toString();
        System.out.println(text + " " + truncated);
    }
}
