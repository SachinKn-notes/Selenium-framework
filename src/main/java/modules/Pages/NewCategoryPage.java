package modules.Pages;

import libs.WebDriverActions;
import org.openqa.selenium.By;

public class NewCategoryPage extends CategoryPage{

    WebDriverActions actions;

    public NewCategoryPage(WebDriverActions actions) {
        this.actions = actions;
    }

    private static final By BOOK = By.xpath("(//div[@id='category_price_content_1']//a[@data-ody-id='BookNowButton'])[last()]");
    static private final By CABIN_PAGE = By.cssSelector("[class='nav-item  active-nav-item']");

    @Override
    public void waitFoePageToLoad() {
    actions.waitForElementToBePresent(BOOK);
    actions.waitForElementToBeVisible(BOOK);

    }

    @Override
    public void clickBookButton() {
        actions.click(BOOK);
    }


    @Override
    public void confirmLandedOnCabinPage() {
        actions.waitForElementToBePresent(CABIN_PAGE);
        actions.waitForElementToBeVisible(CABIN_PAGE);
    }
}
