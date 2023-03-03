package framework.mobiquityPayX.qnb.pageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class QNBBankPageObjects extends AppPageInit {

    public QNBBankPageObjects() {super();}

    @AndroidFindBy(id = "paymentMethodsAddBankLabel")
    private WebElement addBankBtnWhenBankAdded;

    @AndroidFindBy(xpath = "//*[@text='Add bank account']/../..")
    private WebElement addBankBtnWithoutBank;

    @AndroidFindBy(id = "paymentmethodbankNameLayout")
    private List<WebElement> banksLists;

    @AndroidFindBy(id = "fetchDetailNextButton")
    private WebElement associateBankBtn;

    @AndroidFindBy(xpath = "//*[@text='Check balance']/..")
    private WebElement checkBalanceOption;

    @AndroidFindBy(xpath = "/*[@text='Remove bank']/..")
    private WebElement removeBankOption;


    @AndroidFindBy(id = "custom_dialog_message_textView")
    private WebElement bankBalanceText;

    //current account in popup text
    @AndroidFindBy(id = "custom_dialog_title_textView1")
    private WebElement accountTypeText;

    //*[@id='custom_dialog_ok_buttonView'] - Balance ok BTN
    @AndroidFindBy(id = "custom_dialog_ok_buttonView")
    private WebElement bankBalancePopUpOKBtn;

    //*[@id=''] - remove bank ok button
    @AndroidFindBy(id = "confirmation_action_button")
    private WebElement removeBankOkBtn;

    @AndroidFindBy(id = "confirmation_cancel_button")
    private WebElement removeBankCancelBtn;

    @AndroidFindBy(id = "confirmation_description_text")
    private WebElement removeBankDescText;

    private Boolean isBankOptionWithoutBankVisible(){
        System.out.println("Waiting for Home Page to be Displayed...");
        info("Waiting for Home Page to be Displayed...");
        return driver.findElements(By.xpath("//*[@text='Add bank account']/../..")).size() > 0 ;
    }

    public QNBBankPageObjects clickOnAddBank(){
        if(isBankOptionWithoutBankVisible()){
            clickOnElement(addBankBtnWithoutBank,"Add Bank Button when No Bank is Added");
            return this;
        }else
            clickOnElement(addBankBtnWhenBankAdded,"Add Bank Button When Bank is not present");
            return this;
    }

    public QNBBankPageObjects clickOnAssociateBank(){
        clickOnElement(associateBankBtn,"Associate Bank");
        return this;
    }
    public QNBBankPageObjects clickOnFirstBank(){
        clickOnElement(banksLists.get(1),"Bank [First Bank In List]");
        return this;
    }

    public QNBBankPageObjects selectBankWithIndex(int index){
        clickOnElement(banksLists.get(index),"Bank With index = "+ String.valueOf(index));
        return this;
    }

    public QNBBankPageObjects clickOnCheckBalance(){
        clickOnElement(checkBalanceOption,"Check balance");
        return this;
    }
    public QNBBankPageObjects clickOnRemoveBank(){
        clickOnElement(removeBankOption,"Remove Bank Option");
        return this;
    }
    public QNBBankPageObjects clickOnRemoveBankOkBtn(){
        clickOnElement(removeBankOkBtn,"Remove Bank Ok Btn");
        return this;
    }
    public QNBBankPageObjects clickOnRemoveBankCancelBtn(){
        clickOnElement(removeBankCancelBtn,"Remove Bank Cancel Btn");
        return this;
    }
    public QNBBankPageObjects clickOnBalanceOkBtn(){
        clickOnElement(bankBalancePopUpOKBtn,"Bank Balance Ok Btn");
        return this;
    }

    public String getBankBalanceAmt(){
        return getText(bankBalanceText,"Bank Balance Text");
    }

    public String getAccountTypeText(){
        return getText(accountTypeText,"Account Type Text");
    }

    public String getRemoveBankDescText(){
        return getText(removeBankDescText,"Remove Bank Desc Text");
    }





}
