package modules.Pages;

import libs.WebDriverActions;
import org.openqa.selenium.By;

public class OldResultsPage extends ResultsPage {

    WebDriverActions actions;
    public OldResultsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    private static final By CATEGORY = By.xpath("//li[@class='step-current']");
    private static final By BOOK = By.xpath("(//div[@class='categoryview-price-gride']//a[@class='booknow primary-btn'])[last()]");

    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToBePresent(CATEGORY);
        actions.waitForElementToBeVisible(CATEGORY);

    }

    @Override
    public void clickBookNowButton() {
        actions.click(BOOK);

    }

    @Override
    public void confirmThatLandedOnDetailsPage() {

    }
}
