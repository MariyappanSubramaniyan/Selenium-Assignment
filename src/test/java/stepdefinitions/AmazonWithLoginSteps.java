package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.*;
import utils.ConfigReader;

import java.util.Map;

public class AmazonWithLoginSteps {

    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    OrdersPage ordersPage;
    AddressPage addressPage;

    public AmazonWithLoginSteps() {
        loginPage = new LoginPage(Hooks.driver);
        homePage = new HomePage(Hooks.driver);
        productPage = new ProductPage(Hooks.driver);
        ordersPage = new OrdersPage(Hooks.driver);
        addressPage = new AddressPage(Hooks.driver);
    }

    @Given("User is logged into Amazon")
    public void user_is_logged_into_amazon() {
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }


    @When("User selects {string} filter")
    public void user_selects_filter(String filter) {
        productPage.selectFilterCheckbox(filter);
    }

    @Then("Delivery date should be displayed")
    public void delivery_date_should_be_displayed() {
        String deliveryDate = productPage.getDeliveryDate();
        System.out.println("Delivery Date: " + deliveryDate);
        Assert.assertNotNull(deliveryDate);
    }

    @When("User navigates to past orders for year {string}")
    public void user_navigates_to_past_orders_for_year(String year) {
        ordersPage.goToPastOrders(year);
    }

    @When("User navigates to Your Addresses page")
    public void user_navigates_to_your_addresses_page() {
        addressPage.goToYourAddresses();
    }

    @When("User adds a new address with following details")
    public void user_adds_a_new_address_with_following_details(DataTable dataTable) {

        Map<String, String> addressData = dataTable.asMap(String.class, String.class);

        addressPage.addNewAddress(
                addressData.get("name"),
                addressData.get("phone"),
                addressData.get("pincode"),
                addressData.get("addressLine"),
                addressData.get("city")
        );
    }

    @Then("Address {string} should be added successfully")
    public void address_should_be_added_successfully(String name) {

        boolean status = addressPage.isAddressAdded(name);
        Assert.assertTrue(status, "Address was not added successfully!");
        System.out.println("Address added successfully!");
    }

    @When("User selects Prime Reading eligible filter")
    public void user_selects_prime_reading_eligible_filter() {
        productPage.selectPrimeReadingEligible();
    }

    @When("User selects first product from search result")
    public void user_selects_first_product_from_search_result() {
        productPage.selectProductAfterSearch(1);
    }
}