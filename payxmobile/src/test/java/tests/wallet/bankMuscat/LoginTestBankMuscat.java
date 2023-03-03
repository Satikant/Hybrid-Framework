package tests.wallet.bankMuscat;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.bankMuscat.features.CustomerLoginBankMuscat;
import framework.wallet.bankMuscat.pageObjects.LoginPageBankMuscat;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;
import java.io.IOException;


public class LoginTestBankMuscat extends TestInit {
    CustomerLoginBankMuscat customerLogin=new CustomerLoginBankMuscat();
    LoginPageBankMuscat loginPage=new LoginPageBankMuscat();

   @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() throws JSchException, InterruptedException
   {
       new CustomerLoginBankMuscat().acceptAlert();
   }


    @Test(priority=1)
    public void TC0001() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0001"));
        startNegativeTest();
        customerLogin.doLogin(GenerateRandomValue.getRandomIntValue(0), DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority=2)
    public void TC0002() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0002"));
        startNegativeTest();
        customerLogin.doLogin(GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"), DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_002"));
    }

    @Test(priority=3)
    public void TC0003() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0003"));
        startNegativeTest();
        customerLogin.doLogin(GenerateRandomValue.getRandomIntValue(6), DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_003"));
   }

    @Test(priority=4)
    public void TC0004() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0004"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("Y"), "     ");
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_004"));
    }

    @Test(priority=5)
    public void TC0005() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0005"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"), GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_005"));
    }

    @Test(priority=6)
    public void TC0006() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0006"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_006"));

    }

    @Test(priority=7)
    public void TC0007() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0007"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_007"));

    }

    @Test(priority=8)
    public void TC0008() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0008"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_008"));

    }

    @Test(priority=9)
    public void TC0009() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0009"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_009"));

    }

    @Test(priority=10)
    public void TC00010() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0010"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("B"),DataDriven.getUserPinByStatus("B"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_0010"));

    }

    @Test(priority=11)
    public void TC00011() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0011"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("Y"), "258  ");
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_0011"));
    }

    @Test(priority=12)
    public void TC00012() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0012"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("BL"), DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_0012"));
    }

    @Test(priority=13)
    public void TC00013() throws IOException, InterruptedException, JSchException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0013"));
        startNegativeTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("S"), DataDriven.getUserPinByStatus("S"));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_0013"));
    }

    //  @Test(priority=14)
    public void TC00014() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0013"));
        startNegativeTest();
        customerLogin.doLogin("77123478", "14709");
    }

    @Test(priority=15)
    public void TC00015() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0015"));
        startNegativeTest();
        customerLogin.doLogin(GenerateRandomValue.getRandomIntValueWithPrefix(7,"7"), GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(loginPage.getMessageFromDevice(), MessageReader.getMessage("ERRMSG_0015"));
    }

    @Test(priority=16)
    public void TC00016() throws IOException, JSchException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0016"));
        startPositveTest();
        customerLogin.doLogin(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
        }

}
