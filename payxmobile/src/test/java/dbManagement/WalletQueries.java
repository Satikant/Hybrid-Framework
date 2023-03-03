package dbManagement;

import java.sql.*;

public class WalletQueries {
    private static Connection dbConn;
    private static Connection postgreDbConn;
    private static Statement stmt;
    private static ResultSet resultSet;
    private static ResultSetMetaData resultSetMetaData;

    static {
        dbConn = new WalletDB().getDBConnection();
        //postgreDbConn = new MobileAppMgrDB().getDBConnection();
    }

    public static String getSMS(String msisdn){
        try {
            stmt = dbConn.createStatement();
            resultSet = stmt.executeQuery("select * from MTX_SENT_SMS where MSISDN='"+msisdn+"' order by CREATED_ON desc");
            while (resultSet.next()){
                return resultSet.getString("MESSAGE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static void getOTP(){
        try {
            stmt = dbConn.createStatement();
            resultSet = stmt.executeQuery(" select * from OTP_RECORD where ROWNUM <= 1 ");
            resultSetMetaData = resultSet.getMetaData();
            while (resultSet.next()){
                System.out.println(resultSet.getString(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void commit() throws SQLException {
            stmt = dbConn.createStatement();
            resultSet = stmt.executeQuery("commit");
    }



    public static String setSilverGradeSubscription(String msisdn){
        try {
            stmt = dbConn.createStatement();
            resultSet=stmt.executeQuery("update MTX_PREMIUM_USER set STATUS = 'N' WHERE MSISDN='"+msisdn+"'");
            commit();
            while (resultSet.next()){
                return resultSet.getString("STATUS");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }




}

