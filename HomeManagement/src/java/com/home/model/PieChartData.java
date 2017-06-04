/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.model;
import com.home.dao.FamilyInfoBean;
import com.home.utility.DatabaseInfo;
import java.sql.Connection;
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

import java.util.ArrayList;
import java.util.List;

public class PieChartData {
            public static ArrayList<String> list3;
            public static ArrayList<String> list4;
            
    private static final List<KeyValue> pieDataList;

   static {
        
        list3  = FamilyInfoBean.getList1();       
        list4  = FamilyInfoBean.getList2();
        //System.out.println(list3.get(0));
        pieDataList = new ArrayList<PieChartData.KeyValue>();
        //pieDataList.clear();
        
        
            for(int i=0;i<list3.size();i++)
         {
             
                 pieDataList.add(new KeyValue(list3.get(i),list4.get(i)));
               /// pieDataList.add(new KeyValue(list3.get(i),list4.get(i)));
        
             
         }
        
    }
 
    public static List<KeyValue> getPieDataList() {
        return pieDataList;
    }
 
    public static class KeyValue {
        String key;
        String value;
 
        public KeyValue(String key, String value) {
            super();
            this.key = key;
            this.value = value;
        }
 
        public String getKey() {
            return key;
        }
 
        public void setKey(String key) {
            this.key = key;
        }
 
        public String getValue() {
            return value;
        }
 
        public void setValue(String value) {
            this.value = value;
        }
 
    }
}
//public class PieChartData {
//    static String url = DatabaseInfo.DATABASE_URL;
//    static String username = DatabaseInfo.DATABASE_USER;
//    static String password = DatabaseInfo.DATABASE_PASSWORD;
//
//    static String family_name;
//    static Connection con = null;
//    static Statement stmt = null;
//    static Statement statement = null;
//    static PreparedStatement prst = null;
//    static ResultSet rs = null;
//    public static List<MonthlyReviewEntity> getMonthlyReview() {
//
//       // List<MonthlyReviewEntity> list = new ArrayList<MonthlyReviewEntity>();
//        List<MonthlyReviewEntity> pieDataList = new ArrayList<MonthlyReviewEntity>();
//
//        String query = "select (rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense)as 'total',(month_income-(rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense)) as 'month_saving',(((month_income-(rent_expense+food_expense+electricity_expense+gass_expense+water_expense+transport_expense+tution_expense+phone_expense+shopping_expense+cable_expense+internet_expense+utility_expense+travelling_expense))*100)/month_income) as 'month_ratio' ,monthly_review.month_name, month_income from monthly_expenses join monthly_review on monthly_expenses.month_name =monthly_review.month_name";
//        //SELECT Val1,Val2,Val3,(Val1 + Val2 + Val3) as 'Total'FROM Emp
//        
//        try {
//
//            statement = con.createStatement();
//            rs = statement.executeQuery(query);
//            System.out.println("after the query");
//
//            while (rs.next()) {
//                MonthlyReviewEntity review = new MonthlyReviewEntity();
//               
//
//                review.setMonth_name(rs.getString("month_name"));
////                review.setMonth_income(rs.getString("month_income"));
////                review.setMonth_expense(rs.getString("total"));
////                review.setMonth_saving(rs.getString("month_saving"));
//                review.setMonth_ratio(rs.getString("month_ratio"));
//                
//                pieDataList.add(review);
//                System.out.println();
//
//            }
//            
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//
//        } finally {
//            try {
//                statement.close();
//                con.close();
//
//            } catch (SQLException ex) {
//            }
//        }
//        //myObject = new ArrayList<Object>(myTempObject);
//       // public List<MonthlyReviewEntity> newList = new ArrayList<MonthlyReviewEntity>(list);
//        //pieDataList = new ArrayList<MonthlyReviewEntity>(list);
//        
//        return pieDataList;
//        
//    }
//    
//}
