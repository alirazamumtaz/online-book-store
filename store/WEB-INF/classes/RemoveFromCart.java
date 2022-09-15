import java.io.*;
import java.sql.SQLException;
import beans.*;
import dao.*;

import javax.servlet.http.*;

public class RemoveFromCart extends HttpServlet {
    BookStoreDao bookdao;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            bookdao = new BookStoreDao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String name = (String) request.getParameter("book");
        HttpSession session = request.getSession(false);
        String username = (String) session.getAttribute("username");

        try {
            int result = bookdao.removeFromCart(username);

            if (result > 0) {
                response.sendRedirect("userHome.jsp");
            } else {
                response.sendError(500, "Error Occured");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
