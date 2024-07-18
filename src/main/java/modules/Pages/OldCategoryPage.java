package modules.Pages;

import libs.WebDriverActions;
import org.openqa.selenium.By;

public class OldCategoryPage extends CategoryPage{
    WebDriverActions actions;

    public OldCategoryPage(WebDriverActions actions) {
        this.actions = actions;
    }

    static private final By BOOK = By.xpath("(//div[@class='categoryview-price-gride']//a[@class='booknow primary-btn'])[1]");
    static private final By CONTINUE = By.xpath("(//a[@onclick='SubmitSelection()'])[last()]");

    @Override
    public void waitFoePageToLoad() {
        actions.waitForElementToBePresent(BOOK);
        actions.waitForElementToBeVisible(BOOK);
    }

    @Override
    public void clickBookButton() {
        actions.click(BOOK);
        if (actions.getWebDriver().findElement(CONTINUE)!=null)
            actions.click(CONTINUE);
    }


    @Override
    public void confirmLandedOnCabinPage() {

    }
}
