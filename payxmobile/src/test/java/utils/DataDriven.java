package utils;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import propertyManagement.MobileProperties;
import propertyManagement.ProjectProperties;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by ayush.singh on 09-12-2019.
 */
public class DataDriven {
    static String actualCountry,actualStatus, value;
   static ExcelUtil excelUtil;
   static int rowCount;
   static int z;
   static ArrayList<String> msisdnList = new ArrayList<>();


   public DataDriven()  {
       excelUtil=new ExcelUtil(ProjectProperties.getProperty("wallet.excel.filename")).setSheet(ProjectProperties.getProperty("wallet.excel.sheetname"));
       rowCount= excelUtil.getRowCount();
   }

   //Fetching Data from excel on the basis of country and status

    public static String getUserByStatus( String status)  {
        try{
            for (z = 0; z <= rowCount; z++) {
                actualCountry = excelUtil.getCellData(z, 2);
                actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status) ) {
                    return excelUtil.getCellData(z, 0);
                }
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public static String getIdByStatus(String status)  {
        try{
            for ( z = 1; z <= rowCount; z++)
            {
                actualCountry = excelUtil.getCellData(z, 2);
                actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    return excelUtil.getCellData(z, 6);
                }
            }
        }
        catch(Exception e){
        }
        return "";
    }


                public static ArrayList<String> getListOfMsisdn (String status){
                    try {
                        msisdnList.clear();
                        for (z = 1; z <= rowCount; z++) {
                            if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status))
                                msisdnList.add(excelUtil.getCellData(z, 0));
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return msisdnList;
                }

            public static String getUserPinByStatus (String status){
                try {
                    for (z = 0; z <= rowCount; z++) {
                        String actualCountry = excelUtil.getCellData(z, 2);
                        String actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            System.out.println("Current PIN  :  " + excelUtil.getCellData(z, 3));
                            return excelUtil.getCellData(z, 3);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }


            public static String getUserPin2ByStatus (String status){
                try {
                    for (z = 0; z < rowCount; z++) {
                        String actualCountry = excelUtil.getCellData(z, 2);
                        String actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            System.out.println("Last PIN  :  " + excelUtil.getCellData(z, 4));
                            return excelUtil.getCellData(z, 4);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            public static String getUserPin3ByStatus (String status){
                try {
                    for (z = 0; z < rowCount; z++) {
                        String actualCountry = excelUtil.getCellData(z, 2);
                        String actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            System.out.println("Second Last PIN  :  " + excelUtil.getCellData(z, 5));
                            return excelUtil.getCellData(z, 5);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }


    public static String getAmountByStatus (String status){
        try {
            for (z = 0; z < rowCount; z++) {
                String actualCountry = excelUtil.getCellData(z, 2);
                String actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    System.out.println("Enter Amount  :  " + excelUtil.getCellData(z, 8));
                    return excelUtil.getCellData(z, 8);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getMobileNoByStatus (String status){
        try {
            for (z = 0; z < rowCount; z++) {
                String actualCountry = excelUtil.getCellData(z, 2);
                String actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    System.out.println("Enter Amount  :  " + excelUtil.getCellData(z, 12));
                    return excelUtil.getCellData(z, 12);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getCustomerIDByStatus (String status){
        try {
            for (z = 0; z < rowCount; z++) {
                String actualCountry = excelUtil.getCellData(z, 2);
                String actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    System.out.println("Enter Customer ID  :  " + excelUtil.getCellData(z, 9));
                    return excelUtil.getCellData(z, 9);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getDepositNoByStatus (String status){
        try {
            for (z = 0; z < rowCount; z++) {
                String actualCountry = excelUtil.getCellData(z, 2);
                String actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    System.out.println("Get deposite number  :  " + excelUtil.getCellData(z, 10));
                    return excelUtil.getCellData(z, 10);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getWithdrawerNoByStatus (String status){
        try {
            for (z = 0; z < rowCount; z++) {
                String actualCountry = excelUtil.getCellData(z, 2);
                String actualStatus = excelUtil.getCellData(z, 1);
                if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                    System.out.println("Get withdrawer number  :  " + excelUtil.getCellData(z, 11));
                    return excelUtil.getCellData(z, 11);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


            public static void setCellValueByStatus (String actualvalue, String expectedValue){
                try {
                    for (z = 0; z < rowCount; z++) {
                        actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(actualvalue)) {
                            excelUtil.updateCellValue(ProjectProperties.getProperty("wallet.excel.filename"), ProjectProperties.getProperty("wallet.excel.sheetname"), z, 1, expectedValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }


            public static String checkValueExistInExcel (String status){
                value = getUserByStatus(status);
                System.out.println(value);
                if (!(value == null)) {
                    System.out.println("Blacklisted number is already Existed in Excel");
                }
                return value;
            }


            public static void setCellValueByOldPin (String status, String newValue){
                try {
                    for (z = 0; z < rowCount; z++) {
                        actualCountry = excelUtil.getCellData(z, 2);
                        actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            excelUtil.updateCellValue(ProjectProperties.getProperty("wallet.excel.filename"), ProjectProperties.getProperty("wallet.excel.sheetname"), z, 3, newValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public static void main (String[]args) throws IOException,  InvalidFormatException {
                DataDriven dD = new DataDriven();
                String msisdn= DataDriven.getUserByStatus("Y");
                System.out.println(msisdn + "  test");
            }

            public static void setCellValueByOldPin2 (String status, String newValue){
                try {
                    for (z = 0; z < rowCount; z++) {
                        actualCountry = excelUtil.getCellData(z, 2);
                        actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            excelUtil.updateCellValue(ProjectProperties.getProperty("wallet.excel.filename"), ProjectProperties.getProperty("wallet.excel.sheetname"), z, 4, newValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public static void setCellValueByOldPin3 (String status, String newValue){
                try {
                    for (z = 0; z < rowCount; z++) {
                        actualCountry = excelUtil.getCellData(z, 2);
                        actualStatus = excelUtil.getCellData(z, 1);
                        if (actualCountry.equalsIgnoreCase(MobileProperties.getProperty("country.code")) && actualStatus.equalsIgnoreCase(status)) {
                            excelUtil.updateCellValue(ProjectProperties.getProperty("wallet.excel.filename"), ProjectProperties.getProperty("wallet.excel.sheetname"), z, 5, newValue);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
