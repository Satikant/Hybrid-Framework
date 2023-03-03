package framework.mobiquityPayX.payX.PageObjects;

import com.aventstack.extentreports.Status;
import initializers.AppPageInit;
import utils.Utils;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class electricityBillPaymentSuccessPageObj extends AppPageInit {

    public electricityBillPaymentSuccessPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Service Type']")
    private WebElement serviceType;

    @AndroidFindBy(xpath = "//*[@text='Board']")
    private WebElement boardName;

    @AndroidFindBy(xpath = "//*[@text='Date']")
    private WebElement date;

    @AndroidFindBy(xpath = "//*[@text='Make another payment']")
    private WebElement anotherPayment;
    @AndroidFindBy(xpath = "//*[@text='View transactions']")
    private WebElement viewTransactionsBtn;
    @AndroidFindBy(xpath = "//*[@text='Go home']")
    private WebElement goHome;



    public boolean isServiceTypePresent(){
        isElementNotPresent(serviceType);
        return driver.findElements(By.xpath("//*[@text='Service Type']")).size()>0;
    }

    public boolean isAnotherPaymentPresent(){
        isElementNotPresent(anotherPayment);
        return driver.findElements(By.xpath("//*[@text='Make another payment']")).size()>0;
    }

    public electricityBillPaymentSuccessPageObj makeAnotherPayment(){
        Utils.putThreadSleep(3000);
        Utils.scrollDown();
        clickOnElement(anotherPayment,"Click on MAKE ANOTHER PAYMENT");
        return this;
    }

    public boolean isGoHomePresent(){
        Utils.putThreadSleep(5000);
        return driver.findElements(By.xpath("//*[@text='Go home']")).size()>0;
    }

    public electricityBillPaymentSuccessPageObj viewTransactions(){
        Utils.putThreadSleep(3000);
        Utils.scrollDown();
        clickOnElement(viewTransactionsBtn,"Click on view transactions.");
        return this;
    }

    public electricityBillPaymentSuccessPageObj clickOnGoHome(){
        Utils.scrollDown();
        isGoHomePresent();
        clickOnElement(goHome,"Click on Go Home tab.");
        Utils.putThreadSleep(5000);
        return this;
    }

    public String getElectricityBillPaymentSuccessful() {
        try {
            Utils.putThreadSleep(5000);
            waitUntilElementDisappear("//*[@text='Service Type']");
            info("Fetching Text : " + serviceType.getText());
            return serviceType.getText();
        } catch (Exception e) {
            e.printStackTrace();
            pageInfo.fail("Test Case Failed");
            pageInfo.log(Status.INFO, "StackTrace Result: " + ExceptionUtils.getStackTrace(e));
        }
        return "";
    }

}
