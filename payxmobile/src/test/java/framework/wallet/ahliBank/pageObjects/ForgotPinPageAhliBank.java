package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;


public class ForgotPinPageAhliBank extends AppPageInit {

    public ForgotPinPageAhliBank(){
        super();
    }

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvForgotPin")
    private WebElement forgotPin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etMobileNumber")
    private WebElement msisdn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnSubmit")
    private WebElement btnSubmit;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_ok_button")
    private WebElement btnOK;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")
    private WebElement otp;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement btnConfirm;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvResend")
    private WebElement btnResend;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etIdentityNumber")
    private WebElement idNumber;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNext")
    private WebElement btnNext;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etPIN")
    private WebElement pin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etConfirmPin")
    private WebElement confirmPin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/set_pin_btn")
    private WebElement btnSetPin;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    private WebElement dialogBox;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_message_text")
    private WebElement errMsg;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private WebElement msg;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnOKSuccess")
    private WebElement btnSuccess;

    public ForgotPinPageAhliBank clickOnSuccess(){
        clickOnElement(btnSuccess,"Pin Changed Successfully");
        return this;
    }

    public Boolean isSuccessBtnDisplayed(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnOKSuccess")).size()>0;
    }

    public ForgotPinPageAhliBank clickOnForgotPin(){
        isElementNotPresent(forgotPin);
        clickOnElement(forgotPin,"Click on forgot Pin");
        return this;
    }

    public Boolean isMsisdnFieldPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etMobileNumber")).size()>0;
    }

    public ForgotPinPageAhliBank enterMsisdn(String mobNumb){
        isElementNotPresent(msisdn);
        msisdn.clear();
        setText(msisdn,mobNumb,"Enter Mobile number");
        return this;
    }

    public ForgotPinPageAhliBank clickOnSubmit(){
        clickOnElement(btnSubmit,"Click On submit");
        return this;
    }

    public Boolean isOkBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_ok_button")).size()>0;
    }

    public ForgotPinPageAhliBank clickOnOK(){
        clickOnElement(btnOK,"Click on OK");
        return this;
    }

    public Boolean isOTPFieldPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")).size()>0;
    }


    public ForgotPinPageAhliBank enterOtp(String Otp){
        otp.clear();
        driver.navigate().back();
        setText(otp,Otp,"Enter Otp");
        CommonUtils.pauseExecution(2);
        return this;
    }

    public Boolean isConfirmButtonpresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")).size()>0;
    }
    public ForgotPinPageAhliBank clickOnConfirm(){
        clickOnElement(btnConfirm,"Click on Confirm");
         return this;
    }

    public Boolean idFieldPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etIdentityNumber")).size()>0;
    }

    public ForgotPinPageAhliBank enterId(String id){
        CommonUtils.pauseExecution(3);
        clickOnElement(idNumber,"test");
        idNumber.clear();
        setText(idNumber,id,"Enter id number");
        driver.navigate().back();
        return this;
    }

    public ForgotPinPageAhliBank clickOnNext(){
        clickOnElement(btnNext,"Click on next");
        return this;
    }

    public Boolean isPinFieldPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etPIN")).size()>0;
    }

    public ForgotPinPageAhliBank enterPin(String nPin){
        pin.clear();
        driver.navigate().back();
        setText(pin,nPin,"Enter pin");
        return this;
    }

    public ForgotPinPageAhliBank enterConfirmPin(String cPin){
        confirmPin.clear();
        driver.navigate().back();
        setText(confirmPin,cPin,"Enter confirm Pin");
        return this;
    }

    public String getErrMessage(){
        if(isOkBtnPresent()) {
            return errMsg.getText();
        }else
            return msg.getText();
    }

    public ForgotPinPageAhliBank clickOnSetPin(){
        clickOnElement(btnSetPin,"Click on Set Pin");
        return this;
    }

    public boolean isDialogBoxDisplayed(){
        return driver.findElements(By.className("android.widget.FrameLayout")).size()>0;
    }

    public boolean isSetPinPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/set_pin_btn")).size()>0;
    }

}
