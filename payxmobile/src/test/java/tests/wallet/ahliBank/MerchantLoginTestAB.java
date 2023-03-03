package tests.wallet.ahliBank;

import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.ahliBank.features.MerchantLoginFeatureAB;
import framework.wallet.ahliBank.pageObjects.MerchantLoginPageAB;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class MerchantLoginTestAB extends TestInit {
   
        MerchantLoginFeatureAB merchantLogin = new MerchantLoginFeatureAB();
        MerchantLoginPageAB loginPage = new MerchantLoginPageAB();

        @AfterMethod(alwaysRun = true)
        public void acceptTheAlert() throws JSchException, InterruptedException
        {
            merchantLogin.acceptAlert();
        }

        @Test(priority=1)
        public void TC_MAH_01(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_01"));
            merchantLogin.login("", GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_Login_001"));
        }

        @Test(priority=2)
        public void TC_MAH_02(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_02"));
            merchantLogin.login(GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_009"));
        }

        @Test(priority=3)
        public void TC_MAH_03(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_03"));
            merchantLogin.login(GenerateRandomValue.getRandomIntValue(6),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_001"));
        }

        @Test(priority=4)
        public void TC_MAH_04() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_04"));
        merchantLogin.login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_011"));
        }

        @Test(priority=5)
        public void TC_MAH_05() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_05"));
        merchantLogin.login(DataDriven.getUserByStatus("S"),DataDriven.getUserPinByStatus("S"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=6)
        public void TC_MAH_06() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_06"));
        merchantLogin.login(DataDriven.getUserByStatus("BL"),DataDriven.getUserPinByStatus("BL"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_011"));
        }

        @Test(priority=7)
        public void TC_MAH_07() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_07"));
        merchantLogin.login(DataDriven.getUserByStatus("IN"),DataDriven.getUserPinByStatus("IN"));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_009"));
        }

        @Test(priority=8)
        public void TC_MAH_08() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_08"));
            merchantLogin.login(DataDriven.getUserByStatus("MY"),"");
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_005"));
        }

        @Test(priority=9)
        public void TC_MAH_09() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_09"));
        merchantLogin.login(DataDriven.getUserByStatus("MY"),GenerateRandomValue.getRandomIntValue(3));
        Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_005"));
        }

        @Test(priority=10)
        public void TC_MAH_010() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_010"));
            merchantLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=11)
        public void TC_MAH_011() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_011"));
            merchantLogin.login(DataDriven.getUserByStatus("S"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=12)
        public void TC_MAH_012() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_012"));
            merchantLogin.login(DataDriven.getUserByStatus("S"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=13)
        public void TC_MAH_013() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_013"));
            merchantLogin.login(DataDriven.getUserByStatus("S"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=14)
        public void TC_MAH_014() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_014"));
            merchantLogin.login(DataDriven.getUserByStatus("S"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=15)
        public void TC_MAH_015() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_015"));
            merchantLogin.login(DataDriven.getUserByStatus("B"),GenerateRandomValue.getRandomIntValue(6));
            Assertion.verifyEqual(loginPage.getMessageFromAlertBox(),MessageReader.getMessage("Error_AH_Login_012"));
        }

        @Test(priority=16)
        public void TC_MAH_016() throws IOException {
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MAH_016"));
            merchantLogin.login(DataDriven.getUserByStatus("MY"),DataDriven.getUserPinByStatus("MY"));
        }


 }

