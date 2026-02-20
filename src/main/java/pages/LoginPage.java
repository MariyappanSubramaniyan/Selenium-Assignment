package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;
import pages.locators.LoginPageLocators;

public class LoginPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void login(String username, String password) {
        click(LoginPageLocators.SIGN_IN_BUTTON);
        sendKeys(LoginPageLocators.EMAIL_INPUT, username);
        click(LoginPageLocators.CONTINUE_BUTTON);
        sendKeys(LoginPageLocators.PASSWORD_INPUT, password);
        click(LoginPageLocators.SUBMIT_BUTTON);
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
