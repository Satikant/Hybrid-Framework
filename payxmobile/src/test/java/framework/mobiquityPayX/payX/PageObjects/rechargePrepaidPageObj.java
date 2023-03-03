package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonUtils;
import utils.Utils;

import javax.rmi.CORBA.Util;

public class rechargePrepaidPageObj extends AppPageInit {


    public rechargePrepaidPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@bounds='[42,398][207,563]']")
    private WebElement swapIcon;

    @AndroidFindBy(id = "moreIconId")
    private WebElement moreIconBtn;

    @AndroidFindBy(xpath = "//*[@text='Mobile number']")
    private WebElement mobileField;

    @AndroidFindBy(xpath = "//*[@text='Choose operator']")
    private WebElement operatorField;

    @AndroidFindBy(xpath = "//*[@text='Next']")
    private WebElement nextBtn;



    public boolean isSwapIconPresent(){
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@bounds='[42,398][207,563]']")).size() > 0;
    }


    public rechargePrepaidPageObj clickOnSwapIcon()
    {
        Utils.putThreadSleep(3000);
        clickOnElement(swapIcon, "click on swap icon");
        return this;
    }


    public rechargePrepaidPageObj clickOnMobileField(){
        isElementNotPresent(mobileField);
        clickOnElement(mobileField,"Click on Mobile Operator");
        return this;
    }


    public rechargePrepaidPageObj setMobileNumber(String msisdn)
    {
        isElementNotPresent(mobileField);
        setText(mobileField, msisdn,"Enter the mobile number");
        return this;
    }

    public rechargePrepaidPageObj clickOnMobileOper(){
        clickOnElement(operatorField,"Click on Mobile Operator");
        return this;
    }

    public rechargePrepaidPageObj clickOnNext(){
        isElementNotPresent(nextBtn);
        clickOnElement(nextBtn,"Click on next button");
        return this;
    }



}
