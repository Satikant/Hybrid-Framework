package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.MerchantLoginPageAB;
import framework.wallet.omantel.pageObjects.LoginPage;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import static utils.CommonUtils.createMethodLabel;

public class MerchantLoginFeatureAB {

    MerchantLoginPageAB loginPage = new MerchantLoginPageAB();
    ForgotPinPageAhliBank fPinPage = new ForgotPinPageAhliBank();

    public MerchantLoginFeatureAB login(String msisdn, String pin) {
        ExtentTest node = ExtentManager.getTest();
        try{
            createMethodLabel("Login Ahli Bank Merhant");
            if(Config.isFirstTimeLogin){
                loginPage.clickOnUATServer();
                loginPage.clickOnLoginButton();
                Config.setFirstTimeLoginFalse();
            }
            loginPage.setMobileNumber(msisdn).
                    setPin(pin).clickOnSubmitButton();

           /* if (loginPage.isDeviceChanged()) {
                changeDevice(msisdn, pin);
            }*/
            CommonUtils.pauseExecution(2);
            if (loginPage.isAlertBoxPresent()) {
                loginPage.rejectBiometricAlert();
                loginPage.clickOnSubmitButton();
                /*if(loginPage.isLoginBtnPresent()) {

                }
                else*/
                if (loginPage.isWelcomeTextAvailable()) {
                    Assertion.verifyContains(loginPage.getWelcomeMessage(), "Welcome");
                    node.pass("Login Successful");
                } else {
                    node.pass("Failed to Login");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public MerchantLoginFeatureAB acceptAlert(){
        if(loginPage.isAlertDialogOkButtonDisplayed()){
            loginPage.clickOnOk();
        }
        return this;
    }


   /* public MerchantLoginFeatureAB changeDevice(String msisdn, String pin) {
        loginPage.clickOnVerifyOtp();
        if (fPinPage.isOTPFieldPresent()) {
            fPinPage.enterOtp("1234567");
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
    }*/

}

