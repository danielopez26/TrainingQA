package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Drivers {

    public WebDriver strategyDriver(){
        String browserType = System.getProperty("browserType", "SauceChrome");
        String browser = System.getProperty("browser", "Firefox");
        switch (browser){
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();
            case "SauceLabs":
                String URL = "https://daniel.26:409b27ce-b7cc-417b-b200-7d46996d36f6@ondemand.us-west-1.saucelabs.com:443/wd/hub";
                switch (browserType){
                    case "SauceChrome":
                        try{
                            ChromeOptions browserOptions = new ChromeOptions();
                            browserOptions.setCapability("name", "SauceLabs Test");
                            browserOptions.setCapability("platformName", "Windows 10");
                            browserOptions.setCapability("browserName","Chrome");
                            browserOptions.setCapability("browserVersion", "latest");
                            Map<String, Object> sauceOptions = new HashMap<>();
                            browserOptions.setCapability("sauce:options", sauceOptions);
                            return new RemoteWebDriver(new URL(URL), browserOptions);
                        } catch(MalformedURLException error){
                            throw new IllegalStateException("Unexpected URL: " + URL);
                        }

                    case "SauceFirefox":
                        try{
                            FirefoxOptions browserOptions = new FirefoxOptions();
                            browserOptions.setCapability("name", "SauceLabs Test");
                            browserOptions.setCapability("platformName", "Windows 10");
                            browserOptions.setCapability("browserName","Firefox");
                            browserOptions.setCapability("browserVersion", "latest");
                            Map<String, Object> sauceOptions = new HashMap<>();
                            browserOptions.setCapability("sauce:options", sauceOptions);
                            return new RemoteWebDriver(new URL(URL), browserOptions);
                        } catch(MalformedURLException error){
                            throw new IllegalStateException("Unexpected URL: " + URL);
                        }
                }
            default:
                throw new IllegalStateException("Unexpected value: " + browser);
        }
    }
}
