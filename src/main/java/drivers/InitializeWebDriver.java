package drivers;

import com.epam.healenium.SelfHealingDriver;
import org.openqa.selenium.WebDriver;

public class InitializeWebDriver {

    private static InitializeWebDriver instance = null;
    private WebDriver delegate;

    private InitializeWebDriver(){
        delegate = new Drivers().strategyDriver();
        SelfHealingDriver driver = SelfHealingDriver.create(delegate);
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
        delegate.quit();
    }

    public WebDriver getDriver(){
        return delegate;
    }

}
