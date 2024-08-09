package com.user.servlet;

import java.io.IOException;

import com.DAO.BookDAOImpl;
import com.DAO.CartDAOImpl;
import com.DB.DBConnect;
import com.entity.BookDet;
import com.entity.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cart")
public class CartServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			
			int bid=Integer.parseInt(req.getParameter("bid")); 	
			int uid=Integer.parseInt(req.getParameter("uid")); 	
			
			BookDAOImpl dao = new BookDAOImpl(DBConnect.getconn());
			BookDet b=dao.getBooksById(bid);
			
			Cart c = new Cart();
		
			c.setBid(bid);
			c.setUid(uid);
			c.setBookname(b.getBookname());
			c.setAuthor(b.getAuthor());
			c.setPrice(Double.parseDouble(b.getPrice()));
			c.setTotalP(Double.parseDouble(b.getPrice()));
			
			CartDAOImpl dao2 = new CartDAOImpl(DBConnect.getconn());
			boolean f=dao2.addCart(c);
			
			HttpSession session=req.getSession();
			
			if(f) 
			{
				session.setAttribute("succMsg", "Book Added to Cart");
				resp.sendRedirect("all_new_book.jsp");
				//System.out.println("Add Cart Success!!");
			}
			else {
				session.setAttribute("failMsg", "Something went wrong!");
				resp.sendRedirect("all_new_book.jsp");
				//System.out.println("Not Added to Cart!");
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
