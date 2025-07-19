package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtils {

    @DataProvider(name = "registerData")
    public static Object[][] getRegisterData() {
        return ExcelUtils.getExcelData("Register");
    }

    // You can add more in future
    // @DataProvider(name = "loginData") ...
}
