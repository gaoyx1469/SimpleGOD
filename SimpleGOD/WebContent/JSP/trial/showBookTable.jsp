<%@ page language="java"
	import="top.trial.demo.entity.BookEntity,java.util.Map"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<div>
		<table border="1px" width="88%">
			<tr>
				<th>书名</th>
				<th>作者</th>
				<th>价格</th>
				<th>描述</th>
			</tr>
			<%
				Map<String, BookEntity> books = (Map<String, BookEntity>) request.getAttribute("books");
				for (Map.Entry<String, BookEntity> me : books.entrySet()) {
					BookEntity book = me.getValue();
			%>
			<tr>
				<td><%=book.getBookName()%></td>
				<td><%=book.getBookAuther()%></td>
				<td><%=book.getPrice()%></td>
				<td><%=book.getDiscription()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>
</body>
</html>