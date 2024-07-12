package modules.Pages;

import libs.WebDriverActions;

public class NewDetailsPage extends DetailsPage{
    WebDriverActions actions;
    public NewDetailsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    @Override
    public void waitForPageToLoad() {

    }
}
