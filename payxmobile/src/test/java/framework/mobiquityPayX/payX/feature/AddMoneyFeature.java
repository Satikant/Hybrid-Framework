package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.AddMoneyPO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class AddMoneyFeature extends AddMoneyPO {

    public void AddingMoney(){
        ExtentTest node = ExtentManager.getTest();
        try{
            Addmoneyflow();


            /*AddMoneyscreen.clickoncurrencydropddown();
            //AddMoneyscreen.getcurrency();
            AddMoneyscreen.provideamount("1");
            AddMoneyscreen.clickonNext();
            AddMoneyscreen.Errormodal();*/

        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
