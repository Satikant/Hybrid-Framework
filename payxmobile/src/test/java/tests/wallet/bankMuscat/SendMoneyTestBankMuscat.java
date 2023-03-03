package tests.wallet.bankMuscat;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.bankMuscat.features.SendMoneyFeatureBankMuscat;
import framework.wallet.bankMuscat.pageObjects.SendMoneyPageBankMuscat;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.MessageReader;

import java.io.IOException;

public class SendMoneyTestBankMuscat extends TestInit{
    SendMoneyFeatureBankMuscat sendMoneyFeature = new SendMoneyFeatureBankMuscat();
    SendMoneyPageBankMuscat sendMoneyPageBankMuscat=new SendMoneyPageBankMuscat();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
     //   sendMoneyFeature.
    }

    @Test(priority=30)
    public void TC00017() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0017"));
        startNegativeTest();
            sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","","1","Automation");
            Assertion.verifyEqual(sendMoneyPageBankMuscat.getMessageFromDevice(), MessageReader.getMessage("ERR7"));
    }

    @Test(priority=31)
    public void TC00018() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0018"));
        startNegativeTest();
            sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77334546","","Automation");
            Assertion.verifyEqual(sendMoneyPageBankMuscat.getMessageFromDevice(), MessageReader.getMessage("ERR8"));
    }

   @Test(priority=32)
    public void TC00019() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0019"));
            sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77334546","1","");
    }

    @Test(priority=33)
    public void TC00020() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0020"));
            sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","55667788","1","Automation");
            Assertion.verifyEqual(sendMoneyPageBankMuscat.getMessageFromDevice(), MessageReader.getMessage("ERR9"));
    }

    @Test(priority=34)
    public void TC00021() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0021"));
            sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77565656","0","Automation");
            Assertion.verifyEqual(sendMoneyPageBankMuscat.getMessageFromDevice(), MessageReader.getMessage("ERR8"));
    }

    @Test(priority=35)
    public void TC00022() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0022"));
        sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77565656","123456789","Automation");
    }

    @Test(priority=36)
    public void TC00023() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0023"));
        startNegativeTest();
        sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77565681","1","Automation");
    }

    @Test(priority=37)
    public void TC00024() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0024"));
        startNegativeTest();
        sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77885544","1","Automation");
    }

   @Test(priority=38)
    public void TC00025() throws IOException, InterruptedException {
       ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0025"));
       startNegativeTest();
       sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT",payer,payee),"14709","77123478","1","Automation");
       Assertion.verifyEqual(sendMoneyPageBankMuscat.getMessageFromDevice(), MessageReader.getMessage("ERR10"));

    }

   @Test(priority=39)
    public void TC00026() throws IOException, InterruptedException {
       ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0026"));
       sendMoneyFeature.performSendMoneyToMobileNo(new Transaction("P2POUT", payer, payee), "14709", "77665544", "1", "Automation");
    }

   }
