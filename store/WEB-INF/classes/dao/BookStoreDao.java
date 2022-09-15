package dao;

import java.sql.*;
import java.util.ArrayList;
import beans.*;

public class BookStoreDao {
    Connection con;

    public BookStoreDao() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1/project";
        con = DriverManager.getConnection(url, "root", "root");
    }

    public User userlogin(User userp) throws SQLException {

        String sql = "SELECT * FROM user WHERE userName = ? AND password = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, userp.getUserName());
        pStmt.setString(2, userp.getPassword());
        User user = null;
        ResultSet rs = pStmt.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getString("phone"));
            user.setUserName(rs.getString("userName"));
            user.setPassword(rs.getString("password"));
            user.setStatus(rs.getString("status"));
            return user;
        } else {
            return null;
        }

    }

    public Admin adminlogin(Admin adminn) throws SQLException {

        String sql = "SELECT * FROM admin WHERE adminName = ? AND password = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        Admin admin = null;
        pStmt.setString(1, adminn.getAdminName());
        pStmt.setString(2, adminn.getPassword());

        ResultSet rs = pStmt.executeQuery();
        if (rs.next()) {
            admin = new Admin();
            admin.setAdminName(rs.getString("adminName"));
            admin.setPassword("password");
            return admin;
        } else {
            return null;
        }

    }

    public Boolean signup(User user) throws SQLException {

        String sql = "INSERT INTO user (userName,email,password,address,phone, status) VALUES(?,?,?,?,?,?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, user.getUserName());
        pStmt.setString(2, user.getEmail());
        pStmt.setString(3, user.getPassword());
        pStmt.setString(4, user.getAddress());
        pStmt.setString(5, user.getPhone());
        pStmt.setString(6, user.getStatus());
        int rs = pStmt.executeUpdate();

        if (rs > 0) {
            return true;

        } else {
            return false;
        }
    }

    public ArrayList<User> getAllUsers() throws SQLException {
        ArrayList<User> users = new ArrayList<User>();
        String sql = "SELECT * FROM user";
        PreparedStatement pStmt = con.prepareStatement(sql);
        User user = null;
        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {
            user = new User();
            
            user.setUserName(rs.getString("userName"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setAddress(rs.getString("address"));
            user.setPhone(rs.getString("phone"));
            user.setStatus(rs.getString("status"));
            
            users.add(user);
        }
        return users;
    }

    public User searchUser(String userName) throws SQLException {

        String sql = "SELECT * FROM user WHERE userName = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        User user = null;
        pStmt.setString(1, userName);
        ResultSet rs = pStmt.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setUserName(userName);
            user.setEmail(rs.getString("email"));
            user.setAddress(rs.getString("address"));
            user.setPassword(rs.getString("password"));
            user.setPhone(rs.getString("phone"));
            user.setStatus(rs.getString("status"));
            return user;
        } else {
            return null;
        }

    }

    public void blockUser(String userName) throws SQLException {
        String sql = "UPDATE user SET status = 'blocked' WHERE userName = ?";
        try {
            PreparedStatement pStmt = con.prepareStatement(sql);
            pStmt.setString(1, userName);
            pStmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Book> getAllBooks() throws SQLException{
        ArrayList<Book> books = new ArrayList<Book>();
        String sql = "SELECT * FROM book";
        PreparedStatement pStmt = con.prepareStatement(sql);
        Book book = null;
        ResultSet rs = pStmt.executeQuery();

        while (rs.next()) {
            book = new Book();
            book.setWriterName(rs.getString("writerName"));
            book.setBookName(rs.getString("bookName"));
            book.setPrice(rs.getString("price"));
            book.setBookID(rs.getInt("bookId"));
            book.setQty(rs.getInt("qty"));
            books.add(book);
        }
        return books;
    }

    public Boolean updateBook(Book book) throws SQLException {
        String sql = "UPDATE book SET bookName=?, writerName=?, price=?, qty=? WHERE bookID = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, book.getBookName());
        pStmt.setString(2, book.getWriterName());
        pStmt.setString(3, book.getPrice());
        pStmt.setInt(4, book.getQty());
        pStmt.setInt(5, book.getBookID());

        int rs = pStmt.executeUpdate();

        if (rs > 0) {
            return true;

        } else {
            return false;
        }
    }

    public Boolean addBook(Book book) throws SQLException {

        String sql = "INSERT INTO book (bookName,writerName,price,qty) VALUES(?,?,?,?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, book.getBookName());
        pStmt.setString(2, book.getWriterName());
        pStmt.setString(3, book.getPrice());
        pStmt.setInt(4, book.getQty());
        int rs = pStmt.executeUpdate();

        if (rs > 0) {
            return true;

        } else {
            return false;
        }
    }

    public Boolean removeBook(int bookID) throws SQLException {

        String sql = "DELETE FROM book WHERE bookID=?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        pStmt.setInt(1, bookID);
        int rs = pStmt.executeUpdate();

        if (rs == 1) {
            return true;

        } else {
            return false;
        }
    }

    public Book searchBook(String bookName) throws SQLException {

        String sql = "SELECT * FROM book WHERE bookName = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        Book book = null;
        pStmt.setString(1, bookName);
        ResultSet rs = pStmt.executeQuery();

        if (rs.next()) {
            book = new Book();
            book.setWriterName(rs.getString("writerName"));
            book.setBookName(rs.getString("bookName"));
            book.setPrice(rs.getString("price"));
            book.setBookID(rs.getInt("bookId"));
            return book;
        } else {
            return null;
        }

    }

    public Book searchById(int id) throws SQLException {

        String sql = "SELECT * FROM book WHERE bookID = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        Book book = null;
        pStmt.setInt(1, id);
        ResultSet rs = pStmt.executeQuery();

        if (rs.next()) {
            book = new Book();
            book.setWriterName(rs.getString("writerName"));
            book.setBookName(rs.getString("bookName"));
            book.setPrice(rs.getString("price"));
            book.setBookID(rs.getInt("bookID"));
            book.setQty(rs.getInt("qty"));
            return book;
        } else {
            return null;
        }
    }

    public int addToCart(Book book, String username) throws SQLException {

        String sql = "INSERT INTO cart(bookName,bookId, writerName, price, username) VALUES(?,?,?,?,?)";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, book.getBookName());
        pStmt.setInt(2, book.getBookID());
        pStmt.setString(3, book.getWriterName());
        pStmt.setString(4, book.getPrice());
        pStmt.setString(5, username);

        int rs = pStmt.executeUpdate();

        return rs;

    }

    public int removeFromCart(String username) throws SQLException {

        String sql = "DELETE FROM cart WHERE username = ?";
        PreparedStatement pStmt = con.prepareStatement(sql);

        pStmt.setString(1, username);

        int rs = pStmt.executeUpdate();

        return rs;

    }

    public ArrayList<Book> cartList(String username) throws SQLException {

        String sql = "SELECT * FROM cart WHERE username=?";
        PreparedStatement pStmt = con.prepareStatement(sql);
        ArrayList<Book> books = new ArrayList<Book>();
        pStmt.setString(1, username);

        ResultSet rs = pStmt.executeQuery();
        while (rs.next()) {
            Book book = new Book();
            book.setBookID(rs.getInt("bookId"));
            book.setBookName(rs.getString("bookName"));
            book.setPrice(rs.getString("price"));
            book.setWriterName(rs.getString("writerName"));
            books.add(book);
        }

        return books;

    }

}