package WorkFlows;              //Represents regular routine tasks and operations that the system does: Creating / removing users,
                                // new tasks etc. - Inherits from CommonOps

import Extensions.DataBase.DbActions;
import Extensions.Web.UiActions;
import Utilities.CommonOps;
import Utilities.HelperMethods;
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

    @Step("Sign up to Basecamp")
    public static void signUp(String name, String email, String password, String companyName) throws InterruptedException {

        if (basecampUpperMenu.listOfUpperMenuItems.size() == 6) {
            signOut();
        } else {
            driver.get(getDataFromXML("URL"));
            UiActions.click(basecampIntroPage.tryItFree_btn);
            UiActions.insertKeys(basecampSignUpFlow.name_Field, name);
            Thread.sleep(1500);
            UiActions.insertKeysAndClick(basecampSignUpFlow.email_Field, email, basecampSignUpFlow.nextButtonFirst_btn);
            Thread.sleep(1500);
            UiActions.insertKeysAndClick(basecampSignUpFlow.password_Field, password, basecampSignUpFlow.createMyAccount_btn);
            Thread.sleep(1500);
            UiActions.insertKeysAndClick(basecampSignUpFlow.companyName_Field, companyName, basecampSignUpFlow.nextButtonSecond_btn);
            Thread.sleep(1500);
            UiActions.click(basecampSignUpFlow.nextButtonThird_btn);
            Thread.sleep(1500);
            UiActions.click(basecampSignUpFlow.nextButtonForth_btn);
            Thread.sleep(1500);
            UiActions.click(basecampSignUpFlow.allDone_btn);
            DbActions.postCredentials();
            Thread.sleep(1500);
            basecampSignUpFlow.noThanks_btn.click();
        }
    }

    @Step("Add new project")
    public static void addNewProject(String projectName, String description) throws InterruptedException {
        if (basecampUpperMenu.listOfUpperMenuItems.size() == 6) {
            UiActions.click(basecampUpperMenu.home_btn);
        } else {
            driver.get(getDataFromXML("URL"));
            signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        }
        _numberOfProjectsBeforeAddingOrRemoving = HelperMethods.numberOfProjectsNow();
        if (_numberOfProjectsBeforeAddingOrRemoving == 3) {
            System.out.println("Cannot Add Anymore Projects Under This App Package");
        } else {
            UiActions.click(basecampMainPage.homePage_btn);
            _projectName = projectName;
            _projectDescription = description;
            UiActions.click(basecampMainPage.addAnotherProject_btn);
            UiActions.insertKeys(basecampNewProjectFlow.nameThisProject_field, projectName);
            UiActions.insertKeysAndClick(basecampNewProjectFlow.addDescription_box, description,
                    basecampNewProjectFlow.createThisProject_btn);
            DbActions.postProjectInfo();
            Thread.sleep(2000);
            UiActions.click(basecampUpperMenu.home_btn);
            Thread.sleep(2000);
        }
    }
}
