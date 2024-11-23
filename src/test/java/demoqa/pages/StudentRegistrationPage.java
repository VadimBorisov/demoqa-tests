package demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import demoqa.pages.components.CalendarComponent;
import demoqa.pages.components.RegistrationResultModal;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationPage {
  private final String TESTING_URL = "/automation-practice-form";
  private CalendarComponent dateOfBirth = new CalendarComponent();
  private RegistrationResultModal resultModal = new RegistrationResultModal();

  private SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),
          gender = $("#genterWrapper"),
          phoneNumberInput = $("#userNumber"),
          subjectsInput = $("#subjectsInput"),
          hobbies = $("#hobbiesWrapper"),
          picture = $("#uploadPicture"),
          address = $("#currentAddress"),
          stateAndCity = $("#stateCity-wrapper"),
          submitButton = $("#submit");

  public StudentRegistrationPage openPage() {
    open(TESTING_URL);

    return this;
  }

  public StudentRegistrationPage setFirstName(String value) {
    firstNameInput.setValue(value);

    return this;
  }

  public StudentRegistrationPage setLastName(String value) {
    lastNameInput.setValue(value);

    return this;
  }

  public StudentRegistrationPage setEmail(String value) {
    emailInput.setValue(value);

    return this;
  }

  public StudentRegistrationPage setGender(String value) {
    gender.$(byText(value)).click();

    return this;
  }

  public StudentRegistrationPage setPhone(String value) {
    phoneNumberInput.setValue(value);

    return this;
  }

  public StudentRegistrationPage setSubject(String value) {
    subjectsInput.setValue(value).pressEnter();

    return this;
  }

  public StudentRegistrationPage setHobbies(String value) {
    hobbies.$(byText(value)).click();

    return this;
  }

  public StudentRegistrationPage uploadPicture(String filename) {
    picture.uploadFromClasspath(filename);

    return this;
  }

  public StudentRegistrationPage setAddress(String value) {
    address.setValue(value);

    return this;
  }

  public StudentRegistrationPage setStateAndCity(String state, String city) {
    $("#state").click();
    stateAndCity.$(byText(state)).click();
    $("#city").click();
    stateAndCity.$(byText(city)).click();

    return this;
  }

  public StudentRegistrationPage setDateOfBirth(String day, String month, String year) {
    $("#dateOfBirthInput").click();
    dateOfBirth.setDate(day, month, year);

    return this;
  }

  public void submitRegistration() {
    submitButton.click();
  }

  public StudentRegistrationPage verifyResultsModalAppears() {
    resultModal.verifyModalAppears();

    return this;
  }

  public StudentRegistrationPage verifyResult(String key, String value) {
    resultModal.verifyResult(key, value);

    return this;
  }
}
