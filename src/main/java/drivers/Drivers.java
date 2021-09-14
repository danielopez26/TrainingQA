package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    public WebDriver strategyDriver(){

        String browser = System.getProperty("browser", "Firefox");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                return chromeDriver;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver firefoxDriver = new FirefoxDriver();
                return firefoxDriver;
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }
}
