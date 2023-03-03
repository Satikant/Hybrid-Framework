package tests.mobiquityPayX.ndpc;

import framework.mobiquityPayX.commonApplicationModule.features.LogOutFeature;
import framework.mobiquityPayX.commonApplicationModule.features.LoginFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;

public class LogOutTest extends TestInit {

   LoginFeature loginFeature = new LoginFeature();
    LogOutFeature logOutFeature = new LogOutFeature();


    @Test
    public void logOut001(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("LOGIN16"));
        startPositveTest();
        loginFeature.login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"), "");
        logOutFeature.logOut();
    }
}
