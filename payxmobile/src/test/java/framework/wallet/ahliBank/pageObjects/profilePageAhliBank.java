package framework.wallet.ahliBank.pageObjects;

import globalConstants.NumberConstants;
import initializers.AppPageInit;


import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class profilePageAhliBank extends AppPageInit {

    public profilePageAhliBank(){
        super();
    }

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/bottom_navigation_container")
    private List<WebElement> profile;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/editProfileLayout")
private WebElement profileInfo;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/etUserEmailID")
private WebElement emailId;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/editClickLayout")
private WebElement editBtn;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/buildingEditText")
private WebElement buildNum;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/houseEditText")
private WebElement flatNum;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/streetEditText")
private WebElement streetName;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/zoneEditText")
private WebElement zone;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/poBoxEditText")
private WebElement poBox;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/updateProfileButton")
private  WebElement updateBtn;

@AndroidFindBy(id="com.ahlibank.ahlipay.subscriber.uat:id/btnToolbarBack")
private WebElement backBtn;

public profilePageAhliBank clickOnProfile(){
    clickOnElement(profile.get(4),"Click on Profile");
    return this;
}

public profilePageAhliBank clickOnProfileInfo(){
    clickOnElement(profileInfo,"Click on profile information");
    return this;
}

public profilePageAhliBank updateEmailId(String name){
    emailId.clear();
    setText(emailId,name,"Enter email id");
    return this;
}

public boolean isEmailIdPresent(){
    return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/etUserEmailID")).size()>0;
}

public boolean isEditButtonDisplayed(){
    return driver.findElements(By.id("com.ahlibank.ahlipay.subscriber.uat:id/editClickLayout")).size()>0;
}

public profilePageAhliBank clickOnEdit(){
    clickOnElement(editBtn,"Click on edit Button");
    return this;
}

public profilePageAhliBank updateBuildNum(String bNum){
    buildNum.clear();
    setText(buildNum,bNum,"Enter building number");
    return this;
}

public profilePageAhliBank updateStreet(String street){
    streetName.clear();
    setText(streetName,street,"Enter street name");
    return this;
}

public profilePageAhliBank updateZone(String zoneArea){
    zone.clear();
    setText(zone,zoneArea,"Enter Zone");
    return this;
}

public profilePageAhliBank updateFlatNum(String flat){
    flatNum.clear();
    setText(flatNum,flat,"Enter flat");
    return this;
}

public profilePageAhliBank updatePOBox(String poNum){
    poBox.clear();
    setText(poBox,poNum,"Enter Post office Number");
    return this;
}

public profilePageAhliBank clickOnBack(){
    clickOnElement(backBtn,"Click On Back button");
    return this;
}

public profilePageAhliBank clickOnUpdate(){
    clickOnElement(updateBtn,"Click on update");
    return this;
}

   /* public profilePageAhliBank update(String change, String text) {
        switch (change) {
            case NumberConstants.buildingNumber:
                driver.hideKeyboard();
                updateBuildNum(text);
                break;

            case NumberConstants.email:
                driver.hideKeyboard();
                updateEmailId(text);
                break;

            case NumberConstants.flatNumber:
                driver.hideKeyboard();
                updateFlatNum(text);
                break;

            case NumberConstants.pOBox:
                driver.hideKeyboard();
                updatePOBox(text);
                break;

            case NumberConstants.streetName:
                updateStreet(text);
                break;

            case NumberConstants.zone:
                updateZone(text);
                break;

            default:
                throw new UnsupportedOperationException(change + ":- This method is not supported");

        }
        return this;
    }

    public String getText(String change) {
    String value;
        switch (change) {
            case NumberConstants.buildingNumber:
               value = buildNum.getText();
                break;

            case NumberConstants.email:
               value = emailId.getText();
                break;

            case NumberConstants.flatNumber:
               value= flatNum.getText();
                break;

            case NumberConstants.pOBox:
              value=poBox.getText();
                break;

            case NumberConstants.streetName:
               value = streetName.getText();
                break;

            case NumberConstants.zone:
                value = zone.getText();
                break;

            default:
                throw new UnsupportedOperationException(change + ":- This method is not supported");

        }
        return value;
    }*/
}
