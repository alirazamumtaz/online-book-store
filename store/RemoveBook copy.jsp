<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");;
}
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Remove Book</title>
    <link rel="stylesheet" href="stylehome.css">
</head>
<body>
    <div class="form">
            <form action="RemoveBook" method="post">
                <h1>Remove Book</h1>
                <input type="text" name="bookName" placeholder="Enter Book Name">
                <input type="text" name="writerName" placeholder="Enter Writer Name">
                <input type="text" name="bookID" placeholder="Enter Book Id">
                <button>Remove Book</button>
            </form> 
        </div>
    
</body>
</html>