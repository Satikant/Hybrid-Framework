package framework.wallet.bharain.pageObjects;


import common.Assertion;
import framework.wallet.bharain.features.CustomerLoginBharain;
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

public class ForgotPinPage extends AppPageInit {
    public ForgotPinPage() {
        super();
    }

    @AndroidFindBy(id = "com.batelco.sub:id/forgotpin")
    private WebElement btnForgotPinBH;

    @AndroidFindBy(id = "com.batelco.sub:id/mobileNumberInput")
    private WebElement phNumber;

    @AndroidFindBy(id = "com.batelco.sub:id/otp_input")
    private WebElement otpFiled;

    @AndroidFindBy(id = "com.batelco.sub:id/verify_button")
    private WebElement verifyBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/sa_et")
    private WebElement secAnswer;

    @AndroidFindBy(id = "com.batelco.sub:id/proceedButton")
    private WebElement btnSubmit;

    @AndroidFindBy(id = "com.batelco.sub:id/newPinText")
    private WebElement enterPin;

    @AndroidFindBy(id = "com.batelco.sub:id/confirmPinText")
    private WebElement cnfirmPin;

    @AndroidFindBy(id = "com.batelco.sub:id/setPinButton")
    private WebElement submitBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/snackbar_action")
    private WebElement btnOK;

    @AndroidFindBy(id = "com.batelco.sub:id/forgotsecurityanswer")
    private WebElement fgtSecAnswer;

    @AndroidFindBy(id = "com.batelco.sub:id/verifyemailbutton")
    private WebElement verifyEmail;

    @AndroidFindBy(id = "com.batelco.sub:id/dob")
    private WebElement dateOfBirth;

    @AndroidFindBy(id = "com.batelco.sub:id/cprdobsubmit")
    private WebElement submitSec;

    @AndroidFindBy(className = "android.widget.EditText")
    private List<WebElement> newSecAnswer;

    public boolean isEnterPinDisplayed() {
        if (MobileProperties.getProperty("project.name").equalsIgnoreCase("Omantel")) {
            return true;
        } else {
            return driver.findElements(By.id("newPinText")).size() > 0;
        }
    }

    public ForgotPinPage clickOnForgotPin() {
        driver.navigate().back();
            isElementNotPresent(btnForgotPinBH);
            clickOnElement(btnForgotPinBH, "Click on forgot pin button");
        return this;
    }

    public ForgotPinPage enterPhNumber(String msisdn) throws IOException {
        setText(phNumber, msisdn, "Enter mobile number");
        driver.navigate().back();
        return this;
    }

    public boolean isMobileNumberPresent(){

       return driver.findElements(By.id("mobileNumberInput")).size()>0;
    }

    public boolean isOtpScreenDisplayed(){
        waitUntilElementDisappear("android:id/progress");
        return  driver.findElements(By.id("otp_input")).size()>0;
    }

    public ForgotPinPage enterOtp(String otp) {
            setText(otpFiled, otp, "Enter OTP");
            return this;
    }

    public ForgotPinPage clickVerify() {
            clickOnElement(verifyBtn, "Click on verify");
        return this;
    }

    public ForgotPinPage enterCprNumber(String CprNumber) throws InterruptedException {
        isElementNotPresent(secAnswer);
        setText(secAnswer, CprNumber, "Enter CPR number");
        return this;
    }

    public boolean isCprNumberDisplayed(){
        return driver.findElements(By.id("sa_et")).size()>0;
    }

    public boolean isSubmitButtonDisplayed(){
        return driver.findElements(By.id("proceedButton")).size()>0;
    }

    public boolean isSecAnsDisplayed(){
        waitUntilElementDisappear("android:id/progress");
        CommonUtils.pauseExecution(2);
        return driver.findElements(By.id("forgotsecurityanswer")).size()>0;
    }

    public ForgotPinPage enterSecAnser(String secAns) {
        setText(secAnswer, secAns, "Enter Security Answer");
        return this;
    }

   /* public boolean isMobileNumberPresent(){
    return driver.findElements(By.id("mobileNumberInput")).size()>0;
    }*/

    public ForgotPinPage clickSubmit() {
            clickOnElement(btnSubmit, "Click on Submit");
        return this;
    }

    public ForgotPinPage enterPin(String pin) {
        setText(enterPin, pin, "Enter Pin");
        return this;
    }

    public ForgotPinPage confirmPin(String confirmPin) {
        setText(cnfirmPin, confirmPin, "Enter confirm Pin");
        return this;
    }

    public boolean isSetPinButtonDisplayed(){
        waitUntilElementDisappear("android:id/progress");
        CommonUtils.pauseExecution(2);
        return driver.findElements(By.id("setPinButton")).size()>0;
    }

    public ForgotPinPage clickOnSubmit() {
        CommonUtils.pauseExecution(1);
        clickOnElement(submitBtn, "Click on Submit");
        return this;
    }

    public ForgotPinPage clickOnForgotSecurity() {
        isElementNotPresent(fgtSecAnswer);
        clickOnElement(fgtSecAnswer, "Click on Forgot Secuirty Answer");
        CommonUtils.pauseExecution(3);
        return this;
    }

    public ForgotPinPage clickOnverifyEmail() {
        clickOnElement(verifyEmail, "Click on verify OTP");
        return this;
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


    public ForgotPinPage enterDOB(String DOB) throws InterruptedException {
        setText(dateOfBirth, DOB, "Enter Date of Birth");
        return this;
    }

    public ForgotPinPage clickSubmitSec() {
        clickOnElement(submitSec, "Click on Submit");
        return this;
    }

    public ForgotPinPage enterNewSecurityAnswer(String text) {
        CommonUtils.pauseExecution(5);
        isElementNotPresent(newSecAnswer.get(0));
        setText(newSecAnswer.get(0), text, "Enter new Security answer");
        return this;
    }
}
