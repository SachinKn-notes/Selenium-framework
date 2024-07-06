package libs;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import libs.utils.JsonPathUtils;
import libs.utils.ScreenGrabber;
import libs.utils.ZipUtils;
import objects.EnumContainer;
import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;

import io.restassured.path.json.JsonPath;

public class BaseTest {

    private static ExtentReports extentReports;
    private static ConcurrentHashMap<Long, ExtentTest> testInfoMap = new ConcurrentHashMap<>();

    @BeforeSuite
    public void beforeSuite() {
        try {
            FileUtils.deleteDirectory(new File("./test-output/ExtentReport"));
            FileUtils.deleteDirectory(new File("./test-output/Screenshots"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        new File("./test-output/ExtentReport").mkdirs();
        new File("./test-output/Screenshots").mkdirs();

        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File("./test-output/ExtentReport/AutomationReport.html"));
        extentSparkReporter.config().setReportName("Automation Report");
        extentSparkReporter.config().setDocumentTitle("Automation Test Report");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentSparkReporter.config().setEncoding("UTF-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        extentReports.setSystemInfo("User", System.getProperty("user.name").toUpperCase());
        extentReports.setSystemInfo("Environment", "TEST");
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));

    }
    
    @AfterSuite
    public void afterSuite() {
        extentReports.flush();

        new File("./archive").mkdirs();
        List<String> targetPaths = List.of(
                "./test-output/ExtentReport",
                "./test-output/Screenshots"
        );

        String dateName = new SimpleDateFormat("yyyyMMMdd-hhmmss").format(new Date());

        for (String targetPath : targetPaths) {
            ZipUtils.zip(targetPath, "./archive/extentReport-" + dateName + ".zip");
        }

    }
    
    @BeforeMethod
    public void beforeMethod(ITestContext context, Method method, Object[] obj) {
        String testName = method.getAnnotation(Test.class).testName().replaceAll(":", "-").replaceAll("[\\\\/*?\"<>|]", "&");
        ExtentTest extentTest = extentReports.createTest(testName);

        testInfoMap.put(Thread.currentThread().getId(), extentTest);

		String[] groups = method.getAnnotation(Test.class).groups();
        for (String group : groups) {
            extentTest.assignCategory(group);
        }
    }
    
    @AfterMethod
    public void afterMethod(ITestResult result, Method method, Object[] obj) {
        ExtentTest extentTest = testInfoMap.get(Thread.currentThread().getId());

        try {
            if (result.getStatus() == ITestResult.SUCCESS) {
                extentTest.pass(MarkupHelper.createLabel(result.getName()+ " passed", ExtentColor.GREEN));
            }

            else if (result.getStatus() == ITestResult.FAILURE) {
                extentTest.fail(MarkupHelper.createLabel(result.getName() + " failed", ExtentColor.RED));
                extentTest.fail(result.getThrowable());

                // To Capture screenshots.
				if (((WebDriverActions) obj[0]).getWebDriver() != null) {
                    ScreenGrabber.getScreenshot(((WebDriverActions) obj[0]).getWebDriver(), "FailedScreenshot");
				}
            }

            else if (result.getStatus() == ITestResult.SKIP) {
                extentTest.skip(MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.BLUE));
                extentTest.skip(MarkupHelper.createLabel(result.getName() + " skipped", ExtentColor.BLUE));
                extentTest.skip(result.getThrowable());

                // To Capture screenshots.
                if (((WebDriverActions) obj[0]).getWebDriver() != null) {
                    ScreenGrabber.getScreenshot(((WebDriverActions) obj[0]).getWebDriver(), "FailedScreenshot");
                }
            }

            // Close browser
            if (((WebDriverActions) obj[0]).getWebDriver() != null) {
                ((WebDriverActions) obj[0]).closeDriver();
                ((WebDriverActions) obj[0]).quitDriver();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            long milliSecs = result.getEndMillis() - result.getStartMillis();
            extentTest.log(Status.INFO, MarkupHelper.createLabel(String.format("Time taken: %d Minutes %d Seconds",
                    (milliSecs / 1000) / 60, (milliSecs / 1000) % 60), ExtentColor.BROWN));
        }
    }
    
    @DataProvider(name = "genericDataProvider")
    public Object[][] genericDataProvider(Method method) throws Exception {
        
        String[] parameters = method.getAnnotation(Parameters.class).value();
        
        JsonPathUtils jsonPathUtils = new JsonPathUtils("./src/test/resources/TestData.json");
        int dataCount = jsonPathUtils.getSize(parameters);

        List<Object[]> data = new ArrayList<>();
        for (int i=0; i<dataCount; i++) {
            JsonPath testData = jsonPathUtils.getJsonPath(parameters[0], parameters[1] + "[" + i + "]");
            data.add(new Object[]{ new WebDriverActions(), testData });
        }
        return data.toArray(Object[][]::new);
    }
}


