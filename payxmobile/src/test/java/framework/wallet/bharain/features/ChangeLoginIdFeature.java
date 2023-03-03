package framework.wallet.bharain.features;

import framework.wallet.bharain.pageObjects.ChangeEmailIdPage;
import framework.wallet.bharain.pageObjects.ForgotPinPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.SplitBillPage;
import globalConstants.Config;
import initializers.TestInit;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;

public class ChangeLoginIdFeature {
    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    ChangeEmailIdPage changeEmailIdPage = new ChangeEmailIdPage();
    SplitBillPage splitBillPage = new SplitBillPage();
    LoginPageBharain page = new LoginPageBharain();
    ForgotPinPage forgotPinPage = new ForgotPinPage();

    public ChangeLoginIdFeature changeLoginId(String email, String otp) {
        TestInit.startPositveTest();
        if (Config.isFirstTimeLogin) {
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        if (changeEmailIdPage.isUserNamePresent()) {
            changeEmailIdPage.clickOnUserName().clickOnEdit();
        }
        if (changeEmailIdPage.isEmailIdPresent()) {
            changeEmailIdPage.setNewEmailId(email).clickOnSave();
        }
        if (Config.toastCheck) {
            changeEmailIdPage.getToast();
            Config.setToastCheckFalse();
        }
        if (forgotPinPage.isOtpScreenDisplayed()) {
            changeEmailIdPage.enterOtp(otp).clickOnVerify();
        }
        return this;
    }

    public void afterMethod() {
        if (changeEmailIdPage.isHomeBtnPresent()) {
            changeEmailIdPage.clickOnHomebtn();
        }
        if (changeEmailIdPage.isEmailIdPresent() || splitBillPage.isCreateButtonPresent()) {
            changeEmailIdPage.clickBack();
        }
       if (splitBillPage.isClickOnOkisDisplayed()) {
            splitBillPage.clickOK();
        } else if (page.isSnackbarDisplayed()) {
            page.clickOnsnackbarButton();
        }
    }

}
