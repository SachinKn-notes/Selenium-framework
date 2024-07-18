package modules.Pages;

import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class NewDetailsPage extends DetailsPage{
    WebDriverActions actions;
    public NewDetailsPage(WebDriverActions actions) {
        this.actions = actions;
    }

    static private final By BOOK = By.cssSelector("[data-ody-id='BookButton']");
    static private final By GUEST_1 = By.xpath("(//input[@type='number'])[1]");
    static private final By GUEST_2 = By.xpath("(//input[@type='number'])[2]");
    static private final By CONTINUE_1 = By.xpath("(//button[@data-ody-id='ContinueButton'])[1]");
    static private final By CONTINUE_2 = By.xpath("(//button[@data-ody-id='ContinueButton'])[3]");
    static private final By CONTINUE_3 = By.xpath("//button[@data-ody-id='ContinueToBookingButton']");
    static private final By COUNTRY = By.xpath("//*[@data-ody-id='country']//*[@role='textbox']");
    static private final By COUNTRY_TEXT_BOX = By.xpath("//span[@style='position: absolute; top: 158.5px; left: 27px;']//input[@class='select2-search__field']");
    static private final By STATE = By.xpath("//*[@data-ody-id='state']//*[@role='textbox']");
    static private final By STATE_TEXT_BOX = By.xpath("//span[@style='position: absolute; top: 158.5px; left: 410px;']//input[@class='select2-search__field']");
    static private final By CATEGORY_PAGE = By.cssSelector("[class='nav-item  active-nav-item']");




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
        actions.click(CONTINUE_1);
        actions.sleep(1);
        actions.click(COUNTRY);
        actions.type(COUNTRY_TEXT_BOX,jsonPath.getString("detailsPage.country"),Keys.ENTER);
        actions.click(STATE);
        actions.type(STATE_TEXT_BOX,jsonPath.getString("detailsPage.state"),Keys.ENTER);
        actions.click(CONTINUE_2);
        actions.click(CONTINUE_3);

    }

    @Override
    public void confirmLandOnCategoryPage() {
      actions.waitForElementToBePresent(CATEGORY_PAGE);
      actions.waitForElementToBeVisible(CATEGORY_PAGE);
    }
}
