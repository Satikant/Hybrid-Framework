package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.palestineArabBank.pageObjects.ChangePinPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.ForgotPinPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import globalConstants.Config;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class ChangePinFeaturePalestine {

    ChangePinPagePalestine changePinPage = new ChangePinPagePalestine();
    CustomerLoginPalestine customerLogin = new CustomerLoginPalestine();
    LoginPagePalestine page = new LoginPagePalestine();
    ForgotPinPagePalestine forgotPinPg = new ForgotPinPagePalestine();
    ForgotPinFeaturePalestine forgotPinFea = new ForgotPinFeaturePalestine();

    public ChangePinFeaturePalestine() throws IOException, InvalidFormatException {
    }

    public ChangePinFeaturePalestine changePin(String secAnswer,String old, String newP, String cnfrmPin) throws IOException, InterruptedException {
        startPositveTest();
        ExtentTest featureNode = ExtentManager.getTest();
        if (Config.isFirstTimeLogin) {
            customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
            changePinPage.clickOnMenuButton().clickOnChangePin();
        }
        if (changePinPage.isMenuBtnDisplayed()) {
            changePinPage.clickOnMenuButton().clickOnChangePin();
        }
        CommonUtils.pauseExecution(3);
        if(forgotPinPg.isSubmitButtonDisplayed()){
            changePinPage.enterSecAnswer(secAnswer);
            forgotPinPg.clickSubmit();
            CommonUtils.pauseExecution(2);
            if(page.isSnackbarDisplayed()){
                Assertion.verifyEqual(changePinPage.getErrMsg(),MessageReader.getMessage("ERRMSG_0042"));
                page.clickOnsnackbarButton();
                changePinPage.clickOnBackButton();
            }
        }
        CommonUtils.pauseExecution(2);
        if(changePinPage.isOldPinPresent()) {
            changePinPage.setOldPin(old).setNewPin(newP).setConfirmPin(cnfrmPin).clickOnSubmitButton();
        String mess=changePinPage.getErrMsg();
        featureNode.info("New Pin:"+newP+"\t Confirm Pin:"+cnfrmPin);
        if(mess.contentEquals(MessageReader.getMessage("ERRMSG_0029"))){
            Assertion.verifyEqual(mess,MessageReader.getMessage("ERRMSG_0029"));
        forgotPinFea.writeNewPinToExcel(newP);
        featureNode.info("Pin Chnaged Successfully........As :"+newP);
        page.isWelcomeTextPresent();
        }}
        return this;
    }

    public void acceptAlert() {
        System.out.print("method accept alert if condition");
        if (page.isSnackbarDisplayed()) {
            page.clickOnsnackbarButton();
        } else if (changePinPage.isOkButtonDisplayed()) {
            System.out.print(" method accept alert else condition");
            changePinPage.clickOnOk();
        }
    }

    public static class MerchantPayFeatureABP {
    }
}

