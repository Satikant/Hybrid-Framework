package framework.wallet.ahliBank.features;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.pageObjects.BillPayPageAhliBank;
import framework.wallet.ahliBank.pageObjects.NotificationPageAhliBank;
import globalConstants.Config;
import globalConstants.VariableConstant;
import org.apache.commons.lang3.exception.ExceptionUtils;
import reportManagement.ExtentManager;
import utils.DataDriven;
import utils.Utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static initializers.TestInit.startPositveTest;

/**
 * Created by ayush.singh on 05-10-2020.
 */
public class NotificationFeatureAhliBank {
    NotificationPageAhliBank notificationPage=new NotificationPageAhliBank();
    CustomerLoginAhliBank login=new CustomerLoginAhliBank();
    BillPayPageAhliBank billPayPage=new BillPayPageAhliBank();
    String serviceType=null,txnid=null,amt=null,notificationmsg=null;

    public NotificationFeatureAhliBank validateTransactionHistory(String service_type){
        ExtentTest node = ExtentManager.getTest();
        try{
            startPositveTest();
            if(Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }
            billPayPage.clickOnCancel();
            notificationPage.clickOnTransactionHistoryIcon();
            serviceType=notificationPage.getTransactionHistoryServiceType();
            txnid=notificationPage.getTransactionHistoryTransacID();
            amt=notificationPage.getTransactionHistoryAmount();
            Assertion.verifyEqual(notificationPage.dateFormatterTransactHist(),notificationPage.dateFormatterTransaction(VariableConstant.TRANSACTION_DATE_TIME));
            Assertion.verifyEqual(serviceType,service_type);
            Assertion.verifyEqual(txnid,VariableConstant.TRANSACTION_ID);
            Assertion.verifyEqual(amt,"- "+VariableConstant.TRANSACTION_AMOUNT);
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public NotificationFeatureAhliBank validateNotification(String service_type){
        ExtentTest node = ExtentManager.getTest();
        try{
            startPositveTest();
            if(Config.isFirstTimeLogin) {
                login.login(DataDriven.getUserByStatus("Y"), DataDriven.getUserPinByStatus("Y"));
                Config.setFirstTimeLoginFalse();
            }
            billPayPage.clickOnCancel();
            notificationPage.clickOnNotificationIcon();
            notificationmsg=notificationPage.getNotificationMsg();
            Assertion.verifyEqual(notificationPage.dateFormatterNotification(),notificationPage.dateFormatterNotificationTransaction(VariableConstant.TRANSACTION_DATE_TIME));
            Assertion.verifyEqual(notificationmsg,service_type+" for "+VariableConstant.TRANSACTION_AMOUNT+" has been successfully done");
            billPayPage.clickOnBackButton();
        }
        catch (Exception e) {
            e.printStackTrace();
            node.fail("Test Case Failed");
            node.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return this;
    }

    public static void main(String[] args) throws ParseException {
    }
}
