package com.servlet;

import java.io.IOException;
import com.dao.*;
import com.db.DBconnect;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			
			int id=Integer.parseInt(req.getParameter("id"));
			jobDAO jd= new jobDAO(DBconnect.getcon());
			boolean b=jd.deleteJob(id);
			
			HttpSession session = req.getSession();
			if (b) {

				session.setAttribute("succMsg", "job Delete succesfull..");
				resp.sendRedirect("viewjob.jsp");
			} else {
				session.setAttribute("succMsg", "somthing worng on server");
				resp.sendRedirect("viewjob.jsp");
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
