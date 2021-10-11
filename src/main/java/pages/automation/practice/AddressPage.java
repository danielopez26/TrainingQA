package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    private WebDriverWait wait;

    public AddressPage() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(), 20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(name = "processAddress")
    private WebElement btnConfirmAddress;

    public AddressPage confirmAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddress));
        btnConfirmAddress.click();
        return this;
    }
}
