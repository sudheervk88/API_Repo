import com.constants.FrameworkConstants;
import com.utils.ApiUtils;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class AuthDemo {

  @Test
  public void basicAuthTest_Auth(){
//this utilizes the username and password injection
     RequestSpecification requestSpecification= given().
                                                    auth().
                                                    basic("postman","password").
                                                    log().
                                                    all();
    Response response = requestSpecification.get("https://postman-echo.com/basic-auth");

      String val = response.jsonPath().getString("authenticated");
      System.out.println(val);
      response.prettyPrint();

  }

  @Test
  public void basicAuthTest_AuthToken(){
//this utilizes the username and password injection
    RequestSpecification requestSpecification= given().
            header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==").
            log().
            all();
    Response response = requestSpecification.get("https://postman-echo.com/basic-auth");

    String val = response.jsonPath().getString("authenticated");
    System.out.println(val);
    response.prettyPrint();

  }

  @Test
  public void basicAuthTest_CreateRepo(){
//this utilizes the username and password injection

    JSONObject obj = new JSONObject();
    obj.put("name","Dummy_Repo_Automation");
    obj.put("description","Test2");

    RequestSpecification requestSpecification= given().
            header("Authorization","Bearer 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").
            header("Accept","application/vnd.github+json").
            body(obj.toMap()).
            log().
            all();
    Response response = requestSpecification.post("https://api.github.com/user/repos");
    response.prettyPrint();

  }

  @Test
  public void createDefect(){

    String reqBody = ApiUtils.readJsonAsString(FrameworkConstants.jiraJsonPath+"JiraInputData.json").
                     replace("KEY","TES").
                     replace("SUMMERY","defect for rest api automation").
                     replace("DESCRIPTION","defect.....");

     RequestSpecification req =  given().
                                   config(RestAssuredConfig.config().logConfig(LogConfig.logConfig().blacklistHeader("Authorization"))).
                                   header("Authorization","Basic c3VkaGVlcnZrODg6U2VsZW5pdW0hMQ==").
                                   contentType(ContentType.JSON).
                                   body(reqBody).
                                   log().
                                   all();
     Response response = req.post("http://localhost:8080/rest/api/2/issue/");
     response.prettyPrint();


  }


}
