package airTests;

import libs.BaseTest;
import libs.WebDriveActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public class AirTests extends BaseTest {


    @Test(dataProvider = "DataProvider")
    public void test_1(WebDriveActions actions) {
        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        actions.type(By.xpath("//input[@placeholder='Select Cruise Line']"), "Royal Caribbean");
        actions.type(By.xpath("//input[@placeholder='Select Cruise Line']"), Keys.ENTER);

        actions.click(By.cssSelector("[data-ody-id='SearchButton']"));
        actions.quiteDriver();

        System.out.println("Test completed.");
    }

    @Test(dataProvider = "DataProvider")
    public void test_2(WebDriveActions actions) {
        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        actions.type(By.xpath("//input[@placeholder='Select Cruise Line']"), "Royal Caribbean");
        actions.type(By.xpath("//input[@placeholder='Select Cruise Line']"), Keys.ENTER);

        actions.click(By.cssSelector("[data-ody-id='SearchButton']"));
        actions.quiteDriver();

        System.out.println("Test completed.");
    }

}
