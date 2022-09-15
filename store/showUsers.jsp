<%
if(session.getAttribute("adminName") == null){
    response.sendRedirect("login.jsp");
}
%>

<%@ page import ="dao.BookStoreDao" %>
<%@ page import ="beans.User" %>
<%@ page import ="java.util.ArrayList" %>
<%@ page isErrorPage="false" errorPage="error.jsp" %>

<!DOCTYPE html>
<head>
    <title>All Users</title>
    <head>
        <title>Users</title>
        <!-- <link rel="stylesheet" href="stylehome.css"> -->
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
    <h1>All User</h1>
    <div>
        <table border="1">
            <tr>
                <th>User Name</th> <th>Email</th> <th>Address</th> <th>Phone No.</th> <th>Password</th><th>Action</th>
            </tr>
            <%
                BookStoreDao bookStoreDao = new BookStoreDao();
                ArrayList<User> users = bookStoreDao.getAllUsers();
                for(User user : users){
            %>
            <tr>
                <td><%=user.getUserName() %></td>
                <td><%=user.getEmail() %></td>
                <td><%=user.getAddress() %></td>
                <td><%=user.getPhone() %></td>
                <td><%=user.getPassword() %></td>
                <td><button onclick="window.location.href='blockUser?userName=<%=user.getUserName()%>'"><%=user.getStatus()%></button></td>
            </tr>
            <%
                }
            %>
        </table>
    </div>
    <a href="adminHome.jsp"><button>HOME</button></a>
</body>