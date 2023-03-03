package framework.wallet.omantel.pageObjects;

import initializers.AppPageInit;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;


public class HomePage extends AppPageInit{
    FluentWait fluentWait = new FluentWait<>(driver);

    @AndroidFindBy(id = "app.banking.bankmuscat:id/loadmoney_img")
    private WebElement loadMoney;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/img_profilepic")
    private WebElement profilePic;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/header_home")
    private WebElement homeButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/buttonNotification")
    private WebElement notificationButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/header_menu_button")
    private WebElement kebabMenuButton;

    @AndroidFindBy(id = "app.banking.bankmuscat:id/txt_userbalanceamnt")
    private WebElement balanceText;

    public HomePage clickOnLoadMoney(){
        loadMoney.click();
        return this;
    }

    public boolean isProfilePicDisplayed(){
        return profilePic.isDisplayed();
    }

    public boolean isHomeButtonDisplayed(){
        return homeButton.isDisplayed();
    }

    public HomePage clickOnProfilePic()  {
        clickOnElement(profilePic,"Profile Picture");
        return this;
    }

    public HomePage clickOnKebabMenuButton()  {
        clickOnElement(kebabMenuButton,"Menu Button");
        return this;
    }

    public String getBalanceFromHomePage(){
        return balanceText.getText();
    }

    public HomePage clickOnViewBalanceDetails()  {
        clickOnElement(balanceText,"View Balance Details");
        balanceText.click();
        return this;
    }

    //--------------------------Omantel-----------------------


}
