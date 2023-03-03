package tests.wallet.omantel;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.omantel.features.SendMoneyFeature;
import framework.wallet.omantel.pageObjects.LoginPage;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.MobileProperties;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class SendMoneyTest extends TestInit{
    SendMoneyFeature sendMoneyFeature = new SendMoneyFeature();
    LoginPage loginPage=new LoginPage();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
        sendMoneyFeature.acceptAlert();
    }

    @Test(priority=30)
    public void TC00017() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0017"));
        startNegativeTest();
        Config.toastCheck=true;
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),GenerateRandomValue.getRandomIntValue(0), GenerateRandomValue.getRandomIntValue(1));
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0016"));
    }

    @Test(priority=31)
    public void TC00018() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0018"));
        startNegativeTest();
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"99538712", GenerateRandomValue.getRandomIntValue(0));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0017"));
    }
    
    @Test(priority=33)
    public void TC00020() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0020"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),"1");
            //Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0018"));
    }
    
    @Test(priority=34)
    public void TC00021() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0021"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"99538712", "0");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0019"));
    }
    
    @Test(priority=35)
    public void TC00022() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0022"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"99538712", "350");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0020"));
    }

    @Test(priority=36)
    public void TC00023() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0023"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"99464646", "0.4");
        // Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0021"));
    }
    
    @Test(priority=37)
    public void TC00024() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0024"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"99454545", "1");
        //  Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0022"));
    }
    
   @Test(priority=38)
    public void TC00025() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0025"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"77123499", "1");
         //  Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0023"));
    }
   

    @Test(priority = 40)
    public void TC00027 () throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0027"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee),  "78451296", "1");
        //sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "968", "99347801", "1");
    }
    
}
