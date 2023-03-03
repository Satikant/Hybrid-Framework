package framework.mobiquityPayX.qnb.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.commonApplicationModule.pageObjects.CommonFeaturesPageObject;
import framework.mobiquityPayX.qnb.pageObjects.QNBSendMoneyPageObjects;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.MessageReader;

import static initializers.TestInit.startPositveTest;

public class QNBSendMoneyFeature extends CommonFeaturesPageObject {

    QNBLoginFeature loginFeature = new QNBLoginFeature();
    QNBSendMoneyPageObjects sendMoneyPage = new QNBSendMoneyPageObjects();
    FinancialTransactionFlowFeature financialTransactionFlow =  new FinancialTransactionFlowFeature();

    public QNBSendMoneyFeature SendMoney(String msisdn, String amt, String otpOrPin, String serviceType) {
        ExtentTest node = ExtentManager.getTest();
        try {

            financialTransactionFlow.financialTransactionFlow(msisdn, amt,  otpOrPin, serviceType,sendMoneyPage.qnbSendMoneyIcon());
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public QNBSendMoneyFeature mPay(String msisdn, String amt, String otp, String serviceType) {
        ExtentTest node = ExtentManager.getTest();
        try {
            startPositveTest();
            if (Config.isFirstTimeLogin) {
                loginFeature.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"), otp);
                Config.setFirstTimeLoginFalse();
            }
            sendMoneyPage.
                    clickOnMPay().
                    selectService(serviceType);
            sendMoneyPage.setPayee(msisdn, serviceType).
                    setAmount(amt).
                    clickOnNextButton();
            node.info("Payee Mobile Number : " + sendMoneyPage.getPayeeDetails()[0]);
            node.info("Payee Name : " + sendMoneyPage.getPayeeDetails()[1]);
            node.info("Transaction Amount : " + sendMoneyPage.getPayeeDetails()[2]);
            node.info("Payer Avialable Balance : " + sendMoneyPage.getPayeeDetails()[3]);
            node.info("Validation entered amount and amount displays on pre-confirmation screen");
            Assertion.verifyEqual(amt, utils.Utils.fetchDecimalNumber(sendMoneyPage.getPayeeDetails()[2]));
            sendMoneyPage.
                    clickOnTransferNow();
            setOtp(otp,msisdn)
                    .clickOnVerifyOtp();
            if (serviceType == "SEND_MONEY")
                Assertion.verifyEqual(sendMoneyPage.getTransactionStatus(), MessageReader.getMessage("VAL_QNB_SM_001"));
            else
                Assertion.verifyEqual(sendMoneyPage.getTransactionStatus(), MessageReader.getMessage("VAL_QNB_SM_002"));
            if (sendMoneyPage.getTransactionStatus().equalsIgnoreCase(MessageReader.getMessage("VAL_QNB_SM_001"))
                    || sendMoneyPage.getTransactionStatus().equalsIgnoreCase(MessageReader.getMessage("VAL_QNB_SM_002"))) {
                node.pass("Transaction Successful");
                node.info("Post Transaction Amount : " + sendMoneyPage.getTransactionDetails()[0]);
              //  node.info("Net Payable Amount : " + sendMoneyPage.getTransactionDetails()[1]);
              //  node.info("Service Charge : " + sendMoneyPage.getTransactionDetails()[2]);
                node.info("Payee Mobile Number : " + sendMoneyPage.getTransactionDetails()[1]);
                node.info("Payee Name : " + sendMoneyPage.getTransactionDetails()[2]);
                node.info("Transaction ID : " + sendMoneyPage.getTransactionDetails()[3]);
                node.info("Transaction Date : " + sendMoneyPage.getTransactionDetails()[4]);
            } else {
                node.fail("Transaction Failed : " + sendMoneyPage.getTransactionFailureText());
            }

            sendMoneyPage.clickOnGoHome();
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }
}
