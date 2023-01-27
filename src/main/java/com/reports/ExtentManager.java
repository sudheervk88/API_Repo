package com.reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentManager {


    private ExtentManager(){

    }

    private static ThreadLocal<ExtentTest> exTest = new ThreadLocal<>();

    public static ExtentTest getTest(){
        return exTest.get();
    }

    public static void setTest(ExtentTest test){
        exTest.set(test);
    }


}
