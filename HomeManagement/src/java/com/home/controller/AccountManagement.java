/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.controller;

import com.home.dao.RegistrationBean;
import com.home.model.RegistrationEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author UrMeEe
 */
@WebServlet(name = "AccountManagement", urlPatterns = {"/AccountManagement", "/LogInCheckJSP","/CreateAccount","/Logout"})
public class AccountManagement extends HttpServlet {
    private String validation;
    

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            if (request.getServletPath().equals("/CreateAccount")) {

            RegistrationEntity reg_entity = new RegistrationEntity();
            String user = request.getParameter("username");
            String password = request.getParameter("password");
            String family_location = request.getParameter("family_location");

            reg_entity.setUsername(user);
            reg_entity.setPassword(password);
            reg_entity.setFamily_location(family_location);

            try {
                try {
                    new RegistrationBean().addToRegistrationTable(reg_entity);
                } catch (SQLException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
            }

            response.sendRedirect("index.jsp");
            
            
        }else if (request.getServletPath().equals("/LogInCheckJSP")) {
               
               
                String user = request.getParameter("username");
                String pass = request.getParameter("password");
                String loginid = request.getParameter("log_in_id");
                String family_location = request.getParameter("family_location");
                
                
                RegistrationBean loginBean;
                try {
                    loginBean = new RegistrationBean();
                    validation = loginBean.validate(user, pass);
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AccountManagement.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                if(validation!=null) {
                    
                    session.setAttribute("name", user);
                    session.setAttribute("log_in_id", validation);
                    session.setAttribute("family_location", family_location);
                    
                    
                    response.sendRedirect("/HomeManagement/FamilyInfo");
                } else {
                    request.setAttribute("error", "Invalid username or password");
                    RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
                    dispatcher.forward(request,response);
                }
                
        }else if (request.getServletPath().equals("/Logout")){
            session.setAttribute("name", null);
            response.sendRedirect("index.jsp");
        } 
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
