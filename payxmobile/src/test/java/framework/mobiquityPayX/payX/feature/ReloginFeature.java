package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.ReloginPO;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class ReloginFeature extends ReloginPO {
    ReloginPO reloginscreen = new ReloginPO();


    public void reloginscreen(){
        ExtentTest node = ExtentManager.getTest();
        try{
            reloginscreen.reloginfromhome();
        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
