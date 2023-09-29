<%@page import="java.util.ArrayList"%>
<%@page import="com.mysql.cj.xdevapi.DbDoc"%>
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

<title>Edit Profile</title>
</head>
<body style="background-color: #f0f1f2">
	<c:if test="${empty userobj }">
		<c:redirect url="login.jsp"></c:redirect>

	</c:if>
	<%@include file="allmatreal/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-4">
			<div class="col-md-4 offset-md-4">
				<div class="card">
					<div class="card-body">
						<div class="text-center">
							<i class="fa fa-user-plus fa-2x" aria-hidden="true"></i>
							<h5>Edit Profile</h5>

						</div>
						<form action="update_profile" method="post">

							<input type="hidden" name="id" value="${userobj.id }">
							<div class="form-group">
								<label>Enter Full Name</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="name" value="${userobj.name }">

							</div>
							<div class="form-group">
								<label>Enter Qualification</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="qua"
									value="${userobj.qualification }">

							</div>

							<div class="form-group">
								<label>Enter Email</label> <input type="text"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp"
									name="email" value="${userobj.email }">

							</div>

							<div class="form-group">
								<label>Enter Password</label> <input type="password"
									required="required" class="form-control"
									id="exampleInputEmail1" aria-describedby="emailHelp" name="ps"
									value="${userobj.password }">

							</div>
							<button type="submit"
								class="btn btn-primary badge-pill btn-block">Update</button>




						</form>

					</div>
				</div>


			</div>

		</div>
	</div>
<div style="margin-top: 50px;">
<%@include file="allmatreal/footer.jsp" %>
</div>

</body>
</html>