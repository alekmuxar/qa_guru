package tests.AlfaTest;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class alfaTestForm {

    @Test
    void alfaTestDeposits () {
        open("https://alfabank.ru/make-money/");

        //GoDeposits
        $("#filter").$("[href='/make-money/deposits/']").click();
        $("#more-buttons").$(byText("Архивные счета и депозиты")).click();
        $("[role='tablist']").$(byText("Депозиты")).click();
        $$("[data-widget-name='CatalogCard']").shouldHaveSize(5);


    }

    @Test
    void alfaTestAssurance () {
        open("https://alfabank.ru/make-money/");
        $("body").$(byText("Описание")).parent().sibling(0).click();
        $("[data-test-id='accordion-header-0']").shouldHave(text("Альфа-Банк является участником системы обязательного страхования вкладов"));

    }
}
