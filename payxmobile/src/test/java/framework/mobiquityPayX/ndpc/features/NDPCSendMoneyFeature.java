package framework.mobiquityPayX.ndpc.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.commonApplicationModule.features.LogOutFeature;
import framework.mobiquityPayX.commonApplicationModule.features.LoginFeature;
import framework.mobiquityPayX.ndpc.pageObjects.NDPCSendMoneyPageObject;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.DataDriven;

import static initializers.TestInit.startPositveTest;

public class NDPCSendMoneyFeature {

    LogOutFeature logOutFeature = new LogOutFeature();
    LoginFeature loginFeature = new LoginFeature();
    NDPCSendMoneyPageObject sendMoneyPageObject = new NDPCSendMoneyPageObject();
    FinancialTransactionFlowFeature financialTransactionFlow =  new FinancialTransactionFlowFeature();

    public  NDPCSendMoneyFeature sendMoney(String msisdn, String amt, String otpOrPin, String serviceType){
        ExtentTest node = ExtentManager.getTest();
        try {
            if(Config.isLoginWithDifferentMsisdnRequired){
                logOutFeature.logOut().loginWithAnotherAccount();
                loginFeature.login(DataDriven.getUserByStatus(Config.userStatus),DataDriven.getUserPinByStatus(Config.userStatus),otpOrPin);
                Config.setLoginWithDifferentMsisdnRequired();
            }
            financialTransactionFlow.financialTransactionFlow(msisdn, amt,  otpOrPin, serviceType,sendMoneyPageObject.NDPCSendMoneyPageObject());
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }
}
