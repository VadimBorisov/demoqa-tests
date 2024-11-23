package tests;

import com.codeborne.selenide.Configuration;
import demoqa.pages.StudentRegistrationPage;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {
  StudentRegistrationPage registrationPage = new StudentRegistrationPage();

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "none";
    Configuration.browserPosition = "0x0";
    Configuration.holdBrowserOpen = true;
  }
}
