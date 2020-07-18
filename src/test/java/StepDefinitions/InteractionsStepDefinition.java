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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

@RunWith(Cucumber.class)
public class InteractionsStepDefinition extends Base {

    public WebDriver driver;
    public WebDriverWait expWait;
    public static Logger log = (Logger) LogManager.getLogger(DemoQAStepDefinition.class.getName());

    public DemoQAPageObjects dqa;

    @Before("@Interactions")
    public void initializeBrowser() throws IOException {
        driver = initializeDriver();
        log.info("Driver is initialized");
    }

    @After("@Interactions")
    public void tearDown(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            // Take a screenshot...
            String screen = getScreenshotWeb(driver,scenario.getName());
            Reporter.addScreenCaptureFromPath(screen);
        }
        driver.quit();
        log.info("Browser closed");
    }

    @Given("^User go to \"([^\"]*)\" website$")
    public void userGoToWebsite(String url) throws Throwable {
        driver.get(url);
        log.info("Interactions URL opened");
    }

    @When("^User clicks on Droppable$")
    public void userClicksOnDroppable() throws Throwable {
        dqa = new DemoQAPageObjects(driver);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        int i = 1;
        while(i > 0)
        {
            try {
                dqa.droppable().click();
            } catch (Exception e) {
                js.executeScript("window.scrollBy(0,400)");
                log.info("Droppable not present on page, scrolling page to find it");
            }
            if(dqa.droppable().isDisplayed()) {
                dqa.droppable().click();
                log.info("If Droppable found clicking on it");
                break;
            }
        }
    }

    @And("^User performs simple drag and drop$")
    public void userPerformsSimpleDragAndDrop() throws Throwable {
        Actions act = new Actions(driver);

        act.dragAndDrop(dqa.simpleDraggable(),dqa.simpleDropHere()).build().perform();
        log.info("Simple Drag and Drop performed");
    }

    @Then("^Drag and Drop should be performed successfully$")
    public void dragAndDropShouldBePerformedSuccessfully() throws Throwable {
        Assert.assertEquals(dqa.verifySimpleDragAndDrop().getText(),"Dropped!");
        log.info("Simple Drag and Drop verified");
    }

    @And("^User drag and drop Acceptable drag box$")
    public void userDragAndDropAcceptableDragBox() {
        dqa.clickAccept().click();
        log.info("User click on Accept");

        Actions act = new Actions(driver);

        act.dragAndDrop(dqa.acceptableDraggable(),dqa.acceptableDropHere()).build().perform();
        log.info("Acceptable Drag and Drop performed");
    }

    @Then("^Acceptable Drag and Drop should be performed successfully$")
    public void acceptableDragAndDropShouldBePerformedSuccessfully() {
        Assert.assertEquals(dqa.verifyAcceptableDragAndDrop().getText(),"Dropped!");
        log.info("Acceptable Drag and Drop verified");
    }

    @And("^User drag and drop Not Acceptable drag box$")
    public void userDragAndDropNotAcceptableDragBox() {
        dqa.clickAccept().click();
        log.info("User click on Accept");

        Actions act = new Actions(driver);

        act.dragAndDrop(dqa.notAcceptableDraggable(),dqa.acceptableDropHere()).build().perform();
        log.info("Not Acceptable Drag and Drop performed");
    }

    @Then("^Verify Not Acceptable drag and drop$")
    public void verifyNotAcceptableDragAndDrop() {
        Assert.assertEquals(dqa.verifyAcceptableDragAndDrop().getText(),"Drop here");
        log.info("Acceptable Drag and Drop verified");
    }

    @When("^User clicks on Sortable$")
    public void userClicksOnSortable() {
        dqa = new DemoQAPageObjects(driver);

        scrollingPageForElement(driver, dqa.sortable());

        dqa.sortable().click();
    }

    @Then("^User verifies that elements in the list are sorted$")
    public void userVerifiesThatElementsInTheListAreSorted() {
        ArrayList<String> originalList = new ArrayList<String>();
        ArrayList<String> expectedList = new ArrayList<String>();
        expectedList.add("One");
        expectedList.add("Two");
        expectedList.add("Three");
        expectedList.add("Four");
        expectedList.add("Five");
        expectedList.add("Six");

        for(int i = 0; i < dqa.verticalList().size(); i++) {
            originalList.add(dqa.verticalList().get(i).getText());
        }

        Assert.assertEquals(originalList,expectedList);
        log.info("List verified");
    }

    @When("^User clicks on Selectable$")
    public void userClicksOnSelectable() {
        dqa = new DemoQAPageObjects(driver);

        scrollingPageForElement(driver, dqa.selectable());

        dqa.selectable().click();
    }

    @And("^User Selects from the list$")
    public void userSelectsFromTheList() {
        dqa.select2nd().click();
        log.info("2nd element selected");
        dqa.select4th().click();
        log.info("4th element selected");
    }

    @Then("^Selected should be highlighted$")
    public void selectedShouldBeHighlighted() {
        Assert.assertTrue(dqa.select2nd().getAttribute("class").contains("active"));
        log.info("Verified that 2nd element is selected");
        Assert.assertTrue(dqa.select4th().getAttribute("class").contains("active"));
        log.info("Verified that 4th element is selected");
    }

    @When("^User clicks on Resizable$")
    public void userClicksOnResizable() {
        dqa = new DemoQAPageObjects(driver);

        scrollingPageForElement(driver, dqa.resizable());

        dqa.resizable().click();
    }

    @And("^User resize the box$")
    public void userResizeTheBox() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertEquals(dqa.resizableBox().getAttribute("style"),"width: 200px; height: 200px;");
        log.info("Resizable box size verified at the starting");

        int x = dqa.restrictedArea().getLocation().getX();
        int y = dqa.restrictedArea().getLocation().getY();

        Actions act = new Actions(driver);
        act.dragAndDropBy(dqa.resizeBox(),x,y).build().perform();
    }

    @Then("^Verify box is resized$")
    public void verifyBoxIsResized() {
        Assert.assertTrue(dqa.resizableBox().getAttribute("style").equals("width: 500px; height: 300px;"));
        log.info("Resizable box size verified after resizing");
    }
}
