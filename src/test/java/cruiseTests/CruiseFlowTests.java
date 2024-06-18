package cruiseTests;

import modules.ResultsModule;
import modules.SearchModule;
import libs.utils.ScreenGrabber;
import objects.EnumContainer.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import libs.BaseTest;
import libs.WebDriverActions;

public class CruiseFlowTests extends BaseTest {
    @Test(testName = "Cruise Flow Full Payment Test", dataProvider = "genericDataProvider")
    @Parameters(value = {"cruise", "fullPayment"})
    public void cruiseFlowFullPaymentTest(WebDriverActions actions, JsonPath testData) throws Exception {

        // Variables
        SearchModule searchModule = new SearchModule(actions);
        ResultsModule resultsModule = new ResultsModule(actions);

        // Search Page actions
        searchModule.openSearchPageUrl(130386);
        searchModule.waitForPageToLoad();
        searchModule.fillSearchParameters(testData);
        searchModule.clickOnSearch();
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.SearchPage.toString());

        // Results Page actions
        resultsModule.waitForPageToLoad();
        resultsModule.clickBookNowButton();
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.ResultsPage.toString());
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















