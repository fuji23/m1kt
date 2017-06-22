package com.kreditech.x1.pages.external;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.kreditech.x1.pages.Page;
import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class LinkedIn implements Page {

    @FindBy(xpath = "//h1")
    private SelenideElement header;

    @Step
    public void onPage() {
        Composer.of(() -> {
            switchTo().window(1);
            header.shouldHave(Condition.textCaseSensitive("Kreditech"));
        }, "Desired page is opened.");
    }
}
