package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

@WebServlet("/edit")
public class UpdateServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {

			int id = Integer.parseInt(req.getParameter("id"));
			String name = req.getParameter("fname");
			String email = req.getParameter("email");
			String phno = req.getParameter("phno");
			String password = req.getParameter("password");

			User us = new User();
			us.setUser_id(id);
			us.setUser_name(name);
			us.setUser_email(email);
			us.setPhno(phno);

			HttpSession session = req.getSession();
			UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
			boolean f = dao.checkpassword(id, password);

			if (f) {

				boolean f2 = dao.editprofile(us);
				if (f2==false) {
					session.setAttribute("succMsg", "Updated Successfully!");
					resp.sendRedirect("edit_profile.jsp");

				} else {
					session.setAttribute("failMsg", "Not Updated!");
	        		   resp.sendRedirect("edit_profile.jsp");
				}

			} else {
				
				session.setAttribute("failMsg", "Incorrect Password");
	    		   resp.sendRedirect("edit_profile.jsp");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
