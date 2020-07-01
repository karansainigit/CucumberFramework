package StepDefinitions;

import PageObjects.MobileAppAnimationScreenObjects;
import PageObjects.MobileAppHomeScreenObjects;
import Resources.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
public class MobileStepDefinition extends Base {

    public AndroidDriver<AndroidElement> driver;
    public static Logger log = (Logger) LogManager.getLogger(MobileStepDefinition.class.getName());

    public MobileAppHomeScreenObjects mahs;
    public MobileAppAnimationScreenObjects maas;

    /*@Before
    public void initializeMobile() throws IOException {
        driver = initializeAndroid();
        log.info("Android Driver is initialized");
    }*/

    @Given("^User is on home screen and clicks on Animation$")
    public void userIsOnHomeScreenAndClicksOnAnimation() throws IOException {
        driver = initializeAndroid();
        log.info("Android Driver is initialized");
        mahs = new MobileAppHomeScreenObjects(driver);
        maas = mahs.animation();
        log.info("Animation is clicked");
    }

    @When("^User clicks on Bouncing Balls$")
    public void userClicksOnBouncingBalls() {
        maas.bouncingBalls().click();
        log.info("Bouncing Balls is clicked");
    }

    @Then("^Bouncing Balls are displayed$")
    public void bouncingBallsAreDisplayed() throws InterruptedException {
        Thread.sleep(2000);
    }
}
