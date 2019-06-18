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
		xmlHttp.open("GET", "http://127.0.0.1:8080/SimpleGOD/AjaxDemoServlet", true);
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
		xmlHttp.open("POST", "http://127.0.0.1:8080/SimpleGOD/AjaxDemoServlet", true);
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
		xmlHttp.open("POST", "http://127.0.0.1:8080/SimpleGOD/AjaxDemoXmlServlet", true);
		//指定Content-Type
		xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//调用send方法
		xmlHttp.send("username=小李子&psw=asdf");
		//得到返回并展示
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var doc = xmlHttp.responseXML;//返回的是document对象
				var j = document.getElementById("j");
				
				var tiny = doc.getElementsByTagName("tiny")[0];
				var om0 = tiny.getElementsByTagName("om")[0];
				var omid0 = om0.getAttribute("id");//1
				var om1 = tiny.getElementsByTagName("om")[1];
				var omid1 = om1.getAttribute("id");//2
				
				var name0 = om0.getElementsByTagName("name")[0].textContent;//mane
				var value0 = om0.getElementsByTagName("value")[0].textContent;//25
				
				var name1 = om1.getElementsByTagName("name")[0].textContent;//luma
				var value1 = om1.getElementsByTagName("value")[0].textContent;//28
				
				var show = omid0+":"+name0+"--"+value0+"||||||"+omid1+":"+name1+"--"+value1;
				j.innerHTML = show;
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