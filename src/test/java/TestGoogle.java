import drivers.Drivers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestGoogle {

    public WebDriver driver = new Drivers().strategyDriver();
    WebDriverWait wait =  new WebDriverWait(driver,20);

    @BeforeEach
    public void setUp(){
        //driver.get("https://www.google.com.co/");
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Youtube");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement youtube = driver.findElement(By.xpath("//*[@class = \"LC20lb DKV0Md\" and text()=\"YouTube\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("YouTube", "YouTube");
    }

    @Test
    public void purchase() throws InterruptedException {

        WebElement product = driver.findElement(By.xpath("//ul[contains(@class,'active')]//a[contains(text(),'Faded Short Sleeve T-shirt')]"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)",product);

        Actions hover = new Actions(driver);
        hover.moveToElement(product).build().perform();

        WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
        addToCart.click();

        WebElement proceedToCheckout = driver.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();

        WebElement btnProceedSummary = driver.findElement(By.xpath("//p//span[contains(text(),'Proceed to checkout')]"));
        btnProceedSummary.click();

        WebElement email = driver.findElement(By.id("email"));
        WebElement password = driver.findElement(By.id("passwd"));
        WebElement btnSignIn = driver.findElement(By.id("SubmitLogin"));
        email.sendKeys("daniel.26@yopmail.com");
        password.sendKeys("12345678");
        btnSignIn.click();

        WebElement btnConfirmAddress = driver.findElement(By.name("processAddress"));
        btnConfirmAddress.click();

        WebElement chkTermsShipping = driver.findElement(By.id("uniform-cgv"));
        js.executeScript("arguments[0].scrollIntoView(true)", chkTermsShipping);
        WebElement btnConfirmShipping = driver.findElement(By.name("processCarrier"));
        chkTermsShipping.click();
        btnConfirmShipping.click();

        WebElement payByBankWire = driver.findElement(By.className("bankwire"));
        payByBankWire.click();

        WebElement confirmOrder = driver.findElement(By.xpath("//button[span = \"I confirm my order\"]"));
        confirmOrder.click();

        WebElement orderConfirmationMessage = driver.findElement(By.xpath("//strong[text() = \"Your order on My Store is complete.\"]"));
        Assertions.assertEquals(orderConfirmationMessage.getText(), "Your order on My Store is complete.");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }

}
