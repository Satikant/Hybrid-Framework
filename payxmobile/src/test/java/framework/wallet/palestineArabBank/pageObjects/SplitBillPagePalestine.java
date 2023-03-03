package framework.wallet.palestineArabBank.pageObjects;

import common.Assertion;
import framework.wallet.ahliBank.pageObjects.MerchantPaymentPageAhliBank;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;
import utils.W3CActions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class SplitBillPagePalestine extends AppPageInit {
    
    public SplitBillPagePalestine() {
        super();
    }

    LoginPagePalestine loginpage = new LoginPagePalestine();

    @AndroidFindBy(id = "com.abp.sub:id/members_add")
    public WebElement btnAdd;

    @AndroidFindBy(id = "com.abp.sub:id/proceed_button")
    public WebElement btnCreate;

    @AndroidFindBy(id = "com.abp.sub:id/add_services")
    private List<WebElement> SplitBill;

    @AndroidFindBy(xpath = "//android.widget.FrameLayout[@index='0' and @clickable='true']")
    public WebElement SB;

    @AndroidFindBy(id = "com.abp.sub:id/lblListHeader")
    private List<WebElement> SplitBillMenu;

    @AndroidFindBy(id = "com.abp.sub:id/add_group_root_view")
    private WebElement addGroup;

    @AndroidFindBy(id = "com.abp.sub:id/group_name")
    private WebElement groupName;

    @AndroidFindBy(id = "com.abp.sub:id/mobile_email_edt")
    private WebElement mobileNumber;

    @AndroidFindBy(id = "com.abp.sub:id/name")
    private WebElement name;

    @AndroidFindBy(id = "com.abp.sub:id/sub_text")
    private WebElement message;

    @AndroidFindBy(id = "com.abp.sub:id/ok_button")
    private WebElement btnOk;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private List<WebElement> clickBack;

    @AndroidFindBy(id = "com.abp.sub:id/snackbar_text")
    private WebElement textMsg;

    @AndroidFindBy(id = "com.abp.sub:id/add_new_members")
    private List<WebElement> editGroup;

    @AndroidFindBy(id = "com.abp.sub:id/split_group_grid_view")
    private List<WebElement> splitGrid;

    @AndroidFindBy(id = "com.abp.sub:id/save_group")
    private WebElement saveGroup;

    @AndroidFindBy(id = "com.abp.sub:id/delete_group")
    private WebElement dltGroup;

    @AndroidFindBy(id = "com.abp.sub:id/group_name")
    private WebElement grpTxt;

    @AndroidFindBy(id = "com.abp.sub:id/desc_image")
    private List<WebElement> desc_image;

    @AndroidFindBy(id = "com.abp.sub:id/main_content")
    private List<WebElement> main_content;

    @AndroidFindBy(id = "com.abp.sub:id/name_edit")
    private WebElement nameEdit;

    @AndroidFindBy(id = "com.abp.sub:id/edit_button")
    private WebElement groupEditBtn;

    @AndroidFindBy(id = "com.abp.sub:id/delete_contact")
    private WebElement delContact;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement clickOK;

    @AndroidFindBy(id = "com.abp.sub:id/chipin_amount_edt_text")
    private WebElement amt;

    @AndroidFindBy(id = "com.abp.sub:id/request_money_button")
    private WebElement requestMoney;

    @AndroidFindBy(id = "com.abp.sub:id/svc_status")
    private List<WebElement> notificationStatus;

    @AndroidFindBy(id = "com.abp.sub:id/pending_request")
    private WebElement pendingRequest;

    @AndroidFindBy(id = "com.abp.sub:id/amount_edt_txt")
    private List<WebElement> field;

    @AndroidFindBy(id = "com.abp.sub:id/serviceNameId")
    private List<WebElement> tapOnRequest;

    @AndroidFindBy(id = "com.abp.sub:id/txn_message")
    private WebElement txnMsg;

    @AndroidFindBy(id = "com.abp.sub:id/Accept")
    private List<WebElement> clickAccept;

    @AndroidFindBy(id = "com.abp.sub:id/Decline")
    private List<WebElement> clickReject;

    @AndroidFindBy(id = "com.abp.sub:id/done_retry_button")
    private WebElement doneBtn;

    @AndroidFindBy(id = "com.abp.sub:id/showBalance")
    private WebElement balance;

    @AndroidFindBy(id = "com.abp.sub:id/svc_message")
    private List<WebElement> messageNotification;

    @AndroidFindBy(id = "com.abp.sub:id/serviceNameId")
    private List<WebElement> ReqMsg;

    @AndroidFindBy(id="com.abp.sub:id/txn_status")
    private  WebElement splitBillStatus;

    @AndroidFindBy(id = "com.abp.sub:id/TxnStatusMsg")
    private WebElement txnStatus;

    @AndroidFindBy(id = "com.abp.sub:id/home_button")
    private WebElement homeBtn;





    public SplitBillPagePalestine clickOnSplitBillMenu(int i)  {
        isElementNotPresent(SB);
        clickOnElement(SplitBill.get(i), "Click on split bill from menu");
        return this;
    }

    public boolean isSBpresent(){
        return driver.findElements(By.xpath("//android.widget.FrameLayout[@index='0' and @clickable='true']")).size()>0;
    }

    public Double checkBalance() {
        isElementNotPresent(desc_image.get(3));
        CommonUtils.pauseExecution(3);
        String balnce = balance.getText();
        System.out.println("BALANCE  :" + balnce);
        Double bal = Double.parseDouble(balnce.replaceAll("BD ", ""));
        return bal;
    }

    public SplitBillPagePalestine clickonAddGroup() {
        isElementNotPresent(addGroup);
        clickOnElement(addGroup, "Click on add group");
        return this;
    }


    public boolean isMenuButtonPresent(){
        return driver.findElements(By.id("com.abp.sub:id/menu_button")).size()>0;
    }

    public SplitBillPagePalestine enterGroupName(String grpName) {
        setText(groupName, grpName, "Enter group Name");
        return this;
    }

    public SplitBillPagePalestine enterMsisdn(String msisdn) {
        setText(mobileNumber, msisdn, "Enter Msisdn");
        return this;
    }

    public boolean isNameFieldPresent() {
        return driver.findElements(By.id("com.abp.sub:id/name_edit")).size() > 0;
    }

    public SplitBillPagePalestine clickOnPendingRequest() {
        clickOnElement(pendingRequest, "Click on Pending");
        return this;
    }

    public SplitBillPagePalestine enterName(String Fname) {
        if (isNameFieldPresent()) {
            setText(nameEdit, Fname, "Enter name");
        } else
            setText(name, Fname, "Enter name");

        return this;
    }

    public SplitBillPagePalestine clickAddMember() {
        clickOnElement(btnAdd, "Click on add member");
        return this;
    }

    public SplitBillPagePalestine clickOnCreate() {
        clickOnElement(btnCreate, "Click on Create");
        return this;
    }

    public boolean isSplitBillPresent() {
        return driver.findElements(By.id("com.abp.sub:id/add_services")).size() > 0;
    }

    public boolean isClickOnOkisDisplayed() {
        return driver.findElements(By.id("com.abp.sub:id/ok_button")).size() > 0;
    }

    public SplitBillPagePalestine clickOK() {
        clickOnElement(btnOk, "Click on OK");
        return this;
    }

    public SplitBillPagePalestine clickOnDone_Retry() {
        clickOnElement(doneBtn, "Click On done");
        return this;
    }

    public SplitBillPagePalestine enterAmt(String amount) {
        setText(amt, amount, "Enter amount");
        return this;
    }

    public String  getErrMsgFromDialogBox() {
       try {
           if (loginpage.isSnackbarDisplayed()) {
               Thread.sleep(2000);
               System.out.print(textMsg.getText());
               return textMsg.getText();
           } else {
               Thread.sleep(2000);
               System.out.print(message.getText());
               return message.getText();
           }
       }catch (Exception e) {
           e.printStackTrace();
       }
       return null;
       }


    public SplitBillPagePalestine clickBack() {
        clickOnElement(clickBack.get(0), "Click on Back");
        return this;
    }

    public boolean isCreateButtonPresent() {
        return driver.findElements(By.id("com.abp.sub:id/proceed_button")).size() > 0;
    }

    public SplitBillPagePalestine clickOnEdit() {
        isElementNotPresent(editGroup.get(0));
        clickOnElement(editGroup.get(0), "click on edit group");
        return this;
    }

   /* public WebElement clickOnGroupName(String groupText) {
        WebElement mobElement;
        try {
            mobElement = driver.findElement(By.xpath("//*[contains(text(),'" + groupText + "')]/../.."));

            System.out.println("");
        } catch (Exception e) {

            mobElement = driver.findElement(By.xpath("//*[contains(text(),'" + groupText + "')]/../.."));
        }
        return mobElement;
    }*/


    public SplitBillPagePalestine checkMethodAndClick(String method) {
       try{
           switch (method) {
               case "Modify":
                   if (Config.isDeleteMember) {
                       CommonUtils.pauseExecution(3);
                       clickOnElement(delContact, "Click on delete contact");
                       Config.isDeleteMember = false;
//                       Assertion.verifyEqual(loginpage.getMsgFromDialogBox(), MessageReader.getMessage("ERRMSG_0061"));
                       clickOnElement(clickOK, "Click on OK");
                   }
                   clickOnSave();
                   break;

               case "Add":
                   clickOnCreate();
                   break;

               case "Delete":
                   clickOnDelete();
                   break;

               default:
                   throw new UnsupportedOperationException(method + ":- This method is not supported");
           }
       }catch (Exception e){
           e.printStackTrace();
       }return this;
    }

    public void checkNotificationStatus(String status) {
        switch (status) {
            case Constants.ACCEPT:
                Assertion.verifyEqual(notificationStatus.get(0).getText(), MessageReader.getMessage("ERRMSG_0063"));
                break;

            case Constants.REJECT:
                Assertion.verifyEqual(notificationStatus.get(0).getText(), MessageReader.getMessage("ERRMSG_0064"));
                break;
            default:
                System.out.println("The request is pending");

        }
        clickBack();
    }

    public void fetchNotification(String bal, String Status) {
        clickOnElement(messageNotification.get(0), "Click on SMS");
        Assertion.verifyContains(bal.toString(), messageNotification.get(1).getText());
        checkNotificationStatus(Status);
    }


    public SplitBillPagePalestine clickOnSave() {
        clickOnElement(saveGroup, "Click on Save group");
        return this;
    }

    public SplitBillPagePalestine clickOnDelete() throws InterruptedException{
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        clickOnElement(dltGroup, "Click on delete group");
        clickOnElement(clickOK, "Click on OK");

        return this;
    }

    public String getTxnMsg() {
        System.out.print(txnMsg.getText());
        String txt=txnMsg.getText();
        clickOnDone_Retry();
        return txt;
    }

    private String toastMessage;
    public void getToast() throws InterruptedException, IOException {
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);

        if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0047"))) {
            Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0047"));
        } else if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0065"))) {
            Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0065"));
        }
    }

    public String clickOnRequest() {
        clickOnElement(tapOnRequest.get(0), "Click on the Split bill Request");

        return Utils.fetchDecimalNumber(tapOnRequest.get(0).getText());
    }

    public SplitBillPagePalestine clickOnApprove() {
        clickOnElement(clickAccept.get(0), "Click on accept");
        return this;
    }

    public SplitBillPagePalestine clickOnReject() {
        clickOnElement(clickReject.get(0), "Click on accept");
        return this;
    }


    public SplitBillPagePalestine selectGroup(int i) throws InterruptedException {
        int n=main_content.size();
        //n=n-1;
        isElementNotPresent(main_content.get(i));
        clickOnElement(main_content.get(i), "Clicking on Request money");
        return this;
    }

    public SplitBillPagePalestine selectGroup() throws InterruptedException {
        isElementNotPresent(main_content.get(1));
        clickOnElement(main_content.get(1), "Clicking on Request money");
        return this;
    }

    public SplitBillPagePalestine clickOnRequestMoney() throws InterruptedException {

        clickOnElement(requestMoney, "Click on request Money");
        Assertion.verifyEqual(splitBillStatus.getText(),MessageReader.getMessage("COVALMSG_002"));
        return this;
    }

    public  String fetchTxnStatus() {
        return txnStatus.getText();
    }

    public boolean isHomeBtnDisplayed() {
        return driver.findElements(By.id("com.abp.sub:id/home_button")).size() > 0;
    }

    public SplitBillPagePalestine clickOnHome() {
        clickOnElement(homeBtn, "Click on Home");
        return this;
    }






}
