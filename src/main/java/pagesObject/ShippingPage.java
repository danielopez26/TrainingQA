package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShippingPage {

    WebDriverWait wait;
    WebDriver driver;

    public ShippingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver, this);
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
