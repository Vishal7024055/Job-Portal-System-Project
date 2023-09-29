<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="allmatreal/allcss.jsp"%>

<title>Login</title>
</head>
<body>
<%@include file="allmatreal/navbar.jsp"%>
	<form action="login" method="post">
		
	<div class="box" style="padding-top: 25PX;">
		<div class="logomini">
			<h5 style="margin-left: 105px">
				<i class="fas fa-user-plus"></i>
			</h5>
			<h5 style="margin-left: 65px">LOGIN PAGE</h5>
				<c:if test="${not empty succMsg }">
				<h6 class="text-center text-danger">${succMsg}</h6>
				<c:remove var="succMsg"/>
				</c:if>
		
			
				
				<h5>Username :</h5>
				<input type="text" placeholder="Enter Email" class="user_email"
					name="email">
				<h5>Password :</h5>
				<input type="password" placeholder="Enter Password" class="password"
					name="pass"><br>
				<br>
				<button type="submit" class="submit">Submit</button>
			

		</div>

	</div>
	</form>


</body>
</html>