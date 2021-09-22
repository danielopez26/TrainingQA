package pagesObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {
    private WebDriverWait wait;
    private WebDriver driver;

    public SummaryPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,20);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//p//span[contains(text(),'Proceed to checkout')]")
    private WebElement btnProceedSumary;

    public void goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProceedSumary));
        btnProceedSumary.click();
    }
}
