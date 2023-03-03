package tests.wallet.ahliBank;

import common.Assertion;
import framework.wallet.ahliBank.features.CustomerLoginAhliBank;
import framework.wallet.ahliBank.features.ManageFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.ManagePageAhliBank;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.Utils;

import java.io.IOException;


public class ManageTestAhliBank extends TestInit {

    ManagePageAhliBank managePage = new ManagePageAhliBank();
    CustomerLoginAhliBank custLogin = new CustomerLoginAhliBank();
    ManageFeatureAhliBank manageFeature = new ManageFeatureAhliBank();

    String defautNumber = "77216271";
    String defaultMPin  ="258014";

    public ManageTestAhliBank() throws InterruptedException {
    }

    @Test
    public void TC_AB_MB_001() throws InterruptedException, IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AB_MB_001"));
        manageFeature.viewManageBeneficiary();
        Assertion.verifyEqual("", "");
    }

    @Test
    public void TC_AB_MB_002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AB_MB_002"));
        custLogin.login(defautNumber, defaultMPin);
        Utils.rightLeftSwipe(2000);
        manageFeature.deleteManageBeneficiary();
//        Assertion.verifyEqual("","");
        Assertion.verifyEqual(managePage.getDeleteMessage(),"Are you sure you want to delete this beneficiary?");
    }

    @Test
    public void TC_AB_MB_003() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AB_MB_003"));
        custLogin.login(defautNumber, defaultMPin);
        Utils.rightLeftSwipe(2000);
        manageFeature.delete1ManageBeneficiary();
        Assertion.verifyEqual("","");
    }

    @Test
    public void TC_AB_MB_004() throws InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_AB_MB_004"));
        custLogin.login(defautNumber, defaultMPin);
        Utils.rightLeftSwipe(2000);
        manageFeature.delete2ManageBeneficiary();
        Assertion.verifyEqual("","");
    }

//    @Test
//    public void TC_AB_MB_005() {
//
//    }


}
