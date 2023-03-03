package framework.wallet.ahliBank.pageObjects;


import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

public class MerchLoginPageAhliBank extends AppPageInit{
    public MerchLoginPageAhliBank(){
        super();
    }
    
    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/btnUAT")
    private WebElement btnUAT;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnMobileNumberLogin")
    private WebElement btnMobileNumberLogin;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/editTextMobileNumber")
    private WebElement editMobNumber;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnLogin")
    private WebElement btnLogin;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/etMPIN")
    private WebElement editMPIN;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/design_bottom_sheet")
    private WebElement changeDevice;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnPositiveAction")
    private WebElement verifyOtp;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/alertdialog_ok_button")
    private  WebElement btnOk;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/tvTitle")
    private WebElement alertBoxAlert;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/btnNegativeAction")
    private WebElement alertBioReject;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/btnPositiveAction")
    private WebElement alertBioAccept;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/welcome_text")
    private WebElement welcomeText;



    public MerchLoginPageAhliBank clickOnUATServer(){
        clickOnElement(btnUAT,"UAT Server");
        CommonUtils.pauseExecution(5);
        return this;
    }

    public String getMessageFromAlertBox(){
        return alertdialog.getText();
    }

    public boolean isLoginBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/btnMobileNumberLogin")).size()>0;
    }

    public boolean isAlertBoxPresent(){
        return driver.findElements(By.id("tvTitle")).size()>0;
    }

    public MerchLoginPageAhliBank acceptBiometricAlert(){
        clickOnElement(alertBioAccept,"Biometic alert accept");
        return this;
    }

    public MerchLoginPageAhliBank rejectBiometricAlert(){
        isElementNotPresent(alertBioReject);
        clickOnElement(alertBioReject,"Biometic alert reject");
        return this;
    }

    public MerchLoginPageAhliBank clickOnLoginButton(){
        isElementNotPresent(btnMobileNumberLogin);
        clickOnElement(btnMobileNumberLogin,"Login Button");
        return this;
    }


    public MerchLoginPageAhliBank clickOnOk(){
        clickOnElement(btnOk,"Okay Button");
        return this;
    }

    public MerchLoginPageAhliBank setMobileNumber(String msisdn){
        editMobNumber.clear();
        setText(editMobNumber,msisdn,"Mobile Number");
        return this;
    }

    public MerchLoginPageAhliBank setPin(String pin){
        editMPIN.clear();
        setText(editMPIN,pin,"Mobile Pin");
        return this;
    }

    public Boolean isDeviceChanged(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/design_bottom_sheet")).size()>0;
    }

    public MerchLoginPageAhliBank clickOnVerifyOtp(){
        clickOnElement(verifyOtp, "click on verify OTP");
        return this;
    }

    public boolean isLoginButtonClickable(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/btnLogin")).size()>0;
    }

    public boolean isAlertDialogOkButtonDisplayed(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/alertdialog_ok_button")).size()>0;
    }

    public boolean isWelcomeTextAvailable(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/welcome_text")).size()>0;
    }

    public String getWelcomeMessage(){
        return welcomeText.getText();
    }

    public MerchLoginPageAhliBank clickOnSubmitButton(){
        if(isLoginButtonClickable())
        {clickOnElement(btnLogin,"Login Button");}
        else{info("Login button is auto clicked");}
        return this;
    }
}
