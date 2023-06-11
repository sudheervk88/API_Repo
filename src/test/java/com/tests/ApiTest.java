package com.tests;

import com.annotations.FrameworkAnnotations;
import com.reports.ExtentLogger;
import com.requestBuilder.ApiBuilders;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class ApiTest extends BaseTest {


    @Test
    @FrameworkAnnotations(authorName = {"sudheer","SVK"},category = {"smoke","Regression"})
    public void getDetails(){
        Response response = ApiBuilders.buildRequestForGetCall().
                get("/api/users");

        System.out.println(response.getStatusCode());
        int cod = response.getStatusCode();
        response.prettyPrint();
        //ExtentLogger.logResponse(response.asPrettyString());
        Assertions.
                assertThat(response.getStatusCode()).
                isEqualTo(200).isPositive();

    }

    @Test
    @FrameworkAnnotations(authorName = {"sudheer"},category = "smoke")
    public void getDetailOfSingleEmployee(){

        Response response = ApiBuilders.
                buildRequestForGetCall().
                pathParam("userId",2).
                get("/api/users/{userId}");

        System.out.println(response.getStatusCode());
        //response.prettyPrint();
        ExtentLogger.logResponse(response.asPrettyString());
        Assertions.
                assertThat(response.getStatusCode()).
                isEqualTo(201).isPositive();

    }



}
