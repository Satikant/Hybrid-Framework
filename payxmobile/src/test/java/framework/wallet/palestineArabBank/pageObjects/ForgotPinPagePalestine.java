package framework.wallet.palestineArabBank.pageObjects;

import common.Assertion;
import framework.wallet.bharain.pageObjects.ForgotPinPage;
import globalConstants.Config;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class ForgotPinPagePalestine extends AppPageInit {
    public ForgotPinPagePalestine(){
        super();
    }


    @AndroidFindBy(id = "com.abp.sub:id/forgotpin")
    private WebElement btnForgotPin;

    @AndroidFindBy(id = "com.abp.sub:id/mobileNumberInput")
    private WebElement phNumber;

    @AndroidFindBy(id = "com.abp.sub:id/textView18")
    private WebElement otpFiled;

    @AndroidFindBy(id = "com.abp.sub:id/verify_button")
    private WebElement verifyBtn;

    @AndroidFindBy(id="com.abp.sub:id/resend_text")
    private WebElement resendOtpBtn;

    @AndroidFindBy(id = "com.abp.sub:id/sa_et")
    private WebElement secAnswer;

    @AndroidFindBy(id = "com.abp.sub:id/proceedButton")
    private WebElement btnSubmit;

    @AndroidFindBy(id = "com.abp.sub:id/newPinText")
    private WebElement enterPin;

    @AndroidFindBy(id = "com.abp.sub:id/confirmPinText")
    private WebElement cnfirmPin;

    @AndroidFindBy(id = "com.abp.sub:id/setPinButton")
    private WebElement submitBtn;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_action")
    private WebElement btnOK;

    @AndroidFindBy(id = "com.batelco.sub:id/forgotsecurityanswer")
    private WebElement fgtSecAnswer;

    @AndroidFindBy(id = "com.batelco.sub:id/verifyemailbutton")
    private WebElement verifyEmail;

    @AndroidFindBy(id = "com.batelco.sub:id/dob")
    private WebElement dateOfBirth;

    @AndroidFindBy(id = "com.batelco.sub:id/cprdobsubmit")
    private WebElement submitSec;

    @AndroidFindBy(id="com.abp.sub:id/pin_first_edittext")
    public WebElement otp1;

    @AndroidFindBy(id="com.abp.sub:id/pin_second_edittext")
    public WebElement otp2;

    @AndroidFindBy(id="com.abp.sub:id/pin_third_edittext")
    public WebElement otp3;

    @AndroidFindBy(id="com.abp.sub:id/pin_forth_edittext")
    public WebElement otp4;

    @AndroidFindBy(id="com.abp.sub:id/pin_fifth_edittext")
    public WebElement otp5;

    @AndroidFindBy(id="com.abp.sub:id/pin_sixth_edittext")
    public WebElement otp6;

    @AndroidFindBy(id="com.abp.sub:id/LoginID")
    public WebElement loginID;

    public boolean isLoginFieldDisplayed() { return driver.findElements(By.id("com.abp.sub:id/LoginID")).size() > 0; }
    public boolean isEnterPinDisplayed() {
             return driver.findElements(By.id("newPinText")).size() > 0;
           }

    public ForgotPinPagePalestine clickOnForgotPin() {
        driver.navigate().back();
        isElementNotPresent(btnForgotPin);
        clickOnElement(btnForgotPin, "Click on forgot pin button");
        return this;
    }

    public boolean isMsisdnFieldDisplayed(){
        return driver.findElements(By.id("mobileNumberInput")).size()>0;
    }

    public ForgotPinPagePalestine enterPhNumber(String msisdn) throws IOException {
        setText(phNumber, msisdn, "Enter mobile number");
        driver.navigate().back();
        return this;
    }

    public boolean isOtpScreenDisplayed(){
        CommonUtils.pauseExecution(3);
        return  driver.findElements(By.id("textView18")).size()>0;
    }

    public ForgotPinPagePalestine clickVerify() {
        clickOnElement(verifyBtn, "Click on verify");
        return this;
    }

    public boolean isCprNumberDisplayed(){
        return driver.findElements(By.id("sa_et")).size()>0;
    }

    public boolean isSubmitButtonDisplayed(){
        return driver.findElements(By.id("com.abp.sub:id/proceedButton")).size()>0;
    }

    public boolean isSecAnsDisplayed(){
        return driver.findElements(By.id("sa_et")).size()>0;
    }

    public ForgotPinPagePalestine enterSecAnser(String answer) {
        setText(secAnswer, answer, "Enter Security Answer");
        return this;
    }

    public ForgotPinPagePalestine clickSubmit() {
        clickOnElement(btnSubmit, "Click on Submit");
        return this;
    }

    public ForgotPinPagePalestine enterPin(String pin) {
        setText(enterPin, pin, "Enter Pin");
        return this;
    }

    public ForgotPinPagePalestine confirmPin(String confirmPin) {
        setText(cnfirmPin, confirmPin, "Enter confirm Pin");
        return this;
    }

    public boolean isSetPinButtonDisplayed(){
        CommonUtils.pauseExecution(2);
        return driver.findElements(By.id("setPinButton")).size()>0;
    }

    public ForgotPinPagePalestine clickOnSubmit() {
        CommonUtils.pauseExecution(1);
        clickOnElement(submitBtn, "Click on Submit");
        return this;
    }

    public ForgotPinPagePalestine clickOnForgotSecurity() {
        isElementNotPresent(fgtSecAnswer);
        clickOnElement(fgtSecAnswer, "Click on Forgot Secuirty Answer");
        CommonUtils.pauseExecution(3);
        return this;
    }

    public ForgotPinPagePalestine clickOnverifyEmail() {
        clickOnElement(verifyEmail, "Click on verify OTP");
        return this;
    }

    public ForgotPinPagePalestine setOtp1(String otp) {
        setText(otp1, otp, "Otp1");
        return this;
    }

    public ForgotPinPagePalestine setOtp2(String otp) {
        setText(otp2, otp, "Otp2");
        return this;
    }

    public ForgotPinPagePalestine setOtp3(String otp) {
        setText(otp3, otp, "Otp3");
        return this;
    }

    public ForgotPinPagePalestine setOtp4(String otp) {
        setText(otp4, otp, "Otp4");
        return this;
    }

    public ForgotPinPagePalestine setOtp5(String otp) {
        setText(otp5, otp, "Otp5");
        return this;
    }

    public ForgotPinPagePalestine setOtp6(String otp) {
        setText(otp6, otp, "Otp6");
        return this;
    }

    public ForgotPinPagePalestine clearOtpField() {
        otp1.clear();
        otp2.clear();
        otp3.clear();
        otp4.clear();
        otp5.clear();
        otp6.clear();

        return this;
    }

    public ForgotPinPagePalestine setOtp(String otp) {

        int i = otp.length();

        if (Config.isClearFieldTrue) {
            clearOtpField();
            Config.setClearFieldFalse();
            return this;
        }
        if ( i == 3) {
            setOtp1(otp.substring(0));
            setOtp2(otp.substring(1));
            setOtp3(otp.substring(2));
            return this;
        }
        else {
            setOtp1(otp.substring(0));
            setOtp2(otp.substring(1));
            setOtp3(otp.substring(2));
            setOtp4(otp.substring(3));
            setOtp5(otp.substring(4));
            setOtp6(otp.substring(5));
            return this;
        }
    }

    private String toastMessage;

    public void getToast() throws InterruptedException, IOException {
        CommonUtils.pauseExecution(3);
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);

        if (MobileProperties.getProperty("tessdata.lang").equals("eng")) {
            if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0053"))) {
                Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0053"));
            } else if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0054"))) {
                Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0054"));
            }
        }

        else {
            if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0053"))) {
                Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0053"));
            } else if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0054"))) {
                Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0054"));
            }
        }

        Config.setToastCheckFalse();
    }

    public ForgotPinPagePalestine clickSubmitSec() {
        clickOnElement(submitSec, "Click on Submit");
        return this;
    }


}
