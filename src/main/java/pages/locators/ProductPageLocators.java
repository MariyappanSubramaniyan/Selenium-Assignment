package pages.locators;

import org.openqa.selenium.By;

public class ProductPageLocators {

    public static final By PRODUCT_TITLES = By.xpath("//p[contains(@id,'title')]");
    public static final By ADD_TO_CART_BUTTON = By.xpath("//div[@class='a-section a-spacing-none a-padding-none']//div[@id='addToCart_feature_div']//div//input[@id='add-to-cart-button']");
    public static final By QUANTITY = By.xpath("//span[@data-action='a-dropdown-button']/span[2]");
    public static final By CART_QUANTITY = By.cssSelector("span[data-a-selector='inner-value']");
    public static final By SEARCH_RESULTS = By.cssSelector("div[data-component-type='s-search-result']");
    public static final By DELIVERY_DATE = By.xpath("//span[@data-csa-c-type='element']");

    public static By filterCheckbox(String labelName) {
        return By.xpath("//label[.//span[contains(.,'" + labelName + "')]]");
    }

    public static By primeReadingEligible() {
        return By.xpath("//a[.//span[normalize-space()='Prime Reading Eligible']]");
    }

    public static By searchProductLinks() {
        return By.xpath("//div[@data-component-type='s-search-result']//h2/parent::a");
    }
}
