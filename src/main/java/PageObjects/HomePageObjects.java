package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {

    public WebDriver driver;

    public HomePageObjects(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//p[@class='welcome-msg']")
    private WebElement defaultWelcomeMessage;

    public WebElement defaultWelcomeMessage() {
        return defaultWelcomeMessage;
    }
}
