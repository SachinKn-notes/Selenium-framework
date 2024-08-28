package libs;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WebDriveActions {

    private WebDriver driver;
    long TIMEOUT = 60;
    public void openUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\EXEs\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get(url);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForElementToBePresent(By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void waitForElementToBeVisible(By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForElementToBeEnabled(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        wait.until(driver -> element.isEnabled());
    }

    public void waitForElementToBeClickable(By locator) {
        new WebDriverWait(driver, TIMEOUT)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void type(By by, String value) {
        waitForElementToBePresent(by);
        waitForElementToBeEnabled(by);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(value);
    }

    public void type(By by, Keys keys) {
        waitForElementToBePresent(by);
        waitForElementToBeEnabled(by);
        waitForElementToBeVisible(by);
        driver.findElement(by).sendKeys(keys);
    }

    public void click(By by) {
        waitForElementToBePresent(by);
        waitForElementToBeVisible(by);
        waitForElementToBeEnabled(by);
        waitForElementToBeClickable(by);
        driver.findElement(by).click();
    }

    public void quiteDriver() {
        driver.quit();
    }

}
