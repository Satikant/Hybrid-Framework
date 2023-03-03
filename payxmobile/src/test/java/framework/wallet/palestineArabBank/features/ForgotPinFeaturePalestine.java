package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.palestineArabBank.pageObjects.ForgotPinPagePalestine;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

public class ForgotPinFeaturePalestine {

    ForgotPinPagePalestine forgotPinPage = new ForgotPinPagePalestine();

    public ForgotPinFeaturePalestine forgotPin(String msisdn, String otp, String secAnswer, String pin, String confirmPin) {
        ExtentTest featurenode = ExtentManager.getTest();
        try {
            if (Config.isFirstTimeLogin) {
                forgotPinPage.clickOnForgotPin();
                Config.setFirstTimeLoginFalse();
            }

            if (forgotPinPage.isMsisdnFieldDisplayed()) {
                forgotPinPage.enterPhNumber(msisdn).clickSubmit();
                CommonUtils.pauseExecution(2);
            }

            if (forgotPinPage.isOtpScreenDisplayed()) {
                forgotPinPage.clearOtpField();
                forgotPinPage.setOtp(otp)
                        .clickVerify();
            }
            CommonUtils.pauseExecution(3);
            if (forgotPinPage.isSecAnsDisplayed()) {
                forgotPinPage.enterSecAnser(secAnswer)
                        .clickSubmit();
            }
            CommonUtils.pauseExecution(2);
            if (forgotPinPage.isSetPinButtonDisplayed()) {
                forgotPinPage.enterPin(pin).confirmPin(confirmPin).clickOnSubmit();
                CommonUtils.pauseExecution(3);
                System.out.println("Confirm Pin " + confirmPin);
                if (forgotPinPage.isLoginFieldDisplayed())
                {
                    writeNewPinToExcel(pin);
                    featurenode.pass("Pin Succcesfully Changed");
                }

            }
        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result:" + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void writeNewPinToExcel(String pin) throws IOException {
        String pin1 = DataDriven.getUserPinByStatus("Y");
        String pin2 = DataDriven.getUserPin2ByStatus("Y");
        System.out.println("PIN1 : " + pin1 + "\n" + "PIN2 : " + pin2);
        DataDriven.setCellValueByOldPin3("Y", pin2);
        DataDriven.setCellValueByOldPin2("Y", pin1);
        DataDriven.setCellValueByOldPin("Y", pin);
    }
}
