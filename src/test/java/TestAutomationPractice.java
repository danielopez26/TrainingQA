import drivers.Drivers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagesObject.*;


public class TestAutomationPractice {

    WebDriver driver = new Drivers().strategyDriver();
    HomePage homePage = new HomePage(driver);
    CartPage cartPage = new CartPage(driver);
    SummaryPage summaryPage =  new SummaryPage(driver);
    SignInPage signInPage = new SignInPage(driver);
    AddressPage addressPage = new AddressPage(driver);
    ShippingPage shippingPage =  new ShippingPage(driver);

    PaymentPage paymentPage = new PaymentPage(driver);

    @BeforeEach
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){
        homePage.addToCart();
        cartPage.proceedToCheckout();
        summaryPage.goToCheckout();
        signInPage.login();
        addressPage.confirmAddress();
        shippingPage.confirmShipping();
        paymentPage.payByBankwire();
        paymentPage.confirmFinalOrder();
        paymentPage.checkFinalStatus();

        }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
