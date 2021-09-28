package drivers;

import org.openqa.selenium.WebDriver;

public class InitializeWebDriver {

    private static InitializeWebDriver instance = null;
    private WebDriver driver;

    private InitializeWebDriver(){
        driver = new Drivers().strategyDriver();
        driver.manage().window().maximize();
    }

    synchronized public static InitializeWebDriver getInstance(){
        if (instance == null){
            instance = new InitializeWebDriver();
        }
        return instance;
    }

    public void closeObjectInstance() {
        instance = null;
        driver.quit();
    }

    public WebDriver getDriver(){
        return driver;
    }

}
