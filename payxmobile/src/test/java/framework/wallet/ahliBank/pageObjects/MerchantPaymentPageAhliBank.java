package framework.wallet.ahliBank.pageObjects;

import globalConstants.Config;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;
import utils.W3CActions;

import java.io.IOException;
import java.util.List;

public class MerchantPaymentPageAhliBank extends AppPageInit {
    public MerchantPaymentPageAhliBank(){
        super();
    }

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/imgService")
    private List<WebElement> merchPayIcon ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etMerchantCode")
    private List<WebElement> merchcode ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnScanQR")
    private List<WebElement> Qr ;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/etMerchantName")
    private WebElement merchname ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etDescription")
    private WebElement description ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etPayableAmount")
    private WebElement PayableAmt ;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/i_accept_checked_view")
    private WebElement termsbox ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnNext")
    private WebElement next ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnConfirm")
    private WebElement confirm1 ;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private WebElement cancel1 ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnToolbarBack")
    private  List<WebElement> toolbarBckBtn;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")
    private WebElement otp ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvResend")
    private WebElement resend ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement confirm2 ;

    @AndroidFindBy(id="alertdialog_message_text")
    private WebElement alertMessageElem;

    @AndroidFindBy(id="alertdialog_ok_button")
    private WebElement alertOKBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement txnSuccessMessage;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvWalletBalanceAmount")
    private WebElement userWalletBalance;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")
    private WebElement OtpCancelBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement confirmCancelTransOTP;

    @AndroidFindBy(id ="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private WebElement OtpRetry;

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

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/welcomeText")
    private WebElement welcomeText;


    public String getMessageFromAlertBox(){
        return alertdialog.getText();
    }

    public String getWelcomeMessage(){
        return welcomeText.getText();
    }

    public  MerchantPaymentPageAhliBank clickonMerchPayIcon() throws InterruptedException {
        isElementNotPresent(merchPayIcon.get(2));
        clickOnElement(merchPayIcon.get(2), "Clicking on Pay to Merchant");
        return this;
    }

    public boolean isMerchIconVisible() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/imgService")).size()>0;
    }

    public  MerchantPaymentPageAhliBank setMerchCode(String merchCode){
        merchcode.clear();
        setText(merchcode.get(0),merchCode,"Merchant Code");
        return this;
    }

    public MerchantPaymentPageAhliBank QR(){
        clickOnElement(Qr.get(2),"Scanning Merchant QR");
        return this;
    }

    public  MerchantPaymentPageAhliBank setMerchantName(String merchantName){
        merchname.clear();
        setText(merchname,merchantName,"Merchant Name");
        return this;
    }

    public  MerchantPaymentPageAhliBank setDescription(String Description){
        description.clear();
        setText(description,Description,"Receiver Beneficiary Name");
        return this;
    }

    public  MerchantPaymentPageAhliBank setTransferAmt(String payableAmt){
        PayableAmt.clear();
        setText(PayableAmt,payableAmt,"Receiver Beneficiary Name");
        return this;
    }


    public MerchantPaymentPageAhliBank clickOnTermsCondition(){
        if(Config.isTermsAndCondNonClickable){
            clickOnElement(termsbox,"Terms and condition");
//            Config.setTermsAndCondNonClickable();
        }
        else {
            info("Skipping Terms and Conditon");
            }
        return this;
    }

    public MerchantPaymentPageAhliBank clickonTermsbox() throws InterruptedException {
        clickOnElement(termsbox,"Clicking on Terms and conditions");
        return this;
    }

    public MerchantPaymentPageAhliBank scrollToEndOfthePage() throws InterruptedException {
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        return this;
    }

    public MerchantPaymentPageAhliBank clickonNext() {
        clickOnElement(next,"Clicking on Next");
        return this;
    }

    public boolean isConfirmBtnPresent(){
        return driver.findElements(By.id("btnConfirm")).size()>0;
    }

    public boolean isAlertMessageAvailable(){
        return driver.findElements(By.id("alertdialog_message_text")).size()>0;
    }


    public MerchantPaymentPageAhliBank clickOnConfirm1() throws InterruptedException {
        clickOnElement(confirm1, "Clicking on Terms Confirm");
        return this;
    }

    public boolean isCancelButtonPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")).size()>0;
    }

    public MerchantPaymentPageAhliBank clickOnCancel1Btn() throws InterruptedException {
        clickOnElement(cancel1, "Clicking on Terms Cancel");
        return this;
    }

    public MerchantPaymentPageAhliBank clickOnToolBarBckBtn(){
        clickOnElement(toolbarBckBtn.get(0), "Clicking on tool bar back button");
        return this;
    }

    public MerchantPaymentPageAhliBank setOTP(String OTP) {
        setText(otp,OTP,"Setting up OTP");
        return this;
    }

    public MerchantPaymentPageAhliBank resendotp(){
        clickOnElement(resend,"resend OTP");
        return this;
    }

    public MerchantPaymentPageAhliBank clickonConfirm2() {
        clickOnElement(confirm2,"Clicking on confirm");
        return this ;
    }

    public MerchantPaymentPageAhliBank clickonOTPcancel() {
        clickOnElement(OtpCancelBtn,"cancelling the transaction");
        return this;
    }

    public boolean istitlePresent(){
        isElementNotPresent(title);
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/title")).size()>0;
    }

    public MerchantPaymentPageAhliBank clickonDone(){
        clickOnElement(done,"Transaction Done");
        return this;
    }

    public MerchantPaymentPageAhliBank clickOnAlertOK(){
        clickOnElement(alertOKBtn, "Clicking on OK button on alert screen");
        return this;
    }

    public boolean isOTPCancelBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")).size()>0;
    }

    public MerchantPaymentPageAhliBank cancelOtpTxn(){
        clickOnElement(confirmCancelTransOTP,"Cancelling Transaction OTP ");
        return this;
    }

    public MerchantPaymentPageAhliBank retryOtpTxn(){
        clickOnElement(OtpRetry,"Clicking  on retry OTP");
        return this;
    }

    public String getMessageFromOTPtitle(){
        return otptitle.getText();
    }

    public String toastMessage;
    public String getToast() throws InterruptedException, IOException {
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);
        return toastMessage;
    }

    public MerchantPaymentPageAhliBank touchOutside(){
        clickOnElement(touchOutside,"Clicking outside");
        return this;
    }

    public String getOTPcancelFlowMsg(){
        return cancelflow.getText();
    }



    public String getSucessMessage(){  return txnSuccessMessage.getText(); }

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
}
