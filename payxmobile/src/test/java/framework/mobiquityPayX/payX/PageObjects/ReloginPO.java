package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ReloginPO extends AppPageInit {
    public ReloginPO(){
        super();
    }

    @AndroidFindBy(xpath = "//android.widget.ImageView[@content-desc='More options']")
    public WebElement moreoptions;
//    @AndroidFindBy(xpath = "//*[@accessibilityID ='More options']")
//    public WebElement moreoptions;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/verifypin_pin_button")
    public WebElement loginBtn;

    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/forgot_pin_button")
    public WebElement forgotpin;

//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
//    public WebElement loginwithanoteraccountoption;
    @AndroidFindBy(xpath = "//*[contains(text()='Login with another account')]")
    public WebElement loginwithanoteraccountoption;

//    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.TextView")
//    public WebElement Registeroption;

//    @AndroidFindBy(xpath = "//com.comviva.mobiquity.consumer.debug:id/title[text()='Register']")
//    public WebElement Registeroption;
    @AndroidFindBy(id = "//com.comviva.mobiquity.consumer.debug:id/title")
    public WebElement Registeroption;
//    @AndroidFindBy(xpath = "//android.widget.TextView[text()='Register']")
//    public WebElement Registeroption;


    public ReloginPO reloginfromhome(){
        isElementNotPresent(loginBtn,40);
        System.out.println("Waiting for Home screen to be Displayed...");
        info("Waiting for Home screen to be Displayed...");
        clickOnElement(moreoptions,"clicking on moreoptions option from relogin screen");
        clickOnElement(Registeroption,"clicking on Register option from relogin screen");
        return this;
    }
}
