package framework.wallet.bharain.pageObjects;


import framework.wallet.ahliBank.pageObjects.BillPayPageAhliBank;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

import java.util.List;

public class ChangePinPage extends AppPageInit {
    public ChangePinPage(){
        super();
    }

    @AndroidFindBy(id = "com.batelco.sub:id/LoginID")
    private WebElement LoginID ;

    @AndroidFindBy(id = "com.batelco.sub:id/menu_button")
    private WebElement menu_button1;

    @AndroidFindBy(id = "com.batelco.sub:id/submit")
    private WebElement submit;

    @AndroidFindBy(id = "com.batelco.sub:id/eedit0")
    private WebElement oldpin;

    @AndroidFindBy(id = "com.batelco.sub:id/eedit1")
    private WebElement newpin;

    @AndroidFindBy(id = "com.batelco.sub:id/eedit2")
    private WebElement confirmpin;

    @AndroidFindBy(id = "com.batelco.sub:id/lblListHeader")
    public List<WebElement>menuItems;

    @AndroidFindBy(className = "android.widget.EditText")
    public List<WebElement>secAns;

    @AndroidFindBy(id = "com.batelco.sub:id/proceedButton")
    private WebElement proceedButton;

    @AndroidFindBy(id = "android:id/button3")
    private WebElement alertOk;

    public ChangePinPage clickOnMenuButton()  {
        clickOnElement(menu_button1, "Clicking On Menu button");
        return this;
    }

    public ChangePinPage clickOnSubmitButton(){
        clickOnElement(submit,"Submit Button");
        return this;
    }

    public ChangePinPage setOldPin(String oldPin){
        isElementNotPresent(oldpin);
        setText(oldpin,oldPin,"Subscriber's Old PIN");
        return this;
    }

    public ChangePinPage setNewPin(String newPin){
        setText(newpin,newPin,"Subscriber's New PIN");
        return this;
    }

    public ChangePinPage setConfirmPin(String confirmPin){
        setText(confirmpin,confirmPin,"Subscriber's Confrim PIN");
        return this;
    }

    public ChangePinPage clickOnChangePin(){
        clickOnElement(menuItems.get(1),"Change Pin Icon");
        return this;
    }

    public ChangePinPage setSecurityAnswer(String securityAnswer){
        isElementNotPresent(proceedButton);
        setText(secAns.get(0),securityAnswer,"Security Answer is "+securityAnswer);
        return this;
    }

    public ChangePinPage clickOnNext(){
        clickOnElement(proceedButton,"Next Button");
        return this;
    }

    public ChangePinPage clickOnAlertOkButton(){
        clickOnElement(alertOk,"OK Button");
        return this;
    }

    public boolean isAlertBoxDisplayed() {
        return driver.findElements(By.id("android:id/button3")).size() > 0;
    }

    public boolean isLoginToolBarDisplayed() {
        isElementNotPresent(LoginID);
        return driver.findElements(By.id("com.batelco.sub:id/LoginID")).size() > 0;
    }

    public boolean isLoaderDisplayed(){
        return driver.findElements(By.id("android:id/progress")).size()>0;
    }

    public boolean  waitTillLoaderDisplayed(){
         return waitUntilElementDisappear("android:id/progress");
    }

}
