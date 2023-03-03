package framework.wallet.bharain.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.bharain.pageObjects.ChangePinPage;
import framework.wallet.bharain.pageObjects.LoginPageBharain;
import framework.wallet.bharain.pageObjects.ProfileDetailsPage;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.MessageReader;

import java.io.IOException;

import static initializers.TestInit.startPositveTest;

public class ChangePinFeature {
    ChangePinPage changePinPage = new ChangePinPage();
    CustomerLoginBharain customerLogin = new CustomerLoginBharain();
    LoginPageBharain page = new LoginPageBharain();
    String pin1="",pin2="";

    public ChangePinFeature(){
    }

    public ChangePinFeature changePin(String old, String newP, String cnfrmPin)  {
        startPositveTest();
        ExtentTest featureNode = ExtentManager.getTest();
        try{
            if (Config.isFirstTimeLogin) {
                customerLogin.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
                changePinPage.clickOnMenuButton();
                changePinPage.clickOnChangePin().setSecurityAnswer("abc").clickOnNext();
            }
            changePinPage.setOldPin(old).setNewPin(newP).setConfirmPin(cnfrmPin).clickOnSubmitButton();
            if(changePinPage.isLoaderDisplayed()){
                changePinPage.waitTillLoaderDisplayed();
                if(page.getErrMsgFromDevice().equals(MessageReader.getMessage("ERRMSG_0029"))){
                    Assertion.verifyEqual(page.getErrMsgFromDevice(), MessageReader.getMessage("ERRMSG_0029"));
                    if (changePinPage.isLoginToolBarDisplayed()) {
                        featureNode.pass("Change PIN Sucess");
                        writeNewPinToExcel(cnfrmPin);
                    } else {
                        featureNode.fail("ChangePIN Failed");
                    }
                }
                else{
                    featureNode.info("Negative Cases");
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public void acceptAlert() {
        ExtentTest featureNode = ExtentManager.getTest();
        try{
            if (page.isSnackbarDisplayed()) {
                page.clickOnsnackbarButton();
            } else if(changePinPage.isAlertBoxDisplayed()){
                changePinPage.clickOnAlertOkButton();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }

    public void writeNewPinToExcel(String pin) throws IOException {
        ExtentTest featureNode = ExtentManager.getTest();
        try{
             pin1=DataDriven.getUserPinByStatus("Y");
             pin2=DataDriven.getUserPin2ByStatus("Y");
            //System.out.println("PIN1 : "+pin1 +"\n"+"PIN2 : "+pin2);
            DataDriven.setCellValueByOldPin3("Y",pin2);
            DataDriven.setCellValueByOldPin2("Y",pin1);
            DataDriven.setCellValueByOldPin("Y", pin);
            CommonUtils.pauseExecution(1);
        }
        catch (Exception e) {
            e.printStackTrace();
            featureNode.fail("Test Case Failed");
            featureNode.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }

}
