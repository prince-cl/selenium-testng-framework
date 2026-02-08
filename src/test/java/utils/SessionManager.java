package utils;

import pages.HomePage;
import pages.LoginPage;

public class SessionManager {

    private static boolean loggedIn = false;
    private static HomePage homePage;

    public static HomePage loginOnce(String user, String pass) {
        if (!loggedIn) {
            LoginPage loginPage = new LoginPage();
            homePage = loginPage.login(user, pass);
            loggedIn = true;
        }
        return homePage;
    }
}
