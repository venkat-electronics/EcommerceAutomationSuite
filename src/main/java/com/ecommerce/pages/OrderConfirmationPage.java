package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends BasePage {
    
    @FindBy(css = ".sweet-alert h2")
    private WebElement confirmationMessage;
    
    @FindBy(css = ".sa-confirm-button-container .confirm")
    private WebElement okButton;
    
    @FindBy(css = ".lead")
    private WebElement orderDetails;
    
    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public String getConfirmationMessage() {
        return getText(confirmationMessage);
    }
    
    public String getOrderDetails() {
        return getText(orderDetails);
    }
    
    public HomePage clickOK() {
        click(okButton);
        logger.info("Confirmed order");
        return new HomePage(driver);
    }
    
    public boolean isOrderPlaced() {
        return isElementDisplayed(confirmationMessage);
    }
}
