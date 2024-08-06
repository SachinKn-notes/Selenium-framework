package cruiseTests;

import libs.BaseTest;
import libs.WebDriveActions;
import modules.ResultsPage;
import modules.SearchPage;
import org.testng.annotations.Test;


public class CruiseTests extends BaseTest {


    @Test(dataProvider = "DataProvider")
    public void test_1(WebDriveActions actions) {

        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectCruiseLine("Royal Caribbean");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();

        actions.quiteDriver();

        System.out.println("Test completed.");
    }

    @Test(dataProvider = "DataProvider")
    public void test_2(WebDriveActions actions) {
        SearchPage searchpage = new SearchPage(actions);
        ResultsPage resultsPage = new ResultsPage(actions);

        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=130386");

        searchpage.selectSailingDates("");
        searchpage.clickSearchButton();

        resultsPage.clickBookButton();

        System.out.println("Test completed.");
    }

}
