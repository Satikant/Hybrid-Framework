package tests.wallet.ahliBank;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.ahliBank.features.CustomerLoginAhliBank;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;
import utils.Utils;

import java.io.IOException;

public class LoginTestAhliBank extends TestInit {
    CustomerLoginAhliBank customerLogin=new CustomerLoginAhliBank();
    LoginPageAhliBank loginPage=new LoginPageAhliBank();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() throws JSchException, InterruptedException
    {
        customerLogin.acceptAlert();
    }

    @Test(priority=1)
    public void TC0001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_001"));
        customerLogin.login("",GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_Login_001"));
        }

    @Test(priority=2)
    public void TC0002(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_002"));
        customerLogin.login(GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_002"));
    }

    @Test(priority=3)
    public void TC0003(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_003"));
        customerLogin.login(GenerateRandomValue.getRandomIntValue(6),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_001"));
    }

    @Test(priority=4)
    public void TC0004() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_004"));
        customerLogin.login(DataDriven.getUserByStatus("Y"),"");
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_005"));
    }

    @Test(priority=5)
    public void TC0005() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_005"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_003"));
    }

    @Test(priority=6)
    public void TC0006() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_006"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_003"));
    }

    @Test(priority=7)
    public void TC0007() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_007"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_004"));
    }

    @Test(priority=8)
    public void TC0008() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_008"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_006"));
    }

    @Test(priority=9)
    public void TC0009() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_009"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_006"));
    }

    @Test(priority=10)
    public void TC0010() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_010"));
        customerLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_006"));
    }

    @Test(priority=11)
    public void TC0011() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_011"));
        customerLogin.login(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(3));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_005"));
    }

    @Test(priority=12)
    public void TC0012() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_012"));
        customerLogin.login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_008"));
    }

    @Test(priority=13)
    public void TC0013() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_013"));
        customerLogin.login(DataDriven.getUserByStatus("S"),DataDriven.getUserPinByStatus("S"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_007"));
    }

   // @Test(priority=14)
    public void TC0014() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_014"));
        customerLogin.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_002"));
    }

    @Test(priority=15)
    public void TC0015(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_015"));
        customerLogin.login(GenerateRandomValue.getRandomIntValueWithPrefix(6,"33"),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_002"));
    }

    @Test(priority=16)
    public void TC0016() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_Login_016"));
        customerLogin.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        //customerLogin.HorizontalScroll();
    }
}
