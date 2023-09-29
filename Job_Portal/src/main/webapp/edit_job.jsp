<%@page import="com.db.DBconnect"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<%@page import="com.dao.jobDAO"%>
<%@page import="com.servlet.AddPostServlet"%>
<%@page import="com.entity.jobs"%>
<%@page import="com.entity.user"%>
<%@page import="com.servlet.LoginServlet"%>
<%@page import="javax.servlet.http.*"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="allmatreal/allcss.jsp"%>
<title>Edit Job</title>
</head>
<body>
	<%@include file="allmatreal/navbar.jsp"%>

	<div class="container p-2">
		<div class="col-md-10 offset-md-1">
			<div class="card">

				<div class="card-body">
					<div class="text-center text-success">
						<i class="fas fa-user-friends fa-3x"></i>
						<c:if test="${not empty succMsg}">
							<div class="alert alert-success" role="alert">${ succMsg}</div>
							<c:remove var="succMsg" />

						</c:if>
						<h5>Edit Job</h5>
						
						
						
					</div>
				<form action="update" method="post">
				
				
				<%
					int id = Integer.parseInt(request.getParameter("id"));
					jobDAO dao = new jobDAO(DBconnect.getcon());

					jobs j = dao.getJobById(id);
					%>
						<c:if test="${not empty succMsg}">

						<div class="alert alert-success" role="alert">${ succMsg}</div>
						<c:remove var="succMsg" />

					</c:if>
					<input type="hidden" value="<%=j.getId()%>" name="id">
						<div class="form-group">
							<label>Enter Title:</label> <input type="text"
								name="add_job_title" value="<%=j.getTitle()%>" required class="form-control">

						</div>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label>Location:</label> <select name="add_job_location"
									class="custom-select"  id="inlineFormCustomSelectPref">
									<option value="<%=j.getLocation()%>"><%=j.getLocation()%></option>
									<option value="Noida">Noida</option>
									<option value="Pune">Pune</option>
									<option value="Mumbai">Mumbai</option>
									<option value="Banglore">Banglore</option>
									<option value="Indore">Indore</option>
									<option value="Delhi">Delhi</option>

								</select>

							</div>

							<div class="form-group col-md-4">
								<label>Category:</label> <select name="add_job_category"
									class="custom-select"  id="inlineFormCustomSelectPref">
									<option value="<%=j.getCategory()%>"><%=j.getCategory()%></option>
									<option value="IT">IT</option>
									<option value="Developer">Developer</option>
									<option value="Banking">Banking</option>
									<option value="Sales">Sales</option>
									<option value="Other">Other</option>

								</select>

							</div>


							<div class="form-group col-md-4">
								<label>Status:</label> <select name="add_job_status"
									class="custom-select" >
									<option value="<%=j.getStatus()%>"><%=j.getStatus()%></option>
									<option value="Active">Active</option>
									<option value="Inactive">Inactive</option>

								</select>

							</div>


						</div>
						<div class="form-group">
							<label>Enter Description:</label>
							<textarea required rows="6" cols="" name="disc"
								class="form-control" ><%=j.getDescription()%></textarea>
						</div>
						<button class="btn btn-success" name="">Publish Job</button>


					</form>


				</div>

			</div>


		</div>

	</div>


</body>
</html>
