package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileAppHomeScreenObjects {

    public AndroidDriver<AndroidElement> driver;

    public MobileAppHomeScreenObjects(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Animation']")
    private AndroidElement animation;

    public MobileAppAnimationScreenObjects animation() {
        animation.click();
        return new MobileAppAnimationScreenObjects(driver);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='App']")
    private AndroidElement app;

    public MobileAppAppScreenObjects app() {
        app.click();
        return new MobileAppAppScreenObjects(driver);
    }
}
