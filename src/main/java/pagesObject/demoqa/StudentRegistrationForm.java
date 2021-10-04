package pagesObject.demoqa;

import drivers.InitializeWebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class StudentRegistrationForm {

    private WebDriverWait wait;

    public StudentRegistrationForm() {
        wait = new WebDriverWait(InitializeWebDriver.getInstance().getDriver(), 10);
        PageFactory.initElements(InitializeWebDriver.getInstance().getDriver(), this);
    }

    @FindBy(id = "firstName")
    private WebElement firstNameInput;

    @FindBy(id = "lastName")
    private WebElement lastNameInput;

    @FindBy(id = "userEmail")
    private WebElement emailInput;

    @FindBy(xpath = "//label[@for='gender-radio-1']")
    private WebElement genderRadio;

    @FindBy(id = "userNumber")
    private WebElement mobileNumberInput;

    @FindBy(id = "dateOfBirthInput")
    private WebElement calendar;

    @FindBy(xpath = "//*[@aria-label = \"Choose Friday, October 1st, 2021\"]")
    private WebElement dayOfCalendar;

    @FindBy(id = "subjectsInput")
    private WebElement subjectsInput;

    @FindBy(xpath = "//label[@for='hobbies-checkbox-1']")
    private WebElement hobbiesRadio;

    @FindBy(id = "currentAddress")
    private WebElement currentAddressInput;

    @FindBy(id = "react-select-3-input")
    private WebElement stateList;

    @FindBy(id = "react-select-4-input")
    private WebElement cityList;

    @FindBy(id = "submit")
    private WebElement submitButton;

    @FindBy(id = "uploadPicture")
    private WebElement uploadPicture;

    public void fillBasicData(String FirstName, String lastName, String email, String number){
        firstNameInput.sendKeys(FirstName);
        lastNameInput.sendKeys(lastName);
        emailInput.sendKeys(email);
        genderRadio.click();
        mobileNumberInput.sendKeys(number);
        calendar.click();
        dayOfCalendar.click();
    }

    public void setData(String subjects, String image){
        currentAddressInput.sendKeys(Keys.TAB);
        wait.until(ExpectedConditions.elementToBeClickable(subjectsInput));
        subjectsInput.sendKeys(subjects);
        subjectsInput.sendKeys(Keys.TAB);
        hobbiesRadio.click();
        uploadPicture.sendKeys(image);

    }

    public void setAddress(String address, String state, String city){
        currentAddressInput.sendKeys(address);
        stateList.sendKeys(state);
        stateList.sendKeys(Keys.TAB);
        cityList.sendKeys(city);
        cityList.sendKeys(Keys.TAB);
        submitButton.sendKeys(Keys.PAGE_DOWN);
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        submitButton.click();
    }

}
