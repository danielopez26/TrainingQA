package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    private InstantiateDriver init = InstantiateDriver.getInstance();
    private WebDriverWait wait;

    public AddressPage() {
        wait = new WebDriverWait(init.getDriver(), 20);
        PageFactory.initElements(init.getDriver(), this);
    }

    @FindBy(name = "processAddress")
    private WebElement btnConfirmAddress;

    public void confirmAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddress));
        btnConfirmAddress.click();
    }
}
