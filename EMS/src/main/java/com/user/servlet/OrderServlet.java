package com.user.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.DAO.CartDAOImpl;
import com.DAO.OrderDAOImpl;
import com.DB.DBConnect;
import com.entity.BookOrder;
import com.entity.Cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/order")
public class OrderServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			HttpSession session = req.getSession();
			int id = Integer.parseInt(req.getParameter("id"));
			String name =req.getParameter("uname");
			String email =req.getParameter("mail");
			String phno =req.getParameter("phno");
			String addr =req.getParameter("add");
			String landmark =req.getParameter("landm");
			String city =req.getParameter("city");
			String state =req.getParameter("state");
			String pincode =req.getParameter("pinc");
			String Pt =req.getParameter("payt");
			
			String fullAddr = addr+","+landmark+","+city+","+state+","+pincode;
//			System.out.println(name+" "+" "+email+" "+phno+" "+" "+fullAddr+" "+Pt );
			
			CartDAOImpl dao = new CartDAOImpl(DBConnect.getconn());
			List<Cart> blist = dao.getBookByUser(id);
			
			if(blist.isEmpty()) {
				
				session.setAttribute("failMsg", "Please add item to cart.");
				resp.sendRedirect("checkout.jsp");				
			}
			else {
				OrderDAOImpl dao2 = new OrderDAOImpl(DBConnect.getconn());
				
				BookOrder o = null;
				
				ArrayList<BookOrder> ord=new ArrayList<BookOrder>();
				Random r = new Random();
				
				for(Cart c : blist) 
				{
					o=new BookOrder();
					o.setOrder_id("BOOK-ORD-00" + r.nextInt());
					o.setName(name);
					o.setEmail(email);
					o.setPhno(phno);
					o.setAddr(fullAddr);
					o.setBookname(c.getBookname());
					o.setAuthor(c.getAuthor());
					o.setPrice(c.getPrice()+"");
					o.setPayT(Pt); 
					ord.add(o);		
				}
				
				if("noselect".equals(Pt)) {
					
					session.setAttribute("failMsg", "Choose Payment Method!!");
					resp.sendRedirect("checkout.jsp");
					
				}else {
					boolean f=dao2.saveOrder(ord);
					if(f==false) 
					{
						session.setAttribute("succMsg", "Order Placed Successfully.");
						resp.sendRedirect("order_success.jsp");
					}
					else 
					{
						session.setAttribute("failMsg", "Order Failed");
						resp.sendRedirect("checkout.jsp");
					}
				}
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

}
