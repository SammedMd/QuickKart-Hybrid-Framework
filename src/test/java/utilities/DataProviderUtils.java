
package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "registerData")
    public static Object[][] getRegisterData() {
        return ExcelUtils.getExcelData("Register");
    }

    @DataProvider(name = "loginData")
    public static Object[][] getLoginData() {
        return ExcelUtils.getExcelData("Login");
    }
}
