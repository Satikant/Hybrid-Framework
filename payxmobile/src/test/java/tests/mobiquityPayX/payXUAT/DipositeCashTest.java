package tests.mobiquityPayX.payXUAT;

import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.depositeCashDetailsPageObj;
import framework.mobiquityPayX.payX.PageObjects.depositeCashSuccessPageObj;
import framework.mobiquityPayX.payX.feature.loginFeature;
import framework.mobiquityPayX.payX.feature.depositeCashUn_registerFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;

public class DipositeCashTest extends TestInit {

    loginFeature login = new loginFeature();
    depositeCashUn_registerFeature deposite = new depositeCashUn_registerFeature();
    depositeCashDetailsPageObj dcObj = new depositeCashDetailsPageObj();
    depositeCashSuccessPageObj depositeCash = new depositeCashSuccessPageObj();




    @Test(priority = 1)
    public  void  DipositeCash_01(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT138"));
        startPositveTest();
        login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        deposite.depositeCash("7504490205","9078734397","50");
        Assertion.verifyEqual(dcObj.getTransforNow(), MessageReader.getMessage("DipositeCash_TC_138"));
    }

    @Test(priority = 2)
    public  void  DipositeCash_02(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT149"));
        startPositveTest();
        deposite.depositeCashSuccess(DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(depositeCash.getDepositeCashSuccessful(), MessageReader.getMessage("DipositeCash_TC_149"));
    }


}
