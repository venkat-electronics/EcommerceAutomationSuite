package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BasePage {
    
    @FindBy(className = "btn-success")
    private WebElement placeOrderButton;
    
    @FindBy(css = ".btn-secondary")
    private WebElement continueShoppingButton;
    
    @FindBy(id = "totalp")
    private WebElement totalPrice;
    
    @FindBy(css = "#tbodyid tr")
    private List<WebElement> cartItems;
    
    @FindBy(className = "btn-danger")
    private List<WebElement> deleteButtons;
    
    @FindBy(css = "#tbodyid tr td:nth-child(2)")
    private List<WebElement> itemDescriptions;
    
    @FindBy(css = "#tbodyid tr td:nth-child(3)")
    private List<WebElement> itemPrices;
    
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public CheckoutPage proceedToCheckout() {
        click(placeOrderButton);
        logger.info("Proceeded to checkout");
        return new CheckoutPage(driver);
    }
    
    public HomePage continueShopping() {
        click(continueShoppingButton);
        logger.info("Continuing shopping");
        return new HomePage(driver);
    }
    
    public int getCartItemCount() {
        return cartItems.size();
    }
    
    public String getTotalPrice() {
        return getText(totalPrice);
    }
    
    public void deleteItem(int index) {
        if (index < deleteButtons.size()) {
            click(deleteButtons.get(index));
            logger.info("Deleted item at index: {}", index);
        }
    }
    
    public void deleteAllItems() {
        while (!deleteButtons.isEmpty()) {
            click(deleteButtons.get(0));
            waitUtil.sleep(500);
        }
        logger.info("Deleted all items from cart");
    }
    
    public String getItemDescription(int index) {
        if (index < itemDescriptions.size()) {
            return getText(itemDescriptions.get(index));
        }
        return null;
    }
    
    public String getItemPrice(int index) {
        if (index < itemPrices.size()) {
            return getText(itemPrices.get(index));
        }
        return null;
    }
    
    public boolean isCartEmpty() {
        return cartItems.isEmpty();
    }
}
