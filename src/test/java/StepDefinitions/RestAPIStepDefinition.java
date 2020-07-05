package StepDefinitions;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.runner.RunWith;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class RestAPIStepDefinition {

    public RequestSpecification request = null;
    public Response response1 = null;
    public Response response2 = null;
    public Response response3 = null;

    @Given("^BaseURL \"([^\"]*)\" is set$")
    public void baseurlIsSet(String baseURL) throws Throwable {
        RestAssured.baseURI = baseURL;
        request = RestAssured.given();
    }

    @And("^Username \"([^\"]*)\" and Password \"([^\"]*)\" for the request body$")
    public void usernameAndPasswordForTheRequestBody(String username, String password) throws Throwable {
        JSONObject requestParams = new JSONObject();
        requestParams.put("userName", username);
        requestParams.put("password", password);

        request.header("Content-Type", "application/json");
        request.body(requestParams.toJSONString());
    }

    @When("^Post Authorized request is made$")
    public void postAuthorizedRequestIsMade() {
        response1 = request.request(Method.POST,"/Authorized");
    }

    @And("^Post GenerateToken request is made$")
    public void postGenerateTokenRequestIsMade() {
        response2 = request.post("/GenerateToken");
    }

    @And("^Post User request is made$")
    public void postUserRequestIsMade() {
        response3 = request.post("/User");
    }

    @Then("^Verifying the status of these request$")
    public void verifyingTheStatusOfTheseRequest() {
        int statusCode1 = response1.getStatusCode();
        Assert.assertEquals(statusCode1,200);

        Assert.assertEquals(response1.getBody().asString(),"true");

        int statusCode2 = response2.getStatusCode();
        Assert.assertEquals(statusCode2,200);

        JsonPath jp2 = response2.jsonPath();
        Assert.assertEquals(jp2.get("status"),"Success");

        int statusCode3 = response3.getStatusCode();
        Assert.assertEquals(statusCode3,406);

        JsonPath jp3 = response3.jsonPath();
        Assert.assertEquals(jp3.get("code"),"1204");
    }
}
