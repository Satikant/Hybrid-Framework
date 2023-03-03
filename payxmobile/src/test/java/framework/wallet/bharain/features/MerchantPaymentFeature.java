package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import entities.Transaction;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.MerchantpaymentPage1;
import globalConstants.Config;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;


public class MerchantPaymentFeature {
    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    MerchantpaymentPage1 MPayPage = new MerchantpaymentPage1();
    LoginPageBharain loginpage = new LoginPageBharain();

    public MerchantPaymentFeature MerchantPay(Transaction txn, String msisdn, String amount) {
        ExtentTest testCase = ExtentManager.getTest();
        startPositveTest();
        if (Config.isFirstTimeLogin) {
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();

        }
        MPayPage.clickOnmerchantpayicon();
        MPayPage.SetMerchNo(msisdn);
        MPayPage.SetAmount(amount);
        MPayPage.ClickOnSubmit();
        if (Config.toastCheck) {
            MPayPage.getToast();
            Config.setToastCheckFalse();
        } else if (loginpage.isSnackbarDisplayed()) {
            testCase.info("Error message is displayed.");
        } else {
            MPayPage.ClickOnSubmit();
            CommonUtils.pauseExecution(2);
            if (loginpage.isSnackbarDisplayed()) {
                testCase.info("Error message is displayed.");
            } else {
                MPayPage.checkStatus();
                MPayPage.clickOnHomeButton();
            }
        }
        return this;
    }


    public void acceptAlert() {
        if (loginpage.isSnackbarDisplayed()) {
            loginpage.clickOnsnackbarButton();
            do {
                CommonUtils.pauseExecution(2);
                MPayPage.clickOnBackButton();
                System.out.println(MPayPage.isClickOnSubmitButtonDisplayed() + "UP");
            } while (MPayPage.isClickOnSubmitButtonDisplayed());
        }else if(MPayPage.isClickOnSubmitButtonDisplayed()){
            MPayPage.clickOnBackButton();
        }
    }
}


