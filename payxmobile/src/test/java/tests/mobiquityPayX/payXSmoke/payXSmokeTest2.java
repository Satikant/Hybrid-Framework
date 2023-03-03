package tests.mobiquityPayX.payXSmoke;

import framework.mobiquityPayX.payX.feature.billPayFeature;
import framework.mobiquityPayX.payX.feature.depositeCashUn_registerFeature;
import framework.mobiquityPayX.payX.feature.pinChangedSuccessFeature;
import framework.mobiquityPayX.payX.feature.loginFeature;
import initializers.TestInit;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.DataDriven;



    public class payXSmokeTest2 extends TestInit {

        loginFeature login = new loginFeature();
        billPayFeature billPay = new billPayFeature();
        depositeCashUn_registerFeature depositeCash = new depositeCashUn_registerFeature();
        pinChangedSuccessFeature pinChange = new pinChangedSuccessFeature();


/*        @AfterMethod
        public void AcceptDialogBox(){
            login.AcceptDialogBox();
        }
*/

        @Test(priority = 1)
        public  void  InvalidLogin(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_07"));
            startPositveTest();
            login.login(DataDriven.getUserByStatus("Y"),"1254");
        }

        @Test(priority = 2)
        public  void  ElectricBill(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_02"));
            startPositveTest();
            login.enterPin(DataDriven.getUserPinByStatus("Y"));
            billPay.electricityBillPay("50","OD23432123",DataDriven.getUserPinByStatus("Y"));
        }

        @Test(priority = 3)
        public  void  DipositeCash(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_04"));
            startPositveTest();
            depositeCash.depositeCashUnRegister("9658549380","8349020205","50",DataDriven.getUserPinByStatus("Y"));
        }

        @Test(priority = 4)
        public  void  ChangePin(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_12"));
            startPositveTest();
            pinChange.doPinChange(DataDriven.getUserPinByStatus("Y"),"2022","2022");
        }

        @Test(priority = 5)
        public  void  ChangePinCopy2(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_13"));
        }

        @Test(priority = 6)
        public  void  ChangePinCopy3(){
            ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("SMOKE_TC_14"));
        }


    }


