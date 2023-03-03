package dbManagement;

import propertyManagement.ProjectProperties;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MobileAppMgrDB extends DBClass{


    MobileAppMgrDB(){
        DB_IP = ProjectProperties.getProperty("wallet.db.ip");
        DB_PORT = ProjectProperties.getProperty("wallet.db.port");
        DB_USERNAME = ProjectProperties.getProperty("wallet.db.username");
        DB_PASSWD = ProjectProperties.getProperty("wallet.db.password");
        DB_SID = ProjectProperties.getProperty("wallet.db.sid");
        DB_URL = "jdbc:postgresql://" + DB_IP + ":" + DB_PORT + "/" + DB_SID;
        DRIVER_NAME = "org.postgresql.Driver";

    }

    public static MobileAppMgrDB getInstance(){
        return new MobileAppMgrDB();
    }

    public Connection getDBConnection() {
        try {
            dbConn = DBConnectionPool.getDataSource("postgresql").getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return dbConn;
    }

    public static void main(String args[]){
        getInstance();

    }
}
