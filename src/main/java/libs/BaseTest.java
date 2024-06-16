package libs;

import java.io.File;
import java.lang.reflect.Method;

import org.openqa.selenium.chrome.ChromeDriver;
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
    
    static {
        System.setProperty("webdriver.chrome.driver", "D:/Work/EXEs/chromedriver.exe");
    }
    
    @DataProvider(name = "genericDataProvider")
    public Object[][] genericDataProvider(Method method) throws Exception {
        
        String[] parameters = method.getAnnotation(Parameters.class).value();
        
        JsonPathUtils jsonPathUtils = new JsonPathUtils("./src/test/resources/TestData.json");
        JsonPath testData = jsonPathUtils.getJsonPath(parameters[0], parameters[1]);
        
        return new Object[][] {
            {new WebDriverActions(), testData}
        };
        
    }
}


