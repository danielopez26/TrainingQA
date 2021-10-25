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
        String path = System.getProperty("user.dir");
        String fileSeparator = System.getProperty("file.separator");
        String successfulMessage = new StudentRegistrationFormPage().fillBasicData("Daniel", "Lopez","daniel.26@yopmail.com","1234567890")
                                .setHobbies("Reading")
                                .setImage( path + fileSeparator + "src" + fileSeparator + "test" + fileSeparator + "resources" + fileSeparator + "images" + fileSeparator + "test.png")
                                .setAddress("Haryana","Karnal")
                                .getSuccessfulMessage();
        Assertions.assertEquals("Thanks for submitting the form", successfulMessage);
    }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
