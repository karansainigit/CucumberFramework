package StepDefinitions;

import PageObjects.HomePageObjects;
import Resources.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

@RunWith(Cucumber.class)
public class WebStepDefinition extends Base {

    public WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger(WebStepDefinition.class.getName());

    HomePageObjects hp;

    @Before("@Web")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @Given("^Navigate to \"([^\"]*)\" website$")
    public void navigateToWebsite(String url) throws Throwable {
        driver.get(url);
        log.info("Navigated to Home Page");
    }

    @Then("^Verify Home Page title is \"([^\"]*)\"$")
    public void verifyHomePageTitleIs(String homePageTitle) throws Throwable {
        Assert.assertEquals(driver.getTitle(),homePageTitle);
        log.info("Home Page title verified");
    }

    @Then("^Verify Default Welcome Message is \"([^\"]*)\"$")
    public void verifyDefaultWelcomeMessageIs(String defaultWelcomeMessage) throws Throwable {
        hp = new HomePageObjects(driver);
        Assert.assertEquals(hp.defaultWelcomeMessage().getText(),defaultWelcomeMessage);
        log.info("Default Welcome Message verified");
    }

    @After("@Web")
    public void tearDown() {
        driver.quit();
        log.info("Browser closed");
    }
}
