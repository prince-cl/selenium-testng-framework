package pages;

import org.openqa.selenium.By;
import utils.WaitUtil;

public class HomePage extends BasePage {

    // Menu item for Test Code Management
    private By testCodeManagementMenu =
            By.xpath("//i[@id='iTestCodeMgmt']");

    // Submenu item for Test Code Management
    private By testCodeManagementSubmenu =
            By.xpath("//a[@id='aAssayTemp']");

    // Home page identifier
    private By activeCasesTab =
            By.id("ActiveCases-tab");

    public boolean isHomePageLoaded() {
        return WaitUtil.waitForVisible(activeCasesTab).isDisplayed();
    }

    public TestCodeManagementPage goToTestCodeManagement() {
        WaitUtil.waitForClickable(testCodeManagementMenu).click();
        WaitUtil.waitForClickable(testCodeManagementSubmenu).click();
        return new TestCodeManagementPage();
    }
}
