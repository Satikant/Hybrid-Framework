package framework.wallet.bharain.features;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.bharain.pageObjects.ForgotPinPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;


public class ForgotPinFeature {
    ForgotPinPage forgotPinPage = new ForgotPinPage();
    LoginPageBharain page = new LoginPageBharain();
    CustomerLoginBharain login = new CustomerLoginBharain();

    public ForgotPinFeature forgotPin(String msisdn,String otp, String secAns,String pin, String confirmPin)  {
        ExtentTest featurenode = ExtentManager.getTest();
        try{
            if(Config.isFirstTimeLogin){
              //  page.selectLanguage();
                forgotPinPage.clickOnForgotPin();
                Config.setFirstTimeLoginFalse();
            }
            if(forgotPinPage.isMobileNumberPresent()){
                forgotPinPage.enterPhNumber(msisdn).clickSubmit();
            }

            if(forgotPinPage.isOtpScreenDisplayed()) {
                forgotPinPage.enterOtp(otp).clickVerify();
            }
            if(forgotPinPage.isSecAnsDisplayed()){
                forgotPinPage.enterSecAnser(secAns).clickSubmit();
            }
            if(forgotPinPage.isSetPinButtonDisplayed()){
                forgotPinPage.enterPin(pin).confirmPin(confirmPin).clickOnSubmit();
                if (page.isLoginIdDisplayed()) {
                    writeNewPinToExcel(pin);
                    featurenode.pass("Pin Succcesfully Changed");
                }
            }
        }
        catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public ForgotPinFeature forgotSecurityAnwser(String Status, String otp, String CprNumber, String Date_dd_mm_yyyy, String pin, String Cpin, String text) {
        try
        {
            if(Config.isFirstTimeLogin)
            {
                forgotPinPage.clickOnForgotPin().enterPhNumber(DataDriven.getUserByStatus(Status)).clickSubmit();
                forgotPinPage.enterOtp(otp).clickVerify().clickOnForgotSecurity();
                Config.setFirstTimeLoginFalse();
            }
            if(forgotPinPage.isSubmitButtonDisplayed()){
                forgotPinPage.enterNewSecurityAnswer(text).clickSubmit();
                if (page.isLoginIdDisplayed()) {
                    writeNewPinToExcel(pin);
                }
            }
            else{
                if (Config.isForgotSecurityPresent) {
                    forgotPinPage.clickOnverifyEmail();
                    forgotPinPage.getToast();
                    Config.setIsForgotSecurityPresent();
                } else {
                    if(!forgotPinPage.isCprNumberDisplayed()){
                        forgotPinPage.enterOtp(otp).clickVerify();
                    }
                    forgotPinPage.enterCprNumber(CprNumber);
                    forgotPinPage.enterDOB(Date_dd_mm_yyyy);
                    forgotPinPage.clickSubmitSec();
                    if (forgotPinPage.isEnterPinDisplayed()) {
                        forgotPinPage.enterPin(pin).
                                confirmPin(Cpin).
                                clickOnSubmit();
                        System.out.println("Confirm Pin "+ Cpin);
                        writeNewPinToExcel(pin);
                        CommonUtils.pauseExecution(3);
                        forgotPinPage.enterNewSecurityAnswer(text).clickSubmit();
                    }

                }
            }
        }
        catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(com.aventstack.extentreports.Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void acceptAlertOman(){
        try {
            if (page.isSnackbarDisplayed()) {
                page.clickOnsnackbarButton();
            } else if (page.isClickOnTryDisplayed()) {
                page.clickOnTryButton();
            }
        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }

    public void writeNewPinToExcel(String pin) throws IOException {
        String pin1=DataDriven.getUserPinByStatus("Y");
        String pin2=DataDriven.getUserPin2ByStatus("Y");
        System.out.println("PIN1 : "+pin1 +"\n"+"PIN2 : "+pin2);
        DataDriven.setCellValueByOldPin3("Y",pin2);
        DataDriven.setCellValueByOldPin2("Y",pin1);
        DataDriven.setCellValueByOldPin("Y", pin);
        CommonUtils.pauseExecution(1);
    }
}