package libs.utils;

import libs.WebDriveActions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriveActions actions, String fileName) throws IOException {

        String date = new SimpleDateFormat("dd-MMM-yyyy_HH-mm-ss").format(new Date());
        String fullFileName = fileName + "_" + date + ".png";

        WebDriver driver = actions.getWebDriver();
        TakesScreenshot tss = (TakesScreenshot) driver;

        actions.waitForPageToLoad();

        File from = tss.getScreenshotAs(OutputType.FILE);
        File to = new File("./test-output/Screenshots/" + fullFileName);

        FileHandler.copy(from, to);

        return fullFileName;
    }

}
