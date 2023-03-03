package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by ayush.singh on 05-10-2020.
 */
public class NotificationPageAhliBank extends AppPageInit {
    public NotificationPageAhliBank(){
        super();
    }

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/imgNotification")
    private WebElement imgNotification;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvNotificationDateTime")
    private WebElement tvNotificationDateTime;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvNotificationDetail")
    private WebElement tvNotificationDetail;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/bottom_navigation_item_icon")
    private List<WebElement> bottom_navigation_item_icon;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvDayOfMonth")
    private WebElement tvDayOfMonth;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvDate")
    private WebElement tvDate;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTime")
    private WebElement tvTime;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTransactionDetails")
    private WebElement servicetype;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTransactionAmount")
    private WebElement tvTransactionAmount;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTransactionID")
    private WebElement tvTransactionID;



    public NotificationPageAhliBank clickOnNotificationIcon(){
        clickOnElement(imgNotification,"Notification Icon");
        return this;
    }

    public String getNotificationDateAndTime(){
        isElementNotPresent(tvNotificationDateTime);
        return tvNotificationDateTime.getText();
    }

    public String getNotificationMsg(){
        return tvNotificationDetail.getText();
    }

    public NotificationPageAhliBank clickOnTransactionHistoryIcon(){
        clickOnElement(bottom_navigation_item_icon.get(1),"Transaction History Icon");
        return this;
    }

    String txnid="",trancHistDate="",transacNotiDate="",month_year="",time="",datetimeconcat="";

    public String getTransactionHistoryDate(){
       return tvDayOfMonth.getText();
    }

    public String getTransactionHistoryMonthYear(){
        return tvDate.getText();
    }

    public String getTransactionHistoryTime(){
        return tvTime.getText();
    }

    public String getTransactionHistoryServiceType(){
        return servicetype.getText();
    }

    public String getTransactionHistoryAmount(){
        return tvTransactionAmount.getText();
    }

    public String getTransactionHistoryTransacID(){
        return tvTransactionID.getText();
    }

    Date date = null;
    String output = null;

    public String dateFormatterTransactHist() throws ParseException {
        trancHistDate=getTransactionHistoryDate();
        month_year=getTransactionHistoryMonthYear().replaceAll("\\s+","/");
        time=getTransactionHistoryTime();
        datetimeconcat=trancHistDate+"/"+month_year+" "+time;
        return datetimeconcat;
    }

    public String dateFormatterTransaction(String transactionDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
        DateFormat outputformat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        transactionDate=transactionDate.replaceAll("\\|","");
        date= df.parse(transactionDate);
        output = outputformat.format(date);
        return output;
    }

    public String dateFormatterNotification() throws ParseException {
        transacNotiDate=getNotificationDateAndTime();
        DateFormat df = new SimpleDateFormat("dd MMM yyyy");
        DateFormat outputformat = new SimpleDateFormat("dd/MM/yyyy");
        date= df.parse(transacNotiDate);
        output = outputformat.format(date);
        return output;
    }

    public String dateFormatterNotificationTransaction(String notificationDate) throws ParseException {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss aa");
        DateFormat outputformat = new SimpleDateFormat("dd/MM/yyyy");
        notificationDate=notificationDate.replaceAll("\\|","");
        date= df.parse(notificationDate);
        output = outputformat.format(date);
        return output;
    }

}
