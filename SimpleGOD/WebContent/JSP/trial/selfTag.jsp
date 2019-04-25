<%@ page language="java"  pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.simpleGOD.com/selfTag" prefix="selfTag" %>
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
	使用标签版：
	<selfTag:ShowRemoteIp/>
</body>
</html>