package dbManagement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MoneyQueries {

    private static Connection dbConn;
    private static Connection postgreDbConn;
    private static Statement stmt;
    private static ResultSet resultSet;

    static {
        dbConn = new MoneyDB().getDBConnection();
        //postgreDbConn = new MobileAppMgrDB().getDBConnection();
    }


    public static String getLoginID(String msisdn){
        try {
            stmt = dbConn.createStatement();

            resultSet = stmt.executeQuery("select USER_ID from mtx_party where MSISDN='"+msisdn+"'");

            while (resultSet.next()){
                return resultSet.getString("USER_ID");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static String getMSISDN(){
        try {
            stmt = postgreDbConn.createStatement();

            resultSet = stmt.executeQuery("select MSISDN from users");

            while (resultSet.next()){
                return resultSet.getString("MSISDN");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }


    public static void main(String[] args) {
        System.out.println("Login ID :" +getLoginID("77123478"));
    }
}
