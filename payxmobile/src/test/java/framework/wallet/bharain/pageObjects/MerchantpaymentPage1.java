package framework.wallet.bharain.pageObjects;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
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

public class MerchantpaymentPage1 extends AppPageInit {

  public MerchantpaymentPage1() {
        super();
    }

    String status="",txnid="";

    ExtentTest featureNode = ExtentManager.getTest();

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    public List<WebElement> paytoMerchbtn;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement> merchNo;

    @AndroidFindBy(xpath = "(//android.widget.EditText)[3]")
    public WebElement Amount;

    @AndroidFindBy(id = "com.batelco.sub:id/submit_button")
    public WebElement Submit;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(id = "com.batelco.sub:id/home_button")
    public WebElement homebutton;

    @AndroidFindBy(id = "com.batelco.sub:id/textview1")
    private List<WebElement> textview1;


    public MerchantpaymentPage1 clickOnmerchantpayicon() {
        clickOnElement(paytoMerchbtn.get(0), "Clicking on Pay to Merchant");
        return this;
    }
    public boolean isPreconfirmationScreenPresent(){
        return driver.findElements(By.id("com.batelco.sub:id/conLayout")).size()>0;
    }

    public MerchantpaymentPage1 SetMerchNo(String merNo) {
        isElementNotPresent(merchNo.get(1));
        setText(merchNo.get(1),merNo, "Merchant Mobile No.");
        return this;
    }

    public MerchantpaymentPage1 SetAmount(String amt) {
        setText(Amount, amt, "Amount to be payed");
        return this;
    }

    public MerchantpaymentPage1 clickOnHomeButton() {
        clickOnElement(homebutton,"Home Button");
        return this;
    }

    public MerchantpaymentPage1 ClickOnSubmit() {
        clickOnElement(Submit, "Clicked on submit");
        return this;
    }

    public boolean isClickOnSubmitButtonDisplayed(){
        return driver.findElements(By.id("submit_button")).size()>0;
    }

    public MerchantpaymentPage1 clickOnBackButton(){
        clickOnElement(backButton.get(0),"Clicking On Back Button");
        return this;
    }


    public boolean isPayToMerchantPresent(){
        CommonUtils.pauseExecution(5);
        return driver.findElements(By.id("com.batelco.sub:id/desc_image")).size() > 0;
    }

    public String[] getDetails() {
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


    public String getToast()  {
        CommonUtils.pauseExecution(2);
        String toastMessage=Utils.getToastMessage();
        System.out.println(toastMessage);
        Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0049"));
        return null;
    }





}