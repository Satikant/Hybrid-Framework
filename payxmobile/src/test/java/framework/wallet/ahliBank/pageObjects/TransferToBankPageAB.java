package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class TransferToBankPageAB extends AppPageInit {

    public TransferToBankPageAB() { super(); }

    @AndroidFindBy(id= "com.ahlibank.ahlipay.subscriber.uat:id/imgService")
    public List<WebElement> transferIcon ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etTransferAmount")
    public WebElement transferAmount ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNext")
    public WebElement next ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnConfirm")
    public  WebElement confirm1 ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    public  WebElement cancel1 ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")
    public  WebElement otpfield;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement otpconfirm ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")
    private WebElement OtpCancelBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement confirmCancelTransOTP;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private WebElement OtpRetry;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnToolbarBack")
    private  List<WebElement> toolbarBckBtn ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement title ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private  WebElement done ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnPositive")
    private WebElement txnagain ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnShare")
    private WebElement share ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvReviewValue")
    private List<WebElement> tvReviewValue ;

    @AndroidFindBy(xpath = "//*[@text='OTP Verification']")
    private WebElement otptitle;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/touch_outside")
    private  WebElement touchOutside;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private WebElement cancelflow ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvResend")
    private WebElement resend ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement txnSuccessMessage;

    @AndroidFindBy(id="alertdialog_message_text")
    private WebElement alertMessageElem;

    @AndroidFindBy(id="alertdialog_ok_button")
    private WebElement alertOKBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    public String getMessageFromAlertBox(){
        return alertdialog.getText();
    }

    public TransferToBankPageAB clickonTransferIcon() throws InterruptedException {
        isElementNotPresent(transferIcon.get(5));
        clickOnElement(transferIcon.get(5), "Clicking on Transfer To Bank");
        return this;
    }

    public TransferToBankPageAB enterAmount(String amt) {
        setText(transferAmount,amt,"Entering Amount");
        return this ;
    }

    public boolean isAlertMessageAvailable(){
        return driver.findElements(By.id("alertdialog_message_text")).size()>0;
    }


    public TransferToBankPageAB clickonNext() {
        clickOnElement(next,"Clicking on Next");
        return this;
    }

    public TransferToBankPageAB Confirm1() {
        clickOnElement(confirm1,"Clicking on confirm");
        return this;
    }

    public TransferToBankPageAB cancel1() {
        clickOnElement(cancel1,"Clicking on cancel");
        return this;
    }

    public TransferToBankPageAB setotp(String Otp) {
        setText(otpfield,Otp,"Entering the OTP");
        return this;
    }

    public TransferToBankPageAB OtpConfirm() {
        clickOnElement(otpconfirm,"Clicking on Confirm OTP");
        return this;
    }

    public TransferToBankPageAB clickOnOtpCancel() {
        clickOnElement(OtpCancelBtn,"Clicking on cancel");
        return this;
    }


    public TransferToBankPageAB resend(){
        clickOnElement(resend,"Resend OTP");
        return this ;
    }

    public TransferToBankPageAB clickOnToolBarBckBtn(){
        clickOnElement(toolbarBckBtn.get(0), "Clicking on toolbar back button");
        return this;
    }

    public TransferToBankPageAB clickOnAlertOK(){
        clickOnElement(alertOKBtn, "Clicking on OK button on alert screen");
        return this;
    }

    public boolean isOTPCancelBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")).size()>0;
    }

    public TransferToBankPageAB cancelOtpTxn(){
        clickOnElement(confirmCancelTransOTP,"Cancelling Transaction OTP ");
        return this;
    }

    public TransferToBankPageAB retryOtpTxn(){
        clickOnElement(OtpRetry,"Clicking  on retry OTP");
        return this;
    }

    public String getMessageFromOTPtitle(){
        return otptitle.getText();
    }

    public TransferToBankPageAB clickonConfirm2() {
        clickOnElement(otpconfirm,"Clicking on confirm");
        return this ;
    }

    public boolean istitlePresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/title")).size()>0;
    }

    public boolean isConfirmBtnPresent(){
        return driver.findElements(By.id("btnConfirm")).size()>0;
    }

    public TransferToBankPageAB clickOnConfirm1() throws InterruptedException {
        clickOnElement(confirm1, "Clicking on Terms Confirm");
        return this;
    }

    public boolean isCancelButtonPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")).size()>0;
    }

    public String toastMessage;
    public String getToast() throws InterruptedException, IOException {
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);
        return toastMessage;
    }

    public TransferToBankPageAB clickonDone(){
        clickOnElement(done,"Transaction Done");
        return this;
    }

    public TransferToBankPageAB touchOutside(){
        clickOnElement(touchOutside,"Clicking outside");
        return this;
    }

    public String getOTPcancelFlowMsg(){
        return cancelflow.getText();
    }

    public String getSucessMessage(){  return txnSuccessMessage.getText(); }

    String status="",txnid="",date_time="",acct="",transferDetails="";

    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(cancel1);
        status=title.getText();
        txnid=tvReviewValue.get(0).getText();
        date_time=tvReviewValue.get(1).getText();
        acct=tvReviewValue.get(2).getText();
        transferDetails=tvReviewValue.get(3).getText();
        return new String[]{status,txnid,date_time,acct,transferDetails};
    }




}
