<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>文件上传演示</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/FileUploadDemoServlet" method="post" enctype="multipart/form-data">
		<input type="text" name="test">
		<input type="file" name="f1">
		<input type="file" name="f2">
		<input type="submit" value="提交">
	</form>
</body>
</html>