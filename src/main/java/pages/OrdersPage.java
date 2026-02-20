package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import pages.locators.OrdersPageLocators;

public class OrdersPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public OrdersPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void goToPastOrders(String filterText) {
        clickElement(OrdersPageLocators.ORDERS_LINK);
        clickElement(OrdersPageLocators.TIME_FILTER_DROPDOWN);
        clickElement(OrdersPageLocators.timeFilterOption(filterText));
    }

    private void clickElement(By locator) {
        waitUtils.waitElementToBeClickable(locator);
        driver.findElement(locator).click();
    }
}
