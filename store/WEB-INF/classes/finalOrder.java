import java.io.*;
import java.sql.SQLException;
import javax.servlet.*;
import java.util.ArrayList;

import dao.*;

import javax.servlet.http.*;
import beans.*;

public class finalOrder extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
      
        try{
            String username = request.getParameter("username");
            BookStoreDao bookStoreDao = new BookStoreDao();
            ArrayList<Book> books = bookStoreDao.cartList(username);
            for( Book book : books){
                book.setQty(book.getQty()-1);
                bookStoreDao.updateBook(book);
            }
            bookStoreDao.removeFromCart(username);

            RequestDispatcher rd = null;
            request.setAttribute("msg", "Order has been placed!");
            rd = request.getRequestDispatcher("userHome.jsp");
            rd.forward(request, response);

        } catch (Exception e){
            e.printStackTrace();
        }
        //Your order has been placed

    }

}
