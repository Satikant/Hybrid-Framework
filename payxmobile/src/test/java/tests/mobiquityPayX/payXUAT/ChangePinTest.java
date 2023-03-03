package tests.mobiquityPayX.payXUAT;

import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.dashboardPageObj;
import framework.mobiquityPayX.payX.PageObjects.pinChangeSuccessPageObj;
import framework.mobiquityPayX.payX.feature.pinChangedSuccessFeature;
import framework.mobiquityPayX.payX.feature.loginFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;

public class ChangePinTest extends TestInit {

    loginFeature login = new loginFeature();
    pinChangedSuccessFeature pin = new pinChangedSuccessFeature();
    pinChangeSuccessPageObj pcObj = new pinChangeSuccessPageObj();

    dashboardPageObj dbObj = new dashboardPageObj();



    @Test(priority = 1)
    public  void  ChangePin(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT1184"));
        startPositveTest();
        login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        pin.PinChange(DataDriven.getUserPinByStatus("Y"),"1357","1357");
        Assertion.verifyEqual(pcObj.getPinChangeSuccessful(), MessageReader.getMessage("PinChange_TC_1184"));
        pcObj.clickOnLogin();
    }

    @Test(priority = 2)
    public  void  LoginByOldPin(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT1195"));
        startPositveTest();
        login.loginwithPin(DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(login.getErrorText(), MessageReader.getMessage("PinChange_TC_1195"));
        login.AcceptDialogBox();
    }

    @Test(priority = 3)
    public  void  LoginByNewPin(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT1183"));
        startPositveTest();
        login.loginwithPin("1357");
        Assertion.verifyEqual(dbObj.getDashboardWelcomePage(), MessageReader.getMessage("PinChange_TC_1183"));
    }


}
