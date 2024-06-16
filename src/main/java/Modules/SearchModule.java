package Modules;

import Modules.Pages.NewSearchPage;
import Modules.Pages.OldSearchPage;
import Modules.Pages.SearchPage;
import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;

public class SearchModule {

    WebDriverActions actions;
    SearchPage searchPage;

    public SearchModule(WebDriverActions actions) {
        this.actions = actions;
    }

    public void initiatePageReference(int siid) {
        if (siid == 130386) {
            searchPage = new NewSearchPage(actions);
        } else if (siid == 130385) {
            searchPage = new OldSearchPage(actions);
        }
    }

    public void openSearchPageUrl(int siid) {
        actions.openUrl("https://uat.odysol.com/swift/cruise?siid=" + siid);
        initiatePageReference(siid);
    }

    public void waitForPageToLoad() {
        searchPage.waitForPageToLoad();
    }

    public void fillSearchParameters(JsonPath testData) {
        searchPage.fillSearchParameters(testData);
    }

    public void clickOnSearch() {
        searchPage.clickOnSearch();
    }
}
