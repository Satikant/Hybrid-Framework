package framework.wallet.omantel.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.omantel.pageObjects.LoginPage;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.LogReader;
import utils.MessageReader;

import java.io.IOException;

import static utils.CommonUtils.createMethodLabel;


public class CustomerLogin {
    LoginPage page = new
            LoginPage();

    //-----------------------OMANTEL-----------------------
    public CustomerLogin Login(String mobNo, String pin) throws  InterruptedException {
        ExtentTest node = ExtentManager.getTest();
        try{
            createMethodLabel("Login");
            if(MobileProperties.getProperty("application.name").equalsIgnoreCase("AFS") && Config.isFirstTimeLogin) {
                Config.setFirstTimeLoginFalse();
                if (Config.chaneLanguageCounter == 1) {
                    page.clickOnSkipButton();
                    System.out.println("SKIP COUNTER VALUE : " + Config.chaneLanguageCounter);
                    page.selectLanguage();
                } else {
                    System.out.println("SKIP COUNTER VALUE : " + Config.chaneLanguageCounter);
                }
            }
            page.
                    clearFields().
                    setMsisdn(mobNo).
                    setPassword(pin);
            page.clickOnLogin();
            if(Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
                page.isFingerSensorChoiceDisplayed();
                Assertion.verifyEqual(page.getMsgFromDialogBox(), MessageReader.getMessage("COMVALMSG_001"));
                page.clickNoOnFingerSensor();
                //logReader.getMwalletLog();
                if (page.isShowBalanceDisplayed()){
                    node.pass("Login Successful");
                }
                else {
                    node.fail("Failed to Login");
                }
                CommonUtils.captureScreenMobile(node, "");

            }
        }

               catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void acceptAlertOman() throws  InterruptedException {
        try {
            if (page.isSnackbarDisplayed()) {
                page.clickOnsnackbarButton();
            } else if (page.isClickOnTryDisplayed()) {
                page.clickOnTryButton();
            }
        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
