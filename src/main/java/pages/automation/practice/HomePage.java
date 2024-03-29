package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    private WebDriverWait wait;
    private Actions actions;

    public HomePage() {
        actions = new Actions(InitializeWebDriver.getInstance().getDriver());
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(), 20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(css = "a.product-name[title=\"Faded Short Sleeve T-shirts\"]")
    private WebElement product;

    @FindBy(css = "a.button[data-id-product=\"1\"]")
    private WebElement addToCart;

    public CartPage addToCartTShirt(){
        wait.until(ExpectedConditions.elementToBeClickable(product));
        product.sendKeys(Keys.DOWN);
        product.sendKeys(Keys.DOWN);
        InitializeWebDriver.getInstance().getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions.moveToElement(product).build().perform();
        wait.until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        return new CartPage();
    }
}
