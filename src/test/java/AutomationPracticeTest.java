import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.automation.practice.*;


public class AutomationPracticeTest {

    private HomePage homePage;
    private PaymentPage paymentPage;

    @BeforeEach
    public void setUp(){

        homePage = new HomePage();
        paymentPage = new PaymentPage();
        InitializeWebDriver.getInstance().getDriver().get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){


        homePage.addToCartTShirt()
                        .proceedToCheckout()
                        .goToCheckout()
                        .login("daniel.26@yopmail.com","12345678")
                        .confirmAddress()
                        .confirmShipping()
                        .payByBankwire()
                        .confirmFinalOrder();
        Assertions.assertEquals(paymentPage.checkFinalStatus(),"Your order on My Store is complete.");
        }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
