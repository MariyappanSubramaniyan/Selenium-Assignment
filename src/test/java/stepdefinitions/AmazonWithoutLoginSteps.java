package stepdefinitions;

import io.cucumber.java.en.*;
import pages.HomePage;
import pages.ProductPage;

public class AmazonWithoutLoginSteps {

    HomePage homePage = new HomePage(Hooks.driver);
    ProductPage productPage = new ProductPage(Hooks.driver);

    @Given("User is on Amazon home page")
    public void user_is_on_amazon_home_page() {
        // Driver already launched in Hooks
    }

    @When("User clicks on {string}")
    public void user_clicks_on(String link) {
        homePage.clickTopNavigationLink(link);
    }

    @When("User selects product number {int}")
    public void user_selects_product_number(Integer number) {
        productPage.selectProductByNumber(number);
    }

    @When("User adds the product to cart")
    public void user_adds_product_to_cart() {
        productPage.addToCart();
    }

    @Then("Cart quantity should be updated")
    public void cart_quantity_should_be_updated() {
        productPage.verifyCartQuantity();
    }

    @When("User searches for product {string}")
    public void user_searches_for_product(String product) {
        productPage.searchProduct(product);
    }

    @Then("User prints the last product from results")
    public void user_prints_last_product() {
        productPage.printLastProduct();
    }

    @When("User navigates using menu")
    public void user_navigates_using_menu() {
        homePage.goTonav();
    }

    @When("User returns to home page")
    public void user_returns_to_home_page() {
        homePage.returnToHomePage();
    }
}