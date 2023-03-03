package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.CustomerLoginAhliBank;
import framework.wallet.ahliBank.features.SendMoneyFeatureAhliBank;
import globalConstants.Config;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.*;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;
import java.rmi.MarshalException;

public class SendMoneyTestAhliBank extends TestInit {
    CustomerLoginAhliBank customerLogin=new CustomerLoginAhliBank();
    SendMoneyFeatureAhliBank sendMoneyAB= new SendMoneyFeatureAhliBank();

    public SendMoneyTestAhliBank() throws IOException {
    }


    @AfterMethod
    public void closeAlert() throws InterruptedException {
        sendMoneyAB.resetForTesting();
    }

    @Test(priority = 1)
    public void TC_SM_AH_001() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_001"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),Constants.DEFAULT_AMOUNT, Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_BillPay_021"));
    }

    @Test(priority = 2)
    public void TC_SM_AH_002() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_002"));
        Config.isTermsAndCondNonClickable=true;
        sendMoneyAB.performSendMoney("",GenerateRandomValue.getRandomAlphabeticValue(5), Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_Login_001"));

    }

    @Test(priority = 3)
    public void TC_SM_AH_003() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_004"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),"",Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_001"));
    }

    @Test(priority = 4)
    public void TC_SM_AH_004() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_004"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),"",Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(), MessageReader.getMessage("Error_AH_SendMoney_002"));
    }


    @Test(priority = 5)
    public void TC_SM_AH_005() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_005"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),"0",Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_002"));
    }


    @Test(priority = 7)
    public void TC_SM_AH_006() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_006"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomAlphabeticValue(6),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_003"));
    }

    @Test(priority = 8)
    public void TC_SM_AH_007() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_007"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(4),Constants.DEFAULT_AMOUNT,"");
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test(priority = 9)
    public void TC_SM_AH_008() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_008"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(7),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }


    @Test(priority = 10)
    public void TC_SM_AH_009() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_009"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),GenerateRandomValue.getRandomIntValueWithPrefix(4,"99"),Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_005"));
    }

    @Test(priority = 11)
    public void TC_SM_AH_010() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_010"));
        sendMoneyAB.performSendMoney(GenerateRandomValue.getRandomIntValue(4),GenerateRandomValue.getRandomAlphabeticValue(6),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_Login_001"));
    }

    @Test(priority = 6)
    public void TC_SM_AH_011() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_011"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),Constants.DEFAULT_AMOUNT,GenerateRandomValue.getRandomIntValue(7));
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority = 12)
    public void TC_SM_AH_012() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SM_AH_012"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"), GenerateRandomValue.getRandomAlphabeticValue(5), Constants.DEFAULT_AMOUNT,GenerateRandomValue.getRandomIntValue(5));
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(), MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test(priority = 13)
    public void TC_SM_AH0013() throws IOException, InterruptedException {
    ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SM_AH_013"));
    Config.isSelectContactFromList=true;
    sendMoneyAB.performSendMoney("",GenerateRandomValue.getRandomAlphabeticValue(5),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
    Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }

    @Test(priority = 14)
    public void TC_SM_AH0014() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SM_AH_014"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphaNumericValue(5),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }

    @Test(priority = 15)
    public void TC_SM_AH0015() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SM_AH_015"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }

    @Test(priority = 16)
    public void TC_SM_AH0016() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SM_AH_016"));
        String name = GenerateRandomValue.getRandomIntValue(5)+"!@#$%";
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),name,Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }

    @Test(priority = 17)
    public void TC_SM_AH0017() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SM_AH_017"));
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(5),Constants.DEFAULT_AMOUNT,Constants.AhlibankOTP);
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage("Error_AH_SendMoney_004"));
    }

    @Test(priority = 18)
    public void TC_SM_AH0018() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase(""));
        Config.isMultipleOtpValidationCheck=true;
        sendMoneyAB.performSendMoney(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomAlphabeticValue(5),Constants.DEFAULT_AMOUNT,GenerateRandomValue.getRandomIntValue(7));
        Assertion.verifyEqual(sendMoneyAB.getAlertMessage(),MessageReader.getMessage(""));
    }



}
