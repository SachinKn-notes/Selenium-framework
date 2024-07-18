package modules.Pages;

import io.restassured.path.json.JsonPath;

public abstract class DetailsPage {
    public abstract void waitForPageToLoad();

    public abstract void  fillDetailsPageParameters(JsonPath jsonPath);

    public abstract void confirmLandOnCategoryPage();
}
