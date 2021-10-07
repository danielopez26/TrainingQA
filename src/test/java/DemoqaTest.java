import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.demoqa.StudentRegistrationFormPage;
import pages.demoqa.SuccessfulregistrationPage;

public class DemoqaTest {

    private StudentRegistrationFormPage studentFormPage;
    private SuccessfulregistrationPage messageFormPage;

    @BeforeEach
    public void setUp(){
        studentFormPage = new StudentRegistrationFormPage();
        messageFormPage = new SuccessfulregistrationPage();
        InitializeWebDriver.getInstance().getDriver().get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormAndValidate(){
        studentFormPage.fillBasicData("Daniel", "Lopez", "1234567890");
        Assertions.assertEquals(messageFormPage.getSuccessfulMessage(),"Thanks for submitting the form");
    }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
