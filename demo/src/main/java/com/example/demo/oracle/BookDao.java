package com.example.demo.oracle;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BookDao {
	private String host;
	private String user;
	private String password;
	private String database;
	private String port;
	
	public BookDao() {
		try {
			Properties props = new Properties();
			String filename ="D:/JavaWeb/demo/src/main/java/com/example/demo/oracle/oracle.properties";
			InputStream is = new FileInputStream(filename);
			props.load(is);
			is.close();
			
			this.host = props.getProperty("host");
			this.user = props.getProperty("user");
			this.password = props.getProperty("password");
			this.database = props.getProperty("database");
			this.port = props.getProperty("port");
		} catch (Exception e) {
			e.printStackTrace();
		}
//		this.host = "localhost";
//		this.user = "hmuser";
//		this.password = "hmpass";
//		this.database = "xe";
//		this.port = 1521;
	}

	Connection myConnection() {
		Connection conn = null;
		try {
			String connStr = "jdbc:oracle:thin:@" + host + ":" + port + ":" + database;
			 conn = DriverManager.getConnection(connStr, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public Book getBook(int bookId) {
		Connection conn = myConnection();
		String sql = "select * from book where bookid=?";
		Book book = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bookId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				book = new Book(bookId, bookName, publisher, price);
			}
			rs.close(); pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	public List<Book> getBookList() {
		Connection conn = myConnection();
		String sql = "select * from book";
		List<Book> list = new ArrayList<>();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int bookId = rs.getInt(1);
				String bookName = rs.getString(2);
				String publisher = rs.getString(3);
				int price = rs.getInt(4);
				Book b = new Book(bookId, bookName, publisher, price);
				list.add(b);
			}
			rs.close(); conn.close(); stmt.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	public List<Book> getBookListByFieldAndQuery(String field,String query){
		Connection conn = myConnection();
		String sql = "select * from book where " + field + " like ?";
		List<Book> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + query + "%");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Book b = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
				list.add(b);
			}
			rs.close(); conn.close(); pstmt.close();
			} catch (Exception e) {
			e.printStackTrace();
		}
		return list;		
	}
	
	public void insertBook(Book b) {
		Connection conn = myConnection();
		String sql = "insert into Book values (?, ?, ?, ?)";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getBookId());
			pstmt.setString(2, b.getBookName());
			pstmt.setString(3, b.getPublisher());
			pstmt.setInt(4, b.getPrice());
			pstmt.executeUpdate();
			
			pstmt.close(); conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		public void deleteBook(int bookId) {
			Connection conn = myConnection();
			String sql = "delete from book where bookid=?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, bookId);
				pstmt.executeUpdate();
				
				pstmt.close(); conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		
	}
}
