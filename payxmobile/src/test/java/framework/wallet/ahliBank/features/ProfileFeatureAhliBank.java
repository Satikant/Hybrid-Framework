package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.ahliBank.pageObjects.profilePageAhliBank;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;

import java.io.IOException;
import java.util.List;

public class ProfileFeatureAhliBank {

    profilePageAhliBank page = new profilePageAhliBank();
    CustomerLoginAhliBank login =  new CustomerLoginAhliBank();
    ForgotPinFeatureAhliBank forgotFeature= new ForgotPinFeatureAhliBank();


    public ProfileFeatureAhliBank changeProfile(String change, String text, List<String> address) throws IOException {
        ExtentTest node = ExtentManager.getTest();
        try {
            if (Config.isFirstTimeLogin == true) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                // Config.isFirstTimeLogin=false;
                page.clickOnProfile();
            }

            page.clickOnProfileInfo();
            page.clickOnEdit();
           // page.update(change, text);
            CommonUtils.pauseExecution(3);
            page.clickOnUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

            return this;

    }


    public ProfileFeatureAhliBank aftermethod(){
forgotFeature.afterMethod();

if(page.isEmailIdPresent()) {
    page.clickOnBack();
}
        return this;
    }

}
