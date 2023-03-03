package initializers;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import common.MobileDriver;
import globalConstants.Config;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import reportManagement.ExtentManager;
import utils.CITReport;
import utils.DataDriven;
import utils.Utils;

import java.io.IOException;

public class TestInit {

    private static ExtentReports extent;
    protected static ExtentTest pNode;
    ThreadLocal parent = new ThreadLocal();

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        DataDriven dataDriven=new DataDriven();
        System.out.println("Before Suite Started");
        extent =  ExtentManager.getInstance();

    }

    @BeforeClass(alwaysRun = true)
    public void beforeClass() throws IOException {
        //To create parent Node in extent report

        pNode = extent.createTest(getClass().getSimpleName());
        parent.set(pNode);

    }

    @AfterClass
    public void afterClass(){
        extent.flush();
    }

    @AfterSuite
    public void afterSuite() throws IOException {
        extent.flush();
        CITReport report = new CITReport(ExtentManager.getExtentReportFileName());
        MobileDriver.stopAppiumServer();
        report.generateCTReport();
    }



    public static void startNegativeTest(){
        Config.isAssertionRequired = false;
    }

    public static void startPositveTest(){
        Config.FirstTimeLogin = true;
        Config.isAssertionRequired = true;
    }
}
