import drivers.Drivers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.CheckoutPage;
import pages.HomePage;
import pages.SignInPage;


public class TestAutomationPractice {

    WebDriver driver = new Drivers().strategyDriver();
    HomePage homePage = new HomePage(driver);
    SignInPage signInPage = new SignInPage(driver);
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @BeforeEach
    public void setUp(){
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void purchase(){
        homePage.addToCart();
        homePage.proceedToCheckout();
        checkoutPage.goToCheckout();
        signInPage.login();
        checkoutPage.confirmAddress();
        checkoutPage.confirmShipping();
        checkoutPage.payByBankwire();
        checkoutPage.confirmFinalOrder();
        checkoutPage.checkFinalStatus();
        }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
