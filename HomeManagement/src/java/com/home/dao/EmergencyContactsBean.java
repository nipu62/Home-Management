/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.dao;

import static com.home.dao.FamilyInfoBean.url;
import com.home.model.BloodGroupEntity;
import com.home.model.EmergencyContactsEntity;
import com.home.utility.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nipu
 */
public class EmergencyContactsBean {

    static String url = DatabaseInfo.DATABASE_URL;
    static String username = DatabaseInfo.DATABASE_USER;
    static String password = DatabaseInfo.DATABASE_PASSWORD;

    String family_name;
    Connection con = null;
    Statement stmt = null;
    Statement statement = null;
    PreparedStatement prst = null;
    ResultSet rs = null;
    private String emergency_id = null;
    

    public EmergencyContactsBean() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    }

    public void addToEmergencyTable(EmergencyContactsEntity emergencycontacts_entity) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            prst = (PreparedStatement) con.prepareStatement("insert into emergency_contacts(emergency_id,emergency_criteria,emergency_contact) values(?,?,?)");
            prst.setString(1, emergencycontacts_entity.getEmergency_id());
            prst.setString(2, emergencycontacts_entity.getEmergency_criteria());
            prst.setString(3, emergencycontacts_entity.getEmergency_contact());
            System.out.println("BEFORE UPDATE");
            prst.executeUpdate();
            System.out.println("AFTER UPDATE");
        } catch (Exception e) {
        } finally {
            con.close();
            prst.close();
        }
    }


    public List<EmergencyContactsEntity> getEmergency() {
        List<EmergencyContactsEntity> list = new ArrayList<EmergencyContactsEntity>();
        
        String query = "SELECT emergency_id, emergency_criteria, emergency_contact from emergency_contacts"; 
        try {
            
            statement = con.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                EmergencyContactsEntity emergency = new EmergencyContactsEntity();
                
                emergency.setEmergency_id(rs.getString("emergency_id"));
                emergency.setEmergency_criteria(rs.getString("emergency_criteria"));
                emergency.setEmergency_contact(rs.getString("emergency_contact"));
                list.add(emergency);
                
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
                con.close();
                
            } catch (SQLException ex) {
            }
        }
        return list;
//To change body of generated methods, choose Tools | Templates.
    }
        void deleteEmergency(int emergency_id) throws ClassNotFoundException, SQLException {
        System.out.println("inside delete method");
        String query = "delete from emergency_contacts where emergency_id=" + emergency_id;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            statement = con.createStatement();

            prst = (PreparedStatement) con.prepareStatement(query);
            prst.executeUpdate();

        } catch (SQLException se) {
            System.out.println("ERRRRRRRRRRRRRRRRRRRROR");
        } finally {

            prst.close();

            con.close();
        }
    }

    public void updateEmergency(EmergencyContactsEntity ece) throws ClassNotFoundException, SQLException {
        
        EmergencyContactsBean dmb = new EmergencyContactsBean();
        System.out.println("HERE IN UPDATE"+ece.getEmergency_id());
        
        int i = Integer.parseInt(ece.getEmergency_id());
        //System.out.println("MEMBER ID : "+i);
        dmb.deleteEmergency(i);
        addToEmergencyTable(ece);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<BloodGroupEntity> getBloodGroup(String select) throws ClassNotFoundException {
        List<BloodGroupEntity> list = new ArrayList<BloodGroupEntity>();
        
        System.out.println("inside list" +select);
        //select = "O+";
        
        //String query = "SELECT member_id, member_name, member_blood_group, member_contact_no from family_info where member_blood_group like ?";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            prst = (PreparedStatement) con.prepareStatement("SELECT member_id, member_name, member_blood_group, member_location, member_contact_no from family_info where member_blood_group like ?");
            
//            statement = con.createStatement();
            
 //           rs = statement.executeQuery(query);
            prst.setString(1, select);
            rs = prst.executeQuery();
            

            while (rs.next()) {
                BloodGroupEntity group = new BloodGroupEntity();
                
                group.setMember_id(rs.getString("member_id"));
                group.setMember_name(rs.getString("member_name"));
                group.setMember_blood_group(rs.getString("member_blood_group"));
                group.setMember_contact_no(rs.getString("member_contact_no"));
                group.setMember_location(rs.getString("member_location"));
                list.add(group);
                
               
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
               // statement.close();
                prst.close();
                con.close();
                
            } catch (SQLException ex) {
            }
        }
        return list;
//To change body of generated methods, choose Tools | Templates.
    }
}
