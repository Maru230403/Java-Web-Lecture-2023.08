package com.example.demo.oracle;

import java.util.List;

public class BookTest {

	public static void main(String[] args) {
		BookDao bDao = new BookDao();
//		Book b1 = bDao.getBook(1);
//		System.out.println(b1);
//		
//		List<Book> list = bDao.getBookList();
//		for (Book b2: list)
//			System.out.println(b2);	
		
//		Book b3 = new Book(14, "생각하고 말해라", "뇌로부터", 97000);
//		bDao.insertBook(b3);
		
		bDao.deleteBook(14);
		
		List<Book> list = bDao.getBookListByFieldAndQuery("bookName", "");
		for (Book b2: list)
			System.out.println(b2);	
		
	}
}
