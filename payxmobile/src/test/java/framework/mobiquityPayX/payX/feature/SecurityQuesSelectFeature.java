package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.payXSecurityQuesSelectPageObjects;
import org.apache.commons.lang.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class SecurityQuesSelectFeature extends payXSecurityQuesSelectPageObjects{

    payXSecurityQuesSelectPageObjects securityQuesSelect = new payXSecurityQuesSelectPageObjects();

    public void securityQSelect(String pin) {
        ExtentTest node = ExtentManager.getTest();

        try {

//            securityQuesSelect.enteringSecurityPage().pinverify(pin).selectQuestion().logout();
            securityQuesSelect.selectQuestion();
            if(securityQuesSelect.isSecQusSlt()) {
                Assertion.verifyContains(securityQuesSelect.verifySecQus(), "Save");
            }
            securityQuesSelect.backToDashboard();

        } catch (Exception e) {
            e.printStackTrace();
                pageInfo.fail("Test Case Failed");
                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }


}
