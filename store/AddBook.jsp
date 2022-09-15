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
    <title>Add Book</title>
    <link rel="stylesheet" href="stylehome.css">
</head>
<body>
    <div class="form">
    <form action="AddBook" method="post">
        <h1>Add Book</h1>
        <input type="text" name="bookName" placeholder="Enter Book Name">
        <input type="text" name="writerName" placeholder="Enter Writer Name">
        <input type="text" name="price" placeholder="Enter Price of Book">
        <input type="text" name="qty" placeholder="Enter Quantity">
        <button>Add Book</button>
        <div style="color:red">${msg}</div>
    </form> 
    </div>
    
</body>
</html>