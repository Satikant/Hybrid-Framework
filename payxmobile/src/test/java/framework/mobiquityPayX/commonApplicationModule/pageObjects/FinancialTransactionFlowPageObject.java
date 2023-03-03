package framework.mobiquityPayX.commonApplicationModule.pageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;
import utils.W3CActions;

import java.util.List;

public class FinancialTransactionFlowPageObject extends AppPageInit {

    W3CActions w3CActions = new W3CActions();
    public FinancialTransactionFlowPageObject(){
        super();
    }

    @AndroidFindBy(id = "homeSendmoneyMainLayout")
    private WebElement sendMoney;

    @FindBy(name = "tab_home_unselected")
    private  WebElement homeIconIOS;

    @AndroidFindBy(id="toolbar_icon")
    private WebElement backBtn;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='navBarBackButtonAccessibilityId']")
    private WebElement backBtnIOS;

    @AndroidFindBy(id = "sendmoneyContactLayout")
    private WebElement enterMobileNumber;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='Form_InputField_0']")
    private WebElement enterMobileNumberIOS;

    @AndroidFindBy(id = "textinput_placeholder")
    private WebElement textinput_placeholder;

    @FindBy(xpath = "//XCUIElementTypeTextField[@index='0']")
    private WebElement textinput_placeholderIOS;

    @AndroidFindBy(id = "photo_layout")
    private WebElement recent;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Recents']")
    private WebElement recentIOS;

    @AndroidFindBy(id = "transferstockFavouriteImageView")
    private WebElement favourite;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Favorites']")
    private WebElement favouriteIOS;

    @AndroidFindBy(id = "favouriteTitleText")
    private List<WebElement> recenTransaction;

    @AndroidFindBy(id = "errortext")
    private List<WebElement> errorText;

    @FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[@index='1']")
    private WebElement errorTextIOS;

    @FindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")
    private WebElement errorTextLabelIOS;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='popUpCancelButtonIdentifier']")
    private WebElement cancelBtnIOS;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='PopUpActionButtonIdentifier']")
    private WebElement reEnterBtnIOS;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='2']")
    private WebElement dialogErrorMessage;

    @AndroidFindBy(id = "multiCurrencyAmountEdittext")
    private WebElement amount;

    @FindBy(xpath = "//XCUIElementTypeTextField[@name='Form_InputField_0']")
    private WebElement amountIOS;

    @FindBy(xpath = "//XCUIElementTypeTextView[@name='Form_InputFieldMulti_0']")
    private WebElement remarkIOS;

    @AndroidFindBy(id = "inputamountNextButton")
    private WebElement nextButton;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Form_Action_Button']")
    private WebElement nextButtonIOS;

    @AndroidFindBy(id = "transactionconfirmation_next_button")
    private WebElement transferNow;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@name='Transfer now']")
    private WebElement transferNowIOS;

    @AndroidFindBy(id = "otp_edit_text")
    private  WebElement otpField;

    @AndroidFindBy(id = "verifyotp_button")
    private WebElement verifyOtp;

    @AndroidFindBy(id = "verifypin_pin_button")
    private WebElement verifyPin;

    @AndroidFindBy(id = "actionForwardIcon")
    private List<WebElement> forwardIcon;

    @FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeCollectionView/XCUIElementTypeCell[1]")
    private WebElement pinIOS;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Verify']")
    private  WebElement verifyPinIOS;

    @AndroidFindBy(id = "transactionstatus_status_text")
    private WebElement transactionStatus;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='0']")
   // @FindBy(xpath = "//XCUIElementTypeOther/XCUIElementTypeStaticText[@visible='true'][2]")
    private WebElement transactionStatusIOS;

    @AndroidFindBy(id = "transactionstatusGoToHomeButton")
    private WebElement goHome;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Go home']")
    private WebElement goHomeIOS;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='5']")
    private WebElement pinErrorMessageIOS;

    @FindBy(xpath = "//XCUIElementTypeButton[@name='Retry']")
    private WebElement retryIOS;

    @FindBy(xpath = "//XCUIElementTypeCell[@index = '1']/XCUIElementTypeStaticText")
   // @FindBy(xpath = "//XCUIElementTypeCell[@index='2']/XCUIElementTypeStaticText")
    private List<WebElement> transactionDetailsIOS;

    @AndroidFindBy(id = "transactionconfirmation_payee_mobilenumber")
    private WebElement payeeMobileNumber;

    @FindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@index='0']")
    private WebElement payeeMobileNumberIOS;

    @AndroidFindBy(id = "transactionconfirmation_payee_name")
    private WebElement payeeName;

    @FindBy(xpath = "//XCUIElementTypeCell[1]/XCUIElementTypeStaticText[@index='1']")
    private WebElement payeeNameIOS;

    @AndroidFindBy(id = "transactionconfirmation_amount_text")
    private WebElement transactionAmt;

    @FindBy(xpath = "//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[@index='0']")
    private WebElement transactionAmtIOS;

    @AndroidFindBy(id = "transactionconfirmation_payer_value")
    private WebElement availableBalance;

    @FindBy(xpath = "//XCUIElementTypeCell[5]/XCUIElementTypeStaticText[@index='0']")
    private WebElement availableBalanceIOS;

    @FindBy(xpath="//XCUIElementTypeCell[3]/XCUIElementTypeStaticText[@index = '3']")
    private WebElement serviceChargeIOS;

    @FindBy(xpath="//XCUIElementTypeCell[4]/XCUIElementTypeStaticText[@index = '3']")
    private WebElement netPayableIOS;

    @AndroidFindBy(id = "transactionstatus_status_heading")
    private WebElement postTransactionAmt;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='2']")
    private WebElement postTransactionAmtIOS;

    @AndroidFindBy(id = "transactionstatus_status_subtext")
    private WebElement subText;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='1']")
    private WebElement subTextIOS;

    @AndroidFindBy(id = "transactionstatus_details_value")
    private List<WebElement> transactionStatusDetails;

    @AndroidFindBy(id = "toolbarTextViewCenter")
    private WebElement toolbarTextViewCenter;

    @FindBy(xpath = "//XCUIElementTypeStaticText[@index='1']")
    private WebElement homeAvailableLabelIOS;

    @FindBy(id = "Done")
    private WebElement hideKeyboard;

    @FindBy(name = "PINBackButton")
    private  WebElement pinBackBtnIOS;

    @FindBy(name = "ConfirmationBackButton")
    private  WebElement confirmPinBackBtnIOS;

    @FindBy(name = "mobiquityUI_animation_icon")
    private  WebElement spaceIconIOS;

    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;
    List<WebElement> elementList;

    public FinancialTransactionFlowPageObject clickOnFinancialService(WebElement element , String serviceType){
        clickOnElement(element,serviceType);
        return this;
    }
    int i = 1;

    public FinancialTransactionFlowPageObject clickOnSpaceIconIOS() {
        element = devicePlatform?recent:spaceIconIOS;
        clickOnElement(element, "Space Icon");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }
    public FinancialTransactionFlowPageObject clickOnRecentIcon() {
        element = devicePlatform?recent:recentIOS;
        isElementNotPresent(element);
        isElementClickable(element);
        clickOnElement(element, "Recent Icon");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject setMsisdn(String msisdn) {
        element = devicePlatform?enterMobileNumber:enterMobileNumberIOS;
        isElementClickable(element);
        clickOnElement(element, "Mobile Number  ");
        element = devicePlatform ? textinput_placeholder : textinput_placeholderIOS;
        isElementClickable(element);
        setTextByAction(msisdn, "MSISDN");
        clickOnElement(hideKeyboard,"Done");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnRecentTransaction() {
        clickOnElement(recenTransaction.get(0), "Recent Transaction");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnFavouriteTransaction() {
        clickOnElement(favourite, "Favourite Transaction");
        clickOnElement(recenTransaction.get(0), "Select favourite Transaction");
        return this;
    }



    public FinancialTransactionFlowPageObject setPayee(String payee) {
         if(!devicePlatform){
             if(i==0){
                 clickOnSpaceIconIOS();
                 i+=1;
             }
         }
        if (i == 0)
            clickOnRecentIcon();
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");

        if (payee == "RECENT") {
            clickOnRecentTransaction();
            i++;
        } else if (payee == "FAVOURITE") {
            clickOnFavouriteTransaction();
            i++;
        } else {
           setMsisdn(payee);
            i++;
        }
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public Boolean isErrorLabelPresent(){
        return  devicePlatform ?
                driver.findElements(By.id("errortext")).size() > 0: iosErrorPresentInLabel();
    }


    public Boolean iosErrorPresentInLabel(){
        if(driver.findElements(By.xpath("//XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeStaticText[@index='1']")).size()>0) {
            System.out.println("TRUE1");
            return  true;
        }
        else if(isErrorLabelPresentIOS()) {
            System.out.println("TRUE2");
           return  true;
        }
        else if(isPinErrorLabelPresentIOS()) {
            System.out.println("TRUE3");
            return  true;
        }
        return false;
    }


    public FinancialTransactionFlowPageObject setAmount(String amt) {
        element = devicePlatform ? amount : amountIOS;
        isElementNotPresent(element);
        setText(element, amt, "Amount");
        clickOnElement(hideKeyboard,"Done");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public Boolean isErrorLabelPresentIOS(){
        return driver.findElements(By.xpath("//XCUIElementTypeCell[2]/XCUIElementTypeStaticText[1]")).size()>0;
    }

    public Boolean isPinErrorLabelPresentIOS(){
        return driver.findElements(By.xpath("//XCUIElementTypeOther[@index='0']/XCUIElementTypeStaticText[@index='5']")).size()>0;
    }

    public FinancialTransactionFlowPageObject clickOnNextButton() {
        element = devicePlatform ? nextButton : nextButtonIOS;
        isElementNotPresent(element);
        clickOnElement(element, "Next Button");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnTransferNow() {
        waitUntilElementDisappear("pb_loading","In progress");
        element = devicePlatform ? transferNow : transferNowIOS;
        isElementNotPresent(element);
        clickOnElement(element, "Transfer Now");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject setPin(String pin){
        element = devicePlatform ? otpField : pinIOS;
        setText(element,pin,"OTP");
        clickOnElement(hideKeyboard,"Done");
        return this;
    }
    public FinancialTransactionFlowPageObject clickOnVerifyOtp() {
        clickOnElement(verifyOtp, "Verify OTP Button");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnVerifyPin() {
        element = devicePlatform ? verifyPin : verifyPinIOS;
        clickOnElement(element, "Verify PIN Button");
        waitUntilElementDisappear("pb_loading","In progress");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnMakeAnotherPayment() {
        clickOnElement(forwardIcon.get(0), "Make Another Payment");
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnViewStatement() {
        clickOnElement(forwardIcon.get(1), "View Statement");
        return this;
    }

    public String getTransactionStatus() {
        element = devicePlatform ? transactionStatus:transactionStatusIOS;
        isElementNotPresent(element);
        return element.getText();
    }

    public Boolean isGoHomeButtonPresent(){
        w3CActions.scrollDown();
        return driver.findElements(By.name("Go home")).size()>0;
    }

    public FinancialTransactionFlowPageObject clickOnGoHome() {
        element = devicePlatform ? goHome : goHomeIOS;
        isElementNotPresent(element);
        clickOnElement(element, "Go Home");
        waitUntilElementDisappear("pb_loading","In progress");
        element = devicePlatform ? sendMoney : homeIconIOS;
        isElementNotPresent(element);
        return this;
    }

    public String[] getPayeeDetails() {
        try {
            waitUntilElementDisappear("pb_loading","In progress");
            if(devicePlatform){
                return new String[]{
                        payeeMobileNumber.getText(),
                        payeeName.getText(),
                        transactionAmt.getText(),
                        availableBalance.getText()
                };
            }
            else{
                return new String[]{
                        payeeMobileNumberIOS.getText(),
                        payeeNameIOS.getText(),
                        transactionAmtIOS.getText(),
                        availableBalanceIOS.getText(),
                        serviceChargeIOS.getText(),
                        netPayableIOS.getText()
                };
            }

        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return new String[]{};
        }
    }

    public String[] getTransactionDetails() {
        try {
            if(devicePlatform){
                return new String[]{
                        postTransactionAmt.getText(),
                        transactionStatusDetails.get(0).getText(),
                        transactionStatusDetails.get(1).getText(),
                        transactionStatusDetails.get(2).getText(),
                        transactionStatusDetails.get(3).getText(),
                        transactionStatusDetails.get(4).getText(),
                        //  transactionStatusDetails.get(5).getText()
                };
            }
            else{
                return new String[]{
                        postTransactionAmtIOS.getText(),             //post transaction amt
                        transactionDetailsIOS.get(0).getText(),      // service charge
                        transactionDetailsIOS.get(2).getText(),      // payee mobile number
                        transactionDetailsIOS.get(4).getText(),      //payee name
                        transactionDetailsIOS.get(6).getText(),      //transaction id
                        transactionDetailsIOS.get(8).getText(),     //transaction date
                        //  transactionStatusDetails.get(5).getText()
                };
            }

        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return new String[]{};
        }
    }

    public String getTransactionFailureText() {
        element = devicePlatform ? subText : subTextIOS;
        isElementNotPresent(element);
        return element.getText();
    }

    public Boolean isPinBackBtnPresent(){
       return driver.findElements(By.name("PINBackButton")).size()>0;
    }

    public Boolean isConfirmPinBackBtnPresent(){
        return driver.findElements(By.name("ConfirmationBackButton")).size()>0;
    }

    public FinancialTransactionFlowPageObject clickOnBackButton(){
        element = devicePlatform ? backBtn : isPinBackBtnPresent() ? pinBackBtnIOS : isConfirmPinBackBtnPresent() ? confirmPinBackBtnIOS :backBtnIOS ;
        clickOnElement(element,"Back Button" );
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnCancelButton(){
        element = devicePlatform ? backBtn : cancelBtnIOS;
        isElementClickable(element);
        clickOnElement(element,"Back Button" );
        return this;
    }

    public Boolean isPopUpActionButtonOkPresent(){
      return   driver.findElements(By.id("PopUpActionButtonIdentifier")).size()>0;
    }

    public FinancialTransactionFlowPageObject clickOnReEnterButton(){
        element = devicePlatform ? backBtn : reEnterBtnIOS;
        clickOnElement(element,"Back Button" );
        return this;
    }

    public FinancialTransactionFlowPageObject clickOnTickButton(){
        Dimension dim =driver.manage().window().getSize();
        int height = dim.getHeight();
        int width = dim.getWidth();
        System.out.println("HEIGHT "+height);
        System.out.println("WIDTH "+width);
        W3CActions w3CActions = new W3CActions((int) (width * 0.85 ), (int) (height * 0.92),0,0,0,0);
        w3CActions.tap();
        return this;
    }

    public String getWelcomeText() {
        try {
            waitUntilElementDisappear("pb_loading", "In progress");
            element = devicePlatform ? toolbarTextViewCenter : homeAvailableLabelIOS;
            info("Fetching Text : " + element.getText());
            return element.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }


    public String getValidationMessageFromLabel(){
        element = devicePlatform?errorText.get(0): errorTextIOS;
        element = isErrorLabelPresentIOS() ? errorTextLabelIOS : element;
        element = isPinErrorLabelPresentIOS() ? pinErrorMessageIOS : element;
        try{
            info("Fetching Text : "+element.getText());
            return element.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    public String getValidationMessageFromDialog(){
        element = devicePlatform?errorText.get(0):dialogErrorMessage;
        try{
            info("Fetching Text : "+element.getText());
            return element.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
            return "";
        }
    }

    public Boolean isHomeIconPresent(){
        return devicePlatform ?
                driver.findElements(By.id("homeSendmoneyMainLayout")).size()>0:
                driver.findElements(By.name("tab_home_unselected")).size()>0;
    }

    public Boolean isDialogBoxPresent(){
        return  devicePlatform ?
                driver.findElements(By.id("errortext")).size() > 0:
                driver.findElements(By.name("popUpCancelButtonIdentifier")).size()>0;
    }

    public FinancialTransactionFlowPageObject clickOnRetryButton(){
        element = devicePlatform ? backBtn : retryIOS;
        clickOnElement(element,"Back Button" );
        return this;
    }
}
