package Modules.Pages;

import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import org.openqa.selenium.By;

public class NewSearchPage extends SearchPage {

    WebDriverActions actions;

    public NewSearchPage(WebDriverActions actions) {
        this.actions = actions;
    }

    // Locators
    static final By LOADER_SPIRAL = By.cssSelector("[class='loader-spiral']");
    static final By SELECT_CRUISE_LINE = By.cssSelector("[placeholder='Select Cruise Line']");
    static final By SEARCH_BUTTON = By.cssSelector("button[data-ody-id='SearchButton']");

    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToDisappear(LOADER_SPIRAL);
        actions.waitForElementToBeVisible(SELECT_CRUISE_LINE);
        actions.waitForElementToBeVisible(SEARCH_BUTTON);
    }

    @Override
    public void fillSearchParameters(JsonPath testData) {
        actions.type(SELECT_CRUISE_LINE, testData.getString("searchPage.cruiseLine"));
    }

    @Override
    public void clickOnSearch() {
        actions.click(SEARCH_BUTTON);
    }
}
