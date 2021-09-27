package pagesObject;

import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SummaryPage {

    private WebDriverWait wait;

    public SummaryPage() {
        wait = new WebDriverWait(InstantiateDriver.getInstance().getDriver(),20);
        PageFactory.initElements(InstantiateDriver.getInstance().getDriver(), this);
    }

    @FindBy(xpath = "//p//span[contains(text(),'Proceed to checkout')]")
    private WebElement btnProceedSumary;

    public void goToCheckout(){
        wait.until(ExpectedConditions.elementToBeClickable(btnProceedSumary));
        btnProceedSumary.click();
    }
}
