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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

@RunWith(Cucumber.class)
public class DemoQAStepDefinition extends Base {

    public WebDriver driver;
    public static Logger log = (Logger) LogManager.getLogger(DemoQAStepDefinition.class.getName());

    public String createdLinkMessage;
    public String noContentLinkMessage;
    public String movedLinkMessage;
    public String badRequestLinkMessage;
    public String unauthorizedLinkMessage;
    public String forbiddenLinkMessage;
    public String notFoundLinkMessage;
    public String title1;
    public String title2;

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
        for(int i = 0; i < dqa.firstNameColumn().size()-7; i++) {
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

    @When("^User clicks on Buttons$")
    public void userClicksOnButtons() {
        dqa = new DemoQAPageObjects(driver);
        dqa.buttons().click();
        log.info("Buttons is clicked");
    }

    @And("^User double clicks, right clicks and clicks on buttons$")
    public void userDoubleClicksRightClicksAndClicksOnButtons() {
        Actions a1 = new Actions(driver);
        a1.doubleClick(dqa.doubleClickButton()).build().perform();
        log.info("Double Click done");

        Actions a2 = new Actions(driver);
        a2.contextClick(dqa.rightClickButton()).build().perform();
        log.info("Right Click done");

        dqa.clickButton().click();
        log.info("Click done");
    }

    @Then("^Verify Clicks are done correctly$")
    public void verifyClicksAreDoneCorrectly() {
        Assert.assertTrue(dqa.doubleClickMessage().getText().contains("double click"));
        log.info("Double Click message verified");

        Assert.assertTrue(dqa.rightClickMessage().getText().contains("right click"));
        log.info("Right Click message verified");

        Assert.assertTrue(dqa.dynamicClickMessage().getText().contains("dynamic click"));
        log.info("Dynamic Click message verified");
    }

    @When("^User clicks on Links$")
    public void userClicksOnLinks() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        dqa = new DemoQAPageObjects(driver);
        dqa.links().click();
        log.info("Links is clicked");
    }

    @And("^User clicks on all the links that will send API call$")
    public void userClicksOnAllTheLinksThatWillSendAPICall() throws InterruptedException {
        dqa.createdLink().click();
        log.info("Created Link is clicked");
        Thread.sleep(2000);
        createdLinkMessage = dqa.linkResponseMessage().getText();

        dqa.noContentLink().click();
        log.info("No Content Link is clicked");
        Thread.sleep(2000);
        noContentLinkMessage = dqa.linkResponseMessage().getText();

        dqa.movedLink().click();
        log.info("Moved Link is clicked");
        Thread.sleep(2000);
        movedLinkMessage = dqa.linkResponseMessage().getText();

        dqa.badRequestLink().click();
        log.info("Bad Request Link is clicked");
        Thread.sleep(2000);
        badRequestLinkMessage = dqa.linkResponseMessage().getText();

        dqa.unauthorizedLink().click();
        log.info("Unauthorized Link is clicked");
        Thread.sleep(2000);
        unauthorizedLinkMessage = dqa.linkResponseMessage().getText();

        dqa.forbiddenLink().click();
        log.info("Forbidden Link is clicked");
        Thread.sleep(2000);
        forbiddenLinkMessage = dqa.linkResponseMessage().getText();

        dqa.notFoundLink().click();
        log.info("Not Found Link is clicked");
        Thread.sleep(2000);
        notFoundLinkMessage = dqa.linkResponseMessage().getText();

    }

    @Then("^Verify correct call is being made$")
    public void verifyCorrectCallIsBeingMade() {
        Assert.assertTrue(createdLinkMessage.contains("201"));
        Assert.assertTrue(createdLinkMessage.contains("Created"));
        log.info("Create link message verified");

        Assert.assertTrue(noContentLinkMessage.contains("204"));
        Assert.assertTrue(noContentLinkMessage.contains("No Content"));
        log.info("No Content link message verified");

        Assert.assertTrue(movedLinkMessage.contains("301"));
        Assert.assertTrue(movedLinkMessage.contains("Moved Permanently"));
        log.info("Moved link message verified");

        Assert.assertTrue(badRequestLinkMessage.contains("400"));
        Assert.assertTrue(badRequestLinkMessage.contains("Bad Request"));
        log.info("Bad Request link message verified");

        Assert.assertTrue(unauthorizedLinkMessage.contains("401"));
        Assert.assertTrue(unauthorizedLinkMessage.contains("Unauthorized"));
        log.info("Unauthorized link message verified");

        Assert.assertTrue(forbiddenLinkMessage.contains("403"));
        Assert.assertTrue(forbiddenLinkMessage.contains("Forbidden"));
        log.info("Forbidden link message verified");

        Assert.assertTrue(notFoundLinkMessage.contains("404"));
        Assert.assertTrue(notFoundLinkMessage.contains("Not Found"));
        log.info("Not Found link message verified");
    }

    @And("^User clicks on all the links that will open new tab$")
    public void userClicksOnAllTheLinksThatWillOpenNewTab() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)");
        dqa.homeLink().click();

        Set<String> ids = driver.getWindowHandles();

        Iterator<String> id = ids.iterator();
        String pId = id.next();
        String cId = id.next();

        driver.switchTo().window(cId);
        title1 = driver.getTitle();

        driver.switchTo().window(pId);
        dqa.homeHkWJsLink().click();

        ids = driver.getWindowHandles();
        id = ids.iterator();
        pId = id.next();
        cId = id.next();
        String nId = id.next();
        driver.switchTo().window(nId);
        title2 = driver.getTitle();

    }

    @Then("^Verify title of the new tabs$")
    public void verifyTitleOfTheNewTabs() {
        Assert.assertTrue(title1.equals("ToolsQA"));
        log.info("Title Verified for 1st Link");
        Assert.assertTrue(title2.equals("ToolsQA"));
        log.info("Title Verified for 2nd Link");
    }

    @When("^User clicks on Upload and Download$")
    public void userClicksOnUploadAndDownload() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        dqa = new DemoQAPageObjects(driver);
        dqa.uploadAndDownload().click();
        log.info("Upload and Download link is clicked");
    }

    @And("^User clicks on Download link$")
    public void userClicksOnDownloadLink() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-300)");

        dqa.downloadLink().click();
        log.info("Download link is clicked");
        Thread.sleep(5000);
    }

    @Then("^Verify file is downloaded$")
    public void verifyFileIsDownloaded() {
        File f  = new File(System.getProperty("user.dir") + "//sampleFile.jpeg");

        Assert.assertTrue(f.exists());
        log.info("File downloaded successfully");
        if (f.delete()) {
            System.out.println("File Deleted");
        }
    }

    @And("^User clicks on Choose File link and selects file to be uploaded$")
    public void userClicksOnChooseFileLinkAndSelectsFileToBeUploaded() throws InterruptedException, IOException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-200)");

        Thread.sleep(3000);
        js.executeScript("document.getElementById('uploadFile').click()");

        //dqa.chooseFile().click();
        log.info("Choose File button is clicked");
        Thread.sleep(3000);

        Runtime.getRuntime().exec("C://Selenium WebDriver with Java//fileuploadAutoIT.exe");
        log.info("Auto IT script run successfully and file is uploaded");
        Thread.sleep(2000);
    }

    @Then("^Verify file is uploaded successfully$")
    public void verifyFileIsUploadedSuccessfully() {
        Assert.assertEquals(dqa.uploadedFilePath().getText(),"C:\\fakepath\\sampleFile.jpeg");
        log.info("Uploaded file verified successfully");
    }
}
