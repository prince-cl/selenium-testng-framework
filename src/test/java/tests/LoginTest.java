package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import utils.ExcelReader;
import retry.RetryAnalyzer;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return ExcelReader.getData("LoginData");
    }

    @Test(dataProvider = "loginData", retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest(String username, String password) {

        LoginPage lp = new LoginPage();
        lp.login(username, password);

        Assert.assertTrue(
            lp.isLoginSuccessful(),
            "Login failed for: " + username
        );
    }
}
