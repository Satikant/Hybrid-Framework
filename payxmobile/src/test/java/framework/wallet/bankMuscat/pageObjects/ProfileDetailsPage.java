package framework.wallet.bankMuscat.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class ProfileDetailsPage extends AppPageInit {


    @AndroidFindBy(id = "app.banking.bankmuscat:id/txt_name")
    private WebElement userNameLabel;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txt_email")
    private WebElement emailText;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txt_mobile")
    private WebElement mobileText;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/alias")
    private WebElement aliasText;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txt_dob")
    private WebElement dobText;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/btn_language")
    private WebElement btn_language;

    public ProfileDetailsPage clickOnLanguageButton()  {
        clickOnElement(btn_language,"Clicked on Language Button");
        return this;
    }

}
