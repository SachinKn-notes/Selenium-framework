package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverActions {
    
    WebDriver driver;
    
    public WebDriverActions(WebDriver driver) {
        this.driver = driver;
    }
    
    public void openUrl(String url) {
        driver.get(url);
    }
    
    public void click(By locator) {
        try {
            // wait for element to be displayed
            // wait for element to be enabled
            // wait for element to be clickable
            driver.findElement(locator).click();
        } catch(Exception ex) {
            ex.printStackTrace();
            // wait for element to be displayed
            // wait for element to be enabled
            // wait for element to be clickable
            driver.findElement(locator).click();
        }
    }
    
}


