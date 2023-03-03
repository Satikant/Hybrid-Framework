package framework.wallet.bankMuscat.pageObjects;

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


public class SendMoneyPageBankMuscat extends AppPageInit {

    public SendMoneyPageBankMuscat(){
        super();
    }

    @AndroidFindBy(id = "app.banking.bankmuscat:id/sendmoney_img")
    private WebElement sendMoney;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/img_profilepic")
    private WebElement mobileTab;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/alias_txt")
    private WebElement aliasTab;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/qr_txt")
    private WebElement QRCodeTab;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/img_profilepic")
    private WebElement benMobileNoTbox;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edt_number")
    private WebElement mobileNumber;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edt_amount")
    private WebElement amountTbox;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/edt_description")
    private WebElement descriptionTbox;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttoncancel")
    private WebElement cancelButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttonnext")
    private WebElement nextButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btnok")
    private WebElement btnok;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/mob_buttonok")
    private WebElement mob_buttonok ;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btnno")
    private WebElement btnno;

    @AndroidFindBy(id="android:id/text1")
    private List<WebElement> list;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txtmessage")
    private static WebElement txtmessage;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/title")
    private static WebElement title;

    public Boolean isTitleDisplayed(){
        return driver.findElements(By.id("title")).size()>0;
    }

    public SendMoneyPageBankMuscat clickOnSendMoney() {
        clickOnElement(sendMoney,"Clicking on Send Money");
        return this;
    }

    public SendMoneyPageBankMuscat setBeneficiaryMobileNo(String mobNo){
        setText(mobileNumber,mobNo,"Beneficiary Mobile No.");
        return this;
    }

    public SendMoneyPageBankMuscat setAmount(String amt){
        setText(amountTbox,amt,"Amount");
        return this;
    }

    public SendMoneyPageBankMuscat setDescription(String desc){
        setText(descriptionTbox,desc,"Description");
        return this;
    }

    public boolean isErrorMessageDisplayed(){
        return driver.findElements(By.id("btnok")).size()>0;
    }

    public SendMoneyPageBankMuscat clickOnOk()  {
        clickOnElement(btnok, "Clicking on OK Button");
        return this;
    }

    public SendMoneyPageBankMuscat clickOnNo()  {
        clickOnElement(btnno, "Clicking on NO Button");
        return this;
    }

    public SendMoneyPageBankMuscat clickButtonOk()  {
        clickOnElement(mob_buttonok, "Clicking on OK Button");
        return this;
    }

    public SendMoneyPageBankMuscat clickOnNext() {
        clickOnElement(nextButton,"Clicking Next Button");
        return this;
    }

    public SendMoneyPageBankMuscat clickOnCancelButton()  {
        clickOnElement(descriptionTbox,"Cancel Button");
        return this;
    }

    public SendMoneyPageBankMuscat clickOnAliasTab()  {
        clickOnElement(aliasTab,"Alias Tab");
        return this;
    }
    public static String getMessageFromDevice() throws InterruptedException {
        return   txtmessage.getText();
    }

    public void selectBankNameForAlias(String bankname){
        for (WebElement element : list){
            System.out.println(element.getText());

            if(element.getText().equalsIgnoreCase(bankname)){
                element.click();
                System.out.println("Selected Element : Oman Arab Bank SAO");
                break;
            }
        }
    }
}
