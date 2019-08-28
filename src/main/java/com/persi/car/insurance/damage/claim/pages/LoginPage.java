package com.persi.car.insurance.damage.claim.pages;

/**
 * Created by sudam_tilekar on 8/23/2019
 **/

import com.persi.car.insurance.damage.claim.testBase.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends TestBase {

    public static final String loginPageTitle = "Car Insurance";

    //    @FindBy(xpath = "//div[@class='mat-form-field-infix']/input[@ng-reflect-placeholder='Username']")
    @FindBy(css = "#mat-input-0")
    @CacheLookup
    WebElement userName;

    @FindBy(xpath = "//div[@class='mat-form-field-infix']/input[@ng-reflect-placeholder='Password']")
//    @FindBy(css = "#mat-input-1")
    @CacheLookup
    WebElement passWord;

    @FindBy(xpath = "//div[@class='box_buttons']/button[@class='btn_login']")
    @CacheLookup
    WebElement signIn;

    //    Initialize the Page Factor
    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    //    To Set UserName
    public void setUserName(String enterUserName) {
        userName.sendKeys(enterUserName);
        log.info("UserName Entered - " + enterUserName);
    }

    public void setPassWord(String enterPassWord) {
        passWord.sendKeys(enterPassWord);
        log.info("Password Entered - *******");
    }

    public void clickSignIn() {
        signIn.click();
        log.info("User Logged In Successfully");
    }

    public void loginToCareDamageInsurance(String enterUserName, String enterPassWord) {
        setUserName(enterUserName);
        setPassWord(enterPassWord);
        signIn.click();
        log.info("User Logged In Successfully");
    }

    public void validateLoginPageTitle() {
        Assert.assertEquals(driver.getTitle(), loginPageTitle, "Page Title not matched");
    }
}
