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
import org.openqa.selenium.Keys;
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
        js.executeScript("window.scrollBy(0,350)");

        dqa = new DemoQAPageObjects(driver);
        dqa.links().click();
        log.info("Links is clicked");
        js.executeScript("window.scrollBy(0,50)");
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

    @When("^User clicks on Dynamic Properties$")
    public void userClicksOnDynamicProperties() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,400)");

        dqa = new DemoQAPageObjects(driver);
        dqa.dynamicProperties().click();
        log.info("Dynamic Properties link is clicked");
    }

    @Then("^Verify the dynamic properties of the elements$")
    public void verifyTheDynamicPropertiesOfTheElements() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-400)");

        Assert.assertFalse(dqa.firstButton().isEnabled());
        log.info("First button is not enabled");
        Assert.assertTrue(dqa.secondButton().getAttribute("class").equals("mt-4 btn btn-primary"));
        log.info("Second button color is not changed");

        Thread.sleep(6000);
        log.info("After 5 seconds");

        Assert.assertTrue(dqa.firstButton().isEnabled());
        log.info("First button is not enabled");
        Assert.assertTrue(dqa.secondButton().getAttribute("class").contains("danger"));
        log.info("Second button color is changed");
        Assert.assertTrue(dqa.thirdButton().isDisplayed());
        log.info("Third button is displayed");
    }

    @When("^User clicks on Practice Form$")
    public void userClicksOnPracticeForm() {
        dqa = new DemoQAPageObjects(driver);
        dqa.practiceForm().click();
        log.info("Practice Form link clicked");
    }

    @And("^User fills the Practice Form$")
    public void userFillsThePracticeForm() throws InterruptedException, IOException {
        dqa.firstName().sendKeys("Test");
        log.info("First Name entered");

        dqa.lastName().sendKeys("User");
        log.info("Last Name entered");

        dqa.userEmail().sendKeys("testuser@gmail.com");
        log.info("Email entered");

        dqa.maleGender().click();
        log.info("Male gender selected");

        dqa.userNumber().sendKeys("1234567890");
        log.info("Mobile Number entered");

        dqa.dateOfBirth().click();
        dqa.monthOfDOB().selectByVisibleText("March");
        dqa.yearOfDOB().selectByValue("1991");
        dqa.dateOfDOB().click();
        log.info("Date of Birth entered");

        dqa.subjects().sendKeys("Eng");
        dqa.subjects().sendKeys(Keys.ENTER);
        dqa.subjects().sendKeys("Math");
        dqa.subjects().sendKeys(Keys.ENTER);
        dqa.subjects().sendKeys("Computer");
        dqa.subjects().sendKeys(Keys.ENTER);
        log.info("Subjects entered");

        dqa.hobbyOne().click();
        dqa.hobbyThree().click();
        log.info("Hobbies selected");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('uploadPicture').click()");

        Thread.sleep(2000);

        Runtime.getRuntime().exec("C://Selenium WebDriver with Java//fileuploadAutoIT.exe");
        log.info("Auto IT script run successfully and file is uploaded");
        Thread.sleep(2000);

        js.executeScript("window.scrollBy(0,300)");

        dqa.formCurrentAddress().sendKeys("123 Main St, NY");
        log.info("Current Address Entered");

        dqa.selectState().click();
        dqa.enterState().sendKeys("Har");
        dqa.enterState().sendKeys(Keys.ENTER);
        log.info("State Selected");

        dqa.selectCity().click();
        dqa.enterCity().sendKeys("Pan");
        dqa.enterCity().sendKeys(Keys.ENTER);
        log.info("City Selected");
    }

    @And("^Clicks on Submit button$")
    public void clicksOnSubmitButton() throws InterruptedException {
        dqa.submitForm().click();
        log.info("Form submitted");
        Thread.sleep(2000);
    }

    @Then("^Verify form is successfully submitted$")
    public void verifyFormIsSuccessfullySubmitted() {
        Assert.assertTrue(dqa.successfulSubmit().getText().equals("Thanks for submitting the form"));
        log.info("Submission successful");

        dqa.closeSubmit().click();
        log.info("Submission dialog closed");
    }

    @When("^User clicks on Browser Windows$")
    public void userClicksOnBrowserWindows() {
        dqa = new DemoQAPageObjects(driver);
        dqa.browserWindows().click();
        log.info("Browser Windows clicked");
    }

    @And("^User clicks on New Tab and verify the text$")
    public void userClicksOnNewTabAndVerifyTheText() {
        dqa.newTab().click();
        log.info("New Tab clicked");

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> id = ids.iterator();
        String pid = id.next();
        String newTab = id.next();

        driver.switchTo().window(newTab);
        Assert.assertTrue(dqa.newTabHeading().getText().equals("This is a sample page"));
        log.info("Heading of new tab verified");
        driver.close();

        driver.switchTo().window(pid);
    }

    @And("^User clicks on New Window and verify the text$")
    public void userClicksOnNewWindowAndVerifyTheText() {
        dqa.newWindow().click();
        log.info("New Window clicked");

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> id = ids.iterator();
        String pid = id.next();
        String newWindow = id.next();

        driver.switchTo().window(newWindow);
        Assert.assertTrue(dqa.newWindowHeading().getText().equals("This is a sample page"));
        log.info("Heading of new window verified");
        driver.close();

        driver.switchTo().window(pid);
    }

    @And("^User clicks on New Window Message and verify the message$")
    public void userClicksOnNewWindowMessageAndVerifyTheMessage() {
        dqa.newWindowMessage().click();
        log.info("New Window Message is clicked");

        Set<String> ids = driver.getWindowHandles();
        Iterator<String> id = ids.iterator();
        String pid = id.next();
        String newWindowMessage = id.next();

        driver.switchTo().window(newWindowMessage);
        driver.close();

        driver.switchTo().window(pid);
    }

    @When("^User clicks on Alerts$")
    public void userClicksOnAlerts() {
        dqa = new DemoQAPageObjects(driver);
        dqa.alerts().click();
        log.info("Alerts clicked");
    }

    @And("^User clicks on First Alert and verify the text$")
    public void userClicksOnFirstAlertAndVerifyTheText() {
        dqa.firstAlert().click();
        log.info("First Alert clicked");

        Assert.assertTrue(driver.switchTo().alert().getText().equals("You clicked a button"));
        log.info("First Alert text verified");
        driver.switchTo().alert().accept();
        log.info("First Alert closed");
    }

    @And("^User clicks on Second Alert and verify the text$")
    public void userClicksOnSecondAlertAndVerifyTheText() throws InterruptedException {
        dqa.secondAlert().click();
        log.info("Second Alert clicked");

        Thread.sleep(5000);
        Assert.assertTrue(driver.switchTo().alert().getText().equals("This alert appeared after 5 seconds"));
        log.info("Second Alert text verified");
        driver.switchTo().alert().accept();
        log.info("Second Alert closed");
    }

    @And("^User clicks on Third Alert and verify the text$")
    public void userClicksOnThirdAlertAndVerifyTheText() {
        dqa.thirdAlert().click();
        log.info("Third Alert clicked");

        driver.switchTo().alert().accept();
        log.info("Third Alert OK");

        Assert.assertTrue(dqa.thirdAlertResult().getText().contains("Ok"));
        log.info("Third Alert Result verified after OK");

        dqa.thirdAlert().click();
        log.info("Third Alert clicked");

        driver.switchTo().alert().dismiss();
        log.info("Third Alert Cancel");

        Assert.assertTrue(dqa.thirdAlertResult().getText().contains("Cancel"));
        log.info("Third Alert Result verified after Cancel");
    }

    @And("^User clicks on Fourth Alert and verify the text$")
    public void userClicksOnFourthAlertAndVerifyTheText() {
        dqa.fourthAlert().click();
        log.info("Fourth Alert clicked");

        driver.switchTo().alert().sendKeys("Test");
        driver.switchTo().alert().accept();

        Assert.assertTrue(dqa.fourthAlertResult().getText().contains("Test"));
        log.info("Fourth Alert Result verified");
    }

    @When("^User clicks on Frames$")
    public void userClicksOnFrames() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        dqa = new DemoQAPageObjects(driver);
        dqa.frames().click();
        log.info("Frames clicked");
    }

    @Then("^User verifies sample text in each frame$")
    public void userVerifiesSampleTextInEachFrame() {
        driver.switchTo().frame(dqa.frame1());
        log.info("Switched to frame 1");

        Assert.assertTrue(dqa.frame1heading().getText().equals("This is a sample page"));
        log.info("Frame 1 heading verified");

        driver.switchTo().defaultContent();

        driver.switchTo().frame(dqa.frame2());
        log.info("Switched to frame 2");

        Assert.assertTrue(dqa.frame2heading().getText().equals("This is a sample page"));
        log.info("Frame 2 heading verified");

        driver.switchTo().defaultContent();
    }

    @When("^User clicks on Modal Dialogs$")
    public void userClicksOnModalDialogs() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        dqa = new DemoQAPageObjects(driver);
        dqa.modalDialogs().click();
        log.info("Modal Dialogs clicked");
    }

    @And("^User clicks on Small Modal and verify the text$")
    public void userClicksOnSmallModalAndVerifyTheText() throws InterruptedException {
        dqa.smallModal().click();
        log.info("Small Modal clicked");
        Thread.sleep(2000);

        Assert.assertTrue(dqa.smallModalText().getText().equals("Small Modal"));
        log.info("Small Modal text verified");

        dqa.closeSmallModal().click();
        log.info("Small Modal closed");
        Thread.sleep(2000);
    }

    @And("^User clicks on Large Modal and verify the text$")
    public void userClicksOnLargeModalAndVerifyTheText() throws InterruptedException {
        dqa.largeModal().click();
        log.info("Large Modal clicked");
        Thread.sleep(2000);

        Assert.assertTrue(dqa.largeModalText().getText().equals("Large Modal"));
        log.info("Large Modal text verified");

        dqa.closeLargeModal().click();
        log.info("Large Modal closed");
    }

    @When("^User clicks on Accordian$")
    public void userClicksOnAccordian() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)");

        dqa = new DemoQAPageObjects(driver);
        dqa.accordian().click();
        log.info("Accordian clicked");
        Thread.sleep(2000);
    }

    @And("^User clicks any tab$")
    public void userClicksAnyTab() throws InterruptedException {
        dqa.accordianHeading().click();
        log.info("Accordian heading clicked");
        Thread.sleep(2000);
    }

    @Then("^Appropriate text should be displayed$")
    public void appropriateTextShouldBeDisplayed() {
        Assert.assertTrue(dqa.accordianContent().getAttribute("class").contains("show"));
        log.info("Accordian content showed and verified");
    }
}
