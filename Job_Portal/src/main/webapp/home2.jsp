<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page isELIgnored="false"%>
<%@page import="com.entity.jobs"%>
<%@ page language="java"%>
<%@ page import="java.util.List"%>
<%@ page import="java.sql.Connection"%>
<%@page import="com.dao.jobDAO"%>
<%@page import="com.db.DBconnect"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="allmatreal/allcss.jsp"%>

<title>User : View Job</title>
</head>
<body>
  <%@include file="allmatreal/navbar.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5 class="text-center text-primary">All Jobs</h5>
				
				
			<%-- 	<c:if test="${not empty succMsg}">

					<h4 class="text-center text-danger"> ${succMsg}</h4>
					<c:remove var="succMsg" />

				</c:if> --%>
				
				<div class="card">
					<div class="card-body">
					<form class="form-inline" action="more_view.jsp" method="get">
					
					<div class="form-group col-md-5 mt-1">
								<h5>Location</h5>
							</div>

							<div class="form-group col-md-4 mt-1">
								<h5>Category</h5>
							</div>
							
							
							
							<div class="form-group col-md-5">
								<select name="loc" class="custom-select"
									id="inlineFormCustomSelectPref">
									<option selected value="lo">choose...</option>
									<option value="Odisa">Odisa</option>
									<option value="Banglore">Banglore</option>
									<option value="Delhi">Delhi</option>
									<option value="Noida">Noida</option>
									<option value="Pune">Pune</option>
									<option value="Jhansi">Jhansi</option>
									<option value="Hydrabaad">Hydrabaad</option>
									<option value="Gudgao">Gudgao</option>

								</select>
							</div>

							<div class="form-group col-md-5">
								<select class="custom-select" id="inlineFormCustomSelectPref"
								 name="cat">
									<option value="ca" selected>choose...</option>
									<option value="IT">IT</option>
									<option value="Devloper">Devloper</option>
									<option value="Banking">Banking</option>
									<option value="Enginer">Enginer</option>
									<option value="Teacher">Teacher</option>
								</select>
							</div>
							<button class="btn btn-success">Submit</button>
					
					
					
					
					
					
					
					</form>

		
	

					</div>

				</div>

				<%
				jobDAO dao = new jobDAO(DBconnect.getcon());
				List<jobs> list = dao.getAlljobsForUser();
				for (jobs j : list) {
				%>

				<div class="card mt-2">
					<div class="card-body">
						<div class="text-center text-primary">
							<i class="fa fa-clipboard fa-2x"></i>
						</div>
						<h6><%=j.getTitle()%></h6>
						<%
						if (j.getDescription().length() > 0 && j.getDescription().length() < 120) {
						%>
						<p><%=j.getDescription()%></p>
						<%
						} else {
						%>
						<p><%=j.getDescription().substring(0, 120)%>...
						</p>
						<%
						}
						%>
						<br>
						<div class="form-row">
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Location : <%=j.getLocation()%>" readonly>
							</div>
							<div class="form-group col-md-3">
								<input type="text" class="form-control form-control-sm"
									value="Category : <%=j.getCategory()%>" readonly>
							</div>
						</div>
						<h6>
							Publish Date :
							<%=j.getPdate().toString()%></h6>
						<div class="text-center">
							<a href="one_view.jsp?id=<%=j.getId()%>"
								class="btn btn-sm bg-success text-white">View More</a>
						</div>
					</div>

				</div>

				<%
				;
				}
				%>



			</div>
		</div>
	</div>

</body>
</html>