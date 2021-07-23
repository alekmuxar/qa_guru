package tests.GitHub;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class AnnotationTest {

    @Test
    public void createIssuesGitHub () {
        BaseSteps steps = new BaseSteps();

        steps.openMainPage();
        steps.findRepository();
        steps.openRepository();
        steps.openIssues();
        steps.openFormLogin();
        steps.authorizationUser();
        steps.namedIssues();
        steps.createIssues();
        steps.acceptIssues();
    }

    public static class BaseSteps {

        @Step("Открываем главную страницу GitHub")
        void openMainPage() {
            open("https://github.com/");
        }

        @Step("Ищем репозиторий alekmuxar/qa_guru")
        void findRepository () {
            $(".header-search-input").click();
            $(".header-search-input").val("alekmuxar/qa_guru");
            $(".header-search-input").pressEnter();
        }

        @Step("Открываем репозиторий")
        void openRepository () {
            $(By.linkText("alekmuxar/qa_guru")).click();
        }

        @Step("Открываем блок Issues в репозитории")
        void openIssues () {
            $("#issues-tab").click();
        }

        @Step("Открываем форму авторизации в GitHub для создания Issues")
        void openFormLogin () {
            $(".details-overlay-dark").click();
            $(".Box--overlay").$(byText("Sign in")).click();
        }

        @Step("Авторизация под юзером alekmuxar@gmail.com в GitHub")
        void authorizationUser () {
            $("#login_field").click();
            $("#login_field").val("alekmuxar@gmail.com");
            $("#password").click();
            $("#password").val("dota2man1");
            $("[name='commit']").click();
        }

        @Step("Заполнение формы Issues")
        void namedIssues () {
            $("#issue_title").val("Нужно добавить новую задачу");
            $("#issue_body").click();
            $("#issue_body").val("Тестовый текст для создания новой задачи по курсу qa_guru");
            $(".js-issue-assign-self").click();
            $("#labels-select-menu").click();
            $(".js-filterable-issue-labels").$(byText("bug")).click();
            $(".js-filterable-issue-labels").$(byText("help wanted")).click();
        }

        @Step("Нажатие кнопки создания Issues")
        void createIssues () {
            $(".timeline-comment-wrapper").$(byText("Submit new issue")).doubleClick();
        }

        @Step("Проверка полей что все корректно создалось")
        void acceptIssues () {
            $("[data-snek-id='issue-title']").shouldHave(text("Нужно добавить новую задачу"));
            $(".edit-comment-hide").shouldHave(text("Тестовый текст для создания новой задачи по курсу qa_guru"));
            $(".js-issue-labels").shouldHave(text("bug"));
            $(".js-issue-labels").shouldHave(text("help wanted"));
        }
    }
}
