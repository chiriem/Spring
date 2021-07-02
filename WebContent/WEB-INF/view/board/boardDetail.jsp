<%@page import="poly.dto.BoardDTO" %>
<%@page import="poly.util.CmmUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardDTO rDTO = (BoardDTO)request.getAttribute("rDTO");    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=CmmUtil.nvl(rDTO.getPosttitle()) %></title>
</head>
<body>
<div style="width:800px;">
	<h4><%=CmmUtil.nvl(rDTO.getPosttitle()) %></h4>
	
	<hr>
	<div style="text-align:right;">작성자 : <%=CmmUtil.nvl(rDTO.getRegid()) %></div>
	<div>
		<p><%=CmmUtil.nvl(rDTO.getPostcontent()) %></p>
	</div>
	<hr>
	<div style="float:left;">
		<button onclick="location.href='/board/boardList.do'">뒤로</button>
	</div>
	<div style="float:right;">
		<button onclick="location.href='/board/editPost.do?no=<%=rDTO.getPostno()%>'">편집</button>
	</div>
	<div style="float:right;">
		<button onclick="location.href='/board/deletePost.do?no=<%=rDTO.getPostno()%>'">삭제</button>
	</div>
</div>
</body>
</html>