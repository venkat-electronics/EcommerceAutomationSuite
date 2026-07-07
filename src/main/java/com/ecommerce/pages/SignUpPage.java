package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BasePage {
    
    @FindBy(id = "sign-username")
    private WebElement usernameInput;
    
    @FindBy(id = "sign-password")
    private WebElement passwordInput;
    
    @FindBy(css = "button[onclick='register()']")
    private WebElement signUpButton;
    
    @FindBy(id = "signInModalLabel")
    private WebElement signUpModalTitle;
    
    @FindBy(css = "#signInModal .close")
    private WebElement closeModalButton;
    
    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public HomePage signUp(String username, String password) {
        sendKeys(usernameInput, username);
        sendKeys(passwordInput, password);
        click(signUpButton);
        logger.info("SignUp attempted for user: {}", username);
        return new HomePage(driver);
    }
    
    public HomePage signUpWithRandomCredentials() {
        String username = "user_" + System.currentTimeMillis();
        String password = "Pass@123";
        return signUp(username, password);
    }
    
    public boolean isSignUpModalDisplayed() {
        return isElementDisplayed(signUpModalTitle);
    }
    
    public void closeSignUpModal() {
        click(closeModalButton);
    }
    
    public String getUsernamePlaceholder() {
        return usernameInput.getAttribute("placeholder");
    }
    
    public String getPasswordPlaceholder() {
        return passwordInput.getAttribute("placeholder");
    }
}
