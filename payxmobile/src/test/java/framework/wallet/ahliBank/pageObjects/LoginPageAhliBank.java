package framework.wallet.ahliBank.pageObjects;


import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

public class LoginPageAhliBank extends AppPageInit {
    public LoginPageAhliBank() {
        super();
    }


    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnMobileNumberLogin")
    private WebElement btnMobileNumberLogin;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etMobileNumber")
    private WebElement etMobileNumber;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnLogin")
    private WebElement btnLogin;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etMPIN")
    private WebElement etMPIN;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/design_bottom_sheet")
    private WebElement changeDevice;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement verifyOtp;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_ok_button")
    private  WebElement btnOk;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private WebElement alertBoxAlert;

    @AndroidFindBy(id="btnNegativeAction")
    private WebElement alertBioReject;

    @AndroidFindBy(id="btnPositiveAction")
    private WebElement alertBioAccept;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/welcomeText")
    private WebElement welcomeText;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnUAT")
    private WebElement btnUAT;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnSIT")
    private WebElement btnSIT;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rvServiceItems")
    private WebElement rvServiceItems;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private WebElement updateLater;

    public LoginPageAhliBank clickOnUpdateLater(){
        clickOnElement(updateLater,"Update Later");
        return this;
    }

    public LoginPageAhliBank clickOnAllService(){
        clickOnElement(rvServiceItems,"All services");
        return this;
    }

    public LoginPageAhliBank clickOnSITServer(){
        clickOnElement(btnSIT,"SIT Server");
        CommonUtils.pauseExecution(5);
        return this;
    }

    public LoginPageAhliBank clickOnUATServer(){
        clickOnElement(btnUAT,"UAT Server");
        CommonUtils.pauseExecution(5);
        return this;
    }


    public String getMessageFromAlertBox(){
        return alertdialog.getText();
    }

    public boolean isLoginBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnMobileNumberLogin")).size()>0;
    }

    public boolean isAlertBoxPresent(){
         isElementNotPresent(alertBioReject);
        return driver.findElements(By.id("tvTitle")).size()>0;
    }

    public LoginPageAhliBank acceptBiometricAlert(){
        clickOnElement(alertBioAccept,"Biometic alert accept");
        return this;
    }

    public LoginPageAhliBank rejectBiometricAlert(){
        isElementNotPresent(alertBioReject);
        clickOnElement(alertBioReject,"Biometic alert reject");
        return this;
    }

    public LoginPageAhliBank clickOnLoginButton(){
        isElementNotPresent(btnMobileNumberLogin);
        clickOnElement(btnMobileNumberLogin,"Login Button");
        return this;
    }


    public LoginPageAhliBank clickOnOk(){
        clickOnElement(btnOk,"Okay Button");
        return this;
    }

    public LoginPageAhliBank setMobileNumber(String msisdn){
        etMobileNumber.clear();
        setText(etMobileNumber,msisdn,"Mobile Number");
        return this;
    }

    public LoginPageAhliBank setPin(String pin){
        etMPIN.clear();
        setText(etMPIN,pin,"Mobile Pin");
        return this;
    }

    public Boolean isDeviceChanged(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/design_bottom_sheet")).size()>0;
    }

    public LoginPageAhliBank clickOnVerifyOtp(){
        clickOnElement(verifyOtp, "click on verify OTP");
        return this;
    }

    public boolean isLoginButtonClickable(){
        return driver.findElements(By.id("btnLogin")).size()>0;
    }

    public boolean isAlertDialogOkButtonDisplayed(){
        return driver.findElements(By.id("alertdialog_ok_button")).size()>0;
    }

    public boolean isWelcomeTextAvailable(){
        return driver.findElements(By.id("welcomeText")).size()>0;
    }

    public String getWelcomeMessage(){
        return welcomeText.getText();
    }

    public LoginPageAhliBank clickOnSubmitButton(){
        if(isLoginButtonClickable())
        {clickOnElement(btnLogin,"Login Button");}
        else{info("Login button is auto clicked");}
        return this;
    }


}
