package com.DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

import com.entity.User;

public class UserDAOImpl implements UserDAO {

	private Connection conn;

	public UserDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean userRegister(User us) {
		boolean f = false;

		try {
			String sql = "insert into user(user_name,user_email,phno,password) values(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, us.getUser_name());
			ps.setString(2, us.getUser_email());
			ps.setString(3, us.getPhno());
			ps.setString(4, us.getPassword());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public User login(String email, String password) {

		User us = null;

		try {
			String sql = "select * from user where user_email = ? and password = ?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				us = new User();
				us.setUser_id(rs.getInt(1));
				us.setUser_name(rs.getString(2));
				us.setUser_email(rs.getString(3));
				us.setPhno(rs.getString(4));
				us.setPassword(rs.getString(5));
				us.setAddress(rs.getString(6));
				us.setLandmark(rs.getString(7));
				us.setCity(rs.getString(8));
				us.setState(rs.getString(9));
				us.setPincode(rs.getString(10));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return us;
	}

	@Override
	public boolean checkpassword(int id, String pswd) {
		boolean f = false;
		try {
			String sql = "select * from user where user_id=? and password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);
			ps.setString(2, pswd);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	@Override
	public boolean editprofile(User us) {
		boolean f = false;

		try {
			String sql = "update user set user_name=?,user_email=?,phno=? where user_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, us.getUser_name());
			ps.setString(2, us.getUser_email());
			ps.setString(3, us.getPhno());
			ps.setInt(4, us.getUser_id());

			int i = ps.executeUpdate();
			if (i == 1) {
				f = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;

	}

	@Override
	public boolean checkUser(String email) {
		boolean f = true;

		try {
			String sql = "select * from user where user_email=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				f=false;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
