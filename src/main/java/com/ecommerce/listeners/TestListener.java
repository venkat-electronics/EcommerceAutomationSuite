package com.ecommerce.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ecommerce.base.BaseTest;
import com.ecommerce.utils.ScreenshotUtil;

public class TestListener implements ITestListener {
    
    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(">>>>> Starting test: " + result.getName());
        BaseTest.logger.info("Test started: {}", result.getName());
        
        // Create Extent Test
        if (BaseTest.getTest() != null) {
            BaseTest.getTest().log(Status.INFO, "Test Started: " + result.getName());
        }
    }
    
    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(">>>>> Test PASSED: " + result.getName());
        BaseTest.logger.info("Test PASSED: {}", result.getName());
        
        if (BaseTest.getTest() != null) {
            BaseTest.getTest().log(Status.PASS, "Test Passed");
        }
    }
    
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(">>>>> Test FAILED: " + result.getName());
        BaseTest.logger.error("Test FAILED: {}", result.getName());
        BaseTest.logger.error("Failure Reason: {}", result.getThrowable());
        
        try {
            // Capture screenshot on failure
            String screenshotPath = ScreenshotUtil.captureScreenshot(
                BaseTest.getDriver(), 
                result.getName()
            );
            
            if (screenshotPath != null) {
                System.out.println("Screenshot captured: " + screenshotPath);
                if (BaseTest.getTest() != null) {
                    BaseTest.getTest().log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());
                    BaseTest.getTest().addScreenCaptureFromPath(screenshotPath);
                }
            }
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
    
    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(">>>>> Test SKIPPED: " + result.getName());
        BaseTest.logger.warn("Test SKIPPED: {}", result.getName());
        
        if (BaseTest.getTest() != null) {
            BaseTest.getTest().log(Status.SKIP, "Test Skipped");
        }
    }
    
    @Override
    public void onStart(ITestContext context) {
        System.out.println("========================================");
        System.out.println("Test Suite Started: " + context.getName());
        System.out.println("========================================");
        BaseTest.logger.info("Test Suite Started: {}", context.getName());
    }
    
    @Override
    public void onFinish(ITestContext context) {
        System.out.println("========================================");
        System.out.println("Test Suite Completed: " + context.getName());
        System.out.println("Total Tests: " + context.getAllTestMethods().length);
        System.out.println("Passed: " + context.getPassedTests().size());
        System.out.println("Failed: " + context.getFailedTests().size());
        System.out.println("Skipped: " + context.getSkippedTests().size());
        System.out.println("========================================");
        BaseTest.logger.info("Test Suite Completed: {}", context.getName());
    }
}
