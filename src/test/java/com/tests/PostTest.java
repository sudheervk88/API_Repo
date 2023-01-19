package com.tests;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.constants.FrameworkConstants;
import com.constants.FrameworkConstantsSingleTon;
import com.reports.ExtentLogger;
import com.reports.ExtentManager;
import com.reports.ExtentReport;
import com.student.Student;
import com.requestBuilder.ApiBuilders;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PostTest extends BaseTest{


    @Test
    public void postDetails(){

     Student student =   Student.
                            builder().
                            setStudentName(RandomUtils.getFirstName()).
                            setLastName(RandomUtils.getLastName()).
                            setId(RandomUtils.getId()).
                            setDepartment(RandomUtils.getJob()).
                            build();

     Response response = ApiBuilders.
                            buildRequestForPostCall().
                            body(student).
                            post("/api/users");

        ExtentLogger.logResponse(response.asPrettyString());

    }

    @Test
    public void postTestUsingExternalFiles(Method method){

      String reqBody =  ApiUtils.
                readJsonAsString(FrameworkConstants.requestJsonPath+"Request.json").
                replace("sudheer",RandomUtils.getFirstName()).
                replace("number",String.valueOf(RandomUtils.getId()));

        Response response = ApiBuilders.
                buildRequestForPostCall().
                body(reqBody).
                post("/api/users");

        ExtentLogger.logResponse(response.asPrettyString());
        response.prettyPrint();
        ApiUtils.storeResponseAsJson(FrameworkConstants.responseJsonPath+"response.json",response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
        Assertions.assertThat(response.jsonPath().getString("FavFood.lunch")).isEqualTo("rice");
        Assertions.assertThat(response.jsonPath().getString("FavFood.dinner[0]")).isEqualTo("chapati");

    }

    @Test
    public void postTestUsingExternalFiles_singletonCheck(Method method){

        String reqBody =  ApiUtils.readJsonAsString(FrameworkConstantsSingleTon.getInstance().requestJsonPath+"Request.json").
                replace("sudheer",RandomUtils.getFirstName()).
                replace("number",String.valueOf(RandomUtils.getId()));

        Response response = ApiBuilders.
                buildRequestForPostCall().
                body(reqBody).
                post("/api/users");
        ExtentLogger.logResponse(response.asPrettyString());
        response.prettyPrint();
        ApiUtils.storeResponseAsJson(FrameworkConstantsSingleTon.getInstance().getResponseJsonPath()+"response.json",response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
        Assertions.assertThat(response.jsonPath().getString("FavFood.lunch")).isEqualTo("rice");
        Assertions.assertThat(response.jsonPath().getString("FavFood.dinner[0]")).isEqualTo("chapati");

    }





}
