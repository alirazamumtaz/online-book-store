<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");
}
%>
<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin Home</title>
    <link rel="stylesheet" href="stylehome.css">
    <style>
        .logout_button{
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #165800;
            margin:  10px;
            padding: 15px;
            color:#ffffff;
            font-size: 12px;
        }
    </style>
</head>
<body>
    
   
    <h1><center>HOME</center></h1>  
    
    <div class="form">
        <a href="showBooks.jsp"><div class="button" >Show all Books</div></a>
        <br>
        <a href="showUsers.jsp"><div class="button" >Show all Users</div></a>
    </div>

    
        <a href="logout"><button class="logout_button">LOG OUT</button></a>
    
 
</body>
</html>