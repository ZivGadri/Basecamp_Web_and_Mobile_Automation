package Utilities;              //A class that will define an object for each page/section class of the app and initialize the
                                // objects we define in each and every one. Inherits from Base class

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base{

    public static void initWeb() {
        basecampIntroPage = PageFactory.initElements(driver, PageObjects.Web.IntroPage.class);
        basecampMainPage = PageFactory.initElements(driver, PageObjects.Web.MainPage.class);
        basecampSignInPage = PageFactory.initElements(driver, PageObjects.Web.SignInPage.class);
        basecampProjectMainPage = PageFactory.initElements(driver, PageObjects.Web.ProjectMainPage.class);
        basecampUpperMenu = PageFactory.initElements(driver, PageObjects.Web.UpperMenuBar.class);
        basecampEditProjectDetailsPage = PageFactory.initElements(driver, PageObjects.Web.EditProjectDetails.class);
        basecampGetHelpIframe = PageFactory.initElements(driver, PageObjects.Web.GetHelpIframe.class);
        basecampUpperMenuFindWindowPage = PageFactory.initElements(driver, PageObjects.Web.UpperMenuFindWindow.class);
        basecampSignUpFlow = PageFactory.initElements(driver, PageObjects.Web.SignUpFlow.class);
        basecampNewProjectFlow = PageFactory.initElements(driver, PageObjects.Web.NewProjectFlow.class);
        basecampRemoveAProjectFlow = PageFactory.initElements(driver, PageObjects.Web.RemoveAProjectFlow.class);
        basecampAvatarMenu = PageFactory.initElements(driver, PageObjects.Web.AvatarMenu.class);
        basecampEditProfilePage = PageFactory.initElements(driver, PageObjects.Web.EditProfilePage.class);
    }

    public static void initMobile() {
        mobileBasecampLoginPage = PageFactory.initElements(driver, PageObjects.Mobile.LoginPage.class);
        mobileBottomMenu = PageFactory.initElements(driver, PageObjects.Mobile.BottomMenu.class);
        mobileMyStuffPage = PageFactory.initElements(driver, PageObjects.Mobile.MyStuffPage.class);
    }
}
