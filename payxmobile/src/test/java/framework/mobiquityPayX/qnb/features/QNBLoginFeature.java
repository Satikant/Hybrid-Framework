package framework.mobiquityPayX.qnb.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.CommonFeaturesPageObject;
import framework.mobiquityPayX.qnb.pageObjects.QNBLoginPageObjects;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class QNBLoginFeature extends CommonFeaturesPageObject {

    QNBLoginPageObjects login = new QNBLoginPageObjects();

    public void login(String msisdn, String pin, String otp) {
        ExtentTest node = ExtentManager.getTest();
        try{
            login.setMobileNumber(msisdn).setPin(pin).clickOnLoginButton();
            if (Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
                    /*setOtp(otp,"LOGIN_POLICY");
                    CommonUtils.captureScreenMobile(node,"OTP Screen");
                    clickOnVerifyOtp();*/
                if(login.isHomePageDisplayed()){
                    Assertion.verifyContains(login.getWelcomeText(), "Welcome");
                }
        }
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }

    public void AcceptDialogBox(){
        if(login.isValidationDialogBoxDisplayed()){
            login.clickOnOkButton();
        }
    }
}
