import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.demoqa.StudentRegistrationFormPage;

public class DemoqaTest {

    @BeforeEach
    public void setUp(){
        InitializeWebDriver.getInstance().getDriver().get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormAndValidate(){
        String successfulMessage = new StudentRegistrationFormPage().fillBasicData("Daniel", "Lopez","daniel.26@yopmail.com","1234567890")
                                .setData("English", System.getProperty("user.dir") + "\\src\\test\\resources\\images\\test.png")
                                .setAddress("","Haryana","Karnal")
                                .getSuccessfulMessage();
        Assertions.assertEquals("Thanks for submitting the form", successfulMessage);
    }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
