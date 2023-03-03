package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.WalletsPO;
import framework.mobiquityPayX.payX.PageObjects.WalletsPO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class WalletFeature extends WalletsPO {
    WalletsPO walletpo= new WalletsPO();

    public void Wallet(){
        ExtentTest node = ExtentManager.getTest();
        try{
            walletpo.walletflow();
        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
