package framework.mobiquityPayX.qnb.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class QNBTransferToBankPageObjects extends AppPageInit {

    public QNBTransferToBankPageObjects(){
        super();
    }

    @AndroidFindBy(id = "homeTransferToBankImage")
    private WebElement transferToBankIcon;

 /*   @AndroidFindBy(id = "")
    private WebElement
*/

//    @Test
    public  QNBTransferToBankPageObjects clickOnTransferToBank(){
        clickOnElement(transferToBankIcon,"Transfer To Bank");
        return this;
    }



}
