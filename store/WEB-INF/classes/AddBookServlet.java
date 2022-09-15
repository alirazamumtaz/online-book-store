import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import beans.*;
import dao.*;


public class AddBookServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            handleAddBook(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void handleAddBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {

        String name = request.getParameter("bookName");
        String wname = request.getParameter("writerName");
        String price = request.getParameter("price");
        int qty = Integer.parseInt(request.getParameter("qty"));

        BookStoreDao dao = new BookStoreDao();

        Book book = new Book();
        book.setBookName(name);
        book.setWriterName(wname);
        book.setPrice(price);
        book.setQty(qty);

        Boolean flag = false;
        try {
            flag = dao.addBook(book);
            if (flag) {
                request.getRequestDispatcher("showBooks.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Book not added!");
                request.getRequestDispatcher("showBooks.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
