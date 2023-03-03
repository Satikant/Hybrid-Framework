package initializers;

import com.aventstack.extentreports.ExtentTest;
import com.jcraft.jsch.JSchException;
import common.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import reportManagement.ExtentManager;
import utils.CommonUtils;

import java.util.NoSuchElementException;

public class PageInit  {
/*    protected  ExtentTest pageInfo;
    protected static WebDriver webdriver;

    public PageInit()  {
        webdriver= DriverFactory.getDriver();
        CommonUtils.pauseExecution(5);
        PageFactory.initElements(webdriver,this);
        webdriver.get("https://54.76.171.156/mWalletAdmin/");
    }
    public boolean isElementNotPresent(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(webdriver, 30,500);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    protected void setText(WebElement element,String text,String elementName){
        pageInfo= ExtentManager.getTest();
        element.sendKeys(text);
        pageInfo.info("Entered text: '"+text +"' into field "+elementName);
    }

    protected void clickOnElement(WebElement element, String elementName) throws JSchException {
        pageInfo= ExtentManager.getTest();
        element.click();
        pageInfo.info("Clicked on : '"+elementName +"'");
    }
    protected void info(String elementName) throws JSchException {
        pageInfo= ExtentManager.getTest();
        pageInfo.info(elementName);
    }
    */
}
