<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>
<%@ page isErrorPage="false" errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search Book</title>
    <link rel="stylesheet" href="stylehome.css">
</head>
<body>
    <h1><center>Search Book</center></h1>
    <div class="form">
    <form action="searchBook" method="post">
        <input type="text" name="bookName" placeholder="Enter Book Name">
        <button>Search</button>
    </form> 
    </div>
    
</body>
</html>