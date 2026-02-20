package pages.locators;

import org.openqa.selenium.By;

public class AddressPageLocators {

    public static final By ACCOUNT_LIST = By.id("nav-link-accountList");
    public static final By YOUR_ADDRESSES = By.cssSelector("div[data-card-identifier='AddressesAnd1Click']");
    public static final By ADD_ADDRESS_BUTTON = By.id("ya-myab-address-add-link");
    public static final By FULL_NAME = By.id("address-ui-widgets-enterAddressFullName");
    public static final By MOBILE = By.id("address-ui-widgets-enterAddressPhoneNumber");
    public static final By PINCODE = By.id("address-ui-widgets-enterAddressPostalCode");
    public static final By ADDRESS_LINE1 = By.id("address-ui-widgets-enterAddressLine1");
    public static final By CITY = By.id("address-ui-widgets-enterAddressCity");
    public static final By SAVE_ADDRESS_BUTTON = By.xpath("//span[@id='address-ui-widgets-form-submit-button']//input");

    public static By addressByName(String name) {
        return By.xpath("//div[contains(@id,'address-block')]//*[contains(text(),'" + name + "')]");
    }
}
