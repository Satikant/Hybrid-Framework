package framework.wallet.bharain.pageObjects;

import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

/**
 * Created by ayush.singh on 06-01-2020.
 */
public class PremiumSubscriptionPage extends AppPageInit {
    @AndroidFindBy(id = "com.batelco.sub:id/chTerm")
    private WebElement chTerm;

    @AndroidFindBy(id = "com.batelco.sub:id/btBD")
    private WebElement btBD;

    @AndroidFindBy(id = "com.batelco.sub:id/liPay")
    private WebElement liPay;

    @AndroidFindBy(id = "com.batelco.sub:id/btPay")
    private WebElement btPay;

    @AndroidFindBy(id = "com.batelco.sub:id/tv1")
    private WebElement tv1;


    @AndroidFindBy(id = "com.batelco.sub:id/imHome")
    private static WebElement imHome;

    @AndroidFindBy(id = "com.batelco.sub:id/liUpgrade")
    private WebElement liUpgrade;


    @AndroidFindBy(id = "com.batelco.sub:id/pending_notification")
    private  WebElement pending_notification;

    @AndroidFindBy(id = "com.batelco.sub:id/serviceNameId")
    private  WebElement serviceNameId;

    @AndroidFindBy(id = "com.batelco.sub:id/svc_status")
    private  WebElement svc_status;

    @AndroidFindBy(className = "android.widget.ImageButton")
    public List<WebElement> Navigate;

    @AndroidFindBy(id = "com.batelco.sub:id/text")
    private  WebElement checkboxalert;

    @AndroidFindBy(id = "com.batelco.sub:id/ok_button")
    private  WebElement ok_button;

    @AndroidFindBy(id = "com.batelco.sub:id/img_star")
    private  WebElement img_star;

    @AndroidFindBy(id = "com.batelco.sub:id/star_type")
    private  WebElement star_type;

    @AndroidFindBy(id = "com.batelco.sub:id/lblListHeader")
    public List<WebElement> element4;

    public PremiumSubscriptionPage clickOnNotification()  {
        clickOnElement(element4.get(1),"Notification");
        return this;
    }


    public  Boolean isBalanceDisplayed() throws InterruptedException {
        info("Balance Displayed");
        return driver.findElements(By.id("showBalance")).size()>0;
    }

    public PremiumSubscriptionPage isPremiumDisplayed() throws InterruptedException {
         if(driver.findElements(By.id("img_star")).size()>0){
                 pageInfo.pass("You are a Prime Member Now");
             }
        else{
                 pageInfo.fail("You are a Prime Member Now");
             }
             return this;
    }



    public PremiumSubscriptionPage clickOnBackBtn()  {
        clickOnElement(Navigate.get(0),"Back button");
        return this;
    }

    public String getHeaderMsgFromNotification(){
        isElementNotPresent(serviceNameId);
        System.out.print(serviceNameId.getText());
        return serviceNameId.getText();
    }

    public String getTxnStatusFromNotification(){
        isElementNotPresent(svc_status);
        System.out.print(svc_status.getText());
        return svc_status.getText();
    }

    public String getCheckBoxAlertMessage(){
        isElementNotPresent(checkboxalert);
        return checkboxalert.getText();
    }


/*
    public PremiumSubscriptionPage clickOnNotification() throws JSchException {
        isElementNotPresent(pending_notification);
        clickOnElement(pending_notification,"Pending Notification");
        return this;
    }
*/
    public  Boolean isUpgradeBtnDisplayed() {
        isElementNotPresent(liUpgrade);
        info("Upgrade Button Displayed");
        return driver.findElements(By.id("liUpgrade")).size() > 0;
    }

    public PremiumSubscriptionPage isStarTypeDisplayed() {
        isElementNotPresent(star_type);
        if(driver.findElements(By.id("star_type")).size() > 0)
        {
            pageInfo.pass("You are a Prime Member Now");
        }
        else{
            pageInfo.fail("You are a Prime Member Now");
        }
        return this;
    }

    public PremiumSubscriptionPage clickOnUpgrade() throws  InterruptedException {
        isElementNotPresent(liUpgrade);
        clickOnElement(liUpgrade,"Upgarde Button");
        return this;
    }

    public PremiumSubscriptionPage clickOnTC()  {
        isElementNotPresent(chTerm);
        clickOnElement(chTerm,"Terms And Condition");
        return this;
    }


    public PremiumSubscriptionPage clickOnSubscription()  {
        isElementNotPresent(liPay);
        clickOnElement(liPay,"Premium Subscription");
        return this;
    }

    public PremiumSubscriptionPage assertSufficientMoney() throws IOException, InterruptedException {
       // CommonUtils.pauseExecution(3);

        return  this;
    }

    public PremiumSubscriptionPage clickOnAlertOk()  {
        clickOnElement(ok_button,"Premium Subscription");
        return this;
    }

    public PremiumSubscriptionPage clickOnPayNow() {
        clickOnElement(btPay,"Pay Now");
        return this;
    }


    public PremiumSubscriptionPage clickOnHome()  {
        clickOnElement(imHome,"Home Button");
        return this;
    }


}
