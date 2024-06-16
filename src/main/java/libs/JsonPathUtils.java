package libs;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class JsonPathUtils {
    
    JsonPath jsonPath;
    
    public JsonPathUtils(String filePath) {
        jsonPath = new JsonPath(new File(filePath));
    }
    
    public JsonPath getJsonPath(String... params) {
        return jsonPath.setRootPath(String.join(".", params));
    }
}
