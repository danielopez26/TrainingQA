import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class TestChrome {

    private WebDriver driver;

    @BeforeAll
    public static void setUpDriver(){
        //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("https://www.google.com.co/");
        driver.manage().window().maximize();
    }
    @Test
    public void testSearch(){
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Youtube");
        searchBox.submit();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String title = driver.getTitle();
        Assertions.assertEquals("Youtube - Google Search", driver.getTitle());

    }
    @AfterEach
    public void tearDown(){
        driver.quit();
    }

    @AfterAll
    public static void tearDownAfterClass(){
        System.out.println("Finalizado");
    }
}
