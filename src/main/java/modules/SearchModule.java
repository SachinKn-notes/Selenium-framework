package modules;

import libs.utils.PropertyUtils;
import modules.Pages.NewSearchPage;
import modules.Pages.OldSearchPage;
import modules.Pages.SearchPage;
import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import objects.PackageObject;

public class SearchModule {

    WebDriverActions actions;
    SearchPage searchPage;

    public SearchModule(WebDriverActions actions) {
        this.actions = actions;
    }

    public void initiatePageReference(PackageObject packageObject) {
        if (packageObject.getSiid() == 130386) {
            searchPage = new NewSearchPage(actions);
        } else if (packageObject.getSiid() == 130385) {
            searchPage = new NewSearchPage(actions);
        }
    }

    public void openSearchPageUrl(PackageObject packageObject) throws Exception {
        actions.openUrl(String.format(PropertyUtils.getProperty("urls", "cruiseUrl"), packageObject.getSiid()));
    }

    public void waitForPageToLoad(PackageObject packageObject) {
        initiatePageReference(packageObject);
        searchPage.waitForPageToLoad();
    }

    public void fillSearchParameters(JsonPath testData) {
        searchPage.fillSearchParameters(testData);
    }

    public void clickOnSearch() {
        searchPage.clickOnSearch();
    }
}
