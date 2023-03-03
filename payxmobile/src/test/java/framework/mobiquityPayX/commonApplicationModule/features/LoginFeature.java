package framework.mobiquityPayX.commonApplicationModule.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.CommonFeaturesPageObject;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.LoginPageObject;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class LoginFeature extends CommonFeaturesPageObject {

    LoginPageObject login = new LoginPageObject();

    public void login(String msisdn, String pin, String otp) {
        ExtentTest node = ExtentManager.getTest();
        try{
            if(login.isMsisdnFieldPresent()){
                login.setPinForLoggedInUser(pin).clickOnLoginButton();
            }
            else {
                login.setMobileNumber(msisdn).setPin(pin);
                //setOtp(otp,msisdn);
                login.getFocus().clickOnLoginButton();
            }
            if (Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
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
