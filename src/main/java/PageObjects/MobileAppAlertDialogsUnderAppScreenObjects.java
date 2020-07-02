package PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class MobileAppAlertDialogsUnderAppScreenObjects {

    public AndroidDriver<AndroidElement> driver;

    public MobileAppAlertDialogsUnderAppScreenObjects(AndroidDriver<AndroidElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/radio_button")
    private AndroidElement singleChoiceList;

    public AndroidElement singleChoiceList() {
        return singleChoiceList;
    }

    @AndroidFindBy(xpath = "//android.widget.CheckedTextView[@text='Traffic']")
    private AndroidElement sclTraffic;

    public AndroidElement sclTraffic() {
        return sclTraffic;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement sclOK;

    public AndroidElement sclOK() {
        return sclOK;
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/two_buttons2ultra")
    private AndroidElement ultraLongMessage;

    public AndroidElement ultraLongMessage() {
        return ultraLongMessage;
    }

    @AndroidFindBy(id = "android:id/message")
    private AndroidElement ultraLongMessageText;

    public AndroidElement ultraLongMessageText() {
        return ultraLongMessageText;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement ulmOK;

    public AndroidElement ulmOK() {
        return ulmOK;
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/text_entry_button")
    private AndroidElement textEntryDialog;

    public AndroidElement textEntryDialog() {
        return textEntryDialog;
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/username_edit")
    private AndroidElement tedName;

    public AndroidElement tedName() {
        return tedName;
    }

    @AndroidFindBy(id = "io.appium.android.apis:id/password_edit")
    private AndroidElement tedPassword;

    public AndroidElement tedPassword() {
        return tedPassword;
    }

    @AndroidFindBy(xpath = "//android.widget.Button[@text='OK']")
    private AndroidElement tedOK;

    public AndroidElement tedOK() {
        return tedOK;
    }
}
