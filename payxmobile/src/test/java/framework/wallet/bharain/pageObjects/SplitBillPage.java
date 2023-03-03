package framework.wallet.bharain.pageObjects;

import com.aventstack.extentreports.ExtentTest;
import common.Assertion;
import framework.wallet.bankMuscat.pageObjects.ProfileDetailsPage;
import globalConstants.Config;
import globalConstants.Constants;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import reportManagement.ExtentManager;
import utils.CommonUtils;
import utils.MessageReader;
import utils.Utils;
import utils.W3CActions;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;


public class SplitBillPage extends AppPageInit {

    public SplitBillPage() {
        super();
    }

    ProfileDetailsPage profileDetailsPage = new ProfileDetailsPage();
    ExtentTest testCase = ExtentManager.getTest();
    LoginPageBharain loginPage = new LoginPageBharain();
    private String toastMessage;


    @AndroidFindBy(id = "com.batelco.sub:id/members_add")
    public WebElement btnAdd;

    @AndroidFindBy(id = "com.batelco.sub:id/TxnStatusMsg")
    private WebElement txnStatus;

    @AndroidFindBy(id = "com.batelco.sub:id/proceed_button")
    public WebElement btnCreate;

    @AndroidFindBy(id = "com.batelco.sub:id/add_services")
    private List<WebElement> SplitBillMenu;

    @AndroidFindBy(id = "com.batelco.sub:id/add_group_root_view")
    private WebElement addGroup;

    @AndroidFindBy(id = "com.batelco.sub:id/group_name")
    private WebElement groupName;

    @AndroidFindBy(id = "com.batelco.sub:id/mobile_email_edt")
    private WebElement mobileNumber;

    @AndroidFindBy(id="com.batelco.sub:id/top_layout")
    private WebElement totalGrpMember;

    @AndroidFindBy(id = "com.batelco.sub:id/name")
    private WebElement name;

    @AndroidFindBy(id = "com.batelco.sub:id/sub_text")
    private WebElement message;

    @AndroidFindBy(id = "com.batelco.sub:id/ok_button")
    private WebElement btnOk;

    @AndroidFindBy(className = "android.widget.ImageButton")
    private List<WebElement> clickBack;

    @AndroidFindBy(id = "com.batelco.sub:id/snackbar_text")
    private WebElement textMsg;

    @AndroidFindBy(id = "com.batelco.sub:id/add_new_members")
    private List<WebElement> editGroup;

    @AndroidFindBy(id = "com.batelco.sub:id/showBalance")
    private WebElement showBalance;

    @AndroidFindBy(id = "com.batelco.sub:id/save_group")
    private WebElement saveGroup;

    @AndroidFindBy(id = "com.batelco.sub:id/delete_group")
    private WebElement dltGroup;

    @AndroidFindBy(id = "com.batelco.sub:id/group_name")
    private WebElement grpTxt;

    @AndroidFindBy(id = "com.batelco.sub:id/desc_image")
    private List<WebElement> desc_image;

    @AndroidFindBy(id = "com.batelco.sub:id/main_content")
    private List<WebElement> main_content;

    @AndroidFindBy(id = "com.batelco.sub:id/name_edit")
    private WebElement nameEdit;

    @AndroidFindBy(id = "com.batelco.sub:id/delete_contact")
    private WebElement delContact;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement clickOK;

    @AndroidFindBy(id = "com.batelco.sub:id/chipin_amount_edt_text")
    private WebElement amt;

    @AndroidFindBy(id = "com.batelco.sub:id/request_money_button")
    private WebElement requestMoney;

    @AndroidFindBy(id = "com.batelco.sub:id/svc_status")
    private List<WebElement> notificationStatus;

    @AndroidFindBy(id = "com.batelco.sub:id/pending_request")
    private WebElement pendingRequest;

    @AndroidFindBy(id = "com.batelco.sub:id/amount_edt_txt")
    private List<WebElement> field;

    @AndroidFindBy(id = "com.batelco.sub:id/serviceNameId")
    private List<WebElement> tapOnRequest;

    @AndroidFindBy(id = "com.batelco.sub:id/txn_message")
    private WebElement txnMsg;

    @AndroidFindBy(id = "com.batelco.sub:id/Accept")
    private List<WebElement> clickAccpet;

    @AndroidFindBy(id = "com.batelco.sub:id/Decline")
    private List<WebElement> clickReject;

    @AndroidFindBy(id = "com.batelco.sub:id/done_retry_button")
    private WebElement doneBtn;

    @AndroidFindBy(id = "com.batelco.sub:id/showBalance")
    private WebElement balance;

    @AndroidFindBy(id = "com.batelco.sub:id/svc_message")
    private List<WebElement> messageNotification;

    @AndroidFindBy(id = "com.batelco.sub:id/serviceNameId")
    private List<WebElement> ReqMsg;

    @AndroidFindBy(id="com.batelco.sub:id/txn_status")
    private  WebElement splitBillStatus;



    public SplitBillPage clickOnSplitBillMenu() throws InterruptedException {
        CommonUtils.pauseExecution(2);
    Utils.scrollToRightOfActivityPage();

        clickOnElement(SplitBillMenu.get(1), "Click on split bill from menu");
       // Config.isFirstTimeLogin = true;
        return this;
    }

    public boolean isShowBalanceDisplayed() {
        return driver.findElements(By.id("showBalance")).size() > 0;
    }


    public Double checkBalance() {
        isElementNotPresent(desc_image.get(3));
        CommonUtils.pauseExecution(3);
        String balnce = balance.getText();
        System.out.println("BALANCE  :" + balnce);
        Double bal = Double.parseDouble(balnce.replaceAll("BD ", ""));
        return bal;
    }

    public SplitBillPage clickonAddGroup() {
        isElementNotPresent(addGroup);
        clickOnElement(addGroup, "Click on add group");
        return this;
    }

    public boolean isMenuButtonPresent(){
        return driver.findElements(By.id("com.batelco.sub:id/menu_button")).size()>0;
    }

    public SplitBillPage enterGroupName(String grpName) {
        setText(groupName, grpName, "Enter group Name");
        return this;
    }

    public SplitBillPage enterMsisdn(String msisdn) {
        setText(mobileNumber, msisdn, "Enter Msisdn");
        return this;
    }

    public boolean isNameFieldPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/name_edit")).size() > 0;
    }

    public SplitBillPage clickOnPendingRequest() {
        clickOnElement(pendingRequest, "Click on Pending");
        return this;
    }

    public SplitBillPage enterName(String Fname) {
        if (isNameFieldPresent()) {
            setText(nameEdit, Fname, "Enter name");
        } else
            setText(name, Fname, "Enter name");

        return this;
    }

    public SplitBillPage clickAddMember() {
        clickOnElement(btnAdd, "Click on add member");
        return this;
    }

    public SplitBillPage clickOnCreate() throws InterruptedException {
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        clickOnElement(btnCreate, "Click on Create");
        return this;
    }

    public boolean isSplitBillPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/add_services")).size() > 0;
    }

    public boolean isClickOnOkisDisplayed() {
        return driver.findElements(By.id("com.batelco.sub:id/ok_button")).size() > 0;
    }

    public SplitBillPage clickOK() {
        clickOnElement(btnOk, "Click on OK");
        return this;
    }

    public SplitBillPage clickBtnOk(){
        clickOnElement(clickOK,"Click on Ok");
        return this;
    }

    public SplitBillPage clickOnDone_Retry() {
        clickOnElement(doneBtn, "Click On done");
        return this;
    }

    public SplitBillPage enterAmt(String amount) {
        setText(amt, amount, "Enter amount");
        return this;
    }

    public String getErrMsgFromDialogBox() throws InterruptedException {
        if (loginPage.isSnackbarDisplayed()) {
            Thread.sleep(2000);
            System.out.print(textMsg.getText());
            return textMsg.getText();
        } else {
            Thread.sleep(2000);
            System.out.print(message.getText());
            return message.getText();
        }
    }

    public SplitBillPage clickBack() {
        clickOnElement(clickBack.get(0), "Click on Back");
        return this;
    }

    public boolean isCreateButtonPresent() {
        return driver.findElements(By.id("com.batelco.sub:id/proceed_button")).size() > 0;
    }

    public SplitBillPage clickOnEdit() {
        isElementNotPresent(editGroup.get(0));
        clickOnElement(editGroup.get(0), "click on edit group");
        return this;
    }

    public WebElement clickOnGroupName(String groupText) {
        WebElement mobElement;
        try {
            mobElement = driver.findElement(By.xpath("//*[contains(text(),'" + groupText + "')]/../.."));

            System.out.println("");
        } catch (Exception e) {

            mobElement = driver.findElement(By.xpath("//*[contains(text(),'" + groupText + "')]/../.."));
        }
        return mobElement;
    }

    public SplitBillPage clickOnSave() throws InterruptedException {
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        clickOnElement(saveGroup, "Click on Save group");
        return this;
    }

    public SplitBillPage clickOnDelete() {
        clickOnElement(dltGroup, "Click on delete group");
        return this;
    }

    public String getTxnMsg() {
        System.out.print(txnMsg.getText());
        String txt=txnMsg.getText();
        clickOnDone_Retry();
        return txt;
    }

    public SplitBillPage clickOnDeleteContact(){
        System.out.println("Testing");
if(Config.isOneMemberPresent==true){
    int n= driver.findElements(By.id("com.batelco.sub:id/top_layout")).size();
    System.out.println("In the method");
    for (int i=n-1;i>=1;i--){
        System.out.println("IN the loop\n"+i);
        clickOnElement(delContact,"Click on delete contact");
        clickOnElement(clickOK,"Click on Okay");
    }
    Config.isOneMemberPresent=false;
    Config.isDeleteMember=false;
}else {
    clickOnElement(delContact,"Click on delete contact");
    clickOnElement(clickOK,"Click on Okay");
}
        return this;
    }

    public void fetchNotification(String bal, String Status) {
        clickOnElement(messageNotification.get(0), "Click on SMS");
        Assertion.verifyContains(bal.toString(), messageNotification.get(1).getText());
checkNotificationStatus(Status);
    }

    public void checkNotificationStatus(String status) {
        switch (status) {
            case Constants.ACCEPT:
                Assertion.verifyEqual(notificationStatus.get(0).getText(), MessageReader.getMessage("ERRMSG_0065"));
                break;

            case Constants.REJECT:
                Assertion.verifyEqual(notificationStatus.get(0).getText(), MessageReader.getMessage("ERRMSG_0066"));
                break;
            default:
                System.out.println("The request is pending");

        }
        clickBack();
    }

    public String clickOnRequest() {
        clickOnElement(tapOnRequest.get(0), "Click on the Split bill Request");

        return Utils.fetchDecimalNumber(tapOnRequest.get(0).getText());
    }

    public SplitBillPage clickOnApprove() {
        clickOnElement(clickAccpet.get(0), "Click on accept");
        return this;
    }

    public SplitBillPage clickOnReject() {
        clickOnElement(clickReject.get(0), "Click on accept");
        return this;
    }

    public void getToast() throws InterruptedException, IOException {
        toastMessage = Utils.getToastMessage();
        System.out.println(toastMessage);

        if (toastMessage.contains(MessageReader.getMessage("ERRMSG_0049"))) {
            Assertion.verifyContains(toastMessage, MessageReader.getMessage("ERRMSG_0049"));
        }
    }

    public Boolean isGroupPresent() throws InterruptedException {
        return driver.findElements(By.id("com.batelco.sub:id/main_content")).size()>0;
    }

    public SplitBillPage selectGroup() throws InterruptedException {
        clickOnElement(main_content.get(2), "Clicking on Request money");
        return this;
    }

    public SplitBillPage clickOnRequestMoney() throws InterruptedException {

        clickOnElement(requestMoney, "Click on request Money");
Assertion.verifyEqual(splitBillStatus.getText(),MessageReader.getMessage("ERRMSG_0067"));
        return this;
    }

    public String fetchTxnStatus() {
        return txnStatus.getText();
    }

    public double[] checkAmtIsEqual() throws InterruptedException {
        W3CActions w3CActions = new W3CActions();
        w3CActions.scrollDown();
        int i, j = 0;
        int b[] = new int[10];
        double a[] = new double[15];
        double total = 0.000;
        int n = driver.findElements(By.id("com.batelco.sub:id/amount_edt_txt")).size();
        for (i = 0; i < n; i++) {
            double t = Double.parseDouble(field.get(i).getText());
            System.out.print(t);
            a[i] = Math.round(t * 100) / 100.00;
            System.out.println(a[i]);
            total = total + t;
        }
        for (i = 0; i < n - 1; i++) {
            if (a[i] != a[i + 1]) {
                testCase.fail("Amount not distributed equally");
                break;

            }
        }
        ;
        double str[] = {total, a[1]};
        return str;
    }

}