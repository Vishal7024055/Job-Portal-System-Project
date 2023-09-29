<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<%@ page isELIgnored="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="allmatreal/allcss.jsp" %>
<meta charset="UTF-8">
<title>admin</title>
</head>
<body>
<%@include file="allmatreal/navbar.jsp" %>
<body>
<c:if test="${userobj.role ne 'admin' }">
<c:redirect url="login.jsp"></c:redirect>

</c:if>
	<div class="admin-main">
		<div class="text-admin">
			<h1><i class="fas fa-book"></i>Welcome Admin</h1>
		</div>
	</div>

</body>
</html>