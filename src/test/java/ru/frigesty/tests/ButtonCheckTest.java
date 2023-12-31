package ru.frigesty.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ButtonCheckTest extends TestBase {
    @BeforeEach
    void openSite(){
        open("https://jut.su/");
    }
    @CsvSource({
            "Вода, Техники воды",
            "Молния, Техники молнии",
            "Земля, Техники земли",
            "Ветер, Техники ветра",
            "Огонь, Техники огня",
            "Чакра, Техники простой чакры"
    })
    @DisplayName("Кнопки ведут на нужную страницу")
    @ParameterizedTest(name = "При нажатии на кнопку {0} в header мы поподаем на страницу с надписью {1}")
    @Tag("Buttons")
    public void jutSuButtonCheckTest(String link, String header){
        $(".top_nav_b ul").$(byText(link)).click();
        $(".content h1").shouldHave(text(header));
    }
}
