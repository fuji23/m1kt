package com.kreditech.x1.pages.internal.main;

import com.kreditech.x1.pages.internal.main.footer.Footer;
import com.kreditech.x1.pages.internal.main.navigation.NavigationMenu;
import org.openqa.selenium.support.FindBy;

public class Home {

    private NavigationMenu navigationMenu;

    @FindBy(css = "#footer")
    private Footer footer;

    public NavigationMenu navigationMenu() {
        return navigationMenu;
    }

    public Footer footer() {
        return footer;
    }
}
