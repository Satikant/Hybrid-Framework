package framework.mobiquityPayX.commonApplicationModule.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.LogOutPageObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;

public class LogOutFeature {

    LogOutPageObject logOutPage = new LogOutPageObject();

    public LogOutFeature logOut(){
        ExtentTest node = ExtentManager.getTest();
        try{
            logOutPage.clickOnHamburgerMenu().clickOnLogOutIcon().clickOnLogOutConfrimButton();
            if(logOutPage.isForgotPinButtonPresent()){
                CommonUtils.captureScreenMobile(node,"Logout Screen");
                node.pass("User Has been Log out successfully");
            }
            else{
                node.fail("User has not been logged out");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

        return this;
    }

    public LogOutFeature loginWithAnotherAccount(){
        ExtentTest node = ExtentManager.getTest();
        try{
            logOutPage.clickOnKebabMenuIcon().clickOnLoginWithAnotherAccount();
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

        return this;
    }
}
