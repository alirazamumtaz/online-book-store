<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>

<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>Remove from Cart</title>
        <link rel="stylesheet" href="stylehome.css" />
    </head>
    <body>
        <h1><center>Remove Book from Cart</center></h1>
        <div class="form">
            <form action="RemovefromCart" method="post">
                <input type="text" name="" placeholder="Enter Book Name" />
                <button>Remove from Cart</button>
            </form>
        </div>
    </body>
</html>
