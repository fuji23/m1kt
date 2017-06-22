package com.kreditech.x1.utils.driver;

import com.codeborne.selenide.SelenideElement;
import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Driver {

    @Step("Open {0} page")
    public static <T> T go(String path, Class<T> clazz) {
        return Composer.of(() -> open(path, clazz), String.format("Open '%s' page.", path));
    }

    @Step("Enter text {0} to the {1} input field")
    public static SelenideElement enterText(By by, String text, String filed) {
        return Composer.of(() -> $(by).val(text),
                String.format("Enter text '%s' to the input '%s' field with '%s' locator.", text, filed, by));
    }

    @Step
    public static void scrollTo(SelenideElement element, String elementName) {
        Composer.of(element::scrollTo, String.format("Scroll to the element %s", elementName));
    }
}