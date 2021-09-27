package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriverWait wait;

    public CartPage () {
        wait = new WebDriverWait(InstantiateDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InstantiateDriver.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckout;

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
    }

}
