import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import beans.*;
import dao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class cartPage extends HttpServlet {
    BookStoreDao bookdao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try {
            bookdao = new BookStoreDao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String username = (String) request.getParameter("username");
        try {

            ArrayList<Book> result = bookdao.cartList(username);
            request.setAttribute("cartList", result);
            RequestDispatcher rd = request.getRequestDispatcher("cartList.jsp");
            rd.forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
