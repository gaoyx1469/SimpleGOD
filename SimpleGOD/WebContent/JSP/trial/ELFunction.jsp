<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="md5util" uri="http://www.simpleGOD.com/md5"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>EL Function</title>
</head>
<body>
	<br />----------------自定义EL函数----------------
	<br />
	<%
		pageContext.setAttribute("H", "0");
	%>
	${H} ${md5util:md5(H)}
	<br />----------------标准EL函数库之fn----------------
	<br /> ${fn:contains("Tomcat","cat") }
	<br /> ${fn:indexOf("Tomcat","cat") }
	<br /> ${fn:substring("Tomcat",3,1000) }
	<br /> ${fn:split("2019-03/17","-/") }
	<br />----------------标准EL函数库之c:if----------------
	<br />
	<c:if test="${1==2 }">1==2</c:if>
	<c:if test="${1==1 }">1==1</c:if>
	<br />
	<%
		List list = new ArrayList();
		session.setAttribute("cart", list);
	%>
	<c:if test="${empty sessionScope.cart }" var="cartBoolean" scope="page">cart空的</c:if>
	<br />${cartBoolean } -_-`
	<c:if test="${!empty sessionScope.cart }">cart有东西</c:if>
	<br />
	<br />----------------标准EL函数库之c:forEach----------------
	<%
		list.add("s");
		list.add("ss");
		list.add("sss");
	%>
	<br />
	<c:forEach items="${sessionScope.cart}" var="str">
		${str }<br/>
	</c:forEach>
</body>
</html>