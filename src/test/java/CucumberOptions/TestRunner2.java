package CucumberOptions;

import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import java.io.File;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/Features/",
        glue="StepDefinitions",
        tags = {"@Demo"},
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"},
        monochrome = true)

public class TestRunner2 extends AbstractTestNGCucumberTests {
    @AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig(new File(System.getProperty("user.dir") + "//src//main//java//Resources//extent-config.xml"));
    }
}
