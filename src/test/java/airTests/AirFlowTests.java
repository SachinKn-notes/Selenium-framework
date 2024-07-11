package airTests;

import io.restassured.path.json.JsonPath;
import libs.BaseTest;
import libs.WebDriverActions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AirFlowTests extends BaseTest {

    @Test(testName = "Air Flow Full Payment Test", dataProvider = "genericDataProvider", groups = {"Id-04", "smoke"})
    @Parameters(value = {"air", "fullPayment"})
    public void airFlowFullPaymentTest(WebDriverActions actions, JsonPath testData) throws Exception {

    }

    @Test(testName = "Air Flow Deposit Payment Test", dataProvider = "genericDataProvider", groups = {"Id-05", "smoke"})
    @Parameters(value = {"air", "depositPayment"})
    public void airFlowDepositPaymentTest(WebDriverActions actions, JsonPath testData) {

    }

    @Test(testName = "Air Flow Hold Payment Test", dataProvider = "genericDataProvider", groups = {"Id-06", "reg"})
    @Parameters(value = {"air", "holdPayment"})
    public void airFlowHoldPaymentTest(WebDriverActions actions, JsonPath testData) {

    }
}
