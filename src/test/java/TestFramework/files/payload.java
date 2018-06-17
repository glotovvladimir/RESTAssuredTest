package TestFramework.files;

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

    public static String getJiraAuthBody() {
        String body = "{\t\"username\": \"vladimir_glotov\",\t\"password\": \"Ukjnjd24!\" }";
        return body;
    }

    public  static String getJiraAddIssiueBody() {
        String body = "{\n" +
                "    \"fields\": {\n" +
                "       \"project\":\n" +
                "       { \n" +
                "          \"key\": \"RES\"\n" +
                "       },\n" +
                "       \"summary\": \"Wow wow defect\",\n" +
                "       \"description\": \"Creating not first bug\",\n" +
                "       \"issuetype\": {\n" +
                "          \"name\": \"Ошибка\"\n" +
                "       }\n" +
                "   }\n" +
                "}";
        return  body;
    }

    public static String getJiraAddCommentBody() {
        String body = "{\n" +
                "      \"body\": \" 1232 \",\n" +
                "      \"visibility\": {\n" +
                "        \"type\": \"role\",\n" +
                "        \"value\": \"Administrators\"\n" +
                "      }\n" +
                "}";
        return  body;
    }

    public static String getJiraUpdateCommentBody() {
        String body = "{\n" +
                "        \"body\": \"Comment from REST API updated!\",\n" +
                "        \"visibility\": {\n" +
                "           \"type\": \"role\",\n" +
                "           \"value\": \"Administrators\"\n" +
                "       }\n" +
                "    }";
        return  body;
    }
}
