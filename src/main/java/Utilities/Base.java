package Utilities;
//A class meant for declaring objects being used commonly across the project, such as WebDriver, WebDriverWait, Actions, Screenshot, PageObjects, primitives and more.

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Base {

    //Drivers
    public static WebDriver driver = null;
    public static AndroidDriver androidDriver = null;
    public static RemoteWebDriver remoteWebDriver = null;

    //Helpers
    public static JavascriptExecutor js = (JavascriptExecutor) driver;
    public static WebDriverWait wait;
    public static Actions action;

    //Parameters Variables
    public static String platform;
    public static String webSite;
    public static String browser;

    //Variables containing data info that is fed to the DB while signing up a new user.
    public static String _userName;
    public static String _userEmail;
    public static String _password;
    public static String _companyName;

    //Mobile initiation variables
    public static DesiredCapabilities dc;
    public static String reportDirectory = "reports";
    public static String reportFormat = "xml";
    public static String testName = "Mobile App Test";

    //DB Connection
    public static Connection connection;
    public static Statement statement;
    public static ResultSet resultSet;

    //Page Objects Web
    public static PageObjects.Web.IntroPage basecampIntroPage;
    public static PageObjects.Web.MainPage basecampMainPage;
    public static PageObjects.Web.SignInPage basecampSignInPage;
    public static PageObjects.Web.ProjectMainPage basecampProjectMainPage;
    public static PageObjects.Web.UpperMenuBar basecampUpperMenu;
    public static PageObjects.Web.EditProjectDetails basecampEditProjectDetailsPage;
    public static PageObjects.Web.GetHelpIframe basecampGetHelpIframe;
    public static PageObjects.Web.UpperMenuFindWindow basecampUpperMenuFindWindowPage;
    public static PageObjects.Web.SignUpFlow basecampSignUpFlow;
    public static PageObjects.Web.NewProjectFlow basecampNewProjectFlow;
    public static PageObjects.Web.RemoveAProjectFlow basecampRemoveAProjectFlow;
    public static PageObjects.Web.AvatarMenu basecampAvatarMenu;
    public static PageObjects.Web.EditProfilePage basecampEditProfilePage;

    //Page Objects Mobile
    public static PageObjects.Mobile.LoginPage mobileBasecampLoginPage;
    public static PageObjects.Mobile.BottomMenu mobileBottomMenu;
    public static PageObjects.Mobile.MyStuffPage mobileMyStuffPage;
}
