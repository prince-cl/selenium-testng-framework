package pages;

import org.openqa.selenium.By;
import utils.WaitUtil;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    // Dashboard element (only visible after login)
    private By activeCasesTab = By.id("ActiveCases-tab");

    public void login(String user, String pass) {
        WaitUtil.waitForVisible(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public boolean isLoginSuccessful() {
        return WaitUtil.waitForVisible(activeCasesTab).isDisplayed();
    }
}

