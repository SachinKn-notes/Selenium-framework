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

    WebDriver driver;
    public void openUrl(String url) {
        System.setProperty("webdriver.chrome.driver", "D:\\Work\\EXEs\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        driver.get(url);
    }

    public void type(By by, String value) {
        WebElement ele = driver.findElement(by);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        ele.sendKeys(value);
    }

    public void type(By by, Keys keys) {
        WebElement ele = driver.findElement(by);
        ele.sendKeys(keys);
    }

    public void click(By by) {
        WebElement ele = driver.findElement(by);
        new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        new WebDriverWait(driver, 60).until(ExpectedConditions.elementToBeClickable(by));
        ele.click();
    }

    public void quiteDriver() {
        driver.quit();
    }

}
