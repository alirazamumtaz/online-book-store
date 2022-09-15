import java.io.*;
import java.sql.SQLException;
import beans.*;


import javax.servlet.http.*;

public class AddToCartServlet extends HttpServlet {
    dao.BookStoreDao bookdao;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            bookdao = new dao.BookStoreDao();
            int id = Integer.parseInt(request.getParameter("id"));
            String username = (String) request.getParameter("username");

            Book book = bookdao.searchById(id);
            int result = bookdao.addToCart(book, username);

            if (result > 0) {
                response.sendRedirect("userHome.jsp");
            } else {
                response.sendError(500, "Error Occured");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        

    }

}
