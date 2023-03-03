package utils;

import globalConstants.FilePaths;
import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import propertyManagement.ProjectProperties;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Iterator;


import static globalConstants.FilePaths.filePath;


public class ExcelUtil {

    private static final String[] citReportExcelHeader = {
            "BUILD_ID",
            "Lead-Name",
            "Test-Framework-IP",
            "Test-Framework-Name",
            "Test-Framework-SVN-Path",
            "Test-Execution-Date-Time",
            "Product-Interface",
            "Unique-TestCase-ID",
            "Test-Case-Description",
            "Test-Status",
            "INFO1",
            "INFO2",
            "Module Name",
            "Test Type"
    };


    Workbook workbook = null;
    Sheet sheet = null;
    Cell cell = null;
    FileOutputStream fileOut = null;
    FileInputStream inputStream=null;
    OPCPackage pkg=null;

    public ExcelUtil(String fileName)  {
        try{
            File file = new File(filePath+fileName);
            System.out.println(file);
            inputStream = new FileInputStream(file);
            String fileExtensionName = fileName.substring(fileName.indexOf("."));
            if(fileExtensionName.equals(".xlsx")){
                pkg = OPCPackage.open(inputStream);
                workbook = new XSSFWorkbook(pkg);
            }
            else if(fileExtensionName.equals(".xls")){
                workbook = new HSSFWorkbook(inputStream);
            }
        }
        catch(Exception e){}
    }

    public ExcelUtil setSheet(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return this;
    }

    public int getRowCount() {
        return sheet.getLastRowNum();
    }

    public static int getExcelLastRow(String fileName, int... index) throws IOException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
        int sheetId = (index.length > 0) ? index[0] : 0;
        InputStream inp = null;
        try {
            int val = 0;
            inp = new FileInputStream(fileName);
            Workbook wb = WorkbookFactory.create(inp);
            Sheet sheet = wb.getSheetAt(sheetId);
            int maxRowNo = sheet.getLastRowNum();
            val = maxRowNo;
            return val + 1;

        } catch (InvalidFormatException ex) {
            return 0;
        } catch (IOException ex) {
            return 0;
        } finally {
            inp.close();
        }
    }

    public String getCellData(int rowNum,int cellNum){
        Row  row = sheet.getRow(rowNum);
        Cell cell=row.getCell(cellNum);
        DataFormatter dataFormatter = new DataFormatter();
        return dataFormatter.formatCellValue(cell);
    }


    private static final Logger logger = LoggerFactory.getLogger(utils.ExcelUtil.class);
    /**
     * write CIT report excel header
     */
    public static void writeCITReportFileHeader() throws IOException {
        writeHeader(FilePaths.CIT_REPORT_OUTPUT_FILE, citReportExcelHeader);
    }
    private static InputStream createExcel(InputStream inputStream, String filename) throws IOException {

        try {
            inputStream = new FileInputStream(filename);

        } catch (java.io.FileNotFoundException ex) {
            // Create Blank workbook
            XSSFWorkbook workbook = new XSSFWorkbook();
            // Create file system using specific name
            FileOutputStream out = new FileOutputStream(new File(filename));

            workbook.createSheet("new sheet");
            // write operation workbook using file out object
            workbook.write(out);
            out.close();

            inputStream = new FileInputStream(filename);
            //logger.info("File Opened " + filename);
        }
        return inputStream;
    }

    public static void WriteDataToExcel(String filename, int rowt, int cellt, String textt, int... index) throws IOException {
        int sheetId = (index.length > 0) ? index[0] : 0;
        InputStream inpx = null;
        FileOutputStream fileOut = null;
        try {
            inpx = createExcel(inpx, filename);
            XSSFWorkbook wbx = new XSSFWorkbook(inpx);
            XSSFSheet sheet = wbx.getSheetAt(sheetId);
            XSSFCell cell;
            XSSFRow row = sheet.getRow(rowt);
            if (row == null) {
                //logger.info("Row is null");
                sheet.createRow(rowt);
                row = sheet.getRow(rowt);
                row.createCell(cellt);
                cell = row.getCell(cellt);
            } else {
                row.createCell(cellt);
                cell = row.getCell(cellt);
            }
            cell.setCellValue("" + textt);
            fileOut = new FileOutputStream(filename);
            wbx.write(fileOut);
        } catch (IOException ex) {
            logger.error("Error occurred in Excel Util....");
            ex.printStackTrace();
        } finally {
            if (inpx != null)
                inpx.close();

            if (fileOut != null)
                fileOut.close();
        }
    }


    public  void updateCellValue(String fileName,String sheetname,int rowNum,int cellNum,String data) throws IOException {
        setSheet(sheetname);
        Row  row = sheet.getRow(rowNum);
        Cell cell=row.getCell(cellNum);
        cell.setCellValue(data);
        fileOut=new FileOutputStream(filePath+fileName);
        workbook.write(fileOut);
        fileOut.flush();
        fileOut.close();
        System.out.println(filePath);
    }

    private static void writeHeader(String FilePaths, String[] headerList) throws IOException {
        logger.info("Writing file headers " + FilePaths);
        Path path = Paths.get(FilePaths);

        if (!Files.exists(path)) {
            logger.info("File does not exist: " + path);
            for (int i = 0; i < headerList.length; i++) {
                utils.ExcelUtil.WriteDataToExcel(FilePaths, 0, i, headerList[i]);
            }
        } else {
            logger.info("File already exist: " + path);
        }

    }

    public  Object[][] getRecord(String sheetname) {
        setSheet(sheetname);
        DataFormatter dataFormatter = new DataFormatter();
        int rowCount=getRowCount(),rowcounter=-1,fieldCounter=-1;
        Object[][] data=new Object[rowCount+1][6];
        Iterator<Row> itr = sheet.iterator();
        while (itr.hasNext()) {
            rowcounter++;
            Row row = itr.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                fieldCounter++;
                Cell cell = cellIterator.next();
                data[rowcounter][fieldCounter]=dataFormatter.formatCellValue(cell);
            }
            fieldCounter=-1;
        }
        return data;
    }

    public static Object saveExcelData(int row, int column)  {
        ExcelUtil excelUtil=new ExcelUtil(ProjectProperties.getProperty("wallet.excel.filename"));
        Object[][] records=  excelUtil.getRecord(ProjectProperties.getProperty("wallet.excel.sheetname"));
        return  records[row][column];
    }

}


