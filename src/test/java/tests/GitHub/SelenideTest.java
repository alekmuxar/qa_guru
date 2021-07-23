package tests.GitHub;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @Test
    void createIssues () {
        //open GitHub
        open("https://github.com/");

        //find Repository
        $(".header-search-input").click();
        $(".header-search-input").val("alekmuxar/qa_guru");
        $(".header-search-input").pressEnter();

        //open Repository
        $(By.linkText("alekmuxar/qa_guru")).click();

        //open Issues
        $("#issues-tab").click();

        //open form Login
        $(".details-overlay-dark").click();
        $(".Box--overlay").$(byText("Sign in")).click();


        //authorization User
        $("#login_field").click();
        $("#login_field").val("alekmuxar@gmail.com");
        $("#password").click();
        $("#password").val("dota2man1");
        $("[name='commit']").click();

        //named Issues
        $("#issue_title").val("Нужно добавить новую задачу");
        $("#issue_body").click();
        $("#issue_body").val("Тестовый текст для создания новой задачи по курсу qa_guru");

        //assigned
        $(".js-issue-assign-self").click();

        //take Labels
        $("#labels-select-menu").click();
        $(".js-filterable-issue-labels").$(byText("bug")).click();
        $(".js-filterable-issue-labels").$(byText("help wanted")).click();

        //create Issues
        $(".timeline-comment-wrapper").$(byText("Submit new issue")).doubleClick();

        //accept
        $("[data-snek-id='issue-title']").shouldHave(text("Нужно добавить новую задачу"));
        $(".edit-comment-hide").shouldHave(text("Тестовый текст для создания новой задачи по курсу qa_guru"));
        $(".js-issue-labels").shouldHave(text("bug"));
        $(".js-issue-labels").shouldHave(text("help wanted"));

    }
}
