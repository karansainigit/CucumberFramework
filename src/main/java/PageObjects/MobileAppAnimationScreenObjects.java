package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileAppAnimationScreenObjects {

    public AndroidDriver<AndroidElement> driver;

    public MobileAppAnimationScreenObjects(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Bouncing Balls']")
    private AndroidElement bouncingBalls;

    public AndroidElement bouncingBalls() {
        return bouncingBalls;
    }
}
