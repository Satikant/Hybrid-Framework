package tests.wallet.palestineArabBank;

import common.Assertion;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import framework.wallet.palestineArabBank.features.CustomerLoginPalestine;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

public class LoginTestPalestine extends TestInit {

    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();
        LoginPagePalestine loginPage=new LoginPagePalestine();


        @AfterMethod(alwaysRun = true)
        public void acceptTheAlert()
        {
            customerLogin.acceptAlert();
        }


    @Test(priority=1)
    public void TC_ABP_001() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_001"));
        customerLogin.Login("", GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getMsgFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority=2)
    public void TC_ABP_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_002"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(7,"00"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_002"));
    }

    @Test(priority=3)
    public void TC_ABP_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_003"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValue(6),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_003"));
    }

    @Test(priority=4)
    public void TC_ABP_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_004"));
        customerLogin.Login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_008"));
    }

    @Test(priority=5)
    public void TC_ABP_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_005"));
        customerLogin.Login(DataDriven.getUserByStatus("S"),DataDriven.getUserPinByStatus("S"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0068"));
    }

    @Test(priority=6)
    public void TC_ABP_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_006"));
        customerLogin.Login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_008"));
    }

    @Test(priority=7)
    public void TC_ABP_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_007"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValueWithPrefix(5,"9876"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0010"));
    }

    @Test(priority=8)
    public void TC_ABP_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_008"));
        Config.isClearFieldTrue = true;
        customerLogin.Login(GenerateRandomValue.getRandomIntValue(9), "    ");
        Config.setClearFieldFalse();
        Assertion.verifyEqual(loginPage.getMsgFromDevice(),MessageReader.getMessage("ERRMSG_004"));
    }

    @Test(priority=9)
    public void TC_ABP_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_009"));
        customerLogin.Login(GenerateRandomValue.getRandomIntValue(9),GenerateRandomValue.getRandomIntValue(3));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_007"));
    }

    @Test(priority=10)
    public void TC_ABP_010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_010"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_005"));
    }

    @Test(priority=11)
    public void TC_ABP_011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_011"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_005"));
    }

    @Test(priority=12)
    public void TC_ABP_012()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_012"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_006"));
    }

    @Test(priority=13)
    public void TC_ABP_013()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_013"));
        customerLogin.Login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_006"));
    }


    @Test(priority=14)
    public void TC_ABP_014() {
        Config.PositiveloginCase=true;
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ABP_014"));
        startPositveTest();
        customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
    }
}
