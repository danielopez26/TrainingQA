package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriverWait wait;

    public CartPage () {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(css = "a[title= 'Proceed to checkout']")
    private WebElement proceedToCheckout;

    public SummaryPage proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
        return new SummaryPage();
    }

}
