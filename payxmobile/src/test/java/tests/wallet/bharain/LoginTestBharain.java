package tests.wallet.bharain;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.bharain.features.CustomerLoginBharain;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;


public class LoginTestBharain extends TestInit {
    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    LoginPageBharain loginPage=new LoginPageBharain();


   @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()
   {
       customerLogin.acceptAlertOman();
   }

    @AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }


    @Test(priority=1)
    public void TC0001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
           customerLogin.Login(GenerateRandomValue.getRandomIntValue(0),DataDriven.getUserPinByStatus("Y"));
           Assertion.verifyEqual(loginPage.getMsgFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority=2)
    public void TC0002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0002"));
            customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_002"));
    }

    @Test(priority=3)
    public void TC0003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0003"));
            customerLogin.Login(GenerateRandomValue.getRandomIntValue(6),DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_003"));
   }

    @Test(priority=4)
    public void TC0004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0004"));
            customerLogin.Login(DataDriven.getUserByStatus("Y"), "");
            Assertion.verifyEqual(loginPage.getMsgFromDevice(), MessageReader.getMessage("ERRMSG_004"));
    }

    @Test(priority=5)
    public void TC0005()  {
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

    @Test(priority=11)
    public void TC0009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0011"));
            customerLogin.Login(DataDriven.getUserByStatus("Y"), "147");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_007"));
    }

    @Test(priority=12)
    public void TC00010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0012"));
        if(DataDriven.checkValueExistInExcel("BL")==null){
            /*walletAdminLogin.adminLogin("superadmin","Com@2468");
            blacklistManagement.AddToBlacklist();*/
        }
            customerLogin.Login(DataDriven.getUserByStatus("BL"), DataDriven.getUserPinByStatus("BL"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_008"));
    }

    @Test(priority=13)
    public void TC00011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0013"));
            customerLogin.Login(DataDriven.getUserByStatus("S"), "1470");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_009"));
    }

    //  @Test(priority=14)
    public void TC00012()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0014"));
        startNegativeTest();
      //  customerLogin.doLogin("77123478", "14709");
    }

    @Test(priority=15)
    public void TC00013() throws InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0015"));
            customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(7,"7"), GenerateRandomValue.getRandomIntValue(4));
            Assertion.verifyEqual(loginPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0010"));
    }

    @Test(priority=16)
    public void TC00014() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0016"));
        startPositveTest();
        customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));

    }

   /* @Test
    public void TC0100() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0100"));
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0035"));
            loginPage.clickOnsnackbarButton();
            loginPage.clickonback();
    }

    @Test
    public void TC0101() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0101"));
        System.out.print(FilePaths.filePath);
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0035"));
            loginPage.clickOnsnackbarButton();
            loginPage.clickonback();
    }

    @Test
    public void TC0102() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0102"));
        System.out.print(FilePaths.filePath);
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0035"));
            loginPage.clickOnsnackbarButton();
            loginPage.clickonback();
    }

    @Test
    public void TC0103() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0103"));
        System.out.print(FilePaths.filePath);
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0084"));
            loginPage.clickOnsnackbarButton();
            loginPage.clickonback();
    }

    @Test
    public void TC0104() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0104"));
        System.out.print(FilePaths.filePath);
        startPositveTest();
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0085"));
            loginPage.clickOnsnackbarButton();
            loginPage.clickonback();
    }

    @Test
    public void TC0105() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0105"));
        System.out.print(FilePaths.filePath);
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
    }*/



}
