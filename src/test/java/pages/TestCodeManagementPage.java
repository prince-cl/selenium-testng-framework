package pages;

import org.openqa.selenium.By;
import utils.WaitUtil;

public class TestCodeManagementPage extends BasePage {

    public TestCodeManagementPage() {
        super();
    }

    private By pageHeader =
            By.xpath("//a[@role='tab']");

    private By createButton =
            By.xpath("//button[contains(text(),'Create')]");

    private By dataGrid =
            By.cssSelector("table");

    public boolean isPageLoaded() {
        return WaitUtil.waitForVisible(pageHeader).isDisplayed();
    }

    public boolean isCreateButtonVisible() {
        return WaitUtil.waitForVisible(createButton).isDisplayed();
    }

    public boolean isGridLoaded() {
        return WaitUtil.waitForVisible(dataGrid).isDisplayed();
    }
}
