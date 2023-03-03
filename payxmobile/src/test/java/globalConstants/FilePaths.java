package globalConstants;

import propertyManagement.CITReportProperties;
import propertyManagement.MobileProperties;
import utils.DateUtil;

import java.io.File;

public class FilePaths {

    public final static String basePath = new File("").getAbsolutePath();
    public static final String DOWNLOAD_DIRECTORY_PATH = basePath+File.separator+"downloads"+File.separator;
    public static final String EXTENT_REPORT_PATH = basePath +File.separator+ "reports"+File.separator+"htmlReports"+File.separator;
    public final static String dirMwalletLogs = System.getProperty("user.dir") + File.separator+"reports"+File.separator+"logs"+File.separator;
    public final static String dirAppiumLogs = System.getProperty("user.dir") + File.separator+"logs"+File.separator;
    public final static String filePath = System.getProperty("user.dir") +File.separator+ "src"+File.separator+
            "test"+File.separator+"resources"+File.separator+"AppData"+File.separator;
    public final static String toastmessage = System.getProperty("user.dir") + File.separator+"reports"+File.separator+"captures"+File.separator;
    public final static String dirCITReport = System.getProperty("user.dir") + File.separator+"CITReports"+File.separator;
    public final static String applicationPath = System.getProperty("user.dir") + File.separator+"apps"+File.separator;
//    public final static String appiumJsPath = MobileProperties.getProperty("os.platform").equalsIgnoreCase("mac")
//            ?"/opt/homebrew/bin/appium"
//            :System.getProperty("user.home") +"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

//    public final static String nodeJsPath = MobileProperties.getProperty("os.platform").equalsIgnoreCase("mac")
//        ?"/opt/homebrew/bin/node"
//        :"C:\\Program Files\\nodejs\\node.exe";

    public final static String appiumJsPath = MobileProperties.getProperty("os.platform").equalsIgnoreCase("mac")
            ?"/usr/local/bin/appium"
            :System.getProperty("user.home") +"\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

    public final static String nodeJsPath = MobileProperties.getProperty("os.platform").equalsIgnoreCase("mac")
            ?"/usr/local/bin/node"
            :"C:\\Program Files\\nodejs\\node.exe";

    public final static String CIT_REPORT_OUTPUT_FILE = dirCITReport + CITReportProperties.getInstance().getProperty("BUILDID") + "_"
            + CITReportProperties.getInstance().getProperty("TestFrameworkName") + "_" +
            CITReportProperties.getInstance().getProperty("ProductInterface")
            + "_" + DateUtil.getCurrentDateTimeExcel() + ".xlsx";

    public final static String APPIUM_LOGS = dirAppiumLogs + "appium.txt";

    public final static String LOGCAT_LOGS = dirAppiumLogs + "device.txt";

    public final static String TESTING_LOGCAT_LOGS = dirAppiumLogs + "testingdevice.txt";

    public final static String CLIENT_LOGS = dirAppiumLogs + "client.txt";

}
