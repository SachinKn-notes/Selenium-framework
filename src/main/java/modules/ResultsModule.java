package modules;

import modules.Pages.*;
import libs.WebDriverActions;
import objects.PackageObject;

public class ResultsModule {

    // Variables
    WebDriverActions actions;
    ResultsPage resultsPage;

    // Constructor
    public ResultsModule(WebDriverActions actions) {
        this.actions = actions;
    }

    // Methods
    public void initiatePageReference(PackageObject packageObject) {
        if (packageObject.getSiid() == 130386) {
            resultsPage = new NewResultsPage(actions);
        } else if (packageObject.getSiid() == 130385) {
            resultsPage = new NewResultsPage(actions);
        }
    }

    public void waitForPageToLoad(PackageObject packageObject) {
        initiatePageReference(packageObject);
        resultsPage.waitForPageToLoad();
    }

    public void clickBookNowButton() {
        resultsPage.clickBookNowButton();
    }

    public void ConfirmThatLandedOnDetailsPage(){resultsPage.confirmThatLandedOnDetailsPage();}
}
