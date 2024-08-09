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

@WebServlet("/delete_old_book")
public class DeleteOldBook extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String em = req.getParameter("em");
		int id=Integer.parseInt(req.getParameter("id"));
		BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());

		boolean f = dao.oldBookDelete(em, "old", id);

		HttpSession session = req.getSession();

		if (f == true) {
			session.setAttribute("succMsg", "Old Book Delete Successfully!");
			resp.sendRedirect("old_book.jsp");
		} else {
			session.setAttribute("succMsg", "Something wrong on server!");
			resp.sendRedirect("old_book.jsp");
		}
	}catch(Exception e) {
		e.printStackTrace();
	}
}
}
