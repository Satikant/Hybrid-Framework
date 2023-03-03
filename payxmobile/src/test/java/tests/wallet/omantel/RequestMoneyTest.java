package tests.wallet.omantel;


import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.omantel.features.RequestMoneyFeature;
import framework.wallet.omantel.features.SendMoneyFeature;
import framework.wallet.omantel.pageObjects.LoginPage;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class RequestMoneyTest extends TestInit {

    RequestMoneyFeature requestMoneyFeature=new RequestMoneyFeature();
    SendMoneyFeature sendMoneyFeature=new SendMoneyFeature();
    LoginPage loginPage=new LoginPage();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
        requestMoneyFeature.acceptAlert();
    }

    @Test(priority=70)
    public void TC00050() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0050"));
        Config.toastCheck=true;
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee), GenerateRandomValue.getRandomIntValue(0), GenerateRandomValue.getRandomIntValue(1));
    }

    @Test(priority=71)
    public void TC00051() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0051"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"99538712", GenerateRandomValue.getRandomIntValue(0));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0017"));
    }


    @Test(priority=73)
    public void TC00053() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0053"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),"1");
        // Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0018"));
    }

    @Test(priority=74)
    public void TC00054() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0054"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"99538712", "0");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0019"));
    }

    @Test(priority=75)
    public void TC00055() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0055"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"77123465", "4444");
    }

    @Test(priority=76)
    public void TC00056() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0056"));
            requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"99464646", "0.4");
          //  Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0024"));
    }

    @Test(priority=77)
    public void TC00057() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0057"));
        startNegativeTest();
            requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"99454545", "1");
          //  Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0025"));
    }

    @Test(priority=78)
    public void TC00058() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0058"));
        startNegativeTest();
            requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"77123499", "1");
           // Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0023"));
    }

    @Test(priority=81)
    public void TC00061() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0061"));
            requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "77123490", "1");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

    @Test(priority = 86)
    public void TC00066() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0066"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "77123465", "1");
    }
}
