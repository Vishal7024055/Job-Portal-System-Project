package com.servlet;
import com.entity.*;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBconnect;
import com.entity.user;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			
			String em=req.getParameter("email");
			String pass=req.getParameter("pass");
			user u= new user();
			HttpSession session= req.getSession();
			
			if("vishalkumarprajapati.vk@gmail.com".equals(em)&& "Vishal@123".equals(pass)) {
				session.setAttribute("userobj", u);
				u.setRole("admin");
				resp.sendRedirect("admin.jsp");
				
			}
			else {
				UserDao ud= new UserDao(DBconnect.getcon());
				user Us=ud.Login(em, pass);
				if(Us!=null) {
					session.setAttribute("userobj", Us);
					resp.sendRedirect("home.jsp");
				}
				else {
					session.setAttribute("succMsg", "Invalid Email And Password");
					resp.sendRedirect("login.jsp");
				}
				
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	
}