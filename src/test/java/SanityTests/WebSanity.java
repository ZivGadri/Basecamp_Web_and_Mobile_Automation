package SanityTests;

import Extensions.Verifications.Verifications;
import Utilities.CommonOps;
import WorkFlows.WebFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.HelperMethods.getDataFromXML;

@Listeners(Utilities.Listeners.class)
public class WebSanity extends CommonOps {

    @Test(description = "Login Sanity Test", priority = 2, enabled = true)
    @Description("Test description: Logging in with a user")
    public void testLogin() {
        WebFlows.signIn(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        Verifications.verifyTextInElement(basecampMainPage.pageTitle_txt, "Your Projects");
    }
}
