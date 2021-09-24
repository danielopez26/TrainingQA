package drivers;

import org.openqa.selenium.WebDriver;

public class InstantiateDriver {

    private static InstantiateDriver instance = null;
    private WebDriver driver;

    private InstantiateDriver(){
        driver = new Drivers().strategyDriver();
        driver.manage().window().maximize();
    }

    public static InstantiateDriver getInstance(){
        if (instance == null){
            instance = new InstantiateDriver();
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
