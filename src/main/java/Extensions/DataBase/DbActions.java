package Extensions.DataBase;

import Utilities.CommonOps;
import io.qameta.allure.Step;

public class DbActions extends CommonOps {

    @Step("Post Basecamp new user info to Basecamp Credentials Table")
    public static void postCredentials() {
        try {
            statement = connection.createStatement();
            String dbop = "INSERT INTO `Basecamp_Users`(`Name`, `Email`, `Password`, `Company`) VALUES ('"
                    + _userName + "','" + _userEmail + "','" + _password + "','" + _companyName + "');";
            statement.execute(dbop);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error while posting data");
        }
    }
}
