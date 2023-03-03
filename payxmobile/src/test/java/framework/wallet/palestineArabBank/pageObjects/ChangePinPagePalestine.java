package framework.wallet.palestineArabBank.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import java.util.List;

public class ChangePinPagePalestine extends AppPageInit {

    public ChangePinPagePalestine(){
        super();
    }

    @AndroidFindBy(id="android:id/button3")
    private WebElement okBtn;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_text")
    private static WebElement snackbar_text2;

    @AndroidFindBy(id = "com.abp.sub:id/submit")
    private WebElement submit;

    @AndroidFindBy(id = "com.abp.sub:id/eedit0")
    private WebElement oldpin;

    @AndroidFindBy(id = "com.abp.sub:id/eedit1")
    private WebElement newpin;

    @AndroidFindBy(id = "com.abp.sub:id/eedit2")
    private WebElement confirmpin;

    @AndroidFindBy(id = "com.abp.sub:id/menu_button")
    private WebElement menuBtn;

    @AndroidFindBy(id="com.abp.sub:id/lblListHeader")
    private List<WebElement> selectChangePin;


    @AndroidFindBy(className = "android.widget.EditText")
    private List<WebElement> secAnswer;

    @AndroidFindBy(className = "android.widget.FrameLayout")
    private List<WebElement> errDialogBox;

    @AndroidFindBy(id = "android:id/message")
    private static WebElement msg2;

    @AndroidFindBy(xpath = "//*[@class='android.widget.ImageButton']")
    private List<WebElement> backBtn;

    LoginPagePalestine page = new LoginPagePalestine();

    public ChangePinPagePalestine clickOnSubmitButton(){
        clickOnElement(submit,"Submit Button");
        return this;
    }

    public ChangePinPagePalestine clickOnMenuButton()  {
        clickOnElement(menuBtn, "Clicking On Menu button");
        return this;
    }

    public ChangePinPagePalestine clickOnBackButton()  {
        clickOnElement(backBtn.get(0), "Clicking On Back button");
        return this;
    }

public boolean isOldPinPresent(){
        return driver.findElements(By.id("eedit0")).size()>0;
}

public boolean isMenuBtnDisplayed() { return driver.findElements(By.id("com.abp.sub:id/menu_button")).size()>0; }

    public ChangePinPagePalestine setOldPin(String oldPin){
        oldpin.clear();
        setText(oldpin,oldPin,"Subscriber's Old PIN");
        return this;
    }

    public ChangePinPagePalestine setNewPin(String newPin){
        newpin.clear();
        setText(newpin,newPin,"Subscriber's New PIN");
        return this;
    }

    public ChangePinPagePalestine setConfirmPin(String cPin){
        confirmpin.clear();
        setText(confirmpin,cPin,"Subscriber's Confrim PIN");
        return this;
    }

    public ChangePinPagePalestine clickOnChangePin(){
clickOnElement(selectChangePin.get(8),"Cick on change Pin");
        return this;
    }

    public boolean isSecurityAnswerPresent(){
        return driver.findElements(By.className("")).size()>0;
    }
    public ChangePinPagePalestine enterSecAnswer(String text) {
        CommonUtils.pauseExecution(1);
        secAnswer.get(0).clear();
        setText(secAnswer.get(0), text, "Enter new Security answer");
        return this;
    }

    public  boolean isOkButtonDisplayed(){
        return driver.findElements(By.id("android:id/button3")).size()>0;
    }

    public ChangePinPagePalestine clickOnOk(){
        clickOnElement(okBtn,"Click on Ok button");
        return this;
    }

    public boolean isErrDialogBoxPresent(){
        return driver.findElements(By.className("android.widget.FrameLayout")).size()>0;
    }

    public  String getErrMsg() {
        CommonUtils.pauseExecution(3);
        if(isSnackbarDisplayed()) {
            System.out.print(snackbar_text2.getText());
            return snackbar_text2.getText();
        }else{
            System.out.print(msg2.getText());
            return msg2.getText();
        }
    }

    public boolean isSnackbarDisplayed() {
        return driver.findElements(By.id("snackbar_text")).size() > 0;
    }


}
