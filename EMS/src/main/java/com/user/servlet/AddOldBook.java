package com.user.servlet;

import java.io.File;
import java.io.IOException;

import com.DAO.BookDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/add_old_book")
@MultipartConfig
public class AddOldBook extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String bookname = req.getParameter("bname");
			String authorname = req.getParameter("author");
			String price = req.getParameter("price");
			String category = "old";
			String status = "active";
			Part part = req.getPart("bimg");
			String filename = part.getSubmittedFileName();
			
			String useremail=req.getParameter("user");
			BookDet b = new BookDet(bookname, authorname, price, category, status, filename, useremail);
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());

			/*
			 * System.out.println(path);
			 */

			boolean f = dao.addBooks(b);

			HttpSession session = req.getSession();

			if (f == false) {

				String path = getServletContext().getRealPath("") + "bookimg";

				File file = new File(path);
				part.write(path + File.separator + filename);

				session.setAttribute("succMsg", "Book Added Successfully");
				resp.sendRedirect("sell_book.jsp");

			} else {
				session.setAttribute("failMsg", "Book Not Added!");
				resp.sendRedirect("sell_book.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
