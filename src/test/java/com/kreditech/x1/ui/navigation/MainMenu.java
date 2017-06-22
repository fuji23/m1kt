package com.kreditech.x1.ui.navigation;

import com.codeborne.selenide.WebDriverRunner;
import com.kreditech.x1.pages.external.google.GooglePage;
import com.kreditech.x1.pages.internal.main.Home;
import com.kreditech.x1.pages.internal.main.footer.Footer;
import com.kreditech.x1.pages.internal.main.navigation.NavigationMenu;
import com.kreditech.x1.utils.driver.Driver;
import com.kreditech.x1.utils.report.ReportUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;

import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.kreditech.x1.utils.driver.Driver.scrollTo;

public class MainMenu {

    @Test(dataProvider = "navigationLinks")
    @Description("Navigation links test")
    public void test1(NavigationMenu.Menu menu) {

        ReportUtils.step(1, "Open Kreditech site from google search results.");
        Home home = Driver.go("https://www.google.com/", GooglePage.class)
                .searchFor("kreditech")
                .clickOnResultLink(1, Home.class);

        ReportUtils.step(2, "Navigate between header's links and make sure it's opened.");
        NavigationMenu navigationMenu = home.navigationMenu();
        navigationMenu.selectMenu(menu);
        navigationMenu.checkMenuSelected(menu);
    }

    @Test(dataProvider = "socialNetworks")
    @Description("Social networks test")
    public void test2(Footer.FooterSocialLinks socialLink) {

        ReportUtils.step(1, "Open home page, scroll to the social links block.");
        Footer footer = Driver.go("/", Home.class).footer();
        scrollTo(footer.getSelf(), "Footer");

        ReportUtils.step(2, "Navigate to social network and ensure opened page related to the Kreditech.");
        footer.navigateTo(socialLink).onPage();
    }

    @DataProvider(name = "navigationLinks", parallel = true)
    public Iterator<Object[]> navigationLinks() {
        return Arrays.stream(NavigationMenu.Menu.values())
                .map(m -> Stream.of(m).toArray()).iterator();
    }

    @DataProvider(name = "socialNetworks", parallel = true)
    public Iterator<Object[]> socialNetworks() {
        return Arrays.stream(Footer.FooterSocialLinks.values())
                .map(m -> Stream.of(m).toArray()).iterator();
    }

    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}