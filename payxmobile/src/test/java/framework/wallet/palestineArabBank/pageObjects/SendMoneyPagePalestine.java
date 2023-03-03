package framework.wallet.palestineArabBank.pageObjects;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.bharain.pageObjects.SendMoneyPage1;
import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import propertyManagement.MobileProperties;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class SendMoneyPagePalestine extends AppPageInit {
public  SendMoneyPagePalestine(){
    super();
}

    @AndroidFindBy(id = "com.abp.sub:id/submit_button")
    private WebElement submit_button;

    @AndroidFindBy(id = "com.abp.sub:id/toolbar_title")
    private WebElement toolbar_title;

    String status="",txnid="";
    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/parent_name")
    public List<WebElement> element;

    @AndroidFindBy(id = "com.abp.sub:id/add_services")// select Send Money
    public List<WebElement> element1;

    @AndroidFindBy(id = "com.abp.sub:id/add_services")// select Send Money
    public WebElement addServices;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public List<WebElement> element2;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/TxnStatusMsg")
    private WebElement TxnStatusMsg;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/textview1")
    private List<WebElement> textview1;

    @AndroidFindBy(id = "com.abp.sub:id/textview1")
    private List<WebElement> textview2;

    @AndroidFindBy(id = "com.abp.sub:id/home_button")
    private WebElement home_button1;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement clickOnCountryCode;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> countryCode;


    public boolean isHomeButtonDisplayed(){
        return driver.findElements(By.id("home_button")).size()>0;
    }

    public SendMoneyPagePalestine clickOnHomeButton() {
        clickOnElement(home_button1, "Home Button");
        return this;
    }

    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(home_button1);
        System.out.println(textview2.get(0).getText());
        System.out.println(textview2.get(1).getText());
        status=textview2.get(1).getText();
        txnid=textview2.get(0).getText();
        return new String[]{status,txnid};
    }


    public SendMoneyPagePalestine selectCountryCode(String countryCodes){
        clickOnElement(clickOnCountryCode,"Country Option");
        switch(countryCodes){
            case "972":
                clickOnElement(countryCode.get(0)," +973 is selected as Country Code");
                break;

            case "970":
                clickOnElement(countryCode.get(1)," +968 is selected as Country Code");
                break;

           default:
                throw new UnsupportedOperationException("Country Code is not supported.");
        }
        return this;
    }

    public SendMoneyPagePalestine setMsisdn(String msisdn){
        setText(element2.get(0),msisdn,"Mobile Number");
        return this;
    }

    public SendMoneyPagePalestine clickOnBackButton(){
        clickOnElement(backButton.get(0), "Clicking On Back Button");
        return this;
    }

    public SendMoneyPagePalestine setAmt(String amt){
        setText(element2.get(1),amt,"Amount");
        return this;
    }

    public SendMoneyPagePalestine clickOnSubmitButton()  {
        isElementNotPresent(submit_button);
        clickOnElement(submit_button, "Clicking On Submit Button");
        return this;
    }

    public SendMoneyPagePalestine slideSubmitButton()  {
        try {
            isElementNotPresent(submit_button);
            info("Sliding Seek Bar");
            Utils.slideSeekBar("submit_button",3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    public boolean isClickOnSubmitButtonDisplayed(){
        return driver.findElements(By.id("submit_button")).size()>0;
    }

    public void getToast() throws InterruptedException, IOException {
        ExtentTest pageInfo = ExtentManager.getTest();
        CommonUtils.pauseExecution(2);
        String toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);
        if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0016"))) {
            if (MobileProperties.getProperty("tessdata.lang").equals("eng")) {
                pageInfo.pass("Please Enter Valid Mobile Number");
            } else {
                pageInfo.fail("Validation Failed");
            }
        } else {
            if (MobileProperties.getProperty("tessdata.lang").equals("ara")) {
                pageInfo.pass("Please Enter Valid Mobile Number");
            } else {
                pageInfo.fail("Validation Message displayed in English :- Please Enter Valid Mobile Number");
            }
        }
    }

    public SendMoneyPagePalestine clickOnSendMoneyIcon() {
        isElementNotPresent(addServices);
        clickOnElement(element1.get(2),"Clicking on send money");
        return this;
    }

public boolean isPreConfirmationPageDisplayed(){
        return driver.findElements(By.id("com.abp.sub:id/submit_button")).size()>0;
}

}
