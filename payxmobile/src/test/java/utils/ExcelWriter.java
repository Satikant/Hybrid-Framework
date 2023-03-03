package utils;

import globalConstants.FilePaths;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static String ExcelSheetPath;
    public static XSSFSheet ExcelWSheet;
    public static XSSFWorkbook ExcelWBook;
    public static XSSFRow Row;
    public static XSSFCell Cell;


    public ExcelWriter() {
    }

    public static void setExcelFile(String Path, String SheetName) {
        try {
            FileInputStream ExcelFile = new FileInputStream(Path);
            ExcelSheetPath = Path;
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
            if (ExcelWSheet == null) {
                ExcelWSheet = ExcelWBook.createSheet(SheetName);
            }
        } catch (Exception var3) {
            System.out.println("Error performing setExcelFile():");
            var3.printStackTrace();
        }

    }

    public static void createHeader(String... Headers) {
        try {
            if (ExcelWSheet.getRow(0) == null) {
                ExcelWSheet.createRow(0);
                Row = ExcelWSheet.getRow(0);
            } else {
                Row = ExcelWSheet.getRow(0);
            }

            CellStyle style = ExcelWBook.createCellStyle();
            style.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
            style.setFillPattern(FillPatternType.forInt((short) 1));
            Font font = ExcelWBook.createFont();
            font.setColor(IndexedColors.WHITE.getIndex());
            style.setBorderBottom(BorderStyle.valueOf((short) 1));
            style.setBorderTop(BorderStyle.valueOf((short) 1));
            style.setBorderRight(BorderStyle.valueOf((short) 1));
            style.setBorderLeft(BorderStyle.valueOf((short) 1));
            style.setFont(font);

            for (int i = 0; i < Headers.length; ++i) {
                Cell = Row.getCell(i, MissingCellPolicy.RETURN_BLANK_AS_NULL);
                Cell = Row.createCell(i);
                Cell.setCellValue(Headers[i]);
                Cell.setCellStyle(style);
                ExcelWSheet.autoSizeColumn(i);
            }

            ExcelWSheet.createFreezePane(0, 1);
            FileOutputStream fileOut = new FileOutputStream(ExcelSheetPath);
            ExcelWBook.write(fileOut);
            fileOut.flush();
            fileOut.close();
        } catch (Exception var4) {
            var4.printStackTrace();
        }

    }

    public static void writeTestCaseSheetNew(String dirPath, String sheetName, Object[][] writetofile) throws IOException {

        String Path = FilePaths.CIT_REPORT_OUTPUT_FILE;
        File f = new File(Path);

        File directory = new File(FilePaths.dirCITReport);
        if (!directory.exists()) {
            directory.mkdir();
        }

        if (!f.exists()) {
            XSSFWorkbook workbook = new XSSFWorkbook();
            FileOutputStream out = new FileOutputStream(new File(Path));
            workbook.write(out);
            out.close();
            workbook.createSheet(sheetName);
            setExcelFile(Path, sheetName);
            createHeader(new String[]{"BUILD_ID", "Lead-Name", "Test-Framework-IP", "Test-Framework-Name", "Test-Framework-SVN-Path", "Test-Execution-Date-Time", "Product-Interface", "Unique-TestCase-ID", "Test-Case-Description", "Test-Status", "INFO1", "INFO2", "Module", "Test Case Type"});
        }

        File file = new File(Path);
        FileInputStream inputStream = new FileInputStream(file);
        Workbook workBookName = new XSSFWorkbook(inputStream);
        Sheet sheet = workBookName.getSheetAt(0);
        int rowCount = sheet.getLastRowNum();

        for (int i = 0; i < writetofile.length; ++i) {
            ++rowCount;
            Row newRow = sheet.createRow(rowCount);

            for (int j = 0; j < writetofile[0].length; ++j) {
                Cell cell = newRow.createCell(j);
                cell.setCellValue((String) writetofile[i][j]);
            }
        }

        inputStream.close();
        FileOutputStream outputStream = new FileOutputStream(file);
        workBookName.write(outputStream);
        outputStream.close();
        System.out.println("CT Report Generated Successfully");
    }

}
