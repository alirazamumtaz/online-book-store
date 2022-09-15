import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import beans.*;
import dao.*;
import javax.servlet.*;

public class searchBookServlet extends HttpServlet {
    BookStoreDao dao;

    public void init() {
        try {
            dao = new BookStoreDao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {


        String name = request.getParameter("bookName");

        Book book = null;
        RequestDispatcher rd = null;

        try {
            book = dao.searchBook(name);
            if(book == null){
                request.setAttribute("msg", "Book not Found!");
                rd = request.getRequestDispatcher("userHome.jsp");
            }else{
                request.setAttribute("book", book);
                rd = request.getRequestDispatcher("bookDetail.jsp");
            }
            rd.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}