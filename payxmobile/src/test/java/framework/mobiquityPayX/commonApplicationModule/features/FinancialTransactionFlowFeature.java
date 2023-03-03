package framework.mobiquityPayX.commonApplicationModule.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.CommonFeaturesPageObject;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.FinancialTransactionFlowPageObject;
import framework.mobiquityPayX.qnb.pageObjects.QNBSendMoneyPageObjects;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;
import utils.Utils;
import utils.W3CActions;

import javax.xml.crypto.Data;

import static initializers.TestInit.startPositveTest;

 
public class FinancialTransactionFlowFeature {

    LoginFeature loginFeature = new LoginFeature();
    QNBSendMoneyPageObjects sendMoneyPage = new QNBSendMoneyPageObjects();
    CommonFeaturesPageObject commonFeaturesPageObject = new CommonFeaturesPageObject();
    FinancialTransactionFlowPageObject financialTransactionFlowPage = new FinancialTransactionFlowPageObject();
    
    public FinancialTransactionFlowFeature financialTransactionFlow(String msisdn, String amt, String otpOrPin, String serviceType, WebElement element) {
        ExtentTest node = ExtentManager.getTest();
        try {
            startPositveTest();
            if (Config.isFirstTimeLogin) {
                loginFeature.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"), otpOrPin);
                Config.setFirstTimeLoginFalse();
            }
           // sendMoneyPage.clickOnMPay();
            financialTransactionFlowPage.clickOnFinancialService(element,serviceType).setPayee(msisdn);//.clickOnTickButton();
            if(financialTransactionFlowPage.isErrorLabelPresent()
                    || financialTransactionFlowPage.isDialogBoxPresent()
                    || financialTransactionFlowPage.isPopUpActionButtonOkPresent()){
                return this;
            }
            financialTransactionFlowPage.
                    setAmount(amt);
            if(financialTransactionFlowPage.isErrorLabelPresent() || financialTransactionFlowPage.isDialogBoxPresent() ){
                return this;
            }

            financialTransactionFlowPage.clickOnNextButton();
            if(financialTransactionFlowPage.isDialogBoxPresent() || financialTransactionFlowPage.isPopUpActionButtonOkPresent()){
                return this;
            }
            preValidation(amt,node);
            financialTransactionFlowPage.
                    clickOnTransferNow();
            //commonFeaturesPageObject.getOtp(DataDriven.getUserByStatus("Y"))
            twoFactorAuthentication(otpOrPin,serviceType,node);
            if(financialTransactionFlowPage.isPinErrorLabelPresentIOS()){
                return this;
            }
            if(Config.isValidationRequired){
                Config.setFalsePinValidationRequired();
                return this;
            }
            postValidation(serviceType,node);
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public FinancialTransactionFlowFeature preValidation(String amt, ExtentTest node){
        try {
            node.info("Payee Mobile Number : " + financialTransactionFlowPage.getPayeeDetails()[0]);
            node.info("Payee Name : " + financialTransactionFlowPage.getPayeeDetails()[1]);
            node.info("Transaction Amount : " + financialTransactionFlowPage.getPayeeDetails()[2]);
            node.info("Payer Avialable Balance : " + financialTransactionFlowPage.getPayeeDetails()[3]);
            node.info("Service Charge : " + financialTransactionFlowPage.getPayeeDetails()[4]);
            node.info("Net Payable : " + financialTransactionFlowPage.getPayeeDetails()[5]);
            node.info("Validation entered amount and amount displays on pre-confirmation screen");
            Assertion.verifyEqual("Service Charge : " + Utils.fetchDecimalNumber("2.0"),"Service Charge : " +Utils.fetchDecimalNumber(financialTransactionFlowPage.getPayeeDetails()[4]));
            Assertion.verifyEqual("Transaction Amount : " + amt, "Transaction Amount : " + Utils.fetchDecimalNumber(financialTransactionFlowPage.getPayeeDetails()[2]));
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public FinancialTransactionFlowFeature twoFactorAuthentication(String otpOrPin ,String serviceType, ExtentTest node){
        try{
            financialTransactionFlowPage.setPin(otpOrPin).clickOnVerifyPin();
            if(Config.isRetryOptionRequired){
                Config.setRetryOptionRequiredFalse();
                Assertion.verifyEqual(financialTransactionFlowPage.getTransactionFailureText(),"Provided Pin Authentication is missing or invalid.Remainig attempt:3");
                financialTransactionFlowPage.clickOnRetryButton();
            financialTransactionFlowPage.setPin(DataDriven.getUserPinByStatus("Y")).clickOnVerifyPin();
            postValidation(serviceType, node);
            }

        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public FinancialTransactionFlowFeature postValidation(String serviceType, ExtentTest node) {
        try{
        if (serviceType == "SEND_MONEY")
            Assertion.verifyEqual(financialTransactionFlowPage.getTransactionStatus(), MessageReader.getMessage("VAL_POST_TRANSACTION_002"));
        else
            Assertion.verifyEqual(financialTransactionFlowPage.getTransactionStatus(), MessageReader.getMessage("VAL_POST_TRANSACTION_001"));
        if (financialTransactionFlowPage.getTransactionStatus().equalsIgnoreCase(MessageReader.getMessage("VAL_POST_TRANSACTION_001"))
                || financialTransactionFlowPage.getTransactionStatus().equalsIgnoreCase(MessageReader.getMessage("VAL_POST_TRANSACTION_002"))) {
            node.pass("Transaction Successful");
            node.info("Post Transaction Amount : " + financialTransactionFlowPage.getTransactionDetails()[0]);
            //  node.info("Net Payable Amount : " + financialTransactionFlowPage.getTransactionDetails()[1]);
            node.info("Cashback : " + financialTransactionFlowPage.getTransactionDetails()[1]);
            node.info("Payee Mobile Number : " + financialTransactionFlowPage.getTransactionDetails()[2]);
            node.info("Payee Name : " + financialTransactionFlowPage.getTransactionDetails()[3]);
            node.info("Transaction ID : " + financialTransactionFlowPage.getTransactionDetails()[4]);
            node.info("Transaction Date : " + financialTransactionFlowPage.getTransactionDetails()[5]);
        }
            else {
            node.fail("Transaction Failed : " + financialTransactionFlowPage.getTransactionFailureText());
        }
    }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void afterTestHandler(){
        try{
            if(financialTransactionFlowPage.isDialogBoxPresent() )
                financialTransactionFlowPage.clickOnCancelButton();
           else if(financialTransactionFlowPage.isPopUpActionButtonOkPresent())
                financialTransactionFlowPage.clickOnReEnterButton();
           else if(financialTransactionFlowPage.isGoHomeButtonPresent())
                financialTransactionFlowPage.clickOnGoHome();
            while(!financialTransactionFlowPage.isHomeIconPresent()) {
                if(financialTransactionFlowPage.isHomeIconPresent())
                    break;
                else
                    financialTransactionFlowPage.clickOnBackButton();
            }
        }
        catch (Exception e){
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
