package tests;

import org.junit.jupiter.api.Test;

public class FormsTests extends BaseTest {

  @Test
  void successfulFormTest() {
    registrationPage.openPage()
            .setFirstName("Vadim")
            .setLastName("Borisov")
            .setEmail("vadim@test.com")
            .setGender("Other")
            .setPhone("1234567890")
            .setDateOfBirth("15", "March", "1991")
            .setSubject("English")
            .setHobbies("Music")
            .uploadPicture("img/test_picture.jpg")
            .setAddress("Some address")
            .setStateAndCity("NCR", "Delhi")
            .submitRegistration();

    //Check successful text
    registrationPage.verifyResultsModalAppears()
            .verifyResult("Student Name", "Vadim Borisov")
            .verifyResult("Student Email", "vadim@test.com")
            .verifyResult("Gender", "Other")
            .verifyResult("Mobile", "1234567890")
            .verifyResult("Date of Birth", "15 March,1991")
            .verifyResult("Subjects", "English")
            .verifyResult("Hobbies", "Music")
            .verifyResult("Picture", "test_picture.jpg")
            .verifyResult("Address", "Some address")
            .verifyResult("State and City", "NCR Delhi");
  }

}
