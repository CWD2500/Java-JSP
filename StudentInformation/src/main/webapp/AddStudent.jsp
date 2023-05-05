<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="content-type" content = "text/html">
<link  href="css/bootstrap.min.css"  rel="stylesheet">
<title>Add Student </title>

</head>
<body>


<jsp:include page="studentForm.html"></jsp:include>


<%@page import="com.Christiane.StudentDao" %>
<jsp:useBean id="s" class="com.Christiane.Student" ></jsp:useBean>
<jsp:setProperty property="*" name="s"/>


<%
int num = StudentDao.save(s); 

if(num > 0 ){
	response.sendRedirect("studentAdded.jsp");
}else{
	response.sendRedirect("studentfailed.jsp");
}
%>



<script src="js/bootstrap.min.js"></script>
</body>
</html>