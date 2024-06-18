package modules.Pages;

import io.restassured.path.json.JsonPath;

abstract public class SearchPage {
    abstract public void waitForPageToLoad();

    abstract public void fillSearchParameters(JsonPath testData);

    public abstract void clickOnSearch();
}
