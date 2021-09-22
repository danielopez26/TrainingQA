import drivers.Drivers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pagesObject.*;


public class TestAutomationPractice {

    private WebDriver driver = new Drivers().strategyDriver();
    private HomePage homePage;
    private CartPage cartPage;
    private SummaryPage summaryPage;
    private SignInPage signInPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp(){
        homePage = new HomePage(driver);
        cartPage = new CartPage(driver);
        summaryPage =  new SummaryPage(driver);
        signInPage = new SignInPage(driver);
        addressPage = new AddressPage(driver);
        shippingPage =  new ShippingPage(driver);
        paymentPage = new PaymentPage(driver);
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){
        homePage.addToCartTShirt();
        cartPage.proceedToCheckout();
        summaryPage.goToCheckout();
        signInPage.login("daniel.26@yopmail.com","12345678");
        addressPage.confirmAddress();
        shippingPage.confirmShipping();
        paymentPage.payByBankwire();
        paymentPage.confirmFinalOrder();
        Assertions.assertEquals(paymentPage.checkFinalStatus(),"Your order on My Store is complete.");
        }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}