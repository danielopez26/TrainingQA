package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddressPage {

    WebDriverWait wait;
    WebDriver driver;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "processAddress")
    private WebElement btnConfirmAddress;

    public void confirmAddress(){
        wait.until(ExpectedConditions.elementToBeClickable(btnConfirmAddress));
        btnConfirmAddress.click();
    }
}
