package github;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.partialText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class GitHubSelenideTests {

  @BeforeAll
  static void beforeAll() {
    Configuration.baseUrl = "https://github.com/";
    Configuration.browserSize = "1920x1080";
//    Configuration.pageLoadStrategy = "none";
//    Configuration.holdBrowserOpen = true;
  }

  @Test
  void shouldHaveSoftAssertionsPageOnWiki() {

    //Откройте страницу Selenide в Github
    open("selenide/selenide");

    //Перейдите в раздел Wiki проекта
    $("#wiki-tab").click();

    //Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
    $("#wiki-pages-filter").setValue("SoftAssertions");
    $x("//nav[@id='wiki-pages-box']//span//a[contains(text(), 'SoftAssertions')]")
            .shouldBe(text("SoftAssertions")).click();

    //Откройте страницу SoftAssertions, проверьте что внутри есть пример кода для JUnit5
    $x("//div//h4[contains(text(), 'Using JUnit5')]").shouldHave(partialText("Using JUnit5"));
  }

}
