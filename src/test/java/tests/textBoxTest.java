package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class textBoxTest {

    @Test
    void formTest() {
        open("https://demoqa.com/automation-practice-form");

        //Name
        $("#firstName").val("Alex");
        $("#lastName").val("Smith");
        //Email
        $("#userEmail").val("Alek@mail.ru");
        //Gender
        //$("[class='custom-control-label']").click(); - bad alternative
        $("#genterWrapper").$(byText("Male")).click();
        //Number
        $("#userNumber").val("9999999999");
        //Date
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1998");
        $(".react-datepicker__day--003").click();
        //Subject
        $("#subjectsInput").val("m");
        $(".subjects-auto-complete__menu-list").$(byText("Computer Science")).click();
        $("#subjectsInput").val("a");
        $(".subjects-auto-complete__menu-list").$(byText("Arts")).click();
        //Hobbies
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();
        //Picture
        $("#uploadPicture").uploadFile(new File("src/test/java/tests/img/1.jpg"));
        //Current Address
        $("#currentAddress").val("LA, WallStreet 233/42");
        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();

        $("#submit").click();

        //assert
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $x("//td[text()='Student Name']").parent().shouldHave(text("Alex Smith"));
        $x("//td[text()='Student Email']").parent().shouldHave(text("Alek@mail.ru"));
        $x("//td[text()='Gender']").parent().shouldHave(text("Male"));
        $x("//td[text()='Mobile']").parent().shouldHave(text("9999999999"));
        $x("//td[text()='Date of Birth']").parent().shouldHave(text("03 November,1998"));
        $x("//td[text()='Subjects']").parent().shouldHave(text("Computer Science, Arts"));
        $x("//td[text()='Hobbies']").parent().shouldHave(text("Sports, Reading, Music"));
        $x("//td[text()='Picture']").parent().shouldHave(text("1.jpg"));
        $x("//td[text()='Address']").parent().shouldHave(text("LA, WallStreet 233/42"));
        $x("//td[text()='State and City']").parent().shouldHave(text("Haryana Karnal"));

    }
}
