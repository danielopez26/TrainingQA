import drivers.Drivers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TestGoogle {

    public WebDriver driver = new Drivers().strategyDriver();

    @BeforeEach
    public void setUp(){
        driver.get("https://www.google.com.co/");
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Youtube");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        WebElement youtube = driver.findElement(By.xpath("//*[@class = \"LC20lb DKV0Md\" and text()=\"YouTube\"]"));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assertions.assertEquals("YouTube", "YouTube");
    }

    @AfterEach
    public void tearDown(){
        driver.quit();
    }
}
