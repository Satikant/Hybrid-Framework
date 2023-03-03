package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import common.Assertion;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;

public class WalletsPO extends AppPageInit {
    public WalletsPO(){ super();}

    @AndroidFindBy(xpath = "//*[@text='Wallets']")
    public WebElement walletTitle;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/walletErrorLabelTextView")
    public WebElement walletErrormessage;
    @AndroidFindBy(xpath ="//*[@text='Inter-wallet transfer']")
    public WebElement interwallettransfer;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/confirmation_action_button")
    public WebElement nextBtnconfirmation;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/confirmation_cancel_button")
    public WebElement cancelBtn;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/amountEdittext")
    public WebElement amountedit;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/nextButton")
    public WebElement nextBtnInWallet;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/transactionconfirmation_next_button")
    public WebElement transferBtn;

    @AndroidFindBy(id = "otp_edit_text")
    public WebElement mpinbutton;

    @AndroidFindBy(xpath = "//*[@text='Verify']")
    public WebElement verify;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/transactionstatus_status_text")
    public WebElement transactionStatus;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/transactionstatusGoToHomeButton")
    public WebElement goHomeBtn;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_message_textView")
    public WebElement errormessage;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")
    public WebElement okBtnInDialog;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/toolbar_icon")
    public WebElement backBtn;

    public WalletsPO walletflow(){
        if (isElementNotPresent(interwallettransfer,20)){
            clickOnElement(interwallettransfer,"Clicking on Inter wallet transfer button");
            clickOnElement(nextBtnconfirmation, "Clicking on Next button as transfer confirmation");
            setText(amountedit, "1","Amount is provided");
            clickOnElement(nextBtnInWallet,"Clicking on next button");
            //To handle Error message after clicking on next button
            try {
                clickOnElement(transferBtn, "Clicking on TransferNow button");
                //To handle mpin verification
                isElementNotPresent(mpinbutton, 100);
                clickOnElement(mpinbutton, "pin verification field");
                setText(mpinbutton, "1357", "Entering the Pin");
                isElementNotPresent(verify);
                clickOnElement(verify, "verify pin");
                isElementNotPresent(goHomeBtn, 100);
                getText(transactionStatus, "To capture transaction status");
                Assertion.verifyEqual(getTransactionstatusText(),"Transaction successful");
                clickOnElement(goHomeBtn, "Clicking on goto home button");
            }catch (Exception e){
                getText(errormessage, "To capture error mesage");
                clickOnElement(okBtnInDialog, "Clicking on Ok button");
                clickOnElement(backBtn, "Clicking on back button");
            }
        }else {
            getText(walletErrormessage,"No balance in wallet");
        }
        return this;
    }

    public String getErrormessageText(){
        try{
            waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+ errormessage.getText());
            return errormessage.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

    public String getWalletTitle(){
        try{
            waitUntilElementDisappear("//*[@text='Wallets']");
            info("Fetching Text : "+ walletTitle.getText());
            return walletTitle.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }


    public String getTransactionstatusText(){
        try{
            //waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+transactionStatus.getText());
            return transactionStatus.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

}
