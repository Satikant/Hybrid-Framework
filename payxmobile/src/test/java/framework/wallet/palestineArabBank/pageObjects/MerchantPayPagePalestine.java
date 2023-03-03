package framework.wallet.palestineArabBank.pageObjects;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;

import java.io.IOException;
import java.util.List;

public class MerchantPayPagePalestine extends AppPageInit {

    public MerchantPayPagePalestine() {
        super();
    }

    String status="",txnid="";

    ExtentTest featureNode = ExtentManager.getTest();

    @AndroidFindBy(id = "com.abp.sub:id/add_services")
    public List<WebElement> paytoMerchbtn;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0' and @clickable='true']")
    public WebElement ptm;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> merchNo;

    @AndroidFindBy(className = "android.widget.ImageView")
    public List<WebElement> contacts;

    @AndroidFindBy(className = "android.widget.Button")
    public List<WebElement> Qr;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> Amount;

    @AndroidFindBy(id = "com.abp.sub:id/submit_button")
    public WebElement Submit;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(id = "com.abp.sub:id/home_button")
    public WebElement homebutton;

    @AndroidFindBy(id = "com.abp.sub:id/textview1")
    private List<WebElement> textview1;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> text1;

    public MerchantPayPagePalestine clickonMerchPayIcon() throws InterruptedException {
        isElementNotPresent(ptm);
        clickOnElement(paytoMerchbtn.get(0), "Clicking on Pay to Merchant");
        return this;
    }
    public boolean isPreconfirmationScreenPresent(){
        return driver.findElements(By.id("com.batelco.sub:id/conLayout")).size()>0;
    }

    public MerchantPayPagePalestine clickOnSubmitButton() {
        isElementNotPresent(Submit);
        info("Clicking on Submit button");
        Utils.slideSeekBar("submit_button", 2000);
        return this;
    }

    public boolean isClickOnSubmitButtonDisplayed(){
        return driver.findElements(By.id("submit_button")).size()>0;
    }

    public MerchantPayPagePalestine SetMerchNo(String merNo) {
        setText(merchNo.get(0),merNo, "Merchant Mobile No.");
        return this;
    }

    public MerchantPayPagePalestine contact() {
        clickOnElement(contacts.get(1), "Selecting from contacts");
        return this;
    }

    public MerchantPayPagePalestine QR() {
        clickOnElement(Qr.get(2), "Scanning QR");
        return this;
    }

    public MerchantPayPagePalestine SetAmount(String amt) {
        setText(Amount.get(1), amt, "Amount to be payed");
        return this;
    }

    public MerchantPayPagePalestine clickOnHomeButton() {
        clickOnElement(homebutton,"Home Button");
        return this;
    }

    public MerchantPayPagePalestine ClickOnSubmit() {
        clickOnElement(Submit, "Clicked on submit");
        return this;
    }

    public MerchantPayPagePalestine ClickOnCountryCode() {
        clickOnElement(text1.get(0), "Clicked on Country code");
        return this;
    }

    public MerchantPayPagePalestine ClickOnCode() {
        clickOnElement(text1.get(1), "Clicked on 970 code");
        return this;
    }

    public MerchantPayPagePalestine clickOnBackButton(){
        clickOnElement(backButton.get(0),"Clicking On Back Button");
        return this;
    }


    public boolean isPayToMerchantPresent(){
        CommonUtils.pauseExecution(5);
        return driver.findElements(By.xpath("(//android.widget.FrameLayout)[0]")).size() > 0;
    }

    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(homebutton);
        System.out.println(textview1.get(0).getText());
        System.out.println(textview1.get(1).getText());
        status=textview1.get(1).getText();
        txnid=textview1.get(0).getText();
        Assertion.verifyEqual(status,"Successful");
        featureNode.info(txnid);
        return new String[]{status,txnid};
    }

    public void checkStatus(){
        status=textview1.get(1).getText();
        txnid=textview1.get(0).getText();
        Assertion.verifyEqual(status,"Successful");
        System.out.println(txnid);
        CommonUtils.captureScreenMobile(featureNode,"Transaction Status");
    }


    public String getToast() throws InterruptedException, IOException {
        CommonUtils.pauseExecution(2);
        String toastMessage= Utils.getToastMessage();
        System.out.println(toastMessage);
        Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0049"));
        return null;
    }

}
