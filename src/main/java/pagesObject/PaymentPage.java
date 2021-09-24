package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {

    private InstantiateDriver init;
    private WebDriverWait wait;
    private Actions actions;

    public PaymentPage() {
        wait = new WebDriverWait(init.getDriver(), 20);
        actions = new Actions(init.getDriver());
        PageFactory.initElements(init.getDriver(), this);
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
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
    }

    public String checkFinalStatus(){
        wait.until(ExpectedConditions.elementToBeClickable(orderConfirmationMessage));
        return orderConfirmationMessage.getText();
    }
}
