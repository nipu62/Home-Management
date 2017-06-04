<%@page import="java.util.*"%>	
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Google Chart - Servlet 3</title>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<script type="text/javascript">
    // Load the Visualization API and the piechart package.
    google.load('visualization', '1.0', {
        'packages' : [ 'corechart' ]
    });
 
    // Set a callback to run when the Google Visualization API is loaded.
    google.setOnLoadCallback(drawChart);
 
    // Callback that creates and populates a data table,
    // instantiates the pie chart, passes in the data and
    // draws it.
    function drawChart() {
 
        // Create the data table.
        //var data = new google.visualization.DataTable();
        //data.addColumn('string', 'Topping');
        //data.addColumn('number', 'Slices');
        /*data.addRows([
                    <c:forEach items="${pieDataMap}" var="entry">
                        [ '${entry.month_name}', ${entry.month_ratio} ],
                    </c:forEach>
                    ]);*/        
                                                        
var data = google.visualization.arrayToDataTable([
                                                              ['Country', 'Area(square km)'],
                                                              <c:forEach items="${pieDataList}" var="entry">
                                                                  [ '${entry.key}', ${entry.value} ],
                                                              </c:forEach>
                                                        ]);
 
        // Set chart options
        var options = {
            'title' : 'Savings Ratio', //title which will be shown right above the Google Pie Chart
            is3D : true, //render Google Pie Chart as 3D
            pieSliceText: 'label', //on mouse hover show label or name of the Country
            tooltip :  {showColorCode: true}, // whether to display color code for a Country on mouse hover
            'width' : 900, //width of the Google Pie Chart
            'height' : 500 //height of the Google Pie Chart
        };
 
        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
    }
</script>
 <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />

</head>
<body>
  
    
    
    
    
    <div id="wrapper">
            <div id="title">
                <div id="titleimagecontainer">
                    <a href="home.jsp">
                        <img id=titleimage src="css/images/title.png" alt="Home Manager">
                    </a>
                </div>
                <div id="userAccount">
                    <ul id="usermenu">
                        <li>
                            <a id="username" href="#"><%=session.getAttribute("name")%> &#9662;</a>
                            <ul id="accountlist">
                                <li><a class="usermenuitem" href="insertData.jsp">Insert Family Info</a></li>
                                <li><a class="usermenuitem" href="insertExpense.jsp">Insert Monthly Expense</a></li>
                                <li><a class="usermenuitem" href="Logout">Log out</a></li>

                            </ul>
                        </li>
                    </ul>
                </div>
            </div>

            <div id="topbar">
                <nav id="linkNav">
                    <ul id="pagelinks">
                        <li><a  href="/HomeManagement/FamilyInfo">family_info</a></li>
                        <li><a href="/HomeManagement/MonthelyExpense">Monthly_Expenses</a></li>
                        <li><a href="/HomeManagement/EarningMember">Earning_Members</a></li>
                        <li><a href="insertReview.jsp">Monthly_Review</a></li>
                        <li><a href="/HomeManagement/EmergencyContacts">emergency_contacts</a></li>
                        <li><a class="selected" href="/HomeManagement/PieChartServelet">Statistics</a></li>
                        <li><a href="insertbloodgroup.jsp">Blood Group</a></li>
                    </ul>
                </nav>
            </div>
        </div>
    
    <div style="width: 800px;
         padding: 120px; padding-left: 150px;">
        <div id="chart_div"></div>
    </div>
</body>
</html>