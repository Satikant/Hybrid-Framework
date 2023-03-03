package tests.mobiquityPayX.payXSmoke;

import framework.mobiquityPayX.payX.PageObjects.payXLoginPageObjects;
import framework.mobiquityPayX.payX.feature.payXLoginFeature;
import framework.mobiquityPayX.payX.feature.anotherUserFeature;
import framework.mobiquityPayX.payX.feature.*;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;

public class payXSmokeTest1 extends TestInit {

    payXLoginPageObjects loginPage = new payXLoginPageObjects();
    payXLoginFeature loginFeature = new payXLoginFeature();
    anotherUserFeature loginAnother = new anotherUserFeature();
    rechargeFeature recharge = new rechargeFeature();
    HomescreenFeature homescreenFeature = new HomescreenFeature();
    SecurityQuestionFeature securityQues = new SecurityQuestionFeature();
    WithdrawCashFeature withdrawCash = new WithdrawCashFeature();
    SecurityQuesSelectFeature selectSecQues = new SecurityQuesSelectFeature();


    HamburgerMenuFeature hambergerFeature = new HamburgerMenuFeature();
    AddMoneyFeature addmoneyfeature = new AddMoneyFeature();
    WalletFeature walletfeature = new WalletFeature();

/*    @AfterMethod
    public void AcceptDialogBox(){
        loginFeature.DialogBox();
    }*/

;

    @Test(priority = 1)
    public void AddMoney() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_06"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
        loginFeature.DialogBox();
        homescreenFeature.addmoney();
        addmoneyfeature.AddingMoney();
    }

    @Test(priority = 2)
    public void Interwallettransfer(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_16"));
        homescreenFeature.clickonWallet();
        walletfeature.walletflow();
    }

    @Test(priority = 3)
    public  void  loginWithAnotherUser() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_08"));
        startPositveTest();
        loginAnother.loginWithAnotherUser("7773811064","1357");
    }

    @Test(priority = 4)
    public void Recharge() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_01"));
        startPositveTest();
        recharge.recharge("8249020205","50", "1357");
    }


    @Test(priority = 5)
    public  void  setSecurityQus(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_15"));
        startPositveTest();
        securityQues.securityQus("1357","aaaaaaaaaa","bbbbbbbbbb");
    }

    @Test(priority = 6)
    public  void  selectSecurityQus(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_17"));
        startPositveTest();
        selectSecQues.securityQSelect(DataDriven.getUserPinByStatus("Y"));
    }


    /// This SMOKE_TC_05 is Last TestCases, Don't change position beacuse this case is contain Logout scenario....

    @Test(priority = 7)
    public  void  withdrawCash(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_05"));
        startPositveTest();
        withdrawCash.withdrawCashtest("7779905214","1","1357");
    }


}
