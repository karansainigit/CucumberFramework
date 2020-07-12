package Resources;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    AndroidDriver<AndroidElement> androiddriver;
    public Properties prop;

    public WebDriver initializeDriver() throws IOException {
        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Resources//Data.properties");

        prop.load(fis);

        String browserName = prop.getProperty("browser");

        if(browserName.contains("chrome")) {
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "//src//main//java//Resources//chromedriver.exe");

            HashMap<String,Object> chromePrefs = new HashMap<String,Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
            DesiredCapabilities dc = DesiredCapabilities.chrome();
            dc.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true);
            dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            ChromeOptions options = new ChromeOptions();
            options.merge(dc);
            options.setExperimentalOption("prefs",chromePrefs);

            if (browserName.contains("headless")) {
                options.addArguments("headless");
            }
            driver = new ChromeDriver(options);
        }
        else if (browserName.contains("firefox")) {
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "//src//main//java//Resources//gecko.exe");
            driver = new FirefoxDriver();
        }
        else if (browserName.contains("IE")) {
            System.setProperty("webdriver.ie.driver",System.getProperty("user.dir") + "//src//main//java//Resources//IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public AndroidDriver<AndroidElement> initializeAndroid() throws IOException {

        prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//Resources//Data.properties");

        prop.load(fis);

        String mobilePlatform = prop.getProperty("mobile");

        DesiredCapabilities cap = new DesiredCapabilities();

        if (mobilePlatform.contains("android")) {
            File f = new File("src");
            File fs = new File(f, "ApiDemos-debug.apk");

            cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
            cap.setCapability(MobileCapabilityType.DEVICE_NAME, "PIXEL 2 API R");
            cap.setCapability(MobileCapabilityType.APP, fs.getAbsolutePath());
            cap.setCapability(MobileCapabilityType.NO_RESET, "true");

            androiddriver = new AndroidDriver<AndroidElement>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        }
        androiddriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return androiddriver;
    }

    public void getScreenshotWeb(WebDriver driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\logs\\webscreen.png";
        FileUtils.copyFile(src, new File(destinationFile));
    }

    public void getScreenshotAndroid(AndroidDriver<AndroidElement> driver) throws IOException {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir") + "\\logs\\androidscreen.png";
        FileUtils.copyFile(src, new File(destinationFile));
    }

    public WebDriverWait explicitWait(WebDriver driver, int timeInSeconds) {
        WebDriverWait expWait = new WebDriverWait(driver,timeInSeconds);
        return expWait;
    }
}
