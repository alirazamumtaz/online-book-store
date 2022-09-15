<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");
}
%>

<%@ page import ="dao.BookStoreDao" %>
<%@ page import ="beans.Book" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<head>
    <title>Available Books</title>
    <head>
        <title>Edit Book</title>
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
</head>

<body>
    <h1><center>All Available Books</center></h1>
    <div>
        <table border="1">
            <tr>
                <th>Book ID</th> <th>Book Name</th> <th>Writer Name</th> <th>Price</th> <th>Quantity</th> <th>Action</th>
            </tr>
            <%
                BookStoreDao bookStoreDao = new BookStoreDao();
                ArrayList<Book> books = bookStoreDao.getAllBooks();
                for(Book book : books){
            %>
            <tr>
                <td><%=book.getBookID() %></td>
                <td><%=book.getBookName() %></td>
                <td><%=book.getWriterName() %></td>
                <td><%=book.getPrice() %></td>
                <td><%=book.getQty() %></td>
                <td><button onclick="window.location.href='editBook.jsp?id=<%=book.getBookID() %>'">Edit</button></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <a href="AddBook.jsp"><button>Add Book</button></a>
    <a href="RemoveBook.jsp"><button>Remove Book</button></a>
    <a href="adminHome.jsp"><button>HOME</button></a>
</body>