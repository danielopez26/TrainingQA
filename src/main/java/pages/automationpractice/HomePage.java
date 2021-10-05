package pages.automationpractice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private Actions actions;

    public HomePage() {
        actions = new Actions(InitializeWebDriver.getInstance().getDriver());
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//ul[contains(@class,'active')]//a[contains(text(),'Faded Short Sleeve T-shirt')]")
    private WebElement product;

    @FindBy(xpath = "//span[text()='Add to cart']")
    private WebElement addToCart;

    public void addToCartTShirt(){
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        product.sendKeys(Keys.DOWN);
        InitializeWebDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.moveToElement(product).build().perform();
        addToCart.click();
    }
}
