package com.example.dbmethods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author tresz
 */
public class ConnectionMySQLMariadb {
    
    static Connection con = null;
    
    private static final String DATABASE_URL                = AlapadatokDB.getDATABASE_URL();
    private static final String DATABASEDRIVERMARIADB       = AlapadatokDB.getDATABASEDRIVERMARIADB();
    
    public static Connection connectDB(String dbName, String dbUserName, String dbPassword, String dbTable1) throws ClassNotFoundException
 
    {
        
        try {
            Class.forName(DATABASEDRIVERMARIADB);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(dbTable1).severe("nincs meg az adatbázis-driver");
        }        
 
        try {
            // Importing and registering drivers
            //Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(DATABASE_URL+dbName, dbUserName, dbPassword);
            return con;
        }
        catch (SQLException e) {
 
            Logger.getLogger(dbTable1).severe("Nem tudok csatlakozni az adatbázishoz: "+dbName);
        }
        return null;
    }     
}
