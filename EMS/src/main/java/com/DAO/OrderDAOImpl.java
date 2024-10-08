package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookOrder;
import com.entity.User;

public class OrderDAOImpl implements OrderDAO {
	
	private Connection conn;
	public OrderDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}
	
	@Override
	public boolean saveOrder(List<BookOrder> blist) {
		boolean f=false;
		try {
			
			String sql = "insert into book_order(order_id,user_name,user_email,address,phno,bookname,author,price,payment)values(?,?,?,?,?,?,?,?,?)";
			conn.setAutoCommit(false);
			
			PreparedStatement ps = conn.prepareStatement(sql);
			for(BookOrder b:blist) {
				
				ps.setString(1, b.getOrder_id());
				ps.setString(2, b.getName());
				ps.setString(3, b.getEmail());
				ps.setString(4, b.getAddr());
				ps.setString(5, b.getPhno());
				ps.setString(6, b.getBookname());
				ps.setString(7, b.getAuthor());
				ps.setString(8, b.getPrice());
				ps.setString(9, b.getPayT());
				ps.addBatch();			
			}
			
			
			int[] count=ps.executeBatch();
			conn.commit();
			f=true;
			conn.setAutoCommit(true);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<BookOrder> getBook(String email) {
		
		List<BookOrder> list=new ArrayList<BookOrder>();
		BookOrder o=null;
		try {
			String sql = "select * from book_order where user_email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				o=new BookOrder();
				o.setId(rs.getInt(1));
				o.setOrder_id(rs.getString(2));
				o.setName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setAddr(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBookname(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPayT(rs.getString(10));
				list.add(o);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookOrder> getAllBook() {
		
		List<BookOrder> list=new ArrayList<BookOrder>();
		BookOrder o=null;
		try {
			String sql = "select * from book_order";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				o=new BookOrder();
				o.setId(rs.getInt(1));
				o.setOrder_id(rs.getString(2));
				o.setName(rs.getString(3));
				o.setEmail(rs.getString(4));
				o.setAddr(rs.getString(5));
				o.setPhno(rs.getString(6));
				o.setBookname(rs.getString(7));
				o.setAuthor(rs.getString(8));
				o.setPrice(rs.getString(9));
				o.setPayT(rs.getString(10));
				list.add(o);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	

}
