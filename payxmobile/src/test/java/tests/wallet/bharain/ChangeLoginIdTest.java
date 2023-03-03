package tests.wallet.bharain;

import common.Assertion;
import framework.wallet.bharain.features.ChangeLoginIdFeature;
import framework.wallet.bharain.pageObjects.ChangeEmailIdPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import initializers.TestInit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;

import static globalConstants.Constants.BAHRAIN_OTP;
import static utils.GenerateRandomValue.*;


public class ChangeLoginIdTest extends TestInit {
    ChangeLoginIdFeature changeLoginIdFeature = new ChangeLoginIdFeature();
    ChangeEmailIdPage changeEmailIdPage = new ChangeEmailIdPage();
    LoginPageBharain loginPage = new LoginPageBharain();
    String text = "";
    String EMAIL_DOMAIN = "@gmail.com";

    @AfterMethod
    public void changeEmail() {
        changeLoginIdFeature.afterMethod();
    }

    /*@AfterClass(alwaysRun = true)
    public void logOut(){
        ProfileDetailsFeature.logOut();
    }*/

    @Test(priority = 191)
    public void TC_CL_001() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_001"));
        text = getRandomAlphabeticValue(4);
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, BAHRAIN_OTP);
        Assertion.verifyContains(changeEmailIdPage.getTxnStatus(), text + EMAIL_DOMAIN);
        Assertion.verifyEqual(changeEmailIdPage.getPassFail(), MessageReader.getMessage("ERRMSG_0069"));
    }

    // @Test(priority=192)
    public void TC_CL_002() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_002"));
        Config.toastCheck = true;
        changeLoginIdFeature.changeLoginId(getRandomAlphaNumericValue(5), BAHRAIN_OTP);
    }

    @Test(priority = 193)
    public void TC_CL_003() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_005"));
        text = getRandomIntValue(5);
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, BAHRAIN_OTP);
        Assertion.verifyContains(changeEmailIdPage.getTxnStatus(), text + EMAIL_DOMAIN);
        Assertion.verifyEqual(changeEmailIdPage.getPassFail(), MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test(priority = 194)
    public void TC_CL_004() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_006"));
        text = getRandomAlphaNumericValue(5);
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, BAHRAIN_OTP);
        Assertion.verifyContains(changeEmailIdPage.getTxnStatus(), text + EMAIL_DOMAIN);
        Assertion.verifyEqual(changeEmailIdPage.getPassFail(), MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test(priority = 195)
    public void TC_CL_005() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_007"));
        text = getRandomIntValue(3) + getRandomAlphabeticValue(2);
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, BAHRAIN_OTP);
        Assertion.verifyContains(changeEmailIdPage.getTxnStatus(), text + EMAIL_DOMAIN);
        Assertion.verifyEqual(changeEmailIdPage.getPassFail(), MessageReader.getMessage("ERRMSG_0069"));
    }

    @Test(priority = 196)
    public void TC_CL_006() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_003"));
        text = getRandomAlphabeticValue(4);
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, "");
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0071"));

    }

    @Test(priority = 197)
    public void TC_CL_007() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_004"));
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, getRandomIntValue(6));
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0072"));
    }

    @Test(priority = 198)
    public void TC_CL_008() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_008"));
        CommonUtils.pauseExecution(45);
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0088"));
    }

    @Test(priority = 199)
    public void TC_CL_009() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_009"));
        changeEmailIdPage.clickOnVerify();
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0089"));
    }

    @Test(priority = 200)
    public void TC_CL_010() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_010"));
        changeEmailIdPage.clickOnVerify();
        Assertion.verifyEqual(loginPage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0090"));
    }

    @Test(priority = 201)
    public void TC_CL_011() {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_CL_011"));
        changeLoginIdFeature.changeLoginId(text + EMAIL_DOMAIN, BAHRAIN_OTP);
        Assertion.verifyContains(changeEmailIdPage.getTxnStatus(), text + EMAIL_DOMAIN);
        Assertion.verifyEqual(changeEmailIdPage.getPassFail(), MessageReader.getMessage("ERRMSG_0069"));
    }

}