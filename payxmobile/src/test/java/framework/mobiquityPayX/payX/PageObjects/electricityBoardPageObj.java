package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.Utils;

public class electricityBoardPageObj extends AppPageInit {

    public electricityBoardPageObj(){
        super();
    }

    @AndroidFindBy(xpath = "//*[@text='Search']")
    private WebElement searchBar;

    @AndroidFindBy(id = "operatorBackArrowImageview")
    private WebElement backButton;

    @AndroidFindBy(xpath = "//*[@text='CHOOSE BOARD']")
    private WebElement chooseBoard;

    @AndroidFindBy(xpath = "(//*[@class='android.widget.TextView'])[2]")
    private WebElement firstElectricityBoard;


    public boolean isElectricityBoardPresent() {
        Utils.putThreadSleep(4000);
        return driver.findElements(By.xpath("//*[@text='CHOOSE BOARD']")).size() > 0;
    }

    public boolean isBackPresent() {
        Utils.putThreadSleep(3000);
        return driver.findElements(By.id("operatorBackArrowImageview")).size() > 0;
    }

    public electricityBoardPageObj chooseElecticityBoard() {
        Utils.putThreadSleep(4000);
        clickOnElement(firstElectricityBoard, "Clicking on the first elctricity board");
        return this;
    }






}
