package tests.wallet.bharain;

import common.Assertion;
import framework.wallet.bharain.features.DonationFeature;
import framework.wallet.bharain.features.ProfileDetailsFeature;
import framework.wallet.bharain.features.SplitBillFeature;
import framework.wallet.bharain.pageObjects.DonationPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import initializers.TestInit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;

import java.io.IOException;

public class DonationTest extends TestInit {

    DonationFeature donationFeature = new DonationFeature();
    LoginPageBharain lPage = new LoginPageBharain();

    @AfterMethod
    public void acceptAlert() throws InterruptedException {
        donationFeature.acceptAlert();
        CommonUtils.pauseExecution(2);
    }

    /*@AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }*/

    @Test(priority=171)
    public void TC_Donation_001() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_001"));
        donationFeature.Donation("0.001", Boolean.FALSE);
        }

    @Test(priority=172)
    public void TC_Donation_002() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_002"));
        donationFeature.Donation("", Boolean.FALSE);
        Assertion.verifyEqual(lPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0061"));
    }

    @Test(priority=173)
    public void TC_Donation_003() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_003"));
        donationFeature.Donation("0.001", Boolean.FALSE);
        }

    @Test(priority=174)
    public void TC_Donation_004() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_004"));
        donationFeature.Donation("0", Boolean.FALSE);
        Assertion.verifyEqual(lPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0062"));
    }

    @Test(priority=175)
    public void TC_Donation_005() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_005"));
        donationFeature.Donation("0.001", Boolean.TRUE);
    }

    @Test(priority=176)
    public void TC_Donation_006() throws IOException, InterruptedException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Donation_006"));
        donationFeature.Donation("1000", Boolean.FALSE);
        Assertion.verifyEqual(lPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0063"));
    }
}