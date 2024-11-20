package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class FormsTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "none";
//    Configuration.holdBrowserOpen = true;
  }

  @Test
  void successfulFormTest() {
    final String TESTING_URL = "/automation-practice-form";

    open(TESTING_URL);

    //Filling first name field
    $("#firstName").setValue("Vadim");

    //Filling last name field
    $("#lastName").setValue("Borisov");

    //Filling email field
    $("#userEmail").setValue("vadimborisov@list.ru");

    //Select gender
    $(byText("Male")).click();

    //Filling phone number
    $("#userNumber").setValue("9511037292");

    //Select date of birth
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOptionContainingText("March");
    $(".react-datepicker__year-select").selectOptionContainingText("1991");
    $x("//div[@class='react-datepicker__week']/div[contains(text(), '15')]").click();

    //Filling subject field
    $("#subjectsInput").setValue("English").sendKeys(Keys.ENTER);

    //Select hobbies
    $(byText("Music")).click();
    $(byText("Reading")).click();

    //Filling current address
    $("#currentAddress").setValue("Ryazan, Bystreckaya Street");

    //Select state and city
    $("#react-select-3-input").setValue("NCR").sendKeys(Keys.ENTER);
    $("#react-select-4-input").setValue("Delhi").sendKeys(Keys.ENTER);

    //Click on submit button
    $("#submit").click();

    //Check successful text
    $(".modal-content").shouldHave(text("Thanks for submitting the form"));
  }

}
