package cruiseTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import libs.BaseTest;
import libs.WebDriveActions;
import modules.ResultsPage;
import modules.SearchPage;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class CruiseTests extends BaseTest {

    @Test(testName = "test_1", dataProvider = "DataProvider")
    public void test_1(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        if (actions.getUrl().contains("https://uat.odysol.com/")) {
            test.pass("URL check Passed.");
        } else {
            test.fail("URL check Fail");
        }

        searchpage.selectCruiseLine("Royal Caribbean");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_2", dataProvider = "DataProvider")
    public void test_2(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();
    }

    @Test(testName = "test_3", dataProvider = "DataProvider")
    public void test_3(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();

        Assert.fail();
    }

    @Test(testName = "test_4", dataProvider = "DataProvider", enabled = false)
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
