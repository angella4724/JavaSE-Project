package mylab.library.entity;

import java.util.ArrayList;
import java.util.List;

public class Library {
	private List<Book> books;
	private String name;
	
	public Library(String name) {
		this.name = name;
		this.books = new ArrayList<>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public void addBook(Book book) {
		System.out.println("도서가 추가되었습니다: "+book.getTitle());
		this.books.add(book);
	}
	
	public Book findBookByTitle(String title) {
		for (Book b : this.books) {
			if (b.getTitle().equals(title)) {
				return b;
			}
		}
		return null;
	}
	
	public List<Book> findBooksByAuthor(String author) {
		List<Book> authorB = new ArrayList<>();
		for (Book b : this.books) {
			if (b.getAuthor().equals(author)) {
				authorB.add(b);
			}
		}
		return authorB;
	}
	
	public Book findBookByISBN(String isbn) {
		for (Book b : this.books) {
			if (b.getIsbn().equals(isbn)) {
				return b;
			}
		}
		return null;
	}
	
	public boolean checkOutBook(String isbn) {
		Book b = findBookByISBN(isbn);
		if (b != null) {
			return b.checkOut();
		}
		
		return false;
	}
	
	public boolean returnBook(String isbn) {
		Book b = findBookByISBN(isbn);
		if (b != null) {
			b.returnBook();
			return true;
		}
		return false;
	}
	
	public List<Book> getAvailableBooks(){
		List<Book> bks = new ArrayList<>();
		for (Book b : this.books) {
			if (b.isAvailable()) {
				bks.add(b);
			}
		}
		return bks;
	}
	
	public List<Book> getAllBooks(){
		List<Book> bks = new ArrayList<>();
		for (Book b : this.books) {
			bks.add(b);
		}
		return bks;
	}
	
	public int getTotalBooks() {
		int c = 0;
		c = this.books.size();
		return c;
	}
	
	public int getAvailableBooksCount() {
		int c = 0;
		for (Book b : this.books) {
			if(b.isAvailable()) {
				c += 1;
			}
		}
		return c;
	}
	
	public int getBorrowedBooksCount() {
		int c = 0;
		for (Book b : this.books) {
			if(b.isAvailable() == false) {
				c += 1;
			}
		}
		return c;
	}

}
