package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import entities.Transaction;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.SendMoneyPagePalestine;
import globalConstants.Config;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.Utils;

import java.io.IOException;

public class SendMoneyFeaturePalestine {
    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();
    SendMoneyPagePalestine page1 = new SendMoneyPagePalestine();
    LoginPagePalestine page = new LoginPagePalestine();


    public SendMoneyFeaturePalestine sendMoney(Transaction txn, String countrycode, String msisdn, String amt) {
        ExtentTest featureNode = ExtentManager.getTest();
        try {
            TestInit.startPositveTest();
            if (Config.isFirstTimeLogin) {
                customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }
            page1.clickOnSendMoneyIcon();
            // .selectCountryCode(countrycode)
            page1.setMsisdn(msisdn).setAmt(amt).clickOnSubmitButton();
            CommonUtils.pauseExecution(2);

            if (page.isClickOnOkisDisplayed()) {
                CommonUtils.captureScreenMobile(featureNode, "SEND MONEY ERROR MESSAGE");
            }
            else {
                page1.slideSubmitButton();
                CommonUtils.pauseExecution(3);
//                if (page1.isClickOnSubmitButtonDisplayed()) {
//                    do {
//                        CommonUtils.pauseExecution(2);
//                        page1.clickOnBackButton();
//                        System.out.println(page1.isClickOnSubmitButtonDisplayed());
//                    } while (page1.isClickOnSubmitButtonDisplayed());
//                }
                if (page.isClickOnOkisDisplayed()) {
                    CommonUtils.pauseExecution(2);
                }
                else if (page1.isHomeButtonDisplayed()) {
                    String transactiondetails[] = page1.getDetails();
                    CommonUtils.pauseExecution(3);
                    if (transactiondetails[0].equalsIgnoreCase("Successful")) {
                        Assertion.verifyEqual(transactiondetails[0], "Successful");
                        featureNode.pass("Transaction Successful and Transaction ID  :" + transactiondetails[1]);
                    }
                    else {
                        featureNode.fail("Transaction is not Successful and Transaction Status : " + transactiondetails[0] + " and Transaction ID : " + transactiondetails[1]);
                    }
                    CommonUtils.captureScreenMobile(featureNode, "Send Money Screenshot");
                    page1.clickOnHomeButton();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


    public void acceptAlert() {
        try {
            if (page.isClickOnOkisDisplayed()) {
                page.clickOnsnackbarButton();
                do {
                    CommonUtils.pauseExecution(2);
                    page1.clickOnBackButton();
                    System.out.println(page1.isClickOnSubmitButtonDisplayed());
                } while (page1.isClickOnSubmitButtonDisplayed());
            }

        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }


}
