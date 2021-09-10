package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome {

    public ChromeDriver setDriver(){
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
