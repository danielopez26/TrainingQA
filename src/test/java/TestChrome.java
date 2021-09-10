import drivers.Chrome;
import drivers.Firefox;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestChrome {

    GoogleSearch googleSearch = new GoogleSearch();
    Chrome chrome =  new Chrome();
    Firefox firefox = new Firefox();

    @Test
    public void testSearch(){

        googleSearch.search(firefox.setDriver());
        googleSearch.search(chrome.setDriver());
    }
}
