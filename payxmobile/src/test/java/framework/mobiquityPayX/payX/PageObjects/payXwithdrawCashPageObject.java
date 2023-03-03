package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
//import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utils.Utils;

import java.time.Duration;
import java.util.List;

public class payXwithdrawCashPageObject extends AppPageInit {

    public payXwithdrawCashPageObject(){
        super();
    }

    @AndroidFindBy(id = "toolbar_icon")
    public WebElement hamburger ;
    @AndroidFindBy(xpath = "//*[@text='Withdraw cash']")
    public WebElement withdrawCash ;

//    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/layout")
//    public WebElement extra;


    ////*[@bounds='[38,498][188,648]']
    @AndroidFindBy(xpath = "//*[@bounds='[42,398][207,563]']")
    public WebElement extra;

//    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/cashoutagentContactLayout")
//    public WebElement mobNo ;

    @AndroidFindBy(xpath = "//*[@text='Mobile number / Receiver code']")
    public WebElement mobNo ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/textinput_placeholder")
    public WebElement mobNoInput ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/textinput_placeholder")
    public WebElement input ;

    @AndroidFindBy(xpath = "//*[@text='Merchant']")
    public WebElement merchant ;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    public WebElement next ;

    @AndroidFindBy(xpath = "//*[@text='Transfer now']")
    public WebElement transfer ;

    @AndroidFindBy(xpath = "//*[@content-desc='cashoutAgentAmount']")
    public WebElement amount ;

    @AndroidFindBy(id = "otp_edit_text")
    public WebElement pinbutton ;

    @AndroidFindBy(xpath = "//*[@text='Verify']")
    public WebElement verify ;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/transactionstatus_status_text")
    public WebElement confirm ;

    @AndroidFindBy(xpath = "//*[@text='Make another withdrawal']")
    public WebElement anotherwithdraw ;

    @AndroidFindBy(xpath = "//*[@text='Logout']")
    public WebElement logout;

    @AndroidFindBy(xpath = "//*[@text='Are you sure you want to logout?']")
    public WebElement confirnlogout;

    @AndroidFindBy(xpath = "//*[@text='Login']")
    public WebElement login;

    @AndroidFindBy(xpath = "//*[@text='Welcome Subscriber']")
    public WebElement welcome;


    public payXwithdrawCashPageObject withdraw(String MobNo,String Amount) throws InterruptedException {
        Utils.putThreadSleep(2000);
        isElementNotPresent(withdrawCash);
        clickOnElement(withdrawCash,"clicked on WithdrawCash button");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));

        Utils.putThreadSleep(5000);


/*        try
        {
            if(isElementNotPresent(extra));
            clickOnElement(extra,"clicked on Extra button");
            Utils.putThreadSleep(2000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }*/
        isElementNotPresent(mobNo);
        clickOnElement(mobNo,"clicked on MobileNo field");
        Utils.putThreadSleep(1000);
        isElementNotPresent(mobNoInput);
        setText(mobNo,MobNo,"Entered User Mobile no");
        driver.navigate().back();
        isElementNotPresent(next);
        clickOnElement(next,"clicked on next");
        isElementNotPresent(amount);
        setText(amount,Amount,"Entered Amount to transfer");
        isElementNotPresent(next);
        clickOnElement(next,"clicked on next");
        clickOnElement(transfer,"clicked on transfer");
        isElementNotPresent(verify);
        return this;
    }

    public payXwithdrawCashPageObject pinverify(String pin){
        isElementNotPresent(pinbutton);
        clickOnElement(pinbutton,"pin verification field");
        setText(pinbutton,pin,"Entering the Pin");
        isElementNotPresent(verify);
        clickOnElement(verify,"verify pin");
        Utils.putThreadSleep(2000);
        return this;
    }

    public boolean ispaymentpresent(){
        isElementNotPresent(confirm);
        return driver.findElements(By.id("com.comviva.mobiquity.consumer.debug:id/transactionstatus_status_text")).size() > 0;
    }
    public String ispaymentsuccessful(){
        isElementNotPresent(confirm);
        String message= confirm.getText();
        System.out.println("Message  "+message);
        return message;
    }

    public payXwithdrawCashPageObject backtologout() throws InterruptedException {
        Utils.putThreadSleep(2000);
        Utils.scrollDown();
        isElementNotPresent(anotherwithdraw);
        clickOnElement(anotherwithdraw, "Clicked on anotherwithdrawl");
        isElementNotPresent(hamburger);
        clickOnElement(hamburger,"Back to Home Page");
        isElementNotPresent(welcome);
        return this;
    }

    public  payXwithdrawCashPageObject logout() {

        isElementNotPresent(hamburger);
        clickOnElement(hamburger,"Clicked on Hamburger");
        isElementNotPresent(logout);
        clickOnElement(logout,"clicked on logout");
        isElementNotPresent(confirnlogout);
        clickOnElement(logout,"Asking for confirmation");
        isElementNotPresent(login);
        return this;
    }
}
