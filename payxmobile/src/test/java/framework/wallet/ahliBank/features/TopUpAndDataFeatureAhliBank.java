package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import framework.wallet.ahliBank.pageObjects.TopUpAndDataPageAhliBank;
import globalConstants.Config;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.Utils;
import utils.W3CActions;

import static initializers.TestInit.startPositveTest;

public class TopUpAndDataFeatureAhliBank {

    BillPayFeatureAhliBank billPayFeature=new BillPayFeatureAhliBank();
    CustomerLoginAhliBank login=new CustomerLoginAhliBank();
    TopUpAndDataPageAhliBank topUpAndDataPage = new TopUpAndDataPageAhliBank();

    public TopUpAndDataFeatureAhliBank topUpAndData(String qatarid, String serviceno, String nickname, String amt, String otp, String transactionName, String biller, String service){
        billPayFeature.billPay(qatarid,
                serviceno,
                nickname,
                amt,
                otp,
                transactionName,
                biller,
                service);
        return this;
    }

    public TopUpAndDataFeatureAhliBank topUpService(String msisdn, int amtIndex, String nickname, String biller ){
        ExtentTest node = ExtentManager.getTest();
        try{
            startPositveTest();
            if(Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
                topUpAndDataPage.clickOnTopUpAndData();
            }
            topUpAndDataPage.selectBiller(biller);
            topUpAndDataPage.clickOnTopUp().
                    setMsisdn(msisdn).
                    clickOnAmountField().
                    selectAmount(amtIndex).
                    setNickname(nickname).
                    clickOnTermsCondition();
            W3CActions w3CActions = new W3CActions();
            w3CActions.scrollDown();
            topUpAndDataPage.clickOnSubmit();

        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public TopUpAndDataFeatureAhliBank dataRechargeService(String msisdn, int amtIndex, String nickname, String biller ){
        ExtentTest node = ExtentManager.getTest();
        try{
            startPositveTest();
            if(Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
                topUpAndDataPage.clickOnTopUpAndData();
            }
            topUpAndDataPage.selectBiller(biller);
            topUpAndDataPage.clickOnDataRecharge().
                    setMsisdn(msisdn).
                    clickOnTopUpAndDataPack(amtIndex).
                    setDataRechargeNickname(nickname).
                    clickOnTermsCondition();
            W3CActions w3CActions = new W3CActions();
            w3CActions.scrollDown();
            topUpAndDataPage.clickOnSubmit();

        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public TopUpAndDataFeatureAhliBank acceptAlert(String service){
        billPayFeature.acceptAlert(service);
        return this;
    }
}
