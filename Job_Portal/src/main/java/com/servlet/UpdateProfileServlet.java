package com.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.db.DBconnect;
import com.entity.user;
@WebServlet("/update_profile")
public class UpdateProfileServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id=Integer.parseInt(req.getParameter("id"));
			String name= req.getParameter("name");
			String qua= req.getParameter("qua");
			String email= req.getParameter("email");
			String ps= req.getParameter("ps");
			
			UserDao ud= new UserDao(DBconnect.getcon());
			user u = new user();
			u.setId(id);
			u.setName(name);
			u.setQualification(qua);
			u.setEmail(email);
			u.setPassword(ps);
			boolean f= ud.updateUser(u);
			HttpSession hs=req.getSession();
			if(f) {
				hs.setAttribute("succMsg", "Profile Update Sucessfully");
				resp.sendRedirect("home.jsp");
			}else {
				hs.setAttribute("succMsg", "Somthing Worng on Server");
				resp.sendRedirect("home.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
