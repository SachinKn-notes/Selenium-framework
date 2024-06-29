package modules;

import io.restassured.path.json.JsonPath;
import libs.utils.PropertyUtils;
import modules.Pages.NewSearchPage;
import modules.Pages.OldSearchPage;
import modules.Pages.SearchPage;

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

    public void openSearchPageUrl(int siid) throws Exception {
        actions.openUrl(String.format(PropertyUtils.getProperty("urls", "cruiseUrl"), siid));
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
