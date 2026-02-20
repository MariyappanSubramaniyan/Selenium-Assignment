package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import pages.locators.AddressPageLocators;

public class AddressPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void goToYourAddresses() {
        click(AddressPageLocators.ACCOUNT_LIST);
        click(AddressPageLocators.YOUR_ADDRESSES);
    }

    public void addNewAddress(String name, String phone, String pin, String address, String cityName) {
        click(AddressPageLocators.ADD_ADDRESS_BUTTON);
        sendKeys(AddressPageLocators.FULL_NAME, name);
        sendKeys(AddressPageLocators.MOBILE, phone);
        sendKeys(AddressPageLocators.PINCODE, pin);
        sendKeys(AddressPageLocators.ADDRESS_LINE1, address);
        sendKeys(AddressPageLocators.CITY, cityName);
        click(AddressPageLocators.SAVE_ADDRESS_BUTTON);
    }

    public boolean isAddressAdded(String name) {
        By dynamicAddress = AddressPageLocators.addressByName(name);
        waitUtils.waitElementToVisible(dynamicAddress);
        return driver.findElement(dynamicAddress).isDisplayed();
    }

    private void click(By locator) {
        waitUtils.waitElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    private void sendKeys(By locator, String text) {
        waitUtils.waitElementToVisible(locator);
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }
}
