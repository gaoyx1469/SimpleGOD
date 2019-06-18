<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ajax演示</title>
<script type="text/javascript">
	function cliGet() {
		//点击了按钮
		//获取XMLHttpRequest对象
		var xmlHttp = getXMLHttpRequest();
		//调用open方法
		xmlHttp.open("GET", "http://localhost:8080/SimpleGOD/AjaxDemoServlet", true);
		//调用send方法
		xmlHttp.send(null);
		//得到返回并展示
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var msg = xmlHttp.responseText;
				var h = document.getElementById("h");
				h.innerHTML = msg;
			}
		}
	}
	function cliPost() {
		//点击了按钮
		//获取XMLHttpRequest对象
		var xmlHttp = getXMLHttpRequest();
		//调用open方法
		xmlHttp.open("POST", "http://localhost:8080/SimpleGOD/AjaxDemoServlet", true);
		//指定Content-Type
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//调用send方法
		xmlHttp.send("username=小李子&psw=asdf");
		//得到返回并展示
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var msg = xmlHttp.responseText;
				var i = document.getElementById("i");
				i.innerHTML = msg;
			}
		}
	}
	function cliXml() {
		//点击了按钮
		//获取XMLHttpRequest对象
		var xmlHttp = getXMLHttpRequest();
		//调用open方法
		xmlHttp.open("POST", "http://localhost:8080/SimpleGOD/AjaxXMLDemoServlet", true);
		//指定Content-Type
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//调用send方法
		xmlHttp.send("username=小李子&psw=asdf");
		//得到返回并展示
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var msg = xmlHttp.responseText;
				var i = document.getElementById("i");
				i.innerHTML = msg;
			}
		}
	}
	function getXMLHttpRequest() {
		try {
			return new XMLHttpRequest();
		} catch (e) {
			try {
				return ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					return ActiveXObject("Microsoft.XMLHTTP");
				} catch (e) {
					throw e;
				}
			}
		}
	}
</script>
</head>
<body>
	<input type="button" onclick="cliGet();" value="GET方式AJAX文本数据">
	<h2 id="h"></h2>
	<input type="button" onclick="cliPost();" value="POST方式AJAX文本数据">
	<h2 id="i"></h2>
	<input type="button" onclick="cliXml();" value="POST方式AJAX XML数据">
	<h2 id="j"></h2>
</body>
</html>