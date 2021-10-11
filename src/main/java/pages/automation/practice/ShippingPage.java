package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    private WebDriverWait wait;

    public ShippingPage() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(id = "uniform-cgv")
    private WebElement chkTermsShipping;

    @FindBy(name = "processCarrier")
    private WebElement btnConfirmShipping;

    public ShippingPage confirmShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(chkTermsShipping));
        chkTermsShipping.click();
        btnConfirmShipping.click();
        return this;
    }
}
