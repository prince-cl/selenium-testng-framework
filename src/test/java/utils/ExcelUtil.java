package utils;

import org.apache.poi.ss.usermodel.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelUtil {

    private static Workbook workbook;

    static {
        try {
            InputStream is = ExcelUtil.class
                    .getClassLoader()
                    .getResourceAsStream("TestData.xlsx");

            if (is == null) {
                throw new RuntimeException("❌ TestData.xlsx not found in resources");
            }

            workbook = WorkbookFactory.create(is);

        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to load Excel file", e);
        }
    }

    public static Map<String, String> getRowData(String sheetName) {

        Sheet sheet = workbook.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException(
                "❌ Sheet '" + sheetName + "' not found in TestData.xlsx"
            );
        }

        Row header = sheet.getRow(0);
        Row data = sheet.getRow(1);

        Map<String, String> rowData = new HashMap<>();

        for (int i = 0; i < header.getLastCellNum(); i++) {
            rowData.put(
                header.getCell(i).getStringCellValue(),
                data.getCell(i).getStringCellValue()
            );
        }

        return rowData;
    }
}
