package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CheckoutPage {

    WebDriverWait wait;
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
    }

    private By btnProceedSumary = By.xpath("//p//span[contains(text(),'Proceed to checkout')]");
    private By btnConfirmAddress = By.name("processAddress");
    private By chkTermsShipping = By.id("uniform-cgv");
    private By btnConfirmShipping = By.name("processCarrier");
    private By payByBankwire = By.className("bankwire");
    private By confirmOrder = By.xpath("//button[span = \"I confirm my order\"]");
    private By orderConfirmationMessage = By.xpath("//strong[text() = \"Your order on My Store is complete.\"]");

    public void goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProceedSumary));
        driver.findElement(btnProceedSumary).click();
    }

    public void confirmAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddress));
        driver.findElement(btnConfirmAddress).click();
    }

    public void confirmShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(chkTermsShipping));
        driver.findElement(chkTermsShipping).click();
        driver.findElement(btnConfirmShipping).click();
    }

    public void payByBankwire(){
        wait.until(ExpectedConditions.elementToBeClickable(payByBankwire));
        driver.findElement(payByBankwire).click();
    }

    public void confirmFinalOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        driver.findElement(confirmOrder).click();
    }

    public Boolean checkFinalStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return driver.findElement(orderConfirmationMessage).getText().contains("Your order on My Store is complete.");
    }
}
