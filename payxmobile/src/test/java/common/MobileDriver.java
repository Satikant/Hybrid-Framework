package common;

import globalConstants.FilePaths;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.remote.DesiredCapabilities;
import propertyManagement.MobileProperties;
import utils.CommonUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class MobileDriver {

    private static AppiumDriverLocalService service;
    private static String appiumURL;
    private static String nodeJsPath;
    private static String appiumJsPath;
    /*
     * --log-level - change the level at which Appium logs information. Appium defaults to logging everything, which can be a lot.
     * The options for the flag are
     * 'info', 'info:debug', 'info:info', 'info:warn', 'info:error', 'warn', 'warn:debug', 'warn:info',
     * 'warn:warn', 'warn:error', 'error', 'error:debug', 'error:info', 'error:warn',
     * 'error:error', 'debug', 'debug:debug', 'debug:info', 'debug:warn', 'debug:error'*/

    public static void startAppiumServer() {
        try {
            if (!MobileProperties.getProperty("os.platform").equalsIgnoreCase("mac")) {
                Runtime.getRuntime().exec("taskkill /F /IM node.exe");
                CommonUtils.pauseExecution(10);
            }

            nodeJsPath = FilePaths.nodeJsPath;
            appiumJsPath = FilePaths.appiumJsPath;
            Map<String, String> env = new HashMap<String, String>(System.getenv());
            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(
                    new AppiumServiceBuilder().
                            usingDriverExecutable(new File(nodeJsPath)).
                            withAppiumJS(new File(appiumJsPath)).
                            withIPAddress("127.0.0.1").
                            withLogFile(new File(FilePaths.APPIUM_LOGS)).
                            usingAnyFreePort().
                            withTimeout(Duration.ofSeconds(300)).
                            withArgument(GeneralServerFlag.LOG_LEVEL, "error").
                            withArgument(GeneralServerFlag.RELAXED_SECURITY).
                            withArgument(GeneralServerFlag.ALLOW_INSECURE, "get_system_logs").
                            withArgument(GeneralServerFlag.SESSION_OVERRIDE));
            service.start();
            appiumURL = service.getUrl().toString();
            System.out.println("APPIUM URL :  " + appiumURL);
            System.out.println("System Environment :  " + env);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void stopAppiumServer() {
        service.stop();
    }


    public static AndroidDriver getAndroidDriver() {
        File dir = new File(FilePaths.applicationPath);
        File app = new File(dir, MobileProperties.getProperty("application.name"));
        try {
            System.out.println("Setting Capabilities of Android Driver");
            startAppiumServer();
            UiAutomator2Options capabilities = new UiAutomator2Options()
                    .setDeviceName(MobileProperties.getProperty("device.name"))
                    .setUdid(MobileProperties.getProperty("device.udid"))
                    .setApp(app.getAbsolutePath())
                    .setAppPackage(MobileProperties.getProperty("app.package"))
                    .setAppActivity(MobileProperties.getProperty("app.activity"))
                    .setPlatformVersion(MobileProperties.getProperty("device.version"))
                    .setAutoGrantPermissions(true)
                    .setNoReset(false)
                    .setNewCommandTimeout(Duration.ofSeconds(30000))
                    .setAutomationName("UiAutomator2")
                    .setIgnoreHiddenApiPolicyError(true)
                    .clearDeviceLogsOnStart()
                    .eventTimings();
            return new AndroidDriver(service.getUrl(), capabilities);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static IOSDriver getIOSDriver() {
//        File dir = new File(FilePaths.applicationPath);
//        File app = new File(dir, MobileProperties.getProperty("application.name"));
        XCUITestOptions capabilities = new XCUITestOptions();
        try {
            System.out.println("Setting Capabilities of IOS Driver");
            startAppiumServer();
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITEST");
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, MobileProperties.getProperty("device.name"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobileProperties.getProperty("device.platform"));
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, MobileProperties.getProperty("device.version"));
            capabilities.setCapability(MobileCapabilityType.UDID, MobileProperties.getProperty("device.udid"));
//            capabilities.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/apps/Pretups.app");
            capabilities.setCapability(MobileCapabilityType.APP, MobileProperties.getProperty("app.path"));
            capabilities.setCapability("connectHardwareKeyboard", false);
            return new IOSDriver(service.getUrl(), capabilities);
        } catch (SessionNotCreatedException e) {
            capabilities.useNewWDA();
            return new IOSDriver(service.getUrl(), capabilities);
        }
    }

        /*try {
            startAppiumServer();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("pCloudy_Username", "naveen.kaushal@comviva.com");
            capabilities.setCapability("pCloudy_ApiKey", "8mf3hd4zvrgwzghc7dzqq69g");
            capabilities.setCapability("pCloudy_DurationInMinutes", 10);
            capabilities.setCapability("newCommandTimeout", 600);
            capabilities.setCapability("launchTimeout", 90000);
            capabilities.setCapability("pCloudy_DeviceFullName", "APPLE_iPhoneXR_iOS_15.2.1_b3558");
            capabilities.setCapability("platformVersion", "15.2.1");
            capabilities.setCapability("platformName", "ios");
            capabilities.setCapability("acceptAlerts", true);
            capabilities.setCapability("automationName", "XCUITest");
            capabilities.setCapability("bundleId", "com.namastepay.ios.app.consumer");
            capabilities.setCapability("pCloudy_WildNet", "false");
            capabilities.setCapability("pCloudy_EnableVideo", "false");
            capabilities.setCapability("pCloudy_EnablePerformanceData", "false");
            capabilities.setCapability("pCloudy_EnableDeviceLogs", "false");
            return new IOSDriver(new URL("https://device.pcloudy.com/appiumcloud/wd/hub"), capabilities);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

//        try {
//            //startAppiumServer();
//            DesiredCapabilities caps = new DesiredCapabilities();
//            HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
//            // Set your access credentials
//            browserstackOptions.put("userName", "satikantap_hrWRfx");
//            browserstackOptions.put("accessKey", "HM2BjxPSHhex1SzksnNZ");
////    caps.setCapability("browserstack.user", "naveenkaushal_d5DqVU");
////    caps.setCapability("browserstack.key", "DTwdpXPZ613NWTKN9TRw");
//            // Set other BrowserStack capabilities
//            browserstackOptions.put("appiumVersion", "1.22.0");
//            browserstackOptions.put("projectName", "Mobiquity PAYX Project");
//            browserstackOptions.put("buildName", "browserstack-build-1");
//            browserstackOptions.put("sessionName", "first_test");
//            // Passing browserstack capabilities inside bstack:options
//            caps.setCapability("bstack:options", browserstackOptions);
//            // Set URL of the application under test
//            caps.setCapability("app", "bs://e287e571534da329f8b558a586a5d5de9df03f79");
//            // Specify deviceName and platformName for testing
//            caps.setCapability("deviceName", "iPhone XS");
//            caps.setCapability("platformName", "ios");
//            caps.setCapability("platformVersion", "12");
//            // Initialise the remote Webdriver using BrowserStack remote URL
//            // and desired capabilities defined above
//            return new IOSDriver(new URL("http://hub.browserstack.com/wd/hub"), caps);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        File dir = new File(FilePaths.applicationPath);

//        File dir = new File(FilePaths.applicationPath);
//        File app = new File(dir, MobileProperties.getProperty("application.name"));
//        XCUITestOptions capabilities = new XCUITestOptions();
//        try {
//            System.out.println("Setting Capabilities of IOS Driver");
//            startAppiumServer();
//             capabilities
//                    .setDeviceName(MobileProperties.getProperty("device.name"))
//                    .setUdid(MobileProperties.getProperty("device.udid"))
//                    .setApp(app.getAbsolutePath())
//                    .setAllowProvisioningDeviceRegistration(true)
//                    .setAutoAcceptAlerts(true)
//                    .setBundleId(MobileProperties.getProperty("bundle.id"))
//                     .setForceAppLaunch(true)
//                    .setPlatformVersion(MobileProperties.getProperty("device.version"))
//                    .setPlatformName(MobileProperties.getProperty("device.platform"))
//                     .setUsePrebuiltWda(true)
//                    .setNoReset(false)
//                    .setNewCommandTimeout(Duration.ofSeconds(30000))
//                    .setAutomationName("XCUITest")
//                     .clearSystemFiles()
//                     .eventTimings();
//                   // capabilities.setCapability("updatedWDABundleId", "com.ayushsnghcool.WebDriverAgentRunner");
////            capabilities.setCapability("xcodeOrgId", "CQA2B4G3K2");
////            capabilities.setCapability("xcodeSigningId", "iPhone Developer");
//            return new IOSDriver(service.getUrl(),capabilities);
//        } catch (SessionNotCreatedException e) {
//            capabilities.useNewWDA();
//            return new IOSDriver(service.getUrl(), capabilities);
//        }
//    }
    }