package libs;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import libs.utils.JsonPathUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.restassured.path.json.JsonPath;

public class BaseTest {
    
    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running beforeSuite()");
    }
    
    @AfterSuite
    public void afterSuite() {
        System.out.println("Running afterSuite()");
    }
    
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running beforeMethod()");
    }
    
    @AfterMethod
    public void afterMethod() {
        System.out.println("Running afterMethod()");
    }
    
    @DataProvider(name = "genericDataProvider")
    public Object[][] genericDataProvider(Method method) throws Exception {
        
        String[] parameters = method.getAnnotation(Parameters.class).value();
        
        JsonPathUtils jsonPathUtils = new JsonPathUtils("./src/test/resources/TestData.json");
        int dataCount = jsonPathUtils.getSize(parameters);

        List<Object[]> data = new ArrayList<>();
        for (int i=0; i<dataCount; i++) {
            JsonPath testData = jsonPathUtils.getJsonPath(parameters[0], parameters[1] + "[" + i + "]");
            data.add(new Object[]{ new WebDriverActions(), testData });
        }
        return data.toArray(Object[][]::new);
    }
}


