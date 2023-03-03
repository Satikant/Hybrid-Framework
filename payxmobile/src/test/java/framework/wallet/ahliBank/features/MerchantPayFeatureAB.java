package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.LoginPageAhliBank;
import framework.wallet.ahliBank.pageObjects.MerchantPaymentPageAhliBank;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.xmlbeans.impl.xb.xmlschema.SpaceAttribute;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class MerchantPayFeatureAB {

    MerchantPaymentPageAhliBank page = new MerchantPaymentPageAhliBank();
    CustomerLoginAhliBank login = new CustomerLoginAhliBank();
    LoginPageAhliBank page2 = new LoginPageAhliBank();


    public MerchantPayFeatureAB PaytoMerchant(String Merchcode, String Merchname, String Description, String Amt, String Otp /*boolean... tnc*/) {
        ExtentTest featureNode = ExtentManager.getTest();
//        ExtentTest featureNode = ExtentManager.getTest();
        try {
            startPositveTest();
            if (Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }
            page.clickonMerchPayIcon()
                    .setMerchCode(Merchcode)
                    .setMerchantName(Merchname)
                    .setDescription(Description)
                    .setTransferAmt(Amt);

            if(Config.isTermsAndCondNonClickable) {
                page.clickOnTermsCondition();
            }
            page.scrollToEndOfthePage().clickonNext();

            if (page.isAlertMessageAvailable()) {
                featureNode.info("Negative Test case flow");
            }
            else if (page.isConfirmBtnPresent()) {
                page.clickOnConfirm1();

                if(Config.isOtpCancel){
                    page.clickonOTPcancel();
                    return this;
                }
                page.setOTP(Otp);
                CommonUtils.pauseExecution(2);
                if (page.isAlertMessageAvailable()) {
                    featureNode.info("Negative Test case Flow");
                }
                CommonUtils.pauseExecution(2);
                if (page.isCancelButtonPresent()) {

                    page.clickonConfirm2();
                }
                else
                if (page.istitlePresent()) {
                    Assertion.verifyEqual(page.getSucessMessage(), MessageReader.getMessage("Msg_AH_Mpay_001"));
                    String transactiondetails[] = page.getDetails();
                    featureNode.info("Transaction Status : " + transactiondetails[0]);
                    featureNode.info("Transaction ID : " + transactiondetails[1]);
                    featureNode.info("Transaction Date and Time : " + transactiondetails[2]);
                    featureNode.info("Transaction Amount : " + transactiondetails[3]);
                    featureNode.info("Merchant Details : " + transactiondetails[4]);
                    page.getDetails();page.clickonDone();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;

    }

    public MerchantPayFeatureAB termsbox(String Merchcode , String Merchname , String Description , String Amt ,String Otp) {
        try {
            page.clickonMerchPayIcon().setMerchCode(Merchcode).setMerchantName(Merchname).setDescription(Description).setTransferAmt(Amt);
            page.scrollToEndOfthePage();
            page.clickonNext();
            Assertion.verifyEqual(page2.getMessageFromAlertBox(),"Please accept terms & conditions");
            page.clickOnAlertOK().clickOnToolBarBckBtn();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    public void acceptAlert () {
        if (page.isAlertMessageAvailable()) {
            page.clickOnAlertOK();
        }
        if (page.isMerchIconVisible()) {
            return;
        } else {
            do {
                CommonUtils.pauseExecution(2);
                page.clickOnToolBarBckBtn();
                System.out.println(page.isMerchIconVisible() + "UP");
            } while (!page.isMerchIconVisible());
        }
    }
}
