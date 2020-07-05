package Cucumber;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DemoRestPUT {

    @Test
    public void putResponse() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("name","Karan");
        requestParams.put("salary","90000");
        requestParams.put("age","30");

        httpRequest.header("Content-Type", "application/json");
        httpRequest.body(requestParams.toJSONString());

        Response response = httpRequest.request(Method.PUT,"/update/7");
        //Response response = httpRequest.put("/update/7");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        System.out.println(response.getBody().asString());

        JsonPath jp = response.jsonPath();
        System.out.println(jp.get("status"));

    }
}
