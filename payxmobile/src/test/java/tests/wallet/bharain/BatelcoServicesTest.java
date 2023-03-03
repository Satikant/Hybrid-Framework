package tests.wallet.bharain;

import common.Assertion;
import framework.wallet.bharain.features.BatelcoServicesFeatureBharain;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;
import java.io.IOException;


public class BatelcoServicesTest extends TestInit {
    BatelcoServicesFeatureBharain batelcoServicesFeature=new BatelcoServicesFeatureBharain();
    LoginPageBharain loginPage=new LoginPageBharain();

   /* @AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }*/

    @AfterMethod(alwaysRun =true)
    public void acceptAlert()   {
        batelcoServicesFeature.acceptAlertBatelcoServices();
    }

    @Test(priority=220)
    public void TC00090()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_001"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("","","1",Constants.POSTPAID_METHOD);
    }

    @Test(priority=221)
    public void TC00091()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_002"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("23363039","","",Constants.POSTPAID_METHOD);
    }

    @Test(priority=222)
    public void TC00092()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_003"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("233630","","1",Constants.POSTPAID_METHOD);
    }

    @Test(priority=223)
    public void TC00093()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_004"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("29713355","","0",Constants.POSTPAID_METHOD);
    }

    @Test(priority=224)
    public void TC00094()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_005"));
        batelcoServicesFeature.doBillPay("29713355","","1",Constants.POSTPAID_METHOD);
       // Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0041"));
    }

   // @Test(priority=225)
    public void TC00095()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_006"));
        batelcoServicesFeature.doBillPay("00000000","","1",Constants.POSTPAID_METHOD);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0041"));
    }

    @Test(priority=226)
    public void TC00096()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_007"));
        Config.checkSufficientBalance=true;
        batelcoServicesFeature.doBillPay("29713355","830903747","501",Constants.POSTPAID_METHOD);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0042"));
    }

    @Test(priority=227)
    public void TC00097()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_008"));
        Config.isBillEnquiryReuired=true;
        batelcoServicesFeature.doBillPay("29713355","","",Constants.POSTPAID_METHOD);
    }

    @Test(priority=228)
    public void TC00098()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_009"));
        Config.isBillEnquiryReuired=true;
        batelcoServicesFeature.doBillPay("29713355","830903747","",Constants.POSTPAID_METHOD);
    }

    @Test(priority=229)
    public void TC00099()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_009"));
        Config.isBillEnquiryReuired=true;
        batelcoServicesFeature.doBillPay("29713355","830903747","1",Constants.POSTPAID_METHOD);
    }

    //------------------------FixedLine--------------------------------

    @Test(priority=230)
    public void TC00110()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_001"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("","","1", Constants.FIXED_LINE_METHOD);
    }

    @Test(priority=231)
    public void TC00111()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_002"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("23363039","","",Constants.FIXED_LINE_METHOD);
    }

    @Test(priority=232)
    public void TC00112()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_003"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("233630","","1",Constants.FIXED_LINE_METHOD);
    }

    @Test(priority=233)
    public void TC00113()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_004"));
        Config.toastCheck=true;
        batelcoServicesFeature.doBillPay("29713355","","0",Constants.FIXED_LINE_METHOD);
    }

    @Test(priority=234)
    public void TC00114()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_005"));
        batelcoServicesFeature.doBillPay("29713355","","1",Constants.FIXED_LINE_METHOD);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0041"));
    }

    @Test(priority=235)
    public void TC00115()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_006"));
        batelcoServicesFeature.doBillPay("00000000","","1",Constants.FIXED_LINE_METHOD);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0041"));
    }

    @Test(priority=236)
    public void TC00116()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_007"));
        batelcoServicesFeature.doBillPay("29713355","830903747","501",Constants.FIXED_LINE_METHOD);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0042"));
    }

    @Test(priority=237)
    public void TC00117()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_BS_Postaid_008"));
        Config.isBillEnquiryReuired=true;
        batelcoServicesFeature.doBillPay("29713355","","",Constants.FIXED_LINE_METHOD);
    }

    //@Test(priority=238)
    public void TC00118()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0090"));
        batelcoServicesFeature.doPrepaid("29713355");
    }

    //@Test(priority=239)
    public void TC000120()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0090"));
        batelcoServicesFeature.doBillPay("29713355","","1",Constants.FIXED_LINE_METHOD);
    }
}
