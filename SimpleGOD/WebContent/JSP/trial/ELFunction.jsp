<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="md5util" uri="http://www.simpleGOD.com/md5"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EL Function</title>
</head>
<body>
	<%
		pageContext.setAttribute("H", "0");
	%>
	${H}
	${md5util:md5(H)}
</body>
</html>