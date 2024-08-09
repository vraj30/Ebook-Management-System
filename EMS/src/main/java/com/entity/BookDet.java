package com.entity;

public class BookDet {
	
	private int book_id;
	private String bookname;
	private String author;
	private String price;
	private String bookCat;
	private String status;
	private String photo;
	private String user_email;
	
	@Override
	public String toString() {
		return "BookDet [book_id=" + book_id + ", bookname=" + bookname + ", author=" + author + ", price=" + price
				+ ", bookCat=" + bookCat + ", status=" + status + ", photo=" + photo + ", user_email=" + user_email
				+ "]";
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getBookCat() {
		return bookCat;
	}

	public void setBookCat(String bookCat) {
		this.bookCat = bookCat;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getUser_email() {
		return user_email;
	}

	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}

	public BookDet(String bookname, String author, String price, String bookCat, String status, String photo,String user_email) 
	{
		super();
		this.bookname = bookname;
		this.author = author;
		this.price = price;
		this.bookCat = bookCat;
		this.status = status;
		this.photo = photo;
		this.user_email = user_email;
	}

	public BookDet() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
