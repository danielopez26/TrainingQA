package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Drivers {

    public String BROWSER = System.getProperty("BROWSER", "firefox");

    public WebDriver strategyDriver(){
        switch (BROWSER){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                WebDriver chromeDriver = new ChromeDriver();
                return chromeDriver;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                WebDriver firefoxDriver = new FirefoxDriver();
                return firefoxDriver;
            default:
                throw new IllegalStateException("Unexpected value: " + BROWSER);
        }
    }
}
