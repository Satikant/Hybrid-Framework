package tests.wallet.bharain;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.bharain.features.MerchantPaymentFeature;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class MerchantPaymentTest extends TestInit {

    MerchantPaymentFeature merchantPaymentFeature = new MerchantPaymentFeature();
    LoginPageBharain loginPage = new LoginPageBharain();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert() {
        merchantPaymentFeature.acceptAlert();
    }

    @AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }

    @Test(priority=131)
    public void TC_MP_001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_001"));
        Config.setToastCheckTrue();
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(0), GenerateRandomValue.getRandomIntValue(1));
    }

    @Test(priority=132)
    public void TC_MP_002()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_002"));
        Config.setToastCheckTrue();
            merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(4), GenerateRandomValue.getRandomIntValue(1));
    }

    @Test(priority=133)
    public void TC_MP_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_003"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValueWithPrefix(2, "000000"), "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0086"));
    }

    @Test(priority=134)
    public void TC_MP_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_004"));
            merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), "77123479", "1");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0074"));
    }

    @Test(priority=135)
    public void TC_MP_005()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_005"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(8), GenerateRandomValue.getRandomIntValue(1));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),  MessageReader.getMessage("ERRMSG_0073"));
    }

    @Test(priority=136)
    public void TC_MP_006()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_006"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), "545456566", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0087"));
    }

    @Test(priority=137)
    public void TC_MP_007()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_007"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(8), "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0061"));
    }

    @Test(priority=138)
    public void TC_MP_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_008"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), GenerateRandomValue.getRandomIntValue(8), "0");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0062"));
    }

    @Test(priority=139)
    public void TC_MP_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_009"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), "545456566", "1500");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0063"));
    }

    @Test(priority=140)
    public void TC_MP_010()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_010"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee), "545456566", "9999");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0063"));
    }

    @Test(priority=141)
    public void TC_MP_011()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_MP_011"));
        merchantPaymentFeature.MerchantPay(new Transaction("MerchPay", payer, payee),"31067812", "1");
    }

}
