package tests.GitHub;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    @Test
    void createIssues () {

        step("Открываем главную страницу GitHub", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий alekmuxar/qa_guru", () -> {
            $(".header-search-input").click();
            $(".header-search-input").val("alekmuxar/qa_guru");
            $(".header-search-input").pressEnter();
        });

        step("Открываем репозиторий", () -> {
            $(By.linkText("alekmuxar/qa_guru")).click();
        });

        step("Открываем блок Issues в репозитории", () -> {
            $("#issues-tab").click();
        });

        step("Открываем форму авторизации в GitHub для создания Issues", () -> {
            $(".details-overlay-dark").click();
            $(".Box--overlay").$(byText("Sign in")).click();
        });

        step("Авторизация под юзером alekmuxar@gmail.com в GitHub", () -> {
            $("#login_field").click();
            $("#login_field").val("alekmuxar@gmail.com");
            $("#password").click();
            $("#password").val("dota2man1");
            $("[name='commit']").click();
        });

        step("Заполнение формы Issues", () -> {
            $("#issue_title").val("Нужно добавить новую задачу");
            $("#issue_body").click();
            $("#issue_body").val("Тестовый текст для создания новой задачи по курсу qa_guru");

            $(".js-issue-assign-self").click();

            $("#labels-select-menu").click();
            $(".js-filterable-issue-labels").$(byText("bug")).click();
            $(".js-filterable-issue-labels").$(byText("help wanted")).click();
        });

        step("Нажатие кнопки создания Issues", () -> {
            $(".timeline-comment-wrapper").$(byText("Submit new issue")).doubleClick();
        });

        step("Проверка полей что все корректно создалось", () -> {
            $("[data-snek-id='issue-title']").shouldHave(text("Нужно добавить новую задачу"));
            $(".edit-comment-hide").shouldHave(text("Тестовый текст для создания новой задачи по курсу qa_guru"));
            $(".js-issue-labels").shouldHave(text("bug"));
            $(".js-issue-labels").shouldHave(text("help wanted"));
        });

    }
}
