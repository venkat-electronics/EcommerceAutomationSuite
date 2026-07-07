package com.ecommerce.tests;

import com.ecommerce.base.BaseTest;
import com.ecommerce.listeners.RetryListener;
import com.ecommerce.pages.HomePage;
import com.ecommerce.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    
    // ✅ Add retryAnalyzer to each test that needs retry
    @Test(priority = 1, retryAnalyzer = RetryListener.class)
    public void testValidLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        
        loginPage.login("testuser", "password123");
        
        // Verify login success
        Assert.assertTrue(homePage.isLoggedIn(), "User should be logged in");
        Assert.assertEquals(homePage.getWelcomeMessage(), "Welcome testuser");
        logger.info("Valid login test passed");
    }
    
    @Test(priority = 2, retryAnalyzer = RetryListener.class)
    public void testInvalidLogin() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        
        loginPage.login("invaliduser", "invalidpass");
        
        // Verify error message
        String alertText = driver.switchTo().alert().getText();
        Assert.assertEquals(alertText, "Invalid username or password");
        driver.switchTo().alert().accept();
        logger.info("Invalid login test passed");
    }
    
    @Test(priority = 3, retryAnalyzer = RetryListener.class)
    public void testLoginWithEmptyCredentials() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = homePage.goToLoginPage();
        
        loginPage.login("", "");
        
        // Verify alert for empty fields
        String alertText = driver.switchTo().alert().getText();
        Assert.assertNotNull(alertText);
        driver.switchTo().alert().accept();
        logger.info("Empty credentials test passed");
    }
}
