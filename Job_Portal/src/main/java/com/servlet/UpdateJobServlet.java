package com.servlet;
import com.dao.jobDAO;
import com.db.DBconnect;
import com.entity.jobs;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/update")
public class UpdateJobServlet extends HttpServlet {
	@Override

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String Title = req.getParameter("add_job_title");
			String Location = req.getParameter("add_job_location");
			String Category = req.getParameter("add_job_category");
			String Status = req.getParameter("add_job_status");
			String Discription = req.getParameter("disc");

			jobs j = new jobs();
			j.setId(id);
			j.setTitle(Title);
			j.setLocation(Location);
			j.setCategory(Category);
			j.setStatus(Status);
			j.setDescription(Discription);
			HttpSession session = req.getSession();
			jobDAO dao = new jobDAO(DBconnect.getcon());
			boolean f = dao.updateJob(j);
			if (f) {

				session.setAttribute("succMsg", "job Update succesfull..");
				resp.sendRedirect("viewjob.jsp");
			} else {
				session.setAttribute("succMsg", "somthing worng on server");
				resp.sendRedirect("viewjob.jsp");
			}

		} catch (IOException | NumberFormatException ex) {
		}

	}

}