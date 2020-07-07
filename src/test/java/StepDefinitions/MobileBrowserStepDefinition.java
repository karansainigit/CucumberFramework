package StepDefinitions;

import PageObjects.*;
import Resources.Base;
import cucumber.api.PendingException;
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
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.net.URL;
import java.security.Key;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(Cucumber.class)
public class MobileBrowserStepDefinition extends Base {

    public AndroidDriver<AndroidElement> driver;
    public static Logger log = (Logger) LogManager.getLogger(MobileBrowserStepDefinition.class.getName());

    public MobileBrowserPageObjects mb;

    @Before("@MobileBrowser")
    public void initializeMobile() throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2 API R");
        cap.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");

        driver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        log.info("Android Driver is initialized");
    }

    @After("@MobileBrowser")
    public void closingMobileApp() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
        log.info("Mobile App closed");
    }

    @Given("^User navigates to \"([^\"]*)\" url on mobile$")
    public void userNavigatesToUrlOnMobile(String url) throws Throwable {
        Set<String> context = driver.getContextHandles();

        for(String c : context) {
            System.out.println(c);
        }

        driver.context("NATIVE_APP");

        mb = new MobileBrowserPageObjects(driver);
        mb.enterURL().click();
        mb.enterURL().sendKeys(url);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        driver.context("CHROMIUM");
    }

    @When("^User clicks on One Way search$")
    public void userClicksOnOneWaySearch() throws InterruptedException {
        if(mb.popUp().size() > 0) {
            mb.closePopUp().click();
            Thread.sleep(2000);
        }
        mb.oneWay().click();
    }

    @And("^User Enter From \"([^\"]*)\" and To \"([^\"]*)\" city$")
    public void userEnterFromAndToCity(String from, String to) throws Throwable {
        mb.fromCity().click();

        mb.enterFromCity().sendKeys(from);
        Thread.sleep(2000);
        mb.enterFromCity().sendKeys(Keys.ARROW_DOWN);
        mb.enterFromCity().sendKeys(Keys.ENTER);

        mb.toCity().click();
        mb.enterToCity().sendKeys(to);
        Thread.sleep(2000);
        mb.enterToCity().sendKeys(Keys.ARROW_DOWN);
        mb.enterToCity().sendKeys(Keys.ENTER);

        Thread.sleep(2000);
    }

    @And("^User selects Date of travel$")
    public void userSelectsDateOfTravel() {
        mb.departureDate().click();
    }
}
