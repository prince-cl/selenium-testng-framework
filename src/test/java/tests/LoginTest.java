package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import retry.RetryAnalyzer;
import utils.ExcelReader;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return ExcelReader.getData("LoginData");
    }

    @Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest(String username, String password) {
        LoginPage lp = new LoginPage();
        lp.login(username, password);

        // Replace with your real post-login validation
        Assert.assertTrue(lp.isLoginSuccessful(), "Login failed for: " + username);
    }
}
