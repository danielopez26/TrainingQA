package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SignInPage {

    WebDriver driver;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    private By email = By.id("email");
    private By password = By.id("passwd");
    private By btnSignIn = By.id("SubmitLogin");


    public void login (){
        driver.findElement(email).sendKeys("daniel.26@yopmail.com");
        driver.findElement(password).sendKeys("12345678");
        driver.findElement(btnSignIn).click();
    }
}
