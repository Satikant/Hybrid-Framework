package tests.wallet.bharain;

import common.Assertion;
import framework.wallet.bharain.features.ChangePinFeature;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import initializers.TestInit;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;
import java.io.IOException;
import static utils.DataDriven.*;
import static utils.GenerateRandomValue.*;

public class  ChangePinTest extends TestInit{
    String new_confirm_pin="";
    ChangePinFeature chngePinFeature= new ChangePinFeature();
    LoginPageBharain page = new LoginPageBharain();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() {
         chngePinFeature.acceptAlert();
        }


    @Test(priority=311)
    public void TC_ChangePin_001() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_001"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),"1234","1234");
        Assertion.verifyEqual(page.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0028"));
    }

    @Test(priority=312)
    public void TC_ChangePin_002() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_002"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),"4321","4321");
        Assertion.verifyEqual(page.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0030"));
    }

    @Test(priority=313)
    public void TC_ChangePin_003() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_003"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getUserPin3ByStatus("Y"),getUserPin3ByStatus("Y"));
        Assertion.verifyEqual(page.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority=314)
    public void TC_ChangePin_004() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_004"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getUserPin2ByStatus("Y"),getUserPin2ByStatus("Y"));
        Assertion.verifyEqual(page.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority=315)
    public void TC_ChangePin_005() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_005"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getUserPinByStatus("Y"),getUserPinByStatus("Y"));
        Assertion.verifyEqual(page.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0027"));
    }

    @Test(priority=316)
    public void TC_ChangePin_006() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_006"));
        chngePinFeature.changePin(getRandomIntValue(4),getUserPinByStatus("Y"),getUserPinByStatus("Y"));
        Assertion.verifyEqual(page.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0031"));
    }

    @Test(priority=317)
    public void TC_ChangePin_007() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_007"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getNewPin(getDistinctNumber(getRandomIntValue(4),4),4),getNewPin(getDistinctNumber(getRandomIntValue(4),4),4));
        Assertion.verifyEqual(page.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0032"));
    }

    @Test(priority=318)
    public void TC_ChangePin_008() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_008"));
        new_confirm_pin=getNewPin(getDistinctNumber(getRandomIntValue(4),4),4);
        chngePinFeature.changePin("",new_confirm_pin,new_confirm_pin);
        Assertion.verifyEqual(page.getMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0033"));
    }

    @Test(priority=319)
    public void TC_ChangePin_009() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_009"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),"",getNewPin(getDistinctNumber(getRandomIntValue(4),4),4));
        Assertion.verifyEqual(page.getMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0033"));
    }

    @Test(priority=320)
    public void TC_ChangePin_010() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_010"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getNewPin(getDistinctNumber(getRandomIntValue(4),4),4),"");
        Assertion.verifyEqual(page.getMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0033"));
    }

    @Test(priority=321)
    public void TC_ChangePin_011() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_ChangePin_011"));
        chngePinFeature.changePin(getUserPinByStatus("Y"),getNewPin(getDistinctNumber(getRandomIntValue(3),3),3),getNewPin(getDistinctNumber(getRandomIntValue(3),3),3));
        Assertion.verifyEqual(page.getMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0034"));
    }

    @Test(priority=322)//Positive
    public void TC_ChangePin_012() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_ChangePin_012"));
        new_confirm_pin=getNewPin(getDistinctNumber(getRandomIntValue(4),4),4);
        chngePinFeature.changePin(getUserPinByStatus("Y"),new_confirm_pin,new_confirm_pin);
    }

}