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
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>

</c:if>
	<form action="update" method="post">
		
		<div style="margin-left: 15%; border-radius: 10px; margin-right: 15%;"
			class="addjobmain">
			<div
				style="border: 2px solid black; padding-bottom: 5%; padding-left: 10%; padding-right: 10%; padding-top: 6%;"
				class="overview ">
				<div class="listall">


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

					<h5>Enter Title :</h5>
					<input style="width: 80%" type="text" name="add_job_title"
						value="<%=j.getTitle()%>" class="title">
					<div class="three"
						style="height: 6rem; display: flex; justify-content: center; align-items: center; margin-left: -32px;">
						<h5>Enter Location :</h5>
						<br> <input type="text" value="<%=j.getLocation()%>"
							name="add_job_location" class="location">
						<h5>Enter Category :</h5>
						<br> <input type="text" value="<%=j.getCategory()%>"
							name="add_job_category" class="category">
						<h5>Status :</h5>
						<br> <input type="text" value="<%=j.getStatus()%>"
							class="status" name="add_job_status">
					</div>
					<h5>Enter Discription :</h5>
					<input style="padding-bottom: 25%; width: 80%;" type="text"
						name="disc" value="<%=j.getDescription()%>" class="discription">
					<button type="submit" class="jobsubmit">Update Job</button>
				</div>

			</div>

		</div>
	</form>
</body>
</html>