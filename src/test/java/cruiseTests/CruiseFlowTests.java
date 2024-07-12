package cruiseTests;

import com.aventstack.extentreports.Status;
import libs.utils.ReporterUtils;
import modules.DetailsModule;
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
        DetailsModule detailsModule = new DetailsModule(actions);

        // Set Test Data
        packageObject.setSiid(130386);

        // Search Page actions
        searchModule.openSearchPageUrl(packageObject);
        searchModule.waitForPageToLoad(packageObject);
        ReporterUtils.writeStatusToReportWithMsg(Status.PASS, "SearchPage Loaded");
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.SearchPage.toString());
        searchModule.fillSearchParameters(testData);
        searchModule.clickOnSearch();
        searchModule.confirmThatLandedOnResultsPage();
        ReporterUtils.writeStatusToReportWithMsg(Status.PASS,"Everything went well and landed on results page");
        ScreenGrabber.getScreenshot(actions.getWebDriver(), Pages.ResultsPage.toString());

        // Results Page actions
        resultsModule.waitForPageToLoad(packageObject);
        ReporterUtils.writeStatusToReportWithMsg(Status.PASS,"results page loaded");
        resultsModule.clickBookNowButton();
        resultsModule.ConfirmThatLandedOnDetailsPage();
        ReporterUtils.writeStatusToReportWithMsg(Status.PASS,"Everything went well and landed on details page");
        ScreenGrabber.getScreenshot(actions.getWebDriver(),Pages.DetailsPage.toString());
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















