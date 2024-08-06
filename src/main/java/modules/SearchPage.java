package modules;

import libs.WebDriveActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SearchPage {

    WebDriveActions actions;
    public SearchPage(WebDriveActions actions) {
        this.actions = actions;
    }

    private static final By SELECT_CRUISE_LINE = By.xpath("//input[@placeholder='Select Cruise Line']");
    private static final By SEARCH_BUTTON = By.cssSelector("[data-ody-id='SearchButton']");

    public void selectSailingDates(String value) {

    }

    public void selectCruiseLine(String value) {
        actions.type(SELECT_CRUISE_LINE, value);
        actions.type(SELECT_CRUISE_LINE, Keys.ENTER);
    }

    public void clickSearchButton() {
        actions.click(SEARCH_BUTTON);
    }

}
