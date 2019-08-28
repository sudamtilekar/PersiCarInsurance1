package com.persi.car.insurance.damage.claim.test.logiPage;

/**
 * Created by sudam_tilekar on 8/23/2019
 **/

import com.persi.car.insurance.damage.claim.pages.LoginPage;
import com.persi.car.insurance.damage.claim.testBase.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    LoginPage loginPage;

    public LoginTest() {
        super();
    }

    @Test
    public void loginToApp() {
        loginPage = new LoginPage();

//        Generate Test Report
        extenttest = extentreports.startTest("Login Page Test ");
        log.info("********** Start - Login Page Test **********");

//        Validate Car Insurance Login page launched successfully
        loginPage.validateLoginPageTitle();

/*
//        Login to the Car Insurance page using hard coded Credentials
        log.info("Send hardcoded Login Credentials");
        loginPage.loginToCareDamageInsurance("admin", "admin");
*/

//        Get Login Credentials from Config.properties to login Car Insurance Application
        log.info("Get Login Credentials from Config Properties file");
        loginPage.loginToCareDamageInsurance(properties.getProperty("username"), properties.getProperty("password"));


        log.info("********** End - Login Page Test **********");
    }
}
