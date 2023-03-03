package framework.mobiquityPayX.asiaHawala.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.asiaHawala.pageObjects.AHLoginPageObject;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class AHLoginFeature {
    AHLoginPageObject login = new AHLoginPageObject();

    public void login(String msisdn, String pin) {
        try{
            login.setMobileNumber(msisdn).setPin(pin).getFocus().clickOnLoginButton();
            if (Config.FirstTimeLogin) {
                Config.FirstTimeLoginFalse();
                if(login.isHomePageDisplayed()){
                    Assertion.verifyContains(login.getWelcomeText(), "Welcome");
                }
            }

        }
        catch (Exception e){
            ExtentTest node = ExtentManager.getTest();
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
