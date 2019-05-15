<%@ page language="java" import="top.trial.demo.entity.PlayerEntity" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EL隐式对象演示</title>
</head>
<body>
	<br/>--------------------------pageContext--------------------------<br/>
	${pageContext }<br/>
	${pageContext.request }<br/>
	${pageContext.request.contextPath }<br/>
	<br/>--------------------------pageScope--------------------------<br/>
	<%
		pageContext.setAttribute("haha", "hahaPage");
		PlayerEntity player1 = new PlayerEntity();
		player1.setAge(18);
		player1.setName("oh~~~");
		pageContext.setAttribute("player", player1);
	%>
	${pageScope.haha }<br/>
	${pageScope.player.name }
	<br/>--------------------------requestScope--------------------------<br/>
	<%
		pageContext.setAttribute("haha", "hahaRequest",PageContext.REQUEST_SCOPE);
	%>
	${requestScope.haha }
	<br/>--------------------------param/paramValues--------------------------<br/>
	${param.cc }<br/>
	${paramValues.cc[1] }
	<br/>--------------------------header/headerValues--------------------------<br/>
	${header }<br/>
	${header["host"]}
	<br/>--------------------------cookie--------------------------<br/>
	${cookie }<br/>
	${cookie["JSESSIONID"].name }<br/>
	${cookie.JSESSIONID.value }
	<br/>--------------------------initParam--------------------------<br/>
	${initParam }
</body>
</html>