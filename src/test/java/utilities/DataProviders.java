package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {
    @DataProvider (name = "LoginData")
    public String [][] gteData () throws Exception {
        String path = ".\\testData\\Opencart_LoginData.xlsx";
        ExcelUtility xlutil = new ExcelUtility(path);
        int rowCount = xlutil.getRowCount("Sheet1");
        int colCount = xlutil.getCellCount("Sheet1", 1);
        String loginData[][] = new String[rowCount][colCount];
        for (int i = 1; i <= rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
            }
        }
        return loginData;
    }
}
