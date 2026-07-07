package com.ecommerce.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtil {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private long explicitWait = Long.parseLong(ConfigReader.getProperty("explicit.wait"));
    
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(explicitWait));
    }
    
    public WebElement waitForElementVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    public WebElement waitForElementClickable(WebElement element) {
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    
    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    
    public WebElement waitForElementPresent(By locator) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    
    public boolean waitForElementToBeClickable(WebElement element) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForElementToBeVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForElementToBeInvisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForElementToBeInvisible(By locator) {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForTextToBePresent(WebElement element, String text) {
        try {
            return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
        } catch (Exception e) {
            return false;
        }
    }
    
    public List<WebElement> waitForAllElementsVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
    
    public boolean waitForAlertPresent() {
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForUrlContains(String url) {
        try {
            return wait.until(ExpectedConditions.urlContains(url));
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean waitForTitleContains(String title) {
        try {
            return wait.until(ExpectedConditions.titleContains(title));
        } catch (Exception e) {
            return false;
        }
    }
    
    public void waitForPageLoad() {
        wait.until(webDriver -> ((org.openqa.selenium.JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
    
    public void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
