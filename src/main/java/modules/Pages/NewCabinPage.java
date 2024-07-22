package modules.Pages;

import libs.WebDriverActions;
import org.openqa.selenium.By;

public class NewCabinPage extends CabinPage {

    WebDriverActions  actions;

    static private final By book = By.xpath("(//a[@data-ody-id='StateroomBookNowButton'])[last()]");
    static private final By TIMER = By.cssSelector("[id='Extendtime']");

    public NewCabinPage(WebDriverActions actions) {
        this.actions = actions;
    }

    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToBePresent(book);
        actions.waitForElementToBeVisible(book);

    }

    @Override
    public void bookCabin() {
        actions.click(book);
    }

    @Override
    public void confirmLandedOnCheckoutPage() {
        actions.waitForElementToBePresent(TIMER);
        actions.waitForElementToBeVisible(TIMER);
    }
}
