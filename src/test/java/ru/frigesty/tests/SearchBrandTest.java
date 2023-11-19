package ru.frigesty.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchBrandTest {

    @BeforeEach
    void openSite(){
        open("https://zeon18.ru/");
    }
    @CsvFileSource(resources = "/categorySearchZeon.csv")
    @DisplayName("Отображение категории в поиске товара")
    @ParameterizedTest(name = "Для поиского запроса {0} отображается категория {1} на странице с результатом поиска")
    @Tag("Search")
    void brandSearchMVideo(String productName, String categoryName){
        $(".input.style-big").setValue(productName).pressEnter();
        $(".catalog-filter-categories-list").shouldBe(visible).shouldHave(text(categoryName)) ;
    }
}
