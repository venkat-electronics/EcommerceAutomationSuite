package com.ecommerce.base;

import com.ecommerce.utils.WaitUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Set;

public class BasePage {
    
    protected WebDriver driver;
    protected WaitUtil waitUtil;
    protected Actions actions;
    protected JavascriptExecutor jsExecutor;
    protected static Logger logger = LogManager.getLogger(BasePage.class);
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.waitUtil = new WaitUtil(driver);
        this.actions = new Actions(driver);
        this.jsExecutor = (JavascriptExecutor) driver;
        PageFactory.initElements(driver, this);
    }
    
    // Common Actions
    public void click(WebElement element) {
        try {
            waitUtil.waitForElementToBeClickable(element);
            element.click();
            logger.info("Clicked on element: {}", element);
        } catch (Exception e) {
            logger.error("Failed to click element: {}", e.getMessage());
            jsExecutor.executeScript("arguments[0].click();", element);
        }
    }
    
    public void sendKeys(WebElement element, String text) {
        waitUtil.waitForElementVisible(element);
        element.clear();
        element.sendKeys(text);
        logger.info("Entered text: '{}' in element", text);
    }
    
    public String getText(WebElement element) {
        waitUtil.waitForElementVisible(element);
        return element.getText().trim();
    }
    
    public void selectDropdownByVisibleText(WebElement element, String text) {
        waitUtil.waitForElementVisible(element);
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText(text);
        logger.info("Selected dropdown option: {}", text);
    }
    
    public void selectDropdownByValue(WebElement element, String value) {
        waitUtil.waitForElementVisible(element);
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
        logger.info("Selected dropdown value: {}", value);
    }
    
    public void selectDropdownByIndex(WebElement element, int index) {
        waitUtil.waitForElementVisible(element);
        Select dropdown = new Select(element);
        dropdown.selectByIndex(index);
        logger.info("Selected dropdown index: {}", index);
    }
    
    public void hoverOver(WebElement element) {
        waitUtil.waitForElementVisible(element);
        actions.moveToElement(element).build().perform();
        logger.info("Hovered over element");
    }
    
    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
        logger.info("Scrolled to element");
    }
    
    public void scrollToBottom() {
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        logger.info("Scrolled to bottom");
    }
    
    public void scrollToTop() {
        jsExecutor.executeScript("window.scrollTo(0, 0)");
        logger.info("Scrolled to top");
    }
    
    public boolean isElementDisplayed(WebElement element) {
        try {
            waitUtil.waitForElementVisible(element);
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isElementEnabled(WebElement element) {
        try {
            waitUtil.waitForElementVisible(element);
            return element.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isElementSelected(WebElement element) {
        try {
            waitUtil.waitForElementVisible(element);
            return element.isSelected();
        } catch (Exception e) {
            return false;
        }
    }
    
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Page title: {}", title);
        return title;
    }
    
    public String getCurrentUrl() {
        String url = driver.getCurrentUrl();
        logger.info("Current URL: {}", url);
        return url;
    }
    
    public void switchToNewWindow() {
        String currentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!window.equals(currentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        logger.info("Switched to new window");
    }
    
    public void switchToWindowByTitle(String title) {
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            driver.switchTo().window(window);
            if (driver.getTitle().equals(title)) {
                logger.info("Switched to window with title: {}", title);
                break;
            }
        }
    }
    
    public void acceptAlert() {
        driver.switchTo().alert().accept();
        logger.info("Accepted alert");
    }
    
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
        logger.info("Dismissed alert");
    }
    
    public String getAlertText() {
        String text = driver.switchTo().alert().getText();
        logger.info("Alert text: {}", text);
        return text;
    }
    
    public void switchToFrame(WebElement frame) {
        driver.switchTo().frame(frame);
        logger.info("Switched to frame");
    }
    
    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
        logger.info("Switched to default content");
    }
    
    public void refreshPage() {
        driver.navigate().refresh();
        logger.info("Page refreshed");
    }
    
    public void navigateBack() {
        driver.navigate().back();
        logger.info("Navigated back");
    }
    
    public void navigateForward() {
        driver.navigate().forward();
        logger.info("Navigated forward");
    }
}
