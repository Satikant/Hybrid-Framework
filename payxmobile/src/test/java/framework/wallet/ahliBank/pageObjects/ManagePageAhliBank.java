package framework.wallet.ahliBank.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;

public class ManagePageAhliBank extends AppPageInit {

    public ManagePageAhliBank() { super(); }



    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvServiceName")
    private WebElement manageBenIcon;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/imageViews")
    private WebElement threeDots;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvName")
    private WebElement sample;

//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363365")
//    private WebElement successfulDelete;

    @AndroidFindBy(id = "com.ahlibank.ahlipay.subscriber.uat:id/tvView")
    private WebElement view;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnToolbarBack")
    private WebElement backButton;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvError")
    private WebElement delete;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvDelete")
    private WebElement delete1;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnDelete")
    private WebElement delete2;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement yesDelete;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnNegativeAction")
    private WebElement noDelete;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnCancel")
    private WebElement cancelButton;

//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363365")
//    private WebElement viewName;
//
//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363398")
//    private WebElement viewTransferOption;
//
//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363298")
//    private WebElement viewFName;
//
//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363302")
//    private WebElement viewMName;
//
//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363301")
//    private WebElement viewLName;
//
//    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/2131363400")
//    private WebElement viewTransferOption2;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvMessage")
    private WebElement deleteMessage;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/tvMessage")
    private WebElement deleteMessage2;

    @AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnPositiveAction")
    private WebElement okDelete;

//    com.ahlibank.ahlipay.subscriber.uat:id/2131363365 sample sample sample
//    com.ahlibank.ahlipay.subscriber.uat:id/2131363398 Wallet To Account

//    com.ahlibank.ahlipay.subscriber.uat:id/2131363400 Wallet To Account
//    com.ahlibank.ahlipay.subscriber.uat:id/2131363298 FName sample
//    com.ahlibank.ahlipay.subscriber.uat:id/2131363302 MName sample
//    com.ahlibank.ahlipay.subscriber.uat:id/2131363301 LName sample



    public boolean isBeneficiaryPresent() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/imageViews")).size()>0;
    }

    public boolean isManageBenIconAvailable() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/tvServiceName")).size()>0;
    }

    public boolean isDeleteButtonPresent() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/tvError")).size()>0;
    }

    public boolean isDelete1ButtonPresent() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/tvDelete")).size()>0;
    }

    public boolean isDelete2ButtonPresent() {
        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/btnDelete")).size()>0;
    }

//    public boolean isNoDeleteBtnPresent() {
//        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/2131362009")).size()>0;
//    }
//
//    public boolean isYesDeleteBtnPresent() {
//        return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/2131362015")).size()>0;
//    }

    public ManagePageAhliBank clickOnManageBenIcon() {
        clickOnElement(manageBenIcon, "Clicking on Manage Beneficiary icon");
        return this;
    }

    public ManagePageAhliBank clickOnBeneficiary() {
        clickOnElement(threeDots, "Clicking on added Beneficiary name");
        return this;
    }

    public ManagePageAhliBank clickOnView() {
        isElementNotPresent(view);
     PointOption.point(1, 2000);
        clickOnElement(view,"Clicking on View Beneficiary icon");
        return this;
    }

    public ManagePageAhliBank clickOnBack() {
        clickOnElement(backButton, "Clicking on Back button");
        return this;
    }

    public ManagePageAhliBank clickOnCancel() {
        clickOnElement(cancelButton, "Click on cancel button");
        return this;
    }

    public ManagePageAhliBank clickOnDelete() {
        CommonUtils.pauseExecution(2);
        clickOnElement(delete, "Clicking on Delete button");
        return this;
    }

    public ManagePageAhliBank clickOnNoDelete() {
        CommonUtils.pauseExecution(2);
        clickOnElement(noDelete, "Clicking 'No' after clicking on Delete button");
        return this;
    }

    public ManagePageAhliBank clickOnYesDelete() {
        CommonUtils.pauseExecution(2);
        clickOnElement(yesDelete, "Clicking 'Yes' after clicking on Delete button");
        return this;
    }

    public ManagePageAhliBank clickOnDelete1() {
        clickOnElement(delete1, "Clicking on Delete1 button");
        return this;
    }

    public ManagePageAhliBank clickOnDelete2() {
        clickOnElement(delete2, "Clicking on Delete2 button");
        return this;
    }

    public ManagePageAhliBank chickOnNoDelete() {
        clickOnElement(noDelete,"Click on No");
        return this;
    }

    public String getDeleteMessage () {
        CommonUtils.pauseExecution(2);
        System.out.println(deleteMessage.getText());
        return deleteMessage.getText();
    }

    public String getYesDeleteMessage () {
        CommonUtils.pauseExecution(2);
        System.out.println(deleteMessage2.getText());
        return deleteMessage2.getText();
    }

    public ManagePageAhliBank clickOnOkDelete () {
        clickOnElement(okDelete,"Clicking on Ok");
        return this;
    }

//    String benFName,benLName,benMName, transferOption;
//
//    public String[] getBeneficiaryDetails() {
//
//        benFName=viewFName.getText();
//        benMName=viewMName.getText();
//        benLName=viewLName.getText();
//        transferOption=viewTransferOption2.getText();
//
//        return new String[]{benFName,benMName,benLName,transferOption};
//    }


}

