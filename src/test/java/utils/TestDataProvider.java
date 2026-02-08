package utils;

import java.util.Map;

public class TestDataProvider {

    private static Map<String, String> loginData;

    public static void loadLoginData() {
        loginData = ExcelUtil.getRowData("LoginData");
    }

    public static String getUsername() {
        return loginData.get("username");
    }

    public static String getPassword() {
        return loginData.get("password");
    }
}
