package com.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.jobDAO;
import com.db.DBconnect;
import com.entity.jobs;
@WebServlet("/add_job")
public class AddPostServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String Title=req.getParameter("add_job_title");
		String Location=req.getParameter("add_job_location");
		String Category=req.getParameter("add_job_category");
		String Status=req.getParameter("add_job_status");
		String Discription=req.getParameter("disc");
		jobs j= new jobs();
		j.setTitle(Title);
		j.setLocation(Location);
		j.setCategory(Category);
		j.setStatus(Status);
		j.setDescription(Discription);
		HttpSession hs =req.getSession();
		jobDAO jd = new jobDAO(DBconnect.getcon());
		boolean f=jd.addjob(j);
		if(f) {
			
			hs.setAttribute("succMsg", "job post succesfull..");
			resp.sendRedirect("add_job.jsp");
		}
		else {
			hs.setAttribute("succMsg", "somthing worng on server");
			resp.sendRedirect("add_job.jsp");
		}
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
		
}
