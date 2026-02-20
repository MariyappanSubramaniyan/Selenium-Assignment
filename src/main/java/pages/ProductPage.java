package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.WaitUtils;
import pages.locators.ProductPageLocators;

import java.util.List;

public class ProductPage {

    private final WebDriver driver;
    private final WaitUtils waitUtils;
    private String selectedQuantity;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchBox;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String productName) {
        searchBox.sendKeys(productName, Keys.ENTER);
    }

    public void selectProductByNumber(int productNumber) {
        waitUtils.waitElementToVisible(ProductPageLocators.PRODUCT_TITLES);
        List<WebElement> products = driver.findElements(ProductPageLocators.PRODUCT_TITLES);

        if (productNumber <= 0 || productNumber > products.size()) {
            throw new IllegalArgumentException("Invalid product number.");
        }

        WebElement product = products.get(productNumber - 1);
        System.out.println("Selected Product: " + product.getText());
        product.click();
    }

    public void addToCart() {
        selectedQuantity = driver.findElement(ProductPageLocators.QUANTITY).getText();
        driver.findElement(ProductPageLocators.ADD_TO_CART_BUTTON).click();
    }

    public void verifyCartQuantity() {
        waitUtils.waitElementToVisible(ProductPageLocators.CART_QUANTITY);
        String cartQty = driver.findElement(ProductPageLocators.CART_QUANTITY).getText();
        if (!selectedQuantity.equals(cartQty)) {
            throw new AssertionError(
                    "Expected quantity: " + selectedQuantity + ", but found: " + cartQty
            );
        }
    }


    public void selectFilterCheckbox(String labelName) {
        By checkbox = ProductPageLocators.filterCheckbox(labelName);
        waitUtils.waitElementToBeClickable(checkbox);
        driver.findElement(checkbox).click();
    }

    public void selectPrimeReadingEligible() {
        By primeReading = ProductPageLocators.primeReadingEligible();
        waitUtils.waitElementToBeClickable(primeReading);
        driver.findElement(primeReading).click();
    }

    public void selectProductAfterSearch(int productNumber) {
        By searchProducts = ProductPageLocators.searchProductLinks();
        waitUtils.waitElementToVisible(searchProducts);

        List<WebElement> products = driver.findElements(searchProducts);

        if (products.isEmpty()) {
            throw new RuntimeException("No products found after search!");
        }

        if (productNumber <= 0 || productNumber > products.size()) {
            throw new IllegalArgumentException("Invalid product number.");
        }

        WebElement product = products.get(productNumber - 1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);

        System.out.println("Selected Product: " + product.getText());
        product.click();
    }

    public String getDeliveryDate() {
        waitUtils.waitElementToVisible(ProductPageLocators.DELIVERY_DATE);
        return driver.findElement(ProductPageLocators.DELIVERY_DATE).getText();
    }

    public void printLastProduct() {
        waitUtils.waitElementToVisible(ProductPageLocators.SEARCH_RESULTS);
        List<WebElement> results = driver.findElements(ProductPageLocators.SEARCH_RESULTS);
        WebElement lastProduct = results.get(results.size() - 1);
        System.out.println(lastProduct.findElement(By.cssSelector("h2 span")).getText());
    }
}
