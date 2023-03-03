package framework.wallet.bharain.pageObjects;

import common.Assertion;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.MessageReader;
import java.io.IOException;
import java.util.List;

public class ChangeEmailIdPage extends AppPageInit {

    public ChangeEmailIdPage() {
        super();
    }

    @AndroidFindBy(id = "com.batelco.sub:id/account_holder")
    private WebElement userName;

    @AndroidFindBy(id = "com.batelco.sub:id/android:id/message")
    private WebElement message;

    @AndroidFindBy(id = "com.batelco.sub:id/resend_text")
    private WebElement resendOtp;

    @AndroidFindBy(id = "com.batelco.sub:id/edit_button")
    private WebElement editBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/email_edit_text")
    private WebElement updateEmail;

    @AndroidFindBy(id = "com.batelco.sub:id/save_button")
    private WebElement saveBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/otp_input")
    private WebElement otpField;

    @AndroidFindBy(id = "com.batelco.sub:id/verify_button")
    private WebElement verifyBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/TxnStatusMsg")
    private WebElement txnStatus;

    @AndroidFindBy(id = "com.batelco.sub:id/HOME")
    private WebElement homeBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/textview1")
    private List<WebElement> txnPass;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private List<WebElement> clickBack;

    public ChangeEmailIdPage clickOnUserName() {
        clickOnElement(userName, "Click on User's Name");
        return this;
    }

    public boolean isEmailIdPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/email_edit_text")).size() > 0;
    }

    public boolean isUserNamePresent() {
        return driver.findElements(By.id("com.batelco.sub:id/account_holder")).size() > 0;
    }

    public ChangeEmailIdPage clickOnEdit() {
        isElementNotPresent(editBtn);
        clickOnElement(editBtn, "Click On Edit");
        waitUntilElementDisappear("progress");
        return this;
    }

    public ChangeEmailIdPage setNewEmailId(String text) {
        updateEmail.clear();
        driver.navigate().back();
        driver.navigate().back();
        setText(updateEmail, text, " Enter new email id");
        return this;
    }

    public ChangeEmailIdPage clickOnSave() {
        isElementNotPresent(saveBtn);
        clickOnElement(saveBtn, "Click on Save button");
        return this;
    }

    public ChangeEmailIdPage enterOtp(String otp) {
        clickOnElement(resendOtp, "Click on resend OTP");
        waitUntilElementDisappear("progress");
        isElementNotPresent(otpField);
        setText(otpField, otp, "Enter OTP");
        return this;
    }

    public ChangeEmailIdPage clickOnVerify() {
        clickOnElement(verifyBtn, "Click on verify button");
        waitUntilElementDisappear("progress");
        return this;
    }

    public Boolean isHomeBtnPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/HOME")).size() > 0;
    }

    public ChangeEmailIdPage clickOnHomebtn() {
        clickOnElement(homeBtn, "Click On Home Button");
        return this;
    }

    public String getTxnStatus() {
        isElementNotPresent(homeBtn);
        return txnStatus.getText();
    }

    public String getPassFail() {
        return txnPass.get(0).getText();
    }

    String toastMessage;

    public void getToast() {
        toastMessage = driver.getPageSource();
        System.out.println(toastMessage);
        Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0070"));

    }

    public ChangeEmailIdPage clickBack() {
        clickOnElement(clickBack.get(0), "Click on Back");
        return this;
    }

}