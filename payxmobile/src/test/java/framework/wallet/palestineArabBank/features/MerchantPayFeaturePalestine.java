package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import entities.Transaction;
import framework.wallet.bharain.features.CustomerLoginBharain;
import framework.wallet.bharain.features.MerchantPaymentFeature;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.MerchantpaymentPage1;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.MerchantPayPagePalestine;
import globalConstants.Config;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class MerchantPayFeaturePalestine {

    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();
    MerchantPayPagePalestine merchantpaymentPage = new MerchantPayPagePalestine();
    LoginPagePalestine loginpage = new LoginPagePalestine();

    public String Mnumber;

    public MerchantPayFeaturePalestine MerchantPay(Transaction txn, String msisdn, String amount) throws InterruptedException, IOException {
        ExtentTest testCase = ExtentManager.getTest();
        startPositveTest();
        if(Config.isFirstTimeLogin){
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        Mnumber = msisdn;
        merchantpaymentPage.clickonMerchPayIcon();
        CommonUtils.pauseExecution(2);
        if (Mnumber == "978978978") {
            merchantpaymentPage.ClickOnCountryCode().ClickOnCode();
        }
        merchantpaymentPage.SetMerchNo(msisdn);
        merchantpaymentPage.SetAmount(amount);
        merchantpaymentPage.ClickOnSubmit();
        CommonUtils.pauseExecution(3);
        /*if(Config.toastCheck== true) {
            merchantpaymentPage.getToast();
            Config.setToastCheckFalse();
        }else*/
        if(loginpage.isSnackbarDisplayed()){
            testCase.info("Error message is displayed.");
        }
        else
            {
            merchantpaymentPage.clickOnSubmitButton();
            CommonUtils.pauseExecution(2);
            if(loginpage.isSnackbarDisplayed())
            {
                testCase.info("Error message is displayed.");
            }
            else
                {
                merchantpaymentPage.checkStatus();
                merchantpaymentPage.clickOnHomeButton();
            }
        }
        return this;
    }


    public void acceptAlert () {
        if (loginpage.isSnackbarDisplayed()) {
            loginpage.clickOnsnackbarButton();
       /* else if (merchantpaymentPage.isPreconfirmationScreenPresent()) {
            merchantpaymentPage.clickOnBackButton();
        }*/
            do {
                CommonUtils.pauseExecution(2);
                merchantpaymentPage.clickOnBackButton();
                System.out.println(merchantpaymentPage.isClickOnSubmitButtonDisplayed() + "UP");
            } while (merchantpaymentPage.isClickOnSubmitButtonDisplayed());
        }
    }
}
