package framework.mobiquityPayX.DBXP.pageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class DBXPTransferPageObjects extends AppPageInit {

public DBXPTransferPageObjects(){

    super();
}

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/item1")
    private WebElement manageTransfer;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/toggle")
    private WebElement toggle;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/beneficiary")
    private WebElement beneficiary;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/aliasItemLayout")
    private WebElement thmobile;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/aliasItemLayout")
    private WebElement thBank;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/aliasItemLayout")
    private WebElement thalias;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/acc_holder_name")
    private WebElement acctname;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/account_no")
    private WebElement acctNo;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/re_enter_account_no")
    private WebElement reacctNo;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/ifsc")
    private WebElement iifsc;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/option_add_beneficiary")
    private WebElement addoption;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/submit")
    private WebElement submit;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/more")
    private WebElement more;

    @AndroidFindBy (xpath ="//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement backButton;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/custom_dialog_ok_buttonView")
    private WebElement okBtn;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/favourite")
    private WebElement markfav;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/multiCurrencyAmountEdittext")
    private WebElement amount;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/multiCurrencyImageView")
    private WebElement currencydrop;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/arrow")
    private WebElement bankdrop;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/errorText")
    private WebElement bankerr;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/make_it_recurring")
    private WebElement recurring;

    @AndroidFindBy (id =" com.comviva.dbxp.app:id/schedule")
    private WebElement schedule;

    @AndroidFindBy (id ="com.comviva.dbxp.app:id/transfer")
    private WebElement transfer;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/select_date")
    private WebElement selectDate;

    @AndroidFindBy (id = " com.comviva.dbxp.app:id/start_schedule")
    private WebElement startSchedule;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/from_date")
    private WebElement fromDate;

    @AndroidFindBy (id = " com.comviva.dbxp.app:id/to_date")
    private WebElement toDate;

    @AndroidFindBy (xpath = "//android.widget.EditText[@content-desc=\"Day\"]")
    private WebElement day;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/done")
    private WebElement done;

    @AndroidFindBy (id = " com.comviva.dbxp.app:id/cancel")
    private WebElement cancel;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/selection_layout")
    private WebElement DateSelect;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/etMobileNo")
    private WebElement etMobileNo;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/ivContactPicker")
    private WebElement contact;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/etUserName")
    private WebElement etUserName;

    @AndroidFindBy (id = "com.comviva.dbxp.app:id/aliasUserNameContinue")
    private WebElement continuealias;



    public DBXPTransferPageObjects setetUsername(String Usrname){
        isElementNotPresent(etUserName);
        setText(etUserName,Usrname,"Clicking on contacts");
        return this;
    }

    public DBXPTransferPageObjects clickOncontact(){
        isElementNotPresent(contact);
        clickOnElement(contact,"Clicking on contacts");
        return this;
    }

    public DBXPTransferPageObjects setMobileNum(String mobileNo){
        isElementNotPresent(etMobileNo);
        setText(etMobileNo,mobileNo,"Clicking on MObile Number");
        return this;
    }

    public DBXPTransferPageObjects clickOnDateSelect(){
        isElementNotPresent(DateSelect);
        clickOnElement(DateSelect,"Clicking on date Select for recurring");
        return this;
    }

    public DBXPTransferPageObjects clickOnDone(){
        isElementNotPresent(done);
        clickOnElement(done,"Clicking on done for recurring");
        return this;
    }

    public DBXPTransferPageObjects clickOnCancel(){
        isElementNotPresent(cancel);
        clickOnElement(cancel,"Clicking on cancel for recurring");
        return this;
    }


    public DBXPTransferPageObjects clickOnSelectDate(){
        isElementNotPresent(selectDate);
        clickOnElement(selectDate,"Clicking on Select Date for recurring");
        return this;
    }

    public DBXPTransferPageObjects clickOnStartSchedule(){
        isElementNotPresent(startSchedule);
        clickOnElement(startSchedule,"Clicking on start Schedule");
        return this;
    }

    public DBXPTransferPageObjects clickOnFromDate(String fdate ){
        setText(fromDate,fdate,"Entering the start Date");
        return this;
    }

    public DBXPTransferPageObjects clickOnToDate(String tdate ){
        setText(toDate,tdate,"Entering the end Date");
        return this;
    }

    public DBXPTransferPageObjects clickOnday(String Day ){
        setText(day,Day,"Entering the day");
        return this;
    }


    public DBXPTransferPageObjects clickonrecurring(){
        isElementNotPresent(recurring);
        clickOnElement(recurring,"Cliking on mark it as recurring");
        return this;
    }

    public DBXPTransferPageObjects clickonschedule(){
        isElementNotPresent(schedule);
        clickOnElement(schedule,"Cliking on set schedule");
        return this;
    }

    public DBXPTransferPageObjects clickontransfer(){
        isElementNotPresent(transfer);
        clickOnElement(transfer,"Cliking on transfer");
        return this;
    }

    public DBXPTransferPageObjects clickoncurrencyD(){
        isElementNotPresent(currencydrop);
        clickOnElement(currencydrop,"Cliking on choose currency");
        return this;
    }

    public DBXPTransferPageObjects clickonbankD(){
        isElementNotPresent(bankdrop);
        clickOnElement(bankdrop,"Cliking on bank account dropdown");
        return this;
    }

    public DBXPTransferPageObjects clickonfav(){
        isElementNotPresent(markfav);
        clickOnElement(markfav,"Cliking on mark as favourite transaction");
        return this;
    }

    public DBXPTransferPageObjects clickonManagetrf(){
        isElementNotPresent(manageTransfer);
        clickOnElement(manageTransfer,"Cliking on manage Transfer");
        return this;
    }

    public DBXPTransferPageObjects clickontoggle(){
        isElementNotPresent(toggle);
        clickOnElement(toggle,"Cliking on toggle recents");
        clickOnElement(toggle,"");
        return this;
    }

    public DBXPTransferPageObjects beneficiaryName(String BenefName){
        setText(beneficiary,BenefName,"Entering the name of Beneficiary");
        return this;
    }

    public DBXPTransferPageObjects addName(String name){
        setText(acctname,name,"Entering Account holder name");
        return this;
    }

    public DBXPTransferPageObjects addacct(String acct){
        setText(acctNo,acct,"Entering Account holder name");
        return this;
    }

    public DBXPTransferPageObjects addreacct(String reacct){
        setText(reacctNo,reacct,"Entering Account holder name");
        return this;
    }

    public DBXPTransferPageObjects addifsc(String ifsc){
        setText(iifsc,ifsc,"Entering Account holder name");
        return this;
    }

    public DBXPTransferPageObjects clickOnContinue(){
        clickOnElement(submit,"Submitting ");
        return this;
    }









}
