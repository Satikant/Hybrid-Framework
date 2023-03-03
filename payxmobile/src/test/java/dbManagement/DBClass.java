package dbManagement;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DBClass {

    protected String DRIVER_NAME,DB_URL,DB_PORT,DB_USERNAME, DB_PASSWD, DB_IP,DB_SID;
    protected Connection dbConn;

    public abstract Connection getDBConnection() throws SQLException;
}