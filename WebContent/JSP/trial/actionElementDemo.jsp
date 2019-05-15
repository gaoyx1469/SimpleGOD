<%@ page language="java" import="java.util.Date" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>show JSP action element</title>
</head>
<body>
	-----------------------------------jsp:useBean-----------------------------------<br>
	<jsp:useBean id="player01" class="top.trial.demo.entity.PlayerEntity" scope="session">
		first in player01 session
	</jsp:useBean>
	<br>
	<% player01.setLevel(1); %>
	<%=player01.getLevel() %>
	<br>-----------------------------------jsp:setProperty&&jsp:getProperty-----------------------------------<br>
	<!-- /JSP/trial/actionElementDemo.jsp?level=3 -->
	<jsp:useBean id="player02" class="top.trial.demo.entity.PlayerEntity" scope="application">
		first in player02 application
	</jsp:useBean>
	<br>
	<jsp:setProperty property="name" name="player02" value="haha"/>
	<jsp:setProperty property="age" name="player02" value="18"/>
	<jsp:setProperty property="level" name="player02" param="level"/>
	<jsp:setProperty property="birthday" name="player02" value="<%=new Date(2001,10,1) %>"/>
	<jsp:getProperty property="name" name="player02"/><br>
	<jsp:getProperty property="age" name="player02"/><br>
	<jsp:getProperty property="level" name="player02"/><br>
	<jsp:getProperty property="birthday" name="player02"/><br>
	<br>------------------------------------------------------------------------------------------------------<br>
	<!-- /JSP/trial/actionElementDemo.jsp?level=2&name=momo&age=15 -->
	<jsp:useBean id="player03" class="top.trial.demo.entity.PlayerEntity" scope="page">
		first in player03 page
	</jsp:useBean>
	<br>
	<jsp:setProperty property="*" name="player03"/>
	<jsp:getProperty property="name" name="player03"/><br>
	<jsp:getProperty property="age" name="player03"/><br>
	<jsp:getProperty property="level" name="player03"/><br>
	<jsp:getProperty property="birthday" name="player03"/><br>
</body>
</html>