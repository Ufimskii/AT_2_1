package ru.netology;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CardOrderTest {
    @BeforeEach
    void Setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldSuccessfulSendValidForm(){
        $("[data-test-id=name] input").setValue("Иванов-Петров Иван");
        $("[data-test-id=phone] input").setValue("+79260000000");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success]").shouldHave(text(" Ваша заявка успешно отправлена!" +
                " Наш менеджер свяжется с вами в ближайшее время."));
    }
}
