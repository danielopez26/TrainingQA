package pages.automation.practice;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {

    private WebDriverWait wait;

    public SummaryPage() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//p//span[contains(text(),'Proceed to checkout')]")
    private WebElement btnProceedSumary;

    public SummaryPage goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProceedSumary));
        btnProceedSumary.click();
        return this;
    }
}
