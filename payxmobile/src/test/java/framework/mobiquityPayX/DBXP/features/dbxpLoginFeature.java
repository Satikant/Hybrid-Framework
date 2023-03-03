package framework.mobiquityPayX.DBXP.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.DBXP.pageObjects.DBXPLoginPageObjects;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.CommonFeaturesPageObject;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.LoginPageObject;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class dbxpLoginFeature extends DBXPLoginPageObjects {

    DBXPLoginPageObjects login = new DBXPLoginPageObjects();

    public void login(String msisdn, String pin) {
        ExtentTest node = ExtentManager.getTest();
        try{
            if(login.isMsisdnFieldPresent()){
                login.setMobileNumber(msisdn).setPin(pin);
                //setOtp(otp,msisdn);
                login.clickOnLoginButton();
            }
            else {
                login.setPinForLoggedInUser(pin).clickOnLoginButton();
            }
            if (Config.FirstTimeLogin)
            {
                Config.FirstTimeLoginFalse();

                if(login.isHomePageDisplayed())
                {
                    Assertion.verifyContains(login.getWelcomeText(), "Sync");
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
