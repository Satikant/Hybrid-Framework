package framework.wallet.ahliBank.pageObjects;

import framework.wallet.bharain.pageObjects.ChangePinPage;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.Utils;

import java.util.List;

public class ChangePinPageAhliBank extends AppPageInit {

    public ChangePinPageAhliBank(){super();}

    @AndroidFindBy(id="android.widget.LinearLayout")
    private List<WebElement> changePinMenu;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etIdentityNumber")
    private WebElement idNumber;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNext")
    private WebElement btnSubmit;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etOldPIN")
    private WebElement oldPin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etNewPIN")
    private WebElement newPin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnSetPin")
    private WebElement setPin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/bottom_navigation_container")
    private List<WebElement> navigate;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/settingsDescription")
    private WebElement setting;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/changePinLinearLayout")
    private WebElement changePin;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_message_text")
    private WebElement errMsg;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvTitle")
    private WebElement msg;

    public boolean isOldPinDisplayed(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etOldPIN")).size()>0;
    }

    public ChangePinPageAhliBank enteroldPin(String currentPin){
        oldPin.clear();
        setText(oldPin,currentPin,"Enter Old Pin");
        return this;
    }

    public ChangePinPageAhliBank enterNewPin(String nPin){
        newPin.clear();
        setText(newPin, nPin,"Enter new Pin");
        return this;
    }

    public ChangePinPageAhliBank clickOnSetPin(){
        clickOnElement(setPin,"Click on set Pin");
        return this;
    }

    public ChangePinPageAhliBank clickOnSubmit(){
        clickOnElement(btnSubmit,"Click on Submit");
        return this;
    }

    public ChangePinPageAhliBank clickOnChangePinIcon() throws InterruptedException {
        Utils.rightLeftSwipe(1);
        clickOnElement(changePinMenu.get(0),"Click On Change Pin");
        return this;
    }

    public ChangePinPageAhliBank clickOnProfile(){
        clickOnElement(navigate.get(4),"Click On Profile");
        return this;
    }

    public ChangePinPageAhliBank clickOnChangePin(){
        clickOnElement(changePin,"Click on change pin from setting");
        return this;
    }

    public ChangePinPageAhliBank clickOnSetting(){
        clickOnElement(setting,"Click on setting");
        return this;
    }

    public Boolean isOkBtnPresent(){
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/alertdialog_ok_button")).size()>0;
    }

    public String getErrMessage(){
        if(isOkBtnPresent()) {
            return errMsg.getText();
        }else
            return msg.getText();
    }
}
