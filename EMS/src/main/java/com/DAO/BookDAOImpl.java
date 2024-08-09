package com.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.BookDet;

public class BookDAOImpl implements BookDAO {

	private Connection conn;

	public BookDAOImpl(Connection conn) {
		super();
		this.conn = conn;
	}

	@Override
	public boolean addBooks(BookDet b) {
		boolean f = false;

		try {
			String sql = "insert into book_dtls(bookname,author,price,bookCat,status,photo,user_email) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getBookCat());
			ps.setString(5, b.getStatus());
			ps.setString(6, b.getPhoto());
			ps.setString(7, b.getUser_email());

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
	public List<BookDet> getBook() {

		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;
		try {

			String sql = "SELECT * FROM test.book_dtls";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));

				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public BookDet getBooksById(int id) {

		BookDet b = null;
		try {
			String sql = "select*from book_dtls where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		return b;
	}

	@Override
	public boolean edit(BookDet b) {

		boolean f = false;
		try {

			String sql = "update book_dtls set bookname=?,author=?,price=?,status=? where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, b.getBookname());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getPrice());
			ps.setString(4, b.getStatus());
			ps.setInt(5, b.getBook_id());

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
	public boolean del(int id) {

		boolean f = false;
		try {

			String sql = "delete from book_dtls where book_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);

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
	public List<BookDet> getNewBook() {
		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {

			String sql = "SELECT * FROM test.book_dtls where bookCat=? and status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "new");
			ps.setString(2, "active");

			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));

				list.add(b);
				i++;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDet> getRecentBooks() {

		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDet> getOldBooks() {

		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where bookCat=? and status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "old");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();
			int i = 1;
			while (rs.next() && i <= 4) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
				i++;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDet> getAllRecentBooks() {
		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public List<BookDet> getAllNewBooks() {
		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {

			String sql = "SELECT * FROM test.book_dtls where bookCat=? and status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, "new");
			ps.setString(2, "active");

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));

				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<BookDet> getAllOldBooks() {
		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where bookCat=? and status=? order by book_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "old");
			ps.setString(2, "active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public List<BookDet> getBookByOld(String user_email, String cate) {

		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where bookCat=? and user_email=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cate);
			ps.setString(2, user_email);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public boolean oldBookDelete(String user_email, String cat, int id) {

		boolean f = false;
		try {
			String sql = "delete from book_dtls where bookCat=? and user_email=? and book_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cat);
			ps.setString(2, user_email);
			ps.setInt(3, id);

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
	public List<BookDet> getBookBySearch(String ch) {
		List<BookDet> list = new ArrayList<BookDet>();
		BookDet b = null;

		try {
			String sql = "select * from book_dtls where bookname like ? or bookCat like ? or author like ? and status=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+ch+"%");
			ps.setString(2, "%"+ch+"%");
			ps.setString(3, "%"+ch+"%");
			ps.setString(4, "active");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				b = new BookDet();
				b.setBook_id(rs.getInt(1));
				b.setBookname(rs.getString(2));
				b.setAuthor(rs.getString(3));
				b.setPrice(rs.getString(4));
				b.setBookCat(rs.getString(5));
				b.setStatus(rs.getString(6));
				b.setPhoto(rs.getString(7));
				b.setUser_email(rs.getString(8));
				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
