package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    private WebDriverWait wait;

    public ShippingPage() {
        wait = new WebDriverWait(InstantiateDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InstantiateDriver.getInstance().getDriver(), this);
    }

    @FindBy(id = "uniform-cgv")
    private WebElement chkTermsShipping;

    @FindBy(name = "processCarrier")
    private WebElement btnConfirmShipping;

    public void confirmShipping(){
        wait.until(ExpectedConditions.elementToBeClickable(chkTermsShipping));
        chkTermsShipping.click();
        btnConfirmShipping.click();
    }
}
