package reportManagement;
import org.jsoup.select.Elements;
import utils.CITReport;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class HTMLParser {
    static Object[][] ReporterData;

    public HTMLParser() {
    }

    public static Object[][] generateReporterObject() throws IOException {
        ExtentReader HTMLReader = new ExtentReader();
        CITReport citReport = new CITReport();
        String fileContent = HTMLReader.readFile(CITReport.INPUTHTML_PATH);
        Document doc = Jsoup.parse(fileContent, "", Parser.xmlParser());
        int ObjSize, counter;

        Element e;
        Element TestCaseStatus_PROG;
        Iterator var6;
        String ModuleName;
        String testCaseDescription = null;
        String testCaseTime = null;
        String testCaseType = null;
        String infos = null;


        ObjSize = doc.select("div[class='node']").size();
        ReporterData = new Object[ObjSize][16];
        counter = 0;
        var6 = doc.getElementsByClass("test-item").iterator();

        while (var6.hasNext()) {
            e = (Element) var6.next();
            //test-name fetches the module name
            ModuleName = e.select("p[class='name']").text();
            //collapsible-header fetches the block of test case description
            for (Iterator var9 = e.select("div[class='card-header']").iterator(); var9.hasNext(); ++counter) {
                Element f = (Element) var9.next();
                String testCaseID = null;
                String testStatus = null;

                try {
                    Element mainNode = f.children().select("div[class='node']").first();
                    Element mainNodeForTime = f.children().select("div[class='node-time']").first();
                    String allDes = mainNode.text();
                    testCaseID = allDes.split(":")[0];

                    if (testCaseID.toLowerCase().contains("setup") || testCaseID.toLowerCase().contains("teardown") || testCaseID.contains("Load Environment Variables and Base Set") || testCaseID.contains("Base User Creation")) {
                        counter--;
                        continue;
                    }

                    testCaseDescription = allDes.split(":")[1];


                    Element ExecutionTime_PROG = mainNodeForTime;
                       testCaseTime = ExecutionTime_PROG.text();


                    Element TestStatus_PROG = mainNode.nextElementSibling();
                    testStatus = TestStatus_PROG.text();

                    testStatus = Character.toString(testStatus.charAt(0)).toUpperCase() + testStatus.substring(1);
                } catch (Exception ex) {
                    System.err.println("Error while reading HTML file");
                    ex.printStackTrace();
                }

                ReporterData[counter][0] = citReport.getBuildID();
                ReporterData[counter][1] = citReport.getLeadName();
                ReporterData[counter][2] = citReport.getTestFrameworkIP();
                ReporterData[counter][3] = citReport.getTestFrameworkName();
                ReporterData[counter][4] = citReport.getTestFrameworkSVNPath();
                ReporterData[counter][5] = testCaseTime;
                ReporterData[counter][6] = citReport.getProductInterface();
                ReporterData[counter][7] = testCaseID;
                ReporterData[counter][8] = testCaseDescription;
                ReporterData[counter][9] = testStatus;
                ReporterData[counter][10] = citReport.getCountry();
                ReporterData[counter][11] = citReport.getLanguage();
                ReporterData[counter][12] = ModuleName;
                //ReporterData[counter][13] = testCaseType;
            }
        }

        return ReporterData;
    }
}