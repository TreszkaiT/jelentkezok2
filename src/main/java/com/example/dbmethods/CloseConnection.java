package com.example.dbmethods;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

/**
 *
 * @author tresz
 */
public class CloseConnection {
    
    public static void CloseConn(Connection con){
        
        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger("sqllezaras").severe("Nem tudom lezárni az adatbázist!");
            }
        }
    }
}
