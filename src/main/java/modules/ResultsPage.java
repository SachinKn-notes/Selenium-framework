package modules;

import libs.WebDriveActions;
import org.openqa.selenium.By;

public class ResultsPage {

    WebDriveActions actions;
    public ResultsPage(WebDriveActions actions) {
        this.actions = actions;
    }

    private static final By bookButton = By.xpath("(//button[normalize-space()='Book'])[1]");

    public void clickBookButton() {
        actions.click(bookButton);
    }

}
