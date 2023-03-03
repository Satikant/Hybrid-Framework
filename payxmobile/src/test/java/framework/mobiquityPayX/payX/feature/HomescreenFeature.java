package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.HomescreenPageObjects;
import framework.mobiquityPayX.payX.PageObjects.HomescreenPageObjects;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class HomescreenFeature extends HomescreenPageObjects {

    HomescreenPageObjects homescreen = new HomescreenPageObjects();

    public void homescreen(){
        ExtentTest node = ExtentManager.getTest();
        try{
            homescreen.clickonHambergerMenu();
            }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
    public void addmoney(){
        ExtentTest node = ExtentManager.getTest();
        try{
            homescreen.clickonAddmoney();
        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
    public void withdrawcash(){
        try{
            homescreen.clickonWithdrawcash();
            Thread.sleep(10000);
        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
