package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductPage extends BasePage {
    
    @FindBy(className = "card-title")
    private List<WebElement> productTitles;
    
    @FindBy(className = "card-text")
    private List<WebElement> productPrices;
    
    @FindBy(css = ".card .btn-primary")
    private List<WebElement> addToCartButtons;
    
    @FindBy(className = "card")
    private List<WebElement> productCards;
    
    @FindBy(css = ".btn-success")
    private WebElement addToCartButton;
    
    @FindBy(className = "name")
    private WebElement productName;
    
    @FindBy(className = "price-container")
    private WebElement priceContainer;
    
    @FindBy(className = "description")
    private WebElement description;
    
    @FindBy(className = "product-image")
    private WebElement productImage;
    
    @FindBy(className = "btn-success")
    private WebElement addToCartMain;
    
    @FindBy(linkText = "Home")
    private WebElement homeLink;
    
    @FindBy(className = "nav-link")
    private List<WebElement> categoryLinks;
    
    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public int getProductCount() {
        return productCards.size();
    }
    
    public String getProductTitle(int index) {
        if (index < productTitles.size()) {
            return getText(productTitles.get(index));
        }
        return null;
    }
    
    public String getProductPrice(int index) {
        if (index < productPrices.size()) {
            return getText(productPrices.get(index));
        }
        return null;
    }
    
    public ProductDetailsPage selectProduct(int index) {
        if (index < productCards.size()) {
            click(productTitles.get(index));
            logger.info("Selected product at index: {}", index);
        }
        return new ProductDetailsPage(driver);
    }
    
    public ProductDetailsPage selectProductByName(String productName) {
        for (WebElement title : productTitles) {
            if (getText(title).equals(productName)) {
                click(title);
                logger.info("Selected product: {}", productName);
                break;
            }
        }
        return new ProductDetailsPage(driver);
    }
    
    public ProductPage filterByCategory(String category) {
        for (WebElement link : categoryLinks) {
            if (getText(link).equals(category)) {
                click(link);
                logger.info("Filtered by category: {}", category);
                break;
            }
        }
        return this;
    }
    
    public boolean isProductDisplayed(String productName) {
        for (WebElement title : productTitles) {
            if (getText(title).equals(productName)) {
                return true;
            }
        }
        return false;
    }
    
    public ProductDetailsPage goToProductDetails() {
        if (!productTitles.isEmpty()) {
            click(productTitles.get(0));
        }
        return new ProductDetailsPage(driver);
    }
}
