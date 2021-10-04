import drivers.InitializeWebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pagesObject.demoqa.StudentRegistrationForm;
import pagesObject.demoqa.Successfulregistration;

public class TestDemoqa {

    private StudentRegistrationForm student;
    private Successfulregistration message;

    @BeforeEach
    public void setUp(){
        student = new StudentRegistrationForm();
        message = new Successfulregistration();
        InitializeWebDriver.getInstance().getDriver().get("https://demoqa.com/automation-practice-form");
    }

    @Test
    public void fillFormAndValidate(){
        student.fillBasicData("Daniel", "Lopez", "daniel.26@yopmail.com", "1234567890");
        student.setData("English",System.getProperty("user.dir") + "\\src\\test\\resources\\testImage.png");
        student.setAddress("esta data es de prueba","Haryana","Karnal");
        Assertions.assertEquals(message.getSuccessfulMessage(),"Thanks for submitting the form");
    }

    @AfterEach
    public void tearDown(){
        InitializeWebDriver.getInstance().closeObjectInstance();
    }
}
