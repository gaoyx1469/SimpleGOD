<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>input</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/strutsDemo/strutsConversionAction" method="post">
		<label>名称：</label><input type="text" name="name"/><br/>
		<label>生日：</label><input type="text" name="birthday"/><br/>
		<label>爱好：</label><input type="checkbox" value="吃饭" name="hobby"/><label>吃饭</label>
							<input type="checkbox" value="睡觉" name="hobby"/><label>睡觉</label>
							<input type="checkbox" value="打豆豆" name="hobby"/><label>打豆豆</label><br/>
		<label>省：</label><input type="text" name="address.province"/><br/>
		<label>市：</label><input type="text" name="address.city"/><br/>
		<input type="submit" value="go"/>
	</form>
</body>
</html>