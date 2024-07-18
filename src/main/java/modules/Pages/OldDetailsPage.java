package modules.Pages;

import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OldDetailsPage extends DetailsPage{
    WebDriverActions actions;

    public OldDetailsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    static private final By BOOK = By.cssSelector("[data-ody-id='BookButton']");
    static private final By GUEST_1 = By.xpath("//li[@id='GA_1']//input");
    static private final By GUEST_2 = By.xpath("//li[@id='GA_2']//input");
    static private final By SELECT_COUNTRY = By.xpath("//select[@name='_ctl0:MainContentsPH:_ctl0:_ctl0:ResidentCountry']");
    static private final By SELECT_STATE = By.xpath("//select[@name='_ctl0:MainContentsPH:_ctl0:_ctl0:ResidentState']");
    static private final By CONTINUE = By.xpath("//a[@data-btntype='booknow']");
    static private final By CATEGORY_PAGE = By.cssSelector("[class='step-current']");


    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToBePresent(BOOK);
        actions.waitForElementToBeVisible(BOOK);
        actions.waitForElementToBeClickable(BOOK);
        actions.click(BOOK);
        actions.waitForElementToBePresent(GUEST_1);
        actions.waitForElementToBePresent(GUEST_2);
        actions.waitForElementToBeVisible(GUEST_1);
        actions.waitForElementToBeVisible(GUEST_2);
    }

    @Override
    public void fillDetailsPageParameters(JsonPath jsonPath) {
        actions.type(GUEST_1,jsonPath.getString("detailsPage.guestAge[0]"));
        actions.type(GUEST_2,jsonPath.getString("detailsPage.guestAge[1]"));
        Select selectCountry = new Select(actions.getWebDriver().findElement(SELECT_COUNTRY));
        Select selectState = new Select(actions.getWebDriver().findElement(SELECT_STATE));
        selectCountry.selectByValue(jsonPath.getString("detailsPage.country"));
        selectState.selectByValue(jsonPath.getString("detailsPage.state"));
        actions.click(CONTINUE);
    }

    @Override
    public void confirmLandOnCategoryPage() {
        actions.waitForElementToBePresent(CATEGORY_PAGE);
        actions.waitForElementToBeVisible(CATEGORY_PAGE);
    }
}
