package framework.mobiquityPayX.payX.feature;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.payXwithdrawCashPageObject;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;


public class WithdrawCashFeature extends payXwithdrawCashPageObject{

    payXwithdrawCashPageObject withdrawCash = new payXwithdrawCashPageObject();

    public void withdrawCashtest(String mobno,String amount,String pin)
    {
        ExtentTest node = ExtentManager.getTest();

        try{
            withdrawCash.withdraw(mobno,amount).pinverify(pin);
            if(withdrawCash.ispaymentpresent()) {
                Assertion.verifyContains(withdrawCash.ispaymentsuccessful(), "Payment successful");
            }
            withdrawCash.backtologout().logout();

        }
        catch(Exception e)
        {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }

    }
}
