package com.example.dbmethods;

/**
 * Ez a konstansokat tárolja. Nem kell legalább sehol máshol megadni ezeket az adatokat, csak itt
 * 
 * @author tresz
 */
public class AlapadatokDB {
    
    private static final String DATABASE_URL                = "jdbc:mysql://konyvelobt.eu:3306/"; //"jdbc:mysql://localhost:3306/";//"https://databaseurl.db/database"; 
    
    private static final String DATABASEDRIVERMARIADB       = "org.mariadb.jdbc.Driver";
    private static final String DATABASEDRIVERMYSQL         = "com.mysql.cj.jdbc.Driver";
    
    private static final String DBNAME                      = "konyvelo_teszt";//"szamlazo";
    private static final String DBUSERNAME                  = "konyvelo_sql";//"root";
    private static final String DBPASSWORD                  = "konyvelosqladmin";//"";
    
    private static final String DBTABLESZAMLAADATOK         = "szamlaadatok";
    private static final String DBTABLESZAMLATIPUSA         = "szamlatipusa";      
    private static final String DBTABLESZAMLAKKIEGYENLITESE = "szamlakiegyenlitese"; 
    private static final String DBTABLEPENZNEM              = "penznem"; 
    private static final String DBTABLEPARTNEREK            = "partnerek"; 
    private static final String DBTABLEKIEGYENLITES         = "kiegyenlites"; 
    private static final String DBTABLEPROTECT              = "protect";
    private static final String DBTABLEFIZETESIMOD          = "fizetesimod";
  

    public static String getDATABASE_URL() {
        return DATABASE_URL;
    }

    public static String getDATABASEDRIVERMARIADB() {
        return DATABASEDRIVERMARIADB;
    }

    public static String getDATABASEDRIVERMYSQL() {
        return DATABASEDRIVERMYSQL;
    }

    public static String getDBNAME() {
        return DBNAME;
    }

    public static String getDBUSERNAME() {
        return DBUSERNAME;
    }

    public static String getDBPASSWORD() {
        return DBPASSWORD;
    }

    public static String getDBTABLESZAMLAADATOK() {
        return DBTABLESZAMLAADATOK;
    }

    public static String getDBTABLESZAMLATIPUSA() {
        return DBTABLESZAMLATIPUSA;
    }

    public static String getDBTABLESZAMLAKKIEGYENLITESE() {
        return DBTABLESZAMLAKKIEGYENLITESE;
    }

    public static String getDBTABLEPENZNEM() {
        return DBTABLEPENZNEM;
    }

    public static String getDBTABLEPARTNEREK() {
        return DBTABLEPARTNEREK;
    }

    public static String getDBTABLEKIEGYENLITES() {
        return DBTABLEKIEGYENLITES;
    }

    public static String getDBTABLEPROTECT() {
        return DBTABLEPROTECT;
    }

    public static String getDBTABLEFIZETESIMOD() {
        return DBTABLEFIZETESIMOD;
    }

    
    
}
