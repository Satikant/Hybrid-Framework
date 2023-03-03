package tests.wallet.bharain;

import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.features.SendMoneyFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.MobileProperties;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class SendMoneyTest extends TestInit{
    SendMoneyFeature sendMoneyFeature = new SendMoneyFeature();
    LoginPageBharain loginPage=new LoginPageBharain();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
        sendMoneyFeature.acceptAlert();
    }

    @AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }

    @Test(priority=30)
    public void TC00017() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0017"));
        Config.toastCheck=true;
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",GenerateRandomValue.getRandomIntValue(0), GenerateRandomValue.getRandomIntValue(1));
    }

    @Test(priority=31)
    public void TC00018() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0018"));
        sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "973", "99538712", GenerateRandomValue.getRandomIntValue(0));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0017"));
    }

    @Test(priority=33)
    public void TC00020() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0020"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",GenerateRandomValue.getRandomIntValueWithPrefix(6,"00"),"1");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0018"));
    }

    @Test(priority=34)
    public void TC00021() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0021"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("B"), "0");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0019"));
    }

    @Test(priority=35)
    public void TC00022() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0022"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("B"), "350");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0020"));
    }

    @Test(priority=36)
    public void TC00023() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0023"));
        startNegativeTest();
        sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("BL"), "0.4");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0021"));
    }

    @Test(priority=37)
    public void TC00024() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0024"));
            sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("S"), "1");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0022"));
    }

   @Test(priority=38)
    public void TC00025() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0025"));
        startNegativeTest();
           sendMoneyFeature.sendMoney(new Transaction("P2POUT",payer,payee),"973", DataDriven.getUserByStatus("Y"), "1");
           Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0023"));
    }

   @Test(priority=39)
    public void TC00026() throws IOException, InterruptedException {
       ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0026"));
           sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "973", DataDriven.getUserByStatus("B"), "1");
    }

     /*  @Test(priority = 40)
       public void TC00027 () throws IOException, InterruptedException {
           ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0027"));
               sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "968", "78451296", "1");
               //sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "968", "99347801", "1");
       }

       @Test(priority = 41)
       public void TC00028 () throws IOException, InterruptedException
       {
           ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0028"));
               sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "965", "78451296", "1");
       }

       @Test(priority = 42)
       public void TC00029 () throws IOException, InterruptedException
       {
           ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0029"));
               sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "974", "78451296", "1");
       }

       @Test(priority = 43)
       public void TC00030 () throws IOException, InterruptedException
       {
           ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0030"));
           sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "966", "78451296", "1");
       }

       @Test(priority = 44)
       public void TC00031 () throws IOException, InterruptedException
       {
           ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0031"));
               sendMoneyFeature.sendMoney(new Transaction("P2POUT", payer, payee), "971", "78451296", "1");
          //     ProfileDetailsFeature profileDetailsFeature = new ProfileDetailsFeature();
          //     profileDetailsFeature.logOut();
   }*/
}
