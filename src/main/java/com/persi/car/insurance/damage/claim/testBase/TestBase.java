package com.persi.car.insurance.damage.claim.testBase;

/**
 * Created by sudam_tilekar on 8/23/2019
 **/

import com.persi.car.insurance.damage.claim.utils.TestUtils;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class TestBase {

    TestUtils testUtils;
    public static WebDriver driver;
    public static Properties properties;
    public static ExtentReports extentreports;
    public static ExtentTest extenttest;
    public static Logger log = Logger.getLogger(TestBase.class.getName());

    //    Constructor
    public TestBase() {
//        Load configuration.properties file. Configuration properties file contains global variable
//        such as URL, User name, Password, Browser etc.
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/configuration.properties");
            properties = new Properties();
            try {
                properties.load(fileInputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void extentInit() {
        extentreports = new ExtentReports(System.getProperty("user.dir") + "/test-output/ExtentReport.html", true);
    }

    //    Call Browser which is declared in configuration.properties file.
    @BeforeMethod
    public static void initializeBrowser() {


        if (properties.getProperty("browser").equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/chromedriver.exe");
            driver = new ChromeDriver();
        }
//        Delete all cookies
        driver.manage().deleteAllCookies();
//        Maximize the Browser
        driver.manage().window().maximize();
//        Call browser URL from configuration.properties file and load it.
        driver.get(properties.getProperty("url"));
//        Declare Implicitly Wait and Page Load Wait
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        testUtils = new TestUtils();
        if (result.getStatus() == ITestResult.FAILURE) {
            extenttest.log(LogStatus.FAIL, "Test Case - " + result.getName() + "Failed");
            extenttest.log(LogStatus.FAIL, result.getThrowable());
            String screenPath = testUtils.takeScreenShot(result);
            extenttest.log(LogStatus.FAIL, extenttest.addScreenCapture(screenPath));
        } else if (result.getStatus() == ITestResult.SKIP) {
            extenttest.log(LogStatus.SKIP, "Test Case - " + result.getName() + "Skipped");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extenttest.log(LogStatus.PASS, "Test Case - " + result.getName() + "Passed");
        }

        extentreports.endTest(extenttest);
        driver.quit();
    }

    @AfterTest
    public void extentClose() {
        extentreports.flush();
        extentreports.close();

    }
}
