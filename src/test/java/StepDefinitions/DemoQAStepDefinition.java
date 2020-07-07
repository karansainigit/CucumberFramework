package StepDefinitions;

import PageObjects.DemoQAPageObjects;
import PageObjects.HomePageObjects;
import Resources.Base;
import cucumber.api.PendingException;
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
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RunWith(Cucumber.class)
public class DemoQAStepDefinition extends Base {

    public WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger(DemoQAStepDefinition.class.getName());

    public DemoQAPageObjects dqa;

    @Before("@Demo")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @After("@Demo")
    public void tearDown() {
        driver.quit();
        log.info("Browser closed");
    }

    @Given("^User navigates to \"([^\"]*)\" website$")
    public void userNavigatesToWebsite(String url) throws Throwable {
        driver.get(url);
        log.info("Demo QA website opened");
    }

    @When("^User clicks on Text Box$")
    public void userClicksOnTextBox() {
        dqa = new DemoQAPageObjects(driver);
        dqa.textBox().click();
        log.info("Text Box is clicked");
    }

    @And("^User enters \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" all the details and click on Submit button$")
    public void userEntersAllTheDetailsAndClickOnSubmitButton(String fullName, String email, String address) throws Throwable {
        dqa.fullName().sendKeys(fullName);
        dqa.email().sendKeys(email);
        dqa.currentAddress().sendKeys(address);
        dqa.permanentAddress().sendKeys(address);
        log.info("Information entered in text boxes");

        dqa.submit().click();
        log.info("Submit clicked");
    }

    @Then("^Verify Text Box contents displayed correctly$")
    public void verifyTextBoxContentsDisplayedCorrectly() {
        Assert.assertTrue(dqa.outputTextBox().isDisplayed());
        log.info("Submit verified");
    }

    @When("^User clicks on Check Box$")
    public void userClicksOnCheckBox() {
        dqa = new DemoQAPageObjects(driver);
        dqa.checkBox().click();
        log.info("Text Box is clicked");
    }

    @And("^User clicks on Toggle and select Downloads check box$")
    public void userClicksOnToggleAndSelectDownloadsCheckBox() {
        dqa.toggle().click();
        log.info("Toggle clicked");

        dqa.downloadsCheckBox().click();
        log.info("Downloads check box clicked");
    }

    @Then("^Verify \"([^\"]*)\" check box is selected$")
    public void verifyCheckBoxIsSelected(String verifyText) throws Throwable {
        Assert.assertEquals(dqa.verifyCheckBox().getText(),verifyText);
        log.info("Check Box verified");
    }

    @When("^User clicks on Radio Button$")
    public void userClicksOnRadioButton() {
        dqa = new DemoQAPageObjects(driver);
        dqa.radioButton().click();
        log.info("Radio Button is clicked");
    }

    @And("^User clicks on Impressive radio button$")
    public void userClicksOnImpressiveRadioButton() {
        dqa.impressiveRadioButton().click();
        log.info("Impressive Radio Button is clicked");
    }

    @Then("^Verify \"([^\"]*)\" radio box is selected$")
    public void verifyRadioBoxIsSelected(String verifyText) throws Throwable {
        Assert.assertEquals(dqa.verifyRadioButton().getText(),verifyText);
    }

    @When("^User clicks on Web Tables$")
    public void userClicksOnWebTables() {
        dqa = new DemoQAPageObjects(driver);
        dqa.webTable().click();
        log.info("Web Tables is clicked");
    }

    @And("^User clicks on sort by First Name$")
    public void userClicksOnSortByFirstName() {
        dqa.sortFirstName().click();
        log.info("Sort by First Name clicked");
    }

    @Then("^Verify First Name are sorted in ascending order$")
    public void verifyFirstNameAreSortedInAscendingOrder() {
        ArrayList<String> original = new ArrayList<String>();
        for(int i = 0; i < dqa.firstNameColumn().size(); i++) {
            original.add(dqa.firstNameColumn().get(i).getText());
        }

        ArrayList<String> copy = new ArrayList<String>();
        for(int i = 0; i < original.size(); i++) {
            copy.add(original.get(i));
        }

        Collections.sort(copy);

        Assert.assertTrue(original.equals(copy));

        //Assert.assertEquals(original,copy);
    }
}
