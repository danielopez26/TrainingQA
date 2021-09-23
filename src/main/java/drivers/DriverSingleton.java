package drivers;

import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    private static DriverSingleton instance = null;
    private static WebDriver driver;

    private DriverSingleton(){
        driver = new Drivers().strategyDriver();
    }

    public static DriverSingleton getInstance(){
        if (instance == null){
            instance = new DriverSingleton();
        }
        return instance;
    }

    public static void closeObjectInstance () {
        instance =  null;
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }

}
