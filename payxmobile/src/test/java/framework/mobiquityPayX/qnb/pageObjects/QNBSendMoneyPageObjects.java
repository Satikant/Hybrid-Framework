package framework.mobiquityPayX.qnb.pageObjects;

import com.aventstack.extentreports.Status;
import framework.mobiquityPayX.qnb.fetchOtp.FetchOtp;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;
import utils.Utils;

import java.util.List;

public class QNBSendMoneyPageObjects extends AppPageInit {

    public QNBSendMoneyPageObjects() {
        super();
    }

    @AndroidFindBy(id = "todayCardView")
    private List<WebElement> availableservice;

    @FindBy(name = "home_mpayIcon")
    private WebElement availableserviceIOS;

    @FindBy(name = "home_sendMoneyIcon")
    private WebElement sendMoneyIconIOS;

    @AndroidFindBy(id="toolbar_icon")
    private WebElement backBtn;

    @AndroidFindBy(id="sendmoneyfavourit")
//    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='more']")
    private WebElement sendMoneyFavList;

    @AndroidFindBy(id = "fav_text_view")
    private WebElement manageFave;

    @AndroidFindBy(id = "sendmoneyContactLayout")
    private WebElement enterMobileNumber;

    @AndroidFindBy(id = "paymerchantContactLayout")
    private WebElement enterMerchantMsisdn;

    @AndroidFindBy(id = "textinput_placeholder")
    private WebElement textinput_placeholder;

    @AndroidFindBy(id = "sendmoneyNextButton")
    private WebElement sendmoneyNextButton;

    @AndroidFindBy(id = "paymerchantNextButton")
    private WebElement paymerchantNextButton;

    @AndroidFindBy(id = "homeAvailableLabelSub")
    private WebElement availableService;

    @AndroidFindBy(id = "homeAvailableLabel")
    private WebElement homeAvailableLabel;

    @AndroidFindBy(id = "photo_layout")
    private WebElement recent;

    @AndroidFindBy(id = "transferstockFavouriteImageView")
    private WebElement favourite;

    @AndroidFindBy(id = "favouriteTitleText")
    private List<WebElement> recenTransaction;

    @AndroidFindBy(id = "multiCurrencyAmountEdittext")
    private WebElement amount;

    @AndroidFindBy(id = "inputamountNextButton")
    private WebElement nextButton;

    @AndroidFindBy(id = "transactionconfirmation_next_button")
    private WebElement transferNow;

    @AndroidFindBy(id = "otp_edit_text")
    private  WebElement otpField;

    @AndroidFindBy(id = "verifyotp_button")
    private WebElement verifyOtp;

    @AndroidFindBy(id = "actionForwardIcon")
    private List<WebElement> forwardIcon;

    @AndroidFindBy(id = "transactionstatus_status_text")
    private WebElement transactionStatus;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionconfirmation_payee_mobilenumber")
    private WebElement payeeMobileNumber;

    @AndroidFindBy(id = "transactionconfirmation_payee_name")
    private WebElement payeeName;

    @AndroidFindBy(id = "transactionconfirmation_amount_text")
    private WebElement transactionAmt;

    @AndroidFindBy(id = "transactionconfirmation_payer_value")
    private WebElement availableBalance;

    @AndroidFindBy(id = "transactionstatus_status_heading")
    private WebElement postTransactionAmt;

    @AndroidFindBy(id = "transactionstatus_status_subtext")
    private WebElement subText;

    @AndroidFindBy(id = "transactionstatus_details_value")
    private List<WebElement> transactionStatusDetails;

    /*@AndroidFindBy(id = "transactionstatus_details_value")
    private WebElement postPayeeName;*/

    /*@AndroidFindBy(id = "transactionstatus_details_value")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;*/

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;
    List<WebElement> elementList;

    public QNBSendMoneyPageObjects clickOnMPay() {
        element = devicePlatform ? availableservice.get(2) : availableserviceIOS;
        isElementNotPresent(element);
        clickOnElement(element, "M PAY");
        return this;
    }

    public WebElement qnbSendMoneyIcon() {
        element = devicePlatform ? availableservice.get(0) : sendMoneyIconIOS;
        return element;
    }


    public QNBSendMoneyPageObjects clickOnSendMoney() {
        element = devicePlatform ? availableservice.get(0) : sendMoneyIconIOS;
        isElementNotPresent(element);
        clickOnElement(element, "Send Money");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnMerchantPayment() {
        isElementNotPresent(availableService);
        clickOnElement(availableservice.get(1), "Merchant Payment");
        return this;
    }

    public void selectService(String serviceType) {
        if (serviceType == "SEND_MONEY") {
            clickOnSendMoney();
        } else {
            clickOnMerchantPayment();
        }
    }

    public QNBSendMoneyPageObjects clickOnRecentIcon() {
        isElementNotPresent(recent);
        clickOnElement(recent, "Recent Icon");
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public QNBSendMoneyPageObjects setMsisdnForSendMoney(String msisdn) {
        clickOnElement(enterMobileNumber, "Mobile Number  ");
        isElementClickable(textinput_placeholder);
        setTextByAction(msisdn, "MSISDN");
        driver.navigate().back();
        clickOnElement(sendmoneyNextButton, "Next Button");
        return this;
    }

    public QNBSendMoneyPageObjects setMsisdnForMerchantPayment(String msisdn) {
        clickOnElement(enterMerchantMsisdn, "Mobile Number");
        isElementClickable(textinput_placeholder);
        setTextByAction(msisdn, "MSISDN");
        driver.navigate().back();
        clickOnElement(paymerchantNextButton, "Next Button");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnRecentTransaction() {
        clickOnElement(recenTransaction.get(0), "Recent Transaction");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnFavouriteTransaction() {
        clickOnElement(favourite, "Favourite Transaction");
        clickOnElement(recenTransaction.get(0), "Select favourite Transaction");
        return this;
    }

    int i = 0;

    public QNBSendMoneyPageObjects setPayee(String payee, String serviceType) {

        if (i == 0)
            clickOnRecentIcon();
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");

        if (payee == "RECENT") {
            clickOnRecentTransaction();
            i++;
        } else if (payee == "FAVOURITE") {
            clickOnFavouriteTransaction();
            i++;
        } else {
            if (serviceType == "SEND_MONEY")
                setMsisdnForSendMoney(payee);
            else
                setMsisdnForMerchantPayment(payee);
            i++;
        }
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public QNBSendMoneyPageObjects setAmount(String amt) {
        isElementNotPresent(amount);
        setText(amount, amt, "Amount");
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnNextButton() {
        clickOnElement(nextButton, "Next Button");
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnTransferNow() {
        waitUntilElementDisappear("pb_loading");
        clickOnElement(transferNow, "Transfer Now");
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");
        return this;
    }


    public QNBSendMoneyPageObjects clickOnVerifyOtp() {
        clickOnElement(verifyOtp, "Verify OTP Button");
        waitUntilElementDisappear("pb_loading");
        waitUntilElementDisappear("pb_loading");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnMakeAnotherPayment() {
        clickOnElement(forwardIcon.get(0), "Make Another Payment");
        return this;
    }

    public QNBSendMoneyPageObjects clickOnViewStatement() {
        clickOnElement(forwardIcon.get(1), "View Statement");
        return this;
    }

    public String getTransactionStatus() {
        isElementNotPresent(goHome);
        return transactionStatus.getText();
    }

    public QNBSendMoneyPageObjects clickOnGoHome() {
        clickOnElement(goHome, "Go Home");
        return this;
    }

    public String[] getPayeeDetails() {
        try {
            waitUntilElementDisappear("pb_loading");
            return new String[]{
                    payeeMobileNumber.getText(),
                    payeeName.getText(),
                    transactionAmt.getText(),
                    availableBalance.getText()
            };
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return new String[]{};
        }
    }

    public String[] getTransactionDetails() {
        try {
            return new String[]{
                    postTransactionAmt.getText(),
                    transactionStatusDetails.get(0).getText(),
                    transactionStatusDetails.get(1).getText(),
                    transactionStatusDetails.get(2).getText(),
                    transactionStatusDetails.get(3).getText(),
                   // transactionStatusDetails.get(4).getText(),
                  //  transactionStatusDetails.get(5).getText()
            };
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return new String[]{};
        }
    }

    public String getTransactionFailureText() {
        isElementNotPresent(subText);
        return subText.getText();
    }


}
