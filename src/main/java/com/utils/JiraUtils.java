package com.utils;

import com.constants.FrameworkConstants;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.LinkedHashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public final class JiraUtils {

    private JiraUtils(){

    }

    public static String createIssueInJira(String errorMessage) {

        String replaceIllegal= errorMessage.replaceAll("\n","").replaceAll("\r","").replaceAll("\"","\\\\\"");
        String reqBody = ApiUtils.readJsonAsString(FrameworkConstants.jiraJsonPath + "JiraInputData.json").
                replace("KEY", "TES").
                replace("SUMMERY", "defect for rest api automation").
                replace("DESCRIPTION",replaceIllegal);

        RequestSpecification req = given().
                config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization"))).
                header("Authorization", "Basic c3VkaGVlcnZrODg6U2VsZW5pdW0hMQ==").
                contentType(ContentType.JSON).
                body(reqBody).
                log().
                all();

        Response response = req.post("http://localhost:8080/rest/api/2/issue/");
        String key = response.jsonPath().getString("key");
        System.out.println("Key:::" + key);
        response.prettyPrint();
        return key;
    }


}
