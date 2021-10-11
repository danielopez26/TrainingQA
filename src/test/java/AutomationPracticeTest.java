import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.automation.practice.*;


public class AutomationPracticeTest {

    private HomePage homePage;
    private CartPage cartPage;
    private SummaryPage summaryPage;
    private SignInPage signInPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp(){

        homePage = new HomePage();
        cartPage = new CartPage();
        summaryPage =  new SummaryPage();
        signInPage = new SignInPage();
        addressPage = new AddressPage();
        shippingPage =  new ShippingPage();
        paymentPage = new PaymentPage();
        InitializeWebDriver.getInstance().getDriver().get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){
        homePage.addToCartTShirt();
        cartPage.proceedToCheckout();
        summaryPage.goToCheckout();
        signInPage.login("daniel.26@yopmail.com","12345678");
        addressPage.confirmAddress();
        shippingPage.confirmShipping();
        paymentPage.payByBankwire()
                .confirmFinalOrder();
        Assertions.assertEquals(paymentPage.checkFinalStatus(),"Your order on My Store is complete.");
        }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
