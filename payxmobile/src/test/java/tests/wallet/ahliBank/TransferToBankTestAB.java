package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.TransferToBankFeatureAB;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import framework.wallet.ahliBank.pageObjects.TransferToBankPageAB;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

import java.io.IOException;

public class TransferToBankTestAB extends TestInit {

    LoginPageAhliBank login = new LoginPageAhliBank();
    TransferToBankPageAB page1 = new TransferToBankPageAB();
    TransferToBankFeatureAB page2 = new TransferToBankFeatureAB();

/*

*/
    @Test(priority = 1)
    public void TC_TTB_AB_03() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_03"));
        page2.TransferToBank("99999", "1234567");
//        Assertion.verifyEqual(login.getMessageFromAlertBox(),"You have insufficient balance to perform this transaction");
        page1.clickOnToolBarBckBtn();
    }

    @Test(priority = 2)
    public void TC_TTB_AB_01() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_01"));
        page2.TransferToBank("", "");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Please enter a valid amount!");
        page1.clickOnAlertOK().clickOnToolBarBckBtn();
    }

    @Test(priority = 3)
    public void TC_TTB_AB_02() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_02"));
        page2.TransferToBank("0.000", "1234567");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Please enter a valid amount!");
        page1.clickOnAlertOK().clickOnToolBarBckBtn();
    }
    @Test(priority = 4)
    public void TC_TTB_AB_04() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_04"));
        page2.TransferToBank("0.000", "1234567");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Please enter a valid amount!");
        page1.clickOnAlertOK().clickOnToolBarBckBtn();
    }

    @Test(priority = 5)
    public void TC_TTB_AB_05() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_05"));
        page2.TransferToBank("1", "");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Please enter a valid OTP");
        page1.clickOnAlertOK().clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 6)
    public void TC_TTB_AB_06() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_06"));
        page2.TransferToBank("1", "9876543");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Incorrect OTP; please try again");
        page1.clickOnAlertOK().clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 7)
    public void TC_TTB_AB_07() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_07"));
        page2.TransferToBank("1", "1234");
        Assertion.verifyEqual(login.getMessageFromAlertBox(), "Please enter a valid OTP");
        page1.clickOnAlertOK().clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 8)
    public void TC_TTB_AB_08() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_08"));
        page2.OtpReturn("1");
        Assertion.verifyEqual(page1.getOTPcancelFlowMsg(),"Cancel Flow?");
        page1.touchOutside().clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 9)
    public void TC_TTB_AB_09() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_09"));
        page2.OtpReturn( "1");
        page1.cancelOtpTxn();
        Assertion.verifyEqual(login.getWelcomeMessage(),"Welcome JOHN PAUL GUEVARRA");
    }

    @Test(priority = 10)
    public void TC_TTB_AB_010() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_010"));
        page2.OtpReturn("1");
        page1.retryOtpTxn();
        Assertion.verifyEqual(page1.getMessageFromOTPtitle(),"OTP Verification");
        page1.clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 11)
    public void TC_TTB_AB_011() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_011"));
        page2.OtpReturn("1");
        page1.retryOtpTxn().resend();
        Assertion.verifyContains(page1.getToast(),"OTP Veriﬁcation");
        page1.clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 12)
    public void TC_TTB_AB_012() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_TTB_AB_012"));
        page2.TransferToBank("1", "1234567");
        Assertion.verifyEqual(page1.getSucessMessage(), "Transfer Successful!");
        page1.getDetails();
        page1.clickonDone();
    }






}
