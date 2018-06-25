package googleAPI;

public class payload {

    public static String getPostBody() {
        String body = "{\n" +
                "  \"location\": {\n" +
                "    \"lat\": 51.5230064,\n" +
                "    \"lng\": 45.9829183\n" +
                "  },\n" +
                "  \"accuracy\": 200,\n" +
                "  \"name\": \"Holiday train goog\",\n" +
                "  \"phone_number\": \"(02) 9374 4000\",\n" +
                "  \"address\": \"Saratov\",\n" +
                "  \"types\": [\"park\"],\n" +
                "  \"website\": \"http://www.google.com.au/\",\n" +
                "  \"language\": \"en-EN\"\n" +
                "}";
        return body;
    }

    public  static String getDeleteBody() {
        String body = "{\n" +
                "\t\"place_id\" : \"%s\"\n" +
                "}";
        return  body;
    }
}
