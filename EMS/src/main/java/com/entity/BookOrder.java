package com.entity;

public class BookOrder {
	
	private int id;
	private String order_id;
	private String name;
	private String email;
	private String addr;
	private String phno;
	private String fulladdr;
	private String bookname;
	private String author;
	private String price;
	private String payT;
	
	public BookOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getFulladdr() {
		return fulladdr;
	}

	public void setFulladdr(String fulladdr) {
		this.fulladdr = fulladdr;
	}

	public String getPayT() {
		return payT;
	}

	public void setPayT(String payT) {
		this.payT = payT;
	}
	
	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
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


	@Override
	public String toString() {
		return "BookOrder [id=" + id + ", name=" + name + ", email=" + email + ", addr=" + addr + ", phno=" + phno
				+ ", fulladdr=" + fulladdr + ", payT=" + payT + "]";
	}
	
	
	
	
	

}
