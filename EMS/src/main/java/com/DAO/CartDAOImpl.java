package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.entity.BookDet;
import com.entity.Cart;
import com.mysql.cj.protocol.Resultset;

import java.util.ArrayList;
import java.util.List;

public class CartDAOImpl implements CartDAO {
	
	private Connection conn;

	 public CartDAOImpl(Connection conn) {
//		super();
		this.conn = conn;
	}


	@Override
	public boolean addCart(Cart c) {
		boolean f = false;
		
		try {
			String sql = "insert into cart(book_id,user_id,bookname,author,price,total)values(?,?,?,?,?,?)";	
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, c.getBid());
			ps.setInt(2, c.getUid());
			ps.setString(3, c.getBookname());
			ps.setString(4, c.getAuthor());
			ps.setDouble(5, c.getPrice());
			ps.setDouble(6, c.getTotalP());
			
			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}


	@Override
	public List<Cart> getBookByUser(int userId) {
		List<Cart> list = new ArrayList<Cart>();
		Cart c = null;
		double totalPrice = 0;
		try 
		{
			String sql = "select * from cart where user_id =?" ;
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				c = new Cart();
				c.setCid(rs.getInt(1));
				c.setBid(rs.getInt(2));
				c.setUid(rs.getInt(3));
				c.setBookname(rs.getString(4));
				c.setAuthor(rs.getString(5));
				c.setPrice(rs.getDouble(6));
			
				totalPrice = totalPrice + rs.getDouble(7);
				c.setTotalP(totalPrice);


				list.add(c);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}


	@Override
	public boolean deletebook(int bid,int uid, int cid) {

		boolean f= false;

		String sql = "delete from cart where book_id=? and user_id=? and cart_id=?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setInt(2, uid);
			ps.setInt(3, cid);
			
			int i = ps.executeUpdate();
			
			if(i == 1)
			{
				f =true;	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}
	
	

}
