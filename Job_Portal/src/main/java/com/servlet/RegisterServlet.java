package com.servlet;

import java.io.IOException;
import com.dao.UserDao;
import com.db.DBconnect;
import com.entity.user;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/add_user")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		try {
			String name=req.getParameter("fname");
			String qua=req.getParameter("qual");
			String email=req.getParameter("email");
			String ps=req.getParameter("pw");
		
			UserDao ud= new UserDao(DBconnect.getcon());
			user u = new user(name,email,ps,qua,"user");
			boolean f= ud.addUser(u);
			HttpSession hs= req.getSession();
			if (f) {

				hs.setAttribute("succMsg", "Registration Succesfull..");
				resp.sendRedirect("signup.jsp");
			} else {
				hs.setAttribute("succMsg", "Somthing Worng On Server");
				resp.sendRedirect("signup.jsp");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
	}
		
	}}
