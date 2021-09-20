package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {

    WebDriverWait wait;
    WebDriver driver;
    Actions actions;

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "bankwire")
    private WebElement payByBankwire;

    @FindBy(xpath = "//button[span = \"I confirm my order\"]")
    private WebElement confirmOrder;

    @FindBy(xpath = "//strong[text() = \"Your order on My Store is complete.\"]")
    private WebElement orderConfirmationMessage;

    public void payByBankwire(){
        wait.until(ExpectedConditions.elementToBeClickable(payByBankwire));
        payByBankwire.click();
    }

    public void confirmFinalOrder(){
       // actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
    }

    public Boolean checkFinalStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return orderConfirmationMessage.getText().contains("Your order on My Store is complete.");
    }
}
