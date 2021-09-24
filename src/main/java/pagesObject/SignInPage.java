package pagesObject;


import drivers.InstantiateDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage {

    private InstantiateDriver init = InstantiateDriver.getInstance();
    private WebDriverWait wait;

    public SignInPage() {
        PageFactory.initElements(init.getDriver(), this);
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

