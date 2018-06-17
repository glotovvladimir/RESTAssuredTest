package TestFramework.files;

public class resources {

    public static String pathXML = "src\\test\\java\\TestFramework\\files\\payloadForXML.xml";

    public static String placePostData() {
        String resourceName = "/maps/api/place/add/json";
        return resourceName;
    }

    public static String placeDeleteData() {
        String resourceName = "/maps/api/place/delete/json";
        return resourceName;
    }

    public static String placeGetData() {
        String resourceName = "/maps/api/place/nearbysearch/json";
        return resourceName;
    }

    public static String placePostDataXML() {
        String resourceName = "/maps/api/place/add/xml";
        return resourceName;
    }

    public static String jiraAuth() {
        String resourceName = "/rest/auth/1/session";
        return resourceName;
    }

    public static String jiraAddIssue() {
        String resourceName = "/rest/api/2/issue";
        return resourceName;
    }

    public static String jiraAddComment () {
        String resourceName = "/rest/api/2/issue/%s/comment";
        return resourceName;
    }

    public static String tweetGetTimeline () {
        String resourceName = "/home_timeline.json";
        return resourceName;
    }

    public static String postTweet () {
        String resourceName = "/update.json";
        return resourceName;
    }

    public static String deleteTweet () {
        String resourceName = "/destroy/%s.json";
        return resourceName;
    }
}
