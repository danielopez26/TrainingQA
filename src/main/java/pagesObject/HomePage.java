package pagesObject;

import drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriver driver;
    private Actions actions;

    public HomePage() {
        this.driver = DriverSingleton.getDriver();
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//ul[contains(@class,'active')]//a[contains(text(),'Faded Short Sleeve T-shirt')]")
    private WebElement product;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCart;

    public void addToCartTShirt(){
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(product).build().perform();
        addToCart.click();
    }
}
