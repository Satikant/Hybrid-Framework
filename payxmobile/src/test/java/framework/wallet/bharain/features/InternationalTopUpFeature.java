package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.bharain.pageObjects.InternationalTopUpPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import globalConstants.Config;
import java.io.IOException;



public class InternationalTopUpFeature {

    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    InternationalTopUpPage page1 = new InternationalTopUpPage();
    LoginPageBharain page = new LoginPageBharain();


    public InternationalTopUpFeature InternationalTopup(String country, String msisdn)  {
        ExtentTest featureNode = ExtentManager.getTest();
        TestInit.startPositveTest();
        if (Config.isFirstTimeLogin) {
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }
        page1.clickOnIntTopUpicon();
        CommonUtils.pauseExecution(3); // for letting the phone fetch the country codes
        page1.setCountrydropdown(country).Setmsisdn(msisdn).Viewplans();
        if (Config.toastCheck) {
            Config.setToastCheckFalse();
            page1.getToast();
        } else if (page.isSnackbarDisplayed()) {
            featureNode.info("Error message is displayed.");
        } else {
            page1.ClickOnSubmit();
            CommonUtils.pauseExecution(2);
            if (page.isSnackbarDisplayed()) {
                featureNode.info("Error message is displayed.");
            }
        }
        return this;
    }
    public void acceptAlert() {
        try {
            if (page.isSnackbarDisplayed()) {
                page.clickOnsnackbarButton();
            }
            page.clickonback();
        }
        catch (Exception e) {
            ExtentTest node = ExtentManager.getTest();
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}