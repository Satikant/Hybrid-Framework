package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class payXSecurityQuestionPageObjects extends AppPageInit {

    public payXSecurityQuestionPageObjects(){
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

    @AndroidFindBy(xpath ="//*[@text='Answer']")
    public WebElement answer1 ;

    @AndroidFindBy(xpath ="//*[@content-desc='Dropdown1']")
    public WebElement question2 ;

    @AndroidFindBy(xpath ="//*[@text='QUESTION 2']")
    public WebElement question2text ;

    @AndroidFindBy(xpath ="//*[@text='Answer']")
    public WebElement answer2 ;

    @AndroidFindBy(xpath ="//*[@resource-id='com.comviva.mobiquity.consumer.debug:id/choosequestion_title_image']")
    public WebElement cancelQues ;

    @AndroidFindBy(id = "setSecurityBackIcon")
    public WebElement backbtn ;

    @AndroidFindBy(xpath = "//*[@text='Save']")
    public WebElement save ;

    @AndroidFindBy(id = "toast_id")
    public WebElement successfultoast ;
    @AndroidFindBy(xpath = "//*[@text='Security questions']")
    public WebElement secQus;


    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public WebElement logout;

    @AndroidFindBy(xpath = "//*[@text='Are you sure you want to logout?']")
    public WebElement confirnlogout;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    public WebElement login;

    @AndroidFindBy(xpath = "//*[@text='Welcome Subscriber']")
    public WebElement welcome;



    public payXSecurityQuestionPageObjects enteringSecurityPage(){
        isElementNotPresent(hamburger);
        clickOnElement(hamburger,"Clicked on hamburger button");
        isElementNotPresent(settings);
        clickOnElement(settings,"Clicked on Settings button");
        isElementNotPresent(security);
        clickOnElement(security,"Clicked on Security button");
        isElementNotPresent(secQustion);
        clickOnElement(secQustion,"Clicked on changePIN button");
        return this;
    }

    public payXSecurityQuestionPageObjects pinverify(String pin){
        isElementNotPresent(pinbutton);
        clickOnElement(pinbutton,"Pin verification field");
        setText(pinbutton,pin,"Entered the Pin");
        isElementNotPresent(verify);
        clickOnElement(verify,"Pin verified");
        return this;
    }

    public payXSecurityQuestionPageObjects setSequrityQus(String Answer1, String Answer2) throws InterruptedException {
        isElementNotPresent(edit);
        clickOnElement(edit,"Clicked on edit button for SecurityQus");
        isElementNotPresent(answer1);
        clickOnElement(answer1,"Clicked on answer1 field");
        setText(answer1,Answer1,"Entered answer1");
        isElementNotPresent(question2text);
        clickOnElement(question2text,"");
        clickOnElement(answer2,"Clicked on answer1 field");
        setText(answer2,Answer2,"Entered answer2");
        Thread.sleep(1000);
        driver.navigate().back();
        isElementNotPresent(save);
        clickOnElement(save,"save the security question");
//        isElementNotPresent(edit);
//        clickOnElement(backbtn,"Back to Security");
//        Thread.sleep(1000);
//        clickOnElement(hamburger,"Back to Settings");
//        Thread.sleep(1000);
//        clickOnElement(hamburger,"Back to Home Page");
//        isElementNotPresent(welcome);
        return this;
    }

    public boolean isAnswersetsuccesspresent(){
        isElementNotPresent(secQus);
        return driver.findElements(By.xpath("//*[@text='Security questions']")).size() > 0;
    }

    public String isAnswersetsuccessful(){
        isElementNotPresent(secQus);
        String message= secQus.getText();
        System.out.println("Message  "+message);
        return message;
    }
    public payXSecurityQuestionPageObjects logout() {

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
