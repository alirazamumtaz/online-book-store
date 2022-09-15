<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");
}
%>

<%@ page import ="dao.BookStoreDao" %>
<%@ page import ="beans.Book" %>
<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="stylehome.css">
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("id"));
        BookStoreDao dao = new BookStoreDao();
        Book book = dao.searchById(id);
    %>
    <h1>
        <center>Editing Book <%=book.getBookID()%></center>
    </h1>
    <div class="form">
        <form action="editBook?id=<%=id%>" method="post">
            <input type="text" name="bookName" placeholder="Enter New Name" value="<%=book.getBookName()%>">
            <input type="text" name="writerName" placeholder="Enter New Writer Name" value="<%=book.getWriterName()%>">
            <input type="text" name="price" placeholder="Enter New Price of Book" value="<%=book.getPrice()%>">
            <input type="text" name="qty" placeholder="Enter New Quantity" value="<%=book.getQty()%>">
            <input type="submit" name="update" value="Update">
        </form>
    </div>
</body>
</html>