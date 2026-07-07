package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
    
    // Locators
    @FindBy(id = "login2")
    private WebElement loginLink;
    
    @FindBy(id = "signin2")
    private WebElement signUpLink;
    
    @FindBy(id = "cartur")
    private WebElement cartLink;
    
    @FindBy(id = "search")
    private WebElement searchInput;
    
    @FindBy(css = "#search2 .btn")
    private WebElement searchButton;
    
    @FindBy(className = "navbar-brand")
    private WebElement brandLogo;
    
    @FindBy(linkText = "Home")
    private WebElement homeLink;
    
    @FindBy(linkText = "Contact")
    private WebElement contactLink;
    
    @FindBy(linkText = "About us")
    private WebElement aboutUsLink;
    
    @FindBy(className = "btn-success")
    private WebElement addToCartButton;
    
    @FindBy(className = "btn-primary")
    private WebElement placeOrderButton;
    
    @FindBy(id = "nameofuser")
    private WebElement welcomeUser;
    
    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    // Page Actions
    public LoginPage goToLoginPage() {
        click(loginLink);
        logger.info("Navigated to Login page");
        return new LoginPage(driver);
    }
    
    public SignUpPage goToSignUpPage() {
        click(signUpLink);
        logger.info("Navigated to Sign Up page");
        return new SignUpPage(driver);
    }
    
    public CartPage goToCart() {
        click(cartLink);
        logger.info("Navigated to Cart page");
        return new CartPage(driver);
    }
    
    public ProductPage searchProduct(String productName) {
        sendKeys(searchInput, productName);
        click(searchButton);
        logger.info("Searched for product: {}", productName);
        return new ProductPage(driver);
    }
    
    public boolean isBrandLogoDisplayed() {
        return isElementDisplayed(brandLogo);
    }
    
    public String getWelcomeMessage() {
        return getText(welcomeUser);
    }
    
    public boolean isLoggedIn() {
        try {
            return welcomeUser.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public void navigateToHome() {
        click(homeLink);
    }
    
    public ProductPage selectProductFromCategory(String category, String productName) {
        // Implementation to select product from category
        return new ProductPage(driver);
    }
}
