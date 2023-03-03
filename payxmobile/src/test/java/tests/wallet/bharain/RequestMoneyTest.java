package tests.wallet.bharain;


import common.Assertion;
import entities.Subscriber;
import entities.Transaction;
import entities.User;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.features.RequestMoneyFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

import static utils.GenerateRandomValue.getRandomIntValue;
import static utils.GenerateRandomValue.getRandomIntValueWithPrefix;

public class RequestMoneyTest extends TestInit {

    RequestMoneyFeature requestMoneyFeature=new RequestMoneyFeature();
    LoginPageBharain loginPage=new LoginPageBharain();
    User payer = new Subscriber();
    User payee = new Subscriber();

    @AfterMethod(alwaysRun = true)
    public void acceptTheAlert()  {
        requestMoneyFeature.acceptAlert();
    }

    @AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }

    @Test(priority=70)
    public void TC00050() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0050"));
        Config.toastCheck=true;
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973", getRandomIntValue(0), getRandomIntValue(1));
    }

    @Test(priority=71)
    public void TC00051() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0051"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "973", "99538712", getRandomIntValue(0));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0017"));
    }

    @Test(priority=73)
    public void TC00053() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0053"));
            requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",getRandomIntValueWithPrefix(6,"00"),"1");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0018"));
    }

    @Test(priority=74)
    public void TC00054() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0054"));
          requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("B"), "0");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0019"));
    }

    @Test(priority=75)
    public void TC00055() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0055"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("B"), "4444");
    }

    @Test(priority=76)
    public void TC00056() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0056"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("BL"), "0.4");
            Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0024"));
    }

    @Test(priority=77)
    public void TC00057() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0057"));
            requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("S"), "1");
           Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0025"));
    }

    @Test(priority=78)
    public void TC00058() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0058"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT",payer,payee),"973",DataDriven.getUserByStatus("Y"), "1");
         Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0023"));
    }

    @Test(priority=79)
    public void TC00059() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0059"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "973", getRandomIntValue(8), "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

  /* // @Test(priority=80)
    public void TC00060() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0060"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "965", "77123490", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

    @Test(priority=81)
    public void TC00061() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0061"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "968", "77123490", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

    @Test(priority=82)
    public void TC00062() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0062"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "974", "77123490", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

    @Test(priority=83)
    public void TC00063() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0063"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "966", "77123490", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }

    @Test(priority=84)
    public void TC00064() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0064"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "971", "77123490", "1");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(),MessageReader.getMessage("ERRMSG_0026"));
    }*/

    @Test(priority=85)
    public void TC00065() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0065"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "973", DataDriven.getUserByStatus("B"), "1");
    }

    /*@Test(priority = 86)
    public void TC00066() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0066"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "968", "77123465", "1");
    }

    @Test(priority = 87)
    public void TC00067() throws IOException, InterruptedException
    {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0067"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "965", "77123465", "1");
    }

    @Test(priority = 88)
    public void TC00068() throws IOException, InterruptedException
    {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0068"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "974", "77123465", "1");
    }

    @Test(priority = 89)
    public void TC00069() throws IOException, InterruptedException
    {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0069"));
        requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "966", "77123465", "1");
    }

    @Test(priority = 90)
    public void TC00070() throws IOException, InterruptedException
    {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC0070"));
            requestMoneyFeature.requestMoney(new Transaction("P2POUT", payer, payee), "971", "77123465", "1");
            ProfileDetailsFeature profileDetailsFeature = new ProfileDetailsFeature();
            profileDetailsFeature.logOut();

    }*/

}
