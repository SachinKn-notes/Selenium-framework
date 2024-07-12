package modules.Pages;

import libs.WebDriverActions;

public class OldDetailsPage extends DetailsPage{
    WebDriverActions actions;

    public OldDetailsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    @Override
    public void waitForPageToLoad() {

    }
}
