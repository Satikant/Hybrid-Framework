package framework.mobiquityPayX.payXUAT.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class historyPageObj extends AppPageInit {

    public historyPageObj(){
        super();
    }

// (//*[@class='android.widget.FrameLayout'])[16]

    @AndroidFindBy(xpath = "//*[@text='History']")
    private WebElement historyTitle;

    @AndroidFindBy(xpath = "//*[@text='Wallet']")
    private WebElement wallet;

    @AndroidFindBy(xpath = "//*[@text='My orders']")
    private WebElement myOrders;

    @AndroidFindBy(id = "menuOrderFilter")
    private WebElement filterIcon;

    @AndroidFindBy(xpath = "(//*[@text='Status :'])[1]")
    private WebElement firstTransaction;



    public boolean isMyOdrersPresent(){
        Utils.putThreadSleep(4000);
        return driver.findElements(By.xpath("(//*[@class='android.widget.RelativeLayout'])[2]")).size()>0;
    }

    public historyPageObj clickOnMyOrders(){
        Utils.putThreadSleep(5000);
        clickOnElement(myOrders,"Click on my orders tab.");
        return this;
    }

    public historyPageObj clickOnTransction(){
        Utils.putThreadSleep(5000);
        isElementNotPresent(firstTransaction);
        clickOnElement(firstTransaction,"Click on first transctions of my orders tab.");
        return this;
    }



    public String getFailedTransctions() {
        try {
            Utils.putThreadSleep(3000);
            waitUntilElementDisappear("//*[@text='My orders']");
            info("Fetching Text : " + myOrders.getText());
            return myOrders.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }




}
