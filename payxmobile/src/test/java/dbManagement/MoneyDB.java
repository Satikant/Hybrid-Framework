package dbManagement;

import propertyManagement.ProjectProperties;

import java.sql.Connection;

public class MoneyDB extends DBClass{

    private static Connection conn;
    private static MoneyDB moneyDB;

    public MoneyDB(){
        DB_IP = ProjectProperties.getProperty("money.db.ip");
        DB_PORT = ProjectProperties.getProperty("money.db.port");
        DB_USERNAME = ProjectProperties.getProperty("money.db.username");
        DB_PASSWD = ProjectProperties.getProperty("money.db.password");
        DB_SID = ProjectProperties.getProperty("money.db.sid");
        DB_URL = "jdbc:oracle:thin:@" + DB_IP + ":" + DB_PORT + ":" + DB_SID;
        DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

    }

    public static MoneyDB getInstance(){
        return new MoneyDB();
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
