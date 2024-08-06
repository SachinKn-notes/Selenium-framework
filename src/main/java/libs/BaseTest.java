package libs;

import org.testng.annotations.*;

public class BaseTest {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Running beforeSuite()");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Running afterSuite()");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Running beforeMethod()");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Running afterMethod()");
    }

    @DataProvider(name = "DataProvider")
    public Object[][] dataProvider() {
        return new Object[][] {
            { new WebDriveActions() }
        };
    }
}
