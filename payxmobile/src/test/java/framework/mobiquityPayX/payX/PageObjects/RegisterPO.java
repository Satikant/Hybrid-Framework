package framework.mobiquityPayX.payX.PageObjects;

import initializers.AppPageInit;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class RegisterPO extends AppPageInit {
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/et_floating_label_with_prefix_label")
    public WebElement mobilenoedit;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginDetailCheckbox")
    public WebElement loginDetailCheckbox;
    @AndroidFindBy(id = "com.comviva.mobiquity.consumer.debug:id/loginDetailNextButton")
    public WebElement loginDetailNextBtn;
}
