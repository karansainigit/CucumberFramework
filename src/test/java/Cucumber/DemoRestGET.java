package Cucumber;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DemoRestGET {

    @Test
    public void getResponse() {

        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1";

        RequestSpecification httpRequest = RestAssured.given();

        //Response response = httpRequest.request(Method.GET,"/employees");
        Response response = httpRequest.get("/employees");

        String responseBody = response.getBody().asString();
        int statusCode  = response.getStatusCode();
        String statusLine = response.getStatusLine();

        System.out.println("Response Body: " + responseBody);
        System.out.println(statusCode);
        System.out.println(statusLine);

        Assert.assertEquals(statusCode,200);
        Assert.assertEquals(statusLine,"HTTP/1.1 200 OK");

        String contentType = response.header("Content-Type");
        System.out.println(contentType);

        String serverType = response.header("Server");
        System.out.println(serverType);

        String acceptLanguage = response.header("Content-Encoding");
        System.out.println(acceptLanguage);

        Assert.assertEquals(contentType,"application/json;charset=utf-8");
        Assert.assertEquals(serverType,"nginx/1.16.0");
        Assert.assertEquals(acceptLanguage,"gzip");

        Headers allHeaders = response.headers();

        for(Header header : allHeaders) {
            System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
        }

        JsonPath jsonPathEvaluator = response.jsonPath();

        String empname = jsonPathEvaluator.get("status");
            System.out.println(empname);
    }
}
