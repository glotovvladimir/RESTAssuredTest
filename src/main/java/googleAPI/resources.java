package googleAPI;

public class resources {

    public static String pathXML = System.getProperty("user.dir") + "/src/main/java/googleAPI/payloadForXML.xml";

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
}
