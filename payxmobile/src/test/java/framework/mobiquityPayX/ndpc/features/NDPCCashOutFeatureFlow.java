package framework.mobiquityPayX.ndpc.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.commonApplicationModule.features.FinancialTransactionFlowFeature;
import framework.mobiquityPayX.ndpc.pageObjects.NDPCCashOutPageObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class NDPCCashOutFeatureFlow {
    NDPCCashOutPageObject cashOutPage = new NDPCCashOutPageObject();
    FinancialTransactionFlowFeature financialTransactionFlow =  new FinancialTransactionFlowFeature();

    public  NDPCCashOutFeatureFlow cashOut(String msisdn, String amt, String otpOrPin, String serviceType){
        ExtentTest node = ExtentManager.getTest();
        try {
            financialTransactionFlow.financialTransactionFlow(msisdn, amt,  otpOrPin, serviceType,cashOutPage.clickOnCashOutIcon());
        }
        catch (Exception e){
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }
}
