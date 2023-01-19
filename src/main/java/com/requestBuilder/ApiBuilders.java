package com.requestBuilder;
import com.enums.PropertyType;
import com.utils.PropertyUtils;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public final class ApiBuilders {

private ApiBuilders(){

}

  public static RequestSpecification buildRequestForGetCall(){
    return  given().
            baseUri(PropertyUtils.getValue(PropertyType.BASEURL)).
            log().
            all();
}

    public static RequestSpecification buildRequestForPostCall(){
        return  given().
                baseUri(PropertyUtils.getValue(PropertyType.BASEURL)).
                contentType(ContentType.JSON).
                log().
                all();
    }



}
