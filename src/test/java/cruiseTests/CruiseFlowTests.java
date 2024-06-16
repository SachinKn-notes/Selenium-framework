package cruiseTests;

import Modules.SearchModule;
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

        // Variables
        SearchModule searchModule = new SearchModule(actions);

        // Search Page actions
        searchModule.openSearchPageUrl(130386);
        searchModule.waitForPageToLoad();
        searchModule.fillSearchParameters(testData);
        searchModule.clickOnSearch();
    }

    @Test(testName = "Cruise Flow Deposit Payment Test", dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "depositPayment"})
    public void cruiseFlowDepositPaymentTest(WebDriverActions actions, JsonPath testData) {

    }

    @Test(testName = "Cruise Flow Hold Payment Test", dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "holdPayment"})
    public void cruiseFlowHoldPaymentTest(WebDriverActions actions, JsonPath testData) {

    }
}















