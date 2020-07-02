package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileAppAppScreenObjects {

    public AndroidDriver<AndroidElement> driver;

    public MobileAppAppScreenObjects(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Alert Dialogs']")
    private AndroidElement alertDialogs;

    public MobileAppAlertDialogsUnderAppScreenObjects alertDialogs() {
        alertDialogs.click();
        return new MobileAppAlertDialogsUnderAppScreenObjects(driver);
    }

}
