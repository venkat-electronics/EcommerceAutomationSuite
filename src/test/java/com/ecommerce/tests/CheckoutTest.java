package com.ecommerce.tests;

import org.junit.Test;
import org.testng.Assert;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.OrderConfirmationPage;


public class CheckoutTest extends BaseTest {
    
    @Test(priority = 1)
    public void testCompleteCheckout() {
        // Add item to cart first
        HomePage homePage = new HomePage(driver);
        homePage.searchProduct("Samsung")
                .selectProduct(0)
                .addToCart();
        driver.switchTo().alert().accept();
        
        // Proceed to checkout
        CartPage cartPage = homePage.goToCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        
        // Fill checkout form
        OrderConfirmationPage confirmationPage = checkoutPage.placeOrder(
            "Test User",
            "USA",
            "New York",
            "4111111111111111",
            "12",
            "2025"
        );
        
        // Verify order
        Assert.assertTrue(confirmationPage.isOrderPlaced());
        Assert.assertEquals(confirmationPage.getConfirmationMessage(), "Thank you for your purchase!");
        logger.info("Checkout test passed");
    }
    
    @Test(timeout = 2)
    public void testCheckoutWithEmptyFields() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.goToCart();
        CheckoutPage checkoutPage = cartPage.proceedToCheckout();
        
        checkoutPage.placeOrder("", "", "", "", "", "");
        
        // Verify validation
        driver.switchTo().alert();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertNotNull(alertText);
        driver.switchTo().alert().accept();
        logger.info("Checkout validation test passed");
    }
}
