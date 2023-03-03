package tests.wallet.ahliBank;


import common.Assertion;
import framework.wallet.ahliBank.features.RefundFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.MerchantLoginPageAB;
import framework.wallet.ahliBank.pageObjects.RefundPageAhlibank;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;

import java.io.IOException;

public class RefundTestAhliBank extends TestInit {

    MerchantLoginPageAB login = new MerchantLoginPageAB();
    RefundPageAhlibank page1 = new RefundPageAhlibank();
    RefundFeatureAhliBank page2 = new RefundFeatureAhliBank();

    @Test(priority = 1)
    public void TC_MR_AB_01() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_01"));
        page2.Refund("", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"Request parameters cannot be empty!");
    }

    @Test(priority = 2)
    public void TC_MR_AB_02() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_02"));
        page2.Refund("ABQ2011251539078", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"Records not found");

    }

    @Test(priority = 3)
    public void TC_MR_AB_03() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_03"));
        page2.Refund("201125153907", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"Records not found");

    }

    @Test(priority = 4)
    public void TC_MR_AB_04() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_04"));
        page2.Refund("ABQA20301127263", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"Transaction already refunded");
    }

    @Test(priority = 5)
    public void TC_MR_AB_05() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_05"));
        page2.Refund("2011251539078218", "1234567");
        Assertion.verifyEqual(page1.getSucessMessage(),"");
    }

    @Test(priority = 6)
    public void TC_MR_AB_06() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_06"));
        page2.Refund("2011251539078218", "1234567");
        Assertion.verifyEqual(page1.getSucessMessage(),"");

    }

    @Test(priority = 7)
    public void TC_MR_AB_07() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_07"));
        page2.Refund("2011251539078218", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"");

    }

    @Test(priority = 8)
    public void TC_MR_AB_08() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_08"));
        page2.Refund("2011251539078218", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"");
        page1.getDetails(); page1.clickonDone();
    }

    @Test(priority = 9)
    public void TC_MR_AB_09() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_09"));
        page2.Refund("2011251539078218", "");
        Assertion.verifyEqual(page1.getSucessMessage(),"");
        page1.getDetails(); page1.clickonDone();
    }

    @Test(priority = 10)
    public void TC_MR_AB_010() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_010"));
        page2.OtpReturn("");
        Assertion.verifyEqual(page1.getOTPcancelFlowMsg(),"Cancel Flow?");
        page1.touchOutside().clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 11)
    public void TC_MR_AB_011() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_011"));
        page2.OtpReturn( "1");
        page1.cancelOtpTxn();
        Assertion.verifyEqual(login.getWelcomeMessage(),"Welcome, JOHN PAUL GUEVARRA LAO");
    }

    @Test(priority = 12)
    public void TC_MR_AB_012() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_012"));
        page2.OtpReturn("1");
        page1.retryOtpTxn();
        Assertion.verifyEqual(page1.getMessageFromOTPtitle(),"OTP Verification");
        page1.clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 13)
    public void TC_MR_AB_013() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_013"));
        page2.OtpReturn("1");
        page1.retryOtpTxn().resendotp();
//        Assertion.verifyContains(page1.getToast(),"OTP Veriﬁcation");
        page1.clickOnOtpCancel().cancelOtpTxn();
    }

    @Test(priority = 14)
    public void TC_MR_AB_014() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MR_AB_014"));
        page2.Refund("2011251539078218", "1234567");
//        Assertion.verifyEqual(page1.getSucessMessage(),"");
        page1.getDetails(); page1.clickonDone();
    }

}
