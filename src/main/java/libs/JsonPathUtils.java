package libs;

import java.io.File;

import io.restassured.path.json.JsonPath;

public class JsonPathUtils {
    
    JsonPath jsonPath;
    
    public JsonPathUtils(String filePath) {
        jsonPath = new JsonPath(new File("./src/test/resources/TestData.json"));
    }
    
    public JsonPath getJsonPath(String... params) {
        return jsonPath.setRootPath(String.join(".", params));
    }
}
