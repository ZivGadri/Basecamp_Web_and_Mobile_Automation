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

    @Step("Post Basecamp new project info to Basecamp Projects Table")
    public static void postProjectInfo() {
        try {
            statement = connection.createStatement();
            String dbop = "INSERT INTO `Basecamp_Projects`(`projectName`, `projectDescription`) VALUES ('"
                    + _projectName + "','" + _projectDescription + "');";
            statement.execute(dbop);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error while posting data");
        }
    }

    @Step("Post Basecamp new project info to Basecamp Projects Table")
    public static void deleteProjectInfo() {
        try {
            statement = connection.createStatement();
            String dbop = "DELETE FROM `Basecamp_Projects` WHERE projectName = '" + _projectName + "';";
            statement.execute(dbop);
            statement.close();
        } catch (Exception e) {
            System.out.println("Error while posting data");
        }
    }
}
