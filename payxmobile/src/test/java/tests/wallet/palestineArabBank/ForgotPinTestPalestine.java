package tests.wallet.palestineArabBank;

import common.Assertion;
import framework.wallet.palestineArabBank.features.CustomerLoginPalestine;
import framework.wallet.palestineArabBank.features.ForgotPinFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import globalConstants.Config;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

import static utils.GenerateRandomValue.*;

public class ForgotPinTestPalestine extends TestInit {
    String pin;
    ForgotPinFeaturePalestine fgtPinLogic = new ForgotPinFeaturePalestine();
    LoginPagePalestine loginPage = new LoginPagePalestine();
    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();


    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() throws InterruptedException {
        customerLogin.acceptAlert();
    }

    @Test(priority = 201)
    public void FGTTC001() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_001"));
        fgtPinLogic.forgotPin("", "", "", "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority = 202)
    public void FGTTC002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_002"));
        fgtPinLogic.forgotPin(GenerateRandomValue.getRandomIntValueWithPrefix(4,"9"), "", "", "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_003"));
    }

    @Test(priority = 203)
    public void FGTTC003() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_003"));
        fgtPinLogic.forgotPin(GenerateRandomValue.getRandomIntValueWithPrefix(8, "9"), "", "", "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0084"));
    }

    @Test(priority = 204)
    public void FGTTC004() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_004"));
        fgtPinLogic.forgotPin("000000000", "", "", "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_002"));
    }

    @Test(priority = 205)
    public void FGTTC005() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_005"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), GenerateRandomValue.getRandomIntValue(3), DataDriven.getIdByStatus("Y"), "", "");
        Assertion.verifyEqual(loginPage.getErrorMsg(), MessageReader.getMessage("ERRMSG_0035"));
    }

    @Test(priority = 206)
    public void FGTTC006() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_006"));
        Config.isClearFieldTrue = true;
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), "      ", DataDriven.getIdByStatus("Y"), "", "");
        Assertion.verifyEqual(loginPage.getErrorMsg(), MessageReader.getMessage("ERRMSG_0035"));
    }

    @Test(priority = 207)
    public void FGTTC007() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_007"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), GenerateRandomValue.getRandomIntValue(6), DataDriven.getIdByStatus("Y"), "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0036"));
    }

    @Test(priority = 208)
    public void FGTTC008() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_008"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP,"", "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0085"));
    }

    @Test(priority = 209)
    public void FGTTC009() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_009"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, GenerateRandomValue.getRandomAlphabeticValue(3), "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0042"));
    }

    @Test(priority = 210)
    public void FGTTC010() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_010"));
        pin ="1234";
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0037"));
    }

    @Test(priority = 211)
    public void FGTTC011() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_011"));
        pin = "4321";
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0038"));
    }

    @Test(priority = 212)
    public void FGTTC012() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_012"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), "", "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0044"));
    }

    @Test(priority = 213)
    public void FGTTC013() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_013"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), GenerateRandomValue.getRandomIntValue(4), "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0080"));
    }

    @Test(priority = 214)
    public void FGTTC014() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_014"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),"",GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0044"));
    }

    @Test(priority = 215)
    public void FGTTC015() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_015"));
        pin = getNewPin(getDistinctNumber(getRandomIntValue(4), 4), 4);
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), GenerateRandomValue.getRandomIntValue(2), pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_007"));
    }

    @Test(priority = 216)
    public void FGTTC016() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_016"));
        pin = getNewPin(getDistinctNumber(getRandomIntValue(4), 4), 4);
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),pin,GenerateRandomValue.getRandomIntValue(2));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0043"));
    }

    @Test(priority = 217)
    public void FGTTC017() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_017"));
        pin = getNewPin(getDistinctNumber(getRandomIntValue(3), 3), 3);
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_007"));
    }

    @Test(priority = 218)
    public void FGTTC018() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_018"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"),
                Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),
                getNewPin(getDistinctNumber(getRandomIntValue(4), 4), 4),
                getNewPin(getDistinctNumber(getRandomIntValue(4), 4), 4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0043"));
    }

    @Test(priority = 219)
    public void FGTTC019() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_019"));
        pin = DataDriven.getUserPin2ByStatus("Y");
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority = 220)
    public void FGTTC020() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_020"));
        pin = DataDriven.getUserPin3ByStatus("Y");
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority = 221)//Positive Flow
    public void FGTTC021() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_021"));
        pin = getNewPin(getDistinctNumber(getRandomIntValue(4), 4), 4);
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"), pin, pin);
    }
}
