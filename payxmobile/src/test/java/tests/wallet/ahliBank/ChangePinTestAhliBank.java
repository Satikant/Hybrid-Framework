package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.ChangePinFeatureAhliBank;
import framework.wallet.ahliBank.features.ForgotPinFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.ChangePinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;
import static utils.DataDriven.*;
import static utils.GenerateRandomValue.*;


public class ChangePinTestAhliBank extends TestInit {
    String pin="";
    
    ChangePinFeatureAhliBank changePinFeature= new ChangePinFeatureAhliBank();
    ForgotPinPageAhliBank changePinPage =new ForgotPinPageAhliBank();

    @AfterMethod
    public void afterMethod(){
        changePinFeature.afterMethod();
    }

    @Test
    public void TC_CP_001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_001"));
        changePinFeature.changePin("", Constants.AhlibankOTP,getUserPinByStatus("Y"),getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(), MessageReader.getMessage("Error_AH_ChangePin_001"));
    }

    @Test
    public void TC_CP_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_002"));
        changePinFeature.changePin("2810.889214",Constants.AhlibankOTP,getUserPinByStatus("Y"),getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_002"));
    }

    @Test
    public void TC_CP_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_003"));
        pin=getNewPin(getDistinctNumber(getRandomIntValue(6),6),6);
        changePinFeature.changePin(GenerateRandomValue.getRandomIntValue(11),Constants.AhlibankOTP,getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_002"));
    }

    @Test
    public void TC_CP_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_004"));
        changePinFeature.changePin(getIdByStatus("Y"),"",getUserPinByStatus("Y"),getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test
    public void TC_CP_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_005"));
        changePinFeature.changePin(getIdByStatus("Y"),getRandomIntValue(4),getUserPinByStatus("Y"),getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_003"));
    }

    @Test
    public void TC_CP_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_006"));
        pin=getNewPin(getDistinctNumber(getRandomIntValue(6),6),6);
        changePinFeature.changePin(getIdByStatus("Y"),getRandomIntValue(7),getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_BillPay_016"));
    }

    @Test
    public void TC_CP_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_007"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,"",getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_004"));
    }

    @Test
    public void TC_CP_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_008"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),"",getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_006"));
    }

    @Test
    public void TC_CP_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_009"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),getRandomIntValue(6),"");
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_002"));
    }

    @Test
    public void TC_CP_010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_010"));
        pin=getNewPin(getDistinctNumber(getRandomIntValue(6),6),6);
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getRandomIntValue(6),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_Login_003"));
    }

    @Test
    public void TC_CP_011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_011"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),getRandomIntValue(6),getRandomIntValue(6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_005"));
    }

    @Test
    public void TC_CP_012()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_012"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),getRandomIntValue(4),
                getNewPin(getDistinctNumber(getRandomIntValue(6),6),6));
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ChangePin_006"));
    }

    @Test
    public void TC_CP_013()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_013"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),"123456","123456");
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_005"));
    }

    @Test
    public void TC_CP_014()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_014"));
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),"987654","987654");
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_007"));
    }

    @Test
    public void TC_CP_015()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_015"));
        pin = getUserPin3ByStatus("Y");
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_006"));
    }

    @Test
    public void TC_CP_016()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_016"));
        pin = getUserPin2ByStatus("Y");
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_006"));
    }

    @Test
    public void TC_CP_017()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_017"));
        pin =getRandomIntValueWithPrefix(3,"111");
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_012"));
    }

    @Test
    public void TC_CP_018()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AH_CP_018"));
        pin =getNewPin(getDistinctNumber(getRandomIntValue(6),6),6);
        changePinFeature.changePin(getIdByStatus("Y"),Constants.AhlibankOTP,getUserPinByStatus("Y"),pin,pin);
        Assertion.verifyEqual(changePinPage.getErrMessage(),MessageReader.getMessage("Error_AH_ForgotPin_001"));
    }
}
