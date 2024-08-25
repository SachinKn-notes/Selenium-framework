package libs;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {

    public ExtentReports extentReports;
    public ExtentTest test;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running beforeSuite()");
        ExtentSparkReporter esr = new ExtentSparkReporter("./test-output/AutomationReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(esr);
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Running afterSuite()");
        extentReports.flush();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        System.out.println("Running beforeMethod()");

        String testName = method.getAnnotation(Test.class).testName();
        test = extentReports.createTest(testName);

    }

    @AfterMethod
    public void afterMethod(ITestResult result, Object[] objects) {

        if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test completed.");
        } else if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Test completed.");
        }  else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test completed.");
        }

        WebDriveActions actions = (WebDriveActions) objects[0];
        actions.quiteDriver();
    }

    @DataProvider(name = "DataProvider")
    public Object[][] dataProvider() {
        return new Object[][] {
            { new WebDriveActions() }
        };
    }
}
