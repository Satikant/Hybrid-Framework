package common;

import globalConstants.FilePaths;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.logging.LogEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import propertyManagement.MobileProperties;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;

public class DriverFactory {

  //  private static WebDriver driver;
    private static AppiumDriver mobileDriver;
    private static final Logger logger = LoggerFactory.getLogger(DriverFactory.class);

/*
    public static WebDriver getDriver() {
        if (driver == null) {
            driver = createDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //driver.manage().timeouts().pageLoadTimeout(9, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver createDriver() {
        // Uses firefox driver by default
        String browserName = ProjectProperties.getProperty("browser.name");
        if (browserName == null) {
            browserName = "firefox";
        }

        logger.info("Browser :" +browserName);

        if (browserName.equalsIgnoreCase("chrome")) {
            /**
             * Chrome
             */
             //ChromeDriverManager.getInstance().setup();
           // ChromeDriverManager.getInstance(). proxy("http://172.16.1.168:8080").setup();

       /*     System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
            chromePrefs.put("profile.default_content_settings.popups", 0);
            chromePrefs.put("download.default_directory", FilePaths.DOWNLOAD_DIRECTORY_PATH);
            chromePrefs.put(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
                    org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT);

            ChromeOptions options = new ChromeOptions();
            options.setExperimentalOption("prefs", chromePrefs);

            DesiredCapabilities cap = DesiredCapabilities.chrome();
            cap.setCapability(ChromeOptions.CAPABILITY, options);
            cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
            cap.setCapability("acceptInsecureCerts", true);
            cap.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            cap.setCapability("chrome.switches", Arrays.asList("--incognito"));
            //cap.setCapability("record_network", "true");

            return new ChromeDriver(cap);
        } else if (browserName.equalsIgnoreCase("ie")) {
            /**
             * IE Browser Capabilities
             */
       /*     System.setProperty("webdriver.ie.driver", "drivers/IEDriverServer.exe");
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, true);
            capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
            capabilities.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL,"https://www.google.com/");

            return new InternetExplorerDriver(capabilities);
        } else {
            /**
             * FireFox
             */
       /*     System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");

            FirefoxProfile profile = new FirefoxProfile();
            profile.setAcceptUntrustedCertificates(false);
            profile.setAssumeUntrustedCertificateIssuer(true);
            profile.setPreference("browser.download.folderList", 2);
            profile.setPreference("browser.helperApps.alwaysAsk.force", false);
            profile.setPreference("browser.download.manager.showWhenStarting", false);
            profile.setPreference("dom.file.createInChild", true);
            profile.setPreference("browser.download.downloadDir", FilePaths.DOWNLOAD_DIRECTORY_PATH);

            DesiredCapabilities dc = DesiredCapabilities.firefox();
            dc.setCapability(FirefoxDriver.PROFILE, profile);
            dc.setCapability("marionette", true);

            return new FirefoxDriver(dc);
        }
    }
*/
    public static AppiumDriver getMobileAppDriver(){
       try{
           if(mobileDriver != null){
               return mobileDriver;
           }
           if (MobileProperties.getProperty("device.platform").equalsIgnoreCase("android")) {
               mobileDriver = MobileDriver.getAndroidDriver();
               logger.info("Info :  ");

               //mobileDriver.removeApp("com.abp.sub");
           }
           else {
               mobileDriver = MobileDriver.getIOSDriver();
           }
       }
        catch (Exception e){
           e.printStackTrace();
        }
        return mobileDriver;
    }

/*
    public static void closeDriver() {
        driver.close();
    }

    public static void quitDriver() {
        if (driver == null) {
            return;
        }
        driver.quit();
        driver = null;

    }*/

}
