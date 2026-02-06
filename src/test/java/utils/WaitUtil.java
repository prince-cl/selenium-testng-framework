package utils;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.*;

public class WaitUtil {

    public static WebElement waitForVisible(By locator) {
        return new WebDriverWait(
                DriverFactory.getDriver(),
                Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
