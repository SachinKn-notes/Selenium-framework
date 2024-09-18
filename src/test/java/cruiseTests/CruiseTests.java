package cruiseTests;

import libs.BaseTest;
import libs.WebDriveActions;
import libs.utils.ReporterUtils;
import libs.utils.ScreenshotUtils;
import modules.ResultsPage;
import modules.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;


public class CruiseTests extends BaseTest {

    @Test(testName = "test_1", dataProvider = "DataProvider", groups = {"ID-001", "smoke"})
    public void test_1(WebDriveActions actions) throws IOException {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        if (actions.getUrl().contains("https://uat.odysol.com/")) {
            ReporterUtils.pass("URL check Passed.");
        } else {
            ReporterUtils.fail("URL check Fail");
        }

        searchpage.selectCruiseLine("Royal Caribbean");
        searchpage.clickSearchButton();

        ScreenshotUtils.takeScreenshot(actions, "SearchPageScreenshot");

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_2", dataProvider = "DataProvider", groups = {"ID-002", "smoke"})
    public void test_2(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_3", dataProvider = "DataProvider", groups = {"ID-003", "reg"})
    public void test_3(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();

        Assert.fail();
    }

    @Test(testName = "test_4", dataProvider = "DataProvider", groups = {"ID-004", "smoke", "reg"})
    public void test_4(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_5", dataProvider = "DataProvider", enabled = false)
    public void test_5(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_6", dataProvider = "DataProvider", enabled = false)
    public void test_6(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

}
