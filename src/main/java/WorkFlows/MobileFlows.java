package WorkFlows;              //Represents regular routine tasks and operations that the system does: Creating / removing users,
                                // new tasks etc. - Inherits from CommonOps

import Extensions.Mobile.UiActions;
import Utilities.CommonOps;
import io.qameta.allure.Step;

public class MobileFlows extends CommonOps {

    @Step("Login to Application")
    public static void login(String userEmail, String password) throws InterruptedException {
        UiActions.click(mobileBasecampLoginPage.loginToBasecamp_btn);
        UiActions.insertKeysAndClick(mobileBasecampLoginPage.loginEmail_field, userEmail, mobileBasecampLoginPage.next1_btn);
        Thread.sleep(2000);
        UiActions.insertKeysAndClick(mobileBasecampLoginPage.password_field, password, mobileBasecampLoginPage.next2_btn);
    }
}
