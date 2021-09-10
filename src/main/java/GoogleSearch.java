import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class GoogleSearch {

    WebDriver driver;

    public void search(WebDriver driver){
        driver.get("https://www.google.com.co/");
        driver.manage().window().maximize();

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Youtube");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement youtube = driver.findElement(By.xpath("//*[@class = \"LC20lb DKV0Md\" and text()=\"YouTube\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("YouTube", "YouTube");

        driver.quit();
    }
}
