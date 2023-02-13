package com.listeners;

import com.annotations.FrameworkAnnotations;
import com.reports.ExtentLogger;
import com.reports.ExtentReport;
import com.utils.JiraUtils;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        ExtentReport.initReport();
    }

    @Override
    public void onFinish(ISuite suite) {
        ExtentReport.tearDownReport();
    }

    @Override
    public void onTestStart(ITestResult result) {

        ExtentReport.createTest(result.getName());
        String[] author = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).authorName();
        ExtentReport.addAuthor(author);
        String[] category = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(FrameworkAnnotations.class).category();
        ExtentReport.addCategory(category);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentLogger.pass(result.getName()+" is Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentLogger.fail(String.valueOf(result.getThrowable()));
        String issueInJira = JiraUtils.createIssueInJira(String.valueOf(result.getThrowable()));
        ExtentLogger.fail("Issue created in Jira"+"::::"+"http://localhost:8080/browse/"+issueInJira);

    }



}
