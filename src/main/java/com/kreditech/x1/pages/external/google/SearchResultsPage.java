package com.kreditech.x1.pages.external.google;

import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class SearchResultsPage {

    @Step
    public <T> T clickOnResultLink(int index, Class<T> clazz) {
        Composer.of(() -> $(By.cssSelector(".g h3>a"), index - 1).click(),
                String.format("Click on '%d' results link.", index));
        return page(clazz);
    }
}