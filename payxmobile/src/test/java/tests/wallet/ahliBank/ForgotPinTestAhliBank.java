package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.ForgotPinFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import javax.xml.crypto.Data;
import java.io.IOException;

public class ForgotPinTestAhliBank extends TestInit {


    @AfterMethod
            public void afterMethod(){
        featureAhliBank.afterMethod();
    }
    ForgotPinFeatureAhliBank featureAhliBank =new ForgotPinFeatureAhliBank();
    ForgotPinPageAhliBank pageAhliBank=new ForgotPinPageAhliBank();



    @Test(priority = 0)
    public void TC_FP_001()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_001"));
        featureAhliBank.forgotPin("", Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_Login_001"));
    }

    @Test(priority = 0)
    public void TC_FP_002() throws IOException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_AH_FP_002"));
        featureAhliBank.forgotPin("34232",Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_Login_001"));
    }

    @Test(priority = 1)
    public void TC_FP_003()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_003"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),"",DataDriven.getIdByStatus("Y"),"","");
        CommonUtils.pauseExecution(1);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test(priority = 1)
    public void TC_FP_004() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_004"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),"1234",DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test(priority = 1)
    public void TC_FP_005() throws IOException{
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_AH_FP_005"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),GenerateRandomValue.getRandomIntValue(7),DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test(priority = 1)
    public void TC_FP_006() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_006"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,"","","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_001"));
    }
    @Test(priority = 1)
    public void TC_FP_007()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_007"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,"2888.9214","","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_011"));
    }

    @Test(priority = 1)
    public void TC_FP_008()throws IOException{
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_AH_FP_008"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,GenerateRandomValue.getRandomIntValue(11),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_011"));
    }

    @Test(priority = 1)
    public void TC_FP_009()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_009"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_003"));
    }

    @Test(priority = 1)
    public void TC_FP_010()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_010"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),GenerateRandomValue.getRandomIntValue(6),GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_004"));
    }

    @Test(priority = 1)
    public void TC_FP_011()throws IOException{
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_AH_FP_011"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),"",GenerateRandomValue.getRandomIntValue(6));
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_003"));
    }

    @Test(priority = 1)
    public void TC_FP_012() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_012"));
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),GenerateRandomValue.getRandomIntValue(6),"");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_002"));
    }

    @Test(priority = 1)
    public void TC_FP_013() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_013"));
        String pin = "123456";
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_005"));
    }

    @Test(priority = 1)
    public void TC_FP_014()throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_014"));
        String pin = "987654";
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_007"));
    }

    @Test(priority = 1)
    public void TC_FP_015() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_015"));
        String pin =DataDriven.getUserPin3ByStatus("Y");
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_006"));
    }

    @Test(priority = 1)
    public void TC_FP_016() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_016"));
        String pin =DataDriven.getUserPin2ByStatus("Y");
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_006"));
    }

    @Test(priority = 2)
    public void TC_FP_017() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_017"));
        String pin = GenerateRandomValue.getRandomIntValue(6);
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(), MessageReader.getMessage("Error_AH_ForgotPin_001"));
    }

    @Test(priority = 1)
    public void TC_FP_018() throws IOException{
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_FP_018"));
        String pin = GenerateRandomValue.getRandomIntValueWithPrefix(6,"111111");
        featureAhliBank.forgotPin(DataDriven.getUserByStatus("Y"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),pin,pin);
        Assertion.verifyEqual(pageAhliBank.getErrMessage(), MessageReader.getMessage("Error_AH_ForgotPin_012"));
    }

    @Test(priority = 0)
    public void TC_FP_019() throws IOException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_AH_FP_019"));
        featureAhliBank.forgotPin(GenerateRandomValue.getRandomIntValueWithPrefix(8,"33"),Constants.AhlibankOTP,DataDriven.getIdByStatus("Y"),"","");
        Assertion.verifyEqual(pageAhliBank.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_013"));
    }
}