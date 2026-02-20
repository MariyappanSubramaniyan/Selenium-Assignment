package pages.locators;

import org.openqa.selenium.By;

public class HomePageLocators {

    public static final By MAIN_LOGO = By.id("nav-logo");
    public static final By TODAY_DEAL_LINK = By.cssSelector("a[href*='/deals']");
    public static final By HAMBURGER_MENU = By.id("nav-hamburger-menu");

    public static By menuItem(String itemText) {
        return By.xpath("//div[contains(text(),\"" + itemText + "\")] | //a[contains(text(),\"" + itemText + "\")]");
    }
}
