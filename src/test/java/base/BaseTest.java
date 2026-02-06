package base;

import config.ConfigLoader;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.DriverFactory;
import utils.LoggerUtil;

public class BaseTest {

    protected Logger log = LoggerUtil.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        log.info("========== Test Started ==========");
        log.info("Launching browser");
        DriverFactory.initDriver();

        String url = ConfigLoader.get("url");
        log.info("Navigating to URL: " + url);
        DriverFactory.getDriver().get(url);
    }

    @AfterMethod
    public void tearDown() {
        log.info("Closing browser");
        DriverFactory.quitDriver();
        log.info("========== Test Finished ==========");
    }
}
