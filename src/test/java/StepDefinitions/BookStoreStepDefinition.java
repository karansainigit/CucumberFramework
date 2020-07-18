package StepDefinitions;

import PageObjects.DemoQAPageObjects;
import Resources.Base;
import com.cucumber.listener.Reporter;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;

@RunWith(Cucumber.class)
public class BookStoreStepDefinition extends Base {

    public WebDriver driver;
    public WebDriverWait expWait;
    public static Logger log = (Logger) LogManager.getLogger(DemoQAStepDefinition.class.getName());

    public DemoQAPageObjects dqa;

    @Before("@Book")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @After("@Book")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Take a screenshot...
            String screen = getScreenshotWeb(driver,scenario.getName());
            Reporter.addScreenCaptureFromPath(screen);
        }
        driver.quit();
        log.info("Browser closed");
    }

    @Given("^User opens Book Store Application \"([^\"]*)\"$")
    public void userOpensBookStoreApplication(String url) throws Throwable {
        driver.get(url);
        log.info("Book Store Application opened");
    }

    @When("^User clicks on Login$")
    public void userClicksOnLogin() {
        dqa = new DemoQAPageObjects(driver);

        dqa.login().click();
        log.info("Login clicked");
    }

    @And("^User enters Username \"([^\"]*)\" and Password \"([^\"]*)\"$")
    public void userEntersUsernameAndPassword(String userName, String password) throws Throwable {
        dqa.userName().sendKeys(userName);
        dqa.password().sendKeys(password);
        log.info("Username and Password entered");
    }

    @And("^User clicks on Login to sign in$")
    public void userClicksOnLoginToSignIn() {
        dqa.login().click();
        log.info("Login clicked after entering Username and Password");
    }

    @Then("^User should be successfully Signed In$")
    public void userShouldBeSuccessfullySignedIn() {
        expWait = explicitWait(driver,5);
        expWait.until(ExpectedConditions.visibilityOf(dqa.userNameValue()));
        Assert.assertTrue(dqa.userNameValue().isDisplayed());
    }
}
