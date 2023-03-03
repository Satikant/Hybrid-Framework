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
import java.util.ArrayList;
import java.util.List;


public class InternationalTopUpPage extends AppPageInit {
    public InternationalTopUpPage() {
        super();
    }

    String status = "", txnid = "";

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    public List<WebElement> Inttopupbtn;

    @AndroidFindBy(id = "com.batelco.sub:id/countryText")
    public WebElement drpCountry;

    @AndroidFindBy(id = "com.batelco.sub:id/myEditText")
    public WebElement MobNumber;

    @AndroidFindBy(id ="com.batelco.sub:id/proceedButton")
    public WebElement viewplans ;

    @AndroidFindBy(id = "com.batelco.sub:id/submit_button")
    public WebElement Submit;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(id = "com.batelco.sub:id/snackbar_action")
    public WebElement okbtn ;

    @AndroidFindBy(id = "com.batelco.sub:id/home_button")
    public WebElement homebutton;

    @AndroidFindBy(id="com.batelco.sub:id/sub_text")
    private WebElement message;

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    public List<WebElement> paytoMerchbtn;

    @AndroidFindBy(id = "android:id/text1")
    public List<WebElement> topUpcountry;

    @AndroidFindBy(id="com.batelco.sub:id/txt_search")
    private WebElement txt_search;


    public Boolean isTitleDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/toolbar_title")).size() > 0;
    }

    public InternationalTopUpPage clickOnIntTopUpicon()  {
        isElementNotPresent(paytoMerchbtn.get(0));
        Utils.scrollToRightOfActivityPage();
        clickOnElement(Inttopupbtn.get(2), "Clicking on International Top Up");
        return this;
    }

    public InternationalTopUpPage clickOnHomeButton() {
        clickOnElement(homebutton,"Home Button");
        return this;
    }

    public InternationalTopUpPage ClickOnSubmit() {
        clickOnElement(Submit, "Clicked on submit");
        return this;
    }

    public InternationalTopUpPage clickOnBackButton(){
        clickOnElement(backButton.get(0),"Clicking On Back Button");
        return this;
    }

    public InternationalTopUpPage clickOnOkBtn(){
        clickOnElement(okbtn,"clicking on Ok");
        return this;
    }

    public boolean isHomeButtonDisplayed(){
        isElementNotPresent(homebutton);
        return driver.findElements(By.id("com.batelco.sub:id/home_button")).size()>0;
    }

    public boolean isErrorMessageDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/snackbar_text")).size() > 0;
    }

    public boolean isClickOnSubmitButtonDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/submit_button")).size() > 0;
    }

    public String toastMessage;
    public void getToast()  {
        ExtentTest pageInfo = ExtentManager.getTest();
        CommonUtils.pauseExecution(2);
        String toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);
        if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0077"))) {
            if (MobileProperties.getProperty("tessdata.lang").equals("eng")) {
                pageInfo.pass("Please Enter Valid Telephone Number");
            } else {
                pageInfo.fail("Validation Failed");
            }
        } else {
            if (MobileProperties.getProperty("tessdata.lang").equals("ara")) {
                pageInfo.pass("Please Enter Valid Telephone Number");
            } else {
                pageInfo.fail("Validation Message displayed in English :- Please Enter Valid Telephone Number");
            }
        }
    }

    public InternationalTopUpPage setCountrydropdown(String country) {
        isElementNotPresent(drpCountry);
        clickOnElement(drpCountry ,"Bahrain");
        if(country==""){
            setText(txt_search,"Country","Entering country");
            clickOnElement(topUpcountry.get(0),"Entering country");
        }
        else{
            setText(txt_search,country,"Entering "+country);
            clickOnElement(topUpcountry.get(0),"Slecting "+country);
        }
        return this;
    }

    public InternationalTopUpPage Setmsisdn(String number) {
        setText(MobNumber, number, "MSISDN of User");
        return this;
    }

    public InternationalTopUpPage Viewplans() {
        clickOnElement(viewplans, "Clicking on view Plans");
        return this;
    }

}
