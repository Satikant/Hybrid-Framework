package tests.wallet.ahliBank;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import common.Assertion;
import framework.wallet.ahliBank.features.ProfileFeatureAhliBank;
import framework.wallet.ahliBank.pageObjects.ForgotPinPageAhliBank;
import framework.wallet.ahliBank.pageObjects.profilePageAhliBank;
import globalConstants.NumberConstants;
import initializers.TestInit;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import propertyManagement.TestCases;
import reportManagement.ExtentManager;
import utils.GenerateRandomValue;
import utils.MessageReader;

import java.io.IOException;

public class profileTestAhliBank extends TestInit {
    profilePageAhliBank page = new profilePageAhliBank();
    ProfileFeatureAhliBank feature = new ProfileFeatureAhliBank();
    ForgotPinPageAhliBank forgotPage = new ForgotPinPageAhliBank();

    @AfterMethod
    public void afterMethod() {
        feature.aftermethod();
    }
/*

    @Test(priority = 1)
    public void TC_profile_001() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_001"));
        feature.changeProfile(NumberConstants.email, "");
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_005"));
    }

    @Test(priority = 4)
    public void TC_profile_002() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_002"));
        String value = GenerateRandomValue.getRandomAlphabeticValue(6) + "@gmail.com";
        feature.changeProfile(NumberConstants.email, value);
        Assertion.verifyEqual(page.getText(NumberConstants.email), value);
    }

    @Test(priority = 5)
    public void TC_profile_003() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_003"));
        String update = NumberConstants.email;
        String value = GenerateRandomValue.getRandomAlphaNumericValue(6) + "@gmail.com";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 2)
    public void TC_profile_004() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_004"));
        String update = NumberConstants.email;
        String value = GenerateRandomValue.getRandomAlphabeticValue(6);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_005"));
    }

    @Test(priority = 6)
    public void TC_profile_005() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_005"));
        String update = NumberConstants.email;
        String value = GenerateRandomValue.getRandomIntValue(6) + "@gmail.com";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 3)
    public void TC_profile_006() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_006"));
        String update = NumberConstants.email;
        String value = GenerateRandomValue.getRandomAlphaNumericValue(6) + "#$%^&^%$#" + "@gmail.com";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_005"));
    }

    @Test(priority = 6)
    public void TC_profile_007() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_007"));
        String update = NumberConstants.buildingNumber;
        String value = "";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_004"));
    }

    @Test(priority = 6)
    public void TC_profile_008() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_008"));
        String update = NumberConstants.flatNumber;
        String value = "";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_003"));
    }

    @Test(priority = 6)
    public void TC_profile_009() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_009"));
        String update = NumberConstants.streetName;
        String value = "";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_002"));
    }

    @Test(priority = 6)
    public void TC_profile_010() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_010"));
        String update = NumberConstants.zone;
        String value = "";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), MessageReader.getMessage("Error_AH_Profile_001"));
    }

    @Test(priority = 6)
    public void TC_profile_011() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_011"));
        String update = NumberConstants.pOBox;
        String value = "";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(forgotPage.getErrMessage(), "Please enter valid p.o. box number");
    }

    @Test(priority = 6)
    public void TC_profile_012() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_012"));
        String update = NumberConstants.pOBox;
        String value = GenerateRandomValue.getRandomIntValue(6);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 6)
    public void TC_profile_013() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_013"));
        String update = NumberConstants.flatNumber;
        String value = GenerateRandomValue.getRandomIntValue(3);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 6)
    public void TC_profile_014() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_014"));
        String update = NumberConstants.buildingNumber;
        String value = GenerateRandomValue.getRandomIntValue(3);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 6)
    public void TC_profile_015() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_015"));
        String update = NumberConstants.streetName;
        String value = GenerateRandomValue.getRandomIntValue(3);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }


    @Test(priority = 6)
    public void TC_profile_016() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_016"));
        String update = NumberConstants.streetName;
        String value = GenerateRandomValue.getRandomAlphaNumericValue(6);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 6)
    public void TC_profile_017() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_017"));
        String update = NumberConstants.streetName;
        String value = GenerateRandomValue.getRandomAlphabeticValue(3);
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }

    @Test(priority = 6)
    public void TC_profile_018() throws IOException {
        ExtentManager.startTestFromProperty(pNode, TestCases.getTestCase("TC_Profile_018"));
        String update = NumberConstants.streetName;
        String value = GenerateRandomValue.getRandomIntValue(3)+"#$%^&*";
        feature.changeProfile(update, value);
        Assertion.verifyEqual(page.getText(update), value);
    }*/
}