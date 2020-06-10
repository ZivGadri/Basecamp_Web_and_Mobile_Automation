package SanityTests;

import Extensions.Verifications.Verifications;
import Utilities.CommonOps;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.HelperMethods.*;

@Listeners(Utilities.Listeners.class)
public class WebSanity extends CommonOps {

    @Test(description = "Login Sanity Test", priority = 2, enabled = true)
    @Description("Test description: Logging in with a user")
    public void testLogin() {
        WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        Verifications.verifyTextInElement(basecampMainPage.pageTitle_txt, "Your Projects");
    }

    @Test(description = "SignUp Sanity Test", priority = 1, enabled = true)
    @Description("Test description: Signing up a new user")
    public void testSignup() throws InterruptedException {
        WebFlows.signUp(returnRandomFullName(), randomEmailGenerator(), returnRandomPassword(), returnRandomCompanyName());
        Verifications.verifyTextInElement(basecampSignUpFlow.userNameTitle_txt, WebFlows._userName);
    }

}
