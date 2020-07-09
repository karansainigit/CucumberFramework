package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MobileBrowserPageObjects {

    public AndroidDriver<AndroidElement> driver;

    public MobileBrowserPageObjects(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.android.chrome:id/url_bar")
    private AndroidElement enterURL;

    public AndroidElement enterURL() {
        return enterURL;
    }

    @FindBy(xpath = "//span[@data-cy='close']")
    private List<WebElement> popUp;

    public List<WebElement> popUp() {
        return popUp;
    }

    @FindBy(xpath = "//span[@data-cy='close']")
    private WebElement closePopUp;

    public WebElement closePopUp() {
        return closePopUp;
    }

    @FindBy(xpath = "//li[@data-cy='oneWayTrip']")
    private WebElement oneWay;

    public WebElement oneWay() {
        return oneWay;
    }

    @FindBy(xpath = "//div[@data-cy='fromClick']")
    private WebElement fromCity;

    public WebElement fromCity() {
        return fromCity;
    }

    @FindBy(xpath = "//input[@placeholder='Enter Departure City']")
    private WebElement enterFromCity;

    public WebElement enterFromCity() {
        return enterFromCity;
    }

    @FindBy(xpath = "//div[@data-cy='toClick']")
    private WebElement toCity;

    public WebElement toCity() {
        return toCity;
    }

    @FindBy(xpath = "//input[@placeholder='Enter Destination City']")
    private WebElement enterToCity;

    public WebElement enterToCity() {
        return enterToCity;
    }

    @FindBy(xpath = "//span[@data-cy='departureMonthAndYear']")
    private WebElement departureDate;

    public WebElement departureDate() {
        return departureDate;
    }
}
