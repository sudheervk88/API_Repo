package com.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.requestBuilder.ApiBuilders;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {

    @Test
    public void getDetails(){

        Response response = ApiBuilders.buildRequestForGetCall().
                get("/api/users");

        System.out.println(response.getStatusCode());

        response.prettyPrint();
        ExtentLogger.logResponse(response.asPrettyString());
        Assertions.
                assertThat(response.getStatusCode()).
                isEqualTo(200).isPositive();

    }

    @Test
    public void getDetailOfSingleEmployee(){

        Response response = ApiBuilders.
                buildRequestForGetCall().
                pathParam("userId",2).
                get("/api/users/{userId}");

        System.out.println(response.getStatusCode());
        response.prettyPrint();
        ExtentLogger.logResponse(response.asPrettyString());
        Assertions.
                assertThat(response.getStatusCode()).
                isEqualTo(200).isPositive();

    }



}
