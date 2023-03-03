package dbManagement;

import propertyManagement.ProjectProperties;

import java.sql.Connection;

public class WalletDB extends DBClass{

    private static Connection conn;
    private static WalletDB walletDB;

    public WalletDB(){
        DB_IP = ProjectProperties.getProperty("wallet.db.ip");
        DB_PORT = ProjectProperties.getProperty("wallet.db.port");
        DB_USERNAME = ProjectProperties.getProperty("wallet.db.username");
        DB_PASSWD = ProjectProperties.getProperty("wallet.db.password");
        DB_SID = ProjectProperties.getProperty("wallet.db.sid");
        DB_URL = "jdbc:oracle:thin:@" + DB_IP + ":" + DB_PORT + "/" + DB_SID;
        DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    }

    public static WalletDB getInstance(){
        return new WalletDB();
    }


    public Connection getDBConnection()  {
        try {
            DBConnectionPool.setupDataSource(DRIVER_NAME,DB_URL,DB_USERNAME,DB_PASSWD);
            conn = DBConnectionPool.getDataSource("oracle").getConnection();
            System.out.println(conn);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    /*private static final String DRIVER_NAME,DB_URL,DB_PORT,DB_USERNAME, DB_PASSWD, DB_IP;
    static {
        DRIVER_NAME = "";
        DB_IP ="";
        DB_PORT="";
        DB_USERNAME="";
        DB_PASSWD ="";
        DB_URL="";
    }*/

    public String getDBURL(){
        return DB_URL;
    }
}
