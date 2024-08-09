package com.user.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.DAO.UserDAOImpl;
import com.DB.DBConnect;
import com.entity.User;

public class RegisterServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String name = request.getParameter("fname");
			String email = request.getParameter("email");
			String phno = request.getParameter("phno");
			String password = request.getParameter("password");
			String check = request.getParameter("check");

//            System.out.println(name + " " + email + " " + phno + " " + password);

			User us = new User();
			us.setUser_name(name);
			us.setUser_email(email);
			us.setPhno(phno);
			us.setPassword(password);

			HttpSession session = request.getSession();

			if (check != null) {
				UserDAOImpl dao = new UserDAOImpl(DBConnect.getconn());
				boolean f2 = dao.checkUser(email);
				if (f2) {

					boolean f = dao.userRegister(us);
					if (f == false) {
						// System.out.println("Success");
						session.setAttribute("succMsg", "Registered Successfully!");
						response.sendRedirect("register.jsp");
					} else {
						// System.out.println("fail");
						session.setAttribute("failMsg", "Something went wrong!");
						response.sendRedirect("register.jsp");
					}

				} else {
					session.setAttribute("failMsg", "User Already Exists! TRY ANOTHER EMAIL ID!");
					response.sendRedirect("register.jsp");

				}
			} else {
				// System.out.println("Please accept terms & conditions!");
				session.setAttribute("failMsg", "Please accept terms & conditons!");
				response.sendRedirect("register.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
