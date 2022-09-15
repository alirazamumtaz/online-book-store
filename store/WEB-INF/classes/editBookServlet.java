import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import beans.*;
import dao.*;


public class editBookServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            handleEditBook(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void handleEditBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {

        String name = request.getParameter("bookName");
        String wname = request.getParameter("writerName");
        String price = request.getParameter("price");
        int qty = Integer.parseInt(request.getParameter("qty"));
        int id = Integer.parseInt(request.getParameter("id"));

        BookStoreDao dao = new BookStoreDao();

        Book book = new Book();
        book.setBookName(name);
        book.setWriterName(wname);
        book.setPrice(price);
        book.setQty(qty);
        book.setBookID(id);
        System.out.println(book);

        try {
            Boolean flag = dao.updateBook(book);
            if (flag) {
                request.getRequestDispatcher("showBooks.jsp").forward(request, response);
            } else {
                request.setAttribute("msg", "Book not updated!");
                request.getRequestDispatcher("showBooks.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
