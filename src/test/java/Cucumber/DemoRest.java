package Cucumber;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRest {

    @Test
    public void restDemo() {

        String baseURL = "https://demoqa.com/Account/v1";
        String userName = "TOOLSQA-Test";
        String password = "Test@@123";

        RestAssured.baseURI = baseURL;

        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", userName);
        requestParams.put("password", password);

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());

        //Post Authorized
        Response response1 = request.request(Method.POST,"/Authorized");
        //Response response = httpRequest.delete("/delete/2");

        int statusCode1 = response1.getStatusCode();
        Assert.assertEquals(statusCode1,200);

        //System.out.println(response1.getBody().asString());
        Assert.assertEquals(response1.getBody().asString(),"true");

        //Post Generate Token
        Response response2 = request.post("/GenerateToken");

        int statusCode2 = response2.getStatusCode();
        Assert.assertEquals(statusCode2,200);

        System.out.println(response2.getBody().asString());

        JsonPath jp = response2.jsonPath();
        Assert.assertEquals(jp.get("status"),"Success");

        //Post User

        Response response3 = request.post("/User");

        int statusCode3 = response3.getStatusCode();
        Assert.assertEquals(statusCode3,406);

        System.out.println(response3.getBody().asString());

        JsonPath jp1 = response3.jsonPath();
        Assert.assertEquals(jp1.get("code"),"1204");

    }
}
