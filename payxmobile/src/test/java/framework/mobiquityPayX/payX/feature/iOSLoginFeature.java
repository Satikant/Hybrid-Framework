package framework.mobiquityPayX.payX.feature;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.payX.PageObjects.iOSLoginPageObj;
import org.apache.commons.lang.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class iOSLoginFeature extends iOSLoginPageObj{
    iOSLoginPageObj loginPO = new iOSLoginPageObj();
    ExtentTest node = ExtentManager.getTest();
    public void Login(String Msisdn, String pin){
        try {
            loginPO.setMobileNumber(Msisdn).setpin(pin).clickLogin();
        }catch (Exception e)
        {
            e.printStackTrace();
            pageInfo.fail("Tesr Case FAILED");
            pageInfo.log(Status.INFO,"StackTrace Result" + ExceptionUtils.getStackTrace(e));
        }
    }
}
