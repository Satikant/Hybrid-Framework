package reportManagement;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import globalConstants.FilePaths;
import propertyManagement.ExecutionProperties;
import utils.DateUtil;

import java.util.HashMap;
import java.util.Map;

public class ExtentManager {

    private static ExtentReports extent;
    private static ExtentSparkReporter htmlReporter;
    private static String extentReportFileName = null;
    public static Map extentMap = new HashMap();
   // public static ExtentKlovReporter klov ;


    public static ExtentReports getInstance(){
        if(extent != null){
            return extent;
        }
        return createInstance();
    }

    public static String getExtentReportFileName(){
        return extentReportFileName;
    }


    private static ExtentReports createInstance(){
        String fileName = "MobileApp"+ DateUtil.getCurrentDateAndTimeForReport()+".html";
        extentReportFileName = FilePaths.EXTENT_REPORT_PATH + fileName;
        htmlReporter = new ExtentSparkReporter(extentReportFileName);
        /*klov = new ExtentKlovReporter("MyProject").initWithDefaultSettings();*/
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Mobile App Report");
        //htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName("Wallet Report");
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setAnalysisStrategy(AnalysisStrategy.SUITE);

        extent.setSystemInfo("Environment", ExecutionProperties.getProperty("environment"));
        extent.setSystemInfo("Product",ExecutionProperties.getProperty("product"));
        extent.setSystemInfo("Customer",ExecutionProperties.getProperty("customer"));
        extent.setSystemInfo("Version",ExecutionProperties.getProperty("version"));

        extent.flush();

        return extent;
    }

    public static synchronized ExtentTest getTest(){
        return (ExtentTest)extentMap.get((int) Thread.currentThread().getId());
    }

    public static synchronized ExtentTest startTest(String testName, String desc){
        ExtentTest test = extent.createTest(testName,desc);
        extentMap.put((int) Thread.currentThread().getId(),test);
        return test;
    }

    public static synchronized ExtentTest startTest(ExtentTest test,String testName, String desc){
        ExtentTest t1 = test.createNode(testName,desc);
        extentMap.put((int) Thread.currentThread().getId(),t1);
        return t1;
    }

    public static synchronized ExtentTest startTestFromProperty(ExtentTest test,String keyValue){
        ExtentTest t1 = test.createNode(keyValue);
        extentMap.put((int) Thread.currentThread().getId(),t1);
        return t1;
    }

    public static synchronized ExtentTest startTestFromProperty(String keyValue){
        ExtentTest t1 = extent.createTest(keyValue);
        extentMap.put((int) Thread.currentThread().getId(),t1);
        return t1;
    }

    public static String getReportName(){
        return extentReportFileName;
    }
}
