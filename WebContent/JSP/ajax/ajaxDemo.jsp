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
		xmlHttp.setRequestHeader("Content-Type",
				"application/x-www-form-urlencoded");
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
		xmlHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
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

				var show = omid0 + ":" + name0 + "--" + value0 + "||||||" + omid1 + ":" + name1 + "--" + value1;
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

	function getProvince() {

		//获取XMLHttpRequest对象
		var xmlHttp = getXMLHttpRequest();
		//open
		xmlHttp.open("GET", "http://127.0.0.1:8080/SimpleGOD/AjaxDemoLinkageServlet", true);
		//send
		xmlHttp.send(null);
		//获取返回
		xmlHttp.onreadystatechange = function() {
			if (xmlHttp.readyState == 4 && xmlHttp.status == 200) {
				var provinceElement = document.getElementById("province");
				var provinces = xmlHttp.responseText.split("|");
				for (var i = 0; i < provinces.length - 1; i++) {
					//拿到所有的省名

					//创建option元素
					var provinceOp = document.createElement("option");
					//为option元素添加value属性
					provinceOp.value = provinces[i];
					//创建文本元素并为文本元素添加值
					var provinceText = document.createTextNode(provinces[i]);
					//将文本元素加挂为option的子元素
					provinceOp.appendChild(provinceText);
					//将option加挂为province的子元素
					provinceElement.appendChild(provinceOp);
				}
			}
		}

	}

	window.onload = function() {
		
		//获取省的下拉框信息
		getProvince();
		var provinceSelect = document.getElementById("province");
		
		//为省的下拉框注册监听器
		provinceSelect.onchange = function() {
			var selectProvince = document.getElementById("province").value;
			if (selectProvince.substr(0, 1) != '-') {//选择了除第一行外的其余选项
				//创建xmlHttp
				var xmlHttpCity = getXMLHttpRequest();
				//open
				xmlHttpCity.open("POST", "http://127.0.0.1:8080/SimpleGOD/AjaxDemoLinkageServlet", true);
				//指定Content-Type
				xmlHttpCity.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
				//send
				xmlHttpCity.send("province=" + selectProvince);
				//获取返回
				xmlHttpCity.onreadystatechange = function() {
					if (xmlHttpCity.readyState == 4
							&& xmlHttpCity.status == 200) {
						//拿到所选的province的dom对象的city元素数组
						var citys = xmlHttpCity.responseXML.getElementsByTagName("city");

						var cityEle = document.getElementById("city");

						//删除不是---请选择---的option
						var citysOld = cityEle.getElementsByTagName("option");
						while (citysOld.length > 1) {
							cityEle.removeChild(citysOld[1]);
						}

						//添加返回的option
						for (var x = 0; x < citys.length; x++) {
							var cityName = citys[x].textContent;

							//创建option,加挂到select上
							var cityOption = document.createElement("option");
							cityOption.value = cityName;
							var cityText = document.createTextNode(cityName);
							cityOption.appendChild(cityText);
							cityEle.appendChild(cityOption);
						}
					}
				}
			}else{
				var cityEle = document.getElementById("city");
				//删除不是---请选择---的option
				var citysOld = cityEle.getElementsByTagName("option");
				while (citysOld.length > 1) {
					cityEle.removeChild(citysOld[1]);
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
	<select id="province" name="province">
		<option>----请选择省----</option>
	</select>
	<br />
	<br />
	<br />
	<select id="city" name="city">
		<option>----请选择市----</option>
	</select>
</body>
</html>