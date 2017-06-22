package com.kreditech.x1.pages.external;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kreditech.x1.pages.Page;
import com.kreditech.x1.utils.driver.composer.Composer;
import io.vavr.control.Try;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.switchTo;

public class Facebook implements Page {

    @FindBy(css = "#expanding_cta_close_button")
    private SelenideElement notNow;

    @FindBy(xpath = "//a[@href='https://www.facebook.com/kreditech/']")
    private SelenideElement header;

    @Step
    public void onPage() {
        Composer.of(() -> {
            switchTo().window(1);
            Try.run(() -> notNow.waitUntil(Condition.visible, 2000).click()).getOrNull();
            header.shouldHave(Condition.text("Kreditech"));
        }, "Desired page is opened.");
    }
}