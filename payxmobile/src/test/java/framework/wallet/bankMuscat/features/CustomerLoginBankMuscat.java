package framework.wallet.bankMuscat.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.bankMuscat.pageObjects.LoginPageBankMuscat;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import static utils.CommonUtils.createMethodLabel;


public class CustomerLoginBankMuscat {
LoginPageBankMuscat page=new LoginPageBankMuscat();
    public CustomerLoginBankMuscat doLogin(String mobNo, String pin) {
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
                    setPin(pin).
                    clickOnLoginButton();

            if (Config.isAssertionRequired) {
                if (page.isProfilePicDisplayed()) {
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
                page.clickOnButtonNo();
            }
        }
        catch (Exception e){
        e.printStackTrace();
        node.fail("Test Case Failed");
        node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
    }
    }

}
