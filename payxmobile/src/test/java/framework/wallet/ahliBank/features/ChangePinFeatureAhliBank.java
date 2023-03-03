package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import framework.wallet.ahliBank.pageObjects.ChangePinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import globalConstants.Config;
import initializers.TestInit;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;


public class ChangePinFeatureAhliBank {

    ForgotPinPageAhliBank fPinPage= new ForgotPinPageAhliBank();
    ChangePinPageAhliBank cPinPage= new ChangePinPageAhliBank();
    CustomerLoginAhliBank login=new CustomerLoginAhliBank();

public ChangePinFeatureAhliBank changePin(String idNumber,String otp,String oldPin,String newPin,String confirmPin) {
    ExtentTest node = ExtentManager.getTest();
    TestInit.startPositveTest();
    if(Config.isFirstTimeLogin){
        login.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        Config.setFirstTimeLoginFalse();
        cPinPage.clickOnProfile().clickOnSetting().clickOnChangePin();
      }


    if(fPinPage.idFieldPresent()) {
        fPinPage.enterId(idNumber).clickOnNext();
    }
    if(fPinPage.isOTPFieldPresent()){
    fPinPage.enterOtp(otp);

    if(fPinPage.isConfirmButtonpresent()){
        fPinPage.clickOnConfirm();
    }
    }
    
    if(cPinPage.isOldPinDisplayed()){
    cPinPage.enteroldPin(oldPin).enterNewPin(newPin);

    fPinPage.enterConfirmPin(confirmPin);

    cPinPage.clickOnSetPin();
}
    if(fPinPage.isSuccessBtnDisplayed()){
        node.info("Pin Changed Successfully.");
        writeNewPinToExcel(newPin);
    }

    return this;
}

    public ChangePinFeatureAhliBank afterMethod(){
        if(fPinPage.isOkBtnPresent()){
            fPinPage.clickOnOK();}
        if (fPinPage.isSuccessBtnDisplayed()){
            fPinPage.clickOnSuccess(); }
        return this;
    }

    public void writeNewPinToExcel(String pin) {
        String pin1= DataDriven.getUserPinByStatus("Y");
        String pin2=DataDriven.getUserPin2ByStatus("Y");
        System.out.println("PIN1 : "+pin1 +"\n"+"PIN2 : "+pin2);
        DataDriven.setCellValueByOldPin3("Y",pin2);
        DataDriven.setCellValueByOldPin2("Y",pin1);
        DataDriven.setCellValueByOldPin("Y", pin);
        CommonUtils.pauseExecution(1);
    }


}