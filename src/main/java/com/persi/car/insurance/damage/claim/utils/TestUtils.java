package com.persi.car.insurance.damage.claim.utils;

/**
 * Created by sudam_tilekar on 8/23/2019
 **/

import com.persi.car.insurance.damage.claim.testBase.TestBase;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils extends TestBase {

    public static String takeScreenShot(ITestResult result) {
        String pattern = "yyyyMMddHHmmss";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String dateTime = simpleDateFormat.format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String destpath = System.getProperty("user.dir") + "/ScreenShots/" + result.getName() + dateTime + ".png";
        File destination = new File(destpath);
        try {
            FileHandler.copy(source, destination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return destpath;
    }
}
