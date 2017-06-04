package com.home.dao;

import com.home.model.BloodGroupEntity;
import com.home.model.EarningMemberEntity;
import com.home.model.EmergencyContactsEntity;
import com.home.model.FamilyInfoEntity;
import com.home.model.MonthlyExpenseEntity;
import com.home.model.MonthlyReviewEntity;
import com.home.utility.DatabaseInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FamilyInfoBean {
    public static ArrayList<String> list1 = new ArrayList<String>();
    public static ArrayList<String> list2 = new ArrayList<String>();
    
    public static ArrayList<String> getList1() {
        return list1;
    }
    
            public static ArrayList<String> getList2() {
    return list2;
    }
    

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
    //private Object member_collection;

    public FamilyInfoBean(String log_in_id) throws ClassNotFoundException, SQLException {
        
                
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        this.log_in_id = log_in_id;
    }

    public void addToFamilyTable(FamilyInfoEntity family_entity) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            prst = (PreparedStatement) con.prepareStatement("insert into family_info(log_in_id,mwmber_location,member_name,member_gender,member_age,member_occupation,member_income,member_blood_group,member_contact_no) values(?,?,?,?,?,?,?,?,?)");
            //System.out.println(family_entity.getLog_in_id());
            prst.setString(1, family_entity.getLog_in_id());
            prst.setString(2, family_entity.getMember_location());
            prst.setString(3, family_entity.getMember_name());
            prst.setString(4, family_entity.getMember_gender());
            prst.setString(5, family_entity.getMember_age());
            prst.setString(6, family_entity.getMember_occupation());
            prst.setString(7, family_entity.getMember_income());
            prst.setString(8, family_entity.getMember_blood_group());
            prst.setString(9, family_entity.getMember_contact_no());

            prst.executeUpdate();

        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            con.close();
            prst.close();
        }

    }
    

    public List<FamilyInfoEntity> getMember() {
        List<FamilyInfoEntity> list = new ArrayList<FamilyInfoEntity>();
        

        String query = "SELECT log_in_id,member_id,member_location,member_name,member_gender,member_age,member_occupation,member_income,member_blood_group,member_contact_no from family_info where log_in_id=" + log_in_id;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while (rs.next()) {
                FamilyInfoEntity member = new FamilyInfoEntity();
                
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
                
                list.add(member);
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
    }

    public void update(FamilyInfoEntity fie) throws ClassNotFoundException, SQLException {
        DeleteMemberBean dmb = new DeleteMemberBean(log_in_id);
        System.out.println("HERE IN UPDATE" + fie.getMember_id());

        int i = Integer.parseInt(fie.getMember_id());
        System.out.println("MEMBER ID : " + i);
        dmb.delete(i);
        addToFamilyTable(fie);
    }

    public List<EarningMemberEntity> getEarningMember() {
        List<EarningMemberEntity> list = new ArrayList<EarningMemberEntity>();

        String query = "SELECT log_in_id,member_id, member_name, member_occupation, member_income from family_info where member_income != 0 and log_in_id=" + log_in_id;
        try {

             statement = con.createStatement();
            rs = statement.executeQuery(query);

            while (rs.next()) {
                EarningMemberEntity earningmember = new EarningMemberEntity();
                earningmember.setLog_in_id(rs.getString("log_in_id"));
                earningmember.setId(rs.getString("member_id"));
                earningmember.setEarningmember_name(rs.getString("member_name"));
                earningmember.setEarningmember_occupation(rs.getString("member_occupation"));
                earningmember.setEarningmember_income(rs.getString("member_income"));
                list.add(earningmember);

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

    public void addToExpenseTable(MonthlyExpenseEntity monthlyexpense_entity) throws ClassNotFoundException, SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();
            
//                select * from monthly_expences where log_inid=? and month_name = ?;
//                
            prst = (PreparedStatement) con.prepareStatement("insert into monthly_expenses(log_in_id,month_name,rent_expense,food_expense,electricity_expense,gass_expense,water_expense,transport_expense,tution_expense,phone_expense,shopping_expense,cable_expense,internet_expense,utility_expense,travelling_expense) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            //System.out.println("before update");
            //System.out.println(monthlyexpense_entity.getLog_in_id());
            prst.setString(1, monthlyexpense_entity.getLog_in_id());
            prst.setString(2, monthlyexpense_entity.getMonth_name());
            prst.setString(3, monthlyexpense_entity.getRent_expense());
            prst.setString(4, monthlyexpense_entity.getFood_expense());
            prst.setString(5, monthlyexpense_entity.getElectricity_expense());
            prst.setString(6, monthlyexpense_entity.getGass_expense());
            prst.setString(7, monthlyexpense_entity.getWater_expense());
            prst.setString(8, monthlyexpense_entity.getTransport_expense());
            prst.setString(9, monthlyexpense_entity.getTution_expense());
            prst.setString(10, monthlyexpense_entity.getPhone_expense());
            prst.setString(11, monthlyexpense_entity.getShopping_expense());
            prst.setString(12, monthlyexpense_entity.getCable_expense());
            prst.setString(13, monthlyexpense_entity.getInternet_expense());
            prst.setString(14, monthlyexpense_entity.getUtility_expense());
            prst.setString(15, monthlyexpense_entity.getTravelling_expense());
            
            

            prst.executeUpdate();
            System.out.println(monthlyexpense_entity.getLog_in_id());
            System.out.println("after update" + monthlyexpense_entity.getMonth_id());

        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            con.close();
            prst.close();
        }
    }

    public List<MonthlyExpenseEntity> getExpense() {
        List<MonthlyExpenseEntity> list = new ArrayList<MonthlyExpenseEntity>();

        String query = "SELECT log_in_id,month_id,month_name,rent_expense,food_expense,electricity_expense,gass_expense,water_expense,transport_expense,tution_expense,phone_expense,shopping_expense,cable_expense,internet_expense,utility_expense,travelling_expense from monthly_expenses where log_in_id=" + log_in_id;
        try {
            statement = con.createStatement();
            ResultSet rs = statement.executeQuery(query);
            System.out.println("CAME HERE IN EXPENSE");
            while (rs.next()) {
                MonthlyExpenseEntity expense = new MonthlyExpenseEntity();
                System.out.println("INSIDE while");
                expense.setLog_in_id(rs.getString("log_in_id"));
                expense.setMonth_id(rs.getString("month_id"));
                expense.setMonth_name(rs.getString("month_name"));
                expense.setRent_expense(rs.getString("rent_expense"));
                expense.setFood_expense(rs.getString("food_expense"));
                expense.setElectricity_expense(rs.getString("electricity_expense"));
                expense.setGass_expense(rs.getString("gass_expense"));
                expense.setWater_expense(rs.getString("water_expense"));
                expense.setTransport_expense(rs.getString("transport_expense"));
                expense.setTution_expense(rs.getString("tution_expense"));
                expense.setPhone_expense(rs.getString("phone_expense"));
                expense.setShopping_expense(rs.getString("shopping_expense"));
                expense.setCable_expense(rs.getString("cable_expense"));
                expense.setInternet_expense(rs.getString("internet_expense"));
                expense.setUtility_expense(rs.getString("utility_expense"));
                expense.setTravelling_expense(rs.getString("travelling_expense"));
                list.add(expense);
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
    }

    public List<MonthlyReviewEntity> getMonthlyReview() {

        List<MonthlyReviewEntity> list = new ArrayList<MonthlyReviewEntity>();
        //List<MonthlyReviewEntity> pieDataList = new ArrayList<MonthlyReviewEntity>();

        String query = "select (rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense)as 'total',(month_income-(rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense)) as 'month_saving',(((month_income-(rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense))*100)/month_income) as 'month_ratio' , monthly_review.log_in_id,monthly_review.month_name,monthly_review.review_id, month_income from monthly_expenses join monthly_review on monthly_expenses.month_name =monthly_review.month_name  where monthly_review.log_in_id=" + log_in_id;
        //SELECT Val1,Val2,Val3,(Val1 + Val2 + Val3) as 'Total'FROM Emp
        
        try {

            statement = con.createStatement();
            rs = statement.executeQuery(query);
            System.out.println("after the query");
            list1.clear();
            list2.clear();
            while (rs.next()) {
                MonthlyReviewEntity review = new MonthlyReviewEntity();
                review.setLog_in_id(rs.getString("log_in_id"));
                review.setReview_id(rs.getString("review_id"));
                review.setMonth_name(rs.getString("month_name"));
                review.setMonth_income(rs.getString("month_income"));
                review.setMonth_expense(rs.getString("total"));
                review.setMonth_saving(rs.getString("month_saving"));
                review.setMonth_ratio(rs.getString("month_ratio"));
                   list1.add(rs.getString("month_name"));
                   list2.add(rs.getString("month_ratio"));
        
                list.add(review);

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
        //myObject = new ArrayList<Object>(myTempObject);
       // public List<MonthlyReviewEntity> newList = new ArrayList<MonthlyReviewEntity>(list);
        //pieDataList = new ArrayList<MonthlyReviewEntity>(list);
        
        return list;
        
    }
    private List<MonthlyReviewEntity> pieDataList;
    
    //public List<MonthlyReviewEntity> newList = new ArrayList<MonthlyReviewEntity>(list);

    public void addToReviewTable(MonthlyReviewEntity monthlyreview_entity) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            stmt = con.createStatement();

            prst = (PreparedStatement) con.prepareStatement("insert into monthly_review(log_in_id,month_name,month_income) values (?,?,?)");
            System.out.println(monthlyreview_entity.getLog_in_id());
            System.out.println("inside add to review table");
            
            prst.setString(1, monthlyreview_entity.getLog_in_id());
            prst.setString(2, monthlyreview_entity.getMonth_name());
            prst.setString(3, monthlyreview_entity.getMonth_income());
            
//            prst.setString(3, monthlyreview_entity.getMonth_saving());
//            prst.setString(4, monthlyreview_entity.getMonth_ratio());

            prst.executeUpdate();
            System.out.println("after review");

        } catch (ClassNotFoundException | SQLException e) {
        } finally {
            con.close();
            prst.close();
        }
    }

    public void deleteReview(int review_id) throws ClassNotFoundException, SQLException {
        
        System.out.println("inside delete method");
        String query = "delete from monthly_review where review_id=" + review_id;
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

    public void deleteExpense(int month_id) throws ClassNotFoundException, SQLException {
     System.out.println("urmee,,,,,," + month_id);
        String query = "delete from monthly_expenses where month_id=" + month_id;
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

    

}
