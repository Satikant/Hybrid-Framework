package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.HamburgerMenuPageObjects;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class HamburgerMenuFeature extends HamburgerMenuPageObjects {
    HamburgerMenuPageObjects hamburgerMenu = new HamburgerMenuPageObjects();

    public void hamburger(){
        ExtentTest node = ExtentManager.getTest();
        try {
            hamburgerMenu.clickonmenus();
        }catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }
}
