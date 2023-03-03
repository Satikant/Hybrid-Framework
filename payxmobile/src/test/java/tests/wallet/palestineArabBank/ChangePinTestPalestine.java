package tests.wallet.palestineArabBank;

import common.Assertion;
import framework.wallet.palestineArabBank.features.ChangePinFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.ChangePinPagePalestine;
import initializers.TestInit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class ChangePinTestPalestine extends TestInit {

ChangePinFeaturePalestine chngePinFeature = new ChangePinFeaturePalestine();
ChangePinPagePalestine page =new ChangePinPagePalestine();

    public ChangePinTestPalestine() throws IOException, InvalidFormatException {
    }

    @AfterMethod
    public  void  afterMethod(){
        chngePinFeature.acceptAlert();
    }


    @Test(priority = 199)
    public void TC_ChangePin_001() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_001"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String pin = GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= GenerateRandomValue.getRandomAlphabeticValue(3);
        chngePinFeature.changePin(secAnswr,oldPin,pin,pin);
        CommonUtils.pauseExecution(3);
    }

    @Test(priority = 200)
    public void TC_ChangePin_002() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_002"));
        String pin = "1234";
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"),pin, pin);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0028"));
    }

    @Test(priority = 201)
    public void TC_ChangePin_003() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_003"));
        String pin = "4321";
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0030"));
    }

    @Test(priority = 202)
    public void TC_ChangePin_004() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_004"));
        String pin = DataDriven.getUserPin3ByStatus("Y");
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority = 203)
    public void TC_ChangePin_005() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_005"));
        String pin = DataDriven.getUserPin2ByStatus("Y");
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority = 204)
    public void TC_ChangePin_006() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_006"));
        String pin = DataDriven.getUserPinByStatus("Y");
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority = 205)
    public void TC_ChangePin_007() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_007"));
        String oldPin= GenerateRandomValue.getRandomIntValue(4);
        String pin = GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin, pin, pin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0031"));
    }

    @Test(priority = 206)
    public void TC_ChangePin_008() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_008"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String newPin = DataDriven.getUserPin2ByStatus("Y");
        String confirmPin= GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin, newPin, confirmPin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0043"));
    }

    @Test(priority = 207)
    public void TC_ChangePin_009() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_009"));
        String oldPin= "";
        String pin = GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin, pin, pin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0044"));
    }

    @Test(priority = 208)
    public void TC_ChangePin_010() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_010"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String newPin = "";
        String confirmPin= GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin, newPin, confirmPin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0044"));
    }

    @Test(priority = 209)
    public void TC_ChangePin_011() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_011"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String newPin = GenerateRandomValue.getRandomIntValue(4);
        String confirmPin= "";
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin, newPin, confirmPin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0044"));
    }

    @Test(priority = 210)
    public void TC_ChangePin_012() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_012"));
        String oldPin= GenerateRandomValue.getRandomIntValue(2);
        String pin = GenerateRandomValue.getRandomIntValue(4);
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin,pin,pin);
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0045"));
    }

    @Test(priority = 211)
    public void TC_ChangePin_013() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_013"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin,GenerateRandomValue.getRandomIntValue(2),GenerateRandomValue.getRandomIntValue(4));
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0045"));
    }

    @Test(priority = 212)
    public void TC_ChangePin_014() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_014"));
        String oldPin= DataDriven.getUserPinByStatus("Y");
        String secAnswr= DataDriven.getIdByStatus("Y");
        chngePinFeature.changePin(secAnswr,oldPin,GenerateRandomValue.getRandomIntValue(4),GenerateRandomValue.getRandomIntValue(2));
        Assertion.verifyEqual(page.getErrMsg(),MessageReader.getMessage("ERRMSG_0045"));
    }

    @Test(priority = 213)
    public void TC_ChangePin_015() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_015"));
        String pin = "1111";
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0079"));
    }

    @Test(priority = 214)//Positive case
    public void TC_ChangePin_016() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_016"));
        String pin = GenerateRandomValue.getRandomIntValue(4);
        chngePinFeature.changePin(DataDriven.getIdByStatus("Y"),DataDriven.getUserPinByStatus("Y"), pin, pin);
    }

}
