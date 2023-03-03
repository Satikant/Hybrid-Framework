package framework.wallet.ahliBank.pageObjects;


import globalConstants.Config;
import initializers.AppPageInit;



import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class BillPayPageAhliBank extends AppPageInit{

    public BillPayPageAhliBank(){
        super();
    }

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/imgService")
    private List<WebElement> selectBillPay;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvProviderTitle")
    private List<WebElement> selectBiller;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etQatarID")
    private WebElement etQatarID ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etServiceNumber")
    private WebElement etServiceNumber ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/fetchBillDetailsButton")
    private WebElement fetchBillDetailsButton ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/billOption1")
    private WebElement selectfetchedamt ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/billOption3")
    private WebElement preferredamt ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etBillNickName")
    private WebElement etBillNickName ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/i_accept_checked_view")
    private WebElement terms_cond ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnSubmit")
    private WebElement btnSubmit ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private WebElement btnCancel ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvBillAmount")
    private WebElement billamount ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etPreferedBillAmount")
    private WebElement etPreferedBillAmount ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnConfirm")
    private WebElement btnConfirm ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/etOTPEditText")
    private WebElement etOTPEditText ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/btnConfirmOTPAction")
    private WebElement btnConfirmOTPAction ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/title")
    private WebElement title ;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvReviewValue")
    private List<WebElement> tvReviewValue ;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_message_text")
    private WebElement alertdialog;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_ok_button")
    private  WebElement btnOk;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/pb_loading")
    private  WebElement pb_loading;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnToolbarBack")
    private  WebElement btnToolbarBack;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvResend")
    private  WebElement tvResend;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancelOTPAction")
    private  WebElement btnCancelOTPAction;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private  WebElement btnPositiveAction;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private  WebElement btnNegativeAction;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private  WebElement tvTitle;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvMessage")
    private  WebElement tvMessage;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/welcomeText")
    private WebElement welcomeText;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnAddToFavourites")
    private WebElement btnAddToFavourites;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etFavTxnName")
    private WebElement etFavTxnName;

    /*@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnSubmit")
    private WebElement btnSubmit;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private WebElement btnCancel;*/

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvItemName")
    private List<WebElement> selectService;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etRechargeMobileNumber")
    private WebElement etRechargeMobileNumber;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rechargeTopupSpinnerOoredoo")
    private WebElement amtDropdown;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/planItem")
    private List<WebElement> selectAmount;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etRechargeNickName")
    private WebElement etRechargeNickName;

    /*@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rechargeTopupSpinnerOoredoo")
    private WebElement amtDropdown;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rechargeTopupSpinnerOoredoo")
    private WebElement amtDropdown;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/rechargeTopupSpinnerOoredoo")
    private WebElement amtDropdown;*/


    public String getMessageFromAlertBox(){
        try{
            return alertdialog.getText();
        }
        catch (Exception e) {
             e.printStackTrace();
             return "";
        }
    }


    public BillPayPageAhliBank clickOnBillPay(String paymentType){
        isElementNotPresent(selectBillPay.get(1));
        if(paymentType.equalsIgnoreCase("BILLPAY")){
            clickOnElement(selectBillPay.get(1),"Bill Payment");
        }
        else{
            clickOnElement(selectBillPay.get(3),"Data And Top UP");
        }
        return this;
    }

    public boolean isListOfBillerDisplayed(){
        return driver.findElements(By.id("tvSelectProvider")).size()>0;
    }

    public BillPayPageAhliBank selectKahramaa(){
        isElementNotPresent(selectBiller.get(0));
        clickOnElement(selectBiller.get(0),"Kahramaa");
        return this;
    }

    public BillPayPageAhliBank selectOoredoo(){
        clickOnElement(selectBiller.get(1),"Ooredo");
        return this;
    }

    public BillPayPageAhliBank selectVodafone(){
        clickOnElement(selectBiller.get(2),"Vodafone");
        return this;
    }

    public void selectBiller(String billpaymethod) throws InterruptedException {
        switch (billpaymethod) {
            case "KAHRAMAA":
                selectKahramaa();
                break;

            case "OOREDOO":
                selectOoredoo();
                break;

            case "VODAFONE":
                selectVodafone();
                break;

            default:
                throw new UnsupportedOperationException(billpaymethod+":- This method is not supported");
        }
    }

    public BillPayPageAhliBank setQatarId(String qatarId){
        etQatarID.clear();
        setText(etQatarID,qatarId,"Qatar ID");
        return this;
    }

    public BillPayPageAhliBank setServiceNumber(String serviceno){
        etServiceNumber.clear();
        setText(etServiceNumber,serviceno,"Service Number");
        return this;
    }

    public BillPayPageAhliBank clickOnFetchDetails(){
        clickOnElement(fetchBillDetailsButton,"Fetch Details");
        return this;
    }

    public BillPayPageAhliBank clickOnPreferredAmt(){
        if(!preferredamt.isSelected()){
            clickOnElement(preferredamt,"Preferred Amount");
        }
        return this;
    }

    public BillPayPageAhliBank setNickname(String nickname){
        setText(etBillNickName,nickname,"Nickname");
        return this;
    }

    public BillPayPageAhliBank clickOnTermsCondition(){
        if(Config.isTermsAndCondNonClickable){
            Config.setTermsAndCondNonClickable();
        }
        else{
            if(!terms_cond.isSelected()){
                clickOnElement(terms_cond,"Terms and condition");
            }
        }
        return this;
    }

    public boolean isFetchedAmtDisplayed(){
        isElementNotPresent(billamount);
        return driver.findElements(By.id("tvBillAmount")).size()>0;
    }

    public BillPayPageAhliBank setAmount(String amt){
        setText(etPreferedBillAmount,amt,"Amount");
        return this;
    }

    public BillPayPageAhliBank clickOnSubmit(){
        clickOnElement(btnSubmit,"Submit Button");
        return this;
    }

    public BillPayPageAhliBank clickOnConfirm(){
        clickOnElement(btnConfirm,"Confirm Button");
        return this;
    }

    public BillPayPageAhliBank clickOnCancel(){
        clickOnElement(btnCancel,"Cancel Button");
        return this;
    }

    public boolean isDoneButtonDisplayed(){
        return driver.findElements(By.id("btnCancel")).size()>0;
    }

    public BillPayPageAhliBank enterOtp(String otp){
        isElementNotPresent(etOTPEditText);
        setText(etOTPEditText,otp,"OTP");
        return this;
    }

    public boolean isbtnConfirmOTPAction(){
        return driver.findElements(By.id("btnConfirmOTPAction")).size()>0;
    }

    public BillPayPageAhliBank clickOnConfirmOtp(){
        CommonUtils.pauseExecution(1);
        if(isbtnConfirmOTPAction()){
            clickOnElement(btnConfirmOTPAction,"Confirm OTP");
        }
        return this;
    }

    String status="",txnid="",date_time="",amt="",billPayedTo="";

    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(btnCancel);
        status=title.getText();
        txnid=tvReviewValue.get(0).getText();
        date_time=tvReviewValue.get(1).getText();
        amt=tvReviewValue.get(2).getText();
        billPayedTo=tvReviewValue.get(3).getText();
        return new String[]{status,txnid,date_time,amt,billPayedTo};
    }

    public boolean isAlertDialogOkButtonDisplayed(){
        return driver.findElements(By.id("alertdialog_ok_button")).size()>0;
    }

    public BillPayPageAhliBank clickOnOk(){
        clickOnElement(btnOk,"Okay Button");
        return this;
    }

    public BillPayPageAhliBank waitTillLoaderDisplayed(){
         isElementNotPresent(pb_loading);
         return this;
    }

    public boolean isLoaderDisplayed(){
        return driver.findElements(By.id("pb_loading")).size()>0;
    }

    public BillPayPageAhliBank clickOnBackButton(){
        clickOnElement(btnToolbarBack,"Back Button");
        return this;
    }

    public BillPayPageAhliBank clickOnResendOtp() throws IOException, InterruptedException {
        clickOnElement(tvResend,"Re-send Button");
        String toastMessage = Utils.getToastMessage();
        return this;
    }

    public BillPayPageAhliBank clickOnCancelOtp(){
        clickOnElement(btnCancelOTPAction,"Cancel Button Otp Page");
        return this;
    }

   public boolean isBtnPositiveAction(){
        return driver.findElements(By.id("btnPositiveAction")).size()>0;
   }

    public boolean isOtpFieldDisplayed(){
        return driver.findElements(By.id("etOTPEditText")).size()>0;
    }



    public BillPayPageAhliBank clickOnPositiveAction(){
        clickOnElement(btnPositiveAction,"Yes, Cancel Button Otp Page");
        return this;
    }

    public String getMessageFromOtpBox(){
        return tvTitle.getText();
    }

    public BillPayPageAhliBank clickOnNegativeAction(){
        clickOnElement(btnNegativeAction,"No, Retry Button Otp Page");
        return this;
    }

    public BillPayPageAhliBank clickOnAddFavouriteTransaction(){
        clickOnElement(btnAddToFavourites,"Add Favourite Transaction");
        return this;
    }

    public BillPayPageAhliBank setFavouriteTransactionName(String transactionName){
        setText(etFavTxnName, transactionName,"Favourite Transaction Name");
        return this;
    }

    public String getWelcomeMessage(){
        return welcomeText.getText();
    }

    public boolean isWelcomeTextAvailable(){
        return driver.findElements(By.id("welcomeText")).size()>0;
    }

    public BillPayPageAhliBank clickOnTopUp(){
        clickOnElement(selectService.get(0),"Top Up");
        return this;
    }

    public BillPayPageAhliBank clickOnBillPayment(){
        clickOnElement(selectService.get(1),"Top Up");
        return this;
    }

    public BillPayPageAhliBank clickOnDataRecharge(){
        clickOnElement(selectService.get(2),"Data Recharge");
        return this;
    }

    public BillPayPageAhliBank clickOnAmountField(){
        clickOnElement(amtDropdown,"Amount Field");
        return this;
    }

    public BillPayPageAhliBank selectAmount(int i){
        clickOnElement(selectAmount.get(0),"Add Favourite Transaction");
        return this;
    }


}
