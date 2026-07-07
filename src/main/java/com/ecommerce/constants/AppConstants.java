package com.ecommerce.constants;

/**
 * This class contains all application-wide constants used throughout the framework.
 * Centralized location for all constant values to maintain consistency.
 * 
 * @author Automation Team
 * @version 1.0
 */
public class AppConstants {
    
    // ===== Application URLs =====
    
    /** Base URL for the application */
    public static final String APP_URL = "https://www.demoblaze.com";
    
    /** Development environment URL */
    public static final String DEV_URL = "https://dev.demoblaze.com";
    
    /** QA environment URL */
    public static final String QA_URL = "https://qa.demoblaze.com";
    
    /** Staging environment URL */
    public static final String STAGING_URL = "https://staging.demoblaze.com";
    
    /** Production environment URL */
    public static final String PROD_URL = "https://www.demoblaze.com";
    
    
    // ===== Page Titles =====
    
    /** Home page title */
    public static final String HOME_PAGE_TITLE = "STORE";
    
    /** Login page title */
    public static final String LOGIN_PAGE_TITLE = "STORE";
    
    /** Cart page title */
    public static final String CART_PAGE_TITLE = "STORE";
    
    /** Product page title pattern */
    public static final String PRODUCT_PAGE_TITLE_PATTERN = "STORE";
    
    
    // ===== Timeouts (in seconds) =====
    
    /** Explicit wait timeout */
    public static final int EXPLICIT_WAIT = 20;
    
    /** Implicit wait timeout */
    public static final int IMPLICIT_WAIT = 10;
    
    /** Page load timeout */
    public static final int PAGE_LOAD_TIMEOUT = 30;
    
    /** Script timeout */
    public static final int SCRIPT_TIMEOUT = 10;
    
    /** Polling interval for fluent wait */
    public static final int POLLING_INTERVAL = 500; // milliseconds
    
    /** Retry attempts for flaky tests */
    public static final int RETRY_COUNT = 2;
    
    
    // ===== Test Data =====
    
    /** Path to test data directory */
    public static final String TEST_DATA_PATH = "src/test/resources/testData/";
    
    /** Path to test data Excel file */
    public static final String TEST_DATA_EXCEL = TEST_DATA_PATH + "test-data.xlsx";
    
    /** Path to test data JSON file */
    public static final String TEST_DATA_JSON = TEST_DATA_PATH + "test-data.json";
    
    /** Path to config directory */
    public static final String CONFIG_PATH = "src/test/resources/config/";
    
    /** Path to screenshot directory */
    public static final String SCREENSHOT_PATH = "screenshots/";
    
    /** Path to report directory */
    public static final String REPORT_PATH = "test-output/";
    
    /** Path to log directory */
    public static final String LOG_PATH = "logs/";
    
    /** Path to allure results */
    public static final String ALLURE_RESULTS_PATH = "target/allure-results/";
    
    
    // ===== User Credentials (for testing) =====
    
    /** Default test username */
    public static final String TEST_USERNAME = "testuser123";
    
    /** Default test password */
    public static final String TEST_PASSWORD = "Test@123";
    
    /** Admin username */
    public static final String ADMIN_USERNAME = "admin";
    
    /** Admin password */
    public static final String ADMIN_PASSWORD = "Admin@123";
    
    /** Invalid username for negative testing */
    public static final String INVALID_USERNAME = "invaliduser";
    
    /** Invalid password for negative testing */
    public static final String INVALID_PASSWORD = "wrongpassword";
    
    
    // ===== Product Categories =====
    
    /** Phones category */
    public static final String CATEGORY_PHONES = "Phones";
    
    /** Laptops category */
    public static final String CATEGORY_LAPTOPS = "Laptops";
    
    /** Monitors category */
    public static final String CATEGORY_MONITORS = "Monitors";
    
    /** Accessories category */
    public static final String CATEGORY_ACCESSORIES = "Accessories";
    
    
    // ===== Product Names =====
    
    /** Sample product for testing */
    public static final String SAMPLE_PRODUCT = "Samsung Galaxy S6";
    
    /** Sample laptop for testing */
    public static final String SAMPLE_LAPTOP = "MacBook Pro";
    
    /** Sample monitor for testing */
    public static final String SAMPLE_MONITOR = "Apple Cinema 30\"";
    
    /** Sample phone for testing */
    public static final String SAMPLE_PHONE = "Nokia Lumia 1520";
    
    
    // ===== Payment Information =====
    
    /** Test card number */
    public static final String TEST_CARD_NUMBER = "4111111111111111";
    
    /** Test card expiry month */
    public static final String TEST_CARD_MONTH = "12";
    
    /** Test card expiry year */
    public static final String TEST_CARD_YEAR = "2025";
    
    /** Test CVV */
    public static final String TEST_CVV = "123";
    
    /** Test card holder name */
    public static final String TEST_CARD_HOLDER = "Test User";
    
    /** Test address */
    public static final String TEST_ADDRESS = "123 Test Street, Test City";
    
    /** Test country */
    public static final String TEST_COUNTRY = "USA";
    
    /** Test city */
    public static final String TEST_CITY = "New York";
    
    /** Test zip code */
    public static final String TEST_ZIP = "10001";
    
    /** Test phone number */
    public static final String TEST_PHONE = "1234567890";
    
    
    // ===== Error Messages =====
    
    /** Invalid login error message */
    public static final String ERROR_INVALID_LOGIN = "Invalid username or password";
    
    /** Required field error message */
    public static final String ERROR_REQUIRED_FIELD = "This field is required";
    
    /** Empty cart message */
    public static final String EMPTY_CART_MESSAGE = "Your cart is empty";
    
    /** Order success message */
    public static final String ORDER_SUCCESS_MESSAGE = "Thank you for your purchase!";
    
    /** Registration success message */
    public static final String REGISTRATION_SUCCESS = "Sign up successful";
    
    /** Product added to cart message */
    public static final String PRODUCT_ADDED_MESSAGE = "Product added to cart";
    
    
    // ===== Browser Settings =====
    
    /** Default browser to use */
    public static final String DEFAULT_BROWSER = "chrome";
    
    /** Supported browsers list */
    public static final String[] SUPPORTED_BROWSERS = {"chrome", "firefox", "edge", "safari"};
    
    /** Headless mode flag */
    public static final boolean HEADLESS_MODE = false;
    
    /** Maximize window flag */
    public static final boolean MAXIMIZE_WINDOW = true;
    
    
    // ===== Selenium Grid =====
    
    /** Selenium Grid URL */
    public static final String GRID_URL = "http://localhost:4444/wd/hub";
    
    /** Use Selenium Grid flag */
    public static final boolean USE_GRID = false;
    
    
    // ===== API Constants =====
    
    /** API Base URL */
    public static final String API_BASE_URL = "https://api.demoblaze.com";
    
    /** API Endpoint - Login */
    public static final String API_LOGIN = "/api/login";
    
    /** API Endpoint - Register */
    public static final String API_REGISTER = "/api/register";
    
    /** API Endpoint - Products */
    public static final String API_PRODUCTS = "/api/products";
    
    /** API Endpoint - Cart */
    public static final String API_CART = "/api/cart";
    
    /** API Timeout */
    public static final int API_TIMEOUT = 30;
    
    
    // ===== Report Constants =====
    
    /** Extent Report file name */
    public static final String EXTENT_REPORT_NAME = "ExtentReport.html";
    
    /** Allure Report directory */
    public static final String ALLURE_REPORT_DIR = "target/allure-reports";
    
    /** TestNG Report directory */
    public static final String TESTNG_REPORT_DIR = "test-output";
    
    
    // ===== Logging Constants =====
    
    /** Log file name pattern */
    public static final String LOG_FILE_PATTERN = "automation-%d{yyyy-MM-dd}.log";
    
    /** Log pattern */
    public static final String LOG_PATTERN = "%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n";
    
    
    // ===== Database Constants (if needed) =====
    
    /** Database URL */
    public static final String DB_URL = "jdbc:mysql://localhost:3306/testdb";
    
    /** Database username */
    public static final String DB_USERNAME = "root";
    
    /** Database password */
    public static final String DB_PASSWORD = "password";
    
    /** Database driver class */
    public static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    
    
    // ===== Email Configuration =====
    
    /** Email host */
    public static final String EMAIL_HOST = "smtp.gmail.com";
    
    /** Email port */
    public static final int EMAIL_PORT = 587;
    
    /** From email address */
    public static final String EMAIL_FROM = "automation@example.com";
    
    /** To email address */
    public static final String EMAIL_TO = "test@example.com";
    
    /** Email subject */
    public static final String EMAIL_SUBJECT = "Test Execution Report";
    
    
    // ===== File Extensions =====
    
    /** Excel file extension */
    public static final String EXCEL_EXTENSION = ".xlsx";
    
    /** CSV file extension */
    public static final String CSV_EXTENSION = ".csv";
    
    /** JSON file extension */
    public static final String JSON_EXTENSION = ".json";
    
    /** XML file extension */
    public static final String XML_EXTENSION = ".xml";
    
    /** PDF file extension */
    public static final String PDF_EXTENSION = ".pdf";
    
    /** PNG file extension */
    public static final String PNG_EXTENSION = ".png";
    
    /** HTML file extension */
    public static final String HTML_EXTENSION = ".html";
    
    
    // ===== Regular Expressions =====
    
    /** Email pattern */
    public static final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";
    
    /** Phone pattern - US format */
    public static final String PHONE_PATTERN = "^\\d{10}$";
    
    /** Password pattern - at least 8 chars with special char */
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    
    /** Zip code pattern - US */
    public static final String ZIP_PATTERN = "^\\d{5}(?:[-\\s]\\d{4})?$";
    
    
    // ===== Special Characters =====
    
    /** Dollar sign */
    public static final String DOLLAR_SIGN = "$";
    
    /** Percentage sign */
    public static final String PERCENTAGE_SIGN = "%";
    
    /** Comma */
    public static final String COMMA = ",";
    
    /** Space */
    public static final String SPACE = " ";
    
    /** Hyphen */
    public static final String HYPHEN = "-";
    
    /** Underscore */
    public static final String UNDERSCORE = "_";
    
    /** Forward slash */
    public static final String FORWARD_SLASH = "/";
    
    /** Backward slash */
    public static final String BACKWARD_SLASH = "\\";
    
    /** Colon */
    public static final String COLON = ":";
    
    /** Semicolon */
    public static final String SEMICOLON = ";";
    
    /** New line */
    public static final String NEW_LINE = "\n";
    
    /** Tab */
    public static final String TAB = "\t";
}
