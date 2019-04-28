<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.simpleGOD.com/selfTag" prefix="selfTag" %>
<%@ taglib uri="http://www.simpleGOD.com/selfSimpleTag" prefix="selfSimpleTag" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>自定义标签</title>
</head>
<body>
	客户机IP地址：
	<!--实际开发不应出现Java脚本  -->
	<%
		String remoteIp = request.getRemoteAddr();
		out.write(remoteIp);
	%>
	<br/>
	使用标签版客户机IP地址：
	<selfTag:ShowRemoteIp/>
	<br/>
	使用简单标签版客户机IP地址：
	<selfSimpleTag:ShowRemoteIpS/>
	<br/>
</body>
</html>