package dbManagement;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;
import java.sql.SQLException;

public class DBConnectionPool {

    private static DataSource dataSource;
    private static DBClass dbClass;


    public static DataSource setupDataSource(String driverName, String dbURL, String uName, String password) {
        ComboPooledDataSource cpds = new ComboPooledDataSource();
        try {
            cpds.setDriverClass(driverName);

            cpds.setJdbcUrl(dbURL);
            cpds.setUser(uName);
            cpds.setPassword(password);
            cpds.setMinPoolSize(2);
            cpds.setAcquireIncrement(2);
            cpds.setMaxPoolSize(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cpds;
    }


    public static DataSource getDataSource(String db) throws SQLException {
        DataSource dt = null;
        //InitialContext ic = null;
        try {
            if (db.trim().equals("oracle")) {
               // dbClass = MoneyDB.getInstance();
                dbClass=  WalletDB.getInstance();
                dt = setupDataSource(dbClass.DRIVER_NAME, dbClass.DB_URL, dbClass.DB_USERNAME, dbClass.DB_PASSWD);
            } else if (db.trim().equals("postgresql")) {
                dbClass = MobileAppMgrDB.getInstance();
                dt = setupDataSource(dbClass.DRIVER_NAME, dbClass.DB_URL, dbClass.DB_USERNAME, dbClass.DB_PASSWD);
            } else {
                System.out.println("DB type is not mentioned in. Please select the Valid DB");
            }
            return dt;
        } catch (Exception n) {
            throw new SQLException("Err getDataSource (ServiceLocator) NamingException - " + n.getMessage());
        }
    }

}
