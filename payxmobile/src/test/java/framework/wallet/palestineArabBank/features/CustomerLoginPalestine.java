package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.jcraft.jsch.JSchException;
import common.Assertion;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import globalConstants.Config;
import globalConstants.Constants;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;

import java.io.IOException;

import static utils.CommonUtils.createMethodLabel;

public class CustomerLoginPalestine {

    LoginPagePalestine loginpage = new LoginPagePalestine();

    public CustomerLoginPalestine Login(String mobNo, String pin) {
        ExtentTest node = ExtentManager.getTest();
        try {
            createMethodLabel("Login");
            if (Config.isFirstTimeLogin) {
                Config.setFirstTimeLoginFalse();
            }
            loginpage.
                    setMsisdn(mobNo).
                    setPin(pin).
                    clickOnLogin();

            if (Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
                loginpage.isFingerSensorChoiceDisplayed();
                Assertion.verifyEqual(loginpage.getMsgFromDialogBox(), MessageReader.getMessage("COMVALMSG_001"));
                loginpage.clickNoOnFingerSensor();
                if (loginpage.isShowBalanceDisplayed()) {
                    node.pass("Login Successful");
                } else {
                    node.fail("Failed to Login");
                }
                CommonUtils.captureScreenMobile(node, "");
            }
        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public CustomerLoginPalestine DeviceChange(String otp, String SecurityAns)  {

        try {
            if (loginpage.isSnackbarDisplayed()) {
                Assertion.verifyEqual(loginpage.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0086"));
                loginpage.clickOnsnackbarButton();
            } else
                loginpage.enterOtp(otp).VerifyOtp();                         //for entering the OTP
            CommonUtils.pauseExecution(1);
            if (loginpage.isSnackbarDisplayed()) {           //if entered OTP is incorrect
                //  CommonUtils.pauseExecution(3);
                return this;
            } else if (loginpage.isSecurityQuesDisplayed()) {                 //for entering Security Answer
                loginpage.SetSecAns(SecurityAns).DevNextbtn();

                if (loginpage.isSnackbarDisplayed()) {                           //if entered Security Answer is incorrect
                    return this;

                }
            }
            return this;
        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }


    public void acceptAlert() {
        ExtentTest node = ExtentManager.getTest();
        try {
            if (loginpage.isSnackbarDisplayed()) {
                loginpage.clickOnsnackbarButton();
            }
            if (loginpage.isClickOnTryDisplayed()) {
                loginpage.clickOnTryButton();
            }
            else{

            }
        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}


