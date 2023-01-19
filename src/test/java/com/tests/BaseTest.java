package com.tests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;

public class BaseTest {


    @BeforeSuite
    public void setUpSuite(){
        ExtentReport.initReport();
    }

    @AfterSuite
    public void tearDownSuite(){
        ExtentReport.tearDownReport();
    }

    @BeforeMethod
    public void setUP(Method m){
        ExtentReport.createTest(m.getName());
    }

    @AfterMethod
    public void tearDown(ITestResult result){
        if(!result.isSuccess()){
            ExtentLogger.fail(String.valueOf(result.getThrowable()));
        }
    }
}
