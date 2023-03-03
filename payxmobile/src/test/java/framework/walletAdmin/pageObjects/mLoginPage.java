package framework.walletAdmin.pageObjects;

import com.jcraft.jsch.JSchException;
import initializers.PageInit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by ayush.singh on 20-01-2020.
 */
public class mLoginPage extends PageInit {
/*
    public mLoginPage(){
        super();
    }

    @FindBy(name = "Override")
    private WebElement visitsiteanyway;

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "pwd")
    private WebElement password;

    @FindBy(id = "walletForm_button_login")
    private WebElement signinButton;


    public mLoginPage clickOnVisitSiteAnyway() throws JSchException {
        if(webdriver.findElements(By.name("Override")).size()>0) {
            clickOnElement(visitsiteanyway, " Visit Site Anyway");
        }
        else{
            System.out.println("NOT FOUND");
        }
        return this;
    }

    public mLoginPage setUsername(String user) throws JSchException {
        webdriver.switchTo().frame("mainwindow");
        isElementNotPresent(username);
        setText(username,user,"password");
        return this;
    }

    public mLoginPage setPassword(String pass) throws JSchException {
        setText(password,pass,"Visit Site Anyway");
        return this;
    }

    public mLoginPage clickOnLogin() throws JSchException {
        clickOnElement(signinButton," signinButton");
        return this;
    }

    public static void main(String[] args) throws JSchException, InterruptedException {
       mLoginPage mloginpage=new mLoginPage();
       mloginpage.clickOnVisitSiteAnyway();
       webdriver.switchTo().frame("mainwindow");
       mloginpage.setUsername("superadmin");
       mloginpage.setPassword("Com@2468");
       mloginpage.clickOnLogin();
    }
    */
}
