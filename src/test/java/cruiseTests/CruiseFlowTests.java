package cruiseTests;

import com.aventstack.extentreports.Status;
import libs.utils.LoggerUtils;
import libs.utils.ReporterUtils;
import modules.ResultsModule;
import modules.SearchModule;
import libs.utils.ScreenGrabber;
import objects.EnumContainer.*;
import objects.PackageObject;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import libs.BaseTest;
import libs.WebDriverActions;

public class CruiseFlowTests extends BaseTest {
    @Test(testName = "Cruise Flow Full Payment Test", dataProvider = "genericDataProvider", groups = {"Id-01", "smoke"})
    @Parameters(value = {"cruise", "fullPayment"})
    public void cruiseFlowFullPaymentTest(WebDriverActions actions, JsonPath testData) throws Exception {

        // Variables
        PackageObject packageObject = new PackageObject();
        SearchModule searchModule = new SearchModule(actions);
        ResultsModule resultsModule = new ResultsModule(actions);

        // Set Test Data
        packageObject.setSiid(130386);

        // Search Page actions
        searchModule.openSearchPageUrl(packageObject);
        searchModule.waitForPageToLoad(packageObject);
        ReporterUtils.writeStatusToReportWithMsg(Status.PASS, "SearchPage Loaded");
        searchModule.fillSearchParameters(testData);
        searchModule.clickOnSearch();
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.SearchPage.toString());

        // Results Page actions
        resultsModule.waitForPageToLoad(packageObject);
        resultsModule.clickBookNowButton();
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.ResultsPage.toString());
    }

    @Test(testName = "Cruise Flow Deposit Payment Test", dataProvider = "genericDataProvider", groups = {"Id-02", "smoke"})
    @Parameters(value = {"cruise", "depositPayment"})
    public void cruiseFlowDepositPaymentTest(WebDriverActions actions, JsonPath testData) {

    }

    @Test(testName = "Cruise Flow Hold Payment Test", dataProvider = "genericDataProvider", groups = {"Id-03", "reg"})
    @Parameters(value = {"cruise", "holdPayment"})
    public void cruiseFlowHoldPaymentTest(WebDriverActions actions, JsonPath testData) {

    }
}















