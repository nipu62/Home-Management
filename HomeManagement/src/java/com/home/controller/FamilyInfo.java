package com.home.controller;

import com.home.dao.DeleteMemberBean;
import com.home.dao.EmergencyContactsBean;
import com.home.dao.FamilyInfoBean;
import com.home.model.BloodGroupEntity;
import com.home.model.DeleteMemberEntity;
import com.home.model.EarningMemberEntity;
import com.home.model.EmergencyContactsEntity;
import com.home.model.FamilyInfoEntity;
import com.home.model.MonthlyExpenseEntity;
import com.home.model.MonthlyReviewEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "FamilyInfo", urlPatterns = {"/FamilyInfo", "/InsertData", "/DeleteMember", "/EmergencyContacts", "/EditMember", "/EditedMember", "/EditEmergency",
    "/EditedEmergency", "/EarningMember", "/MonthelyExpense", "/InsertExpense", "/MonthlyReview", "/InsertReview", "/DeleteMonth",
    "/DeleteExpense", "/SearchBloodGroup", "/InsertBloodGroup","/EditExpense","/EditedExpense"})
public class FamilyInfo extends HttpServlet {

    public static String select = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String log_in_id = (String) session.getAttribute("log_in_id");
        String family_location = (String) session.getAttribute("family_location");

        FamilyInfoBean member = new FamilyInfoBean(log_in_id);
        DeleteMemberBean delete_member = new DeleteMemberBean(log_in_id);
        DeleteMemberBean edit_member = new DeleteMemberBean(log_in_id);
        DeleteMemberBean edit_expense = new DeleteMemberBean(log_in_id);
        EmergencyContactsBean emergency = new EmergencyContactsBean();
        FamilyInfoBean earningmember = new FamilyInfoBean(log_in_id);
        FamilyInfoBean expense = new FamilyInfoBean(log_in_id);
        FamilyInfoBean review = new FamilyInfoBean(log_in_id);
        FamilyInfoBean delete_review = new FamilyInfoBean(log_in_id);
        FamilyInfoBean delete_expense = new FamilyInfoBean(log_in_id);
        EmergencyContactsBean blood_group = new EmergencyContactsBean();

        try (PrintWriter out = response.getWriter()) {
            System.out.println("URL: " + request.getServletPath());
            if (request.getServletPath().equals("/InsertData")) {

                FamilyInfoEntity familyinfo_entity = new FamilyInfoEntity();

                log_in_id = String.valueOf(request.getSession().getAttribute("log_in_id"));
                family_location = String.valueOf(request.getSession().getAttribute("family_location"));
                //String family_name = String.valueOf(request.getSession().getAttribute("family_name"));
                String member_name = request.getParameter("member_name");
                String member_gender = request.getParameter("member_gender");
                String member_age = request.getParameter("member_age");
                String member_occupation = request.getParameter("member_occupation");
                String member_income = request.getParameter("member_income");
                int value = Integer.parseInt(member_income);
                String member_blood_group = request.getParameter("member_blood_group");
                String member_contact_no = request.getParameter("member_contact_no");

                familyinfo_entity.setLog_in_id(log_in_id);
                familyinfo_entity.setFamily_location(family_location);
                familyinfo_entity.setMember_name(member_name);
                familyinfo_entity.setMember_gender(member_gender);
                familyinfo_entity.setMember_age(member_age);
                familyinfo_entity.setMember_occupation(member_occupation);
                familyinfo_entity.setMember_income(member_income);
                familyinfo_entity.setMember_blood_group(member_blood_group);
                familyinfo_entity.setMember_contact_no(member_contact_no);

                try {
                    try {

                        new FamilyInfoBean(log_in_id).addToFamilyTable(familyinfo_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("/HomeManagement/FamilyInfo");

            } else if (request.getServletPath().equals("/DeleteMember")) {
                System.out.println("inside deleteservlet");
                if (request.getParameter("member_id") != null) {
                    System.out.println("MEMBER ID" + request.getParameter("member_id"));
                    int member_id = Integer.parseInt(request.getParameter("member_id"));
                    delete_member.delete(member_id);
//                    response.sendRedirect("/HomeManagement/FamilyInfo");
                }
                response.sendRedirect("/HomeManagement/FamilyInfo");

            } else if (request.getServletPath().equals("/EditMember")) {
                System.out.println("inside Editservlet");
                if (request.getParameter("member_id") != null) {
                    int member_id = Integer.parseInt(request.getParameter("member_id"));
                    FamilyInfoEntity list = edit_member.updateMemberInfo(member_id);
                    request.setAttribute("member", list);
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/editmember.jsp");
                    System.out.println("inside EDIT page");
                    rd.forward(request, response);
                } else {
                    System.out.println("ERROR IN EDIT");
                }

            }
            else if (request.getServletPath().equals("/EditExpense")) {
                System.out.println("inside Editservlet");
                if (request.getParameter("month_id") != null) {
                    int month_id = Integer.parseInt(request.getParameter("month_id"));
                    System.out.println("edit expense : " +month_id);
                    MonthlyExpenseEntity list = edit_expense.updateExpenseInfo(month_id);
                    request.setAttribute("expense", list);
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/editexpense.jsp");
                    
                    System.out.println("inside EDIT page");
                    rd.forward(request, response);
                } else {
                    System.out.println("ERROR IN EDIT");
                }

            }
            else if (request.getServletPath().equals("/EditEmergency")) {
                System.out.println("inside Editservlet");
                if (request.getParameter("emergency_id") != null) {
                    int emergency_id = Integer.parseInt(request.getParameter("emergency_id"));
                    EmergencyContactsEntity list = edit_member.updateEmergencyInfo(emergency_id);
                    request.setAttribute("emergency", list);
                    ServletContext sc = getServletContext();
                    RequestDispatcher rd = sc.getRequestDispatcher("/editemergency.jsp");
                    System.out.println("inside EDIT page");
                    rd.forward(request, response);
                } else {
                    System.out.println("ERROR IN EDIT");
                }

            }else if (request.getServletPath().equals("/EditedMember")) {
                FamilyInfoEntity familyinfo_entity = new FamilyInfoEntity();
                log_in_id = String.valueOf(request.getSession().getAttribute("log_in_id"));
                String family_name = String.valueOf(request.getSession().getAttribute("family_name"));
                String member_name = request.getParameter("member_name");
                String member_gender = request.getParameter("member_gender");
                String member_age = request.getParameter("member_age");
                String member_occupation = request.getParameter("member_occupation");
                String member_income = request.getParameter("member_income");
                int value = Integer.parseInt(member_income);
                String member_blood_group = request.getParameter("member_blood_group");
                String member_contact_no = request.getParameter("member_contact_no");
                String member_id = request.getParameter("member_id");
                familyinfo_entity.setLog_in_id(log_in_id);
                familyinfo_entity.setFamily_location(family_location);
                familyinfo_entity.setMember_name(member_name);
                familyinfo_entity.setMember_gender(member_gender);
                familyinfo_entity.setMember_age(member_age);
                familyinfo_entity.setMember_occupation(member_occupation);
                familyinfo_entity.setMember_income(member_income);
                familyinfo_entity.setMember_blood_group(member_blood_group);
                familyinfo_entity.setMember_contact_no(member_contact_no);
                familyinfo_entity.setMember_id(member_id);

                try {
                    try {

                        new FamilyInfoBean(log_in_id).update(familyinfo_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("/HomeManagement/FamilyInfo");

            } else if (request.getServletPath().equals("/EmergencyContacts")) {
                System.out.println("Emergency Contacts HERE");
                List<EmergencyContactsEntity> list = emergency.getEmergency();
                request.setAttribute("ContactList", list);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/emergencycontacts.jsp");
                System.out.println("inside emergency page");
                rd.forward(request, response);

            }  else if (request.getServletPath().equals("/EditedEmergency")) {
                EmergencyContactsEntity emergencycontacts_entity = new EmergencyContactsEntity();

                String emergency_id = request.getParameter("emergency_id");
                String emergency_criteria = request.getParameter("emergency_criteria");
                String emergency_contact = request.getParameter("emergency_contact");
                emergencycontacts_entity.setEmergency_id(emergency_id);
                emergencycontacts_entity.setEmergency_criteria(emergency_criteria);
                emergencycontacts_entity.setEmergency_contact(emergency_contact);
                try {
                    try {

                        new EmergencyContactsBean().updateEmergency(emergencycontacts_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

                response.sendRedirect("/HomeManagement/EmergencyContacts");

            } 
            else if (request.getServletPath().equals("/EditedExpense")) {
                MonthlyExpenseEntity monthlyexpense_entity = new MonthlyExpenseEntity();
                log_in_id = String.valueOf(request.getSession().getAttribute("log_in_id"));
                String month_id = request.getParameter("month_id");
                String month_name = request.getParameter("month_name");
                String rent_expense = request.getParameter("rent_expense");
                //System.out.println("RENT EXPENSE" +rent_expense);
                int rent = Integer.parseInt(rent_expense);
                // System.out.println("After parsing: "+rent);
                String food_expense = request.getParameter("food_expense");
                int value2 = Integer.parseInt(food_expense);
                String electricity_expense = request.getParameter("electricity_expense");
                int value3 = Integer.parseInt(electricity_expense);
                String gass_expense = request.getParameter("gass_expense");
                int value4 = Integer.parseInt(gass_expense);
                String water_expense = request.getParameter("water_expense");
                int value5 = Integer.parseInt(water_expense);
                String transport_expense = request.getParameter("transport_expense");
                int value6 = Integer.parseInt(transport_expense);
                String tution_expense = request.getParameter("tution_expense");
                int value7 = Integer.parseInt(tution_expense);
                String phone_expense = request.getParameter("phone_expense");
                int value8 = Integer.parseInt(phone_expense);
                String shopping_expense = request.getParameter("shopping_expense");
                int value9 = Integer.parseInt(shopping_expense);
                String cable_expense = request.getParameter("cable_expense");
                int value10 = Integer.parseInt(cable_expense);
                String internet_expense = request.getParameter("internet_expense");
                int value11 = Integer.parseInt(internet_expense);
                String utility_expense = request.getParameter("utility_expense");
                int value12 = Integer.parseInt(utility_expense);
                String travelling_expense = request.getParameter("travelling_expense");
                int value13 = Integer.parseInt(travelling_expense);

                monthlyexpense_entity.setLog_in_id(log_in_id);
                monthlyexpense_entity.setMonth_id(month_id);
                monthlyexpense_entity.setMonth_name(month_name);
                monthlyexpense_entity.setRent_expense(rent_expense);
                monthlyexpense_entity.setFood_expense(food_expense);
                monthlyexpense_entity.setElectricity_expense(electricity_expense);
                monthlyexpense_entity.setGass_expense(gass_expense);
                monthlyexpense_entity.setWater_expense(water_expense);
                monthlyexpense_entity.setTransport_expense(transport_expense);
                monthlyexpense_entity.setTution_expense(tution_expense);
                monthlyexpense_entity.setPhone_expense(phone_expense);
                monthlyexpense_entity.setShopping_expense(shopping_expense);
                monthlyexpense_entity.setCable_expense(cable_expense);
                monthlyexpense_entity.setInternet_expense(internet_expense);
                monthlyexpense_entity.setUtility_expense(utility_expense);
                monthlyexpense_entity.setTravelling_expense(travelling_expense);
                System.out.println("hhghadss" +month_id);


                try {
                    try {

                        new DeleteMemberBean(log_in_id).updateExpense(monthlyexpense_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }

                
                response.sendRedirect("/HomeManagement/MonthelyExpense");

            }
            
            else if (request.getServletPath().equals("/FamilyInfo")) {

                List<FamilyInfoEntity> list = member.getMember();
                request.setAttribute("MemberList", list);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/familyinfo.jsp");
                rd.forward(request, response);

            } else if (request.getServletPath().equals("/EarningMember")) {
                System.out.println("Emergency Contacts HERE");
                List<EarningMemberEntity> list = earningmember.getEarningMember();
                request.setAttribute("EarningList", list);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/earningmembers.jsp");
                System.out.println("inside emergency page");
                rd.forward(request, response);

            } else if (request.getServletPath().equals("/InsertExpense")) {

                MonthlyExpenseEntity monthlyexpense_entity = new MonthlyExpenseEntity();
                log_in_id = String.valueOf(request.getSession().getAttribute("log_in_id"));

                String month_id = request.getParameter("month_id");
                String month_name = request.getParameter("month_name");
                String rent_expense = request.getParameter("rent_expense");
                //System.out.println("RENT EXPENSE" +rent_expense);
                int rent = Integer.parseInt(rent_expense);
                // System.out.println("After parsing: "+rent);
                String food_expense = request.getParameter("food_expense");
                int value2 = Integer.parseInt(food_expense);
                String electricity_expense = request.getParameter("electricity_expense");
                int value3 = Integer.parseInt(electricity_expense);
                String gass_expense = request.getParameter("gass_expense");
                int value4 = Integer.parseInt(gass_expense);
                String water_expense = request.getParameter("water_expense");
                int value5 = Integer.parseInt(water_expense);
                String transport_expense = request.getParameter("transport_expense");
                int value6 = Integer.parseInt(transport_expense);
                String tution_expense = request.getParameter("tution_expense");
                int value7 = Integer.parseInt(tution_expense);
                String phone_expense = request.getParameter("phone_expense");
                int value8 = Integer.parseInt(phone_expense);
                String shopping_expense = request.getParameter("shopping_expense");
                int value9 = Integer.parseInt(shopping_expense);
                String cable_expense = request.getParameter("cable_expense");
                int value10 = Integer.parseInt(cable_expense);
                String internet_expense = request.getParameter("internet_expense");
                int value11 = Integer.parseInt(internet_expense);
                String utility_expense = request.getParameter("utility_expense");
                int value12 = Integer.parseInt(utility_expense);
                String travelling_expense = request.getParameter("travelling_expense");
                int value13 = Integer.parseInt(travelling_expense);

                monthlyexpense_entity.setLog_in_id(log_in_id);
                //monthlyexpense_entity.setMonth_id(month_id);
                monthlyexpense_entity.setMonth_name(month_name);
                monthlyexpense_entity.setRent_expense(rent_expense);
                monthlyexpense_entity.setFood_expense(food_expense);
                monthlyexpense_entity.setElectricity_expense(electricity_expense);
                monthlyexpense_entity.setGass_expense(gass_expense);
                monthlyexpense_entity.setWater_expense(water_expense);
                monthlyexpense_entity.setTransport_expense(transport_expense);
                monthlyexpense_entity.setTution_expense(tution_expense);
                monthlyexpense_entity.setPhone_expense(phone_expense);
                monthlyexpense_entity.setShopping_expense(shopping_expense);
                monthlyexpense_entity.setCable_expense(cable_expense);
                monthlyexpense_entity.setInternet_expense(internet_expense);
                monthlyexpense_entity.setUtility_expense(utility_expense);
                monthlyexpense_entity.setTravelling_expense(travelling_expense);

                try {
                    try {

                        new FamilyInfoBean(log_in_id).addToExpenseTable(monthlyexpense_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(" Before Monthly Expense");

                response.sendRedirect("/HomeManagement/MonthelyExpense");
                //System.out.println(" After Monthly Expense");
            } else if (request.getServletPath().equals("/MonthelyExpense")) {
                System.out.println("HERE IN MONTHLY EXPENSE Controller");
                List<MonthlyExpenseEntity> list = expense.getExpense();
                request.setAttribute("ExpenseList", list);
                ServletContext sc = getServletContext();

                RequestDispatcher rd = sc.getRequestDispatcher("/monthelyexpense.jsp");
                rd.forward(request, response);

            } else if (request.getServletPath().equals("/InsertReview")) {

                MonthlyReviewEntity monthlyreview_entity = new MonthlyReviewEntity();

                log_in_id = String.valueOf(request.getSession().getAttribute("log_in_id"));
                System.out.println(monthlyreview_entity.getLog_in_id());
                System.out.println("insertreview");

                //String review_id = request.getParameter("review_id");
                String month_name = request.getParameter("month_name");
                String month_income = request.getParameter("month_income");

                int value = Integer.parseInt(month_income);

                //monthlyreview_entity.setReview_id(review_id);
                monthlyreview_entity.setLog_in_id(log_in_id);
                monthlyreview_entity.setMonth_name(month_name);
                monthlyreview_entity.setMonth_income(month_income);

                try {
                    try {

                        new FamilyInfoBean(log_in_id).addToReviewTable(monthlyreview_entity);

                        //response.sendRedirect("home.jsp");
                    } catch (SQLException ex) {
                        Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                //System.out.println(" Before Monthly Expense");

                response.sendRedirect("/HomeManagement/MonthlyReview");
                //System.out.println(" After Monthly Expense");
            } else if (request.getServletPath().equals("/MonthlyReview")) {
                System.out.println("Emergency Contacts HERE");

                List<MonthlyReviewEntity> list = review.getMonthlyReview();

                request.setAttribute("ReviewList", list);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/review.jsp");
                //System.out.println("inside emergency page");
                rd.forward(request, response);

            } else if (request.getServletPath().equals("/DeleteMonth")) {
                System.out.println("inside deletemonthservlet");
                if (request.getParameter("review_id") != null) {
                    System.out.println("REview ID" + request.getParameter("review_id"));
                    int review_id = Integer.parseInt(request.getParameter("review_id"));
                    delete_review.deleteReview(review_id);
//                    response.sendRedirect("/HomeManagement/FamilyInfo");
                }
                response.sendRedirect("/HomeManagement/MonthlyReview");

            } else if (request.getServletPath().equals("/DeleteExpense")) {
                System.out.println("inside deletemonthservlet");
                if (request.getParameter("month_id") != null) {
                    System.out.println("REview ID" + request.getParameter("month_id"));
                    int month_id = Integer.parseInt(request.getParameter("month_id"));
                    delete_expense.deleteExpense(month_id);
//                    response.sendRedirect("/HomeManagement/FamilyInfo");
                }
                response.sendRedirect("/HomeManagement/MonthelyExpense");

            } else if (request.getServletPath().equals("/InsertBloodGroup")) {

                select = request.getParameter("selectbox");
                System.out.println("group: " + select);
                session = request.getSession();
                session.setAttribute("select", select);
                //request.setAttribute("select", select);
//                RequestDispatcher rd = request.getRequestDispatcher("/HomeManagement/SearchBloodGroup");
//                rd.forward(request, response);

                response.sendRedirect("/HomeManagement/SearchBloodGroup");
                //System.out.println(" After Monthly Expense");
            } else if (request.getServletPath().equals("/SearchBloodGroup")) {
                session = request.getSession();
                String select = (String) session.getAttribute("select");
                //select = (String) request.getAttribute("select");
                //System.out.println("");
                List<BloodGroupEntity> list = blood_group.getBloodGroup(select);

                request.setAttribute("GroupList", list);
                ServletContext sc = getServletContext();
                RequestDispatcher rd = sc.getRequestDispatcher("/bloodgroup.jsp");
                //System.out.println("inside emergency page");
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FamilyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(FamilyInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
