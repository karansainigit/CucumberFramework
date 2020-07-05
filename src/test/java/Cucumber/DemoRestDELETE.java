package Cucumber;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class DemoRestDELETE {

    @Test
    public void deleteResponse() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        httpRequest.header("Content-Type", "application/json");

        Response response = httpRequest.request(Method.DELETE,"/delete/100");
        //Response response = httpRequest.delete("/delete/2");

        int statusCode = response.getStatusCode();
        System.out.println(statusCode);

        System.out.println(response.getBody().asString());
        JsonPath jp = response.jsonPath();
        System.out.println(jp.get("status"));

    }
}
