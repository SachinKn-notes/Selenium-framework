package libs.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;

public class ScreenGrabber {

    static public void getScreenshot(WebDriver driver, String fileName) throws IOException {
        TakesScreenshot tss = (TakesScreenshot) driver;

        File from = tss.getScreenshotAs(OutputType.FILE);
        File to = new File("./test-output/Screenshots/" + fileName + ".png");

        FileHandler.copy(from, to);
    }

    static public void getFullPageScreenshot(WebDriver driver, String fileName) throws IOException {

    }

}
