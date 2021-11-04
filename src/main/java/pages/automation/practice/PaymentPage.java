package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class PaymentPage {

    private WebDriverWait wait;
    private Actions actions;

    public PaymentPage() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(), 20);
        actions = new Actions(InitializeWebDriver.getInstance().getDriver());
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(className = "bankwire")
    private WebElement payByBankwire;

    @FindBy(css = "button.button-medium[type=submit]")
    private WebElement confirmOrder;

    @FindBy(xpath = "//strong[text() = \"Your order on My Store is complete.\"]")
    private WebElement orderConfirmationMessage;

    public PaymentPage payByBankwire(){
        wait.until(ExpectedConditions.elementToBeClickable(payByBankwire));
        payByBankwire.click();
        return this;
    }

    public PaymentPage confirmFinalOrder(){
        wait.until(ExpectedConditions.elementToBeClickable(confirmOrder));
        confirmOrder.click();
        return this;
    }

    public String checkFinalStatus(){
        wait.until(ExpectedConditions.visibilityOf(orderConfirmationMessage));
        return orderConfirmationMessage.getText();
    }
}
