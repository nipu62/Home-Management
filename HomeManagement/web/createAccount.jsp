<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <%

            if (session.getAttribute("name") != null) {
                response.sendRedirect("home.jsp");
                //out.println("<script>parent.location.href='home.jsp'</script>");
            }
        %>
        <link rel="stylesheet" type="text/css" href="css/plugin-css/homepage.css">
        <link href="css/plugin-css/topbar.css" rel="stylesheet" type="text/css" />
        <title>Home Manager - Admin Registration</title>
    </head>
    <body>

        <script>

            function myFunction() {
                var pass1 = document.getElementById("pass").value;
                var pass2 = document.getElementById("confirm").value;
                var ok = true;
                if (pass1 !== pass2) {
                    //alert("Passwords Do not match");
                    document.getElementById("pass").style.borderColor = "#E34234";
                    document.getElementById("confirm").style.borderColor = "#E34234";
                    document.getElementById("mismatcherror").innerHTML = "passwords do not match";
                    document.getElementById("mismatcherror").style.color = "#E34234";
                    ok = false;
                }
                return ok;
            }

        </script>

        <div id="wrapper">
            <div id="title">
                <div id="titleimagecontainer">
                    <a href="login.jsp">
                        <img id=titleimage src="css/images/title.png" alt="Home Manager">
                    </a>
                </div>
            </div>
            <div id="login">
                <div id="triangle"></div>
                <form class="loginform" action="CreateAccount" method="POST" onsubmit="return myFunction()">
                    <h3>Create a new account</h3>
                    <p><input type="text" class="loginfield" name="username" value="" placeholder="Choose a username" required/><br></p>
                    <p id="mismatcherror"></p>
                    <p><input id="pass" type="password" class="loginfield" name="password" value="" placeholder="Password" required /><br></p>
                    <p><input id="confirm" type="password" class="loginfield" name="confirm_password" value="" placeholder="Confirm Password" required /><br></p>
                    <p><input type="text" class="loginfield" name="family_location" value="" placeholder="family location" required/><br></p>
                    <p><input type="submit" class="loginSubmit" value="Sign Up" /></p>
                </form>
            </div>
        </div>
    </body>
</html>
