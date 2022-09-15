<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>

<%@ page import ="beans.Book" %>
<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Book Detail</title>
    <style>
        table{
            width: 75%;
            border-collapse: collapse;
            border: 1px solid black;
            margin: 0 auto;
            text-align: center;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even){background-color: #f2f2f2}

        th {
            background-color: #43A047;
            color: white;
        }
        button{
            font-family: "Roboto", sans-serif;
            text-transform: uppercase;
            outline: 0;
            background: #4CAF50;
            /* width: 100%; */
            border: 0;
            margin:  10px;
            padding: 15px;
            color:#FFFFFF;
            /* font-size: 14px; */
            cursor: pointer;
        }
    </style>
</head>
<body>
    
    <%
        Book book = (Book) request.getAttribute("book");
        String username = (String)session.getAttribute("username");
     %>

    <div>
        <table border="1">
            <tr>
                <th>Book ID</th> <th>Book Name</th> <th>Writer Name</th> <th>Price</th>
            </tr>
            <tr>
                <td><%=book.getBookID() %></td>
                <td><%=book.getBookName() %></td>
                <td><%=book.getWriterName() %></td>
                <td><%=book.getPrice() %></td>
            </tr>
        </table>
    </div>
    
    <div class="form">
    <form action="addtoCart" method="post">
        
        <button type = "submit">Add to Cart</button>
        <input type="hidden" name="id" value="<%= book.getBookID()%>"/>
        <input type="hidden" name="username" value="<%= username%>"/>
        
    </form> 
    </div>
    <a href="userHome.jsp"><button>HOME</button></a>
</body>
</html>