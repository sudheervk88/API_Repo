package com.tests;

import com.annotations.FrameworkAnnotations;
import com.constants.FrameworkConstants;
import com.constants.FrameworkConstantsSingleTon;
import com.reports.ExtentLogger;
import com.requestBuilder.ApiBuilders;
import com.student.Student;
import com.utils.ApiUtils;
import com.utils.RandomUtils;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class PostTest extends BaseTest{
    @Test
    @FrameworkAnnotations(authorName = "SVK",category = {"smoke","Regression"})
    public void postDetails(){

     Student student =   Student.
                            builder().
                            setStudentName(RandomUtils.getFirstName()).
                            setLastName(RandomUtils.getLastName()).
                            setId(RandomUtils.getId()).
                            setDepartment(RandomUtils.getJob()).
                            build();

     RequestSpecification requestSpecification = ApiBuilders.
                            buildRequestForPostCall().
                            body(student);
     ExtentLogger.logRequest(requestSpecification);
     Response response = requestSpecification.post("/api/users");
     ExtentLogger.logResponse(response.prettyPrint());

    }

    @Test
    @FrameworkAnnotations(authorName = "sudheer",category = "Regression")
    public void postTestUsingExternalFiles(Method method){

      String reqBody =  ApiUtils.
                readJsonAsString(FrameworkConstants.requestJsonPath+"Request.json").
                replace("sudheer",RandomUtils.getFirstName()).
                replace("number",String.valueOf(RandomUtils.getId()));

        RequestSpecification requestSpecification = ApiBuilders.
                buildRequestForPostCall().
                body(reqBody);
        ExtentLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/api/users");

        ExtentLogger.logResponse(response.asPrettyString());
        ApiUtils.storeResponseAsJson(FrameworkConstants.responseJsonPath+"response.json",response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
        Assertions.assertThat(response.jsonPath().getString("FavFood.lunch")).isEqualTo("rice");
        Assertions.assertThat(response.jsonPath().getString("FavFood.dinner[0]")).isEqualTo("chapati");

    }

    @Test
    @FrameworkAnnotations(authorName = {"sudheer","SVK"},category = {"smoke","Regression"})
    public void postTestUsingExternalFiles_singletonCheck(Method method){

        String reqBody =  ApiUtils.readJsonAsString(FrameworkConstants.requestJsonPath+"Request.json").
                replace("sudheer",RandomUtils.getFirstName()).
                replace("number",String.valueOf(RandomUtils.getId()));

        RequestSpecification requestSpecification = ApiBuilders.
                buildRequestForPostCall().
                body(reqBody);
        ExtentLogger.logRequest(requestSpecification);
        Response response = requestSpecification.post("/api/users");
        ExtentLogger.logResponse(response.asPrettyString());
        ApiUtils.storeResponseAsJson(FrameworkConstants.responseJsonPath+"response.json",response);

        Assertions.assertThat(response.getStatusCode()).isEqualTo(201);
        Assertions.assertThat(response.jsonPath().getString("FavFood.lunch")).isEqualTo("rice");
        Assertions.assertThat(response.jsonPath().getString("FavFood.dinner[0]")).isEqualTo("chapati");

    }





}
