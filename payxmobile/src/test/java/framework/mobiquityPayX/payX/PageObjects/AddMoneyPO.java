package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import common.Assertion;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class AddMoneyPO extends AppPageInit {

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/multiCurrencyNameLabel")
    public WebElement currencydropdown;

    @AndroidFindBy(xpath = "//*[@text='USD']")
    public WebElement USAcurrency;

    @AndroidFindBy(xpath = "//*[@text='IndianRupee']")
    public WebElement INDcurrency;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/multiCurrencyAmountEdittext")
    public WebElement Amountedit;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    public WebElement NextBtn;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_title_textView")
    public WebElement errorMesage1;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_message_textView")
    public WebElement errormessage2;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_ok_buttonView")
    public WebElement GohomeBtnInModal;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/custom_dialog_cancel_buttonView")
    public WebElement CancelBtnInModal;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/transactionconfirmation_next_button")
    public WebElement transferBtn;

    public AddMoneyPO clickoncurrencydropddown(){
        isElementNotPresent(currencydropdown,300);
        clickOnElement(currencydropdown,"clicking on currencydropdown in addmoney screen");
        isElementNotPresent(INDcurrency,300);
        clickOnElement(INDcurrency,"clicking on INDcurrency in addmoney screen");
        return this;
    }
    public String getcurrency(){
        return getText(INDcurrency,"currencytext");
    }
    public AddMoneyPO provideamount(String amount){
        setText(Amountedit,amount,"Providing amount");
        return this;
    }
    public AddMoneyPO clickonNext(){
        clickOnElement(NextBtn,"clicking on Next button");
        return this;
    }
    public AddMoneyPO Errormodal(){
        isElementNotPresent(GohomeBtnInModal,300);
        clickOnElement(GohomeBtnInModal,"clicking on Gohome button");
        return this;
    }
    public String getInvalidBankaccountdetailText(){
        try{
            //waitUntilElementDisappear("pb_loading");
            info("Fetching Text : "+errorMesage1.getText());
            return errorMesage1.getText();
        }
        catch (Exception e){
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }
    public void Addmoneyflow(){
        clickoncurrencydropddown();
        provideamount("1");
        clickonNext();
        try{
            clickOnElement(transferBtn, "Clicking on TransferNow button");
        }catch (Exception e){
            Utils.putThreadSleep(10000);
            Assertion.verifyEqual(getInvalidBankaccountdetailText(),"Unable to fetch bank account details");
            Errormodal();
            e.printStackTrace();
            pageInfo.pass("Please activate Internet/mobile banking");
//            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
    }



}