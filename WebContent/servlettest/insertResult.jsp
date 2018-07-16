<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html">
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h2>jsp로 불리된 응답화면</h2>
	<hr/>
	<% String msg = (String) request.getAttribute("msg"); %>
	<h3><%=msg %></h3>
</body>
</html>