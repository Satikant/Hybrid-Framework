package framework.mobiquityPayX.payXUAT.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class orderDetailsPageObj extends AppPageInit {

    public orderDetailsPageObj(){
        super();
    }


    @AndroidFindBy(xpath = "//*[@text='Order details']")
    private WebElement orderDetails;



    public boolean isMyOdrersPresent(){
        Utils.putThreadSleep(4000);
        return driver.findElements(By.xpath("(//*[@class='android.widget.RelativeLayout'])[2]")).size()>0;
    }


    public String getTransctionsDetails() {
        try {
            Utils.putThreadSleep(3000);
            waitUntilElementDisappear("//*[@text='Order details']");
            info("Fetching Text : " + orderDetails.getText());
            return orderDetails.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }



}
