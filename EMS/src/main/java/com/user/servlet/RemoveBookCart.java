package com.user.servlet;

import java.io.IOException;

import com.DAO.CartDAOImpl;
import com.DB.DBConnect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/remove_book")

public class RemoveBookCart extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		int bid = Integer.parseInt(req.getParameter("book_id"));
		int uid = Integer.parseInt(req.getParameter("user_id"));
		int cid = Integer.parseInt(req.getParameter("cart_id"));
		CartDAOImpl dao = new CartDAOImpl(DBConnect.getconn());
		
		boolean f = dao.deletebook(bid,uid,cid);
		
		HttpSession session = req.getSession();
		
		if(f==true)
		{
			session.setAttribute("succMsg", "Book Removed from cart!");
			resp.sendRedirect("checkout.jsp");
		}
		else
		{
			session.setAttribute("failMsg", "Something wrong on server!");
			resp.sendRedirect("checkout.jsp");
		}
	}

	
}
