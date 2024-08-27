package libs.utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import libs.BaseTest;

public class ReporterUtils {

    public static void log(Status status, String message) {
        ExtentTest test = BaseTest.getTest(Thread.currentThread().getId());
        test.log(status, "URL check Passed.");
    }

    public static void pass(String message) {
        ExtentTest test = BaseTest.getTest(Thread.currentThread().getId());
        test.pass("URL check Passed.");
    }

    public static void fail(String message) {
        ExtentTest test = BaseTest.getTest(Thread.currentThread().getId());
        test.fail("URL check Passed.");
    }

    public static void skip(String message) {
        ExtentTest test = BaseTest.getTest(Thread.currentThread().getId());
        test.skip("URL check Passed.");
    }

}
