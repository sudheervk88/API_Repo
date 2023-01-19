package com.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public final class ExtentReport {

    private static ExtentReports extentReports;
    private static ExtentTest test;


    private ExtentReport(){

    }

    public static void initReport(){
        extentReports = new ExtentReports();
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("index.html");
        extentReports.attachReporter(sparkReporter);
    }

    public static void tearDownReport(){
        extentReports.flush();
    }
    public static void createTest(String name) {
        test = extentReports.createTest(name);
        ExtentManager.setTest(test);
    }
}
