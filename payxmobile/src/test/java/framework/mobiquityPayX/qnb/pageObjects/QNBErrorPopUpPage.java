package framework.mobiquityPayX.qnb.pageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class QNBErrorPopUpPage extends AppPageInit {

    public QNBErrorPopUpPage() {super();}


    @AndroidFindBy(id = "custom_dialog_title_imageView")
    private WebElement imgIcon;

    @AndroidFindBy(id = "custom_dialog_title_textView")
    private WebElement errorHeading;

    @AndroidFindBy(id = "custom_dialog_message_textView")
    private WebElement errorDescription;

    @AndroidFindBy(id = "custom_dialog_ok_buttonView")
    private WebElement errorOkBtn;

    public QNBErrorPopUpPage clickOnErrorOkBtn(){
        clickOnElement(errorOkBtn, "Error Ok Btn");
        return this;
    }

    public String getErrorHeading(){
        return getText(errorHeading,"Error Heading Text");
    }
    public String getErrorDescription(){
        return getText(errorDescription,"Error Description Text");
    }

    public boolean isErrorPopupPresent(){
        return driver.findElements(By.id("custom_dialog_title_imageView")).size() > 0 ;
    }

    public String[] getErrorPopupDetails(){
        return new String[]{getErrorHeading(),getErrorDescription()};
    }



}
