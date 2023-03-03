package framework.wallet.omanArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.omanArabBank.pageObjects.LoginPage;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.LogReader;
import java.io.IOException;

import static utils.CommonUtils.createMethodLabel;


public class CustomerLogin {
    LogReader logReader = new LogReader();
    LoginPage page = new
            LoginPage();

    public CustomerLogin doLogin(String mobNo, String pin) throws IOException, InterruptedException {
        ExtentTest node = ExtentManager.getTest();
        createMethodLabel("doLogin");

        try
        {
            if (Config.isFirstTimeLogin) {
                if (MobileProperties.getProperty("language.code").equals("en")) {
                    page.
                            clickOnEnglishLang()
                            .clickOnLanguageConfirmButton();
                    Config.setFirstTimeLoginFalse();
                } else {
                    page.
                            clickOnArabicLang().
                            clickOnLanguageConfirmButton();
                    Config.setFirstTimeLoginFalse();

                }
            }
            page.
                    setMobileNo(mobNo).
                    setPin1(pin.substring(0, 1)).
                    setPin2(pin.substring(1, 2)).
                    setPin3(pin.substring(2, 3)).
                    setPin4(pin.substring(3, 4)).
                    setPin5(pin.substring(4, 5)).
                    clickOnLoginButton();

            if (Config.isAssertionRequired) {
                if (page.isLoginWithPinDisplayed()) {
                    page.clickOnLoginWithPin();
                    node.pass("Login Successful");
                } else {
                    System.out.println("Login Failed");
                    node.fail("Failed to Login");
                }
                CommonUtils.captureScreenMobile(node, "");
            }
        }
        catch (Exception e){
               e.printStackTrace();
               node.fail("Test Case Failed");
               node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void acceptAlert() throws InterruptedException
    {
        ExtentTest node = ExtentManager.getTest();
        try{
            if(page.isclickOnOkDisplayed()){
                page.clickOnOk().clearField();
            }
            else  if(page.isclickOnButtonNoDisplayed()){
   //            page.clickOnButtonNo();
            }
        }
        catch (Exception e){
        e.printStackTrace();
        node.fail("Test Case Failed");
        node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
    }
    }


}
