package framework.wallet.bharain.pageObjects;


import common.Assertion;
import globalConstants.Config;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class BatelcoServicesPage extends AppPageInit {
    String toastMessage;

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    private List<WebElement> desc_image;

    @AndroidFindBy(id = "com.batelco.sub:id/parent_name")
    private WebElement listofservices;

    @AndroidFindBy(id = "com.batelco.sub:id/parent_name")
    private List<WebElement> batelcoservices;

    @AndroidFindBy(id = "com.batelco.sub:id/ph")
    private WebElement billpayno;

    @AndroidFindBy(id = "com.batelco.sub:id/cpr")
    private WebElement cprnumber;

    @AndroidFindBy(id = "com.batelco.sub:id/amt")
    private WebElement billamount;

    @AndroidFindBy(id = "com.batelco.sub:id/getbill")
    private WebElement getbill;

    @AndroidFindBy(id = "com.batelco.sub:id/button5")
    private WebElement confirmbutton;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> quickpayamount;

    @AndroidFindBy(id = "com.batelco.sub:id/pre")
    private WebElement quickpay;

    @AndroidFindBy(id = "com.batelco.sub:id/proceedButton")
    private WebElement proceedButton;


    public BatelcoServicesPage clickOnBatelcoServicesIcon() throws InterruptedException {
        clickOnElement(desc_image.get(1), "Clicking on Batelco Services");
        CommonUtils.pauseExecution(2);
        return this;
    }

    public boolean isBatelcoServicesIconDisplayed(){
        return driver.findElements(By.id("desc_image")).size()>0;
    }

    public BatelcoServicesPage clickOnPostpaid() throws InterruptedException {
        isElementNotPresent(listofservices);
        clickOnElement(batelcoservices.get(0), "Clicking on Postpaid");
        return this;
    }

    public BatelcoServicesPage clickOnPrepaid() throws InterruptedException {
        isElementNotPresent(listofservices);
        clickOnElement(batelcoservices.get(1), "Clicking on Prepaid");
        return this;
    }

    public BatelcoServicesPage clickOnFixedline() throws InterruptedException {
        isElementNotPresent(listofservices);
        clickOnElement(batelcoservices.get(2), "Clicking on Fixed Line");
        return this;
    }

    public void clickOnBillPayMode(String billpaymethod) throws InterruptedException {
        switch (billpaymethod) {
            case "postpaid":
                clickOnPostpaid();
                break;

            case "fixed_line":
                clickOnFixedline();
                break;

            default:
                throw new UnsupportedOperationException(billpaymethod+":- This method is not supported");
        }
    }

    public BatelcoServicesPage setPostpaidNumber(String msisdn) throws InterruptedException {
        setText(billpayno,msisdn,"Postpaid Number");
        return this;
    }

    public BatelcoServicesPage setPrepaidNumber(String msisdn) throws InterruptedException {
        isElementNotPresent(billpayno);
        setText(billpayno,msisdn,"Prepaid Number");
        return this;
    }

    public BatelcoServicesPage setFixedLineNumber(String msisdn) throws InterruptedException {
        setText(billpayno,msisdn,"Fixed Line Number");
        return this;
    }

    public BatelcoServicesPage setAmount(String amount) throws InterruptedException {
        setText(billamount,amount," Amount");
        return this;
    }

    public String getAmount() throws InterruptedException {
       return billamount.getText();
    }

    public BatelcoServicesPage setPostpaidCprNumber(String cpr) throws InterruptedException {
        setText(cprnumber,cpr,"Postpaid CPR Number");
        return this;
    }

    public BatelcoServicesPage setFixedCprNumber(String cpr) throws InterruptedException {
        setText(cprnumber,cpr,"Fixed line CPR Number");
        return this;
    }

    public BatelcoServicesPage clickOnGetBill() throws InterruptedException, IOException {
        clickOnElement(getbill,"Fetching Bill Button");
        if(!Config.isBillEnquiryReuired) {
            getToast();
        }
        return this;
    }

    public BatelcoServicesPage clickOnConfirmButton() throws InterruptedException {
        clickOnElement(confirmbutton,"Confirm Button");
        return this;
    }

    public boolean isConfirmButtonDisplayed(){
        return driver.findElements(By.id("button5")).size()>0;
    }

    public BatelcoServicesPage clickOnQuickPay() throws InterruptedException {
        isElementNotPresent(quickpay);
        clickOnElement(quickpay,"Quick Pay Button");
        return this;
    }

    public BatelcoServicesPage selectAmount() throws InterruptedException {
        clickOnElement(quickpayamount.get(1),"Selecting Amount");
        return this;
    }

    public BatelcoServicesPage clickOnProceedButton() throws InterruptedException {
        clickOnElement(proceedButton,"Proceed Button");
        return this;
    }

    public void getToast() throws InterruptedException, IOException {
        CommonUtils.pauseExecution(1);
        String xmlFormat = driver.getPageSource();
        toastMessage= Utils.getToastMessage();
        System.out.println(toastMessage);
        int c=0;
        if(toastMessage.contains(MessageReader.getMessage("ERRMSG_0040"))){
            Assertion.verifyContains(toastMessage,MessageReader.getMessage("ERRMSG_0040"));
        }
        else{
            //System.out.println(xmlFormat);
            if(xmlFormat.contains("Getting Bill")){
                while(xmlFormat.contains("Getting Bill")){
                    xmlFormat = driver.getPageSource();
                }
                toastMessage=toastMessage.replaceAll("[\r\n]+", " ");
                Assertion.verifyContains(toastMessage,MessageReader.getMessage("ERRMSG_0043"));
            }
            else{
                if(xmlFormat.contains("Please Enter Valid Amount")){
                    System.out.println("Toast message displayed: "+"Please Enter Valid Amount");
                    pageInfo.pass("Please Enter Valid Amount");
                }
                else{
                    Assertion.verifyContains(toastMessage,"Enter your CPR");
                }
            }
        }

    }
}
