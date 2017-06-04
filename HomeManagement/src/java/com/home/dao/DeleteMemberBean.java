/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.dao;

import com.home.model.DeleteMemberEntity;
import com.home.model.EmergencyContactsEntity;
import com.home.model.FamilyInfoEntity;
import com.home.model.MonthlyExpenseEntity;
import com.home.utility.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DeleteMemberBean {

    static String url = DatabaseInfo.DATABASE_URL;
    static String username = DatabaseInfo.DATABASE_USER;
    static String password = DatabaseInfo.DATABASE_PASSWORD;

    String family_name;
    Connection con = null;
    Statement stmt = null;
    Statement statement = null;
    PreparedStatement prst = null;
    ResultSet rs = null;
    private String log_in_id = null;
    private Object member_collection;

    public DeleteMemberBean(String log_in_id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        this.log_in_id = log_in_id;
    }

    public void delete(int member_id) throws ClassNotFoundException, SQLException {
        System.out.println("inside delete method");
        String query = "delete from family_info where member_id=" + member_id;
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

    public FamilyInfoEntity updateMemberInfo(int member_id) throws SQLException, ClassNotFoundException {

        String query = "SELECT * from family_info where member_id=" + member_id;
        FamilyInfoEntity member = new FamilyInfoEntity();
        try {
            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                member.setLog_in_id(rs.getString("log_in_id"));
                member.setMember_id(rs.getString("member_id"));
                member.setMember_location(rs.getString("member_location"));
                member.setMember_name(rs.getString("member_name"));
                member.setMember_gender(rs.getString("member_gender"));
                member.setMember_age(rs.getString("member_age"));
                member.setMember_occupation(rs.getString("member_occupation"));
                member.setMember_income(rs.getString("member_income"));
                member.setMember_blood_group(rs.getString("member_blood_group"));
                member.setMember_contact_no(rs.getString("member_contact_no"));

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
        return member;

    }

    public EmergencyContactsEntity updateEmergencyInfo(int emergency_id) throws SQLException, ClassNotFoundException {

        String query = "SELECT * from emergency_contacts where emergency_id=" + emergency_id;
        EmergencyContactsEntity emergency = new EmergencyContactsEntity();
        try {
            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                emergency.setEmergency_id(rs.getString("emergency_id"));
                emergency.setEmergency_criteria(rs.getString("emergency_criteria"));
                emergency.setEmergency_contact(rs.getString("emergency_contact"));

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
        return emergency;

    }

    public MonthlyExpenseEntity updateExpenseInfo(int month_id) {
        String query = "SELECT * from monthly_expenses where month_id=" + month_id;
        MonthlyExpenseEntity month = new MonthlyExpenseEntity();
        try {
            statement = con.createStatement();

            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                month.setLog_in_id(rs.getString("log_in_id"));
                month.setMonth_id(rs.getString("month_id"));
                month.setMonth_name(rs.getString("month_name"));
                month.setRent_expense(rs.getString("rent_expense"));
                month.setFood_expense(rs.getString("food_expense"));
                month.setElectricity_expense(rs.getString("electricity_expense"));
                month.setGass_expense(rs.getString("gass_expense"));
                month.setWater_expense(rs.getString("water_expense"));
                month.setTransport_expense(rs.getString("transport_expense"));
                month.setTution_expense(rs.getString("tution_expense"));
                month.setPhone_expense(rs.getString("phone_expense"));
                month.setShopping_expense(rs.getString("shopping_expense"));
                month.setCable_expense(rs.getString("cable_expense"));
                month.setInternet_expense(rs.getString("internet_expense"));
                month.setUtility_expense(rs.getString("utility_expense"));
                month.setTravelling_expense(rs.getString("travelling_expense"));

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
        return month;
    }

    public void updateExpense(MonthlyExpenseEntity monthlyexpense_entity) throws ClassNotFoundException, SQLException {
        FamilyInfoBean dmb = new FamilyInfoBean(log_in_id);
        FamilyInfoBean add = new FamilyInfoBean(log_in_id);
        System.out.println("HERE IN UPDATE kjkjk.jdlka" + monthlyexpense_entity.getMonth_id());

        int i = Integer.parseInt(monthlyexpense_entity.getMonth_id());
        System.out.println("MEMBER ID : " + i);
        dmb.deleteExpense(i);
        
        add.addToExpenseTable(monthlyexpense_entity);
    }

}
