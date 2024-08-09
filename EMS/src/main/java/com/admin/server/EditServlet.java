package com.admin.server;

import java.io.File;
import java.io.IOException;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/edit_books")
public class EditServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String bookname = req.getParameter("bname");
			String authorname = req.getParameter("author");
			String price = req.getParameter("price");
			String status = req.getParameter("bstatus");
			
			BookDet b = new BookDet();
			
			b.setBook_id(id);
			b.setBookname(bookname);
			b.setAuthor(authorname);
			b.setPrice(price);
			b.setStatus(status);
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			boolean f = dao.edit(b);
			HttpSession session = req.getSession();

			if (f == true) {
				session.setAttribute("succMsg", "Book Updated Successfully");
				resp.sendRedirect("admin/all_books.jsp");

			} else {
				session.setAttribute("failMsg", "Book Not Updated!");
				resp.sendRedirect("admin/all_books.jsp");

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
