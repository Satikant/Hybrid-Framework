package tests.mobiquityPayX.payXUAT;

import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.*;
import framework.mobiquityPayX.payX.feature.loginFeature;
import framework.mobiquityPayX.payXUAT.PageObjects.historyPageObj;
import framework.mobiquityPayX.payXUAT.PageObjects.orderDetailsPageObj;
import framework.mobiquityPayX.payXUAT.feature.billPayFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;
import utils.Utils;

public class BillPaySubsciberTest extends TestInit {

    loginFeature login = new loginFeature();
    billPayFeature bpFeature = new billPayFeature();
    billPayPageObj billPay = new billPayPageObj();
    HamburgerMenuPageObjects hm = new HamburgerMenuPageObjects();
    dashboardPageObj dashboard = new dashboardPageObj();
    electricityDetailsPageObj electricity = new electricityDetailsPageObj();
    WalletsPO wpo = new WalletsPO();
    pinAuthenticationPageObj pinMask = new pinAuthenticationPageObj();
    electricityBillPaymentSuccessPageObj billSuccess = new electricityBillPaymentSuccessPageObj();

    historyPageObj hp = new historyPageObj();
    orderDetailsPageObj od = new orderDetailsPageObj();


    @Test(priority = 1)
    public  void  payXUAT782(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT782"));
        startPositveTest();
        login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        dashboard.clickOnBillPay();
        Assertion.verifyEqual(billPay.getBillPayPageTitle(), MessageReader.getMessage("BillPay_TC_782"));
        Utils.putThreadSleep(10000);
    }

    @Test(priority = 2)
    public  void  payXUAT784(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT784"));
        bpFeature.electricityBillPay("20","OS91234518");
        pinMask.clickOnEnterPinField().setPin(DataDriven.getUserPinByStatus("Y")).clickVerify();
        Assertion.verifyEqual(billSuccess.getElectricityBillPaymentSuccessful(), MessageReader.getMessage("BillPay_TC_784"));
        billSuccess.clickOnGoHome();
    }

    @Test(priority = 3)
    public  void  payXUAT785(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT785"));
        startPositveTest();
        dashboard.clickOnBillPay();
        bpFeature.postPaidBillPay("8249020205","50",DataDriven.getUserPinByStatus("Y"));
        Assertion.verifyEqual(billSuccess.getElectricityBillPaymentSuccessful(), MessageReader.getMessage("BillPay_TC_785"));
        billSuccess.clickOnGoHome();
    }

    @Test(priority = 4)
    public  void  payXUAT786(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT786"));
        startPositveTest();
        bpFeature.electricityBillPay("20","OS91234518");
        pinMask.clickOnEnterPinField().setPin(DataDriven.getUserPinByStatus("Y")).clickVerify();
        billSuccess.makeAnotherPayment();
        bpFeature.electricityBillPay("50","HO78654365");
        pinMask.clickOnEnterPinField().setPin(DataDriven.getUserPinByStatus("Y")).clickVerify();
        Assertion.verifyEqual(billSuccess.getElectricityBillPaymentSuccessful(), MessageReader.getMessage("BillPay_TC_786"));
    }

    @Test(priority = 5)
    public  void  payXUAT1782(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT1782"));
        startPositveTest();
        Assertion.verifyEqual(billSuccess.getElectricityBillPaymentSuccessful(), MessageReader.getMessage("BillPay_TC_1782"));
    }

    @Test(priority = 6)
    public  void  payXUAT787(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT787"));
        startPositveTest();
        billSuccess.viewTransactions();
        Assertion.verifyEqual(hp.getFailedTransctions(), MessageReader.getMessage("BillPay_TC_787"));
        dashboard.clickSubscriberHome();
//        hm.clickonmenus();
    }

    @Test(priority = 6)
    public  void  payXUAT115(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUAT115"));
        startPositveTest();
        dashboard.clickOnWallet();
        Assertion.verifyEqual(wpo.getWalletTitle(), MessageReader.getMessage("BillPay_TC_115"));
        dashboard.clickSubscriberHome();
//        hm.clickonmenus();
    }


}
