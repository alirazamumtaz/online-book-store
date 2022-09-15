package beans;

public class Book {
    public String bookName;
    public String writerName;
    public int bookID;
    public String price;
    public int qty;

    public Book() {
        this.writerName = "";
        this.bookName = "";
        this.bookID = 0;
        this.price = "";
        this.qty = 0;

    }

    public Book(String writerName, String bookName, int bookID, String price) {
        this.writerName = writerName;
        this.bookName = bookName;
        this.bookID = bookID;
        this.price = price;
        this.qty = 1;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getWriterName() {
        return writerName;
    }

    public void setWriterName(String writerName) {
        this.writerName = writerName;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public void addQty(int qty) {
        this.qty += qty;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String toString() {
        return "Book Name: " + bookName + " <br>Writer Name: " + writerName + " <br>Book ID: " + bookID + " <br>Price: " + price + " <br>Quantity: " + qty;
    }

}
