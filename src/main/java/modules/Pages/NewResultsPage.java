package modules.Pages;

import libs.WebDriverActions;
import org.openqa.selenium.By;

public class NewResultsPage extends ResultsPage {

    WebDriverActions actions;
    public NewResultsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    private static final By BOOK = By.xpath("(//button[@class='btn btn-primary mw100'])[1]");
    private static final By PACKAGE_PRICES = By.cssSelector("[data-ody-id='PackagePrices']");

    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToBePresent(BOOK);
        actions.waitForElementToBeVisible(BOOK);

    }

    @Override
    public void clickBookNowButton() {
        actions.waitForElementToBeClickable(BOOK);
        actions.click(BOOK);
    }

    @Override
    public void confirmThatLandedOnDetailsPage() {

        actions.waitForElementToBePresent(PACKAGE_PRICES);
        actions.waitForElementToBeVisible(PACKAGE_PRICES);

    }
}
