package framework.mobiquityPayX.commonApplicationModule.pageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import propertyManagement.MobileProperties;

import java.util.List;

public class LogOutPageObject extends AppPageInit {

    public LogOutPageObject(){
        super();
    }

    @AndroidFindBy(id ="toolbar_icon")
    private WebElement hamburgerMenu;

    @FindBy(xpath = "//XCUIElementTypeNavigationBar/XCUIElementTypeButton")
    private WebElement hamburgerMenuIOS;

    @AndroidFindBy(id ="menu_section_title_view")
    private List<WebElement> logOut;

    @FindBy(name ="home_logoutIcon")
    private WebElement logOutIOS;

    @AndroidFindBy(id ="confirmation_action_button")
    private WebElement logOutConfirmButton;

    @FindBy(name ="BottomSheetOkButtonIdentifier")
    private WebElement logOutConfirmButtonIOS;

    @FindBy(name ="Cancel")
    private WebElement cancelButtonIOS;

    @FindBy(xpath ="//XCUIElementTypeButton[@index = '0']")
    private WebElement kebabMenuIconIOS;

    @FindBy(xpath ="//XCUIElementTypeButton[@index = '0']")
    private WebElement loginWithAnotherAccountIOS;



    Boolean devicePlatform = MobileProperties.getProperty("device.platform").equalsIgnoreCase("android");
    WebElement element;

    public LogOutPageObject clickOnHamburgerMenu(){
        element = devicePlatform ? hamburgerMenu : hamburgerMenuIOS;
        clickOnElement(element,"Hamburger Menu");
        return this;
    }

    public LogOutPageObject clickOnLogOutIcon(){
        element = devicePlatform ? logOut.get(6) : logOutIOS;
        clickOnElement(element,"Log Out");
        return this;
    }

    public LogOutPageObject clickOnLogOutConfrimButton(){
        element = devicePlatform ? logOutConfirmButton:  logOutConfirmButtonIOS;
        clickOnElement(element,"Log Out Button");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }

    public Boolean isForgotPinButtonPresent(){
        return devicePlatform ?
                driver.findElements(By.id("forgot_pin_button")).size()>0 :
                driver.findElements(By.xpath("//XCUIElementTypeOther[@index = '9']")).size()>0;
    }

    public LogOutPageObject clickOnKebabMenuIcon(){
        element = devicePlatform ? logOutConfirmButton: kebabMenuIconIOS;
        isElementNotPresent(element);
        clickOnElement(element,"Kebab Menu icon");
        return this;
    }

    public LogOutPageObject clickOnLoginWithAnotherAccount(){
        element = devicePlatform ? logOutConfirmButton: loginWithAnotherAccountIOS;
        clickOnElement(element,"Login With Another Account");
        waitUntilElementDisappear("pb_loading","In progress");
        return this;
    }



}
