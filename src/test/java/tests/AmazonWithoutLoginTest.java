package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class AmazonWithoutLoginTest extends BaseTest {

    @Test
    public void verifyAmazonFlowWithoutLogin() {

        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);

        homePage.clickTopNavigationLink("Today's Deals");
        productPage.selectProductByNumber(3);
        productPage.addToCart();
        productPage.verifyCartQuantity();
        productPage.searchProduct("Mobiles");
        productPage.printLastProduct();
        homePage.goTonav();
        homePage.returnToHomePage();


    }
}
