<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">其他页面</h1>
	<hr/>
	<c:if test="${sessionScope.user == null}">
		<a href="${pageContext.request.contextPath }/JSP/autoLogin/login.jsp">登录</a>
	</c:if>
	<br/>
	<c:if test="${sessionScope.user != null}">
		欢迎你：${sessionScope.user.nickname}
	</c:if>
	
	<a href="${pageContext.request.contextPath }/JSP/autoLogin/autoMain.jsp">主页</a>
</body>
</html>