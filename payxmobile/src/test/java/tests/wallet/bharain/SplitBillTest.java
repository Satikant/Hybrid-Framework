package tests.wallet.bharain;

import common.Assertion;
import framework.wallet.bharain.features.SplitBillFeature;
import framework.wallet.bharain.pageObjects.SplitBillPage;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class SplitBillTest extends TestInit {
    SplitBillFeature spltBillFeature = new SplitBillFeature();
    SplitBillPage spltBillPage = new SplitBillPage();
    String groupName=GenerateRandomValue.getRandomAlphabeticValue(4);

    @AfterMethod
    public void acceptalert() throws InterruptedException {
        spltBillFeature.acceptAlert();
    }

    @AfterClass(alwaysRun = true)
    public void logOut(){
            ProfileDetailsFeature.logOut();
    }

    @Test(priority=100)
    public void TC_SpltBill_001() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_001"));
        spltBillFeature.splitBillFeature(groupName, GenerateRandomValue.getGroupOfMemberMsisdn(3,8), GenerateRandomValue.getGroupOfMemberName(3,4), 3, Constants.ADD);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0044"));
    }


    @Test

    public void TC_SpltBill_002() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_002"));
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(1,8), GenerateRandomValue.getGroupOfMemberName(1,4), 1, Constants.ADD);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0045"));
    }

    @Test(priority=102)
    public void TC_SpltBill_003() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_003"));
        spltBillFeature.splitBillFeature("", GenerateRandomValue.getGroupOfMemberMsisdn(3,9), GenerateRandomValue.getGroupOfMemberName(3,4), 3, Constants.ADD);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0046"));
    }

    @Test(priority=100)
    public void TC_SpltBill_004() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_004"));
        spltBillFeature.splitBillFeature(groupName, GenerateRandomValue.getGroupOfMemberMsisdn(3,9), GenerateRandomValue.getGroupOfMemberName(3,4), 3, Constants.ADD);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0047"));
    }

    @Test(priority=103)
    public void TC_SpltBill_005() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_005"));
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(3,8), GenerateRandomValue.getGroupOfMemberName(3,4), 3, Constants.ADD);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0048"));
    }

    @Test(priority=104)
    public void TC_SpltBill_006() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_006"));
        Config.toastCheck = true;
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(1,3), GenerateRandomValue.getGroupOfMemberName(1,4), 1, Constants.ADD);
    }

    @Test(priority=105)
    public void TC_SpltBill_007() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_007"));
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(8,8), GenerateRandomValue.getGroupOfMemberName(8,4), 8, Constants.ADD);
        Assertion.verifyContains(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0050"));
    }

    @Test(priority=106)
    public void TC_SpltBill_008() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_008"));
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(1,8), GenerateRandomValue.getGroupOfMemberName(1,4), 1, Constants.MODIFY);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0051"));
    }


    @Test
    public void TC_SpltBill_010() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_010"));
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(1,9), GenerateRandomValue.getGroupOfMemberName(1,4), 1, Constants.DELETE);
        Assertion.verifyContains(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0057"));
    }

    @Test(priority=109)
    public void TC_SpltBill_011() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,TestCases.getTestCase("TC_SB_011"));
        spltBillFeature.initiateSplitBill("2",Constants.REJECT);
        Assertion.verifyContains(MessageReader.getMessage("ERRMSG_0059"),spltBillPage.getTxnMsg());
    }

    @Test
    public void TC_SpltBill_009() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_SB_009"));
        Config.isDeleteMember = true;
        spltBillFeature.splitBillFeature("sdd", GenerateRandomValue.getGroupOfMemberMsisdn(0,9), GenerateRandomValue.getGroupOfMemberName(0,5), 0, Constants.MODIFY);
        Assertion.verifyContains(spltBillPage.getErrMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0051"));
    }
    @Test
    public void TC_SpltBill_012() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode,"TC_SB_012");
        Config.isDeleteMember = true;
        Config.isOneMemberPresent=true;
        spltBillFeature.splitBillFeature("sdd", GenerateRandomValue.getGroupOfMemberMsisdn(0,9), GenerateRandomValue.getGroupOfMemberName(0,5), 0, Constants.MODIFY);
        Assertion.verifyEqual(spltBillPage.getErrMsgFromDialogBox(),MessageReader.getMessage("ERRMSG_0044"));
        spltBillFeature.acceptAlert();
        spltBillFeature.splitBillFeature(GenerateRandomValue.getRandomAlphabeticValue(3), GenerateRandomValue.getGroupOfMemberMsisdn(2,9), GenerateRandomValue.getGroupOfMemberName(2,4), 2, Constants.MODIFY);
    }

//    @Test
//    public void TC_SpltBill_013() throws IOException, InterruptedException {
//        ExtentManager.startTestFromProperty(pNode,"TC_SB_013");
//        Config.checkNotification=true;
//        spltBillFeature.initiateSplitBill("2",Constants.ACCEPT);
////Assertion.verifyEqual(donationPage.fetchTxnStatus(),MessageReader.getMessage("ERRMSG_0060"));
////profileDetailsFeature.logOut();
// }
//
//    @Test
//    public void TC_SpltBill_014() throws IOException, InterruptedException {
//        ExtentManager.startTestFromProperty(pNode,"TC_SB_014");
//        Config.checkNotification=true;
//       spltBillFeature.initiateSplitBill("2",Constants.REJECT);
////profileDetailsFeature.logOut();
//    }
//
//    @Test
//    public void TC_SpltBill_015() throws IOException, InterruptedException {
//        ExtentManager.startTestFromProperty(pNode,"TC_SB_015");
//        Config.checkNotification=true;
//        spltBillFeature.initiateSplitBill("10000",Constants.ACCEPT);
//      //  profileDetailsFeature.logOut();
//    }
//
//    @Test
//    public void TC_SpltBill_016() throws IOException, InterruptedException {
//        ExtentManager.startTestFromProperty(pNode,"TC_SB_016");
//        Config.checkNotification=true;
//        spltBillFeature.initiateSplitBill("10000",Constants.REJECT);
//      //  profileDetailsFeature.logOut();
//    }
//
//    @Test
//    public void TC_SpltBill_017() throws IOException, InterruptedException {
//        ExtentManager.startTestFromProperty(pNode,"TC_SB_017");
//        Config.checkNotification=true;
//        spltBillFeature.initiateSplitBill("2",Constants.ACCEPT);
//
//    }

}