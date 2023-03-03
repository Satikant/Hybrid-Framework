package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import globalConstants.Config;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

public class ForgotPinFeatureAhliBank {

    ForgotPinPageAhliBank fPinPage=new ForgotPinPageAhliBank();
    LoginPageAhliBank loginPageAhliBank = new LoginPageAhliBank();


    public ForgotPinFeatureAhliBank forgotPin(String msisdn, String otp,String idNumber,String Pin,String cPin) throws IOException {
        ExtentTest testcase  = ExtentManager.getTest();
       try{
           TestInit.startPositveTest();

        if(Config.isFirstTimeLogin){
            loginPageAhliBank.clickOnUATServer();
            CommonUtils.pauseExecution(5);
            Config.setFirstTimeLoginFalse();
            loginPageAhliBank.clickOnLoginButton();
            fPinPage.clickOnForgotPin();
        }

    if(fPinPage.isMsisdnFieldPresent()) {
        fPinPage.enterMsisdn(msisdn).clickOnSubmit();
        CommonUtils.pauseExecution(1);
    }
    if(fPinPage.isOTPFieldPresent()){
         fPinPage.enterOtp(otp);
        if(fPinPage.isConfirmButtonpresent()) {
        fPinPage.clickOnConfirm();
        }
    }
    if(fPinPage.idFieldPresent()) {
        fPinPage.enterId(idNumber).clickOnNext();
    }
    if(fPinPage.isPinFieldPresent()) {
            fPinPage.enterPin(Pin).enterConfirmPin(cPin);
            CommonUtils.pauseExecution(2);
    if(fPinPage.isSetPinPresent())
    {fPinPage.clickOnSetPin();}
    }
    CommonUtils.pauseExecution(2);
    if(fPinPage.isSuccessBtnDisplayed()){
      testcase.info("Pin Changed Successfully.");
        writeNewPinToExcel(Pin);
    }
       }catch (Exception e){
           e.printStackTrace();
           testcase.fail("Test Case Failed");
           testcase.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
       }
        return this;
    }

    public ForgotPinFeatureAhliBank afterMethod(){
      if(fPinPage.isOkBtnPresent()){
        fPinPage.clickOnOK();}
      if (fPinPage.isSuccessBtnDisplayed()){
          fPinPage.clickOnSuccess(); }
      return this;
    }

    public void writeNewPinToExcel(String pin) {
        String pin1= DataDriven.getUserPinByStatus("Y");
        String pin2=DataDriven.getUserPin2ByStatus("Y");
        System.out.println("PIN1 : "+pin1 +"\n"+"PIN2 : "+pin2);
        DataDriven.setCellValueByOldPin3("Y",pin2);
        DataDriven.setCellValueByOldPin2("Y",pin1);
        DataDriven.setCellValueByOldPin("Y", pin);
        CommonUtils.pauseExecution(1);
    }

}
