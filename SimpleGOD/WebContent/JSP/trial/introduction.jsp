<%@page import="java.util.Date"%>
<%@page language="java" pageEncoding="UTF-8"%>
<%@page errorPage="../errorPage/jspError.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>introduction of JSP</title>
</head>
<body>
	<h1>
		当前日期是：
		<%
		Date d = new Date();
		%>
		<%=d.toLocaleString()%>
	</h1>
	<div>
		<%
			out.write("a");
			//out.flush();
			response.getWriter().write("b");
		%>
	</div>
</body>
</html>