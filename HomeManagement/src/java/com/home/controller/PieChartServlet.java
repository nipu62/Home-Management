/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.home.controller;

//import in.webtuts.google.chart.data.FamilyInfoBean;
//import in.webtuts.google.chart.data.FamilyInfoBean.MonthlyReviewEntity; 
import com.home.dao.FamilyInfoBean;
import com.home.model.MonthlyReviewEntity;
import com.home.model.PieChartData;
import com.home.model.PieChartData.KeyValue;

import java.io.IOException;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class PieChartServlet
 */
@WebServlet("/PieChartServlet")
public class PieChartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PieChartServlet() {
        super();
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        List<KeyValue> pieDataList = PieChartData.getPieDataList();
        request.setAttribute("pieDataList", pieDataList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("statistics.jsp");
        requestDispatcher.forward(request, response);
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
    }
 
}