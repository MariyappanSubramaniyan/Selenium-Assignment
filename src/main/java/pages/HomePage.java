package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import pages.locators.HomePageLocators;

public class HomePage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;

    @FindBy(id = "nav-logo")
    private WebElement mainLogo;

    @FindBy(css = "a[href*='/deals']")
    private WebElement todayDealLink;

    @FindBy(id = "nav-hamburger-menu")
    private WebElement hamburgerMenu;

    By first_Nav = By.xpath("//div[contains(text(),'Mobiles')]");
    By second_Nav = By.xpath("//a[contains(text(),'Mobile Phones')]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickTopNavigationLink(String linkText) {
        waitUtils.waitElementToBeClickable(HomePageLocators.menuItem(linkText));
        driver.findElement(HomePageLocators.menuItem(linkText)).click();
    }


    public void returnToHomePage() {
        waitUtils.waitElementToBeClickable(HomePageLocators.MAIN_LOGO);
        mainLogo.click();
    }

    public void goTonav(){
        waitUtils.waitElementToBeClickable(By.id("nav-hamburger-menu"));
        hamburgerMenu.click(); waitUtils.waitElementToBeClickable(first_Nav);
        driver.findElement(first_Nav).click();
        waitUtils.waitElementToBeClickable(second_Nav);
        WebElement mobilePhones = driver.findElement(second_Nav);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", mobilePhones);
        waitUtils.waitElementToBeClickable(By.id("nav-logo")); mainLogo.click();
    }

}
