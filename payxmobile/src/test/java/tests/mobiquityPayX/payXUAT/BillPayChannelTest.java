package tests.mobiquityPayX.payXUAT;

import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import framework.mobiquityPayX.payXUAT.PageObjects.historyPageObj;
import framework.mobiquityPayX.payXUAT.PageObjects.orderDetailsPageObj;
import framework.mobiquityPayX.payXUAT.feature.billPayFeature;
import framework.mobiquityPayX.payX.feature.loginFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;
import utils.Utils;

public class BillPayChannelTest extends TestInit {

    loginFeature login = new loginFeature();
    billPayFeature bpFeature = new billPayFeature();
    billPayPageObj billPay = new billPayPageObj();
    dashboardPageObj dashboard = new dashboardPageObj();
    electricityDetailsPageObj electricity = new electricityDetailsPageObj();
    pinAuthenticationPageObj pinMask = new pinAuthenticationPageObj();
    electricityBillPaymentSuccessPageObj billSuccess = new electricityBillPaymentSuccessPageObj();

    historyPageObj hp = new historyPageObj();
    orderDetailsPageObj od = new orderDetailsPageObj();



    @Test(priority = 1)
    public  void  payXUAT122(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT122"));
        startPositveTest();
        login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        bpFeature.electricityBillPay("20","OS91234518");
        pinMask.clickOnEnterPinField().setPin(DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(pinMask.getMaskPinVerify(), MessageReader.getMessage("BillPay_TC_122"));
        pinMask.clickVerify();
    }


    @Test(priority = 2)
    public  void  payXUAT127(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT127"));
        startPositveTest();
        billSuccess.clickOnGoHome();
        Assertion.verifyEqual(dashboard.getDashboardWelcomePage(), MessageReader.getMessage("BillPay_TC_127"));
    }


    @Test(priority = 3)
    public  void  payXUAT123(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT123"));
        startPositveTest();
        dashboard.clickChannelHistory(); hp.clickOnMyOrders();
        Assertion.verifyEqual(hp.getFailedTransctions(), MessageReader.getMessage("BillPay_TC_123"));
    }

    @Test(priority = 4)
    public  void  payXUAT124(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT124"));
        startPositveTest();
        hp.clickOnTransction();
        Assertion.verifyEqual(od.getTransctionsDetails(), MessageReader.getMessage("BillPay_TC_124"));
        bpFeature.backToDashboard();dashboard.clickChannelHome();
    }

/*    @Test(priority = 4)
    public  void  payXUAT115(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT115"));
        startPositveTest();
        hp.clickOnTransction();
        Assertion.verifyEqual(od.getTransctionsDetails(), MessageReader.getMessage("BillPay_TC_124"));
        bpFeature.backToDashboard();dashboard.clickChannelHome();
    }*/


}
