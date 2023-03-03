package tests.wallet.palestineArabBank;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.palestineArabBank.features.MerchantPayFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class MerchantPayTestPalestine  extends TestInit {

    MerchantPayFeaturePalestine MerchPay = new MerchantPayFeaturePalestine();
    LoginPagePalestine loginPage = new LoginPagePalestine();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() {
        MerchPay.acceptAlert();
    }

    @Test(priority=1)
    public void TC_MPay_001() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_001"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(0), GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0046"));
    }

    @Test(priority=2)
    public void TC_MPay_002() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_002"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(6), GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0046"));
    }

    @Test(priority=3)
    public void TC_MPay_003() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_003"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValueWithPrefix(8,"0"), GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0047"));
    }

    @Test(priority=4)
    public void TC_MPay_004() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_004"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), "956956956", GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0048"));
    }

    @Test(priority=5)
    public void TC_MPay_005() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_005"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValueWithPrefix(8,"9"), "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test(priority=6)
    public void TC_MPay_006() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_006"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValueWithPrefix(8,"9"), "0");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0070"));
    }

    @Test(priority=7)
    public void TC_MPay_007() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_007"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), "978978978", "5000");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0051"));
    }

    @Test(priority=8)
    public void TC_MPay_008() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_008"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), "978978978", "999999");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0051"));
    }

    @Test(priority=9)
    public void TC_MPay_009() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_009"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee),"978978978", "1");
    }

    @Test(priority=10)
    public void TC_MPay_010() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MPay_010"));
        MerchPay.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValueWithPrefix(8,"9"), GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0078"));
    }



}
