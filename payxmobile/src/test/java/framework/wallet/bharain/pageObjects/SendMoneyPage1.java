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


public class SendMoneyPage1 extends AppPageInit {
    public SendMoneyPage1(){
        super();
    }

    String status="",txnid="";

    @AndroidFindBy(id = "com.batelco.sub:id/submit_button")
    private WebElement submit_button;

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    public List<WebElement> element1;

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    public WebElement serviceIcon;

    @AndroidFindBy(id = "   com.batelco.sub:id/qrlinear")
    public WebElement qrlinear;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public List<WebElement> element2;

    @AndroidFindBy(id = "com.batelco.sub:id/textview1")
    private List<WebElement> textview2;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/home_button")
    private WebElement home_button;

    @AndroidFindBy(id = "com.batelco.sub:id/home_button")
    private WebElement home_button1;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement clickOnCountryCode;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> countryCode;


    public SendMoneyPage1 clickOnSendMoneyIcon(){
            isElementNotPresent(serviceIcon);
            clickOnElement(element1.get(5),"Clicking on send money");
        return this;
    }

    public boolean isHomeButtonDisplayed(){
            return driver.findElements(By.id("home_button")).size()>0;
    }

    public SendMoneyPage1 clickOnHomeButton() {
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


    public SendMoneyPage1 selectCountryCode(String countryCodes){
        clickOnElement(clickOnCountryCode,"Country Option");
        switch(countryCodes){
            case "973":
                clickOnElement(countryCode.get(1)," +973 is selected as Country Code");
                break;

            case "968":
                clickOnElement(countryCode.get(1)," +968 is selected as Country Code");
                break;

            case "965":
                clickOnElement(countryCode.get(2)," +965 is selected as Country Code");
                break;

            case "974":
                clickOnElement(countryCode.get(3)," +974 is selected as Country Code");
                break;

            case "966":
                clickOnElement(countryCode.get(4)," +966 is selected as Country Code");
                break;

            case "971":
                clickOnElement(countryCode.get(5)," +971 is selected as Country Code");
                break;

            default:
                throw new UnsupportedOperationException("Country Code is not supported.");
        }
        return this;
    }

    public SendMoneyPage1 setMsisdn(String msisdn){
        isElementNotPresent(element2.get(0));
        setText(element2.get(0),msisdn,"Mobile Number");
        return this;
    }

    public SendMoneyPage1 clickOnBackButton(){
        clickOnElement(backButton.get(0), "Clicking On Back Button");
        return this;
    }

    public SendMoneyPage1 setAmt(String amt){
        setText(element2.get(1),amt,"Amount");
        return this;
    }

    public SendMoneyPage1 clickOnSubmitButton()  {
        isElementNotPresent(submit_button);
        clickOnElement(submit_button, "Clicking On Submit Button");
        waitUntilElementDisappear("android:id/progress");
        return this;
    }

    public boolean isClickOnSubmitButtonDisplayed(){
        return driver.findElements(By.id("submit_button")).size()>0;
    }

    public void getUnknownError() throws InterruptedException {
        ExtentTest pageInfo= ExtentManager.getTest();
        String xmlFormat = driver.getPageSource();
        if(xmlFormat.contains("Technical Error")){
            System.out.println("Toast message displayed: "+"Technical Error");
            Assertion.verifyContains(xmlFormat,"Validation Message is Missing :- Search this 'Technical Error' Text");
        }
        else{

                pageInfo.fail("Unknown Error");

        }

    }

    public void getToast() throws InterruptedException, IOException {
            ExtentTest pageInfo = ExtentManager.getTest();
            CommonUtils.pauseExecution(2);
            String toastMessage = Utils.getToastMessage();
            System.out.println(toastMessage);
            if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0049"))) {
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



}
