package base;

import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import config.ConfigLoader;
import pages.HomePage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.LoggerUtil;
import utils.TestDataProvider;

public class BaseTest {

    protected static HomePage homePage;
    protected Logger log = LoggerUtil.getLogger(this.getClass());

    @BeforeSuite
    public void beforeSuite() {

        log.info("========== Test Suite Started ==========");

        // 1️⃣ Load login data from Excel
        TestDataProvider.loadLoginData();

        // 2️⃣ Launch browser
        DriverFactory.initDriver();
        DriverFactory.getDriver().manage().window().maximize();

        // 3️⃣ Navigate to application (REAL URL)
        String url = ConfigLoader.get("url");
        DriverFactory.getDriver().get(url);

        // 4️⃣ Login ONCE
        LoginPage loginPage = new LoginPage();
        homePage = loginPage.login(
                TestDataProvider.getUsername(),
                TestDataProvider.getPassword()
        );

        log.info("Login successful – session reused for all tests");
    }

    @AfterSuite
    public void afterSuite() {

        log.info("========== Test Suite Finished ==========");
        DriverFactory.quitDriver();
    }
}
