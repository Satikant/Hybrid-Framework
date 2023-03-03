package utils;

import globalConstants.FilePaths;
import globalConstants.NumberConstants;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import propertyManagement.CITReportProperties;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import reportManagement.HTMLParser;

import java.io.*;

import static globalConstants.FilePaths.CIT_REPORT_OUTPUT_FILE;
import static org.jsoup.nodes.Document.OutputSettings.Syntax.html;

/**
 * Created by navin.pramanik on 7/21/2017.
 *
 * @author navin.pramanik
 */
public class CITReport {

    public static String INPUTHTML_PATH;
    public static String CTDATEFORMAT_INTERNAL = "yyyy-MM-dd HH:mm:ss";
    private static String description = null;
    private static String uniqueID = null;
    private static CITReportProperties properties = CITReportProperties.getInstance();
    private String buildID, leadName, testFrameworkIP, testFrameworkName, testFrameworkSVNPath,
            testExecutionDateTime, productInterface, uniqueTestCaseID, testCaseDescription, testStatus,INFO1,INFO2, TestType;

    public CITReport() {

        this.leadName = CITReportProperties.getInstance().getProperty("LeadName");
        this.productInterface = CITReportProperties.getInstance().getProperty("ProductCIinterface");
        this.testFrameworkName = CITReportProperties.getInstance().getProperty("TestFrameworkName");
        this.testFrameworkIP = CITReportProperties.getInstance().getProperty("TestFrameworkIP");
        this.testFrameworkSVNPath = CITReportProperties.getInstance().getProperty("TestFrameworkSVNPath");
        this.testExecutionDateTime = DateUtil.getCurrentDateTime();
        this.buildID = CITReportProperties.getInstance().getProperty("BUILDID");
        this.INFO1 = MobileProperties.getProperty("project.name");
        this.INFO2 = MobileProperties.getProperty("language.code");

    }

    public CITReport(String inputHTMLPath) {
        this();
        this.INPUTHTML_PATH = inputHTMLPath;

    }

    public static void generateCTReport() throws IOException {

        File directory = new File(FilePaths.dirCITReport);

        if (!directory.exists()) {
            directory.mkdir();
        }
        ExcelUtil.writeCITReportFileHeader();

        Object[][] reporterObject = HTMLParser.generateReporterObject();

        ExcelWriter.writeTestCaseSheetNew(FilePaths.dirCITReport, "TestCases", reporterObject);
    }

   public static void main(String args[]) {

        try {
            String path = "C:\\Users\\ayush.singh\\Desktop\\Wallet_Framework\\walletproject\\reports\\htmlReports\\MobileApp14-01-2022-04-52-48.html";
            String fileName = "MobileApp19-12-2019-01-04-01.html";
           // CITReport CIT = new CITReport(ExtentManager.getExtentReportFileName());
            CITReport CIT = new CITReport(path);
            CIT.generateCTReport();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

   public static void readBuildID() throws Exception {
        String BuildIDPath = CITReportProperties.getInstance().getProperty("BuildIDPath");
        File fileName = new File(BuildIDPath);

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String line;
            String buildID = null;
            while ((line = br.readLine()) != null) {
                buildID = line.trim();
            }
            System.out.println("Build ID is -->" + buildID);
        } finally {
            br.close();
        }
    }

    public void setReportFilePath(String inputHTMLPath) {
        this.INPUTHTML_PATH = inputHTMLPath;
    }

    public String getTestStatus() {
        return this.testStatus;
    }

    public void setTestStatus(String status) {
        this.testStatus = status;
    }

    public String getLeadName() {
        return this.leadName;
    }

    public String getTestExecutionDateTime() {
        return this.testExecutionDateTime;
    }

    public String getTestFrameworkName() {
        return this.testFrameworkName;
    }

    public String getUniqueTestCaseID() {
        return this.uniqueTestCaseID;
    }

    public void setUniqueTestCaseID(String id) {
        this.uniqueTestCaseID = id;
    }

    public String getProductInterface() {
        return this.productInterface;
    }

    public String getTestFrameworkIP() {
        return this.testFrameworkIP;
    }

    public String getCountry() {
        return this.INFO1;
    }

    public String getLanguage() {
        return this.INFO2;
    }

    public String getBuildID() {
        return this.buildID;
    }

    public String getTestFrameworkSVNPath() {
        return this.testFrameworkSVNPath;
    }

    public String getTestCaseDescription() {
        return this.testCaseDescription;
    }

    public void setTestCaseDescription(String desc) {
        this.testCaseDescription = desc;
    }

    public void generateCITReport() throws IOException, InvalidFormatException {

        try {

            //For creating Directory if not already there
            File directory = new File(FilePaths.dirCITReport);

            if (!directory.exists()) {
                directory.mkdir();
            }
            //For CIT report Header
            ExcelUtil.writeCITReportFileHeader();


        } catch (FileNotFoundException fe) {
            System.out.println("File not Found ... ");
        } catch (IOException ioe) {
            System.out.println("IO Exception... ");
        }

    }


    public void writeDataToExcel() throws IOException, InvalidFormatException {
        int lastRow = ExcelUtil.getExcelLastRow(CIT_REPORT_OUTPUT_FILE);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_0, this.buildID);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_1, this.leadName);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_2, this.testFrameworkIP);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_3, this.testFrameworkName);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_4, this.testFrameworkSVNPath);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_5, this.testExecutionDateTime);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_6, this.productInterface);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_7, this.uniqueTestCaseID);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_8, this.testCaseDescription);
        ExcelUtil.WriteDataToExcel(CIT_REPORT_OUTPUT_FILE, lastRow, NumberConstants.CONST_9, this.testStatus);
    }


}
