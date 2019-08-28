package com.persi.car.insurance.damage.claim.listners;

/**
 * Created by sudam_tilekar on 8/23/2019
 **/

import com.persi.car.insurance.damage.claim.utils.TestUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ResultListener implements ITestListener {
    public void onTestStart(ITestResult iTestResult) {

        System.out.println("Listner : Test Case Started");

    }

    public void onTestSuccess(ITestResult iTestResult) {

        System.out.println("Listner : Test case Success");
    }

    public void onTestFailure(ITestResult iTestResult) {
        TestUtils.takeScreenShot(iTestResult);
        System.out.println("Listner : Screen Shot taken");
    }

    public void onTestSkipped(ITestResult iTestResult) {

        System.out.println("Listner : Test case Skipped");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

        System.out.println("Listner : Test cases are Failed with Success % as : ");
    }

    public void onStart(ITestContext iTestContext) {

        System.out.println("Listner : Test Case On Start");
    }

    public void onFinish(ITestContext iTestContext) {

        System.out.println("Listner : Test Case Execution Finished");

    }
}
