package framework.mobiquityPayX.payX.feature;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.mobiquityPayX.payX.PageObjects.payXSecurityQuestionPageObjects;

import org.apache.commons.lang.exception.ExceptionUtils;
import reportManagement.ExtentManager;

public class SecurityQuestionFeature extends payXSecurityQuestionPageObjects{

    payXSecurityQuestionPageObjects securityQuestion = new payXSecurityQuestionPageObjects();

    public void securityQus(String pin , String answer1, String answer2) {
        ExtentTest node = ExtentManager.getTest();

        try {

            securityQuestion.enteringSecurityPage().pinverify(pin).setSequrityQus(answer1, answer2);
            if(securityQuestion.isAnswersetsuccesspresent()) {
                Assertion.verifyContains(securityQuestion.isAnswersetsuccessful(), "Security questions");
            }

        } catch (Exception e) {
            e.printStackTrace();
                pageInfo.fail("Test Case Failed");
                pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }


}
