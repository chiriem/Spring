<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	table, th, td{
		border : 1px solid black;
	}
</style>
</head>
<body>
<table border='1'>
	<%for (int i = 0; i < 3; i++){%>
	<tr>
		<%for (int j=0; j < 4; j++){ %>
		<td>
		<%=i %>행 <%=j %>열
		</td>
		<%} %>
	</tr>
	<%} %>
</table>
</body>
</html>