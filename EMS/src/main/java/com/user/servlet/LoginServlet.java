package com.user.servlet;

import java.io.IOException;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet
{


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try
		{
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
			
			HttpSession session = req.getSession(); 
					
			
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			
			if("admin@gmail.com".equals(email) && "admin".equals(password))
			{
				User us = new User();
				us.setUser_name("Admin");
				session.setAttribute("userobj", us);
				resp.sendRedirect("admin/home.jsp");
			}
			else
			{
				User us = dao.login(email, password);
				
				if(us != null)
				{
					session.setAttribute("userobj", us);
					resp.sendRedirect("index.jsp");
				}
				else
				{
					session.setAttribute("failedmsg", "Email & Password Invalid");
					resp.sendRedirect("login.jsp");

				}
				resp.sendRedirect("home.jsp");
			}
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}

}
