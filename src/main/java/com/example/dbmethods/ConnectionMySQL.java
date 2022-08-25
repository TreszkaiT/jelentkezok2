package com.example.dbmethods;

//Importing SQL libraries to create database
import java.sql.*;
import java.util.logging.Logger;
/**
*
* @author tresz
*/
public class ConnectionMySQL {
 
 Connection con = null;
 
 private static final String DATABASE_URL            = AlapadatokDB.getDATABASE_URL();
 private static final String DATABASEDRIVERMYSQL     = AlapadatokDB.getDATABASEDRIVERMYSQL();
 
 public static Connection connectDB(String dbName, String dbUserName, String dbPassword, String dbTable1) throws ClassNotFoundException

 {

     try {
         Class.forName(DATABASEDRIVERMYSQL);//"com.mysql.jdbc.Driver"); // --- ez volt a régi driver, már nem jó
     } catch (ClassNotFoundException ex) {
         Logger.getLogger(dbTable1).severe("nincs meg az adatbázis-driver");
     }  
     
     try {
         // Importing and registering drivers
         //Class.forName("com.mysql.jdbc.Driver");

         Connection con = DriverManager.getConnection(DATABASE_URL+dbName, dbUserName, dbPassword);

         return con;
     }
     catch (SQLException e) {

         Logger.getLogger(dbTable1).severe("Nem tudok csatlakozni az adatbázishoz: "+dbName);
     }
     return null;
 }    
}
