package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.util.List;

public class payXSecurityQuesSelectPageObjects extends AppPageInit {

    public payXSecurityQuesSelectPageObjects(){
        super();
    }

    @AndroidFindBy(id = "toolbar_icon")
    public WebElement hamburger ;

    @AndroidFindBy(xpath = "//*[@text='Settings']")
    public WebElement settings ;

    @AndroidFindBy(xpath = "//*[@text='Security']")
    public WebElement security ;

    @AndroidFindBy(xpath = "//*[@text='Security questions']")
    public WebElement secQustion ;

    @AndroidFindBy(id = "otp_edit_text")
    public WebElement pinbutton ;

    @AndroidFindBy(xpath = "//*[@text='Verify']")
    public WebElement verify ;

    @AndroidFindBy(xpath = "//*[@text='Edit']")
    public WebElement edit ;

    @AndroidFindBy(xpath ="//*[@content-desc='Dropdown0']")
    public WebElement dropdown1 ;

    @AndroidFindBy(xpath ="//*[@content-desc='Dropdown1']")
    public WebElement dropdown2 ;

   @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Dropdown0']/android.widget.TextView")
   public WebElement qusname1 ;

    @AndroidFindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Dropdown1']/android.widget.TextView")
    public WebElement qusname2 ;

    @AndroidFindBy(xpath = "//*[@text='Save']")
    public WebElement save ;

    @AndroidFindBy(id ="choosequestion_title_image")
    public WebElement cancelQues ;

    @AndroidFindBy(xpath = "//*[@text='Edit questions']")
    public WebElement editQuestion;

    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public WebElement logout;

    @AndroidFindBy(xpath = "//*[@text='Are you sure you want to logout?']")
    public WebElement confirnlogout;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    public WebElement login;

    @AndroidFindBy(xpath = "//*[@text='Welcome Subscriber']")
    public WebElement welcome;

    @AndroidFindBy(id = "setSecurityBackIcon")
    public WebElement backbtn ;

//    @AndroidFindBy(className = "android.widget.RelativeLayout")
//    public WebElements selectQuestion ;
    @AndroidFindBy(className = "android.widget.TextView")
    public List<WebElement> selectQuestion;
//    List<WebElement> selectQuestion= dropdown1.getOptions();


    public payXSecurityQuesSelectPageObjects enteringSecurityPage(){
        isElementNotPresent(hamburger);
        clickOnElement(hamburger,"clicked on hamburger button");
        isElementNotPresent(settings);
        clickOnElement(settings,"clicked on Settings button");
        isElementNotPresent(security);
        clickOnElement(security,"clicked on Security button");
        isElementNotPresent(secQustion);
        clickOnElement(secQustion,"clicked on changePIN button");
        return this;
    }

    public payXSecurityQuesSelectPageObjects pinverify(String pin){
        isElementNotPresent(pinbutton);
        clickOnElement(pinbutton,"pin verification field");
        setText(pinbutton,pin,"Entering the Pin");
        isElementNotPresent(verify);
        clickOnElement(verify,"verify pin");
        return this;
    }

    public payXSecurityQuesSelectPageObjects selectQuestion() throws InterruptedException {
        isElementNotPresent(edit);
        clickOnElement(edit, "Edit button for SecurityQus");
        isElementNotPresent(dropdown1);
        String qus1 = qusname1.getText();
        System.out.println("qus1......." + qus1);
        clickOnElement(dropdown1, "Select Security Question1");
        for (int j = 2; j < selectQuestion.size(); j++) {
//            System.out.println("Size.................."+selectQuestion.size());
            System.out.println("Name..................." + selectQuestion.get(j).getText());
            if (selectQuestion.get(j).getText() != (qus1)) {
                Thread.sleep(2000);
                selectQuestion.get(j).click();
                break;
            }
        }
        Thread.sleep(4000);
        isElementNotPresent(dropdown2);
        String qus2= qusname2.getText();
        System.out.println("qus2......."+qus2);
        clickOnElement(dropdown2, "Select Security Question2");
        for (int j = 3; j < selectQuestion.size(); j++) {
//            System.out.println("Size.................."+selectQuestion.size());
            System.out.println("Name..................."+selectQuestion.get(j).getText());
            if (selectQuestion.get(j).getText()!=(qus2)) {
                Thread.sleep(2000);
                selectQuestion.get(j).click();
                break;
            }
        }
//        isElementNotPresent(cancelQues);
//        clickOnElement(cancelQues,"");
     return this;
    }
    public payXSecurityQuesSelectPageObjects backToDashboard() throws InterruptedException {

//        isElementNotPresent(cancelQues);
//        clickOnElement(cancelQues,"");
        Utils.putThreadSleep(2000);
        isElementNotPresent(editQuestion);
        clickOnElement(hamburger, "Back to to Security question Page");
        Utils.putThreadSleep(1000);
        clickOnElement(backbtn, "Back to Security Page");
        Utils.putThreadSleep(1000);
        clickOnElement(hamburger, "Back to Settings");
        Utils.putThreadSleep(1000);
        clickOnElement(hamburger, "Back to Home Page");
        isElementNotPresent(welcome);
        return this;

    }

    public boolean  isSecQusSlt() {

        Utils.putThreadSleep(2000);
        isElementNotPresent(save);
        return save.isEnabled();
    }

    public String  verifySecQus() throws InterruptedException {

        Utils.putThreadSleep(2000);
        isElementNotPresent(save);
        String message = save.getText();
        return message;
    }

    public payXSecurityQuesSelectPageObjects logout() {

        isElementNotPresent(hamburger);
        clickOnElement(hamburger,"Clicked on hamburger menu");
        isElementNotPresent(logout);
        clickOnElement(logout,"Clicked on logout");
        isElementNotPresent(confirnlogout);
        clickOnElement(logout,"Logout Successfully");
        isElementNotPresent(login);
        return this;
    }



}
