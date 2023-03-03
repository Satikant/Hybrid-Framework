package framework.wallet.ahliBank.features;


import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.BillPayPageAhliBank;
import globalConstants.Config;
import globalConstants.VariableConstant;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.*;

import static initializers.TestInit.startPositveTest;

/**
 * Created by ayush.singh on 23-09-2020.
 */
public class BillPayFeatureAhliBank {
    boolean transactionDetailsFlag;

    CustomerLoginAhliBank login=new CustomerLoginAhliBank();
    BillPayPageAhliBank billPayPage=new BillPayPageAhliBank();


    public BillPayFeatureAhliBank billPay(String qatarid,String serviceno,String nickname,String amt,String otp,String transactionName,String biller,String service){
        ExtentTest node = ExtentManager.getTest();
        try{
            startPositveTest();
                if(Config.isFirstTimeLogin) {
                    login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                    Config.setFirstTimeLoginFalse();
                    billPayPage.clickOnBillPay(service);
            }
            billPayPage.selectBiller(biller);
            billPayPage.clickOnBillPayment();
            billPayPage.setQatarId(qatarid).setServiceNumber(serviceno).clickOnFetchDetails();
                if(!billPayPage.isLoaderDisplayed()){
                    if(billPayPage.isAlertDialogOkButtonDisplayed()){
                        if(Config.isAssertionRequiredCheck){
                            node.fail("Unable to fetch details");
                            node.info(billPayPage.getMessageFromAlertBox());
                            Config.setAssertionRequiredCheckFalse();
                        }
                        else{
                            node.info("Negative Case Flow");
                        }
                    }
                    else{
                        node.fail("Unable to fetch details");
                    }
                }
                else if(billPayPage.isLoaderDisplayed()){
                    CommonUtils.pauseExecution(2);
                    if(billPayPage.isAlertDialogOkButtonDisplayed()){
                        if(Config.isAssertionRequiredCheck){
                            node.fail("Unable to fetch details");
                            node.info(billPayPage.getMessageFromAlertBox());
                            Config.setAssertionRequiredCheckFalse();
                        }
                        else{
                            node.info("Negative Case Flow");
                        }
                    }
                    else if(billPayPage.isFetchedAmtDisplayed()){
                        W3CActions w3CActions = new W3CActions();
                        w3CActions.scrollDown();
                        billPayPage.clickOnPreferredAmt().setAmount(amt).setNickname(nickname).clickOnTermsCondition().clickOnSubmit();
                        if(billPayPage.isAlertDialogOkButtonDisplayed()){
                            node.info("Negative Case Flow");
                        }
                        else{
                            billPayPage.clickOnConfirm();
                            if(billPayPage.isAlertDialogOkButtonDisplayed()){
                                node.info("Negative Case Flow");
                            }
                            else{
                                otpValidation(otp);
                                if(billPayPage.isAlertDialogOkButtonDisplayed()){
                                    node.info("Negative Case Flow");
                                    if(Config.isMultipleOtpValidationCheck) {
                                        multipleOtpValidation(otp);
                                        Config.setMultipleOtpValidationCheckFalse();
                                    }
                                }
                                else if(transactionDetailsFlag){
                                    String transactiondetails[] = billPayPage.getDetails();
                                    VariableConstant.TRANSACTION_STATUS=transactiondetails[0];
                                    VariableConstant.TRANSACTION_ID=transactiondetails[1];
                                    VariableConstant.TRANSACTION_DATE_TIME=transactiondetails[2];
                                    VariableConstant.TRANSACTION_AMOUNT=transactiondetails[3];
                                    VariableConstant.PROVIDER=transactiondetails[4];
                                    node.info("Transaction Status : " + VariableConstant.TRANSACTION_STATUS);
                                    node.info("Transaction ID : " + VariableConstant.TRANSACTION_ID);
                                    node.info("Transaction Date and Time : " + VariableConstant.TRANSACTION_DATE_TIME);
                                    node.info("Transaction Amount : " + VariableConstant.TRANSACTION_AMOUNT);
                                    node.info("Bill Payed To : " + VariableConstant.PROVIDER);
                                    if(VariableConstant.TRANSACTION_STATUS.equalsIgnoreCase("Bill Payment Successful!")){
                                        node.pass("Transaction Pass");
                                        Assertion.verifyEqual(VariableConstant.PROVIDER,biller+" | "+serviceno);
                                    }
                                    else{
                                        node.fail("Transaction Fail");
                                    }
                                    if(Config.isFavouriteTransactionCheck){
                                        favoutiteTransactionValidation(transactionName);
                                        Config.setFavouriteTransactionCheckFalse();
                                    }
                                    else{
                                        node.info("Favourite Transaction Check Skip");
                                    }
                                }
                            }

                        }
                    }
                    else{
                        node.fail("Unable to fetch details");
                    }
                }
                else{
                    node.fail("Unable to fetch details");
                }

        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }


    public BillPayFeatureAhliBank otpValidation(String otp)  {
        ExtentTest node = ExtentManager.getTest();
        try{
            if(Config.isOtpPositiveAction){
                billPayPage.enterOtp(otp).clickOnConfirmOtp();
                transactionDetailsFlag=true;
            }
            else if(Config.toastCheck){
                billPayPage.clickOnResendOtp();
                Config.setToastCheckFalse();
                Config.setOtpPositiveActionTrue();
                transactionDetailsFlag=false;
            }
            else{
                transactionDetailsFlag=false;
                Config.setOtpPositiveActionTrue();
                billPayPage.clickOnCancelOtp();
                Assertion.verifyEqual(billPayPage.getMessageFromOtpBox(), MessageReader.getMessage("Error_AH_BillPay_020"));
                if(Config.isOtpRetry){
                    Config.setOtpRetryFalse();
                    billPayPage.clickOnNegativeAction();
                    node.pass("Test Case Pass");
                }
                else{
                    billPayPage.clickOnPositiveAction();
                    Assertion.verifyContains(billPayPage.getWelcomeMessage(), MessageReader.getMessage("Error_AH_BillPay_019"));
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public BillPayFeatureAhliBank multipleOtpValidation(String otp){
        ExtentTest node = ExtentManager.getTest();
        try{
            Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
            billPayPage.clickOnOk();
            otpValidation(otp);
            Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
            billPayPage.clickOnOk();
            otpValidation(otp);
            Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
            billPayPage.clickOnOk();
            otpValidation(otp);
            Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_016"));
            billPayPage.clickOnOk();
            otpValidation(otp);
            String transactiondetails[] = billPayPage.getDetails();
            node.pass("Transaction Fail");
            node.info("Transaction Status : " + transactiondetails[0]);
            node.info("Transaction ID : " + transactiondetails[1]);
            node.info("Transaction Date and Time : " + transactiondetails[2]);
            node.info("Transaction Amount : " + transactiondetails[3]);
            node.info("Bill Payed To : " + transactiondetails[4]);
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public BillPayFeatureAhliBank favoutiteTransactionValidation(String transactionName){
        ExtentTest node = ExtentManager.getTest();
        try{
            billPayPage.clickOnAddFavouriteTransaction().setFavouriteTransactionName(transactionName).clickOnSubmit();
            if(billPayPage.isAlertDialogOkButtonDisplayed()){
                Assertion.verifyEqual(billPayPage.getMessageFromAlertBox(), MessageReader.getMessage("Error_AH_BillPay_022"));
                billPayPage.clickOnOk();
                billPayPage.clickOnCancel();
            }
            else{
                String toastMessage = Utils.getToastMessage();
                node.pass("Successfully added the transaction as Favourite");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }



    public BillPayFeatureAhliBank acceptAlert(String service){
        if(billPayPage.isAlertDialogOkButtonDisplayed()){
            billPayPage.clickOnOk();
            do{
                    billPayPage.clickOnBackButton();
            }while(!billPayPage.isListOfBillerDisplayed());
        }
        else if(billPayPage.isWelcomeTextAvailable()){
            billPayPage.clickOnBillPay(service);
        }
        else if(billPayPage.isOtpFieldDisplayed()){
            do{
                billPayPage.clickOnBackButton();
            }while(!billPayPage.isListOfBillerDisplayed());
        }
        else if(billPayPage.isDoneButtonDisplayed()){
            billPayPage.clickOnCancel();
            billPayPage.clickOnBillPay(service);
        }
        else{
            do{
                billPayPage.clickOnBackButton();
            }while(!billPayPage.isListOfBillerDisplayed());
        }
        return this;
    }
}
