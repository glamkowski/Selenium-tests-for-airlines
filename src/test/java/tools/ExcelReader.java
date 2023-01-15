package tools;

import io.netty.util.concurrent.SingleThreadEventExecutor;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

    public static void main(String[] args) throws IOException {
        getDataFromExcel();
    }

    public static void getDataFromExcel () throws IOException {

        File file = new File("src/test/resources/dane.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

        FileInputStream fileInputStream = new FileInputStream(file);

        Workbook workbook = new HSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheetAt(0);

        Row row = sheet.getRow(1);

        Integer countRows = sheet.getLastRowNum();
        short countColumns = row.getLastCellNum();
        DataFormatter formatter = new DataFormatter();

        Cell cell = row.getCell(2);
        String j_username = formatter.formatCellValue(cell);
        System.out.println(j_username);

        for (int i = 0; i <= countRows; i++) {
            System.out.println(formatter.formatCellValue(row.getCell(0)));
            System.out.println(formatter.formatCellValue(row.getCell(1)));
            System.out.println(formatter.formatCellValue(row.getCell(2)));
        }
    }


}
