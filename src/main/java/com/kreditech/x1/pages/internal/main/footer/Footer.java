package com.kreditech.x1.pages.internal.main.footer;

import com.codeborne.selenide.ElementsContainer;
import com.codeborne.selenide.SelenideElement;
import com.kreditech.x1.pages.Page;
import com.kreditech.x1.pages.external.Facebook;
import com.kreditech.x1.pages.external.LinkedIn;
import com.kreditech.x1.pages.external.Twitter;
import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class Footer extends ElementsContainer {

    @Step
    public <T extends Page> T navigateTo(FooterSocialLinks link) {
        return Composer.of(() -> {
            $(link.by).click();
            return (T) page(link.page);
        }, String.format("Navigate to the %s page", link.page.getSimpleName()));
    }

    public enum FooterSocialLinks {

        FACEBOOK(Facebook.class, By.cssSelector(".social.facebook>a")), LINKEDIN(LinkedIn.class,
               By.cssSelector(".social.linkedin>a")) , TWITTER(Twitter.class, By.cssSelector(".social.twitter>a"));

        private Class<? extends Page> page;
        private By by;

        FooterSocialLinks(Class<? extends Page> page, By by) {
            this.page = page;
            this.by = by;
        }
    }
}