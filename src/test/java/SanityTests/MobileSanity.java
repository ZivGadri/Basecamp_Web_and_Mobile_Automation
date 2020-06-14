package SanityTests;

import Extensions.Verifications.Verifications;
import Utilities.CommonOps;
import WorkFlows.MobileFlows;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static Utilities.HelperMethods.getDataFromXML;

@Listeners(Utilities.Listeners.class)
public class MobileSanity extends CommonOps {

    @Test(description = "Mobile Login Sanity Test")
    @Description("Test description: Logging in with a user to mobile app")
    public void testLoginMobile() throws InterruptedException {
        MobileFlows.login(getDataFromXML("UserEmail"), getDataFromXML("Password"));
        Verifications.verifyTextInElement(basecampMainPage.pageTitle_txt, "Your Projects");
    }
}
