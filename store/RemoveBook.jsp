<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");;
}
%>
<%@ page import ="dao.BookStoreDao" %>
<%@ page import ="beans.Book" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page isErrorPage="false" errorPage="error.jsp" %>


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
                <label for="books">Choose a Book:</label>
                <select name="bookID" id="books">
                    <%
                        BookStoreDao bookStoreDao = new BookStoreDao();
                        ArrayList<Book> books = bookStoreDao.getAllBooks();
                        for(Book book : books){
                    %>
                    <option value="<%=book.getBookID()%>"><%=book.getBookName()%></option>
                    <%
                        }
                    %>
                </select>
                <button>Remove Book</button>
            </form> 
        </div>
    
</body>
</html>