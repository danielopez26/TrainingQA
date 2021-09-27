package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    private WebDriverWait wait;

    public AddressPage() {
        wait = new WebDriverWait(InstantiateDriver.getInstance().getDriver(), 20);
        PageFactory.initElements(InstantiateDriver.getInstance().getDriver(), this);
    }

    @FindBy(name = "processAddress")
    private WebElement btnConfirmAddress;

    public void confirmAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddress));
        btnConfirmAddress.click();
    }
}
