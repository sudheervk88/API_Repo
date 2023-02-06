package com.utils;

import com.constants.FrameworkConstants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public final class JiraUtils {

    private JiraUtils(){

    }

    public static String createIssueInJira(String errorMessage){

        String reqBody = ApiUtils.readJsonAsString(FrameworkConstants.jiraJsonPath+"JiraInputData.json").
                replace("KEY","TES").
                replace("DESCRIPTION",errorMessage);

        RequestSpecification req =  given().
                contentType(ContentType.JSON).
                auth().
                basic("sudheervk88","Selenium!1").
                body(reqBody).
                log().
                all();
        Response response = req.post("http://localhost:8080/rest/api/2/issue/");
        response.prettyPrint();
        return response.jsonPath().getString("key");
    }


}
