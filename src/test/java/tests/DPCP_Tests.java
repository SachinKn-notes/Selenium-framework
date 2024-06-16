package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import hub.BaseTest;


public class DPCP_Tests extends BaseTest {
	
	static {
		System.setProperty("webdriver.chrome.driver", "D:\\Work\\EXEs\\chromedriver.exe");
	}
	
	@Test(testName = "ODY-1 : Verify Cruise Only Test", groups = {"ODY-1", "smoke"})
	public void test_1() throws InterruptedException {
		System.out.println("test_1()");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.odysol.com/swift/cruise?siid=130386");
		driver.quit();

	}
	
	@Test(testName = "ODY-2 : Verify Cruise Only Test", groups = {"ODY-2", "smoke"})
	public void test_2() {
		System.out.println("test_2()");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.odysol.com/swift/cruise?siid=130386");
		driver.quit();
	}
	
	@Test(testName = "ODY-3 : Verify Cruise Only Test", groups = {"ODY-3", "reg"})
	public void test_3() throws InterruptedException {
		System.out.println("test_3()");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.odysol.com/swift/cruise?siid=130386");
		driver.quit();
		
		Assert.fail();
	}
	
	@Test(testName = "ODY-4 : Verify Cruise Only Test", groups = {"ODY-4", "reg"})
	public void test_4() {
		System.out.println("test_4()");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.odysol.com/swift/cruise?siid=130386");
		driver.quit();
		
		Assert.fail();
	}
	
	@Test(testName = "ODY-5 : Verify Cruise Only Test", groups = {"ODY-5", "reg", "smoke"})
	public void test_5() {
		System.out.println("test_5()");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://uat.odysol.com/swift/cruise?siid=130386");
		driver.quit();
		
	}
	
}