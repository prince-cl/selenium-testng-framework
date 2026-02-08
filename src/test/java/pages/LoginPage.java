package pages;

import org.openqa.selenium.By;
import utils.WaitUtil;

public class LoginPage extends BasePage {

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");

    // Element visible only after successful login
    private By activeCasesTab = By.id("ActiveCases-tab");

    public HomePage login(String user, String pass) {
        WaitUtil.waitForVisible(username).sendKeys(user);
        WaitUtil.waitForVisible(password).sendKeys(pass);
        WaitUtil.waitForClickable(loginBtn).click();

        return new HomePage();
    }

    // ✅ THIS METHOD FIXES YOUR ERROR
    public boolean isLoginSuccessful() {
        try {
            return WaitUtil.waitForVisible(activeCasesTab).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
