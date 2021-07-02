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
<title>새 글 등록</title>
</head>
<body>
<h3>새 글 등록</h3>
<form action="/board/doEditPost.do" method="post">
	<div>제목</div>
	<div><input type="text" value="<%=CmmUtil.nvl(rDTO.getPosttitle()) %>" name="post_title" style="width:500px; " required></div>
	<br>
	<div>내용</div>
	<div><textarea name="post_content" required style="width:500px;height:500px"><%=CmmUtil.nvl(rDTO.getPostcontent()) %></textarea></div>
	<input name="post_no" value="<%=CmmUtil.nvl(rDTO.getPostno())%>"hidden="hidden">
	<div><input type="submit" value="편집"></div>
</form>	
</body>
</html>