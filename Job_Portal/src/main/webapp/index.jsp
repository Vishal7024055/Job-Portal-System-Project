<%@page import="com.db.DBconnect"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css"></style>
<title>Job</title>
<%@include file="allmatreal/allcss.jsp"%>
<%@include file="allmatreal/navbar.jsp"%>

</head>
<body>

<%@include file="allmatreal/carousel.jsp" %>
<h1 class="text-center mb-6" style="line-height: 90px">Explore By Category</h1>
<%@include file="allmatreal/category.jsp" %>
<h1 class="text-center mb-5">Our Clients Say!!!</h1>
<%@include file="allmatreal/Testimonial.jsp" %>
<br>
<%@include file="allmatreal/footer.jsp" %>


</body>
</html>
