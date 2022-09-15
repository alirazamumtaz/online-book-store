import java.io.*;
import java.sql.SQLException;
import javax.servlet.http.*;
import beans.*;
import dao.*;


public class blockUserServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("adminName") == null){
            response.sendRedirect("login.html");
        }

        try {
            handleBlockUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        if(session.getAttribute("adminName") == null){
            response.sendRedirect("login.html");
        }

        try {
            handleBlockUser(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void handleBlockUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ClassNotFoundException, IOException {
        
        String userName = request.getParameter("userName");
        BookStoreDao dao = new BookStoreDao();
        User user = dao.searchUser(userName);
        
        if(user != null){
            dao.blockUser(userName);
            response.sendRedirect("adminHome.jsp?msg=blocked");
        }
        else{
            response.sendRedirect("adminHome.jsp?msg=notFound");
        }
    }
}