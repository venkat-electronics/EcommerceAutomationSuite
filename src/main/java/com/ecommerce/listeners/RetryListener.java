package com.ecommerce.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * RetryListener - Implements IRetryAnalyzer for retrying failed tests
 * This is NOT a TestNG listener - it's a retry analyzer
 */
public class RetryListener implements IRetryAnalyzer {
    
    private static final Logger logger = LogManager.getLogger(RetryListener.class);
    private int retryCount = 0;
    private static final int MAX_RETRY_COUNT = 2;
    
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            String testName = result.getName();
            logger.warn("🔄 RETRYING test: {} (Attempt {} of {})", 
                testName, retryCount, MAX_RETRY_COUNT);
            System.out.println("🔄 Retrying test: " + testName + 
                " (Attempt " + retryCount + " of " + MAX_RETRY_COUNT + ")");
            return true;
        }
        return false;
    }
}
