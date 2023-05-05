<%@page import="java.awt.print.Printable"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Name Page </h1>

<%
// String name = (String)	session.getAttribute("MyName");
String name = (String)pageContext.getAttribute("MyName");
out.print( "My Name  Page name "  + name);
%>

<%@ page isErrorPage='true'%>
Sorry 404 page<br/>
Date:<%=new java.util.Date() %>
<br/>
<%= exception %>



<%@ includefile ='index.html'%>
<!-- Hello Christiane Include html 

<!--  ترشرش لاهىس تعريغ ال -->

<jsp:useBean id="vBean" class ="valuesBin"/>

<% int num = vBean.sum(20);
out.print("the result" + num); 
%>
	
</body>
</html>