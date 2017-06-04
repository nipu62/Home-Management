<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%

            if (session.getAttribute("name") != null) {
                response.sendRedirect("home.jsp");
                //out.println("<script>parent.location.href='home.jsp'</script>");
            }
        %>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        
        <title>Home Manager - Log In</title>
    </head>
    <body>
        <div id="wrapper">
            <div id="title">
                <div id="titleimagecontainer">
                    <a href="login.jsp">
                        <img id=titleimage src="css/images/title.png" alt="Home Manager">
                    </a>
                </div>
            </div>
            <div id="loginnew">
                <div id="triangle"></div>
                <form class="loginform" action="LogInCheckJSP" method="POST">
                    <h3 class="paraTitle">Log In</h3>
                    <p id="loginerror"><%= request.getAttribute("error") == null ? "" : request.getAttribute("error")%></p>
                    <p class="textfield"><input type="text" class="loginfield" name="username" value="" placeholder="Username"  /><br></p>
                    <p class="textfield"><input type="password" class="loginfield" name="password" value="" placeholder="Password" /><br></p>
                    <p class="submit"><input type="submit" class="loginSubmit" value="Sign In" /></p>
                    <p class="submit"><a href="createAccount.jsp">Create new account</a></p>
                </form> 
            </div>
        </div>
    </body>
</html>
