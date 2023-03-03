package framework.wallet.palestineArabBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.palestineArabBank.pageObjects.LoginPagePalestine;
import framework.wallet.palestineArabBank.pageObjects.SplitBillPagePalestine;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.DataDriven;
import utils.GenerateRandomValue;
import utils.MessageReader;

public class SplitBillFeaturePalestine {
    
    LoginPagePalestine loginpage = new LoginPagePalestine();
    CustomerLoginPalestine Login = new CustomerLoginPalestine();
    SplitBillPagePalestine SBpage = new SplitBillPagePalestine();
    ExtentTest testCase = ExtentManager.getTest();
    ExtentTest node = ExtentManager.getTest();

    //------------------------ADD / DELETE - Group----------------------------------------------------------------------------------------------------------------------------//
    public SplitBillFeaturePalestine Group(String GrpName, String[] msisdn, String[] names, int total_people_Group_number, String action) {

        try {

            TestInit.startPositveTest();

            if (Config.isFirstTimeLogin) {
                Login.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }
            SBpage.clickOnSplitBillMenu(5);

            Config.chaneLanguageCounter = 0;
            if ((action == Constants.MODIFY) || (action == Constants.DELETE)) {
                SBpage.selectGroup(3);
                SBpage.clickOnEdit();
            } else {
                SBpage.clickonAddGroup();
                SBpage.enterGroupName(GrpName);
            }
            if ((action == Constants.MODIFY) || (action == Constants.ADD)) {
                addMember(total_people_Group_number, msisdn, names, action);
            }

            if (Config.chaneLanguageCounter == 0)
                SBpage.checkMethodAndClick(action);

            return this;
        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }



    //--------------------ADD Member in Existing Group----------------------------------------------------------------------------------------------------------------------//
    public SplitBillFeaturePalestine addMember(int total_people_Group_number, String msisdn[], String names[], String AddOrEditOrDelete) {
        try {
            int i = 0;
            if (!Config.isDeleteMember) {
                while (i < total_people_Group_number) {
                    SBpage.enterMsisdn(msisdn[i]).enterName(names[i]).clickAddMember();
                    if (Config.toastCheck) {
                        SBpage.getToast();
                        Config.chaneLanguageCounter++;
                    }
                    i++;
                }
                Config.setToastCheckFalse();
            }
        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

//-------------------------Initiate Split Bill Request-----------------------------------------------------------------------------------------------------------------//
    public SplitBillFeaturePalestine initiateSplitBill(String amount, String AcceptReject) {
       try{
        if (Config.isFirstTimeLogin) {
            Login.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Config.setFirstTimeLoginFalse();
        }

               SBpage.clickOnSplitBillMenu(5);
               SBpage.selectGroup();
               CommonUtils.pauseExecution(2);
               SBpage.clickOnCreate();
               SBpage.enterAmt(amount);

               testCase.info("Amount not distributed equally");
           return this;
    }catch (Exception e){
           e.printStackTrace();
           node.fail("Test Case Failed");
           node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
       }
        return this;
    }


    //------------------------Pending Request------------------------------------------------------------------------------------------------------------------//
    public SplitBillFeaturePalestine CheckAndAcceptPendingReq(String AcceptReject) {
        try {
            Login.Login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
            Double previousBalnace = SBpage.checkBalance();
            SBpage.clickOnPendingRequest();

            CommonUtils.pauseExecution(5);
            String amnt = SBpage.clickOnRequest();

            if (AcceptReject == Constants.ACCEPT) {
                SBpage.clickOnApprove();
                if (loginpage.isSnackbarDisplayed()) {
                    acceptAlert();
                    SBpage.clickBack();
                } else
                    Assertion.verifyEqual(SBpage.fetchTxnStatus(), MessageReader.getMessage("ERRMSG_0060"));

            } else if (AcceptReject == Constants.REJECT) {
                SBpage.clickOnReject();
                Assertion.verifyEqual(SBpage.fetchTxnStatus(), MessageReader.getMessage("ERRMSG_0064"));
            }

            if (SBpage.isHomeBtnDisplayed()) {
                SBpage.clickOnHome();
                Double currentBalance = SBpage.checkBalance();
                if (previousBalnace == currentBalance) {
                    testCase.info("Balance not deducted");
                }
                //   profileDetailsPage.clickOnMenuButton();
                SBpage.clickOnSplitBillMenu(1).fetchNotification(amnt, AcceptReject);//Notification
            } else if (!SBpage.isMenuButtonPresent())
                SBpage.clickBack();

        } catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }



    //------------------------Accept Alert------------------------------------------------------------------------------------------------------------------//
    public SplitBillFeaturePalestine acceptAlert() {
        try {
            if (SBpage.isClickOnOkisDisplayed()) {
                System.out.print(" method accept alert else condition");
                SBpage.clickOK();
            } else if (loginpage.isSnackbarDisplayed()) {
                loginpage.clickOnsnackbarButton();
            }
            Thread.sleep(1000);
            /*if (SBpage.isCreateButtonPresent()) {
                do {
                    SBpage.clickBack();
                    System.out.println(SBpage.isSBpresent() + "UP");
                } while (!SBpage.isSBpresent());
            }
            else*/ if (SBpage.isSBpresent()) {
                return this;
            } else {
                do {
                    SBpage.clickBack();
                    System.out.println(SBpage.isSBpresent() + "UP");
                } while (!SBpage.isSBpresent());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }


}

