package com.DAO;

import java.util.List;

import com.entity.BookDet;
import com.entity.User;

public interface BookDAO {

	public boolean addBooks(BookDet b);
	public List<BookDet> getBook();
	public BookDet getBooksById(int id);
	public boolean edit(BookDet b);
	public boolean del(int id);

	public List<BookDet> getNewBook();
	public List<BookDet> getRecentBooks();
	public List<BookDet> getOldBooks();
	
	public List<BookDet> getAllRecentBooks();
	public List<BookDet> getAllNewBooks();
	public List<BookDet> getAllOldBooks();
	
	public List<BookDet> getBookByOld(String user_email, String cate);
	
	public boolean oldBookDelete(String user_email, String cat, int id);
	
	public List<BookDet> getBookBySearch(String ch);
}
