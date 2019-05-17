<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>输入</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/CharacterShowServlet" method="post">
		输入<input type="text" name="value">
		<input type="submit" value="看一看">
	</form>
</body>
</html>