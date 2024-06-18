package modules;

import modules.Pages.*;
import libs.WebDriverActions;

public class ResultsModule {

    // Variables
    WebDriverActions actions;
    ResultsPage resultsPage;

    // Constructor
    public ResultsModule(WebDriverActions actions) {
        this.actions = actions;
    }

    // Methods
    public void initiatePageReference(int siid) {
        if (siid == 130386) {
            resultsPage = new NewResultsPage(actions);
        } else if (siid == 130385) {
            resultsPage = new OldResultsPage(actions);
        }
    }

    public void waitForPageToLoad() {
        resultsPage.waitForPageToLoad();
    }

    public void clickBookNowButton() {
        resultsPage.clickBookNowButton();
    }
}
