package com.ecommerce.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ecommerce.utils.ConfigReader;
import com.ecommerce.utils.ScreenshotUtil;
import com.ecommerce.listeners.TestListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

// ✅ CORRECT - Only TestListener here
@Listeners({TestListener.class})
public class BaseTest {
    
    protected static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseTest.class);
    protected static ExtentReports extent;
    protected static ExtentTest test;
    protected static ThreadLocal<ExtentTest> testThread = new ThreadLocal<>();
    protected static ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();
    
    @BeforeSuite
    public void setupExtentReport() {
        String reportPath = ConfigReader.getProperty("report.path") + "ExtentReport.html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setDocumentTitle("E-Commerce Test Report");
        spark.config().setReportName("Automation Test Execution");
        spark.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
        
        extent = new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("OS", System.getProperty("os.name"));
        extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        extent.setSystemInfo("Browser", ConfigReader.getProperty("browser"));
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Automation Team");
        
        logger.info("Extent Report initialized");
    }
    
    @BeforeMethod
    public void setupDriver(Method method) {
        String browser = ConfigReader.getProperty("browser", "chrome");
        boolean headless = Boolean.parseBoolean(ConfigReader.getProperty("headless", "false"));
        
        WebDriverManager.chromedriver().setup();
        
        switch(browser.toLowerCase()) {
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (headless) {
                    chromeOptions.addArguments("--headless");
                }
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--incognito");
                chromeOptions.addArguments("--remote-allow-origins=*");
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                driver = new FirefoxDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        
        driverThread.set(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(
            Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicit.wait", "10"))));
        driver.manage().timeouts().pageLoadTimeout(
            Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("page.load.timeout", "30"))));
        driver.manage().deleteAllCookies();
        
        // Initialize Extent Test
        test = extent.createTest(method.getName());
        testThread.set(test);
        
        logger.info("Test started: {}", method.getName());
        logger.info("Browser initialized: {}", browser);
        
        // Navigate to URL
        driver.get(ConfigReader.getProperty("app.url", "https://www.demoblaze.com"));
        logger.info("Navigated to URL: {}", ConfigReader.getProperty("app.url"));
    }
    
    @AfterMethod
    public void teardown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            logger.error("Test failed: {}", result.getName());
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
            testThread.get().fail(result.getThrowable());
            testThread.get().addScreenCaptureFromPath(screenshotPath);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.info("Test passed: {}", result.getName());
            testThread.get().pass("Test executed successfully");
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.warn("Test skipped: {}", result.getName());
            testThread.get().skip("Test skipped");
        }
        
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Browser closed");
            } catch (Exception e) {
                logger.error("Error closing browser: {}", e.getMessage());
            }
        }
        driverThread.remove();
        testThread.remove();
    }
    
    @AfterSuite
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
            logger.info("Extent Report generated");
        }
    }
    
    public static WebDriver getDriver() {
        return driverThread.get();
    }
    
    public static ExtentTest getTest() {
        return testThread.get();
    }
}
