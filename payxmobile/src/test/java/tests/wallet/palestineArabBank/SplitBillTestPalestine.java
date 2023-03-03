package tests.wallet.palestineArabBank;

import common.Assertion;
import framework.wallet.bharain.features.SplitBillFeature;
import framework.wallet.palestineArabBank.features.CustomerLoginPalestine;
import framework.wallet.palestineArabBank.features.SplitBillFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.SplitBillPagePalestine;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;

import static utils.GenerateRandomValue.*;


public class SplitBillTestPalestine extends TestInit {

    SplitBillFeaturePalestine splitBillFeature = new SplitBillFeaturePalestine();
    SplitBillPagePalestine splitBillPage = new SplitBillPagePalestine();

    @AfterMethod
    public void acceptalert() {
        splitBillFeature.acceptAlert();
    }

    @Test(priority = 1)
    public void TC_SPB_001() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_001"));
        String[] msisdn = {getRandomIntValue(9)};
        String[] names = {getRandomAlphabeticValue(5)};
        splitBillFeature.Group(getRandomAlphabeticValue(4),msisdn, names, 3, Constants.ADD);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("COVALMSG_001"));
    }

    @Test(priority = 2)
    public void TC_SBP_002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_002"));
        String[] msisdn = {getRandomIntValue(9)};
        String[] names = {getRandomAlphabeticValue(5)};
        splitBillFeature.Group(getRandomAlphabeticValue(6), msisdn, names, 1, Constants.ADD);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0053"));
    }

    @Test(priority = 3)
    public void TC_SBP_003() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_003"));
        String[] msisdn = {getRandomIntValue(9), getRandomIntValue(9)};
        String[] names = {getRandomAlphabeticValue(4), getRandomAlphabeticValue(4)};
        splitBillFeature.Group("", msisdn, names, 2, Constants.ADD);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0054"));
    }

    @Test(priority = 4)
    public void TC_SBP_004() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_004"));
        String[] msisdn = {getRandomIntValue(9), getRandomIntValue(9), getRandomIntValue(9)};
        String[] names = {getRandomAlphabeticValue(4), getRandomAlphabeticValue(4), getRandomAlphabeticValue(4)};
        splitBillFeature.Group(Constants.Splitgroup, msisdn, names, 3, Constants.ADD);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0055"));
    }

    @Test(priority = 5)
    public void TC_SPB_005() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_005"));
        String[] msisdn = {Constants.SplitInitiator, getRandomIntValue(9), getRandomIntValue(9)};
        String[] names = {getRandomAlphabeticValue(4),getRandomAlphabeticValue(4),getRandomAlphabeticValue(4)};
        splitBillFeature.Group(getRandomAlphabeticValue(4), msisdn, names, 3, Constants.ADD);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0056"));
    }

    @Test(priority = 6)
    public void TC_SBP_006() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_006"));
        String[] msisdn = {getRandomIntValueWithPrefix(2, "00")};
        String[] names = {getRandomAlphabeticValue(4)};
        Config.toastCheck = true;
        splitBillFeature.Group(getRandomAlphabeticValue(3), msisdn, names, 1, Constants.ADD);
    }

    @Test(priority = 7)
    public void TC_SBP_007() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_007"));
        String[] msisdn = {getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"),
                getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"),
                getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"),
                getRandomIntValueWithPrefix(7, "97"), getRandomIntValueWithPrefix(7, "97"),};
        String[] names = {getRandomAlphabeticValue(5), getRandomAlphabeticValue(5), getRandomAlphabeticValue(5), getRandomAlphabeticValue(3),
                getRandomAlphabeticValue(3), getRandomAlphabeticValue(5), getRandomAlphabeticValue(5),
                getRandomAlphabeticValue(3), getRandomAlphabeticValue(3), getRandomAlphabeticValue(3), getRandomAlphabeticValue(4)};
        Config.toastCheck = true;
        splitBillFeature.Group(getRandomAlphabeticValue(4), msisdn, names, 11, Constants.ADD);
    }

    @Test(priority = 8)
    public void TC_SPB_008() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_008"));
        String[] msisdn = {getRandomIntValueWithPrefix(6, "77")};
        String[] names = {getRandomAlphabeticValue(5)};
        splitBillFeature.Group("", msisdn, names, 1, Constants.MODIFY);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0058"));
    }

    @Test(priority = 9)
    public void TC_SPB_009() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_009"));
        String[] msisdn = {};
        String[] names = {};
        Config.isDeleteMember = true;
        splitBillFeature.Group(getRandomAlphabeticValue(4), msisdn, names, 1, Constants.MODIFY);
        Assertion.verifyContains(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0058"));
    }

    @Test(priority = 10)
    public void TC_SPB_010() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_010"));
        String[] msisdn = {};
        String[] names = {};
//        Config.isDeleteMember = true;
        splitBillFeature.Group(getRandomAlphabeticValue(4), msisdn, names, 2, Constants.DELETE);
        Assertion.verifyContains(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0059"));
    }

    @Test(priority = 11)
    public void TC_SBP_011() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SBP_011"));
        splitBillFeature.initiateSplitBill("2", Constants.REJECT);
        Assertion.verifyContains( splitBillPage.getTxnMsg(),MessageReader.getMessage("ERRMSG_0066"));
    }

    @Test(priority = 12)
    public void TC_SBP_012() {
        ExtentManager.startTestFromProperty(pNode, "TC_SBP_012");
        String msisdn[] = {getRandomIntValueWithPrefix(7,"77"),getRandomIntValueWithPrefix(7,"77")};
        String name[] = {getRandomAlphabeticValue(4),getRandomAlphabeticValue(4)};
        /*splitBillFeature.Group("group1", msisdn, name, 2, Constants.ADD);
        splitBillFeature.acceptAlert();*/ Config.isDeleteMember = true;
        splitBillFeature.Group(getRandomAlphabeticValue(4), msisdn, name, 2, Constants.MODIFY);
        Assertion.verifyEqual(splitBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0067"));


    }


}