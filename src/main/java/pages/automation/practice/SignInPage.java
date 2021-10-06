package pages.automation.practice;


import drivers.InitializeWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage {

    private WebDriverWait wait;

    public SignInPage() {
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "passwd")
    private WebElement password;

    @FindBy(id = "SubmitLogin")
    private WebElement btnsignIn;

    public void login (String username, String passwd){
        email.sendKeys(username);
        password.sendKeys(passwd);
        btnsignIn.click();
    }
}

