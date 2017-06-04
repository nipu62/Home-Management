
package com.home.utility;

/**
 *
 * @author UrMeEe
 */

import com.home.utility.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    static String url = DatabaseInfo.DATABASE_URL;
    static String username = DatabaseInfo.DATABASE_USER;
    static String password = DatabaseInfo.DATABASE_PASSWORD;
    Connection con = null;
    Statement stmt = null;
    ResultSet res = null;
    
   public DatabaseConnection() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        //con = DriverManager.getConnection(url, username, password);
        try {
            Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        System.out.println("successful");
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
    }
   public ResultSet getResult(String sql,Connection con){
       try {
           stmt = con.createStatement();
           res = stmt.executeQuery(sql);
       } catch (Exception e) {
       }
        return res;
   }

    public Connection setConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
    
}
