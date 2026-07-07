package com.ecommerce.tests;

import org.testng.Assert;
import org.testng.annotations.Test;  // ✅ CORRECT - TestNG import

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.ProductPage;

public class CartTest extends BaseTest {
    
    @Test(priority = 1)
    public void testAddToCart() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.searchProduct("Samsung");
        ProductDetailsPage detailsPage = productPage.selectProduct(0);
        
        detailsPage.addToCart();
        driver.switchTo().alert().accept();
        
        CartPage cartPage = homePage.goToCart();
        int itemCount = cartPage.getCartItemCount();
        Assert.assertTrue(itemCount > 0, "Item should be in cart");
        logger.info("Add to cart test passed");
    }
    
    @Test(priority = 2)
    public void testRemoveFromCart() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.goToCart();
        
        int initialCount = cartPage.getCartItemCount();
        if (initialCount > 0) {
            cartPage.deleteItem(0);
            int newCount = cartPage.getCartItemCount();
            Assert.assertEquals(newCount, initialCount - 1);
        }
        logger.info("Remove from cart test passed");
    }
    
    @Test(priority = 3)
    public void testCartTotal() {
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = homePage.goToCart();
        
        String total = cartPage.getTotalPrice();
        Assert.assertNotNull(total);
        Assert.assertTrue(total.startsWith("$"));
        logger.info("Cart total test passed");
    }
}
