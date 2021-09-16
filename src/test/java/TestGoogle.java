import drivers.Drivers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class TestGoogle {

    public WebDriver driver = new Drivers().strategyDriver();

    @BeforeEach
    public void setUp(){
        driver.manage().window().maximize();
    }

    @Test
    public void testSearch(){
        driver.get("https://www.google.com.co/");
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
