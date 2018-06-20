package ReusableMethods;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

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
}
