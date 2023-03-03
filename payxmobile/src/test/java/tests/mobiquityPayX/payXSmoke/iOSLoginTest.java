package tests.mobiquityPayX.payXSmoke;

import framework.mobiquityPayX.payX.PageObjects.iOSLoginPageObj;
import framework.mobiquityPayX.payX.PageObjects.payXLoginPageObjects;
import framework.mobiquityPayX.payX.feature.iOSLoginFeature;
import framework.mobiquityPayX.payX.feature.payXLoginFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;

public class iOSLoginTest extends TestInit {

    iOSLoginFeature loginFeature = new iOSLoginFeature();
    iOSLoginPageObj loginPO = new iOSLoginPageObj();
    @Test(priority = 1)
    public void payXUATIOS1(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUATIOS1"));
        startPositveTest();
        loginFeature.Login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
    }
    @Test(priority = 2)
    public void payXUATIOS2(){
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("payXUATIOS2"));
        startPositveTest();
        loginFeature.Login(DataDriven.getUserByStatus("Y"),DataDriven.getUserPinByStatus("Y"));
        loginPO.clickRecharge();
    }
}
