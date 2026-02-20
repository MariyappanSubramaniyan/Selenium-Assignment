package tests;

import base.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;
import utils.ConfigReader;

public class AmazonWithLoginTest extends BaseTest {

    @BeforeMethod
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(
                ConfigReader.get("username"),
                ConfigReader.get("password")
        );
    }

    @Test
    public void verifyAmazonFlowWithLogin() {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        OrdersPage ordersPage = new OrdersPage(driver);
        AddressPage addressPage = new AddressPage(driver);

        homePage.clickTopNavigationLink("Today's Deals");
        productPage.selectFilterCheckbox("Prime Exclusive");

        productPage.selectProductByNumber(1);
        String delivery_date = productPage.getDeliveryDate();
        System.out.println(delivery_date);

        ordersPage.goToPastOrders("2025");

        addressPage.goToYourAddresses();

        addressPage.addNewAddress(
                "Mariyappan",
                "9876543210",
                "600052",
                "No.762, 1st Main Road, Solaiamman Nagar, Redhills",
                "chennai"
        );

        if(addressPage.isAddressAdded("Mariyappan")) {
            System.out.println("Address added successfully!");
        }

        productPage.searchProduct("Books");
        productPage.selectPrimeReadingEligible();
        productPage.selectProductAfterSearch(1);

    }
}
