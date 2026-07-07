package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends BasePage {
    
    @FindBy(id = "name")
    private WebElement nameInput;
    
    @FindBy(id = "country")
    private WebElement countryInput;
    
    @FindBy(id = "city")
    private WebElement cityInput;
    
    @FindBy(id = "card")
    private WebElement cardInput;
    
    @FindBy(id = "month")
    private WebElement monthInput;
    
    @FindBy(id = "year")
    private WebElement yearInput;
    
    @FindBy(css = "button[onclick='purchaseOrder()']")
    private WebElement purchaseButton;
    
    @FindBy(css = "button[onclick='closePlaceOrder()']")
    private WebElement closeButton;
    
    @FindBy(css = ".btn-primary")
    private WebElement okButton;
    
    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public OrderConfirmationPage placeOrder(String name, String country, String city, 
                                            String card, String month, String year) {
        sendKeys(nameInput, name);
        sendKeys(countryInput, country);
        sendKeys(cityInput, city);
        sendKeys(cardInput, card);
        sendKeys(monthInput, month);
        sendKeys(yearInput, year);
        click(purchaseButton);
        logger.info("Order placed successfully");
        return new OrderConfirmationPage(driver);
    }
    
    public void closeCheckout() {
        click(closeButton);
    }
    
    public boolean isCheckoutModalDisplayed() {
        return isElementDisplayed(nameInput);
    }
    
    public void clearFields() {
        nameInput.clear();
        countryInput.clear();
        cityInput.clear();
        cardInput.clear();
        monthInput.clear();
        yearInput.clear();
    }
}
