package Utilities;              //A class that provide with all the routine operations and methods being used with every test run, mainly for initializing drivers and browsers,
                                // main logical TestNG annotations (Before / After class / Test), reading execution xml file parameters and initializing them. etc.
                                // Inherits from Base class

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static Utilities.HelperMethods.getDataFromXML;

public class CommonOps extends Base {

    public static void initBrowser() {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = initChromeDriver();
        } else if (browser.equalsIgnoreCase("ie")) {
            driver = initIEDriver();
        } else {
            throw new RuntimeException("Invalid Browser Name Selected.");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getDataFromXML("TimeOut")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getDataFromXML("TimeOut")));
        action = new Actions(driver);
    }

    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    public static void initMobile() {
        dc = new DesiredCapabilities();
        dc.setCapability("reportDirectory", reportDirectory);
        dc.setCapability("reportFormat", reportFormat);
        dc.setCapability("Mobile App Test", testName);
        dc.setCapability(MobileCapabilityType.PLATFORM_NAME, Platform.ANDROID);
        dc.setCapability(MobileCapabilityType.NO_RESET, false);
        dc.setCapability(MobileCapabilityType.UDID, getDataFromXML("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getDataFromXML("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getDataFromXML("APP_ACTIVITY"));
        dc.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 5000);
        try {
            androidDriver = new AndroidDriver(new URL(getDataFromXML("AppiumServerURL")), dc);
        } catch (Exception e) {
            System.out.println("Can not Connect to Appium Server, See Details: " + e);
        }
    }

    @BeforeClass
    @Parameters({"platformName", "siteTested", "browserName"})
    public void startSession(String platformName, String siteTested, String browserName) throws IOException {
        platform = platformName;
        webSite = siteTested;
        browser = browserName;
        if (platform.equalsIgnoreCase("web")) {
            initBrowser();
            ManagePages.initWeb();
        } else if (platform.equalsIgnoreCase("mobile")) {
            initMobile();
            ManagePages.initMobile();
        } else
            throw new RuntimeException("Given Platform Is Invalid.");
        ManageDB.initConnection(getDataFromXML("DBURL"), getDataFromXML("DBuser"), getDataFromXML("DBpassword"));
    }
}
