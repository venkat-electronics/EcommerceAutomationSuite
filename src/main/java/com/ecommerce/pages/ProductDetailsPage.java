package com.ecommerce.pages;

import com.ecommerce.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage {
    
    @FindBy(className = "name")
    private WebElement productName;
    
    @FindBy(className = "price-container")
    private WebElement priceContainer;
    
    @FindBy(className = "description")
    private WebElement productDescription;
    
    @FindBy(className = "btn-success")
    private WebElement addToCartButton;
    
    @FindBy(linkText = "Home")
    private WebElement homeLink;
    
    @FindBy(id = "review")
    private WebElement reviewButton;
    
    @FindBy(id = "writeReview")
    private WebElement writeReviewButton;
    
    @FindBy(id = "review-text")
    private WebElement reviewTextArea;
    
    @FindBy(id = "review-submit")
    private WebElement submitReviewButton;
    
    @FindBy(className = "product-image")
    private WebElement productImage;
    
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    
    public String getProductName() {
        return getText(productName);
    }
    
    public String getPrice() {
        return getText(priceContainer);
    }
    
    public String getDescription() {
        return getText(productDescription);
    }
    
    public ProductDetailsPage addToCart() {
        click(addToCartButton);
        logger.info("Added product to cart");
        return this;
    }
    
    public ProductDetailsPage addReview(String review) {
        click(writeReviewButton);
        sendKeys(reviewTextArea, review);
        click(submitReviewButton);
        logger.info("Added review: {}", review);
        return this;
    }
    
    public HomePage goToHome() {
        click(homeLink);
        return new HomePage(driver);
    }
    
    public boolean isProductImageDisplayed() {
        return isElementDisplayed(productImage);
    }
    
    public String getProductImageSrc() {
        return productImage.getAttribute("src");
    }
}
