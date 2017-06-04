package com.home.dao;

import com.home.model.RegistrationEntity;
import com.home.utility.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author UrMeEe
 */
public class RegistrationBean {

    static String url = DatabaseInfo.DATABASE_URL;
    static String username = DatabaseInfo.DATABASE_USER;
    static String password = DatabaseInfo.DATABASE_PASSWORD;

    private String family_name;
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst;
    ResultSet rs;
    String log_in_id;
    PreparedStatement ps_registration;

    public RegistrationBean() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    }

    public String validate(String user, String pass) throws SQLException {
        try {
            pst = (PreparedStatement) con.prepareStatement("select log_in_id from authentication_reg where username=? and password=?");
            pst.setString(1, user);
            pst.setString(2, pass);

            rs = pst.executeQuery();
            while (rs.next()) {
                log_in_id = rs.getString("log_in_id");
            }
        } catch (SQLException se) {
            return null;
        } finally {
            con.close();
        }
        return log_in_id;
    }

    public void addToRegistrationTable(RegistrationEntity reg_entity) throws SQLException {
        try {
            ps_registration = (PreparedStatement) con.prepareStatement("insert into authentication_reg(username,password,family_location) values(?,?,?)");
            ps_registration.setString(1, reg_entity.getUsername());
            ps_registration.setString(2, reg_entity.getPassword());
            ps_registration.setString(3, reg_entity.getFamily_location());

            ps_registration.executeUpdate();

        } catch (SQLException se) {
        } finally {
            con.close();
            ps_registration.close();
        }
    }

}
