package WorkFlows;              //Represents regular routine tasks and operations that the system does: Creating / removing users,
                                // new tasks etc. - Inherits from CommonOps

import Extensions.Web.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

import static Utilities.HelperMethods.getDataFromXML;

public class WebFlows extends CommonOps {

    @Step("Sign in to Basecamp")
    public static void signIn(String userEmail, String userPassword) {
        if (basecampUpperMenu.listOfUpperMenuItems.size() == 6) {
            signOut();
            UiActions.click(basecampIntroPage.signIn_btn);
        } else {
            driver.get(getDataFromXML("URL"));
            UiActions.click(basecampIntroPage.signIn_btn);
            if (basecampUpperMenu.listOfUpperMenuItems.size() == 6) {
                signOut();
                UiActions.click(basecampIntroPage.signIn_btn);
            }
        }
        UiActions.insertKeysAndClick(basecampSignInPage.userIdentifierInput_Field, userEmail, basecampSignInPage.next_btn);
        UiActions.insertKeysAndClick(basecampSignInPage.userPasswordInput_Field, userPassword, basecampSignInPage.login_btn);
    }

    @Step("Sign out from Basecamp")
    public static void signOut() {
        UiActions.click(basecampMainPage.homePage_btn);
        UiActions.click(basecampMainPage.avatarIcon_btn);
        UiActions.click(basecampAvatarMenu.logOut_btn);
        driver.get(getDataFromXML("URL"));
    }
}
