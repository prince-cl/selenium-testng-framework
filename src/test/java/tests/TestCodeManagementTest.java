package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseTest;
import pages.TestCodeManagementPage;

public class TestCodeManagementTest extends BaseTest {

    @Test
    public void verifyTestCodeManagementPageLoads() {
        TestCodeManagementPage page =
                homePage.goToTestCodeManagement();

        Assert.assertTrue(
                page.isPageLoaded(),
                "Test Code Management page did not load"
        );
    }
}
