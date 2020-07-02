package StepDefinitions;

import PageObjects.MobileAppAlertDialogsUnderAppScreenObjects;
import PageObjects.MobileAppAnimationScreenObjects;
import PageObjects.MobileAppAppScreenObjects;
import PageObjects.MobileAppHomeScreenObjects;
import Resources.Base;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(Cucumber.class)
public class MobileStepDefinition extends Base {

    public AndroidDriver<AndroidElement> driver;
    public static Logger log = (Logger) LogManager.getLogger(MobileStepDefinition.class.getName());

    public MobileAppHomeScreenObjects mahs;
    public MobileAppAnimationScreenObjects maas;
    public MobileAppAppScreenObjects maa;
    public MobileAppAlertDialogsUnderAppScreenObjects maad;

    @Before("@Mobile,@Animation,@App")
    public void initializeMobile() throws IOException {
        driver = initializeAndroid();
        log.info("Android Driver is initialized");
    }

    @After("@Mobile,@Animation,@App")
    public void closingMobileApp() {
        driver.quit();
        log.info("Mobile App closed");
    }

    @Given("^User is on home screen and clicks on Animation$")
    public void userIsOnHomeScreenAndClicksOnAnimation() throws IOException {
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
        driver.quit();
    }

    @Given("^User is on home screen and clicks on App$")
    public void userIsOnHomeScreenAndClicksOnApp() {
        mahs = new MobileAppHomeScreenObjects(driver);
        maa = mahs.app();
        log.info("App is clicked");
    }

    @When("^User clicks on Alert Dialogs$")
    public void userClicksOnAlertDialogs() {
        maad  = maa.alertDialogs();
        log.info("Alert Dialogs is clicked");
    }

    @And("^User clicks on Single choice list and choose Traffic$")
    public void userClicksOnSingleChoiceListAndChooseTraffic() {
        maad.singleChoiceList().click();
        log.info("Single choice list clicked");

        maad.sclTraffic().click();
        log.info("Traffic is selected");
    }

    @Then("^Traffic should be selected$")
    public void trafficShouldBeSelected() throws InterruptedException {
        Assert.assertEquals(maad.sclTraffic().getAttribute("checked"),"true");

        maad.sclOK().click();
        Thread.sleep(2000);
        log.info("OK to close");
    }

    @And("^User clicks on Ultra long message and swipe till last$")
    public void userClicksOnUltraLongMessageAndSwipeTillLast() {
        maad.ultraLongMessage().click();
        log.info("Ultra long message clicked");

        int x = (maad.ultraLongMessageText().getLocation().getX() + maad.ultraLongMessageText().getSize().getWidth())/2;
        int y = maad.ultraLongMessageText().getLocation().getY() + maad.ultraLongMessageText().getSize().getHeight();

        TouchAction action = new TouchAction(driver);
        action.longPress(PointOption.point(x, (int) (y*0.95))).moveTo(PointOption.point(x, (int) (y*0.05))).release().perform();
    }

    @Then("^User clicks on Ultra long message OK$")
    public void userClicksOnUltraLongMessageOK() throws InterruptedException {
        maad.ulmOK().click();
        Thread.sleep(2000);
        log.info("OK to close");
    }

    @And("^User clicks on Text Entry dialog and enter (.+) , (.+)$")
    public void user_clicks_on_text_entry_dialog_and_enter_(String name, String password) {
        maad.textEntryDialog().click();
        log.info("Text Entry dialog clicked");

        maad.tedName().sendKeys(name);
        log.info("Name entered");
        maad.tedPassword().sendKeys(password);
        log.info("Password entered");
    }

    @Then("^User clicks on Text Entry dialog OK$")
    public void userClicksOnTextEntryDialogOK() throws InterruptedException {
        maad.tedOK().click();
        Thread.sleep(2000);
        log.info("OK to close");
    }
}
