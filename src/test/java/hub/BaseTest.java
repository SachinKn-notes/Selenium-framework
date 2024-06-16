package hub;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.io.FileUtils;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseTest {
	
	private static ExtentReports extentReports;
	private static ConcurrentHashMap<Long, ExtentTest> testInfoMap = new ConcurrentHashMap<Long, ExtentTest>();
	
	@BeforeSuite
	public void beforeSuit() {
		
		System.out.println("beforeSuite()");
		
		try {
			FileUtils.deleteDirectory(new File("./test-output/ExtentReport"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		new File("./test-output/ExtentReport").mkdirs();
		
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(new File("./test-output/ExtentReport/AutomationReport.html"));
		extentSparkReporter.config().setReportName("Odysseus Report");
		extentSparkReporter.config().setDocumentTitle("Odysseus Test Report");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setEncoding("UTF-8");
		
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentSparkReporter);
		
		extentReports.setSystemInfo("User", System.getProperty("user.name").toUpperCase());
		extentReports.setSystemInfo("Environment", "TEST");
		extentReports.setSystemInfo("OS", System.getProperty("os.name"));
		
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context, Method method, Object[] obj) {
		
		System.out.println("beforeMethod()");
		
		String methodName = method.getAnnotation(Test.class).testName().replaceAll(":", "-").replaceAll("[\\\\/*?\"<>|]", "&");
		ExtentTest extentTest = extentReports.createTest(methodName);
		
		testInfoMap.put(Thread.currentThread().getId(), extentTest);
		
//		List<String> groups = Arrays.asList(method.getAnnotation(Test.class).groups());
//		extentTest.assignCategory(groups.get(0));
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		System.out.println("afterMethod()");
		
		ExtentTest extentTest = testInfoMap.get(Thread.currentThread().getId());
		
		try {
			
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.pass(MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
			}
			
			else if (result.getStatus() == ITestResult.FAILURE) {
				extentTest.fail(MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
				extentTest.fail(result.getThrowable());
				
				// To Capture screenshots.
//				if (actions.getWebDriver() != null) {
//					String fileName = ScreenGrabber.getScreenshot(actions, testInfoString);
//					testInfo.fail(actions.getWebDriver().getCurrentUrl(),
//							MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
//					writeCalculationDataToTable(false, null, actions.getBrowserName());
//				}
			}
			
			else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.skip(MarkupHelper.createLabel(result.getThrowable().getMessage(), ExtentColor.BLUE));
				extentTest.skip(MarkupHelper.createLabel(result.getName() + " Test Case skipped", ExtentColor.ORANGE));
				extentTest.skip(result.getThrowable());
				
				// To Capture screenshots.
//				if (actions.getWebDriver() != null) {
//					String fileName = ScreenGrabber.getScreenshot(actions, testInfoString);
//					testInfo.fail(actions.getWebDriver().getCurrentUrl(),
//							MediaEntityBuilder.createScreenCaptureFromPath(fileName).build());
//					writeCalculationDataToTable(false, null, actions.getBrowserName());
//				}
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			long milliSecs = result.getEndMillis() - result.getStartMillis();
			extentTest.log(Status.INFO, MarkupHelper.createLabel(String.format("Time taken - %d Minutes %d Seconds",
					(milliSecs / 1000) / 60, (milliSecs / 1000) % 60), ExtentColor.BROWN));
		}
		
	}
	
	@AfterSuite
	public void afterSuite() {
		
		System.out.println("afterSuite()");
		
		extentReports.flush();
		
		new File("./archive").mkdirs();
		List<String> targetPath = new ArrayList<String>();
		targetPath.add("./test-output/ExtentReport");
		
		
	}
	
}