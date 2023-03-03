package framework.wallet.omantel.pageObjects;

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

     String status="",txnid="";
    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/parent_name")
    public List<WebElement> element;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    public List<WebElement> backButton;

    @AndroidFindBy(xpath = "//*[@class='android.widget.EditText']")
    public List<WebElement> element2;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/submit_button")
    private WebElement submit_button1;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/TxnStatusMsg")
    private WebElement TxnStatusMsg;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/textview1")
    private List<WebElement> textview1;

    @AndroidFindBy(id = "com.omantel.efloos.subscriber:id/home_button")
    private WebElement home_button;

    @AndroidFindBy(id = "android:id/text1")
    private WebElement clickOnCountryCode;

    @AndroidFindBy(id = "android:id/text1")
    private List<WebElement> countryCode;


    public boolean isHomeButtonDisplayed(){
        isElementNotPresent(home_button);
        return driver.findElements(By.id("home_button")).size()>0;

    }

    public SendMoneyPage1 clickOnHomeButton() {
        clickOnElement(home_button, "Home Button");
        return this;
    }

    public String[] getDetails() throws InterruptedException {
        isElementNotPresent(home_button);
        System.out.println(textview1.get(0).getText());
        System.out.println(textview1.get(1).getText());
        status=textview1.get(1).getText();
        txnid=textview1.get(0).getText();
        return new String[]{status,txnid};
    }


    public SendMoneyPage1 setMsisdn(String msisdn){
        isElementNotPresent(element2.get(0));
       // setText(element2.get(0),"99538712","Mobile Number");
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
        isElementNotPresent(submit_button1);
        clickOnElement(submit_button1, "Clicking On Submit Button");
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

    public SendMoneyPage1 clickOnSendMoneyIcon() throws InterruptedException {
        clickOnElement(element.get(0), "Clicking on send money");
        return this;
    }

}
