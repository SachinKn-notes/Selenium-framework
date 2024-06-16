package cruiseTests;

import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import libs.BaseTest;
import libs.WebDriverActions;

public class CruiseFlowTests extends BaseTest {
    @Test(testName = "Cruise Flow Full Payment Test", dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "fullPayment"})
    public void cruiseFlowFullPaymentTest(WebDriverActions actions, JsonPath testData) {
        System.out.println("Running cruiseFlowFullPaymentTest()");
        
        actions.openUrl("https://www.example.com");
//        actions.click(By.xpath(""));
        
        System.out.println(testData.get("detailsPage.guestAge[1]"));
    }
    
    
    
    @Test(dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "depositPayment"})
    public void cruiseFlowDepositPaymentTest(WebDriverActions actions, JsonPath testData) {
        System.out.println("Running cruiseFlowDepositPaymentTest()");
        
        actions.openUrl("https://www.example.com");
        actions.click(By.xpath(""));
        
        System.out.println(testData.get("detailsPage.guestAge[1]"));
    }
    
    
    
    @Test(dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "holdPayment"})
    public void cruiseFlowHoldPaymentTest(WebDriverActions actions, JsonPath testData) {
        System.out.println("Running cruiseFlowHoldPaymentTest()");
        System.out.println(testData.get("detailsPage.guestAge[1]"));
    }
    
}















