package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchTest extends BaseTest {
    
    @Test(priority = 1)
    public void testSearchProduct() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.searchProduct("Samsung");
        
        int productCount = productPage.getProductCount();
        Assert.assertTrue(productCount > 0, "Products should be found");
        Assert.assertTrue(productPage.isProductDisplayed("Samsung Galaxy S6"));
        logger.info("Search test passed");
    }
    
    @Test(priority = 2)
    public void testSearchWithNoResults() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.searchProduct("InvalidProduct123");
        
        int productCount = productPage.getProductCount();
        Assert.assertEquals(productCount, 0, "No products should be found");
        logger.info("No results search test passed");
    }
    
    @Test(priority = 3)
    public void testSearchByCategory() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = new ProductPage(driver);
        
        productPage.filterByCategory("Phones");
        int phoneCount = productPage.getProductCount();
        Assert.assertTrue(phoneCount > 0, "Phones should be displayed");
        logger.info("Category filter test passed");
    }
}
