import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.demoqa.StudentRegistrationFormPage;
import pages.demoqa.SuccessfulregistrationPage;

public class TestDemoqa {

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
        studentFormPage.fillBasicData("Daniel", "Lopez", "daniel.26@yopmail.com", "1234567890");
        studentFormPage.setData("English",System.getProperty("user.dir") + "\\src\\test\\resources\\images\\test.png");
        studentFormPage.setAddress("esta data es de prueba","Haryana","Karnal");
        Assertions.assertEquals(messageFormPage.getSuccessfulMessage(),"Thanks for submitting the form");
    }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
