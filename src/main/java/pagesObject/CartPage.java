package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckout;

    public void proceedToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        proceedToCheckout.click();
    }

}
