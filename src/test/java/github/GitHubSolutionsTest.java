package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSolutionsTest {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://github.com/";
    Configuration.browserSize = "1920x1080";
//    Configuration.pageLoadStrategy = "none";
//    Configuration.holdBrowserOpen = true;
  }

  @Test
  void shouldOpenEnterprisePage() {
    open("");

    $x("//button[contains(text(), 'Solutions')]").hover();
    $x("//a[contains(text(), 'Enterprises')]").click();
    $("a[data-testid=SubNav-root-heading]").shouldHave(text("Enterprise"));
  }

}
