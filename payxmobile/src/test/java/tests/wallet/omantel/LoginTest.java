package tests.wallet.omantel;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.bankMuscat.features.ProfileDetailsFeature;
import framework.wallet.omantel.features.CustomerLogin;
import framework.wallet.omantel.pageObjects.LoginPage;
import globalConstants.FilePaths;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;


public class LoginTest extends TestInit {
    CustomerLogin customerLogin = new CustomerLogin();
    LoginPage loginPage=new LoginPage();


   @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() throws JSchException, InterruptedException
   {
       new CustomerLogin().acceptAlertOman();
   }


    @Test(priority=1)
    public void TC0001() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValue(0),DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(LoginPage.getMsgFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority=2)
    public void TC0002() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0002"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_002"));
    }

    @Test(priority=3)
    public void TC0003() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0003"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValue(6),DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_003"));
   }

    @Test(priority=4)
    public void TC0004() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0004"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"), "");
        Assertion.verifyEqual(loginPage.getMsgFromDevice(), MessageReader.getMessage("ERRMSG_004"));
    }

    @Test(priority=5)
    public void TC0005() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0005"));
        customerLogin.Login(DataDriven.getUserByStatus("B"),  GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_005"));
        
    }

    @Test(priority=6)
    public void TC0006() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0006"));
        customerLogin.Login(DataDriven.getUserByStatus("B"), GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_005"));
    }

    @Test(priority=7)
    public void TC0007() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0007"));
        customerLogin.Login(DataDriven.getUserByStatus("B"), GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_006"));
    }

    @Test(priority=8)
    public void TC0008() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0008"));
        customerLogin.Login(DataDriven.getUserByStatus("B"), DataDriven.getUserPinByStatus("B"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_006"));
    }

  //  @Test(priority=9)
    public void TC0009() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0009"));
            customerLogin.Login(DataDriven.getUserByStatus("B"), DataDriven.getUserPinByStatus("B"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_006"));
    }

  //  @Test(priority=10)
    public void TC00010() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0010"));
        customerLogin.Login(DataDriven.getUserByStatus("B"), DataDriven.getUserPinByStatus("B"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_006"));
    }

    @Test(priority=11)
    public void TC00011() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0011"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"), "147");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_007"));
    }

    @Test(priority=12)
    public void TC00012() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0012"));
       /* if(DataDriven.checkValueExistInExcel("BL")==null){
            walletAdminLogin.adminLogin("superadmin","Com@2468");
            blacklistManagement.AddToBlacklist();
        }*/
        customerLogin.Login(DataDriven.getUserByStatus("BL"), DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_008"));
    }

    @Test(priority=13)
    public void TC00013() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0013"));
        customerLogin.Login(DataDriven.getUserByStatus("S"), "1470");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_009"));
    }

    @Test(priority=15)
    public void TC00015() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0015"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(7,"7"), GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(LoginPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0010"));
    }

    @Test(priority=16)
    public void TC00016() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0016"));
        System.out.print(FilePaths.filePath);
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            ProfileDetailsFeature profileDetailsFeature=new ProfileDetailsFeature();
         //   profileDetailsFeature.logOut();
        
    }

}
