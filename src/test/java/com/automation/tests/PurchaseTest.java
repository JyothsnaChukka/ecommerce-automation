package com.automation.tests;

import com.automation.pages.CheckoutPage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;
import com.automation.pages.WatchPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseTest extends BaseTest {

    @Test
    public void testPurchase() {
        // Step 1: Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("jyothsnacse317@gmail.com", "Dummy@123");

        // Step 2: Navigate to Watches
        HomePage homePage = new HomePage(driver);
        homePage.goToWatches();

        // Step 3: Filter by Material (Metal) and Add to Cart
        WatchPage watchPage = new WatchPage(driver);
        watchPage.filterByMaterial();
        watchPage.addWatchToCart();
        watchPage.goToCart();

        // Step 4: Increase Quantity and Complete Purchase
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        checkoutPage.completePurchase();
        checkoutPage.enterAddressDetails();
        checkoutPage.placeOrder();

        // Step 5: Verify Success Message and Order ID
        String successMessage = checkoutPage.getSuccessMessage();
        Assert.assertTrue(successMessage.equals("Thank you for your purchase!"));

        String orderId = checkoutPage.getOrderId();
        System.out.println("Order ID: " + orderId);
    }
}
