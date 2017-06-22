package com.kreditech.x1.pages.external.google;

import com.codeborne.selenide.SelenideElement;
import com.kreditech.x1.utils.driver.Driver;
import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.page;

public class GooglePage {

    @Step("Search for {0}")
    public SearchResultsPage searchFor(String searchTerm) {
        Composer.ofActions(() -> Driver.enterText(By.name("q"), searchTerm, "Search input").pressEnter());
        return page(SearchResultsPage.class);
    }
}