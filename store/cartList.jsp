
<%
if(session.getAttribute("username") == null){
    response.sendRedirect("login.jsp");
}
%>



<%@ page import="beans.Book"%>
<%@ page import ="dao.BookStoreDao" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.ArrayList.*"%>
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

    <div>
        <table border="1">
            <tr>
                <th>Book ID</th> <th>Book Name</th> <th>Writer Name</th> <th>Price</th><th>Action</th>
            </tr>
            <%
                BookStoreDao bookdao = new BookStoreDao();
                String username = (String) request.getParameter("username");
                ArrayList<Book> list = bookdao.cartList(username);
                if(list.size() == 0){
                    request.setAttribute("msg", "Cart is empty.");
                    request.getRequestDispatcher("userHome.jsp").forward(request, response);
                }
                for(Book book : list){
            %>
            <tr>
                <td><%=book.getBookID() %></td>
                <td><%=book.getBookName() %></td>
                <td><%=book.getWriterName() %></td>
                <td><%=book.getPrice() %></td>
                <td> 
                    <form action ="removeFromCart"> 
                        <button type="submit">Remove</button>
                        <input type="hidden" name="book" value=" <%=book.getBookName()%>"/>
                    </form>
                </td>
            </tr>
            <%
                };
            %>
        </table>
    </div>
    
    
    <a href="finalOrder?bookID=<%=username%>"><button>Finalize Order</button></a>
    <a href="userHome.jsp"><button>HOME</button></a>
</body>
</html>