package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;

import static utils.CommonUtils.createMethodLabel;


public class CustomerLoginBharain {
    LoginPageBharain page = new LoginPageBharain();

    public CustomerLoginBharain Login(String mobNo, String pin) {
        ExtentTest node = ExtentManager.getTest();
        try {
            createMethodLabel("Login");
            if (Config.isFirstTimeLogin) {
                Config.setFirstTimeLoginFalse();
                if (Config.chaneLanguageCounter == 0) {
                    page.selectLanguage();
                }
            }
            page.
                    clearFields().
                    setMsisdn(mobNo).
                    setPassword(pin);
            page.clickOnLogin();
            if (Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
                page.isFingerSensorChoiceDisplayed();
                Assertion.verifyEqual(page.getMsgFromDialogBox(), MessageReader.getMessage("COMVALMSG_001"));
                page.clickNoOnFingerSensor();
                //logReader.getMwalletLog();
                if (page.isShowBalanceDisplayed()) {
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

    public CustomerLoginBharain DeviceChange(String otp, String SecurityAns) {

        try {
//            if(page.isSnackbarDisplayed()){
//                Assertion.verifyEqual(page.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0086"));
//                page.clickOnsnackbarButton();
//            }
            page.enterOtp(otp).VerifyOtp();                         //for entering the OTP
//            CommonUtils.pauseExecution(1);
//            if (page.isSnackbarDisplayed())  {           //if entered OTP is incorrect
//                //  CommonUtils.pauseExecution(3);
//                return this;
//            }
//            else if (page.isSecurityQuesDisplayed()) {                 //for entering Security Answer
            page.SetSecAns(SecurityAns).DevNextbtn();

//                if (page.isSnackbarDisplayed()) {                           //if entered Security Answer is incorrect
//                    return this;
//
//                }
            return this;

        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

        return this;
    }

    public void acceptAlertOman() {
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
