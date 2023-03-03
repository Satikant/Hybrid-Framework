package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.palestineArabBank.pageObjects.AtmCashoutPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.SendMoneyPagePalestine;
import globalConstants.Config;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.Utils;

import java.nio.charset.StandardCharsets;

public class AtmCashoutFeaturePalestine {

    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();
    AtmCashoutPagePalestine atmCashoutPagePalestine = new AtmCashoutPagePalestine();
    LoginPagePalestine loginPagePalestine = new LoginPagePalestine();

//    public String enteredAmount;


    public AtmCashoutFeaturePalestine atmCashOutMoney(String amt) {

        try {
            TestInit.startPositveTest();
            System.out.println(Config.isFirstTimeLogin);
            if (Config.isFirstTimeLogin) {
                customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }

//            enteredAmount = amt;
            atmCashoutPagePalestine.clickOnAtmCashoutIcon().
                    selectAmount(amt);
            atmCashoutPagePalestine.clickOnSubmitBtn();
            CommonUtils.pauseExecution(2);

//            if (feature.enteredAmount == "20.00") {
//                Assertion.verifyEqual("20.00", atmCashoutPagePalestine.getAmount());
//            }

            atmCashoutPagePalestine.clickOnSubmitBtn();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public void acceptAlert() {
        try {
            if (loginPagePalestine.isClickOnOkisDisplayed()) {
                loginPagePalestine.clickOnsnackbarButton();
                do {
                    CommonUtils.pauseExecution(2);
                    atmCashoutPagePalestine.clickOnBackButton();
                    atmCashoutPagePalestine.isClickOnSubmitButtonDisplayed();
                } while (atmCashoutPagePalestine.isClickOnSubmitButtonDisplayed());
            }
        } catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}