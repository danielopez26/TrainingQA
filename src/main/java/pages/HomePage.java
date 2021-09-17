package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private By addToCart = By.xpath("//span[text()='Add to cart']");
    private By proceedToCheckout = By.xpath("//span[contains(text(),'Proceed to checkout')]");

    public void addToCart(){
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement product = driver.findElement(By.xpath("//ul[contains(@class,'active')]//a[contains(text(),'Faded Short Sleeve T-shirt')]"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(product));
        actions.moveToElement(product).build().perform();
        driver.findElement(addToCart).click();
    }

    public void proceedToCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(proceedToCheckout));
        driver.findElement(proceedToCheckout).click();
    }
}
