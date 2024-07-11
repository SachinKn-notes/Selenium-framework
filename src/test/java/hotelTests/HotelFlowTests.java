package hotelTests;

import io.restassured.path.json.JsonPath;
import libs.BaseTest;
import libs.WebDriverActions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HotelFlowTests extends BaseTest {

    @Test(testName = "Hotel Flow Full Payment Test", dataProvider = "genericDataProvider", groups = {"Id-07", "smoke"})
    @Parameters(value = {"hotel", "fullPayment"})
    public void hotelFlowFullPaymentTest(WebDriverActions actions, JsonPath testData) throws Exception {

    }

    @Test(testName = "Hotel Flow Deposit Payment Test", dataProvider = "genericDataProvider", groups = {"Id-08", "smoke"})
    @Parameters(value = {"hotel", "depositPayment"})
    public void hotelFlowDepositPaymentTest(WebDriverActions actions, JsonPath testData) {

    }

    @Test(testName = "Hotel Flow Hold Payment Test", dataProvider = "genericDataProvider", groups = {"Id-09", "reg"})
    @Parameters(value = {"hotel", "holdPayment"})
    public void hotelFlowHoldPaymentTest(WebDriverActions actions, JsonPath testData) {

    }
}
