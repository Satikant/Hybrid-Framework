package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import globalConstants.Config;
import globalConstants.Constants;
import globalConstants.NumberConstants;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.Utils;

import static utils.CommonUtils.createMethodLabel;

/**
 * Created by ayush.singh on 19-08-2020.
 */
public class CustomerLoginAhliBank {

    LoginPageAhliBank loginPage = new LoginPageAhliBank();
    ForgotPinPageAhliBank fPinPage = new ForgotPinPageAhliBank();

    public CustomerLoginAhliBank login(String msisdn, String pin) {
        ExtentTest node = ExtentManager.getTest();
        try{
            createMethodLabel("Login Ahli Bank");
            if(Config.isFirstTimeLogin){
                //select Language
                /*loginPage.clickOnSITServer();*/
                loginPage.clickOnUATServer();
                loginPage.clickOnLoginButton();
                Config.setFirstTimeLoginFalse();
            }

            loginPage.setMobileNumber(msisdn).
                    setPin(pin).clickOnSubmitButton();
            if (loginPage.isDeviceChanged()) {
                changeDevice(msisdn, pin , Constants.AhlibankOTP);
            }

            loginPage.clickOnUpdateLater();

           if (loginPage.isAlertBoxPresent()) {
               loginPage.rejectBiometricAlert();
               if (loginPage.isWelcomeTextAvailable()){
                   Assertion.verifyContains(loginPage.getWelcomeMessage(),"Welcome,");
                   node.pass("Login Successful");
               }
               else {
                   node.fail("Failed to Login");
               }
           }

        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
        /*
        if (fPinPage.isForgotPinPresent()) {
            loginPage.clickOnLoginButton();
        }
        return this;*/
    }

    public CustomerLoginAhliBank acceptAlert(){
        if(loginPage.isAlertDialogOkButtonDisplayed()){
            loginPage.clickOnOk();
        }
        return this;
    }

    public CustomerLoginAhliBank changeDevice(String msisdn, String pin , String otp) {
        loginPage.clickOnVerifyOtp();
        if (fPinPage.isOTPFieldPresent()) {
            fPinPage.enterOtp(otp);
            if (fPinPage.isConfirmButtonpresent()) {
                fPinPage.clickOnConfirm();
            }
            if (fPinPage.isDialogBoxDisplayed()) {
                loginPage.clickOnOk();
            }
            loginPage
                    .setMobileNumber(msisdn)
                    .setPin(pin);
//                    .clickOnLoginButton();
        }
        return this;
    }

}

