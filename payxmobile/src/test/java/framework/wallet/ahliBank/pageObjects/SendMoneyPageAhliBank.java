package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;
import utils.W3CActions;

import java.util.List;

/**
 * Created by ayush.singh on 20-08-2020.
 */
public class SendMoneyPageAhliBank extends AppPageInit {

    public SendMoneyPageAhliBank() {
        super();
    }

    @AndroidFindBy(id= "imgService")
    private List<WebElement> sendMoneyIcon;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etMobileNumber")
    private WebElement mobileNum;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etBeneficiaryName")
    private WebElement beneficiaryName;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etAmount")
    private WebElement transferAmt;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/i_accept_checked_view")
    private WebElement termsLink;

    @AndroidFindBy(id="android.widget.FrameLayout")
    private WebElement alertDialogBox;

    @AndroidFindBy(id="btnNext")
    private WebElement nextBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirm")
    private WebElement confirmBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private WebElement cancelBtn;

    @AndroidFindBy(id="btnToolbarBack")
    private  WebElement toolbarBckBtn;

//    @AndroidFindBy(className="android.widget.LinearLayout")
//    private List<WebElement> selectName;
//
    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvContactName")
    private WebElement selectName;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")
    private WebElement OTPVerification;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement OtpConfirmBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")
    private WebElement OtpCancelBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/ibContacts")
    private WebElement selectContact;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement confirmCancelTransOTP;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private WebElement cancelCancelTransOTP;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement txnSuccessMessage;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvWalletBalanceAmount")
//    @AndroidFindBy(id = "ccom.ahlibank.ahlipay.subscriber.uat:id/tvBalanceAmount")
    private WebElement userWalletBalance;

//Alert Box
    @AndroidFindBy(id="alertdialog_message_text")
    private WebElement alertMessageElem;

    @AndroidFindBy(id="alertdialog_ok_button")
    private WebElement alertOKBtn;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etSearchContact")
    private  WebElement enterName;

    public SendMoneyPageAhliBank clickOnNext() throws InterruptedException {
        clickOnElement(nextBtn,"Clicking on Next");
        return this;
    }

    public SendMoneyPageAhliBank clickOnSendMoneyIcon() throws InterruptedException {
        clickOnElement(sendMoneyIcon.get(0), "Clicking on Pay to Merchant");
        return this;
    }

    public boolean isMsisdnFieldDisplayed(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etMobileNumber")).size()>0;
    }

    public boolean isSendMoneyIconAvailable(){
        return driver.findElements(By.id("imgService")).size()>0;
//        return sendMoneyIcon.get(0).isDisplayed();
    }

    public  SendMoneyPageAhliBank setMobileNumber(String mobileNumberStr){
        mobileNum.clear();
        setText(mobileNum,mobileNumberStr,"Receiver Mobile number");
        return this;
    }

    public  SendMoneyPageAhliBank setTransferAmt(String transferAmtStr){
        transferAmt.clear();
        setText(transferAmt,transferAmtStr,"Receiver Beneficiary Name");
        return this;
    }

    public  SendMoneyPageAhliBank setBeneficiaryName(String beneficiaryNameStr){
        beneficiaryName.clear();
        setText(beneficiaryName,beneficiaryNameStr,"Receiver Beneficiary Name");
        return this;
    }

    public boolean isTermsChecked(){
        return Boolean.parseBoolean(termsLink.getAttribute("Checked"));
    }

    public SendMoneyPageAhliBank clickOnTermsLink() throws InterruptedException {
        if (isTermsChecked()){
            return this;}
        else {
        clickOnElement(termsLink,"Clicking on Terms");
        return this;}
    }

    public SendMoneyPageAhliBank scrollToEndOfthePage() throws InterruptedException {
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        return this;
    }

    public boolean isConfirmBtnPresent(){
        return driver.findElements(By.id("btnConfirm")).size()>0;
    }

    public boolean isAlertMessageAvailable(){
        return driver.findElements(By.id("alertdialog_message_text")).size()>0;
    }


    public SendMoneyPageAhliBank clickOnConfirmBtn() throws InterruptedException {
        clickOnElement(confirmBtn, "Clicking on Terms Confirm");
        return this;
    }

    public boolean isCancelButtonPresent(){return driver.findElements(By.id("btnCancel")).size()>0;}

    public SendMoneyPageAhliBank clickOnCancelBtn() throws InterruptedException {
        clickOnElement(cancelBtn, "Clicking on Terms Cancel");
        return this;
    }

    public boolean isAlertDialogBoxPresent(){
       return driver.findElements(By.className("android.widget.FrameLayout")).size()>0;
    }

    public SendMoneyPageAhliBank clickOnToolBarBckBtn(){
        clickOnElement(toolbarBckBtn, "Clicking on tool bar back button");
        return this;
    }


    //For AlertBox
    public String getAlertMessage(){
        return alertMessageElem.getText();
    }

    public boolean isAlertOkPresent(){return driver.findElements(By.id("alertdialog_ok_button")).size()>0;}

    public SendMoneyPageAhliBank clickOnAlertOK(){
        clickOnElement(alertOKBtn, "Clicking on OK button on alert screen");
        return this;
    }


    public boolean isOTPFeildPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")).size()>0;
    }

    public SendMoneyPageAhliBank enterOTP(String OTPvalue){
        OTPVerification.clear();
        setText(OTPVerification,OTPvalue,"Entering OTP");
        return this;
    }


    public boolean isOTPConfirmBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")).size()>0;
    }

    public SendMoneyPageAhliBank clickOnOTPConfirmBtn(){
        if(isOTPConfirmBtnPresent()){
        clickOnElement(OtpConfirmBtn, "Clicking on confirm button on OTP screen");}
        return this;
    }

    public boolean isOTPCancelBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")).size()>0;
    }

    public SendMoneyPageAhliBank clickOnOTPCancelBtn(){
            clickOnElement(OtpCancelBtn, "Clicking on cancel button on OTP screen");
        return this;
    }

    public SendMoneyPageAhliBank clickOnConfirmCancelBtn(){
        if(driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")).size()>0){
            clickOnElement(confirmCancelTransOTP, "Clicking on confirm button on cancel transaction on otp screen");}
        return this;
    }

    public boolean isTxnSuccessMessagePresent(){
        return driver.findElements(By.id("title")).size()>0;
    }

    public String getSucessMessage(){  return txnSuccessMessage.getText(); }

    public float getUserBalance(){
        String userBal = userWalletBalance.getText();
        return Float.parseFloat(userBal.substring(4).replaceAll(",",""));
    }

    public SendMoneyPageAhliBank clickOnContact(){
        clickOnElement(selectContact,"Seelct Contact");
        return this;
    }

    public SendMoneyPageAhliBank selectName(){
        setText(enterName,"Ahli","Enter Name");
        clickOnElement(selectName,"Cick on Name");
        return this;
    }
}
