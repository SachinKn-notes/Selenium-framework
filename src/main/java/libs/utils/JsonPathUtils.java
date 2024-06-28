package libs.utils;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class JsonPathUtils {
    
    JsonPath jsonPath;
    
    public JsonPathUtils(String filePath) {
        jsonPath = new JsonPath(new File(filePath));
    }

    public int getSize(String... pathParams) {
        return jsonPath.getInt(String.join(".", pathParams) + ".size()");
    }

    public JsonPath getJsonPath(String... pathParams) {
        return jsonPath.setRootPath(String.join(".", pathParams));
    }
}
