package com.kreditech.x1.pages.internal.main.navigation;

import com.codeborne.selenide.ElementsContainer;
import com.kreditech.x1.pages.internal.main.*;
import com.kreditech.x1.utils.driver.composer.Composer;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class NavigationMenu extends ElementsContainer {

    private By menus = By.cssSelector("#menu-main>li");

    @Step
    public void selectMenu(Menu menu) {
        Composer.of(() -> {
            $$(menus).findBy(text(menu.toString())).click();
            return page(menu.getPage());
        }, String.format("Select %s menu", menu.toString()));
    }

    @Step
    public void checkMenuSelected(Menu menu) {
        Composer.of(() ->
                $$(menus).findBy(text(menu.toString())).parent().
                        has(attribute("class", "current-menu-item")), menu + " is selected.");
    }

    public enum Menu {

        WHAT_WE_DO("What we do", WhatWeDo.class), HOME("Home", Home.class), WHO_WE_ARE("Who we are", WhoWeAre.class),
        WORK_WITH_US("Work with us", WorkWithUs.class), CAREERS("Careers", Careers.class),
        INVESTOR_RELATIONS("Investor Relations", InvestorRelations.class),
        PRESS("Press", Press.class), MAGAZINE("Magazine", Magazine.class);

        private String name;
        private Class<?> clazz;

        Menu(String name, Class<?> clazz) {
            this.name = name;
            this.clazz = clazz;
        }

        public Class<?> getPage() {
            return clazz;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}