package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.ProductDetailsPage;
import com.ecommerce.pages.ProductPage;
import com.ecommerce.pages.SignUpPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RegressionSuite extends BaseTest {
    
    @Test
    public void testHomePage() {
        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isBrandLogoDisplayed());
        Assert.assertEquals(homePage.getPageTitle(), "STORE");
        logger.info("Home page test passed");
    }
    
    @Test
    public void testSignUp() {
        HomePage homePage = new HomePage(driver);
        SignUpPage signUpPage = homePage.goToSignUpPage();
        
        String username = "testuser_" + System.currentTimeMillis();
        signUpPage.signUp(username, "Password123");
        
        // Verify signup
        driver.switchTo().alert().accept();
        logger.info("SignUp test passed");
    }
    
    @Test
    public void testProductDetails() {
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.searchProduct("Samsung");
        ProductDetailsPage detailsPage = productPage.selectProduct(0);
        
        Assert.assertNotNull(detailsPage.getProductName());
        Assert.assertNotNull(detailsPage.getPrice());
        Assert.assertTrue(detailsPage.isProductImageDisplayed());
        logger.info("Product details test passed");
    }
}
