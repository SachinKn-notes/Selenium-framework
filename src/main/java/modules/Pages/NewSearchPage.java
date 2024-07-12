package modules.Pages;

import io.restassured.path.json.JsonPath;
import libs.WebDriverActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class NewSearchPage extends SearchPage {

    WebDriverActions actions;
    public static String [] fromDate;
    public static String [] toDate;

    public NewSearchPage(WebDriverActions actions) {
        this.actions = actions;
    }

    // Locators
    static final By LOADER_SPIRAL = By.cssSelector("[class='loader-spiral']");
    static final By SELECT_CRUISE_LINE = By.cssSelector("[placeholder='Select Cruise Line']");
    static final By SEARCH_BUTTON = By.cssSelector("button[data-ody-id='SearchButton']");
    static final By SAILING_DATES = By.cssSelector("[data-ody-id='sailingDates']");
    static final By CURRENT_YEAR = By.xpath("(//div[@class='bs-datepicker-head'])[1]//button[@class='current']");
    static final By RESULT_PAGE = By.cssSelector("[data-ody-id='CruiseSailingDatesSection']");

    @Override
    public void waitForPageToLoad() {
        actions.waitForElementToDisappear(LOADER_SPIRAL);
        actions.waitForElementToBeVisible(SELECT_CRUISE_LINE);
        actions.waitForElementToBeVisible(SEARCH_BUTTON);
    }

    @Override
    public void fillSearchParameters(JsonPath testData) {
        actions.type(SELECT_CRUISE_LINE, testData.getString("searchPage.cruiseLine"), Keys.ENTER);
        selectsSailingDates(testData);
    }

    private void selectsSailingDates(JsonPath testData) {

        fromDate = testData.getString("searchPage.sailingDates.from").split("-");
        toDate = testData.getString("searchPage.sailingDates.to").split("-");
        actions.click(SAILING_DATES);
        actions.click(CURRENT_YEAR);
        final By FROM_YEAR = By.xpath("((//div[@class='bs-datepicker-body'])[1]//tr//td)//*[contains(normalize-space(),"+fromDate[2]+")]");
        actions.click(FROM_YEAR);
        final By FROM_MONTH = By.xpath("((//div[@class='bs-datepicker-body'])[1])//span[contains(normalize-space(),"+fromDate[1]+")]");
        actions.click(FROM_MONTH);
        final By FROM_DATE = By.xpath("((//div[@class='bs-datepicker-body'])[1])//tr//td//*[normalize-space()="+fromDate[0]+"][not(contains(@class,'is-other-month'))]");
        actions.click(FROM_DATE);

        actions.click(CURRENT_YEAR);
        final By TO_YEAR = By.xpath("((//div[@class='bs-datepicker-body'])[1]//tr//td)//*[contains(normalize-space(),"+toDate[2]+")]");
        actions.click(TO_YEAR);
        final By TO_MONTH = By.xpath("((//div[@class='bs-datepicker-body'])[1])//span[contains(normalize-space(),"+toDate[1]+")]");
        actions.click(TO_MONTH);
        final By TO_DATE = By.xpath("((//div[@class='bs-datepicker-body'])[1])//tr//td//*[normalize-space()="+toDate[0]+"][not(contains(@class,'is-other-month'))]");
        actions.click(TO_DATE);

    }

    @Override
    public void clickOnSearch() {
        actions.click(SEARCH_BUTTON);
    }

    @Override
    public void ConfirmThatLandedOnResultspage() {
        actions.waitForElementToBePresent(RESULT_PAGE);
        actions.waitForElementToBeVisible(RESULT_PAGE);
    }
}
