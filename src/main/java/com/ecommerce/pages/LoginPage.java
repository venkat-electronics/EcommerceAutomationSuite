package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
    
    @FindBy(id = "loginusername")
    private WebElement usernameInput;
    
    @FindBy(id = "loginpassword")
    private WebElement passwordInput;
    
    @FindBy(css = "button[onclick='logIn()']")
    private WebElement loginButton;
    
    @FindBy(id = "logInModalLabel")
    private WebElement loginModalTitle;
    
    @FindBy(css = "#logInModal .close")
    private WebElement closeModalButton;
    
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public HomePage login(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(loginButton);
        logger.info("Login attempted for user: {}", username);
        return new HomePage(driver);
    }
    
    public HomePage loginWithValidCredentials() {
        String username = "testuser123";
        String password = "Test@123";
        return login(username, password);
    }
    
    public boolean isLoginModalDisplayed() {
        return isElementDisplayed(loginModalTitle);
    }
    
    public void closeLoginModal() {
        click(closeModalButton);
    }
    
    public void clearCredentials() {
        usernameInput.clear();
        passwordInput.clear();
    }
    
    public String getUsernamePlaceholder() {
        return usernameInput.getAttribute("placeholder");
    }
    
    public String getPasswordPlaceholder() {
        return passwordInput.getAttribute("placeholder");
    }
}
