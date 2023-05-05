<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Calendar"%>
<html>

<body>

<%
//String name =request.getParameter("firstname");
//String lname=request.getParameter(arg0)

//out.print("What Your Name :  "+ name );
// Script let  هاد طريق ال

%>
<!-- لم  نستخدم ال يسااوي  Excprtions    هي طريقى ال -->

<%= "Christiane" %>
<%= Calendar.getInstance().getTime() %>

<%= "What Your Name :"+request.getParameter("firstname")   %>

<!-- ------------------------------------- -->
<!--  Declaration  طريقة  ال    -->

<%! String userName = "Christiane ";
	int number = 1;
	
int sum(int num )
{
	return  num * 3;
}
// excprtions and declaration    نستطيع الدمج بين ال 
%>
<%= "\n This is result : " + sum(2)  %>




<%

// Out : // Servlet :	PrintWriter write  = response.getWriter()
// Out :  //JSP   out.print("Hello JSP :>")
// -------------

// Reqeust : 
	String name  = request.getParameter("firstname");
	out.print(name);
// -----------------

// Response :
//	response.sendRedirect("https://www.yahoo.com");
//-------------------
// Session 

session.setAttribute("MyName" , name);
//---------------

// Page Context
 pageContext.setAttribute("Myname", name ,PageContext.SESSION_SCOPE);

%>

<a  href="name.jsp"> Name Page </a>



</body>
</html>