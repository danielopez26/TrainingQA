import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.automation.practice.*;


public class AutomationPracticeTest {

    @BeforeEach
    public void setUp(){
        InitializeWebDriver.getInstance().getDriver().get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){

        String finalStatus = new HomePage().addToCartTShirt()
                                .proceedToCheckout()
                                .goToCheckout()
                                .login("daniel.26@yopmail.com","12345678")
                                .confirmAddress()
                                .confirmShipping()
                                .payByBankwire()
                                .confirmFinalOrder()
                                .checkFinalStatus();
        Assertions.assertEquals("Your order on My Store is complete.",finalStatus);
        }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
