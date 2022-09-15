import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import beans.*;
import dao.*;

public class RemoveBookServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            handleRemoveBook(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void handleRemoveBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {

        int bookID = Integer.parseInt(request.getParameter("bookID"));
        String price = request.getParameter("price");

        BookStoreDao dao = new BookStoreDao();

        Book book = new Book();
        Boolean flag = false;
        try {
            flag = dao.removeBook(bookID);
            if (flag) {
                request.setAttribute("msg", "Book has been removed.");
            } else {
                request.setAttribute("msg", "Book has not been deleted.");
            }
            request.getRequestDispatcher("showBooks.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
