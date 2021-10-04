package pagesObject.demoqa;

import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Successfulregistration {

    private WebDriverWait wait;

    public Successfulregistration() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(), 20);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(id = "example-modal-sizes-title-lg")
    private WebElement successfulMessage;

    public String getSuccessfulMessage(){
        wait.until(ExpectedConditions.elementToBeClickable(successfulMessage));
        return successfulMessage.getText();
    }
}
