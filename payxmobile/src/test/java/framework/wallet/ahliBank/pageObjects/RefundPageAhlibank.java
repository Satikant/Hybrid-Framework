package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class RefundPageAhlibank extends AppPageInit {

    public RefundPageAhlibank() {
        super();
    }


    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/imgRefund")
    private WebElement refundbtn ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/edittextTransactionid")
    private WebElement Txnid ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnConfirmTransactionAction")
    private WebElement confirmbtn ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnCancelTransactionAction")
    private WebElement cancelbtn ;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.merchant.uat:id/btnCancel")
    private WebElement cancel1 ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnToolbarBack")
    private WebElement toolbarbackbtn ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/alertdialog_ok_button")
    private WebElement alertok ;
    
    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/welcome_text")
    private WebElement welcomeText ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/etOTPEditText")
    private WebElement otp ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/tvResend")
    private WebElement resend ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/btnCancelOTPAction")
    private WebElement OtpCancelBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.merchant.uat:id/btnPositiveAction")
    private WebElement confirmCancelTransOTP;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.merchant.uat:id/btnNegativeAction")
    private WebElement OtpRetry;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/title")
    private WebElement title ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement txnSuccessMessage;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnCancel")
    private  WebElement done ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnPositive")
    private WebElement txnagain ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/btnShare")
    private WebElement share ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.merchant.uat:id/tvReviewValue")
    private List<WebElement> tvReviewValue ;

    @AndroidFindBy(xpath = "//*[@text='OTP Verification']")
    private WebElement otptitle;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/touch_outside")
    private  WebElement touchOutside;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private WebElement cancelflow ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement confirm2 ;

    public RefundPageAhlibank clickonRefund() {
        isElementNotPresent(refundbtn);
        clickOnElement(refundbtn,"Clicking on Refund button");
        return this ;
    }

    public RefundPageAhlibank editTxnid(String txnid){
        setText(Txnid,txnid,"Setting up Transaction ID");
        return this ;
    }
    
    public RefundPageAhlibank clickonconfirm(){
        clickOnElement(confirmbtn,"Clicking on Confirm");
        return this;
    }
    
    public RefundPageAhlibank clickoncancel(){
        clickOnElement(cancelbtn,"Clicking on cancel");
        return this;
    }
    
    public RefundPageAhlibank clickonback(){
        clickOnElement(toolbarbackbtn,"Clicking on Back button at the top");
        return this;
    }

    public RefundPageAhlibank clickonDone(){
        clickOnElement(done,"Transaction Done");
        return this;
    }

    public String getSucessMessage(){  return txnSuccessMessage.getText(); }

    public boolean isAlertMessageAvailable(){
        return driver.findElements(By.id("alertdialog_message_text")).size()>0;
    }

    public RefundPageAhlibank clickonConfirm2() {
        clickOnElement(confirm2,"Clicking on confirm");
        return this;
    }

    public boolean istitlePresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/title")).size()>0;
    }

    public boolean isAlertBoxPresent(){
        return driver.findElements(By.id("tvTitle")).size()>0;
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

  /*  public RefundPageAhlibank clickOnSubmitButton(){
        clickOnElement(submit,"Login Button");
        return this;
    }*/

    public String getMessageFromAlertBox(){
        return alertdialog.getText();
    }

    public boolean isConfirmBtnPresent(){
        return driver.findElements(By.id("btnConfirm")).size()>0;
    }

    public boolean isCancelButtonPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.merchant.uat:id/btnCancelOTPAction")).size()>0;
    }

    public RefundPageAhlibank clickOnOtpCancel() {
        clickOnElement(OtpCancelBtn,"Clicking on cancel");
        return this;
    }

    public RefundPageAhlibank retryOtpTxn(){
        clickOnElement(OtpRetry,"Clicking  on retry OTP");
        return this;
    }

    public RefundPageAhlibank cancelOtpTxn(){
        clickOnElement(confirmCancelTransOTP,"Cancelling Transaction OTP ");
        return this;
    }

    public String getOTPcancelFlowMsg(){
        return cancelflow.getText();
    }

    public RefundPageAhlibank touchOutside(){
        clickOnElement(touchOutside,"Clicking outside");
        return this;
    }

    public String getMessageFromOTPtitle(){
        return otptitle.getText();
    }

    public RefundPageAhlibank setOTP(String OTP) {
        setText(otp,OTP,"Setting up OTP");
        return this;
    }

    public RefundPageAhlibank resendotp(){
        clickOnElement(resend,"resend OTP");
        return this;
    }

    String status="",txnid="",date_time="",amt="",merchantDetails="";
    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(cancel1);
        status=title.getText();
        txnid=tvReviewValue.get(0).getText();
        date_time=tvReviewValue.get(1).getText();
        amt=tvReviewValue.get(2).getText();
        merchantDetails=tvReviewValue.get(3).getText();
        return new String[]{status,txnid,date_time,amt,merchantDetails};
    }

    public String toastMessage;
    public String getToast() throws InterruptedException, IOException {
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);
        return toastMessage;
    }
    
    
}
