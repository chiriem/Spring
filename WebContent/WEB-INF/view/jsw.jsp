<%@page import="poly.util.CmmUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String nicName = CmmUtil.nvl((String)request.getAttribute("nicName"));
    %>
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
<h1>나의 닉네임은 : <%=nicName%></h1>

<%for (int i = 0; i<5; i++){
	if (i%2 == 0){%>
		
	<p><%=i+1 %>번째 줄입니다.</p>
	<% }
	} %>
<br>
와! 와! 와! JSW!
</body>
</html>