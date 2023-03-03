package tests.wallet.bharain;


import common.Assertion;
import framework.wallet.bankMuscat.features.ProfileDetailsFeature;
import framework.wallet.bharain.features.CustomerLoginBharain;
import framework.wallet.bharain.features.ForgotPinFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;
import java.io.IOException;
import static utils.GenerateRandomValue.*;



import static utils.GenerateRandomValue.getNewPin;


public class ForgotPinTest extends TestInit {
    ForgotPinFeature fgtPinLogic = new ForgotPinFeature();
    LoginPageBharain loginPage = new LoginPageBharain();
    String new_confirm_pin=getNewPin(getDistinctNumber(getRandomIntValue(4),4),4);

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() {
        fgtPinLogic.acceptAlertOman();
    }

    @Test(priority = 340)
    public void FGTTC001() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_001"));
        fgtPinLogic.forgotPin("", Constants.BAHRAIN_OTP,DataDriven.getIdByStatus("Y"),new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_001"));
    }

    @Test(priority = 341)
    public void FGTTC002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_002"));
        fgtPinLogic.forgotPin(getRandomIntValue(4),Constants.BAHRAIN_OTP,"",new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_003"));
    }

    @Test(priority = 342)
    public void FGTTC003() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_003"));
        fgtPinLogic.forgotPin(getRandomIntValue(9),Constants.BAHRAIN_OTP,DataDriven.getIdByStatus("Y"),new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0040"));
    }

    @Test(priority = 343)
    public void FGTTC004() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_004"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"),getRandomIntValue(4),DataDriven.getIdByStatus("y"),new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0035"));
    }

    @Test(priority = 345)
    public void FGTTC005() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_005"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"),"",DataDriven.getIdByStatus("Y"),new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0035"));
    }

    @Test(priority = 346)//OTP validation
    public void FGTTC006() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_006"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"),getRandomIntValue(6), DataDriven.getIdByStatus("Y"),new_confirm_pin, new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0036"));
    }

    @Test(priority = 347)//OTP validation
    public void FGTTC007() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_007"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"),Constants.BAHRAIN_OTP,"",new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0085"));
    }

    @Test(priority = 348)//OTP validation
    public void FGTTC008() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_008"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, getRandomAlphabeticValue(4),new_confirm_pin, new_confirm_pin);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0084"));
    }

    @Test(priority = 349)//Enter new_confirm_pin
    public void FGTTC009() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_009"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),"1234", "1234");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0037"));
    }

    @Test(priority = 350)
    public void FGTTC010() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_010"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),"4321", "4321");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0038"));
    }

    @Test(priority = 351)
    public void FGTTC011() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_011"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),"", getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0039"));
    }

    @Test(priority = 352)
    public void FGTTC012() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_012"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),getRandomIntValue(4), "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0080"));
    }

    @Test(priority = 353)
    public void FGTTC013() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_013"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),getRandomIntValue(3), getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0081"));
    }

    @Test(priority = 354)
    public void FGTTC014() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_014"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),getRandomIntValue(4), getRandomIntValue(4));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0082"));
    }

    @Test(priority = 209)
    public void FGTTC015() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_015"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),DataDriven.getUserPin2ByStatus("Y"),DataDriven.getUserPin2ByStatus("Y"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0083"));
    }

    @Test(priority = 355)
    public void FGTTC016() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_016"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),DataDriven.getUserPin3ByStatus("Y"),DataDriven.getUserPin3ByStatus("Y"));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0083"));
    }

    @Test(priority = 356)
    public void FGTTC017() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_017"));
        fgtPinLogic.forgotPin(DataDriven.getUserByStatus("Y"), Constants.BAHRAIN_OTP, DataDriven.getIdByStatus("Y"),new_confirm_pin,new_confirm_pin);
    }

    @Test(priority = 357)// Email not verified
    public void FGTTC018() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ForgotPin_018"));
        Config.isForgotSecurityPresent = true;
        Config.isFirstTimeLogin=true;
        fgtPinLogic.forgotSecurityAnwser("Y","123456","","","","","");
    }
    @Test(priority = 358)
    public void FGTTC019() {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_019"));
        Config.isFirstTimeLogin=true;
        fgtPinLogic.forgotSecurityAnwser("TBV","123456","","29/04/1988","1357","1357","abc");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0054"));
    }

    @Test(priority = 359)
    public void FGTTC020() {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_020"));
        fgtPinLogic.forgotSecurityAnwser("Y","123456","9876543210","","1357","1357","abc");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0055"));
    }

    @Test(priority = 360)
    public void FGTTC021() {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_021"));
        fgtPinLogic.forgotSecurityAnwser("Y","123456","9876543210","29/04/1998","1357","1357","");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0056"));
    }
    @Test(priority =361)
    public void FGTTC022() {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_022"));
        fgtPinLogic.forgotSecurityAnwser("Y","123456","135854217","24/04/1995","1357","1357","");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0056"));
    }

//    @Test(priority = 362)
//    public void FGTTC023() {
//        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_017"));
//         newpin=getRandomIntValue(4);
//        fgtPinLogic.forgotSecurityAnwser("Y","123456","9876543210","24/04/1995",newpin,newpin,"");
//        Assertion.verifyEqual("","");
//    }

    @Test(priority = 363)//Positive
    public void FGTTC024() {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ForgotPin_024"));
        new_confirm_pin=getRandomIntValue(4);
        fgtPinLogic.forgotSecurityAnwser("Y","123456","9876543210","24/04/1995",new_confirm_pin,new_confirm_pin,"abc");
        ProfileDetailsFeature.logOut();
    }


}