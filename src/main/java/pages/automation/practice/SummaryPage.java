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

    @FindBy(css = "a[href=\"http://automationpractice.com/index.php?controller=order&step=1\"]")
    private WebElement btnProceedSumary;

    public SignInPage goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProceedSumary));
        btnProceedSumary.click();
        return new SignInPage();
    }
}
