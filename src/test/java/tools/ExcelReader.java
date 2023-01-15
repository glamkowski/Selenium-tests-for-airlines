package tools;

import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static String[][] getDataFromExcel() throws IOException {

        File file = new File("src/test/resources/excel_data.xls");

        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = new HSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(1);

        Integer countRows = sheet.getLastRowNum();

        short countColumns = row.getLastCellNum();

        DataFormatter formatter = new DataFormatter();

        String[][] dataFromExcel = new String[countRows][countColumns];


        for (int i = 1; i <= countRows; i++) {
            for (int j = 0; j < countColumns; j++) {
                dataFromExcel[i - 1][j] = formatter.formatCellValue(sheet.getRow(i).getCell(j));
            }
        }

        return dataFromExcel;

    }

}
