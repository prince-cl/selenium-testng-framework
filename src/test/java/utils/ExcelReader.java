package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;

public class ExcelReader {

    public static Object[][] getData(String sheetName) {
        try {
            FileInputStream fis =
                    new FileInputStream("src/test/resources/TestData.xlsx");
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            int rows = sheet.getPhysicalNumberOfRows();
            int cols = sheet.getRow(0).getPhysicalNumberOfCells();

            Object[][] data = new Object[rows-1][cols];

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i-1][j] = sheet.getRow(i).getCell(j).toString();
                }
            }
            return data;

        } catch (Exception e) {
            return null;
        }
    }
}
