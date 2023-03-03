package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.loginPageObj;
import framework.mobiquityPayX.payX.PageObjects.dashboardPageObj;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.Utils;


public class loginFeature extends loginPageObj {

    loginPageObj loginpage = new loginPageObj();
    dashboardPageObj dbpage = new dashboardPageObj();
    ExtentTest node = ExtentManager.getTest();

    public void login(String Msisdn, String Pin) {
        try {
            //*IOS SCRIPT to handle notification*//
            if(loginpage.isFirstNotificationiOSPresent()){
                AllowNotificationiOS();
                OkNotificationiOS();
            }
            //The service flow of Login automation
            loginpage.setMobileNum(Msisdn).setPin(Pin).clickonLogin();
            //enter mobile number . enter pin , and click on login button
            if (loginpage.isErrorDilogboxPresent()) {
                Assertion.verifyContains(loginpage.getErrorText(), "Error");
                AcceptDialogBox();
//                    node.pass("Test case PASS");
            } else if (dbpage.isIgnoreBoxPresent()) {
                Utils.putThreadSleep(3000);
                dbpage.clickOnIgnore();
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case FAILED");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

    }

    public void enterPin(String Pin) {
        try {
            loginpage.setPin(Pin).clickonLogin();

            if (dbpage.isIgnoreBoxPresent()) {
                dbpage.clickOnIgnore();
            }
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }

    // Accepting the dialog box if it appears

    public void AcceptDialogBox() {
        if (isErrorDilogboxPresent()) {
            loginpage.clickOnAcceptErr();
        }
    }

    public void AllowNotificationiOS() {
        if (isFirstNotificationiOSPresent()) {
            loginpage.clickOnAllowNotification();
        }
    }

    public void OkNotificationiOS() {
        if (isFirstNotificationiOSPresent()) {
            loginpage.clickOnOkNotification();
        }
    }

    public void loginwithPin(String Pin) {

        loginpage.setPin2(Pin).clickonLogin2();
        if (dbpage.isIgnoreBoxPresent()) {
            dbpage.clickOnIgnore();
        }
    }


}


