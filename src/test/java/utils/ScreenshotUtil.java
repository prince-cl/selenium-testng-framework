package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;

public class ScreenshotUtil {

    public static String capture(String name) {
        try {
            String dir = System.getProperty("user.dir") + "/target/screenshots/";
            new File(dir).mkdirs();   // ensures folder exists

            File src = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            String path = dir + name + ".png";
            FileUtils.copyFile(src, new File(path));

            return path;   // ✅ ALWAYS valid path
        } catch (Exception e) {
            e.printStackTrace();
            return "";    // ✅ never return null
        }
    }
}
