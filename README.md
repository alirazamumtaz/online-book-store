# Online Book Store

During my Web Engineering course at University of the Punjab - PUCIT in 2022, I have completed this assignment to practice J2EE concepts using the following configurations:
Java Version: javac 17.0.3
SQL Version: Ver 8.0.29 for macos12 on arm64 (MySQL Community Server - GPL)
Apache Tomcat Version: apache-tomcat-9.0.63
OS: MacOS Montery

## Project Tree
```
.
├── AddBook.jsp
├── Books.JPG
├── RemoveBook copy.jsp
├── RemoveBook.jsp
├── RemovefromCart.jsp
├── WEB-INF
│   ├── classes
│   │   ├── AddBookServlet.java
│   │   ├── AddToCartServlet.java
│   │   ├── LoginServlet.java
│   │   ├── Logout.java
│   │   ├── RemoveBookServlet.java
│   │   ├── RemoveFromCart.java
│   │   ├── SignupServlet.java
│   │   ├── beans
│   │   │   ├── Admin.java
│   │   │   ├── Book.java
│   │   │   └── User.java
│   │   ├── blockUserServlet.java
│   │   ├── cartPage.java
│   │   ├── dao
│   │   │   └── BookStoreDao.java
│   │   ├── editBookServlet.java
│   │   ├── finalOrder.java
│   │   └── searchBookServlet.java
│   ├── lib
│   │   └── mysql-connector-java-8.0.29.jar
│   └── web.xml
├── adminHome.jsp
├── bookDetail.jsp
├── cartList.jsp
├── editBook.jsp
├── error.jsp
├── login.js
├── login.jsp
├── project.sql
├── searchBook.jsp
├── showBooks.jsp
├── showUsers.jsp
├── signup.js
├── signup.jsp
├── style.css
├── stylehome.css
└── userHome.jsp

5 directories, 39 files
```

## How to compile and run

You need to follow these steps to compile and run this project:

### Step 1 := Creating a Database:

Create a database using the script provided in the project.sql file in this repository.

### Step 2 := Database connectivity

In the DOA class dao/BookStoreDOA.java you need to make changes according to your database. For example the username and password of your data base etc.

### Step 3 := Compiling the java files

Compile all the java files.

```
cd store/WEB-INF
javac classes/beans/*.java classes/dao/*.java
```

### Step 4 := Running the project

You need to place this repo inside the webapps directory of apache-tomcat.
Open any web browser and type the url: localhost:8080/store/login.html
