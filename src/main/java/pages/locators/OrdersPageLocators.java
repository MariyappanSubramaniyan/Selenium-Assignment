package pages.locators;

import org.openqa.selenium.By;

public class OrdersPageLocators {

    public static final By ORDERS_LINK = By.id("nav-orders");
    public static final By TIME_FILTER_DROPDOWN = By.xpath("//span[@data-action='a-dropdown-button']");

    public static By timeFilterOption(String optionText) {
        return By.xpath("//a[contains(text(),'" + optionText + "')]");
    }
}
