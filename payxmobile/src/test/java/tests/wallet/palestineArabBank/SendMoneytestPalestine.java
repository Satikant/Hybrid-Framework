package tests.wallet.palestineArabBank;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.palestineArabBank.features.SendMoneyFeaturePalestine;
import framework.wallet.palestineArabBank.pageObjects.ChangePinPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.SendMoneyPagePalestine;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;
public class SendMoneytestPalestine extends TestInit {

    @AfterMethod
            public void accpetAlert(){
feature.acceptAlert();
    }

    SendMoneyFeaturePalestine feature =new SendMoneyFeaturePalestine();
    SendMoneyPagePalestine page2 = new SendMoneyPagePalestine();
    User payer= new Subscriber();
    User payee= new Subscriber();
    ChangePinPagePalestine page = new ChangePinPagePalestine();

    @Test
    public void TC_SM_001()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0017"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", "", Constants.DEFAULT_AMOUNT);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0046"));
    }

    @Test
    public void TC_SM_002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0018"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", GenerateRandomValue.getRandomIntValue(9), "");
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test
    public void TC_SM_003()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0019"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", GenerateRandomValue.getRandomIntValue(5), Constants.DEFAULT_AMOUNT);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0046"));
    }

    @Test
    public void TC_SM_004()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0020"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", "000000000", Constants.DEFAULT_AMOUNT);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0047"));
    }

    @Test
    public void TC_SM_005() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0021"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", GenerateRandomValue.getRandomIntValue(9), "0");
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0070"));
    }

    @Test
    public void TC_SM_006() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0022"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", GenerateRandomValue.getRandomIntValue(9), "10000.00");
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0051"));
    }

    @Test
    public void TC_SM_007() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0023"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", "956956956", Constants.DEFAULT_AMOUNT);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_008"));
    }

    @Test
    public void TC_SM_008()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0024"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", "369852147", Constants.DEFAULT_AMOUNT);
        Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0071"));
    }

    @Test
    public void TC_SM_009()  {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0025"));
       feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", "222222222", Constants.DEFAULT_AMOUNT);
       Assertion.verifyEqual(page.getErrMsg(), MessageReader.getMessage("ERRMSG_0072"));
   }

    @Test
    public void TC_SM_010() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0026"));
        feature.sendMoney(new Transaction("P2POUT",payer,payee),"973", GenerateRandomValue.getRandomIntValue(9), "1.00");
    }


}
