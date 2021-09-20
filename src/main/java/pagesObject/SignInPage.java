package pagesObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage {

    private WebDriverWait wait;
    private WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

